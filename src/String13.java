/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class String13 {

    // заменить все пробелы на %20
    public static void main(String[] args) {
        System.out.println(solution1("asd"));
        System.out.println(solution1("asd  sdfas  "));

        System.out.println();

        System.out.println(solution2("asd"));
        System.out.println(solution2("asd  sdfas  "));
    }

    public static String solution1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        return s.replaceAll(" ", "%20");
    }

    public static String solution2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}