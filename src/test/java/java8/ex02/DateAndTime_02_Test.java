package java8.ex02;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

    @Test
    public void test_localDate_of() {

        // TODO créer un objet LocalDate à la date 24/12/2050
        LocalDate result = null;

        // TODO valoriser les différentes variables afin de rendre le test passant
        int year = 0;
        Month month = null;
        int dayOfMonth = 0;
        DayOfWeek dayOfWeek = null;
        int dayOfYear = 0;

        assertThat(year, is(2050));
        assertThat(month, is(Month.DECEMBER));
        assertThat(dayOfMonth, is(24));
        assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
        assertThat(dayOfYear, is(358));
    }

    @Test
    public void test_localDate_parse() {

        // TODO créer un objet LocalDate à la date 10/01/1990
        // TODO utiliser la méthode parse
        LocalDate result = null;


        // TODO valoriser les différentes variables afin de rendre le test passant
        int year = 0;
        Month month = null;
        int dayOfMonth = 0;


        assertThat(year, is(1990));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(10));
    }

    @Test
    public void test_localDate_format() {

        // TODO créer un objet LocalDate à la date 11/03/2015
        // TODO utiliser la méthode of
        LocalDate localDate = null;

        // TODO Formatter la date pour que le test soit passant
        String result = null;

        assertThat(result, is("11 - 03 - 2015"));
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void test_localDate_format_with_hour() {

        // TODO créer un objet LocalDate à la date 11/03/2015
        // TODO utiliser la méthode of
        LocalDate localDate = null;

        // TODO Formatter la date pour avoir l'affichage suivant : "11/03/2015 00:00:00"
        localDate.format(null);
    }

    @Test
    public void test_with() {

        // TODO créer un objet LocalDate à la date 10/01/2000
        // TODO utiliser la méthode of
        LocalDate localDate = null;

        // TODO transformer la date précédente en 05/02/2015
        LocalDate result = null;

        assertThat(result.getYear(), is(2015));
        assertThat(result.getMonth(), is(Month.FEBRUARY));
        assertThat(result.getDayOfMonth(), is(5));
    }

}
