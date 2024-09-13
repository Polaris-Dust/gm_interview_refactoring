package ch.gma.vente.interview.refactoring.services.website;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ch.gma.vente.interview.refactoring.models.website.BasketSO;
import ch.gma.vente.interview.refactoring.models.website.PersonSO;
import ch.gma.vente.interview.refactoring.models.website.ProductTarifSO;
import ch.gma.vente.interview.refactoring.utils.DateUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

@RunWith(MockitoJUnitRunner.class)
public class WebsiteWorkerHelperTest {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(WebsiteWorkerHelperTest.class);
  private DateUtils dateUtils = new DateUtils(null);
  private WebsiteWorkerHelper websiteWorkerHelper = new WebsiteWorkerHelper(dateUtils);

  private BasketSO basketSO;

  @Before
  public void init() {
    final ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).registerModule(new JavaTimeModule());
    try {
      basketSO = objectMapper.readValue(getClass().getResource("/website/basket.json"), BasketSO.class);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }

  @Test
  public void removeProductFromBasket_emptyLevelCode_Test() {
    PersonSO personSO = basketSO.getPersons().get(0);

    websiteWorkerHelper.removeProductFromBasket("AHGM03", "", personSO);

    assertEquals("Basket for person should contain 2 products", 2, personSO.getProducts().size());
    Optional<ProductTarifSO> gl = personSO.getProducts().stream().filter(product -> product.getProductCode().equals("GLGA01")).findAny();
    assertTrue("Basket should contain GL", gl.isPresent());
    Optional<ProductTarifSO> mu = personSO.getProducts().stream().filter(product -> product.getProductCode().equals("MUGA01")).findAny();
    assertTrue("Basket should contain MU", mu.isPresent());
  }

  @Test
  public void removeProductFromBasket_WithLevelCode_Test() {
    PersonSO personSO = basketSO.getPersons().get(0);

    websiteWorkerHelper.removeProductFromBasket("MUGA01", "", personSO);

    assertEquals("Basket for person should contain 2 products", 2, personSO.getProducts().size());
    Optional<ProductTarifSO> gl = personSO.getProducts().stream().filter(product -> product.getProductCode().equals("GLGA01")).findAny();
    assertTrue("Basket should contain GL", gl.isPresent());
    Optional<ProductTarifSO> ah = personSO.getProducts().stream().filter(product -> product.getProductCode().equals("AHGM03")).findAny();
    assertTrue("Basket should contain AH", ah.isPresent());
  }
}
