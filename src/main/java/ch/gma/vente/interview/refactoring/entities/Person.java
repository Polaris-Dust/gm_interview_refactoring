package ch.gma.vente.interview.refactoring.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {

  @Id
  private String uuid;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "person_products",
    joinColumns = {@JoinColumn(name = "person_uuid")},
    inverseJoinColumns = {@JoinColumn(name = "product_uuid")}
  )
  private List<Product> products = new ArrayList<>();

  public Person() {
  }

  public String getUuid() {
    return this.uuid;
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    final Person other = (Person) o;
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
    return other instanceof Person;
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
    return "Person(uuid=" + this.getUuid() + ", products=" + this.getProducts() + ")";
  }
}
