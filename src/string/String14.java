package string;/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.HashMap;
import java.util.Map;

public class String14 {

    // является ли строка перестановкой палиндрома
    public static void main(String[] args) {
        System.out.println(solution1("tact coa"));
        System.out.println(solution1("asd  sdfas"));
        System.out.println(solution1("aattf h"));

        System.out.println();
    }

    public static boolean solution1(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            if (c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        boolean flag = false;
        for(Character c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}