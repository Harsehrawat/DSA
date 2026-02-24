package usingStack;


public class Main {

    public static void main(String[] args) {
        Queue q = new Queue( 5);

        // Attempt to add 6 elements (queue size is 5)
        for(int i = 0; i < 6; i++){
            try {
                q.offer(i);
                System.out.println("Added: " + i);
            } catch (RuntimeException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        try{
            System.out.println("Peek element: "+ q.peek());
        }catch( RuntimeException e){
            System.out.println("Exception: " + e.getMessage());
        }

    }
}