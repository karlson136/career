/*
 * Copyright
 * Andrei Razhkou
 */

package linkedlist;


import java.util.Stack;

import static linkedlist.LinkedListUtils.createNodeOneDirection;
import static linkedlist.LinkedListUtils.print;

public class LinkedList25 {

    // linked list represents a number in reverse order
    // sum 2 numbers
    // (7->1->6) + (5->9->2) = (2->1->9)
    //   617     +     295   =   912
    // and calculate sum for numbers in direct order
    public static void main(String[] args) {
        sumReverseNumbers(createNodeOneDirection(7, 1, 6), createNodeOneDirection(5, 9, 2));
        sumReverseNumbers(createNodeOneDirection(9), createNodeOneDirection(9));
        sumReverseNumbers(createNodeOneDirection(1, 9), createNodeOneDirection(9));

        sumDirectNumbers(createNodeOneDirection(6, 1, 7), createNodeOneDirection(2, 9, 5));
        sumDirectNumbers(createNodeOneDirection(9), createNodeOneDirection(9));
        sumDirectNumbers(createNodeOneDirection(9, 1), createNodeOneDirection(9));
    }

    public static void sumReverseNumbers(NodeOneDirection num1, NodeOneDirection num2) {
        print(num1);
        print(num2);

        NodeOneDirection sum = null;
        NodeOneDirection sumHead = null;
        int i = 0;
        while (num1 != null || num2 != null || i == 1) {
            int a = 0;
            if (num1 != null) {
                a = num1.data;
                num1 = num1.next;
            }
            int b = 0;
            if (num2 != null) {
                b = num2.data;
                num2 = num2.next;
            }
            int temp = (a + b + i) % 10;
            i = (a + b + i) / 10;
            if (sum == null) {
                sum = new NodeOneDirection(temp);
                sumHead = sum;
            } else {
                sum.next = new NodeOneDirection(temp);
                sum = sum.next;
            }
        }

        print(sumHead);
        System.out.println();
    }

    public static void sumDirectNumbers(NodeOneDirection num1, NodeOneDirection num2) {
        print(num1);
        print(num2);

        Stack<Integer> stack1 = new Stack<>();
        while (num1 != null) {
            stack1.push(num1.data);
            num1 = num1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (num2 != null) {
            stack2.push(num2.data);
            num2 = num2.next;
        }

        NodeOneDirection sum = null;
        NodeOneDirection sumHead = null;
        int i = 0;
        while (!stack1.empty() || !stack2.isEmpty() || i == 1) {
            int a = !stack1.empty() ? stack1.pop() : 0;
            int b = !stack2.empty() ? stack2.pop() : 0;

            int temp = (a + b + i) % 10;
            i = (a + b + i) / 10;
            if (sumHead == null) {
                sumHead = new NodeOneDirection(temp);
            } else {
                sum = new NodeOneDirection(temp);
                sum.next = sumHead;
                sumHead = sum;
            }
        }

        print(sumHead);
        System.out.println();
    }
}