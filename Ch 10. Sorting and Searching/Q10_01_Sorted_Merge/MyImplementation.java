package Q10_01_Sorted_Merge;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class MyImplementation {

    static void mergeArrayandSort(int[] arr1, int[] arr2, int size1, int size2) {

        int current = size1 + size2 - 1;
        int left = size1 - 1;
        int right = size2 - 1;


        while (right >= 0) {
            if (left >= 0 && arr1[left] > arr2[right]) {
                arr1[current] = arr1[left];
                left--;
            } else {
                arr1[current] = arr2[right];
                right--;
            }
            current--;
        }

        System.out.println(Arrays.toString(arr1));
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 6, 7, 7, 7};
        mergeArrayandSort(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }
}
