package string;/*
 * Copyright
 * Andrei Razhkou
 */

public class String16 {

    // Сжать строку: aaBccccDDD -> a2B1c4D3; aabbcc -> a2b2c2 -> aabbcc
    public static void main(String[] args) {
        System.out.println(solution1("aaBccccDDD"));
        System.out.println(solution1("aabbcc"));

        System.out.println();
    }

    public static String solution1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char curChar = s.charAt(0);
        int curLength = 1;

        for(int i = 1; i < s.length(); i++) {
            if(curChar == s.charAt(i)) {
                curLength++;
            } else {
                sb.append(curChar).append(curLength);
                curChar = s.charAt(i);
                curLength = 1;
            }
        }
        sb.append(curChar).append(curLength);

        String res = sb.toString();
        return s.length() <= res.length() ? s : res;
    }
}