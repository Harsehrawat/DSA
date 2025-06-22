package myLinkedList;

public class Operations {

    public Node head;

    public static int getSize(Node head) {
        if (head == null) return 0;
    
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
    

    public void printList() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
    
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    

    public void appendToTail(int data){
        if(head == null){
            Node temp = new Node(data);
            head = temp;
            return;
        }
        
        Node temp = head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        Node n = new Node(data);
        temp.next = n;
    }

    public void deleteNode(int data){
        // to delete, i need to stop at node previous to it
        if(head == null){
            System.out.println("LL is NULL , can't delete");
            return;
        }

        if(head.data == data){
            head = head.next;
            System.out.println("Deleted");
            return;
        }

        Node prevNode = head;
        while (prevNode.next!= null) {
            if(prevNode.next.data == data){
                Node new_nextNode = prevNode.next.next;
                prevNode.next = new_nextNode;
                System.out.println("deleted");
                return;
            }
            prevNode = prevNode.next;
        }

        System.out.println("LL Doesn't contain any node with data : " + data + " , can't perform deletion");

    }

    public void InsertNode(int index,int data){
        int size = getSize(head);
        if (index > size) {
            System.out.println("L.L. is of size : " + size + " , can't perform insertion at index " + index);
            return;
        }
        if(index == 0){
            Node n = new Node(data);
            n.next = head;
            head = n;
            return;
        }

        Node prevNode = head;
        int curr_index = 0;
        while (curr_index < index - 1 && prevNode!= null) {
            prevNode = prevNode.next;
            curr_index++;
        }
        Node n = new Node(data);
        n.next = prevNode.next;
        prevNode.next = n;
        return;

    }

}