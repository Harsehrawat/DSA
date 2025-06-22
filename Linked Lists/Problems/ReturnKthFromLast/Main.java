package Problems.ReturnKthFromLast;

import java.util.Scanner;

import Problems.ReturnKthFromLast.Logic;
import myLinkedList.Operations;
import myLinkedList.Node;

public class Main {

    public static void main(String[] args) {
        Operations list = new Operations();
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Value of K : ");

        int k = sc.nextInt();

        int size = Operations.getSize(list.head);
        if(k >= size){
            System.out.println("Operation Can't be performed as value of k"+(k)+" can't be more than size"+(size)+" of the L.L.");
        }else{
            Node temp = Logic.kthFromLastNode(list.head,k);   
            System.out.println(k+"th node from end is "+temp.data);
        }
        
    }
}