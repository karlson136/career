/*
 * Copyright
 * Andrei Razhkou
 */

public class String15 {

    // Есть три модификации строки: вставка символа, удаление, замена.
    // Определить что строки находятся на расстоянии одной модификация
    public static void main(String[] args) {
        System.out.println(solution1("pale", "ple"));
        System.out.println(solution1("pales", "pale"));
        System.out.println(solution1("pale", "bale"));
        System.out.println(solution1("pale", "bake"));
        System.out.println(solution1("pale", "palrhh"));

        System.out.println();
    }

    public static boolean solution1(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        return helper(s1, s2, false);
    }

    public static boolean helper(String s1, String s2, boolean flag) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        int minLength = Math.min(s1.length(), s2.length());

        for(int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (flag) {
                    return false;
                }
                return helper(s1.substring(i + 1), s2.substring(i + 1), true)
                        || helper(s1.substring(i + 1), s2.substring(i), true)
                        || helper(s1.substring(i), s2.substring(i + 1), true);
            }
        }

        return true;
    }
}