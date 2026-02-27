package NextGI;

public class Main {

    public static void main(String[] args) {
        NextGreaterIndex solution = new NextGreaterIndex();

        int[] arr = {1,3,4,2};

        int[] res = solution.getNextGI(arr);

        for(int i : res){
            System.out.print(i + ", ");
        }
    }
}