// Imagine a robot sitting on the upper left corner of a grid with r rows and c columns.
// The robot can only move in two directions, right and down, but certain cells are "off limits"
// such that the robot cannot step on them.
/// Design an algortihm to find a path for the robot from the top left to the bottom right.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[][] grid = {
            {'.', '.', '.'},
            {'.', '*', '.'},
            {'*', '.', '.'}
        };
        
        // _ : Robot , . : safe Cell , * : danger cell
        List<List<Integer>> validPath = new ArrayList<>();
        if(fn(grid, 0, 0,validPath )){
            // means i've validPath containing valid <i,j> lists
            for(List<Integer> l : validPath){
                System.out.println("("+ l.get(0) + " , "+ l.get(1)+")");
            }
        }else{
            System.out.println("No valid Path found To Reach Bottom Right");
        }

    }
    static boolean fn(char[][] grid,int i,int j,List<List<Integer>> validPath){
        int row = grid.length; 
        int col = grid[0].length;

        if(i >= row || i < 0 || j >= col || j < 0 || grid[i][j] == '*' ){
            return false;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1){
            List<Integer> currCell = new ArrayList<>();
            currCell.add(i);
            currCell.add(j);
            validPath.add(currCell);
            return true;
        }

        // add currPath to validPath
        List<Integer> currCell = new ArrayList<>();
        currCell.add(i);
        currCell.add(j);
        validPath.add(currCell);

        if(fn(grid, i+1, j, validPath) || fn(grid, i, j+1, validPath)) return true;

        validPath.remove(validPath.size() - 1);
        return false;
    }
}