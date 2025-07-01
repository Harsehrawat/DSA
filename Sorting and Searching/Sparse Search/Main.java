// given a sorted array of strings interparsed with empty strings, write a method to find the location of the target .

public class Main {

    public static void main(String[] args) {
        String[] arr = {"act","","","bae","ball"};
        String target = "act";

        int ans = findIndex(arr, target);
        System.out.println(ans == -1 ? "No Target Found in Entire Array" : "Target Element found at index : "+ans+" in the array");
    }
    static int findIndex(String[] arr, String target){
        return space_Search(arr,target,0,arr.length-1);
    }
    static int space_Search(String[] arr,String target,int left,int right){
        if(left > right) return -1;

        int middle = (left+right)/2;
        // i would either land at empty string or a non-empty string .
        // for ladning at empty string : set middle to closest non-empty string
        while (middle >= left && middle<= right && arr[middle].equals("")) {
            int counter = 0;
            if(counter <1) System.out.println("Landed at empty string with index : "+middle);
            int expandLeft=  middle-1;
            int expandRight = middle+1;
            while (expandLeft >= left || expandRight <= right) {
                if(expandLeft >= left && !arr[expandLeft].equals("")){
                    middle = expandLeft;
                    System.out.println("expandLeft found non-empty string at index : "+middle);
                    break;
                }
                if(expandRight <= right && !arr[expandRight].equals("")){
                    middle = expandRight;
                    System.out.println("expandRight found non-empty string at index : "+middle);
                    break;
                }
                counter++;
                expandLeft --;
                expandRight ++;
            }
            if(expandLeft < left && expandRight > right){
                System.out.println("Failed to find any non-empty string in b/w left : "+left+" and right : "+right);
                return -1;
            }
        }

        if (arr[middle].equals(target)){
            System.out.println("found target at index : "+middle);
            return middle;
        }
        else if(arr[middle].compareTo(target) < 0){ // shift to right side 
            System.out.println("Middle pointing at element : "+arr[middle]+" at index : "+middle+", Now moving to search space b/w left : "+(middle+1)+" and right : "+right);
            return space_Search(arr, target, middle+1, right);
        }
        else{
            System.out.println("Middle pointing at element : "+arr[middle]+" at index : "+middle+", Now moving to search space b/w left : "+(left)+" and right : "+(middle-1));
            return space_Search(arr, target, left,middle-1);
        } 
    }
}