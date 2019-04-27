package Q8_07_Permutations_Without_Dups;

import java.util.*;

//other implementation: https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

// Better: https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/

public class QuestionC {

    public static void getPerms(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) {
            result.add(prefix);
            System.out.println("Added prefix is " + prefix);
        }
        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            System.out.println("Remainder is " + remainder);
            String before = remainder.substring(0, i);
            System.out.println("Before is " + before);
            String after = remainder.substring(i + 1, len);
            System.out.println("After is " + after);
            char c = remainder.charAt(i);
            System.out.println("Passed prefix is " + prefix);
            System.out.println("Prefix + " + c + " is " + prefix + c);
            getPerms(prefix + c, before + after, result);

        }
    }

    public static ArrayList<String> getPerms(String str) {
        ArrayList<String> result = new ArrayList<String>();
        getPerms("", str, result);
        System.out.println("Result is " + result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
