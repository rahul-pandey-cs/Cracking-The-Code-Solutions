package Q1_02_Check_Permutation;

// Check Permutation: Given two strings,write a method to decide if one is a permutation of the other.
public class Tester {

    public static void main(String[] args) {

        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];

            boolean anagram = QuestionA.permutation(word1, word2);
            boolean anagram1 = QuestionB.permutation(word1, word2);
            boolean anagram2 = MyImplementation.permutation(word1, word2);
            boolean anagram3 = MyImplementation.efficientPermutation(word1, word2);


            System.out.println(word1 + ", " + word2 + ": " + anagram + ", 2nd solution: " + anagram1 + ", 3rd solution: " + anagram2 + ", 4th Solution: " + anagram3);
        }
    }
}
