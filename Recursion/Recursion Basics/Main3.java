// calculate a raise to power b 

// ex. 2^3

public class Main3 {

    public static void main(String[] args) {
        int a = 2;
        int power = 3;
        int ans = fn(a, power,1);
        System.out.println(ans);
    }
    static int fn(int a,int power,int number){
        if(power == 0) return number;

        return fn(a,power-1,number*a);
    }
}