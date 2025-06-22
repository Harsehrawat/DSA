package Problems.ReturnKthFromLast;

import myLinkedList.Node;
import myLinkedList.Operations;


public class Logic {

    Node head;

    static Node kthFromLastNode(Node head,int k){
        int size = Operations.getSize(head);

        // 0th from last would mean the last node
        // 1th from last would mean the 2nd last node
        // size - 1 would mean the first node

        Node temp = head;
        if(k < size){
            int j = 1;
            while (j < size - k) {
                temp = temp.next;
                j++;
            }
        }
        return temp;
    }
}