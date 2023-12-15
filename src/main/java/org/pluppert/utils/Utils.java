package org.pluppert.utils;

public class Utils {
    static final String[] specialCharacters = new String[]{"+", "-", "&", "|", "!", "(", ")", "{", "}", "[", "]", "^", "~", "*", "?", ":", "'", "\"","\\"};
    static final String[] alphabetCharacters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q","r", "s", "t", "u", "v", "w", "x", "y", "z", "å", "ä", "ö"};
    public boolean isNullOrEmpty(String s) {
        if (s == null) return true;
        return s.isEmpty();
    }
    public boolean invalidPassword(String s) {
        if (isNullOrEmpty(s)) {
            return true;
        } else if (s.length() < 8) {
            return true;
        } else if (noSpecialCharacter(s)) {
            return true;
        } else return missingUpperOrLowerCase(s);
    }

    public boolean noSpecialCharacter(String s) {
        boolean result = true;
        for ( String sc : specialCharacters ) {
            result = !s.contains(sc);
            if (!result) break;
        }
        return result;
    }

    public boolean missingUpperOrLowerCase(String s) {
        boolean noLower = true;
        boolean noUpper = true;
        for ( String c : alphabetCharacters ) {
            noLower = !s.contains(c);
            if (!noLower) break;
        }
        if (noLower) {
            for ( String c : alphabetCharacters ) {
                noUpper = !s.contains(c.toUpperCase());
                if (!noUpper) break;
            }
        }
        return noLower && noUpper;
    }
}
