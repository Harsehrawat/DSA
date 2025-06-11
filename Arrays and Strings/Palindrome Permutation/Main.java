public class Main {
    // I could have done it using intelligent way by counting total terms with evenCOunt and oddCOunt,
    // but i wanted to do it this way to get hold of recursion+backtracking permutation generation
    public static void main(String[] args) {
        String s = "Tact Coa";

        // preprocess: remove spaces + convert to lowercase
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') continue;
            sb.append(Character.toLowerCase(ch));
        }
        
        s = sb.toString();
        char[] str = s.toCharArray();
        char[] ans = new char[s.length()];

        ans = isPalindromePermutation(str, 0, ans);

        if(ans[0] == 0) {  // if ans was never filled
            System.out.println("No Palindrome Permutation Found");
        }
        else {
            System.out.println("Palindrome Permutation Found: " + new String(ans));
        }
    }

    static char[] isPalindromePermutation(char[] s, int index, char[] ans){
        if(index == s.length){
            if(checkPalindrome(s)){
                for(int i = 0; i < s.length; i++) {
                    ans[i] = s[i];
                }
                return ans;
            }
            return ans;
        }

        for(int i = index; i < s.length; i++){
            swap(s, i, index);
            ans = isPalindromePermutation(s, index+1, ans);
            if(ans[0] != 0) return ans;  // early exit if ans was filled
            swap(s, index, i); // backtrack 
        }
        return ans;
    }

    static boolean checkPalindrome(char[] s){
        int i = 0;
        int j = s.length - 1;
        while(i <= j){
            if(s[i] != s[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    static void swap(char[] s, int index1, int index2){
        char temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }
}
