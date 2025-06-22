package Problems.DeleteMiddleNode;

import java.util.Scanner;
import java.util.logging.LogManager;

import myLinkedList.Operations;
import myLinkedList.Node;

public class Main {
    // i am assuming its only possible to delete a node by a value
    public static void main(String[] args) {
        Operations list = new Operations();
        list.appendToTail(1);        
        list.appendToTail(2);        
        list.appendToTail(3);        
        list.appendToTail(4);        
        list.appendToTail(5);        

        System.out.println("Original L.L. : ");
        list.printList();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of node you want to delete");
        int data = sc.nextInt();

        Node node = list.findNode(list.head, data);
        if(node != null){
            Logic.deleteGivenNode(node);
            System.out.println("Modified L.L. after Deleting node with Value : "+data);
            list.printList();
        }
        
    }
}