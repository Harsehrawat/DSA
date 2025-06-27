// Write an algorithm to print all ways of arranging eight queens on an 8*8 board such that no two queens
// share the same row/col/diagonal with each other.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        List<List<Integer>> cellsOccupied = new ArrayList<>();
        if(fn(board, 0, cellsOccupied, n)){
            System.out.println("True ! Queens can be arranged");
            for(List<Integer> list : cellsOccupied){
                System.out.println("("+list.get(0)+","+list.get(1)+")");
            }
        }
        else System.out.println("False ! No way to arrange "+n+" Queens on a "+n+"*"+n+" board");
    }
    static boolean fn(int[][] board,int currRow,List<List<Integer>> cellsOccupied,int queensLeft){
        if(queensLeft == 0) return true;
        if(currRow < 0 || currRow >= board.length) return false;

        for(int i = 0;i<board[currRow].length;i++){
            if(isSafe(currRow,i,cellsOccupied)){
                List<Integer> currPair = new ArrayList<>();
                currPair.add(currRow);
                currPair.add(i);
                cellsOccupied.add(currPair);
                // now do same operation on next Row 
                if(fn(board, currRow+1, cellsOccupied, queensLeft-1)){
                    return true;
                }
                // back-track otherwise
                cellsOccupied.remove(cellsOccupied.size()-1);
            }
        }

        return false;
    }
    static boolean isSafe(int row,int col,List<List<Integer>> visitedCells){
        // for diagonal check if curr row - col == prev abs(row-col) .. then diagnaolly alligned 
        for (List<Integer> pos : visitedCells) {
            int r = pos.get(0);
            int c = pos.get(1);
            // Check same column or same diagonal
            if (col == c || Math.abs(row - r) == Math.abs(col - c)) {
                return false;
            }
        }
        return true;
    }
}