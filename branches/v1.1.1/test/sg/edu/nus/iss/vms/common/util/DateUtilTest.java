/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
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
                TimeZone tz = TimeZone.getTimeZone("Asia/Singapore");
                Calendar calendar = Calendar.getInstance(tz);
                Date expResult = calendar.getTime();                
                Date result = DateUtil.getDate();
                assertTrue(expResult.getTime() < result.getTime());
        }

        /**
         * Test of getDate method, of class DateUtil.
         */
        @Test
        public void testGetDate_3args() {
                System.out.println("getDate");
                int year = 2011;
                int month = 12;
                int day = 25;

                Calendar cal = Calendar.getInstance();
                cal.clear();
                cal.set(year, month - 1, day);

                Date expResult = cal.getTime();
                Date result = DateUtil.getDate(year, month, day);
                assertEquals(expResult, result);

        }

        /**
         * Test of parseDate method, of class DateUtil.
         */
        @Test
        public void testParseDate_String() {
                System.out.println("parseDate");
                String iDate = "15-12-2011";
                SimpleDateFormat oFormat = new SimpleDateFormat("dd-MM-yyyy");
                oFormat.setLenient(false);
                try {
                        Date expResult = oFormat.parse(iDate);
                        Date result = DateUtil.parseDate(iDate);
                        assertEquals(expResult, result);
                } catch (Exception ex) {
                        fail(ex.toString());
                }

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
                assertEquals(iDate, sDatePattern);
                assertNull(expResult);
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
                assertEquals(expResult, "");
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
                assertEquals(expResult, sDatePattern);

        }

        
}
