// Refer to leetcode42 for question understanding

class Solution {
    public int trap(int[] height) {
        int currB = 0;
        int stopB = 0;
        int tw = 0;

        for (int i = 0; i < height.length; i++) {
            currB = height[i];
            System.out.println("\nTaking index: " + i + " as currB with value: " + currB);

            int j = i + 1;
            int nextMax = 0;
            int stopBIndex = -1;

            for (int k = j; k < height.length; k++) {
                if (height[k] > nextMax) {
                    nextMax = height[k];
                    stopBIndex = k;
                }
                if (height[k] >= currB) {
                    stopBIndex = k;
                    break;
                }
            }

            // No valid stopB found, or there is no space between currB and stopB.
            if (stopBIndex == -1 || stopBIndex == i || stopBIndex == i + 1) {
                System.out.println("No valid stopB found for currB at index " + i);
                continue;
            }

            stopB = height[stopBIndex];
            System.out.println("stopB found at index: " + stopBIndex + " and value: " + stopB);

            int[] currBlockage = new int[(stopBIndex - i) - 1];
            System.out.println("CurrBlockage taken from index: " + (i + 1) + " to index: " + (stopBIndex - 1));

            int l = 0;
            for (int k = i + 1; k < stopBIndex; k++) {
                currBlockage[l++] = height[k];
            }

            for (int d : currBlockage) {
                System.out.print(d + ", ");
            }
            System.out.println();

            // The water level is determined by the minimum of the two bounding buildings.
            int currHeight = Math.min(currB, stopB);
            int width = (stopBIndex - i) - 1;
            int initTW = currHeight * width;

            for (int m : currBlockage) {
                initTW -= m;
            }

            System.out.println("current trapped water between index " + i + " and " + stopBIndex + " is: " + initTW);
            tw += initTW;
            System.out.println("Total trapped water so far: " + tw);

            i = stopBIndex - 1;  // Jump to just before stopB for the next iteration.
        }

        return tw;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};  // example input
        Solution sol = new Solution();
        int totalWaterTrapped = sol.trap(height);
        System.out.println("\nTotal trapped water: " + totalWaterTrapped);
    }
}
