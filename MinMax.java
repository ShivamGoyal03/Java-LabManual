// Take a array, and return minimum and maximum number repeating how many times.

import java.util.*;
public class MinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        minNum(arr, n);
        maxNum(arr, n);
    }

    static void minNum(int[] arr, int n){
        Arrays.sort(arr);
        int minimum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != arr[0]) {
                break;
            }
            minimum++;
        }
        System.out.println(arr[0] + " occured " + minimum + " times" );
    }
    
    static void maxNum(int[] arr, int n){
        Arrays.sort(arr);
        int maximum = 0;
        for (int j = n-1; j >= 0; j--) {
            if (arr[j] != arr[n-1]) {
                break;
            }
            maximum++;
        }
        System.out.println(arr[n-1] + " occured " + maximum + " times" );
    }
}
