package javasig.hello.java.datetime;

import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * DateTime partials: Month, MonthDay, Year, YearMonth and DayOfWeek tests.
 * <p>
 * Note: We create a Clock instance in setup() used for some of the tests.
 *
 * @see Clock
 * @see Month
 * @see MonthDay
 * @see Year
 * @see YearMonth
 * @see DayOfWeek
 */
public class Exercise4Test {
    private Clock terminatorOriginalJudgementDay = null;
    private LocalDateTime tOJDateTime;

    @Before
    public void setup() {

        Instant instant = Instant.parse("1997-08-29T07:14:30Z");
        // We make an assumption for GMT - 5 as the standard time for users of this test.
        terminatorOriginalJudgementDay = Clock.fixed(instant, ZoneId.of("GMT-5"));
        tOJDateTime = LocalDateTime.now(terminatorOriginalJudgementDay);
    }

    @Test
    public void month() {

        // TODO: Fix assertion.
        fail("Delete this fail() and FIX assert below.");
        // assertEquals("The Month enumeration should match August.", Month.???, tOJDateTime.getMonth());
    }

    @Test
    public void monthDay() {

        MonthDay monthDay = MonthDay.now(terminatorOriginalJudgementDay);
        // TODO: Fix assertions.
        fail("Delete this fail() and FIX assertions below.");
        // assertEquals("The month enumeration should match August.", Month.???, monthDay.getMonth());
        // assertEquals("The month value should match 8.", 0, monthDay.getMonthValue());
        // assertEquals("The date value should match 29.", 0, monthDay.getDayOfMonth());
    }

    @Test
    public void year() {

        Year year = Year.now(terminatorOriginalJudgementDay);
        // TODO: Fix assertion.
        fail("Delete this fail() and FIX assertion below.");
        // assertEquals("The year value should match 1997.", 0, year.getValue());
    }

    @Test
    public void yearMonth() {

        YearMonth yearMonth = YearMonth.now(terminatorOriginalJudgementDay);
        // TODO: Fix assertions.
        fail("Delete this fail() and FIX assertions below.");
        // assertEquals("The month enumeration should match August.", Month.???, yearMonth.getMonth());
        // assertEquals("The month value should match 8.", 0, yearMonth.getMonthValue());
        // assertEquals("The year value should match 1997.", 0, yearMonth.getYear());
    }

    @Test
    public void dayOfWeek() {

        DayOfWeek dayOfWeek = tOJDateTime.getDayOfWeek();
        // TODO: Fix assertions.
        fail("Delete this fail() and FIX assertion below.");
        // assertEquals("The day of the week enumeration should match Friday.", DayOfWeek.???, dayOfWeek);
    }

}
