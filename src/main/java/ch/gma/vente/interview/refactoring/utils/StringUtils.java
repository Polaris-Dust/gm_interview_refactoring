package ch.gma.vente.interview.refactoring.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {

  private StringUtils() {
  }

  public static String fillStringToMaxSize(String string, int size) {
    return fillStringToMaxSize(string, size, false);
  }

  public static String fillStringToMaxSize(String string, int size, boolean debugMode) {
    if (string == null) {
      string = "";
    }
    StringBuilder stringBuilder = new StringBuilder(string);
    while (stringBuilder.length() < size) {
      stringBuilder.append(debugMode ? "X" : " ");
    }
    if (stringBuilder.length() > size) {
      stringBuilder.delete(size, stringBuilder.length());
    }
    return stringBuilder.toString().toUpperCase();
  }

  public static String fillStringToMaxSizeAndAlignRight(Object obj, int size) {
    return fillStringToMaxSizeAndAlignRight(obj, size, false);
  }

  public static String fillStringToMaxSizeAndAlignRight(Object obj, int size, boolean debugMode) {
    String str = null;
    if (obj == null) {
      str = "";
    }
    if (obj instanceof String || obj instanceof Integer) {
      str = String.valueOf(obj);
    }

    if (obj instanceof BigDecimal) {
      str = new java.text.DecimalFormat("###").format(obj);
    }

    str = org.apache.commons.lang3.StringUtils.reverse(str);
    StringBuilder toReturn = new StringBuilder();
    if (str != null && (str.length() <= size || size == -1)) {
      toReturn.append(str);
    } else if (str != null) {
      toReturn.append(str, 0, size);
    }
    assert str != null;
    for (int i = str.length(); i < size; i++) {
      toReturn.append(debugMode ? "X" : " ");
    }
    return org.apache.commons.lang3.StringUtils.reverse(toReturn.toString()).toUpperCase();
  }

  public static String formatString(Object strToFormat, String sourcePattern,
    String replacementPattern) {
    String toReturn = null;

    if (strToFormat instanceof String) {
      toReturn = strToFormat.toString();
    } else if (strToFormat instanceof BigDecimal) {
      toReturn = new java.text.DecimalFormat("###0.00").format(strToFormat);
    }

    if (strToFormat != null && toReturn != null && toReturn.length() > 0 && sourcePattern != null
      && sourcePattern.length() > 0 && replacementPattern != null
      && replacementPattern.length() > 0) {
      Pattern pattern = Pattern.compile(sourcePattern);
      Matcher matcher = pattern.matcher(toReturn);
      toReturn = matcher.replaceAll(replacementPattern);
    }
    return toReturn;
  }

  public static String checkNameWithApostophe(String nom) {
    StringBuilder toReturn = new StringBuilder();
    if (org.apache.commons.lang3.StringUtils.isNotEmpty(nom)) {
      int charPosition = nom.indexOf('\'');
      int lengthNom = nom.length();
      if (charPosition < 0 || lengthNom == charPosition + 1) { // s'il n'y a pas d'apostrophe, on retourne le même nom
        return nom;
      }

      if (lengthNom > charPosition + 1) {
        char charToConvert = Character.toUpperCase(nom.charAt(charPosition + 1));
        toReturn.append(nom.substring(0, charPosition + 1)).append(charToConvert);

        if (lengthNom > charPosition + 2) {
          toReturn.append(nom.substring(charPosition + 2));
        }
      }
    }
    return toReturn.toString();
  }

  public static String join(String... args) {
    return Stream.of(args)
      .filter(org.apache.commons.lang3.StringUtils::isNotBlank)
      .collect(Collectors.joining(org.apache.commons.lang3.StringUtils.SPACE));
  }
}
