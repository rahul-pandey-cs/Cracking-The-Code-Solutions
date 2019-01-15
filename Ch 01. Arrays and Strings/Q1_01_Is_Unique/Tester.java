package Q1_01_Is_Unique;

// Question: Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

public class Tester {
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			boolean wordA =  QuestionA.isUniqueChars(word);
			boolean wordB =  QuestionB.isUniqueChars(word);
			boolean wordC = MyImplementation.isUniqueChars(word);
			if (wordA == wordB == wordC) {
				System.out.println(word + ": " + wordA);
			} else {
				System.out.println(word + ": " + wordA + " vs " + wordB + " vs " + wordC);
			}
		}
	}
}
