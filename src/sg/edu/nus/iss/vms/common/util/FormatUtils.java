/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zaw
 */
public class FormatUtils {

    /**
     * Checks the given string for a valid email format "robert@rcreations.com".
     * @return true if no error was found.
     */
    public static boolean isEmailFormat(String emailAddress) {
        String expression = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String email1 = "user@domain.com";
        Boolean b = email1.matches(EMAIL_REGEX);
        System.out.println("is e-mail: " + email1 + " :Valid = " + b);
        String email2 = "user^domain.co.in";
        b = email2.matches(EMAIL_REGEX);
        System.out.println("is e-mail: " + email2
                + " :Valid = " + b);
    }
}
