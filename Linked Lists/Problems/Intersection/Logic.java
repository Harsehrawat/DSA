package Problems.Intersection;

import myLinkedList.Node;
import myLinkedList.Operations;

public class Logic {

    public static void ifIntersection(Node head1,Node head2){
        // get size diff. of both
        // cases : size equal , size different.
        Operations list1 = new Operations();
        Operations list2 = new Operations();

        int size1 = list1.getSize(head1);
        int size2 = list2.getSize(head2);
        Node temp1 = head1;
        Node temp2 = head2;

        if(size1 == size2){
            validateIntersaction(temp1, temp2);
        }
        else{
            if(size1 > size2){
                int j = 0;
                while (j < size1 - size2) {
                    temp1 = temp1.next;
                    j++;
                }

                validateIntersaction(temp1,temp2);
            }
            else{
                int j = 0;
                while (j < size2 - size1) {
                    temp2 = temp2.next;
                    j++;
                }

                validateIntersaction(temp1, temp2);
            }
        }

    }   

    public static void validateIntersaction(Node temp1,Node temp2){
        while (temp1 != null && temp2!= null) {
            if (temp1 == temp2) {
                System.out.println("Intersection Node Found at Node : "+temp1.data);
                return;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        System.out.println("No Intersaction Found");

    }
    
}