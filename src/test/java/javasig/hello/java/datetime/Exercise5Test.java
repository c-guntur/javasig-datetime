package javasig.hello.java.datetime;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * DateTime in Streams.
 *
 * @see TemporalAdjuster
 * @see TemporalAdjusters
 * @see DayOfWeek
 * @see Stream
 * @see IntStream
 * @see Collectors
 */
public class Exercise5Test {

    @Test
    public void temporalAdjuster() {

        LocalDate tOJDate = LocalDate.of(1997, 8, 29);

        // TODO: Fix assertions below.
        //-----------------------------------------
        fail("Delete this fail() and FIX the assertion below.");
        // assertEquals("firstDayOfTheMonth", tOJDate.minusDays(28), tOJDate.with(TemporalAdjusters.firstDayOfMonth()));
        // assertEquals("lastDayOfMonth ", tOJDate.plusDays(2), tOJDate.with(TemporalAdjusters.lastDayOfMonth()));
        // assertEquals("firstDayOfNextMonth ", tOJDate.plusDays(3), tOJDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        // assertEquals("nextDayOfWeek ", tOJDate.plusDays(5), tOJDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));

        // The first day of the next year after the Original Judgement day.
        LocalDate nextYearDate = LocalDate.of(1998, 1, 1);
        // TODO: Fix assertions below.
        //-----------------------------------------
        fail("Delete this fail() and FIX the assertion below.");
        // assertEquals("firstDayOfNextYear ", nextYearDate, tOJDate.with(TemporalAdjusters.firstDayOfNextYear()));
        // assertEquals("firstDayOfCurrentYear from nextYearDate ", nextYearDate.minusDays(365), tOJDate.with(TemporalAdjusters.firstDayOfYear()));
    }

    @Test
    public void streamTemporalAdjustment() {

        TemporalAdjuster temporalAdjuster = temporal -> {
            LocalDate localDate = LocalDate.from(temporal);
            localDate = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            return temporal.with(localDate);
        };

        Stream<LocalDate> someDates = Stream.of(
                LocalDate.of(1997, 8, 29),
                LocalDate.of(2015, 1, 1),
                LocalDate.of(2015, 1, 4));

        // TODO: Fix the list population below.
        // REPLACE the new ArrayList creation with a stream action on 'someDates'.
        //-----------------------------------------
        // List<LocalDate> collectSundays = someDates.map(each -> each.with(temporalAdjuster)).collect(Collectors.toList());

        fail("Delete this fail() and FIX the assertion line below.");
        // assertEquals("Sunday on or after 1997-08-29 is 1997-08-31", "1997-08-31", collectSundays.get(0).toString());
        // assertEquals("Sunday on or after 2015-01-01 is 2015-01-04", "2015-01-04", collectSundays.get(1).toString());
        // assertEquals("Sunday on or after 1997-01-04 is 2015-01-04", "2015-01-04", collectSundays.get(2).toString());
    }

    @Test
    public void twoBusinessDateShippingCalculator() {

        // TODO: Fix the TemporalAdjuster below.
        // Fix the logic. Use the assertions below.
        //-----------------------------------------
        TemporalAdjuster tPlusTwoBusinessDates = temporal -> {
            LocalDate localDate = LocalDate.from(temporal);
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            localDate = localDate.plusDays(2);
            return temporal.with(localDate);
        };

        LocalDate localDate = LocalDate.of(2015, 11, 18);

        List<LocalDate> sampleShippingDates = new ArrayList<>();

        IntStream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(i -> sampleShippingDates.add(localDate.plusDays(i)));

        Map<LocalDate, LocalDate> shippingDateMap = sampleShippingDates.stream()
                .collect(Collectors.toMap(each -> each, each -> each.with(tPlusTwoBusinessDates)));

        assertTrue("No weekend shipping", shippingDateMap.values().stream().noneMatch(localDate1 -> localDate1.getDayOfWeek().getValue() > 5));

        assertEquals("Items purchased on Monday should ship on the following Wednesday",
                DayOfWeek.WEDNESDAY, shippingDateMap.get(localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY))).getDayOfWeek());

        assertEquals("Items purchased on Tuesday should ship on the following Thursday",
                DayOfWeek.THURSDAY, shippingDateMap.get(localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY))).getDayOfWeek());

        assertEquals("Items purchased on Wednesday should ship on the following Friday",
                DayOfWeek.FRIDAY, shippingDateMap.get(localDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY))).getDayOfWeek());

        assertEquals("Items purchased on Thursday should ship on the following Monday",
                DayOfWeek.MONDAY, shippingDateMap.get(localDate.with(TemporalAdjusters.next(DayOfWeek.THURSDAY))).getDayOfWeek());

        assertEquals("Items purchased on Friday should ship on the following Tuesday",
                DayOfWeek.TUESDAY, shippingDateMap.get(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))).getDayOfWeek());

        assertEquals("Items purchased on Saturday should ship on the following Tuesday",
                DayOfWeek.TUESDAY, shippingDateMap.get(localDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY))).getDayOfWeek());

        assertEquals("Items purchased on Sunday should ship on the following Tuesday",
                DayOfWeek.TUESDAY, shippingDateMap.get(localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY))).getDayOfWeek());

    }

}
