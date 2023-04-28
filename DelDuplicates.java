// Delete duplicate numbers in array

import java.util.*;
public class DelDuplicates {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = sc.nextInt();
        // }
        int[] arr = { 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6 };
        int n = arr.length;
        int k = RemDuplicates(arr, n);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int RemDuplicates(int[] arr, int n){
        if (n == 0 || n == 1) {
            return n;
        }
        Arrays.sort(arr);
        int j = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i] != arr[i+1] ) {
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[n-1];
        j++;
        return j;
    }
}
