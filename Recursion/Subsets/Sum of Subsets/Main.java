import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = {5,2,1};
        List<Integer> res= new ArrayList<>();
        fn(nums, 0, 0, res);
        System.out.print("[");
        for(int i : res){
            System.out.print(i+",");
        }
        System.out.print("]");
    }
    static void fn(int[] nums,int index,int currSum,List<Integer> res){
        if(index == nums.length){
            res.add(currSum);
            return;
        }

        currSum += nums[index];
        fn(nums,index+1,currSum,res);
        currSum -= nums[index];
        fn(nums,index+1,currSum,res);
    }

}