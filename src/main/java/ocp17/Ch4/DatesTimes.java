package ocp17.Ch4;

import java.time.*; // import time classes
import java.time.temporal.ChronoUnit;

public class DatesTimes {
    public static void main(String[] args) {
        System.out.println(LocalDate.now()); // 2022-08-03
        System.out.println(LocalTime.now()); // 18:17:27.589854
        System.out.println(LocalDateTime.now()); // 2022-08-03T18:17:27.589946
        System.out.println(ZonedDateTime.now()); // 2022-08-03T18:17:27.590547+01:00[Europe/Dublin]

        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var date2 = LocalDate.of(2022, 1, 20);

        var time1 = LocalTime.of(6, 15); // hour and minute
        var time2 = LocalTime.of(6, 15, 30); // + seconds
        var time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

        var dateTime1 = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
        var dateTime2 = LocalDateTime.of(date1, time1);

        var zone = ZoneId.of("US/Eastern");
        var zoned1 = ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone);
        var zoned2 = ZonedDateTime.of(date1, time1, zone);
        var zoned3 = ZonedDateTime.of(dateTime1, zone);

        var d = new LocalDate(); // DOES NOT COMPILE
        var d = LocalDate.of(2022, Month.JANUARY, 32); // DateTimeException

        var date = LocalDate.of(2022, Month.JANUARY, 20);
        date = date.plusDays(2);
        System.out.println(date); // 2022–01–22
        date = date.plusWeeks(1);
        date = date.plusMonths(1);
        date = date.plusYears(5);
        System.out.println(date); // 2027–02–28

        var date = LocalDate.of(2024, Month.JANUARY, 20);
        var time = LocalTime.of(5, 15);
        var dateTime = LocalDateTime.of(date, time).minusDays(1).minusHours(10).minusSeconds(30);

        var date = LocalDate.of(2024, Month.JANUARY, 20);
        date = date.plusMinutes(1); // DOES NOT COMPILE LocalDate does not contain time.

        var start = LocalDate.of(2022, Month.JANUARY, 1);
        var end = LocalDate.of(2022, Month.MARCH, 30);
        var period = Period.ofMonths(1); // create a period
        performAnimalEnrichment(start, end, period);

        var annually = Period.ofYears(1); // every 1 year
        var quarterly = Period.ofMonths(3);
        var everyThreeWeeks = Period.ofWeeks(3);
        var everyOtherDay = Period.ofDays(2);
        var everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

        var wrong = Period.ofYears(1).ofWeeks(1); // every week
        System.out.println(Period.ofMonths(3)); // P3M

        var date = LocalDate.of(2022, 1, 20);
        var time = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date, time);
        var period = Period.ofMonths(1);
        System.out.println(date.plus(period)); // 2022–02–20
        System.out.println(dateTime.plus(period)); // 2022–02–20T06:15
        System.out.println(time.plus(period)); // Exception

        var daily = Duration.ofDays(1); // PT24H
        var hourly = Duration.ofHours(1); // PT1H
        var everyMinute = Duration.ofMinutes(1); // PT1M 
        var everyTenSeconds = Duration.ofSeconds(10); // PT10S
        var everyMilli = Duration.ofMillis(1); // PT0.001S
        var everyNano = Duration.ofNanos(1); // PT0.000000001S

        var daily = Duration.of(1, ChronoUnit.DAYS);

        var date = LocalDate.of(2022, 5, 25); 
        var period = Period.ofDays(1);
        var days = Duration.ofDays(1);
        System.out.println(date.plus(period)); // 2022–05–26
        System.out.println(date.plus(days)); // Unsupported unit: Seconds Cannot use LocalDate with Duration only LocalDateTime or LocalTime or ZonedDateTime
    
        var now = Instant.now();
        // do something time consuming 
        var later = Instant.now();

        var duration = Duration.between(now, later); 
        System.out.println(duration.toMillis()); // Returns number milliseconds
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end,
            Period period) { // uses the generic period
        var upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period); // adds the period
        }
    }
}
