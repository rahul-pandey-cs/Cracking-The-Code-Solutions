package Q1_06_String_Compression;

public class MyImplementation {

    public static String compress(String str) {

        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < str.length() - 1; ) {
            int count = 1;
            char c = str.charAt(i);
            boolean flagDuplicates = false;
            while (str.charAt(i) == str.charAt(i + 1)) {
                flagDuplicates = true;
                i++;
                count++;
            }
            if (count > 0 && flagDuplicates)
                strBuild.append(c).append(count);
            else i++;

            if (i == str.length() - 1) {
                strBuild.append(str.charAt(i)).append(1);
            }
        }
        return strBuild.toString();
    }
}
