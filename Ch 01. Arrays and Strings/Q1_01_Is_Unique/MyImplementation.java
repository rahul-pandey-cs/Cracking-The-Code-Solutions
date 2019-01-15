package Q1_01_Is_Unique;

public class MyImplementation {
    public static boolean isUniqueChars(String inputString){
        int checker = 0;
        for(int i = 0; i<inputString.length(); i++){

            int val = inputString.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) return false;

            checker |= 1 << val;
        }
        return true;
    }
}
