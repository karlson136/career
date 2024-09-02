/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;

public class NodeOneDirection {
    public NodeOneDirection next;
    public int data;

    public NodeOneDirection(int data) {
        this.data = data;
    }

    public void appendTail(int value) {
        NodeOneDirection temp = new NodeOneDirection(value);
        NodeOneDirection curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}