package Q1_05_One_Away;

public class MyImplementation {


    public static boolean oneEditAwayImpl(String a, String b) {

        String s1 = a.length() > b.length() ? b : a;
        String s2 = a.length() > b.length() ? a : b;
        boolean differenceFound = false;
        int index1 = 0, index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (differenceFound) return false; //second difference found between two
                differenceFound = true;
                if (s1.length() == s2.length())
                    index1++;
            } else { // if both strings are equal
                index1++;
            }
            index2++;
        }
        return true;
    }


// Not correctly working

    public static boolean oneEditAway(String a, String b) {

        int count = Math.abs(a.length() - b.length()), length = a.length() > b.length() ? b.length() : a.length();
        int j = 0;
        System.out.println("Input is: " + a + " , " + b);
        System.out.println("Length is: " + length + "and count: " + count);

        for (int i = 0; i < length; i++, j++) {
            if (a.charAt(i) != b.charAt(j) && a.length() == b.length())
                count++;
            else if (a.charAt(i) != b.charAt(j) && a.length() != b.length()) {
                count++;
                if (i < length - 1 && a.length() > b.length())
                    i++;
                else if (i < length - 1 && a.length() < b.length())
                    j++;
            }
        }
        return count <= 1 ? true : false;
    }
}
