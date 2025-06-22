package Problems.DeleteMiddleNode;

import myLinkedList.Node;
import myLinkedList.Operations;

public class Logic {

    Node head;

    static void deleteGivenNode(Node node){
        if(node == null ||  node.next == null){
            System.out.println("Can't Perform Operation of Head / Tail");
            return;
        }

        node.data = node.next.data; 
        node.next = node.next.next; // i am basically taking value of nextNode and storing it into currNode 
    }
}