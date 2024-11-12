import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Generates random ChthonicCreature objects using Stream API.
 */
public class ChthonicCreatureGenerator {

  private static final String[] NAMES = {"Cerberus", "Medusa", "Basilisk", "Hydra", "Kraken"};
  private static final String[] TYPES = {"Beast", "Spirit", "Demon", "Giant"};
  private static final Random RANDOM = new Random();

  public static Stream<ChthonicCreature> generateCreatures() {
    return Stream.generate(() -> {
      ChthonicCreature creature = new ChthonicCreature();
      creature.setName(getRandomName());
      creature.setType(getRandomType());
      creature.setFirstMentionDate(LocalDate.now().minusYears(RANDOM.nextInt(2000)));
      creature.setAttackPower(100 + RANDOM.nextInt(900));
      return creature;
    });
  }

  private static String getRandomName() {
    return NAMES[RANDOM.nextInt(NAMES.length)];
  }

  private static String getRandomType() {
    return TYPES[RANDOM.nextInt(TYPES.length)];
  }
}
