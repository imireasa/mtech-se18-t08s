package sg.edu.nus.iss.vms.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class StringUtil extends StringUtils {
    
    private static Logger logger = Logger.getLogger(StringUtil.class);

    // Automatically generated variable: INT_39

    private static final int INT_39 = 39;

    // Automatically generated variable: INT_34

    private static final int INT_34 = 34;

    private static Vector<String> NON_KEY_WORDS = new Vector<String>(4);

    static {
        NON_KEY_WORDS.addElement("the");
        NON_KEY_WORDS.addElement("a");
        NON_KEY_WORDS.addElement("an");
        NON_KEY_WORDS.addElement("of");
    }

    /**
     * Utility class should not have public constructor.
     */
    private StringUtil () {
    }

    /**
     * Capitalizes a string, i.e. changing its first letter to uppercase.
     * 
     * @param str The String that needs to be capitalized.
     * @return The capitalized string.
     */
    public static String capitalize (String str) {
        if (str == null || str.length() == 0)
            return str;
        else
            return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * Fully capitalizes all words in a String, i.e. changing the first letter
     * of each and every word (except for non key words) in the string to
     * uppercase.
     * 
     * @param str The string to be fully capitalized.
     * @return The fully capitalized string.
     */
    public static String capitalizeAllWords (String str) {
        if (str == null || str.length() == 0)
            return str;

        StringTokenizer tokens = new StringTokenizer(str, " ");
        StringBuffer sb = new StringBuffer();
        String word;

        while (tokens.hasMoreTokens()) {
            word = tokens.nextToken();
            sb.append(' ');

            if (!NON_KEY_WORDS.contains(word)) {
                sb.append(word.substring(0, 1).toUpperCase());
                sb.append(word.substring(1));
            } else
                sb.append(word);
        }

        return sb.toString().substring(1);
    }

    /**
     * Combines the strings values in the string array into one single string,
     * delimited by the specified delimiter. An emtpy String is returned if the
     * given values array is of size 0.
     * 
     * @param values The strings to be combined.
     * @param delimiter The delimiter used to separate the different strings.
     * @return The resultant string combined from the string array separated by
     *         the specified delimiter. Return an emtpy String if the given
     *         values array is of size 0.
     */
    public static String combine (String[] values, String delimiter) {

        if (values == null) {
            throw new NullPointerException("values array is null");
        }

        if (values.length == 0) {
            return "";
        }

        StringBuffer result = new StringBuffer();

        for (int i = 1; i < values.length; i++) {
            result.append(delimiter);
            result.append(values[i]);
        }

        result.insert(0, values[0]);

        return result.toString();
    }

    /**
     * Removes redundant spaces (the second consecutive space onwards) from a
     * String.
     * 
     * @param str The String that needs to be compacted.
     * @return The String which has been compacted.
     */
    public static String compact (String str) {
        if (str == null || str.length() == 0)
            return str;

        int len = str.length();
        char[] buf = new char[len];
        StringBuffer sb = new StringBuffer();
        str.getChars(0, len, buf, 0);
        int i = 0;

        while (i < len) {
            if (buf[i] != ' ') /* Found the first space */
                sb.append(buf[i++]);
            else {
                sb.append(' ');
                while (i < len && buf[i] == ' ')
                    /* Skip the rest of the spaces */
                    i++;
            }
        }

        return sb.toString();
    }

    /**
     * If a string is null, return it as "".
     * 
     * @param str The String that needs to be checked for null value.
     * @return The String that is converted to appropriate string value.
     */
    public static String deNull (String str) {
        if (str == null)
            return "";
        return str;
    }

    /**
     * To return a string which is filled with a specified string. e.g.
     * duplicate("*", 5) returns "*****", duplicate("OK", 3) returns "OKOKOK"
     * repeated for given number of times
     * 
     * @param str String to be repeated/duplicated
     * @param times Number of time the string to be repeated/duplicated
     * @return The resulted string with <code>str</code> repeated the specified
     *         number of times.
     */
    public static String duplicate (String str, int times) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return (result.toString());
    }

    /**
     * Get the count of occurrences of the character in the target string.
     * 
     * @param str The String used to check for the character occurrenct count.
     * @param ch The character to be counted in the string.
     * @return Number of occurrences of the character in the target string.
     */
    public static int getCount (String str, char ch) {
        int pos;
        int count = 0;

        do {
            pos = str.indexOf(ch);

            if (pos != -1) {
                count++;

                if (pos != str.length())
                    str = str.substring(pos + 1, str.length());
                else
                    pos = -1;
            }

        } while (pos != -1);

        return count;
    }

    /**
     * Checks if the length of the string is of the length specified.
     * 
     * @param str The string to test for the length.
     * @param len The length that the string should conform to.
     * @return A boolean value that indicates if the string is of the length
     *         specified.
     */
    public static boolean isLengthEqual (String str, int len) {
        if (str == null) {
            return false;
        } // if (str == null)

        return (str.length() == len) ? true : false;
    }

    /**
     * Tests whether the specified string's length is less than or equal to the
     * specified length.
     * 
     * @param str The string to test for the length.
     * @param len The length that the string should conform to.
     * @return A boolean value that indicates if the string is at most the
     *         length specified.
     */
    public static boolean isLengthLessThan (String str, int len) {
        if (str == null) {
            return false;
        } // if (str == null)

        return (str.length() <= len) ? true : false;
    }

    /**
     * Returns true if the data is null or empty string.
     * 
     * @param data data
     * @return boolean
     */
    public static boolean isNullOrEmpty (String data) {
        return data == null || data.length() == 0;
    }

    /**
     * Returns true if the data is null or empty string array (length == 0).
     * 
     * @param data data
     * @return boolean
     */
    public static boolean isNullOrEmpty (String[] data) {
        return data == null || data.length == 0;
    }

    /**
     * Returns true if the data is null or blank string (with only whitespaces).
     * 
     * @param data data
     * @return boolean
     */
    public static boolean isNullOrBlank (String data) {
        return data == null || isBlank(data);
    }

    /**
     * Returns true if the data equals to data2 or both are null.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqual (String data1, String data2) {
        if (data1 == null && data2 == null)
            return true;
        else if (data1 != null)
            return data1.equals(data2);
        else
            return data2.equals(data1);
    }

    /**
     * Returns true if the data equals to data2 or both are null.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualTrim (String data1, String data2) {
        data1 = data1 == null ? data1 : data1.trim();
        data2 = data2 == null ? data2 : data2.trim();
        return isEqual(data1, data2);

    }

    /**
     * Returns true if the data equals to data2.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualNotNull (String data1, String data2) {
        if (data1 == null || data1.length() == 0 || data2 == null || data2.length() == 0)
            return false;
        else
            return data2.equals(data1);
    }

    /**
     * Returns true if the data equals to data2.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isBiggerThanZero (int data1, int data2) {
        return data1 > 0 || data2 > 0;

    }

    /**
     * add left space for input string.
     * 
     * @param data data
     * @return formatted string.
     */
    public static String padZeroFront (String data) {
        if (data.length() < 2) {
            data = "0" + data;
        }
        return data;
    }

    /**
     * Returns true if the data equals int 0.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualZero (int data1, int data2) {

        return data1 == 0 && data2 == 0;
    }

    /**
     * Returns true if the data equals to data2 or both are null.
     * 
     * @param data1 data1
     * @param data2 data2
     * @return boolean
     */
    public static boolean isEqualIgnoreCase (String data1, String data2) {
        if (data1 == null && data2 == null)
            return true;
        else if (data1 != null)
            return data1.equalsIgnoreCase(data2);
        else
            return data2.equalsIgnoreCase(data1);
    }

    /**
     * Remove all occurrences of the match in the target string.
     * 
     * @param str The String to be checked and have the occurrences of the
     *            matching String removed.
     * @param match The matching string.
     * @return The resultant string with all matching string removed.
     */
    public static String removeAllMatch (String str, String match) {

        if (str == null || match == null || str.length() == 0 || match.length() == 0) {
            return "";
        }

        StringBuffer newStr = new StringBuffer();

        int endpos = 0;
        for (int startpos = str.indexOf(match, endpos); startpos != -1; startpos = str.indexOf(match, endpos)) {
            newStr.append(str.substring(endpos, startpos));
            endpos = startpos + match.length();
        }

        newStr.append(str.substring(endpos));

        return newStr.toString();
    }

    /**
     * Replace the occurrence of a key within the existing string with the
     * required value.
     * 
     * @param str Existing String to be replace
     * @param key Key within the String to be searched and replaced
     * @param replacement The replaced value
     * @return The resulted string
     */
    public static String replaceAll (String str, String key, String replacement) {

        // Split the string with the key as the delimiter
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isNotEmpty(str)) {
            String[] parts = StringUtil.split(str, key);
            sb.append(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                sb.append(replacement + parts[i]);
            }
        }
        return sb.toString();
    }

    /**
     * Replaces the first substring of this string that matches the given key
     * with the given replacement.
     * 
     * @param str The String to be replaced
     * @param key Key within the String to be searched and replaced
     * @param replacement The String used to replace
     * @return The String with the first occurence of the key value replaced.
     */
    public static String replaceFirst (String str, String key, String replacement) {
        StringBuffer result = new StringBuffer(str);

        int pos = str.indexOf(key);

        if (pos >= 0) {
            result.replace(pos, pos + key.length(), replacement);
            // System.out.println( "result = " + result );
        }
        return result.toString();
    }

    /**
     * Replaces the last substring of this string that matches the given key
     * with the given replacement.
     * 
     * @param str The String to be replaced
     * @param key Key within the String to be searched and replaced
     * @param replacement The String used for replacement
     * @return The String with the last occurence of the key value replaced.
     */
    public static String replaceLast (String str, String key, String replacement) {
        StringBuffer result = new StringBuffer(str);

        int pos = str.lastIndexOf(key);

        if (pos >= 0) {
            result.replace(pos, pos + key.length(), replacement);
            //System.out.println("result = " + result);
        }
        return result.toString();
    }

    /**
     * Parse a string and split into various parts by the specified delimiters.
     * 
     * @param str the string to be split
     * @param delimiter delimiting character(s)
     * @return The string array containing the parts delimited by the specified
     *         delimiter.
     */
    public static String[] split (String str, String delimiter) {
        // tentatively allocate only vector of size 3.
        // if not enough, vector will increment 3 each time.
        Vector<String> result = new Vector<String>(3, 3);

        int index = 0;
        int pos = 0;
        int count = 0;

        while (true) {
            pos = str.indexOf(delimiter, index);

            // no more parts
            if (pos == -1) {
                result.add(count, str.substring(index));
                count++;
                break;
            }

            // put into the array
            result.add(count, str.substring(index, pos));

            // increment count
            count++;

            // must cater for delimiter with length > 1
            // so cannot just + 1
            index = pos + delimiter.length();

        } // parseString()

        // compact the array
        String[] tmp = new String[count];
        System.arraycopy(result.toArray(), 0, tmp, 0, count);

        result = null;
        return tmp;
    }

    /**
     * convert list value to a string.
     * 
     * @param s input string list
     * @param separator separator
     * @return String
     */
    public static String listToString (List<String> s, String separator) {
        return listToString(s, separator, 0);
    }

    /**
     * convert list value to a string.
     * 
     * @param oList oList
     * @param separator separator
     * @param separatorFrPos separatorFrPos
     * @return String
     */
    public static String listToString (List<String> oList, String separator, int separatorFrPos) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < oList.size(); i++) {
            if (i > separatorFrPos) {
                sb.append(separator);
            }
            sb.append(oList.get(i));
        }
        return sb.toString();
    }
    
    /**
     * convert list value to a string array.
     * 
     * @param list
     * @return
     */
    public static String[] listToString(List<String> list) {
        
        if (list != null && !list.isEmpty()) {
            
            String[] str = new String[list.size()];
            
            for (int i = 0; i < list.size(); i ++) {
                str[i] = list.get(i);
            }
            return str;
        }
        return null;
    }

    /**
     * check is the String array contain an input String.
     * 
     * @param array input array
     * @param s input String
     * @return boolean
     */
    public static boolean contains (String[] array, String s) {
        return (indexOf(array, s) > -1);
    }

    /**
     * get the index for input String from array.
     * 
     * @param array array
     * @param s string
     * @return index
     */
    public static int indexOf (String[] array, String s) {
        for (int i = 0; i < array.length; i++) {
            if (s != null && s.equals(array[i]))
                return i;
        }
        return -1;
    }


    /**
     * This method is used to escape SQL string in a like clause.
     * 
     * @param oldString oldString
     * @return escaped string
     */

    public static String escapeSQLString (String oldString) {
        if (oldString == null)
            return oldString;
        StringBuffer newString = new StringBuffer();
        char c;
        for (int i = 0; i < oldString.length(); i++) {
            c = oldString.charAt(i);
            switch (c) {
                case '\'':
                    // if( i+1== oldString.length() || i+1< oldString.length()
                    // &&
                    // oldString.charAt(i+1)!='\'')
                    newString.append("''");
                    break;
                case '%':
                    newString.append("/%");
                    break;
                case '_':
                    newString.append("/_");
                    break;
                case '/':
                    newString.append("//");
                    break;
                default:
                    newString.append(c);
            }
        }
        return "%" + newString + "%";
    }

    /**
     * For removing specified value from a array.
     * 
     * @param fieldList fieldList
     * @param exludeElement exludeElement
     * @return formated array.
     */
    public static String[] removeFromArray (String[] fieldList, String exludeElement) {
        String[] newList = new String[fieldList.length - 1];
        List<String> oldList = null;
        int j = 0;

        if (fieldList != null) {
            oldList = Arrays.asList(fieldList);
            if (!oldList.contains(exludeElement)) {
                return fieldList;
            }
            for (int i = 0; i < fieldList.length; i++) {
                if (!exludeElement.equals(fieldList[i])) {
                    newList[j] = fieldList[i];
                    j++;
                }
            }
            return newList;
        } else {
            return null;
        }
    }

    /**
     * check is the String can convert to integer.
     * 
     * @param s s
     * @return boolean
     */
    public static boolean isConvertableToInteger (String s) {
        if (isNullOrBlank(s))
            return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                return false;
        }

        return true;
    }

    /**
     * convert to uppercase.
     * 
     * @param list input list
     * @return converted array
     */
    public static String[] toUpperCase (String[] list) {
        if (isNullOrEmpty(list))
            return list;
        String[] newList = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i].toUpperCase();
        }
        return newList;
    }

    /**
     * The format method that for the String.
     * 
     * @param value the string value
     * @return the string format value, when the value is null, it returns empty
     *         string("")
     */
    public static String formatString (String value) {
        if (value == null) {
            value = "";
        }
        return value.trim();
    }

    /**
     * The format method that remove the single quote from string.
     * 
     * @param value the string value
     * @return the string format value, when the value is null, it returns empty
     *         string("")
     */
    public static String removeSingleQuote (String value) {
        if (value == null) {
            value = "";
        }
        return value.trim().replace("'", "");
    }

    /**
     * convert empty value to null.
     * 
     * @param str input String
     * @return converted value
     */
    public static String convertEmpty2Null (String str) {
        if (str == null || str.trim().equalsIgnoreCase(""))
            return null;
        return str;
    }

    /**
     * Get the parameters from URL address.
     * 
     * @param paramStr the parameter String. 
     * @return the parameter map.
     */
    public static Map<String, String> getParamMap(String paramStr){
        if(StringUtil.isEmpty(paramStr)){
            return null;
        }
        Map<String,String> map = new HashMap<String, String>();
        String[] params = paramStr.split("&");
        for(int i=0; i < params.length; i++){
            String[] tmpParam = params[i].split("=");
            if(tmpParam == null || tmpParam.length == 0){
                continue;
            }else if(tmpParam.length == 1){
                map.put(tmpParam[0].trim(), "");
            }else{
                map.put(tmpParam[0].trim(), tmpParam[1].trim());
            }
        }
        return map;
    }
    
    public static String urlEncode (String str) {
        if (str == null)
            return null;

        StringBuffer tmp = new StringBuffer();

        for (int i = 0; i < str.length(); ++i) {
            char a = str.charAt(i);
            if (((a < ':') && (a > '/')) || ((a < '[') && (a > '@'))
                    || ((a < '{') && (a > '`')) || (a == '_'))
                tmp.append(a);
            else if (a < '\16')
                tmp.append("%0" + Integer.toHexString(a));
            else
                tmp.append("%" + Integer.toHexString(a));
        }

        return tmp.toString();
    }

    /**
     * Compare two array lists, if any of the elements in elements1 matches to either one of 
     * the element in elements2, return true else return false.
     * 
     * @param elements1
     * @param elements2
     * @return
     */
    public static boolean compareStringLists(List<String> elements1, List<String> elements2) {
        for (String element1 : elements1) {
            for (String element2: elements2) {
                if (element1.equals(element2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return the dashed string "-" for Report when the data string is empty, or return data string.
     * 
     * @param data the data string
     * @return String
     */
    public static String returnDashedWhenStrIsEmpty(String data){
        return StringUtil.isNullOrBlank(data)? "-" : data ;
    }
    
    public static String covertHtmlStr(String source)
    {
      if(source == null)
          return null;

      return source.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("'", "&apos;").replaceAll("\"", "&quote;").replaceAll(" ", "&nbsp;").replaceAll("\n", "<br>");
    }

}
