import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void nextDayCalculatorDay1() {
        int day = 1;
        int month = 1;
        int year = 2018;

        String result = NextDayCalculator.getNextDay(day, month, year);
        String expected = "2/1/2018";
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorDay31() {
        int day = 31;
        int month = 1;
        int year = 2018;

        String result = NextDayCalculator.getNextDay(day, month, year);
        String expected = "1/2/2018";
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorDay30() {
        int day = 30;
        int month = 4;
        int year = 2018;

        String result = NextDayCalculator.getNextDay(day, month, year);
        String expected = "1/5/2018";
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorLeapYear() {
        int day = 29;
        int month = 2;
        int year = 2016;

        String result = NextDayCalculator.getNextDay(day, month, year);
        String expected = "1/3/2016";
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorNotLeapyear() {
        int day = 28;
        int month = 2;
        int year = 2017;

        String result = NextDayCalculator.getNextDay(day, month, year);
        String expected = "1/3/2017";
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorMonth12() {
        int day = 31;
        int month = 12;
        int year = 2019;

        String result = NextDayCalculator.getNextDay(day, month, year);
        String expected = "1/1/2020";
        assertEquals(expected, result);
    }

    @Test
    void nextDayCalculatorDay30Month2() {
        int day = 30;
        int month = 2;
        int year = 2008;
        String result = NextDayCalculator.getNextDay(day, month, year);
        String expected = "Invalid date";
        assertEquals(expected, result);
    }
}