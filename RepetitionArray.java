import java.util.*;

public class RepetitionArray{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the size of Array: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		for(int i=0 ; i<size ; i++){
			System.out.print("Enter element "+(i+1)+": ");
			int val=sc.nextInt();
			if(val>size){
				System.out.println("Enter value below "+size);
				System.out.println();
				i--;
			}
			else{
				arr[i]=val;
			}
		}

		Arrays.sort(arr);

	    int[] freq = new int[size + 1];
	    for (int i = 0; i < size; i++) {
	        freq[arr[i]]++;
	    }
		

		// Step 2: Print repeating elements
	    System.out.println("\nRepeating elements in the array");
	    for (int i = 1; i <= size; i++) {
	        if (freq[i] > 1) {
	            System.out.println(" "+i+", Frequency: "+freq[i]);
	        }
	    }


	    // Step 3: Find missing element
	    System.out.print("\nMissing element:");
	    int missingElement = -1;
	    for (int i = 1; i <= size; i++) {
	        if (freq[i] == 0) {
	            missingElement = i;
	            System.out.print(" " + missingElement);
	        }
	    }
	    System.out.println();
	}
}