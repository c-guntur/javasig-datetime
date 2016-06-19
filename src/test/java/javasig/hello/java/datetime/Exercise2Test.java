package javasig.hello.java.datetime;

import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Date containers: LocalDate, LocalTime, LocalDateTime and ZonedDateTime tests.
 * <p>
 * Note: We create a Clock instance in setup() used for some of the tests.
 *
 * @see Clock
 * @see LocalDate
 * @see LocalDateTime
 * @see ZonedDateTime
 * @see ZoneOffset
 * @see ZoneId
 * @see Month
 */
public class Exercise2Test {

    private Clock terminatorOriginalJudgementDay = null;

    @Before
    public void setup() {

        Instant instant = Instant.parse("1997-08-29T07:14:30Z");
        // *****************************************************
        // We make an assumption for GMT - 5 as the standard
        // time for users of this test.
        // *****************************************************
        terminatorOriginalJudgementDay = Clock.fixed(instant, ZoneId.of("GMT-5"));
    }

    @Test
    public void simpleAssignmentOfLocalDate1() {

        // *****************************************************
        // Is March = month 2 ( remember old date API? ) or
        // did Java 8 Date Time FINALLY address that and make
        // month numbering consistent with ISO8601 standard?
        // *****************************************************

        // TODO: Fix LocalDate to a date of 2015-03-17. Try using integers for years, months and dates.
        // REPLACE the line below to fix stPatricksDay2015.
        //-----------------------------------------
        // LocalDate stPatricksDay2015 = LocalDate.???; // Fix to take year, month and date
        fail("Delete this fail() and FIX the assertion line below.");
        // assertEquals("LocalDate should match the expected", "2015-03-17", stPatricksDay2015.toString());
    }

    @Test
    public void simpleAssignmentOfLocalDate2() {

        // *****************************************************
        // A tribute to 2001: A Space Odyssey, HAL, the sentient
        // computer, was 'born' on January 12th 1999
        // *****************************************************

        // TODO: Fix date below to HAL's birthday. Use Month enums.
        // REPLACE the now() with HAL's birthday
        //-----------------------------------------
        // LocalDate halsBirthday = LocalDate.???; // Fix to take year, Month and date
        fail("Delete this fail() and FIX the assertion line below.");
        // assertEquals("LocalDate year should match the expected", 1999, halsBirthday.getYear());
    }

    @Test
    public void recommendedDateBasedTestingForLocalDate() {

        // *****************************************************
        // This test demonstrates the power of a Clock, by
        // allowing creation of a time that represents a
        // specific time as "now". For this test a Fixed Clock
        // instantiated in the setup() is used to generate a
        // "now" of the Original Terminator Judgement day.
        // *****************************************************

        // TODO: Fix date below to refer to the exact date of the Terminator (Original) Judgement Day.
        // REPLACE the now() with the the right value.
        //-----------------------------------------
        // LocalDate tOJDDate = LocalDate.now(???); // FIXME
        fail("Delete this fail() and FIX the assertion line below.");
        // assertEquals("The Original Terminator Judgement Day was in the 8th month (August)", 8, tOJDDate.getMonthValue());
    }

    @Test
    public void simpleAssignmentOfLocalTime() {

        // *****************************************************
        // Demonstrate setting just the time to 7:52
        // *****************************************************

        // TODO: Fix LocalTime to a time on 07:52 AM.
        // REPLACE the line below to set the right hour and minute.
        //-----------------------------------------
        // LocalTime sevenFiftyTwoAm = LocalTime.???; //FIXME
        fail("Delete this fail() and FIX the assertion line below.");
        // assertEquals("The time should show 07:52", "07:52", sevenFiftyTwoAm.toString());
    }

