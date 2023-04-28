// Vowel Print

import java.util.*;

public class PrintVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();
        int[] arr = new int[7];
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case ' ':
                    break;
                case 'a':
                    arr[0]++;
                    arr[1]++;
                    break;
                case 'e':
                    arr[0]++;
                    arr[2]++;
                    break;
                case 'i':
                    arr[0]++;
                    arr[3]++;
                    break;
                case 'o':
                    arr[0]++;
                    arr[4]++;
                    break;
                case 'u':
                    arr[0]++;
                    arr[5]++;
                    break;
                default:
                    arr[6]++;
            }
        }
        System.out.println("a : " + arr[1] + ", e : " + arr[2] + ", i : " + arr[3] + ", o : " + arr[4] + ", u : " + arr[5] + "\nTotal Vowels : " + arr[0]);
    }
}
