/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;


import static linkedlist.LinkedListUtils.createNodeOneDirection;
import static linkedlist.LinkedListUtils.print;

public class LinkedList27 {

    // ia the lists intersects?
    public static void main(String[] args) {
        System.out.println(isIntersects(createNodeOneDirection(1, 2, 3), createNodeOneDirection(4, 2, 3)));

        NodeOneDirection baseList = createNodeOneDirection(2, 3);
        NodeOneDirection list1 = new NodeOneDirection(1);
        NodeOneDirection list2 = new NodeOneDirection(4);
        NodeOneDirection list3 = new NodeOneDirection(5);

        list1.next = baseList;
        list2.next = baseList;
        list3.next = list2;
        System.out.println(isIntersects(list1, list3));
    }

    public static NodeOneDirection isIntersects(NodeOneDirection list1, NodeOneDirection list2) {
        print(list1);
        print(list2);

        int len1 = len(list1);
        int len2 = len(list2);

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                list1 = list1.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                list2 = list2.next;
            }
        }

        while (list1 != null && list2 != null) {
            if (list1 == list2) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return null;
    }

    private static int len(NodeOneDirection list) {
        if (list == null) return 0;
        return len(list.next) + 1;
    }
}