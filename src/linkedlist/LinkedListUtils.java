/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;

public final class LinkedListUtils {

    private LinkedListUtils() {

    }

    public static NodeOneDirection createNodeOneDirection(int... data) {
        if (data == null || data.length == 0) {
            return null;
        }

        NodeOneDirection head = new NodeOneDirection(data[0]);
        for (int i = 1; i < data.length; i++) {
            head.appendTail(data[i]);
        }

        return head;
    }

    public static void print(NodeOneDirection head) {
        if (head == null) {
            System.out.println("empty node");
        } else {
            NodeOneDirection node = head;
            while (node != null) {
                System.out.print(node);
                if (node.next != null) {
                    System.out.print(" -> ");
                }
                node = node.next;
            }
        }
        System.out.println();
    }
}