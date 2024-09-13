package ch.gma.vente.interview.refactoring.models.website;

import java.util.ArrayList;
import java.util.List;

public class PersonSO {

  private String uuid;
  private List<ProductTarifSO> products = new ArrayList<>();

  public PersonSO(String uuid, List<ProductTarifSO> products) {
    this.uuid = uuid;
    this.products = products;
  }

  public PersonSO() {
  }

  public String getUuid() {
    return this.uuid;
  }

  public List<ProductTarifSO> getProducts() {
    return this.products;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public void setProducts(List<ProductTarifSO> products) {
    this.products = products;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PersonSO)) {
      return false;
    }
    final PersonSO other = (PersonSO) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$uuid = this.getUuid();
    final Object other$uuid = other.getUuid();
    if (this$uuid == null ? other$uuid != null : !this$uuid.equals(other$uuid)) {
      return false;
    }
    final Object this$products = this.getProducts();
    final Object other$products = other.getProducts();
    if (this$products == null ? other$products != null : !this$products.equals(other$products)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof PersonSO;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $uuid = this.getUuid();
    result = result * PRIME + ($uuid == null ? 43 : $uuid.hashCode());
    final Object $products = this.getProducts();
    result = result * PRIME + ($products == null ? 43 : $products.hashCode());
    return result;
  }

  public String toString() {
    return "PersonSO(uuid=" + this.getUuid() + ", products=" + this.getProducts() + ")";
  }
}
