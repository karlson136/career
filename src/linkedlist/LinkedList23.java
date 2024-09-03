/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;


import java.util.LinkedList;

import static linkedlist.LinkedListUtils.createNodeOneDirection;
import static linkedlist.LinkedListUtils.print;

public class LinkedList23 {

    // remove k-th element from the middle. We have access to k-th only
    public static void main(String[] args) {
        NodeOneDirection nodeOneDirection = createNodeOneDirection(1, 2, 3, 4, 5);
        print(nodeOneDirection);
        removeElement(nodeOneDirection.next.next);
        print(nodeOneDirection);
    }

    public static void removeElement(NodeOneDirection node) {
        if (node == null || node.next == null) {
            return;
        }

        NodeOneDirection temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
    }
}