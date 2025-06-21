package Problems.RemoveDups;

import myLinkedList.Operations;

public class Main {
    public static void main(String[] args) {
        Operations list = new Operations();

        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(3);

        System.out.println("Before removing duplicates:");
        list.printList();

        Logic.RemoveDups(list.head);

        System.out.println("After removing duplicates:");
        list.printList();
    }
}