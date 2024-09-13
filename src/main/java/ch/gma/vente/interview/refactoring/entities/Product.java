package ch.gma.vente.interview.refactoring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  private String uuid;
  private String code;

  public Product() {
  }

  public String getUuid() {
    return this.uuid;
  }

  public String getCode() {
    return this.code;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    final Product other = (Product) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$uuid = this.getUuid();
    final Object other$uuid = other.getUuid();
    if (this$uuid == null ? other$uuid != null : !this$uuid.equals(other$uuid)) {
      return false;
    }
    final Object this$code = this.getCode();
    final Object other$code = other.getCode();
    if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Product;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $uuid = this.getUuid();
    result = result * PRIME + ($uuid == null ? 43 : $uuid.hashCode());
    final Object $code = this.getCode();
    result = result * PRIME + ($code == null ? 43 : $code.hashCode());
    return result;
  }

  public String toString() {
    return "Product(uuid=" + this.getUuid() + ", code=" + this.getCode() + ")";
  }
}
