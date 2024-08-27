/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class String11 {

    // Все ли символы встречаются только один раз
    public static void main(String[] args) {
        System.out.println(solution1("wertyt"));
        System.out.println(solution1("asdfghj"));
        System.out.println(solution1("eeee"));

        System.out.println();

        System.out.println(solution2("wertyt"));
        System.out.println(solution2("asdfghj"));
        System.out.println(solution2("eeee"));
    }

    public static boolean solution1(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Set<Character> symbols = new HashSet<>();
        for(Character c : s.toCharArray()) {
            if (symbols.contains(c)) {
                return false;
            } else {
                symbols.add(c);
            }
        }
        return true;
    }

    // without data structure
    public static boolean solution2(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                return false;
            }
        }
        return true;
    }


}