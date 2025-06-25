// "this time return all non-duplicate permutations when string can contain repeated characters"

import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {
        String s = "aab";

        ArrayList<String> ans =  new ArrayList<>();
        ans = fn(s);
        System.out.println("The permutations for "+s+" are :");
        for(String str : ans){
            System.out.print(str+" , ");
        }
    }
    static ArrayList<String> fn(String s){
        ArrayList<String> permutations = new ArrayList<>();
        if(s.length() == 0){
            permutations.add("");
            return permutations;
        }

        char first_Word = s.charAt(0);
        String newStr = s.substring(1);
        ArrayList<String> curr_Permutations =  fn(newStr);
        System.out.println("firs_word received "+first_Word);
        System.out.println("new fn call for string : "+ newStr);
        for(String p : curr_Permutations){
            for(int i = 0;i<=p.length();i++){
                String perm = insertCharAt(p,first_Word,i);
                if(!permutations.contains(perm)) permutations.add(perm);
                System.out.println(perm);
            }
        }

        return permutations;
    }
    static String insertCharAt(String str,Character ch,int index){
        String start = str.substring(0, index);
        String end = str.substring(index);
        return start + ch + end;
    }
}