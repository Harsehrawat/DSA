// Implement an algorithm to print all valid combinations of n-pairs of a parentheses.
// ex. input : 3 
// output : ((())) , (()()) , (())() , ()(()) , ()()() 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n");    
        int n = sc.nextInt();

        Set<String> ans = fn(n);
        for(String s : ans){
            System.out.println(s);
        }
        
    }

    static Set<String> fn(int n){
        Set<String> currValid = new HashSet<>();
        if(n == 1){
            currValid.add("()");
            return currValid;
        }

        Set<String> prev = fn(n-1);
        for(String s : prev){
            currValid.add("()"+s);
            for(int i = 0;i<s.length();i++){
                // I've to also insert at beginning
                String newParen = insertionOperation(s,i);
                currValid.add(newParen);
            }
        }

        return currValid;
    }
    
    static String insertionOperation(String s,int index){
        String start = s.substring(0, index+1);
        String end = s.substring(index+1,s.length());
        return start + "()" + end;
    }
}