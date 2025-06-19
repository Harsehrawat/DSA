public class Main {

    public static void main(String[] args) {
        Operations list = new Operations();
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        int size = list.getSize();
        System.out.println(size);
        list.printList();
    }
}