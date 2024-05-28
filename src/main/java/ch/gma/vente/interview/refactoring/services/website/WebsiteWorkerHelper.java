package ch.gma.vente.interview.refactoring.services.website;

import ch.gma.vente.interview.refactoring.models.website.PersonSO;
import ch.gma.vente.interview.refactoring.models.website.ProductTarifSO;
import ch.gma.vente.interview.refactoring.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WebsiteWorkerHelper {

  private final DateUtils dateUtils;

  public WebsiteWorkerHelper(DateUtils dateUtils) {
    this.dateUtils = dateUtils;
  }

  public void removeProductFromBasket(final String productCode, final String levelCode, PersonSO personSO) {
    for (ProductTarifSO tarifSO : personSO.getProducts()) {
      if (tarifSO.getProductCode().equals(productCode)
        && (levelCode.equals(""))) {
        personSO.getProducts().remove(tarifSO);
        break;
      }
    }
  }

  public void addProductFromBasket(final String productCode, final String levelCode, PersonSO personSO) {
    for (ProductTarifSO tarifSO : personSO.getProducts()) {
      if (tarifSO.getProductCode().equals(productCode)
        && (levelCode == null)) {
        personSO.getProducts().remove(tarifSO);
        break;
      }
    }
  }
}
