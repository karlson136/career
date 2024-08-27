/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.*;

public class String12 {

    // является ли одна строка перестановкой другой
    public static void main(String[] args) {
        System.out.println(solution1("asd", "dsa"));
        System.out.println(solution1("asd", "dsa1"));

        System.out.println();

        System.out.println(solution2("asd", "dsa"));
        System.out.println(solution2("asd", "dsa1"));
    }

    public static boolean solution1(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static boolean solution2(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Character c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        return map.values().stream().noneMatch(integer -> integer > 0);
    }
}