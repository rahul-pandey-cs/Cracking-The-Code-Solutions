package Q1_04_Palindrome_Permutation;

import java.util.Arrays;

public class MyImplementation {

    public static boolean isPermutationOfPalindrome(String inputStrings) {

        System.out.println(inputStrings.toLowerCase());
        int[] charCount = new int[128];
        for (int i = 0; i < inputStrings.length(); i++) {
            System.out.println("Character added: " + inputStrings.charAt(i));
            if (inputStrings.toLowerCase().charAt(i) > 96 && inputStrings.toLowerCase().charAt(i) < 123) {

                  charCount[(int) inputStrings.toLowerCase().charAt(i)]++;
            }
        }

        System.out.println(Arrays.toString(charCount));

        int oddCount = 0;
        for (int k = 0; k < 128; k++) {
            if (charCount[k] % 2 == 0)
                continue;
            else if (charCount[k] != 0) {
                oddCount++;
                if (oddCount > 1)
                    return false;
            }
        }
        return true;
    }
}
