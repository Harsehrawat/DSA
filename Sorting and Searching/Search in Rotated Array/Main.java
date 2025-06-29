// Given a sorted array of n integers that has been rotated an unknown number of times, 
// write code to find an element in this array.
// You may assume that the array was originally sorted in increasing order.

public class Main {

    public static void main(String[] args) {
        int[] arr=  {5,6,1,2,3,4};
        int target = 5;

        int ansIndex = 0;
        if(arr[0] > arr[arr.length - 1]){
            // array is rotated.
            // find rotated index .
            int rotatedIndex = findRotationIndex(arr);
            if(target >= arr[0] && target <= arr[rotatedIndex]){
                // means target in rotated part .
                for(int i = 0;i<=rotatedIndex;i++){
                    if(arr[i] == target){
                        ansIndex = i;
                        break;
                    }
                }
            }
            else{
                // means target in second partition
                for(int i = rotatedIndex+1;i<arr.length;i++){
                    if(arr[i] == target){
                        ansIndex = i;
                        break;
                    }
                }
            }
        }
        else{
            for(int i = 0;i<arr.length;i++){
                if(arr[i] == target){
                    ansIndex = i;
                    break;
                }
            }
        }

        System.out.println("Target element : "+target+" is found at index : "+ansIndex+" in the given array ");
    }
    static int findRotationIndex(int[] arr){
        int i = 0;
        while (i < arr.length - 1 && arr[i] < arr[i+1]) {
            i++;
        }
        System.out.println("Rotated Point at index : "+i);
        return i;
    }
}