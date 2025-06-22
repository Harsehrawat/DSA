package myLinkedList;

public class Operations {
    public Node head;

    public int getSize(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
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

    public void appendToTail(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data);
    }

    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("LL is NULL , can't delete");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted");
            return;
        }

        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data == data) {
                prev.next = prev.next.next;
                System.out.println("Deleted");
                return;
            }
            prev = prev.next;
        }

        System.out.println("Value not found: " + data);
    }

    public void insertNode(int index, int data) {
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return;
        }

        int count = 0;
        Node temp = head;
        while (temp != null && count < index - 1) {
            count++;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Index out of bounds");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public Node findNode(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("No Such Node with value: " + data);
        return null;
    }

    public Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev; // Update head
        return head;
    }
}
