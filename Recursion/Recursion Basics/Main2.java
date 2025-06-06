// Determine whether a string is palindrome or not
// abba

public class Main2 {

    public static void main(String[] args) {
        String s = "abcc";

        if(s.length() % 2 == 0){
            if(lengthEven(s, 0, s.length()-1)) System.out.print("True");
            else System.out.print("False");
        }
        else{
            if(lengthOdd(s, 0, s.length()-1)) System.out.print("True");
            else System.out.print("False");
        }
    }
    static boolean lengthOdd(String s,int index1,int index2){
        if(s.charAt(index1) != s.charAt(index2)) return false;
        if(index1 == index2) return true;
        return lengthOdd(s, index1+1, index2-1);
    }
    static boolean lengthEven(String s,int index1,int index2){
        if(s.charAt(index1) != s.charAt(index2)) return false;
        if(index1 + 1 == index2) return true;
        return lengthEven(s, index1+1, index2-1);
    }
}