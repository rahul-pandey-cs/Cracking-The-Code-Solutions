package Q1_09_String_Rotation;

public class MyImplementation {

// String Rotation: Assume you have a method isSubstringwhich checks if one word is a substring of another. Given two strings, sl and s2,
// write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").

// O(n) Complexity

    public static boolean isRotation(String word1, String word2) {

        if(word1.length() != word2.length())
            return false;

        for (int i = 0; i < word1.length(); i++) {
            if((word1.substring(i+1, word1.length()) + word1.substring(0,i+1)).equals(word2))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
