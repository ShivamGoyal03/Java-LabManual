// Linear Search 

import java.util.*;
public class LinearSearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element you want to search");
        int ele = sc.nextInt();
        linear(arr, ele);
    }

    static void linear(int[] arr, int ele){
        int flag = 0;
        for (int i : arr) {
            if (i == ele) {
                flag++;
                break;
            }
        }

        if (flag == 1)
            System.out.println("Element found ");
        else
            System.out.println("Element not found ");
    }
}