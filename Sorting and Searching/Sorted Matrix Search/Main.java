// Given an m*n matrix in which each row and each column is sorted in ascending order ,
// write a method to find an element .

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] arr;
        int m, n, target;

        // Read input and unpack values
        Scanner sc = new Scanner(System.in);
        System.out.print("Write No. of rows for the matrix: ");
        m = sc.nextInt();
        System.out.print("Write No. of columns for the matrix: ");
        n = sc.nextInt();

        arr = new int[m][n];
        System.out.println("Remember: values must be in ascending sorted order (row and column-wise).");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Write value for cell [" + i + "," + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print("Write the target element: ");
        target = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        space_Search(arr, m, n, target, list);

        if (list.isEmpty()) {
            System.out.println("Element not found in matrix.");
        } else {
            System.out.println("Element found at: [" + list.get(0) + ", " + list.get(1) + "]");
        }
    }

    static void space_Search(int[][] arr, int row, int col, int target, ArrayList<Integer> list) {
        for (int i = 0; i < row; i++) {
            int startEl = arr[i][0];
            int lastEl = arr[i][col - 1];
            if (target >= startEl && target <= lastEl) {
                linearSearch(arr, i, col, target, list);
                return;
            }
        }
    }

    static void linearSearch(int[][] arr, int rowNumber, int col, int target, ArrayList<Integer> list) {
        for (int i = 0; i < col; i++) {
            if (arr[rowNumber][i] == target) {
                list.add(rowNumber);
                list.add(i);
                return;
            }
        }
    }
}


   