import java.util.*;

public class Rep_arr {
    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size = sn.nextInt();
	    int arr[]=new int[size];
	    for(int i=0;i<arr.length;i++){
		    int val=sn.nextInt();
		    if(val>size){
			    System.out.println("enter value below" + size);
                i--;
    		}
	    	else{
		    	arr[i]=val;
		    }
	    }

    	Arrays.sort(arr);

	    int n = arr.length;
        int[] freq = new int[n + 1];
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }
	

	    // Step 2: Print repeating elements
        System.out.print("Repeating elements: ");
        for (int i = 1; i <= n; i++) {
            if (freq[i] > 1) {
                System.out.print(i + " " + freq[i]);
            }
        }
        System.out.println();
        // Step 3: Find missing element
        int missingElement = -1;
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) {
                missingElement = i;
                break;
            }
        }

        // Step 4: Print missing element
        System.out.println("Missing element: " + missingElement);
	}
}