package Problems.Palindrome;

import myLinkedList.Operations;
import myLinkedList.Node;

public class Logic {

    public static boolean isPalindrome(Node head) {
        System.out.println("inside Logic");
        Node slow = head;
        Node fast = head;
    
        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        // If odd length, skip the middle node
        if (fast != null) {
            slow = slow.next;
        }
    
        // Reverse the second half
        Operations revHalf = new Operations();
        Node reverseHead = revHalf.reverseList(slow);
        System.out.println("reverse Head found with value : " + reverseHead.data);
    
        // Compare first and second half
        Node temp = reverseHead;
        Node first = head;
        while (temp != null) {
            if (first.data != temp.data) {
                return false;
            }
            first = first.next;
            temp = temp.next;
        }
    
        return true;
    }
}