/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.util;

import java.util.List;
import java.util.Map;
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
public class StringUtilTest {
    
    public StringUtilTest() {
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
     * Test of capitalize method, of class StringUtil.
     */
    @Test
    public void testCapitalize() {
        System.out.println("capitalize");
        String str = "";
        String expResult = "";
        String result = StringUtil.capitalize(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of capitalizeAllWords method, of class StringUtil.
     */
    @Test
    public void testCapitalizeAllWords() {
        System.out.println("capitalizeAllWords");
        String str = "";
        String expResult = "";
        String result = StringUtil.capitalizeAllWords(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of combine method, of class StringUtil.
     */
    @Test
    public void testCombine() {
        System.out.println("combine");
        String[] values = null;
        String delimiter = "";
        String expResult = "";
        String result = StringUtil.combine(values, delimiter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compact method, of class StringUtil.
     */
    @Test
    public void testCompact() {
        System.out.println("compact");
        String str = "";
        String expResult = "";
        String result = StringUtil.compact(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deNull method, of class StringUtil.
     */
    @Test
    public void testDeNull() {
        System.out.println("deNull");
        String str = "";
        String expResult = "";
        String result = StringUtil.deNull(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of duplicate method, of class StringUtil.
     */
    @Test
    public void testDuplicate() {
        System.out.println("duplicate");
        String str = "";
        int times = 0;
        String expResult = "";
        String result = StringUtil.duplicate(str, times);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class StringUtil.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        String str = "";
        char ch = ' ';
        int expResult = 0;
        int result = StringUtil.getCount(str, ch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLengthEqual method, of class StringUtil.
     */
    @Test
    public void testIsLengthEqual() {
        System.out.println("isLengthEqual");
        String str = "";
        int len = 0;
        boolean expResult = false;
        boolean result = StringUtil.isLengthEqual(str, len);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLengthLessThan method, of class StringUtil.
     */
    @Test
    public void testIsLengthLessThan() {
        System.out.println("isLengthLessThan");
        String str = "";
        int len = 0;
        boolean expResult = false;
        boolean result = StringUtil.isLengthLessThan(str, len);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNullOrEmpty method, of class StringUtil.
     */
    @Test
    public void testIsNullOrEmpty_String() {
        System.out.println("isNullOrEmpty");
        String data = "";
        boolean expResult = false;
        boolean result = StringUtil.isNullOrEmpty(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNullOrEmpty method, of class StringUtil.
     */
    @Test
    public void testIsNullOrEmpty_StringArr() {
        System.out.println("isNullOrEmpty");
        String[] data = null;
        boolean expResult = false;
        boolean result = StringUtil.isNullOrEmpty(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNullOrBlank method, of class StringUtil.
     */
    @Test
    public void testIsNullOrBlank() {
        System.out.println("isNullOrBlank");
        String data = "";
        boolean expResult = false;
        boolean result = StringUtil.isNullOrBlank(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqual method, of class StringUtil.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        String data1 = "";
        String data2 = "";
        boolean expResult = false;
        boolean result = StringUtil.isEqual(data1, data2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqualTrim method, of class StringUtil.
     */
    @Test
    public void testIsEqualTrim() {
        System.out.println("isEqualTrim");
        String data1 = "";
        String data2 = "";
        boolean expResult = false;
        boolean result = StringUtil.isEqualTrim(data1, data2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqualNotNull method, of class StringUtil.
     */
    @Test
    public void testIsEqualNotNull() {
        System.out.println("isEqualNotNull");
        String data1 = "";
        String data2 = "";
        boolean expResult = false;
        boolean result = StringUtil.isEqualNotNull(data1, data2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBiggerThanZero method, of class StringUtil.
     */
    @Test
    public void testIsBiggerThanZero() {
        System.out.println("isBiggerThanZero");
        int data1 = 0;
        int data2 = 0;
        boolean expResult = false;
        boolean result = StringUtil.isBiggerThanZero(data1, data2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of padZeroFront method, of class StringUtil.
     */
    @Test
    public void testPadZeroFront() {
        System.out.println("padZeroFront");
        String data = "";
        String expResult = "";
        String result = StringUtil.padZeroFront(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqualZero method, of class StringUtil.
     */
    @Test
    public void testIsEqualZero() {
        System.out.println("isEqualZero");
        int data1 = 0;
        int data2 = 0;
        boolean expResult = false;
        boolean result = StringUtil.isEqualZero(data1, data2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqualIgnoreCase method, of class StringUtil.
     */
    @Test
    public void testIsEqualIgnoreCase() {
        System.out.println("isEqualIgnoreCase");
        String data1 = "";
        String data2 = "";
        boolean expResult = false;
        boolean result = StringUtil.isEqualIgnoreCase(data1, data2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllMatch method, of class StringUtil.
     */
    @Test
    public void testRemoveAllMatch() {
        System.out.println("removeAllMatch");
        String str = "";
        String match = "";
        String expResult = "";
        String result = StringUtil.removeAllMatch(str, match);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replaceAll method, of class StringUtil.
     */
    @Test
    public void testReplaceAll() {
        System.out.println("replaceAll");
        String str = "";
        String key = "";
        String replacement = "";
        String expResult = "";
        String result = StringUtil.replaceAll(str, key, replacement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replaceFirst method, of class StringUtil.
     */
    @Test
    public void testReplaceFirst() {
        System.out.println("replaceFirst");
        String str = "";
        String key = "";
        String replacement = "";
        String expResult = "";
        String result = StringUtil.replaceFirst(str, key, replacement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replaceLast method, of class StringUtil.
     */
    @Test
    public void testReplaceLast() {
        System.out.println("replaceLast");
        String str = "";
        String key = "";
        String replacement = "";
        String expResult = "";
        String result = StringUtil.replaceLast(str, key, replacement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of split method, of class StringUtil.
     */
    @Test
    public void testSplit() {
        System.out.println("split");
        String str = "";
        String delimiter = "";
        String[] expResult = null;
        String[] result = StringUtil.split(str, delimiter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listToString method, of class StringUtil.
     */
    @Test
    public void testListToString_List_String() {
        System.out.println("listToString");
        List<String> s = null;
        String separator = "";
        String expResult = "";
        String result = StringUtil.listToString(s, separator);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listToString method, of class StringUtil.
     */
    @Test
    public void testListToString_3args() {
        System.out.println("listToString");
        List<String> oList = null;
        String separator = "";
        int separatorFrPos = 0;
        String expResult = "";
        String result = StringUtil.listToString(oList, separator, separatorFrPos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listToString method, of class StringUtil.
     */
    @Test
    public void testListToString_List() {
        System.out.println("listToString");
        List<String> list = null;
        String[] expResult = null;
        String[] result = StringUtil.listToString(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class StringUtil.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String[] array = null;
        String s = "";
        boolean expResult = false;
        boolean result = StringUtil.contains(array, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class StringUtil.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        String[] array = null;
        String s = "";
        int expResult = 0;
        int result = StringUtil.indexOf(array, s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escapeSQLString method, of class StringUtil.
     */
    @Test
    public void testEscapeSQLString() {
        System.out.println("escapeSQLString");
        String oldString = "";
        String expResult = "";
        String result = StringUtil.escapeSQLString(oldString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromArray method, of class StringUtil.
     */
    @Test
    public void testRemoveFromArray() {
        System.out.println("removeFromArray");
        String[] fieldList = null;
        String exludeElement = "";
        String[] expResult = null;
        String[] result = StringUtil.removeFromArray(fieldList, exludeElement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConvertableToInteger method, of class StringUtil.
     */
    @Test
    public void testIsConvertableToInteger() {
        System.out.println("isConvertableToInteger");
        String s = "";
        boolean expResult = false;
        boolean result = StringUtil.isConvertableToInteger(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toUpperCase method, of class StringUtil.
     */
    @Test
    public void testToUpperCase() {
        System.out.println("toUpperCase");
        String[] list = null;
        String[] expResult = null;
        String[] result = StringUtil.toUpperCase(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatString method, of class StringUtil.
     */
    @Test
    public void testFormatString() {
        System.out.println("formatString");
        String value = "";
        String expResult = "";
        String result = StringUtil.formatString(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSingleQuote method, of class StringUtil.
     */
    @Test
    public void testRemoveSingleQuote() {
        System.out.println("removeSingleQuote");
        String value = "";
        String expResult = "";
        String result = StringUtil.removeSingleQuote(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertEmpty2Null method, of class StringUtil.
     */
    @Test
    public void testConvertEmpty2Null() {
        System.out.println("convertEmpty2Null");
        String str = "";
        String expResult = "";
        String result = StringUtil.convertEmpty2Null(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParamMap method, of class StringUtil.
     */
    @Test
    public void testGetParamMap() {
        System.out.println("getParamMap");
        String paramStr = "";
        Map expResult = null;
        Map result = StringUtil.getParamMap(paramStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of urlEncode method, of class StringUtil.
     */
    @Test
    public void testUrlEncode() {
        System.out.println("urlEncode");
        String str = "";
        String expResult = "";
        String result = StringUtil.urlEncode(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareStringLists method, of class StringUtil.
     */
    @Test
    public void testCompareStringLists() {
        System.out.println("compareStringLists");
        List<String> elements1 = null;
        List<String> elements2 = null;
        boolean expResult = false;
        boolean result = StringUtil.compareStringLists(elements1, elements2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnDashedWhenStrIsEmpty method, of class StringUtil.
     */
    @Test
    public void testReturnDashedWhenStrIsEmpty() {
        System.out.println("returnDashedWhenStrIsEmpty");
        String data = "";
        String expResult = "";
        String result = StringUtil.returnDashedWhenStrIsEmpty(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of covertHtmlStr method, of class StringUtil.
     */
    @Test
    public void testCovertHtmlStr() {
        System.out.println("covertHtmlStr");
        String source = "";
        String expResult = "";
        String result = StringUtil.covertHtmlStr(source);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
