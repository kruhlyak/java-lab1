import java.time.LocalDate;

/**
 * Represents a chthonic creature with name, type, first mention date in literature, and attack power.
 */
public class ChthonicCreature {

  private String name;
  private String type;
  private LocalDate firstMentionDate;
  private int attackPower;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public LocalDate getFirstMentionDate() {
    return firstMentionDate;
  }

  public void setFirstMentionDate(LocalDate firstMentionDate) {
    this.firstMentionDate = firstMentionDate;
  }

  public int getAttackPower() {
    return attackPower;
  }

  public void setAttackPower(int attackPower) {
    this.attackPower = attackPower;
  }
}
