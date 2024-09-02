package string;/*
 * Copyright
 * Andrei Razhkou
 */

public class String19 {

    /*
        Определить получена ли строка s2 циклическим сдвигом из s1

        erwat -> water
     */
    public static void main(String[] args) {
        System.out.println(solution1("erwat", "water"));
        System.out.println(solution1("erwta", "water"));
        System.out.println(solution1("aaaab", "baaaa"));
    }

    public static boolean solution1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        return (s1 + s1).contains(s2);
    }
}