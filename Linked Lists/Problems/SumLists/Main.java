package Problems.SumLists;

import java.util.Scanner;
import Problems.SumLists.Logic;
import myLinkedList.Operations;
import myLinkedList.Node;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number1 : ");
        int n = sc.nextInt();
        int number1 = n;

        Operations list1 = new Operations();
        Operations list2 = new Operations();
        
        while (n > 0) {
            int currDigit = n%10;
            n /= 10;
            list1.appendToTail(currDigit);
        }

        System.out.println("Enter Number2 : ");
        int n2 = sc.nextInt();
        int number2 = n2;

        while (n2 > 0) {
            int currDigit = n2%10;
            n2 /= 10;
            list2.appendToTail(currDigit);
        }

        System.out.println("Number 1 as l.l. : ");
        list1.printList();

        System.out.println("Number2 as l.l. : ");
        list2.printList();

        System.out.println("The sum of "+number1+" + "+number2+" as L.L. is : ");
        Node node = Logic.sumFunction(list1.head,list2.head);
        Operations resultList = new Operations();
        resultList.head = node;
        resultList.printList(); // if using Option 2



    }
}