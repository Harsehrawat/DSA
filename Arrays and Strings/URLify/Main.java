
public class Main {
    public static void main(String[] args) {
        String s = "Mr John Smith";

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }
            else sb.append(s.charAt(i));
        }

        System.out.println(sb.toString());
    }
}