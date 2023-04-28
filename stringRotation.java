import java.util.*;

public class stringRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();
        System.out.println("Enter the number of times : ");
        int d = sc.nextInt();
        System.out.println(leftrotate(str,d));
        System.out.println(rightrotate(str,d));
    }
    static String rightrotate(String str, int d){
        return leftrotate(str, str.length() - d);
    }
    static String leftrotate(String str, int d){
        String str2 = str.substring(d) + str.substring(0,d);
        return str2;
    }
}
