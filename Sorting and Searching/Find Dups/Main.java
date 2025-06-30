// u have an array with all the numbers from 1 to N, where N is atmost 32,000 .
// The array may have duplicate entries and u don't know what N is .
// How would u print all dups present in the array ? 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,5,6,7,7,7,7,7,7,7,7};
        // i don't know N means i have no clue about the last number .
        int max = 32000;
        int[] freq = new int[max+1];
        for(int i = 0;i<arr.length;i++){
            int currNumber = arr[i];
            freq[currNumber] += 1;
        }

        List<Integer> dups = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (freq[i] > 1) {
                dups.add(i);
            }
        }

        for (int i : dups) {
            System.out.println(i);
        }

    }
}