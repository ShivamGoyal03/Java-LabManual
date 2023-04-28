// Shivam
// 21CSU090

import java.util.*;
public class Practical1a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = facto(n);
        System.out.println(ans);
    }

    static int facto(int n){
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * facto(n-1);
    }
}
