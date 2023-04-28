import java.util.*;
public class MinSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = generate(5);
        System.out.println("Array is : " + Arrays.toString(arr)); 
        System.out.println("Enter the number of min element : ");
        int ele = sc.nextInt();
        int[] arr2 = sort(arr);
        System.out.println("\nArray is : " + Arrays.toString(arr2));
        System.out.println("Sorted element is : " + arr[ele-1]);
        int min_unsort = minSort(arr, ele);
        System.out.println("Smallest element is " + min_unsort );
    }

    static int minSort(int[] arr, int k){
        int[] copy = Arrays.copyOf(arr, arr.length);
        arr = sort(arr);
        return copy[k-1];
    }

    static int[] sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    static int[] generate(int n){
        Random rnd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }
        return arr;
    }
}
