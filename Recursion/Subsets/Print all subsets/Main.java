// The solution set must not contain duplicate subsets. Return the solution in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,2};
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        fn(nums, 0, new ArrayList<>(), res);
        System.out.print("[");
        for(List<Integer> i : res){
            System.out.print("[");
            for(int j : i){
                System.out.print(j+" , ");
            }
            System.out.print("] ,");
        }
    }
    static void fn(int[] nums,int index,List<Integer> currSum,List<List<Integer>> res){
        res.add(new ArrayList<>(currSum));

        for(int i = index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            currSum.add(nums[i]);
            fn(nums,i+1,currSum,res);
            currSum.remove(currSum.size() - 1);
        }
    }
}