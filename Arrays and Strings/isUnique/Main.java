
public class Main {

    public static void main(String[] args) {
        String s = "abcde";
        int[] freq  = new int[26];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        if(isUnique(freq)) System.out.print(s + "is unique");
        else System.out.print(s + " is not unique");

    }
    static boolean isUnique(int[] freq){
        for(int i : freq){
            if(i>1) return false;
        }
        return true;
    }
}