    @Test
    public void recommendedDateBasedTestingForLocalTime() {

        // TODO: Fix time below to refer to the exact time of the Terminator (Original) Judgement Day.
        // REPLACE the now() with the the right value.
        //-----------------------------------------
        // LocalTime tOJDTime = LocalTime.now(???);
        fail("Delete this fail() and FIX the assertion lines below.");
        // assertEquals("The hour should be at 2 AM", 2, tOJDTime.getHour());
        // assertEquals("The minute should be at 14", 14, tOJDTime.getMinute());
    }

    @Test
    public void simpleAssignmentOfLocalDateTime() {

        // TODO: Fix LocalDateTime to a date of 2005-05-05 and a time on 05:05:05 AM.
        // REPLACE the line below to set the right date and time.
        //-----------------------------------------
        // LocalDateTime allDateTimeOhFives = LocalDateTime.???; //FIXME
        fail("Delete this fail() and FIX the assertion lines below.");
        // assertTrue("The month should be May (5th Month)", allDateTimeOhFives.getMonthValue() == 5);
        // assertEquals("The minute should be 5", 5, allDateTimeOhFives.getMinute());
        // assertTrue("The second should be 5", allDateTimeOhFives.getSecond() == 5);
    }

    @Test
    public void recommendedDateBasedTestingForLocalDateTime() {

        // TODO: Fix time below to refer to the exact time of the Terminator (Original) Judgement Day.
        // REPLACE the now() with the the right value.
        //-----------------------------------------
        // LocalDateTime tOJDDateTime = LocalDateTime.now(???);
        fail("Delete this fail() and FIX the assertion lines below.");
        // assertEquals("The Original Terminator Judgement Day was in the 8th month (August)", 8, tOJDDateTime.getMonthValue());
        // assertEquals("The hour should be at 2 AM", 2, tOJDDateTime.getHour());
        // assertEquals("The minute should be at 14", 14, tOJDDateTime.getMinute());
    }

    @Test
    public void zonedDateTime() {

        // Will not name this test as simple ...
        ZonedDateTime allDateTimeOhFives = ZonedDateTime.of(5, 5, 5, 5, 5, 5, 555, ZoneId.ofOffset("", ZoneOffset.of("-0500")));
        ZoneId gmtPlusOneZoneId = ZoneId.ofOffset("", ZoneOffset.of("+0100"));

        // TODO: Fix ZonedDateTime to a date of 2005-05-05 and a time on 05:05:05 AM in GMT -5 to display in GMT +1.
        // REPLACE the line below to show the same Instant in a different zone. Investigate the 'with' methods.
        //-----------------------------------------
        // ZonedDateTime gmtPlusOneDateTimeAtAllFivesInGmtMinusFive = allDateTimeOhFives.???;
        fail("Delete this fail() and FIX the assertion lines below.");
        // assertEquals("The offset should be 1h in seconds", 3600, gmtPlusOneDateTimeAtAllFivesInGmtMinusFive.getOffset().getTotalSeconds());
        // assertEquals("5 AM in GMT-5 implies 11AM in GMT+1", 11, gmtPlusOneDateTimeAtAllFivesInGmtMinusFive.getHour());
    }

    @Test
    public void recommendedDateBasedTestingForZonedDateTime() {

        LocalDateTime tOJDDateTime = LocalDateTime.now(terminatorOriginalJudgementDay);
        ZonedDateTime gmtPlusOneHourTimeForTOJD = ZonedDateTime.ofInstant(tOJDDateTime.toInstant(ZoneOffset.of("+0000")), ZoneId.of("GMT+1"));
        // TODO: Fix the below asserts, so they pass.
        //-----------------------------------------
        fail("Delete this fail() and FIX the assertion lines below.");
        // assertEquals("The expected and actual values need to match", 0, gmtPlusOneHourTimeForTOJD.getMonthValue());
        // assertEquals("The expected and actual values need to match", 0, gmtPlusOneHourTimeForTOJD.getHour());
        // assertEquals("The expected and actual values need to match", 0, gmtPlusOneHourTimeForTOJD.getMinute());
    }

}
