package java8.ex04;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 04 - LocalDateTime
 */
public class DateAndTime_04_Test {

    @Test
    public void test_localDateTime_of() {

        // TODO créer un objet LocalDateTime à la date heure 12h00m00s 01/01/2018
        LocalDateTime result = null;

        // TODO valoriser les différentes variables afin de rendre le test passant
        int hour = 0;
        int minutes = 0;
        int second = 0;
        int year = 0;
        Month month = null;
        int dayOfMonth = 0;

        assertThat(hour, is(12));
        assertThat(minutes, is(0));
        assertThat(second, is(0));
        assertThat(year, is(2018));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(1));
    }

    @Test
    public void test_localDateTime_parse() {

        // TODO créer un objet LocalTime à l'heure 2 mars 2009 à 09h30m00s à l'aide de la méthode parse
        LocalDateTime result = null;

        // TODO valoriser les différentes variables afin de rendre le test passant
        int hour = 0;
        int minutes = 0;
        int second = 0;

        int year = 0;
        Month month = null;
        int dayOfMonth = 0;

        assertThat(year, is(2009));
        assertThat(month, is(Month.MARCH));
        assertThat(dayOfMonth, is(2));

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localDateTime_format() {

        // TODO créer un objet LocalDateTime le 27/11/2017 à 12h00m00s
        // TODO utiliser la méthode of
        LocalDateTime localDateTime = null;

        // TODO Formatter l'heure pour que le test soit passant
        String result = null;

        assertThat(result, is("2017 - 11/27 12:00"));
    }
}
