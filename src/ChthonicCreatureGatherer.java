import java.util.Optional;
import java.util.stream.Gatherer;

/**
 * A custom gatherer that skips a specified number of creatures of a given type.
 */
class ChthonicCreatureGatherer implements
    Gatherer<ChthonicCreature, Optional<ChthonicCreature>, ChthonicCreature> {

  private int skipCount;
  private final String skipType;

  public ChthonicCreatureGatherer(int skipCount, String skipType) {
    this.skipCount = skipCount;
    this.skipType = skipType;
  }

  @Override
  public Integrator<Optional<ChthonicCreature>, ChthonicCreature, ChthonicCreature> integrator() {
    return Gatherer.Integrator.of((_, element, downstream) -> {
      if (element.getType().equals(skipType) && skipCount > 0) {
        skipCount--;
        return true;
      }
      return downstream.push(element);
    });
  }
}
