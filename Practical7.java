// 0/1 Knapsack problem
// Shivam
// 21CSU090

import java.util.*;

public class Practical7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.print("Enter maximum capacity: ");
        int capacity = sc.nextInt();
        System.out.println("\nEnter the items with their profit and weight separated by a space");
        
        int[] profit= new int[n];
        int[] weight= new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.println("\nMax Profit: "+knap(capacity,weight,profit,n));
    }

    static int knap(int capacity,int weight[],int profit[],int size){
 
        if(size==0 || capacity==0)
            return 0;
        if(weight[size-1]>capacity)
            return knap(capacity,weight,profit,size-1);
        else
            return Math.max(profit[size-1]+knap(capacity-weight[size-1],weight,profit,size-1),knap(capacity,weight,profit,size-1));    
    }
}

/*
-------------------------------------------Test Cases---------------------------------------------
Test Case 1
Input
3
50
60 10
100 20
120 30

Output: 220


Test Case 2
Input
4 
8
1 2
2 3
5 4
6 5

Output: 8
*/