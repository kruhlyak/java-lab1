/**
 * Holds statistical data for attack power of chthonic creatures.
 */
public record StatisticsData(
    int minAttackPower,
    int maxAttackPower,
    double avgAttackPower,
    double stdDeviation) {
}