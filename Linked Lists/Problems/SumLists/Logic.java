package Problems.SumLists;

import myLinkedList.Operations;
import myLinkedList.Node;

public class Logic {

    public static Node sumFunction(Node head1, Node head2) {
        int carry = 0;
        Node temp1 = head1;
        Node temp2 = head2;

        Operations list = new Operations();

        while (temp1 != null || temp2 != null) {
            int val1 = (temp1 != null) ? temp1.data : 0;
            int val2 = (temp2 != null) ? temp2.data : 0;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            list.appendToTail(digit);

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }

        if (carry > 0) {
            list.appendToTail(carry);
        }

        // reverse the list

        Operations revList=  new Operations();
        return revList.reverseList(list.head);
    }
}
