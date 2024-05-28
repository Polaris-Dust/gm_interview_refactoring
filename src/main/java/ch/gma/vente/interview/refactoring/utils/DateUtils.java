package ch.gma.vente.interview.refactoring.utils;

import ch.gma.vente.interview.refactoring.models.SexeEnumFO;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {

  public static final String DATE_FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
  public static final String DATE_FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd'T'HH:mm:ss";
  public static final String DATE_FORMAT_ddMMyyyy = "dd.MM.yyyy";
  private final Clock clock;

  public DateUtils(Clock clock) {
    this.clock = clock;
  }

  public LocalDate now() {
    return LocalDate.now(clock);
  }

  public int getAge(LocalDate dateNaissance) {
    LocalDate today = now();
    return getAgeRevoluByYear(dateNaissance, today);
  }

  public int getAgeRevoluByYear(LocalDate dateNaissance, LocalDate atDate) {
    return atDate.getYear() - dateNaissance.getYear();
  }

  public static int getAgeRevoluByDay(LocalDate dateNaissance, LocalDate atDate) {
    Period period = Period.between(dateNaissance, atDate);
    return period.getYears();
  }

  public LocalDate getDateEntreeVigueurLAMAL(SexeEnumFO sexe, LocalDate dateNaissance) {
    if (SexeEnumFO.PRENATAL == sexe) {
      return dateNaissance;
    }

    // Nouveau ne, date de naissance < 3 mois par rapport à la date du jour ALORS l'assureur actuel ne doit pas être exigé
    if (dateNaissance.isAfter(now().minusMonths(3))) {
      return now().withDayOfMonth(1).plusMonths(1);
    }

    return now().withMonth(1).withDayOfMonth(1).plusYears(1);
  }

  public LocalDate getDateEntreeVigueurLAMALCaisseEtrangere(SexeEnumFO sexe, LocalDate dateNaissance) {
    if (SexeEnumFO.PRENATAL == sexe) {
      return dateNaissance;
    }
    return now().plusMonths(1).withDayOfMonth(1);
  }

  public LocalDate getDateEntreeVigueurLCA(SexeEnumFO sexe, LocalDate dateNaissance) {
    if (SexeEnumFO.PRENATAL == sexe) {
      return dateNaissance;
    }

    // Nouveau ne, date de naissance < 3 mois par rapport à la date du jour ALORS l'assureur actuel ne doit pas être exigé
    if (dateNaissance.isAfter(now().minusMonths(3))) {
      return now().withDayOfMonth(1).plusMonths(1);
    }

    return now().withMonth(1).withDayOfMonth(1).plusYears(1);
  }

  public boolean dateInPast(LocalDate dateEntree) {
    return dateEntree.isBefore(now());
  }

  public boolean dateAfter21Month(LocalDate dateEntree) {
    return now().plusMonths(21).isBefore(dateEntree);
  }

  public boolean todayBeforeDate(int day, int month, int year) {
    LocalDate calendar = initDate(day, month, year);

    return now().isBefore(calendar);
  }

  public boolean todayAfterDate(int day, int month, int year) {
    LocalDate calendar = initDate(day, month, year);

    return now().isAfter(calendar);
  }

  public boolean dateEquals(LocalDate date1, LocalDate date2) {
    return date1.isEqual(date2);
  }

  public boolean dateEquals(LocalDate date, int day, int month, int yearToAdd) {
    LocalDate localDate = now().withDayOfMonth(day).withMonth(month).plusYears(yearToAdd);
    return date.isEqual(localDate);
  }

  public LocalDate initDate(int day, int month, int year) {
    LocalDate localDate = now();
    if (year != -1) {
      localDate = localDate.withYear(year);
    }
    if (month != -1) {
      localDate = localDate.withMonth(month);
    }
    if (day != -1) {
      localDate = localDate.withDayOfMonth(day);
    }

    return localDate;
  }

  public static String formatDate(LocalDate date, String pattern) {
    if (date == null) {
      return "";
    }
    return date.format(DateTimeFormatter.ofPattern(pattern));
  }

  public static String formatDate(LocalDateTime date, String pattern) {
    return date.format(DateTimeFormatter.ofPattern(pattern));
  }

  public static String formatDate(LocalDate localDate, String pattern, Locale locale) {
    if (localDate == null) {
      return "";
    }
    return localDate.format(DateTimeFormatter.ofPattern(pattern, locale));
  }

  /**
   * @param dateStr formatted by "yyyy-MM-dd"
   * @return dateStr convert to date
   */
  public static LocalDate parseDate(final String dateStr) {
    if (StringUtils.isNotEmpty(dateStr)) {
      try {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE_FORMAT_yyyy_MM_dd));

      } catch (Exception e1) {
        throw new RuntimeException(e1);
      }
    }
    return null;
  }

  public int getAgeRevoluAtDate(final LocalDate dateNaissance, final LocalDate atDate) {
    return Period.between(dateNaissance, atDate).getYears();
  }

  public LocalDate parseFrontDate(final String dateStr) {
    if (StringUtils.isNotEmpty(dateStr)) {
      try {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE_FORMAT_ddMMyyyy));
      } catch (Exception e) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE_FORMAT_yyyy_MM_dd));
      }
    }
    return null;
  }

  public String toFrontDate(LocalDate date) {
    return toFormatDate(date, DATE_FORMAT_ddMMyyyy);
  }

  public String toApiDate(LocalDate date) {
    return toFormatDate(date, DATE_FORMAT_yyyy_MM_dd);
  }

  private String toFormatDate(LocalDate date, String pattern) {
    try {
      return date.format(DateTimeFormatter.ofPattern(pattern));
    } catch (Exception e) {
      return "";
    }
  }
}
