package Problems.RemoveDups;

import myLinkedList.Node;
import java.util.ArrayList;

public class Logic {

    Node head;

    static int getSize(Node head){
        if(head == null) return 0;

        Node temp = head;
        int size = 0;
        while (temp!=null) {
            temp = temp.next;
            size++;
        }

        return size;
    }
    
    static void RemoveDups(Node head){
        if (head == null) return;
    
        System.out.println("Remove Dups Called");
    
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        list.add(temp.data);
    
        while (temp != null && temp.next != null) {
            if (list.contains(temp.next.data)) {
                // Skip the duplicate node
                temp.next = temp.next.next;
            } else {
                // Add to list and move forward
                list.add(temp.next.data);
                temp = temp.next;
            }
        }
    }
}    