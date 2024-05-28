package ch.gma.vente.interview.refactoring.resources;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ch.gma.vente.interview.refactoring.entities.Person;
import ch.gma.vente.interview.refactoring.repositories.PersonRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WebsiteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PersonRepository personRepository;

  @BeforeEach
  public void setup() {
    Person person = new Person();
    person.setUuid("123");
    when(personRepository.findById("123")).thenReturn(Optional.of(person));
  }

  @Test
  public void testAddProduct() throws Exception {
    mockMvc.perform(get("/basket/addProduct")
        .param("productCode", "prod123")
        .param("personId", "123"))
      .andExpect(status().isOk());
  }

  @Test
  public void testRemoveProduct() throws Exception {
    mockMvc.perform(delete("/basket/removeProduct")
        .param("productCode", "prod123")
        .param("personId", "123"))
      .andExpect(status().isOk());
  }
}