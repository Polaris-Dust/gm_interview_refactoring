package ch.gma.vente.interview.refactoring.utils;

public class RisqueUtils {

  public static final String RISQUE_MALADIE_ACCIDENT = "MA";
  public static final String RISQUE_MALADIE = "M";

  public static String findDefaultCodeRisque(String codeProduit, int age) {
    return codeProduit + (isDefaultCouvertureMaladieAccident(age) ? RISQUE_MALADIE_ACCIDENT : RISQUE_MALADIE);
  }

  /**
   * Since 2020/01/01 OR can change [Couverture Accident] from 15 up to 65 years
   *
   * @param age Age of the person
   * @return
   */
  public static boolean canChangeCouvertureAccident(int age) {
    return between(age, 15, 65);
  }

  /**
   * 0-16 | >65 year old should have default [CouvertureAccident] set to true
   *
   * @param age Age of the person
   * @return
   */
  public static boolean isDefaultCouvertureMaladieAccident(int age) {
    return between(age, 0, 16) || age > 65;
  }

  public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
    return (i >= minValueInclusive && i <= maxValueInclusive);
  }
}
