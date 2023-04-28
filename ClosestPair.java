import java.util.*;
public class ClosestPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();
        System.out.println("Enter value of final ");
        // int[] arr = { 12, 40, 60, 15, 2}; 
        int finals = sc.nextInt();
        int tolerance = (int)(finals*0.1);
        for (int i = 0; i < size; i++) {
            int a = arr[i];
            for (int j = i+1; j < size; j++) {
                if (a + arr[j] == finals) {
                    System.out.println(a + " , " + arr[j] + " sum " + (a + arr[j]));
                    // break;
                }
                if ((a + arr[j] < finals && a + arr[j] >=finals-tolerance)) {
                    System.out.println(a + " , " + arr[j] + " sum " + (a + arr[j]));
                    // break;
                }
                if ((a + arr[j] > finals && a + arr[j] <= finals+tolerance)) {
                    System.out.println(a + " , " + arr[j] + " sum " + (a + arr[j]));
                    // break;
                }
            }
        }
    }
}

// Enter the size of array: 
// 5
// 1
// 2
// 3
// 4
// 0

// Enter value of final 
// 5
// 1 , 4 sum 5
// 2 , 3 sum 5