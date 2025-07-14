//Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res =  new ArrayList<>();
        fn(numRows, res);

        // Print the result
        for (List<Integer> row : res) {
            System.out.println(row);
        }
    }
    static List<Integer> fn(int numRows, List<List<Integer>> res){
        ArrayList<Integer> list = new ArrayList<>();
        if(numRows == 1){
            list.add(1);
            res.add(list);
            return list;
        }

        // get the currentSelectionList
        List<Integer> prevSelectnList = fn(numRows-1, res);
        List<Integer> currSelectnList = shuffleFunction(prevSelectnList, numRows);
        res.add(currSelectnList);
        return currSelectnList;
    }
    static List<Integer> shuffleFunction(List<Integer> currFormation,int currNumber){
        // i'd start adding element to positions from 0 to index-1 
        List<Integer> list = new ArrayList<>();
        if(currNumber == 2) {
            list.add(1);
            list.add(1);
            return list;
        }
        int beginEl = currFormation.get(0);
        int endEl = currFormation.get(currFormation.size() - 1);
        list.add(beginEl);
        for(int i = 1;i<currFormation.size();i++){
            int currSum = currFormation.get(i-1) + currFormation.get(i);
            list.add(currSum);
        }
        list.add(endEl);
        return list;
    }
    
}
