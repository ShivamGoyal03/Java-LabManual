// FractionalKnapsack
// Shivam
// 21CSU090

import java.util.*;

public class Practical5 {
    public static void main(String args[]) {
        int i, j = 0, n;
        float sum = 0, max;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of items");
        n = sc.nextInt();
        int arr[][] = new int[2][n];

        System.out.println("Enter the weights of each items");
        for (i = 0; i < n; i++)
            arr[0][i] = sc.nextInt();

        System.out.println("Enter the values of each items");
        for (i = 0; i < n; i++)
            arr[1][i] = sc.nextInt();

        System.out.println("Enter maximum value of knapsack :");
        int max_qty = sc.nextInt();

        int m = max_qty;
        while (m >= 0) {
            max = 0;
            for (i = 0; i < n; i++) {
                if (((float) arr[1][i]) / ((float) arr[0][i]) > max) {
                    max = ((float) arr[1][i]) / ((float) arr[0][i]);
                    j = i;
                }
            }
            if (arr[0][j] > m) {
                System.out.println("Quantity of item number " + (j + 1) + " added is " + m);
                sum += m * max;
                m = -1;
            } else {
                System.out.println("Quantity of item number " + (j + 1) + " added is " + arr[0][j]);
                m -= arr[0][j];
                sum += (float) arr[1][j];
                arr[1][j] = 0;
            }
        }
        System.out.println("The total profit is " + sum);

    }
}

// Enter no of items
// 8
// Enter the weights of each items
// 10 15 5 12 6 8 7
// 3
// Enter the values of each items
// 20 30 18 25 14 24 15 10
// Enter maximum value of knapsack :
// 40
// Quantity of item number 3 added is 5
// Quantity of item number 8 added is 3 
// Quantity of item number 6 added is 8 
// Quantity of item number 5 added is 6 
// Quantity of item number 7 added is 7 
// Quantity of item number 4 added is 11
// The total profit is 103.916664