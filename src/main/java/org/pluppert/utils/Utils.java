package org.pluppert.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public boolean isNullOrEmpty(String s) {
        if (s == null) return true;
        return s.isEmpty();
    }
    public boolean invalidPassword(String s) {
        if (isNullOrEmpty(s)) {
            return true;
        } else if (s.length() < 8) {
            return true;
        } else {
            String regex = "^(?=.*[a-zäöå])(?=."
                    + "*[A-ZÄÖÅ])(?=.*\\d)"
                    + "(?=.*[-+=/\"'¨~|<>{}¤£_!@#$%^&*., ?]).+$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s);

            return !m.matches();
        }
    }
}
