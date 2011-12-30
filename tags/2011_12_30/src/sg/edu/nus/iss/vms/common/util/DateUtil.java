package sg.edu.nus.iss.vms.common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * Date Utility Class.
 * 
 * @Class name : 
 * @author: $Author: $
 */
public class DateUtil {
    /**
     * Utility class should not have public constructor.
     */
    private DateUtil () {
    }

    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

    public static final String DATE_FORMAT_YMD = "yyyy/MM/dd";
    
    public static final String DATE_FORMAT_YMD_WITHOUT_SLASH = "yyyyMMdd";

    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public static final String DEFAULT_TIME_FORMAT_SHORT = "HH:mm";
    
    public static final String TIME_STR_ONE_ZERO = "0";

    public static final String TIME_STR_TWO_ZERO = "00";

    private static String default_timezone = "Asia/Singapore";

    public final static String TIMESTAMP_MILLIS_FORMAT = "dd/MM/yyyy HH:mm:ss.SSS";

    /**
     * Returns the date instance based on the current system date and default
     * timezone.
     * 
     * @return Current System date.
     */
    public static Date getDate () {
        TimeZone tz = TimeZone.getTimeZone(default_timezone);
        Calendar calendar = Calendar.getInstance(tz);
        return calendar.getTime();
    }

    /**
     * Return the Date instance with the provided year, month ( 1 - 12 ), and
     * day ( 1 - 31 ) values.
     * <p/>
     * The date value will roll over when given a value that is greater than the
     * max possible. Eg. when getDate( 2002, 10, 32 ) is provided, the Date
     * instance will be 1st Nov 2002.
     * <p/>
     * 
     * @param year Year
     * @param month Month ( 1 - 12 )
     * @param day Day( 1 - 31 )
     * @return The Date instance created.
     */
    public static Date getDate (int year, int month, int day) {
        Calendar cal = Calendar.getInstance();

        // Clear all fields first
        cal.clear();

        cal.set(year, month - 1, day);

        return cal.getTime();
    }

    /**
     * Format the input date String to a date in the following format:
     * dd/MM/yyyy.
     * 
     * @param iDate the date String to be formatted.
     * @return the formatted date, return null if input string is null or empty.
     */
    public static Date parseDate (String iDate) {
        return parseDate(iDate, DEFAULT_DATE_FORMAT);
    }

