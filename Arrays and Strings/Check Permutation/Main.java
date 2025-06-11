
public class Main {

    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "listen";

        // i'll have freq arr for both and then compare both freq arr
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0;i<s1.length();i++){
            char ch = s1.charAt(i);
            freq1[ch - 'a']++;
        }

        for(int i = 0;i<s2.length();i++){
            char ch = s2.charAt(i);
            freq2[ch - 'a']++;
        }

        if(checkPermutation(freq1, freq2)) System.out.print(s1 + " and " + s2 + " are Permutations of each other");
        else System.out.println(s1+" and "+s2+" are not Permutations of each other");;
    }
    static boolean checkPermutation(int[] freq1,int[] freq2){
        for(int i = 0;i<freq1.length;i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}