import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for analyzing attack power and identifying outliers.
 */
public class PowerAnalysisIQR {

  public static Map<String, Long> analyzeAttackPower(List<ChthonicCreature> creatures) {
    List<Integer> attackPowers = creatures.stream()
        .map(ChthonicCreature::getAttackPower)
        .sorted()
        .toList();
    int Q1 = attackPowers.get((int) Math.ceil(0.25 * attackPowers.size()) - 1);
    int Q3 = attackPowers.get((int) Math.ceil(0.75 * attackPowers.size()) - 1);
    int IQR = Q3 - Q1;
    Map<Boolean, Long> result = creatures.stream()
        .collect(Collectors.partitioningBy(
            creature ->
                creature.getAttackPower() >= Q1 - 1.5 * IQR &&
                creature.getAttackPower() <= Q3 + 1.5 * IQR,
            Collectors.counting()
        ));
    Map<String, Long> finalResult = new HashMap<>();
    finalResult.put("data", result.get(true));
    finalResult.put("outliers", result.get(false));
    return finalResult;
  }
}
