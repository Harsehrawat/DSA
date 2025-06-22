package Problems.Palindrome;

import myLinkedList.Operations;
import myLinkedList.Node;
import Problems.Palindrome.Logic;

public class Main {

    public static void main(String[] args) {
        Operations list = new Operations();
        System.out.println("inside Main");
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(2);
        list.appendToTail(1);
        System.out.println("append complete");
        if(Logic.isPalindrome(list.head)){
            System.out.print("The L.L. is palindrome");
        }
        else System.out.print("The L.L. is not Palindrome");

    }
    
}