/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;


import static linkedlist.LinkedListUtils.createNodeOneDirection;
import static linkedlist.LinkedListUtils.print;

public class LinkedList26 {

    // ia the list a palindrome?
    public static void main(String[] args) {
        System.out.println(isPalindrome(createNodeOneDirection(1, 2, 1)));
        System.out.println(isPalindrome(createNodeOneDirection(9, 9)));
        System.out.println(isPalindrome(createNodeOneDirection(1)));
        System.out.println(isPalindrome(createNodeOneDirection(1, 2, 3)));
    }

    public static boolean isPalindrome(NodeOneDirection list) {
        print(list);
        if (list == null) {
            return false;
        } else if (list.next == null) {
            return true;
        }

        NodeOneDirection reverseList = null;
        NodeOneDirection iterate = list;

        while (iterate != null) {
            NodeOneDirection temp = new NodeOneDirection(iterate.data);
            if (reverseList == null) {
                reverseList = temp;
            } else {
                temp.next = reverseList;
                reverseList = temp;
            }
            iterate = iterate.next;
        }

        while (list != null) {
            if (list.data != reverseList.data) {
                return false;
            }
            list = list.next;
            reverseList = reverseList.next;
        }
        return true;
    }
}