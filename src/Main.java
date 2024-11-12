import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main class that demonstrates filtering, grouping, statistical analysis,
 * and power analysis of a list of ChthonicCreature objects.
 */
public class Main {

  public static void main(String[] args) {
    int N = 5;
    String typeToSkip = "Demon";

    List<ChthonicCreature> creatures = ChthonicCreatureGenerator.generateCreatures()
        .gather(new ChthonicCreatureGatherer(N, typeToSkip))
        .limit(500)
        .collect(Collectors.toList());
    for (ChthonicCreature creature : creatures) {
      System.out.println(creature);
    }

    Map<String, List<ChthonicCreature>> groupedCreatures = creatures.stream()
        .filter(creature -> creature.getFirstMentionDate().isAfter(LocalDate.now().minusYears(100)))
        .collect(Collectors.groupingBy(ChthonicCreature::getType));
    for (Map.Entry<String, List<ChthonicCreature>> entry : groupedCreatures.entrySet()) {
      System.out.println("Кількість '" + entry.getKey() + "': " + entry.getValue().size());
    }

    StatisticsData statistics = creatures.stream()
        .collect(new ChthonicCreatureStatisticsCollector());
    System.out.println(statistics);

    Map<String, Long> powerAnalysis = PowerAnalysisIQR.analyzeAttackPower(creatures);
    System.out.println(powerAnalysis);
  }
}
