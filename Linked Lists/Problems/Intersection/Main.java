package Problems.Intersection;

import myLinkedList.Operations;
import myLinkedList.Node;
import Problems.Intersection.Logic;

public class Main {
    public static void main(String[] args) {
        // First linked list
        Operations list1 = new Operations();
        list1.appendToTail(1);
        list1.appendToTail(2);
        list1.appendToTail(3);

        // Second linked list
        Operations list2 = new Operations();
        list2.appendToTail(8);
        list2.appendToTail(7);

        // Create a common tail
        Node common = new Node(6);
        common.next = new Node(9);
        common.next.next = new Node(5);

        // Attach the common part to both lists
        Node temp1 = list1.head;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = common;  // list1 now ends with common

        Node temp2 = list2.head;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = common;  // list2 also ends with common

        // Print both lists
        System.out.print("List1: ");
        list1.printList();
        System.out.print("List2: ");
        list2.printList();

        // Check for intersection
        Logic.ifIntersection(list1.head, list2.head);
    }
}
