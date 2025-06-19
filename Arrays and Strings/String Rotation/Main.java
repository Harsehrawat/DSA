
// "waterbottle" "erbottlewat" .. for s2, i am at 'e' find first occ. of e in other

import java.util.Arrays;


            public class Main {
            
                public static void main(String[] args) {
                    String s1 = "abcabc";
                    String s2 = "cabcab";
            
                    if(verifyRotation(s1,s2)){
                        System.out.print(s1 + " is a rotation of "+ s2);
                    }
                    else{
                        System.out.println(s1 + " is not a rotation of " + s2);
                    }
                }
                static boolean verifyRotation(String s1,String s2){
                    if(s1.length() == s2.length()){
                        s2 = s2+s2;
                        // now verify is this new s2 contains s1 as a substring in it 
                        if(isSubstring(s1,s2)) return true;
                    }
                    return false;
                }
                static boolean isSubstring(String s1,String s2){
                    char startChar = s1.charAt(0);
                    for(int i = 0;i<= s2.length() - s1.length();i++){
                        if(s2.charAt(i) == startChar && (i+s1.length() <= s2.length()) ){
                            String s3 = s2.substring(i, i+s1.length());
                            if(s3.equals(s1)) return true;
                        }
            
                    }
                    return false;
                }
            }   
    