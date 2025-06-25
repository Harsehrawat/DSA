// Write all permutaions of a string containing all unique characters..

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> ans =  new ArrayList<>();
        ans = fn(s);
        System.out.println("The permutations for "+s+" are :");
        for(String str : ans){
            System.out.print(str+" , ");
        }

    }
    static ArrayList<String> fn(String string){
        ArrayList<String> permutations = new ArrayList<>();
        if(string.length() == 0){
            permutations.add("");
            return permutations;
        }

        char firstWord = string.charAt(0);
        String newStr = string.substring(1);
        ArrayList<String> words = fn(newStr);
        for(String word : words){
            for(int j = 0;j<=word.length();j++){
                String s = insertCharAt(word,firstWord,j);
                permutations.add(s);
            }
        }
        return permutations;
    }
    static String insertCharAt(String word,char c,int i){
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start+c+end;
    }
}