    /**
     * Format the input date String to a date in the pass in date format.
     * 
     * @param iDate the date String to be formatted.
     * @param sDatePattern format pattern
     * @return the formatted date, return null if input string is null or empty.
     */
    public static Date parseDate (String iDate, String sDatePattern) {
        try {
            if (iDate == null || iDate.trim().equals("")) {
                return null;
            }

            SimpleDateFormat oFormat = new SimpleDateFormat(sDatePattern);
            oFormat.setLenient(false);
            return oFormat.parse(iDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Format the input date to a date string in the following format:
     * dd/MM/yyyy.
     * 
     * @param iDate the date value to be formatted into a date string.
     * @return the formatted date time string; an empty String if the input date
     *         is <code>null</code> or if there is error during formatting.
     */
    public static String formatDate (Date iDate) {
        return formatDate(iDate, DEFAULT_DATE_FORMAT);
    }

    /**
     * Format the input date to a date string in the pass in date pattern.
     * 
     * @param iDate the date value to be formatted into a date string.
     * @param sDatePattern pass in date pattern.
     * @return the formatted date time string; an empty String if the input date
     *         is <code>null</code> or if there is error during formatting.
     */
    public static String formatDate (Date iDate, String sDatePattern) {
        if (iDate == null) {
            return null;
        }
        SimpleDateFormat oFormat = new SimpleDateFormat(sDatePattern);
        oFormat.setLenient(false);
        return oFormat.format(iDate);
    }

    /**
     * set input time to the input date.
     * 
     * @param iDate input date
     * @param iTime input time
     * @return Date with input time.
     */
    public static Date setTime (Date iDate, String iTime) {
        if (iDate == null) {
            return null;
        }
        if (iTime == null) {
            return iDate;
        }
        Calendar oCalendar = Calendar.getInstance();
        oCalendar.setTime(iDate);
        SimpleDateFormat oFormat = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
        oFormat.setLenient(false);
        try {
            Date oDate1 = oFormat.parse(iTime);
            Calendar oCalendar1 = Calendar.getInstance();
            oCalendar1.setTime(oDate1);
            oCalendar.set(Calendar.HOUR_OF_DAY, oCalendar1
                    .get(Calendar.HOUR_OF_DAY));
            oCalendar.set(Calendar.MINUTE, oCalendar1.get(Calendar.MINUTE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oCalendar.getTime();
    }

    /**
     * get input date's time with default time format.
     * 
     * @param oDate input date
     * @return time string with default foramt.
     */
    public static String formatTime (Date oDate) {
        if (oDate == null) {
            return null;
        }
        SimpleDateFormat oFormat = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
        oFormat.setLenient(false);
        return oFormat.format(oDate);
    }

    /**
     * Returns the timestamp instance based on the current system date and
     * default timezone.
     * 
     * @return the current timestamp
     */
    public static Timestamp getCurrentTimestamp () {
        return new Timestamp(getDate().getTime());
    }

    /**
     * The method will compares input date with system date (excluding the HH MM
     * SS).
     * 
     * @param date1 date
     * @return int int value
     */
    public static int compareSystemDate (Date date1) {
        Date date2 = new Date(System.currentTimeMillis());
        return compareDates(date1, date2);
    }

    /**
     * The method will compares 2 dates (excluding the HH MM SS).
     * 
     * @param date1 1st date parameter
     * @param date2 2nd date parameter
     * @return returns -1 if 1st date parameter is earlier than 2nd date
     *         parameter retuns 0 if both dates parameter is the same day retuns
     *         1 if 1st date parameter is later than 2nd date parameter
     */
    public static int compareDates (Date date1, Date date2) {
        if ((date1 == null) && (date2 == null)) {
            return 0;
        }

        if (date1 == null) {
            return -1;
        }

        if (date2 == null) {
            return 1;
        }

        String strFormat = "yyyyMMdd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);

        int intDate1 = Integer.parseInt(dateFormat.format(date1));
        int intDate2 = Integer.parseInt(dateFormat.format(date2));

        if (intDate1 == intDate2) {
            return 0;
        }

        if (intDate1 > intDate2) {
            return 1;
        }

        return -1;
    }

    /**
     * Tests the input value to ensure that a valid Date instance can be created
     * from it. Roll over dates are not allowed here and will return a false
     * value. Eg. isValidDate(2002, 10, 32) will return false.
     * <p/>
     * 
     * @param year The year value.
     * @param month The month value. ( 1 - 12 )
     * @param day The day value. ( 1 - 31 )
     * @return True if all values can be used to create a single valid Date
     *         instance.
     */
    public static boolean isValidDate (int year, int month, int day) {

        if (day <= 0 || month <= 0 || year <= 0)
            return false;
        if (month > 12 || day > 31)
            return false;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);

        // Find the maximum field value possible for the day with the year and
        // month.
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        return (day <= maxDay);
    }

    /**
     * Tests the input string to ensure that a valid Date instance can be
     * created according to the date format specified in the System property.
     * <p/>
     * If the properties file is not available or the dateformat property has
     * not been specified, the default format "dd/MM/yyyy" will be used.
     * <p/>
     * 
     * @param dateStr A date string.
     * @return True if it conforms to the system date format; False otherwise.
     */
    public static boolean isValidDate (String dateStr) {

        StringUtil.deNull(dateStr);
        if (dateStr.length() != 10) {
            return false;
        }

        boolean validDelimiter = (StringUtil.getCount(dateStr, '-') == 2
                || StringUtil.getCount(dateStr, '/') == 2 || StringUtil
                .getCount(dateStr, '.') == 2);

        if (!validDelimiter) {
            return false;
        }

        String dd = dateStr.substring(0, 2);
        String mm = dateStr.substring(3, 5);
        String yyyy = dateStr.substring(6, 10);

        try {
            return isValidDate(Integer.parseInt(yyyy), Integer.parseInt(mm),
                    Integer.parseInt(dd));
        } catch (Throwable t) {
            return false;
        }

    }

    /**
     * Tests if the inputs are valid time. When the ampm parameter is true, the
     * input hour will be tested for 12-hour format ( 1 ? 12 ). When it is
     * false, the input hour will be tested for 24-hour format ( 0 ? 23 ).
     * <p/>
     * 
     * @param hour The Hour value. ( 0 - 23 )
     * @param minute The Minute value. ( 0 - 59 )
     * @return True if the time inputs can be used to create a valid time
     *         instance.
     */
    public static boolean isValidTime (int hour, int minute) {
        return minute >= 0 && minute <= 59 && hour >= 0 && hour <= 23;
    }

    /**
     * Date Arithmetic function. Adds the specified (signed) amount of time to
     * the given time field, based on the calendar's rules.
     * <p>
     * For example, to subtract 5 days from a specific date, it can be achieved
     * by calling:
     * <p>
     * DateUtil.add(date, Calendar.DATE, -5).
     * <p>
     * 
     * @param date The date to perform the arithmetic function on
     * @param field A Calendar constant to retrieve the field value from the
     *            Date object. Same as for {@link #get get()}.
     * @param amount the amount of date or time to be added to the field
     * @return The date as a result of the execution of the arithmetic function.
     */
    public static Date add (Date date, int field, int amount) {
        TimeZone tz = TimeZone.getTimeZone(default_timezone);
        Calendar cal = Calendar.getInstance(tz);
        cal.setTime(date);
        cal.add(field, amount);

        return cal.getTime();
    }

    /**
     * Format the input date String from one pattern to another pattern in the
     * following format: "dd/MM/yyyy" to "yyyy/MM/dd" or "yyyy/MM/dd" to
     * "dd/MM/yyyy".
     * 
     * @param dateStr the date String to be formatted.
     * @param sDatePattern the pattern of date string.
     * @return the formatted date string, return null if input string is null or
     *         empty.
     */
    public static String formatDateStr (String dateStr, String sDatePattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        if (StringUtils.equalsIgnoreCase(sDatePattern, DEFAULT_DATE_FORMAT)) {
            return formatDate(parseDate(dateStr, DATE_FORMAT_YMD),
                    DEFAULT_DATE_FORMAT);

        } else if (StringUtils.equalsIgnoreCase(sDatePattern, DATE_FORMAT_YMD)) {
            return formatDate(parseDate(dateStr, DEFAULT_DATE_FORMAT),
                    DATE_FORMAT_YMD);

        } else {
            return null;
        }
     }
    
    /**
     * Format the input date String from one pattern to another pattern in the
     * following format: "dd/MM/yyyy" to "yyyyMMdd" or "yyyyMMdd" to "dd/MM/yyyy".
     * 
     * @param dateStr the date String to be formatted.
     * @param sDatePattern the pattern of date string.
     * @return the formatted date string, return null if input string is null or
     *         empty.
     */
    public static String formatDateStrWithoutSlash (String dateStr, String sDatePattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        if (StringUtils.equalsIgnoreCase(sDatePattern, DEFAULT_DATE_FORMAT)) {
            return formatDate(parseDate(dateStr, DATE_FORMAT_YMD_WITHOUT_SLASH), DEFAULT_DATE_FORMAT);

        } else if (StringUtils.equalsIgnoreCase(sDatePattern, DATE_FORMAT_YMD_WITHOUT_SLASH)) {
            return formatDate(parseDate(dateStr, DEFAULT_DATE_FORMAT), DATE_FORMAT_YMD_WITHOUT_SLASH);

        } else {
            return null;
        }
     }

    /**
     * Format the input date to a date time string in the following format: <br>
     * <code>dd/MM/yyyy HH:mm:ss.SSS</code>.
     * 
     * @param ts the TimeStamp value to be formatted into a date time string.
     * @return the formatted date time string; an empty String if the input date
     *         is <code>null</code> or if there is error during formatting.
     */
    public static String formatTimestampMillis (Timestamp ts) {
        return formatTimestampMillis(ts, TIMESTAMP_MILLIS_FORMAT);
    }

    /**
     * Format the input date to a date time string in the specified date
     * pattern.
     * 
     * @param ts the TimeStamp value to be formatted into a date time string.
     * @param sDatePattern pass in date pattern.
     * @return the formatted date time string; an empty String if the input date
     *         is <code>null</code> or if there is error during formatting.
     */
    public static String formatTimestampMillis (Timestamp ts,
            String sDatePattern) {
        if (ts == null) {
            return null;
        }
        SimpleDateFormat oFormat = new SimpleDateFormat(sDatePattern);
        oFormat.setLenient(false);
        return oFormat.format(ts);
    }

    /**
     * Parse the input date to a <code>java.sql.Timestamp</code> object. The
     * expected input date is of format <code>dd/MM/yyyy HH:mm:ss.SSS</code>
     * 
     * @param dateStr the date string.
     * @return the Timestamp instance created; <code>null</code> if the date
     *         string is <code>null</code> or it does not conform to the format
     *         <code>dd/MM/yyyy HH:mm:ss.SSS</code>
     */
    public static Timestamp parseTimestampMillis (String dateStr) {
        return parseTimestampMillis(dateStr, TIMESTAMP_MILLIS_FORMAT);
    }

    /**
     * Parse the input date to a <code>java.sql.Timestamp</code> object. The
     * expected input date is of format <code>dd/MM/yyyy HH:mm:ss.SSS</code>
     * 
     * @param dateStr the date string.
     * @param sDatePattern pass in date pattern.
     * @return the Timestamp instance created; <code>null</code> if the date
     *         string is <code>null</code> or it does not conform to the format
     *         <code>dd/MM/yyyy HH:mm:ss.SSS</code>
     */
    public static Timestamp parseTimestampMillis (String dateStr,
            String sDatePattern) {
        Timestamp ts = null;
        try {
            if (dateStr == null || dateStr.trim().equals("")) {
                return null;
            }
            SimpleDateFormat oFormat = new SimpleDateFormat(sDatePattern);
            oFormat.setLenient(false);
            Date date = oFormat.parse(dateStr);
            ts = new Timestamp(date.getTime());
        } catch (Exception e) {
            // Do nothing
        }
        return ts;
    }

    /**
     * Format the time string by the specified hour, minute, second as below
     * format: (25,13,14) -> "12:13:14" (12,13,14) -> "12:13:14" (12,13,"") ->
     * "12:13:00".
     * 
     * @param hour the hour
     * @param minute the minute
     * @param second the second
     * @return time string.
     */
    public static String formatTimeStr (String hour, String minute,
            String second) {
        try {
            int h = 0, m = 0, s = 0;
            if (StringUtils.isEmpty(hour)) {
                hour = TIME_STR_TWO_ZERO;
            } else {
                h = Integer.parseInt(hour);
            }
            if (StringUtils.isEmpty(minute)) {
                minute = TIME_STR_TWO_ZERO;
            } else {
                m = Integer.parseInt(minute);
            }
            if (StringUtils.isEmpty(second)) {
                second = TIME_STR_TWO_ZERO;
            } else {
                s = Integer.parseInt(second);
            }
            if (h < 0 || h > 24 || m < 0 || m > 59 || s < 0 || s > 59) {
                return null;
            }
            String hourStr = hour.length() > 1 ? hour : TIME_STR_ONE_ZERO
                    + hour;

            String minuteStr = minute.length() > 1 ? minute : TIME_STR_ONE_ZERO
                    + minute;

            String secondStr = second.length() > 1 ? second : TIME_STR_ONE_ZERO
                    + second;

            return hourStr + ":" + minuteStr + ":" + secondStr;
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * Get current time, format HH:MM.
     * 
     * @return
     */
    public static String getCurrentTime () {
        return formatDate(getCurrentTimestamp(), DEFAULT_TIME_FORMAT_SHORT);
    }

    /**
     * Get current date, format yyyy/MM/dd.
     * 
     * @return
     */
    public static String getCurrentDate () {
        return formatDate(getCurrentTimestamp());
    }

    /**
     * get timestamp by date and time
     * 
     * @param dateStr: format: yyyy/MM/dd
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Timestamp getTimestampByDateAndTime (String dateStr,
            int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(DateUtil.parseDate(dateStr, DateUtil.DATE_FORMAT_YMD_WITHOUT_SLASH));
        c.set(Calendar.HOUR, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        return new Timestamp(c.getTimeInMillis());
    }
    
    public static int getHourFromTimestamp(Timestamp ts){
        Calendar c = Calendar.getInstance();
        c.setTime(ts);
        return c.get(Calendar.HOUR_OF_DAY);
    }
    
    public static int getMinFromTimestamp(Timestamp ts){
        Calendar c = Calendar.getInstance();
        c.setTime(ts);
        return c.get(Calendar.MINUTE);
    }
    
    /**
     * Only for dd/MM/yyyy
     * @param date
     * @return
     */
    public static Date parseDateForCsv(String date){
        if(date != null){
            String[] arr = date.split("/");
            if(arr.length >= 3){
                try {
                    int day = Integer.parseInt(arr[0]);
                    int month = Integer.parseInt(arr[1])-1;
                    int year = Integer.parseInt(arr[2]);
                    Calendar c = Calendar.getInstance();
                    c.set(year, month, day);
                    return c.getTime();
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }
        return null;
    }
}
