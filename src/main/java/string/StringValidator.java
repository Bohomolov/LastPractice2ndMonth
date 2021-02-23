package string;

import utils.Constants;

public class StringValidator {

    public boolean chekString(String string) {
        if (string == null || string.length() < 2) {
            return false;
        }
        String newStr = string;
        newStr = newStr.replaceAll(Constants.REGEX, "");

        if (newStr.length() > 0) {
            return false;
        }
        if (string.charAt(0) == ']' || string.charAt(0) == ')' || string.charAt(0) == '}') {
            return false;
        }
        StringBuilder str = new StringBuilder(string);
        return chekString(str, 0);
    }

    private boolean chekString(StringBuilder string, int count) {
        if (string.length() == 0) {
            return true;
        }
        if (count == string.length()) {
            return false;
        }
        boolean closed = string.charAt(count) == '}' || string.charAt(count) == ']' || string.charAt(count) == ')';

        if (closed) {
            if (string.charAt(count) == ')') {
                if (string.charAt(count - 1) == '(') {
                    string.delete(count - 1, count + 1);
                } else return false;

            } else if (string.charAt(count) == ']') {
                if (string.charAt(count - 1) == '[') {
                    string.delete(count - 1, count + 1);
                } else return false;
            } else if (string.charAt(count) == '}') {
                if (string.charAt(count - 1) == '{') {
                    string.delete(count - 1, count + 1);
                } else return false;
            }
            count -= 2;
        }
        return chekString(string, ++count);
    }
}
