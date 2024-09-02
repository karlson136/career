/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;

import java.util.HashSet;
import java.util.Set;

import static linkedlist.LinkedListUtils.createNodeOneDirection;
import static linkedlist.LinkedListUtils.print;

public class LinkedList21 {

    // remove duplicates from unordered list
    public static void main(String[] args) {
        removeDuplicates(createNodeOneDirection(1, 7, 3, 6, 2));
        removeDuplicates(createNodeOneDirection(1, 7, 2, 6, 2));
        removeDuplicates(createNodeOneDirection(1, 1, 1, 1, 1));
        removeDuplicates(createNodeOneDirection(2, 1, 2, 2, 1));

        System.out.println("Without additional memory");

        removeDuplicates2(createNodeOneDirection(1, 7, 3, 6, 2));
        removeDuplicates2(createNodeOneDirection(1, 7, 2, 6, 2));
        removeDuplicates2(createNodeOneDirection(1, 1, 1, 1, 1));
        removeDuplicates2(createNodeOneDirection(2, 1, 2, 2, 1));
    }

    public static void removeDuplicates(NodeOneDirection head) {
        print(head);

        NodeOneDirection node = head;
        if (node != null) {
            Set<Integer> elems = new HashSet<>();
            elems.add(node.data);
            while (node.next != null) {
                if (elems.contains(node.next.data)) {
                    if (node.next.next != null) {
                        node.next = node.next.next;
                    } else {
                        node.next = null;
                    }
                } else {
                    elems.add(node.next.data);
                    node = node.next;
                }
            }
        }

        print(head);
        System.out.println();
    }

    // without additional memory
    public static void removeDuplicates2(NodeOneDirection head) {
        print(head);

        if (head != null && head.next != null) {
            NodeOneDirection current = head;
            while (current != null) {
                NodeOneDirection runner = current;
                while (runner.next != null) {
                    if (runner.next.data == current.data) {
                        runner.next = runner.next.next;
                    } else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
        }

        print(head);
        System.out.println();
    }

}