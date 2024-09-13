package ch.gma.vente.interview.refactoring.models.website;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BasketSO implements Serializable {

  private List<PersonSO> persons = new ArrayList<>();

  public BasketSO() {
  }

  public List<PersonSO> getPersons() {
    return this.persons;
  }

  public void setPersons(List<PersonSO> persons) {
    this.persons = persons;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof BasketSO)) {
      return false;
    }
    final BasketSO other = (BasketSO) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$persons = this.getPersons();
    final Object other$persons = other.getPersons();
    if (this$persons == null ? other$persons != null : !this$persons.equals(other$persons)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof BasketSO;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $persons = this.getPersons();
    result = result * PRIME + ($persons == null ? 43 : $persons.hashCode());
    return result;
  }

  public String toString() {
    return "BasketSO(persons=" + this.getPersons() + ")";
  }
}
