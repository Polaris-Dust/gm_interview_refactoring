package ch.gma.vente.interview.refactoring.models.website;

public class ProductTarifSO {

  private String productCode;

  public ProductTarifSO() {
  }

  public String getProductCode() {
    return this.productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ProductTarifSO)) {
      return false;
    }
    final ProductTarifSO other = (ProductTarifSO) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$productCode = this.getProductCode();
    final Object other$productCode = other.getProductCode();
    if (this$productCode == null ? other$productCode != null : !this$productCode.equals(other$productCode)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof ProductTarifSO;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $productCode = this.getProductCode();
    result = result * PRIME + ($productCode == null ? 43 : $productCode.hashCode());
    return result;
  }

  public String toString() {
    return "ProductTarifSO(productCode=" + this.getProductCode() + ")";
  }
}
