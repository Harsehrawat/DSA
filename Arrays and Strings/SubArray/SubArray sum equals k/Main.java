import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] arr = {-1,-1,0,1,1,2,3};
        int k = 2;

    }
    static int prefixAlgo(int[] nums,int k){

        int count = 0;
        int prefixSum = 0;
        HashMap<Integer,Integer> prevSumMapper = new HashMap<>();
        prevSumMapper.put(0,1);

        // Suppose we are at index i,
        // our goal is to check if there exists a subarray ending at index i that sums to the target k.
        // Let prefixSum be the sum of all elements from index 0 to i.
        // If there exists a previous prefix sum such that:
        //  prefixSum - previousPrefixSum = k
        // then the subarray from the next index after that previous prefix to index i has sum = k.

        for(int i: nums){
            prefixSum += i;
            if (prevSumMapper.containsKey(prefixSum - k)) {
                count += prevSumMapper.get(prefixSum - k);
            }
            prevSumMapper.put(prefixSum, prevSumMapper.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}