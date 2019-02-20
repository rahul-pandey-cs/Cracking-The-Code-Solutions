package Q1_03_URLify;

import CtCILibrary.AssortedMethods;

/*

  URLify:
  Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
  EXAMPLE:
  Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"

*/

public class MyImplementation {

    public static char[] URLify(char[] url, int length) {
        int space = 0;


        for (int i = 0; i < length; i++) {
            if (url[i] == ' ')
                space++;
        }

        System.out.println("Space is: " + space);
        int endPoint = length + space * 2;

        if (length < url.length) url[length] = '\0';

        for (int i = length - 1; i >= 0; i--) {
            if (url[i] == ' ') {
                url[endPoint - 1] = '0';
                url[endPoint - 2] = '2';
                url[endPoint - 3] = '%';
                endPoint -= 3;
            } else {
                url[endPoint - 1] = url[i];
                endPoint--;
            }
        }
        return url;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = 13;
        arr = URLify(arr, trueLength);
        //System.out.println(result);
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
    }
}