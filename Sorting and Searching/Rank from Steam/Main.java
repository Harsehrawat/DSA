// u'd be given steam of integers (non-sorted and may contain dups) ,
// return the rank of an asked integer x : (rank means no. of integers <= x)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> steam = new ArrayList<>();
        Scanner sc =new Scanner(System.in);
        
        System.out.println("Write total no of integers present in steam :");
        int n = sc.nextInt();

        for(int i = 0;i<n;i++){
            System.out.println("Write value for Integer"+(i+1));
            int el = sc.nextInt();
            steam.add(el);
        }

        // {2,5,3,1,3,3,6,4}  find getRank(4), getRank(6)
        // approach : linear scan
        // approach 1 : sort for once, use B.S. for Rank
        ArrayList<HashMap<Integer,Integer>> ans  = new ArrayList<>();
        System.out.println("Total number of x for which u will call getRank() ?");
        int counter = sc.nextInt();
        if(counter == 1){
            System.out.println("Enter the number u for which u want to call getRank() :");
            linearSearch(steam,sc.nextInt(),ans);
        }
        else{
            Collections.sort(steam);
            for(int i = 0;i<counter;i++){
                System.out.println("Enter the number u for which u want to call getRank() :");
                getRank(steam,sc.nextInt(),ans);
            }
        }

        // Print the Result : 
        System.out.println("\nRanks:");
        for (HashMap<Integer, Integer> map : ans) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println("getRank(" + entry.getKey() + ") = " + entry.getValue());
            }
        }
        
    }
    static void linearSearch(ArrayList<Integer> list,int target,ArrayList<HashMap<Integer,Integer>> ans){
        int lowerNumber = 0;
        for(int i : list){
            if(i < target) lowerNumber++;
        }
        HashMap<Integer,Integer> rank = new HashMap<>();
        rank.put(target,lowerNumber);
        ans.add(rank);
    }
    static void getRank(ArrayList<Integer> list,int target,ArrayList<HashMap<Integer,Integer>> ans){
        int rank = space_Search(list, target,0,list.size()-1);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(target,rank);
        ans.add(map);
    }
    static int space_Search(ArrayList<Integer> list,int target,int low,int high){
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                ans = mid; // candidate rank
                low = mid + 1; // look further right
            } else {
                high = mid - 1;
            }
        }
        return ans + 1; 
    }
}