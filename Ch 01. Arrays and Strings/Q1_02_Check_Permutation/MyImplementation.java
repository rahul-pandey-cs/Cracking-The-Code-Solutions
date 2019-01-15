package Q1_02_Check_Permutation;

// Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

import java.util.Arrays;

public class MyImplementation {

    public static boolean permutation(String word1, String word2) {

        if (sort(word1).equals(sort(word2))) {
            return true;
        } else return false;
    }

    public static String sort(String unsorted) {
        char[] content = unsorted.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean efficientPermutation(String word1, String word2){
        if(word1.length()!=word2.length()){
            return false;
        }

        int[] storeChar = new int[128];
        for(int i = 0; i < word1.length() ; i++){
            storeChar[word1.charAt(i)]++;
        }

        for(int i = 0; i < word2.length() ; i++){
            storeChar[word2.charAt(i)]--;
            if(storeChar[word2.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
