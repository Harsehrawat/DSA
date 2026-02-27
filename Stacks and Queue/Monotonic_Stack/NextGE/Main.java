package NextGE;

public class Main {

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();

        int[] arr = {1,3,4,2};

        int[] res = solution.nextGE(arr);

        for(int i : res){
            System.out.print(i + ", ");
        }
    }
}