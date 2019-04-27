package Q8_09_Parens;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionB {
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem) return; // invalid state
		
		if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
			list.add(String.copyValueOf(str));
			System.out.println("Current value in list: " + list.toString());
		} else {
			str[index] = '('; // Add left and recurse
			System.out.println("STR now 1: " + Arrays.toString(str));
			addParen(list, leftRem - 1, rightRem, str, index + 1);
			System.out.println("STR now 2: " + Arrays.toString(str));

			str[index] = ')'; // Add right and recurse
			addParen(list, leftRem, rightRem - 1, str, index + 1);
			System.out.println("STR now 3: " + Arrays.toString(str));
		}
	}
	
	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = generateParens(3);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());		
	}

}
