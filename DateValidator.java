

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * The DateValidator class provides functionality to validate and manipulate dates.
 */
public class DateValidator {

    // Regular expression for date validation
    private static final String DATE_REGEXP = "^(3[01]|[12][0-9]|0[1-9])(\\/|-|\\.|,|:)(1[0-2]|0[1-9])\\2([0-9]{2})?[0-9]{2}$";

    private static final int[] DAYS_COUNT = new int[]{31,29,31,30,31,30,31,30,30,31,30,31};

    // Array of characters representing possible date separators
    private static final char[] DATE_SEP_CHARS = new char[] { '-', '.', ',', ':' };

    /**
     * Checks if the provided date string is in a valid format.
     *
     * @param date The date string to be validated.
     * @return True if the date is valid, false otherwise.
     */
    public static boolean isValid(String date) {
        return date.matches(DATE_REGEXP);
    }

    /**
     * Adapts the date string by replacing various separators with the standard '/' separator.
     *
     * @param date The date string to be adapted.
     * @return The adapted date string.
     * @throws Exception If the date is not valid.
     */
    public static String adaptDate(String date) throws Exception {
        if (!isValid(date)) {
            throw new Exception("Date is not valid");
        }
        for (char c : DATE_SEP_CHARS) {
            if (date.contains(Character.toString(c))) {
                date = date.replace(c, '/');
            }
        }
        return date;
    }

    private int year, month, day;
    private LocalDate localDate;

    /**
     * returns the localDate of the validated date.
     * @return `LocalDate` object
     */
    public LocalDate getLocalDate() {
        return localDate;
    }

    /**
     * Constructs a DateValidator object by parsing the provided date string.
     *
     * @param date The date string to be parsed and validated.
     * @throws Exception If the date is not valid or cannot be parsed.
     */
    public DateValidator(String date) throws Exception {
        date = adaptDate(date);
        String[] splittedDate = date.split("\\/");
        this.year = Integer.parseInt(splittedDate[2]);
        this.month = Integer.parseInt(splittedDate[1]);
        this.day = Integer.parseInt(splittedDate[0]);
        // Check for invalid dates
        if(day>DAYS_COUNT[this.month-1]){
            throw new Exception("This date cannot exist");
        }
        if (this.day == 29 && this.month == 2 && (!(this.year % 4 == 0 && !(this.year % 100 == 0)))) {
            throw new Exception("This date cannot exist");
        }
        localDate = LocalDate.of(year, month, day);
    }

    /**
     * Gets the year of the validated date.
     *
     * @return The year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the month of the validated date.
     *
     * @return The month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the day of the validated date.
     *
     * @return The day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the month of the current LocalDate as a string in Italian.
     *
     * @return The month as a string in Italian.
     */
    public String getMonthAsString() {
        return switch (localDate.getMonth()) {
            case JANUARY -> "Gennaio";
            case FEBRUARY -> "Febbraio";
            case MARCH -> "Marzo";
            case APRIL -> "Aprile";
            case MAY -> "Maggio";
            case JUNE -> "Giugno";
            case JULY -> "Luglio";
            case AUGUST -> "Agosto";
            case SEPTEMBER -> "Settembre";
            case OCTOBER -> "Ottobre";
            case NOVEMBER -> "Novembre";
            case DECEMBER -> "Dicembre";
        };
    }

    /**
     * Returns the day of the week of the current LocalDate as a string in Italian.
     *
     * @return The day of the week as a string in Italian.
     */
    public String getDayOfWeekAsString() {
        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALY);
    }

    /**
     * Returns the current date formatted in the European (EU) date format
     * (dd-mm-yyyy).
     *
     * @return The current date in EU format.
     */
    public String getDateEUFormat() {
        return String.format("%d-%d-%d", day, month, year);
    }

    /**
     * Overrides the default toString method to provide a formatted representation of the date.
     *
     * @return The formatted date string.
     */
    @Override
    public String toString() {
        String monthName = switch (localDate.getMonth()) {
            case JANUARY -> "Gennaio";
            case FEBRUARY -> "Febbraio";
            case MARCH -> "Marzo";
            case APRIL -> "Aprile";
            case MAY -> "Maggio";
            case JUNE -> "Giugno";
            case JULY -> "Luglio";
            case AUGUST -> "Agosto";
            case SEPTEMBER -> "Settembre";
            case OCTOBER -> "Ottobre";
            case NOVEMBER -> "Novembre";
            case DECEMBER -> "Dicembre";
        };
        return String.format("%s %d %s %d", localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALY), day,
                monthName, year);
    }
}