package ch.gma.vente.interview.refactoring.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch.gma.vente.interview.refactoring.RefactoringApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = RefactoringApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class AccessConfigurationTest {

  @Autowired
  private TestRestTemplate template;

  @Test
  void whenUnknownEndpoint_shouldFailWith404() {
    final ResponseEntity<Void> result = template.getForEntity("/endpoint/that/does/not/exist", Void.class);
    assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
  }
}