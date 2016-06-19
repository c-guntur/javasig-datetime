package javasig.hello.java.datetime;

import static org.junit.Assert.fail;

public class LenientAssert {

    public static final String FIX_WITH_RIGHT_CALL = "Replace this string with a valid call";

    public static void assertAlmostEqual(long first, String second, long tolerance) {

        assertAlmostEqual(null, first, second, tolerance);
    }

    public static void assertAlmostEqual(long first, long second, long tolerance) {

        assertAlmostEqual(null, first, second, tolerance);
    }

    public static void assertAlmostEqual(String message, long first, long second, long tolerance) {

        if (!(Math.abs(first - second) <= tolerance)) {
            fail(format(message, first, second));
        }
    }

    public static void assertAlmostEqual(String message, long first, String second, long tolerance) {

            fail(format(message, first, second));
    }

    private static String format(String message, Object expected, Object actual) {

        String formatted = "";
        if (message != null && !message.equals("")) {
            formatted = message + " ";
        }
        String expectedString = String.valueOf(expected);
        String actualString = String.valueOf(actual);
        if (expectedString.equals(actualString)) {
            return formatted + "expected: "
                    + formatClassAndValue(expected, expectedString)
                    + " but was: " + formatClassAndValue(actual, actualString);
        } else {
            return formatted + "expected:<" + expectedString + "> but was:<"
                    + actualString + ">";
        }
    }

    private static String formatClassAndValue(Object value, String valueString) {

        String className = value == null ? "null" : value.getClass().getName();
        return className + "<" + valueString + ">";
    }
}
