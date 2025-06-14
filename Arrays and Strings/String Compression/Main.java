
public class Main {

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            sb.append(ch);
            int counter = 0;
            int j = i;
            while(j < s.length() && s.charAt(j) == ch){
                j++;
                counter++;
            }
            sb.append(counter);
            i = j-1;
        }

        String sCompressed = sb.toString();
        if(sCompressed.length() < s.length()){
            System.out.println("Compressed String : " + sCompressed);
        }else{
            System.out.println("Compressed String is not smaller than original String, so can't return compressed string");
        }
    
    }
}