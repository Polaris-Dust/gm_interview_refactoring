package ch.gma.vente.interview.refactoring.resources;

import ch.gma.vente.interview.refactoring.entities.Person;
import ch.gma.vente.interview.refactoring.entities.Product;
import ch.gma.vente.interview.refactoring.models.website.PersonSO;
import ch.gma.vente.interview.refactoring.models.website.ProductTarifSO;
import ch.gma.vente.interview.refactoring.repositories.PersonRepository;
import ch.gma.vente.interview.refactoring.services.website.WebsiteWorkerHelper;
import ch.gma.vente.interview.refactoring.utils.DateUtils;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebsiteController {

  @Autowired
  public PersonRepository personRepository;

  private final WebsiteWorkerHelper websiteWorkerHelper = new WebsiteWorkerHelper(new DateUtils(null));

  @DeleteMapping(path = "/basket/removeProduct")
  public void removeProduct(@RequestParam(name = "productCode") final String productCode, @RequestParam(name = "personId") final String personId) {
    websiteWorkerHelper.removeProductFromBasket(productCode, "", toSO(personRepository.findById(personId).get()));
  }

  private PersonSO toSO(Person person) {
    return new PersonSO(person.getUuid(), person.getProducts().stream().map(this::toSO).collect(Collectors.toList()));
  }

  private ProductTarifSO toSO(Product product) {
    final ProductTarifSO productTarifSO = new ProductTarifSO();
    productTarifSO.setProductCode(product.getCode());
    return productTarifSO;
  }

  @GetMapping(path = "/basket/addProduct")
  public void addProduct(@RequestParam(name = "productCode") final String productCode, @RequestParam(name = "personId") final String personId) {
    websiteWorkerHelper.addProductFromBasket(productCode, null, toSO(personRepository.findById(personId).get()));
  }

}
