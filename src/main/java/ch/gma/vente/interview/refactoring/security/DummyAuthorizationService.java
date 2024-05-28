package ch.gma.vente.interview.refactoring.security;

public class DummyAuthorizationService {

  private final String authorizationHeader;

  public DummyAuthorizationService(final String authorizationHeader) {
    this.authorizationHeader = authorizationHeader;
  }

  public String getAuthorizationHeader() {
    return authorizationHeader;
  }
}
