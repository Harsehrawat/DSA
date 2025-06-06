
class Main1 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        fn(arr, 0);
    }
    static void fn(int[] arr,int index){
        if(index == arr.length) return;

        System.out.println(arr[index]);
        fn(arr,index+1);
    }
}