/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;

import static linkedlist.LinkedListUtils.*;

public class LinkedList22 {

    // remove k-th element from the end
    public static void main(String[] args) {
        System.out.println(kThElemFromTheEnd(createNodeOneDirection(1, 7, 3, 6, 2), 1));
        System.out.println(kThElemFromTheEnd(createNodeOneDirection(1, 7, 3, 6, 2), 3));
        System.out.println(kThElemFromTheEnd(createNodeOneDirection(1, 7, 3, 6, 2), 5));
        System.out.println(kThElemFromTheEnd(createNodeOneDirection(1), 1));

        System.out.println();

        System.out.println(kThElemFromTheEndRecursion(createNodeOneDirection(1, 7, 3, 6, 2), 1));
        System.out.println(kThElemFromTheEndRecursion(createNodeOneDirection(1, 7, 3, 6, 2), 3));
        System.out.println(kThElemFromTheEndRecursion(createNodeOneDirection(1, 7, 3, 6, 2), 5));
        System.out.println(kThElemFromTheEndRecursion(createNodeOneDirection(1), 1));
    }

    public static int kThElemFromTheEnd(NodeOneDirection head, int k) {
        if (head == null) {
            return -1;
        }

        int size = 0;
        NodeOneDirection temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        for(int i = 0; i < size - k; i++) {
            head = head.next;
        }
        return head.data;
    }

    public static int kThElemFromTheEndRecursion(NodeOneDirection head, int k) {
        if (head == null) {
            return -1;
        }
        return helper(head, k).data;
    }

    public static Pair helper(NodeOneDirection head, int k) {
        if (head.next == null) {
            return new Pair(1, head.data);
        }

        Pair pair = helper(head.next, k);
        if (pair.kFromTheEnd == k) {
            return pair;
        } else {
            return new Pair(pair.kFromTheEnd + 1, head.data);
        }
    }

    public static class Pair {
        int kFromTheEnd;
        int data;

        Pair(int kFromTheEnd, int data) {
            this.kFromTheEnd = kFromTheEnd;
            this.data = data;
        }
    }
}