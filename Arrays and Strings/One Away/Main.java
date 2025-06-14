// i'd count freq of each char, 
// if freqGap <= 1 and only for one such char : return true

public class Main {
    public static void main(String[] args) {
        String s1 = "pele";
        String s2 = "ple";

        // i'll use two pointers , one for s1 and other for s2
        // at any point if counter > 1 return false
        if(s1.length() > s2.length()){
            if( fn(s1, s2)) System.out.print("true");
            else System.out.print("False");
        }
        else{
            if( fn(s2,s1)) System.out.print("true");
            else System.out.print("False");
        }

    }
    static boolean fn(String s1,String s2){
        int counter = 0;

        if (s1.length() == s2.length()) {
            // replacement case
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) counter++;
                if (counter > 1) return false;
            }

        }
        else{
            int j = 0;
            for(int i = 0;i<s1.length();i++){
                if(counter > 1) return false;
                if(j>= s2.length()  || s2.charAt(j) != s1.charAt(i)) counter++;
                else{
                    j++;
                }
            }
        }
        return true;
    }
}
