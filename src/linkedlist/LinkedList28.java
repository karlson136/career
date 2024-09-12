/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;


import static linkedlist.LinkedListUtils.createNodeOneDirection;

public class LinkedList28 {

    // return start node of the circular linked list
    // 1 -> 2 -> 3 -> 4 -> 5 -> 3 ----> 3
    public static void main(String[] args) {
        NodeOneDirection list = createNodeOneDirection(1, 2, 3, 4, 5);
        System.out.println(isCircular(list));

        NodeOneDirection third = list.next.next;
        NodeOneDirection last = list.next.next.next.next;
        last.next = third;
        System.out.println(isCircular(list));


        NodeOneDirection list2 = createNodeOneDirection(1, 2, 3, 4, 5);
        NodeOneDirection last2 = list2.next.next.next.next;
        last2.next = list2;
        System.out.println(isCircular(list2));
    }

    public static NodeOneDirection isCircular(NodeOneDirection list1) {
        if (list1 == null || list1.next == null || list1.next.next == null) {
            return null;
        }

        NodeOneDirection head = list1;
        NodeOneDirection slow = head;
        NodeOneDirection fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}