package ch.gma.vente.interview.refactoring.security;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DummyAuthorizationServiceTest {

  private DummyAuthorizationService service;

  @Test
  public void shouldReturnTheProvidedToken() {
    // GIVEN
    final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
    service = new DummyAuthorizationService(token);

    // WHEN
    final String actualToken = service.getAuthorizationHeader();

    // THEN
    assertEquals("Both tokens should be equals", token, actualToken);
  }
}