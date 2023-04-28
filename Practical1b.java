// Shivam
// 21CSU090

import java.util.*;
public class Practical1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  k = fib(n-1);
        System.out.println(k);
    }

    static int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        else if(n==1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
