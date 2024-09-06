/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;


import static linkedlist.LinkedListUtils.createNodeOneDirection;
import static linkedlist.LinkedListUtils.print;

public class LinkedList24 {

    // remove k-th element from the middle. We have access to k-th only
    public static void main(String[] args) {
        splitElements(createNodeOneDirection(4, 2, 1, 3, 5), 2);
        splitElements(createNodeOneDirection(4, 2, 1, 3, 5), 1);
        splitElements(createNodeOneDirection(4, 2, 1, 3, 5), 5);
        splitElements(createNodeOneDirection(1, 1, 1, 1, 1), 1);
        splitElements(createNodeOneDirection(1, 1, 1, 1, 1), 0);
        splitElements(createNodeOneDirection(1, 1, 1, 1, 1), 5);
    }

    public static void splitElements(NodeOneDirection node, int key) {
        System.out.println(key);
        print(node);

        NodeOneDirection less = null;
        NodeOneDirection lessHead = null;
        NodeOneDirection great = null;
        NodeOneDirection greatHead = null;

        while (node != null) {
            NodeOneDirection next = node.next;
            node.next = null;
            if (node.data < key) {
                if (less == null) {
                    less = node;
                    lessHead = less;
                } else {
                    less.next = node;
                    less = less.next;
                }
            } else {
                if (great == null) {
                    great = node;
                    greatHead = node;
                } else {
                    great.next = node;
                    great = great.next;
                }
            }
            node = next;
        }
        if (less != null) {
            less.next = greatHead;
            print(lessHead);
        } else {
            print(greatHead);
        }
        System.out.println();
    }
}