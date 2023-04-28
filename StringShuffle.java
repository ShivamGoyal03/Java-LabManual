// Shuffle String & print

import java.util.*;
public class StringShuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();
        char[] shuffle = str.toCharArray();
        shuffle(str, shuffle);
    }

    static void shuffle(String str, char[] shuffle){
        Random rm = new Random();
        for (int i = 0; i < shuffle.length; i++) {
            int index = rm.nextInt(shuffle.length);
            char temp = shuffle[i];
            shuffle[i] = shuffle[index];
            shuffle[index] = temp;
        }

        String str1 = new String(shuffle);
        System.out.println("Original : " + str + '\n' + "New : " + str1);
    }
}
