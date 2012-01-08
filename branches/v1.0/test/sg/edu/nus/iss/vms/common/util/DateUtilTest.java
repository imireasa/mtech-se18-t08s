/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.util;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zaw
 */
public class DateUtilTest {
    
    public DateUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDate method, of class DateUtil.
     */
    @Test
    public void testGetDate_0args() {
        System.out.println("getDate");
        Date expResult = null;
        Date result = DateUtil.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class DateUtil.
     */
    @Test
    public void testGetDate_3args() {
        System.out.println("getDate");
        int year = 0;
        int month = 0;
        int day = 0;
        Date expResult = null;
        Date result = DateUtil.getDate(year, month, day);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDate method, of class DateUtil.
     */
    @Test
    public void testParseDate_String() {
        System.out.println("parseDate");
        String iDate = "";
        Date expResult = null;
        Date result = DateUtil.parseDate(iDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDate method, of class DateUtil.
     */
    @Test
    public void testParseDate_String_String() {
        System.out.println("parseDate");
        String iDate = "";
        String sDatePattern = "";
        Date expResult = null;
        Date result = DateUtil.parseDate(iDate, sDatePattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatDate method, of class DateUtil.
     */
    @Test
    public void testFormatDate_Date() {
        System.out.println("formatDate");
        Date iDate = null;
        String expResult = "";
        String result = DateUtil.formatDate(iDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatDate method, of class DateUtil.
     */
    @Test
    public void testFormatDate_Date_String() {
        System.out.println("formatDate");
        Date iDate = null;
        String sDatePattern = "";
        String expResult = "";
        String result = DateUtil.formatDate(iDate, sDatePattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class DateUtil.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        Date iDate = null;
        String iTime = "";
        Date expResult = null;
        Date result = DateUtil.setTime(iDate, iTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatTime method, of class DateUtil.
     */
    @Test
    public void testFormatTime() {
        System.out.println("formatTime");
        Date oDate = null;
        String expResult = "";
        String result = DateUtil.formatTime(oDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTimestamp method, of class DateUtil.
     */
    @Test
    public void testGetCurrentTimestamp() {
        System.out.println("getCurrentTimestamp");
        Timestamp expResult = null;
        Timestamp result = DateUtil.getCurrentTimestamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareSystemDate method, of class DateUtil.
     */
    @Test
    public void testCompareSystemDate() {
        System.out.println("compareSystemDate");
        Date date1 = null;
        int expResult = 0;
        int result = DateUtil.compareSystemDate(date1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareDates method, of class DateUtil.
     */
    @Test
    public void testCompareDates() {
        System.out.println("compareDates");
        Date date1 = null;
        Date date2 = null;
        int expResult = 0;
        int result = DateUtil.compareDates(date1, date2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDate method, of class DateUtil.
     */
    @Test
    public void testIsValidDate_3args() {
        System.out.println("isValidDate");
        int year = 0;
        int month = 0;
        int day = 0;
        boolean expResult = false;
        boolean result = DateUtil.isValidDate(year, month, day);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDate method, of class DateUtil.
     */
    @Test
    public void testIsValidDate_String() {
        System.out.println("isValidDate");
        String dateStr = "";
        boolean expResult = false;
        boolean result = DateUtil.isValidDate(dateStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidTime method, of class DateUtil.
     */
    @Test
    public void testIsValidTime() {
        System.out.println("isValidTime");
        int hour = 0;
        int minute = 0;
        boolean expResult = false;
        boolean result = DateUtil.isValidTime(hour, minute);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class DateUtil.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Date date = null;
        int field = 0;
        int amount = 0;
        Date expResult = null;
        Date result = DateUtil.add(date, field, amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatDateStr method, of class DateUtil.
     */
    @Test
    public void testFormatDateStr() {
        System.out.println("formatDateStr");
        String dateStr = "";
        String sDatePattern = "";
        String expResult = "";
        String result = DateUtil.formatDateStr(dateStr, sDatePattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatDateStrWithoutSlash method, of class DateUtil.
     */
    @Test
    public void testFormatDateStrWithoutSlash() {
        System.out.println("formatDateStrWithoutSlash");
        String dateStr = "";
        String sDatePattern = "";
        String expResult = "";
        String result = DateUtil.formatDateStrWithoutSlash(dateStr, sDatePattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatTimestampMillis method, of class DateUtil.
     */
    @Test
    public void testFormatTimestampMillis_Timestamp() {
        System.out.println("formatTimestampMillis");
        Timestamp ts = null;
        String expResult = "";
        String result = DateUtil.formatTimestampMillis(ts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatTimestampMillis method, of class DateUtil.
     */
    @Test
    public void testFormatTimestampMillis_Timestamp_String() {
        System.out.println("formatTimestampMillis");
        Timestamp ts = null;
        String sDatePattern = "";
        String expResult = "";
        String result = DateUtil.formatTimestampMillis(ts, sDatePattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseTimestampMillis method, of class DateUtil.
     */
    @Test
    public void testParseTimestampMillis_String() {
        System.out.println("parseTimestampMillis");
        String dateStr = "";
        Timestamp expResult = null;
        Timestamp result = DateUtil.parseTimestampMillis(dateStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseTimestampMillis method, of class DateUtil.
     */
    @Test
    public void testParseTimestampMillis_String_String() {
        System.out.println("parseTimestampMillis");
        String dateStr = "";
        String sDatePattern = "";
        Timestamp expResult = null;
        Timestamp result = DateUtil.parseTimestampMillis(dateStr, sDatePattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatTimeStr method, of class DateUtil.
     */
    @Test
    public void testFormatTimeStr() {
        System.out.println("formatTimeStr");
        String hour = "";
        String minute = "";
        String second = "";
        String expResult = "";
        String result = DateUtil.formatTimeStr(hour, minute, second);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTime method, of class DateUtil.
     */
    @Test
    public void testGetCurrentTime() {
        System.out.println("getCurrentTime");
        String expResult = "";
        String result = DateUtil.getCurrentTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentDate method, of class DateUtil.
     */
    @Test
    public void testGetCurrentDate() {
        System.out.println("getCurrentDate");
        String expResult = "";
        String result = DateUtil.getCurrentDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimestampByDateAndTime method, of class DateUtil.
     */
    @Test
    public void testGetTimestampByDateAndTime() {
        System.out.println("getTimestampByDateAndTime");
        String dateStr = "";
        int hour = 0;
        int minute = 0;
        int second = 0;
        Timestamp expResult = null;
        Timestamp result = DateUtil.getTimestampByDateAndTime(dateStr, hour, minute, second);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHourFromTimestamp method, of class DateUtil.
     */
    @Test
    public void testGetHourFromTimestamp() {
        System.out.println("getHourFromTimestamp");
        Timestamp ts = null;
        int expResult = 0;
        int result = DateUtil.getHourFromTimestamp(ts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinFromTimestamp method, of class DateUtil.
     */
    @Test
    public void testGetMinFromTimestamp() {
        System.out.println("getMinFromTimestamp");
        Timestamp ts = null;
        int expResult = 0;
        int result = DateUtil.getMinFromTimestamp(ts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDateForCsv method, of class DateUtil.
     */
    @Test
    public void testParseDateForCsv() {
        System.out.println("parseDateForCsv");
        String date = "";
        Date expResult = null;
        Date result = DateUtil.parseDateForCsv(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthStartDate method, of class DateUtil.
     */
    @Test
    public void testGetMonthStartDate() {
        System.out.println("getMonthStartDate");
        Date d = null;
        String expResult = "";
        String result = DateUtil.getMonthStartDate(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthEndDate method, of class DateUtil.
     */
    @Test
    public void testGetMonthEndDate() {
        System.out.println("getMonthEndDate");
        Date d = null;
        String expResult = "";
        String result = DateUtil.getMonthEndDate(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
