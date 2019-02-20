package Q1_06_String_Compression;

// String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string,
// your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).

public class Tester {

	public static void main(String[] args) {
		String str = "aaaaabbbbaaaabbddc";
		System.out.println(str);
		System.out.println(QuestionA.compressBad(str));
		System.out.println(QuestionB.compress(str));
		System.out.println(QuestionC.compress(str));
		System.out.println(MyImplementation.compress(str));
	}

}
