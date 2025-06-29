public class Main2 {
    public static void main(String[] args) {
        int[] arr=  {5,6,1,2,3,4};
        int target = 3;

        int ans = search_Space(arr, 0,arr.length-1, target);
        System.out.println(ans == -1 ? "No such element found" : "Target Element found at index : "+ans );

    }
    static int search_Space(int[] arr,int left,int right,int target){
        int ans = -1;
        while (left <= right) {
            int middle = (left+right)/2;
            if(arr[middle] == target) return middle;

            // middle will either fall in left sorted part or in right sorted part
            if(arr[middle] >= arr[left]){ // left sorted part
                if(target > arr[left] && target < arr[middle]){
                    right = middle-1;
                }
                else left = middle+1;
            }
            else{
                if(target > arr[middle] && target < arr[right]){
                    left = middle+1;
                }
                else right = middle-1;
            }
        }
        return ans;
        
    }
}