package ch.gma.vente.interview.refactoring.utils;

public class ErrorUtils {

  private ErrorUtils() {
  }

  public static boolean isErrorStatusCode(int statusCode) {
    return statusCode >= 400 && statusCode < 600;
  }

}
