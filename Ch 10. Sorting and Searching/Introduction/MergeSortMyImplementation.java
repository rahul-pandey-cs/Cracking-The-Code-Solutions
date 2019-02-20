package Introduction;

import CtCILibrary.AssortedMethods;

public class MergeSortMyImplementation {

    static void mergeSortImpl(int arr[]) {

        int[] helper = new int[arr.length];
        mergeSortImpl(arr, 0, arr.length - 1, helper);
    }

    static void mergeSortImpl(int arr[], int left, int right, int[] helper) {

        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortImpl(arr, left, mid, helper);
            mergeSortImpl(arr, mid + 1, right, helper);
            merge(arr, left, mid, right, helper);
        }
    }

    static void merge(int[] arr, int left, int mid, int right, int[] helper) {

        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }
        int leftHelper = left;
        int rightHelper = mid + 1;
        int current = left;

        while (leftHelper <= mid && rightHelper <= right) {
            if (helper[leftHelper] <= helper[rightHelper]) {
                arr[current] = helper[leftHelper];
                leftHelper++;
            } else {
                arr[current] = helper[rightHelper];
                rightHelper++;
            }
            current++;
        }

        int remaining = mid - leftHelper;
        for (int j = 0; j <= remaining; j++) {
            arr[current + j] = helper[leftHelper + j];
        }
    }

    public static void main(String[] args) {
        int size = 20;
        int[] arr = AssortedMethods.randomArray(size, 0, size - 1);
        int[] validate = new int[size];
        AssortedMethods.printIntArray(arr);
        for (int i = 0; i < size; i++) {
            validate[arr[i]]++;
        }
        AssortedMethods.printIntArray(validate);
        mergeSortImpl(arr);
        for (int i = 0; i < size; i++) {
            validate[arr[i]]--;
        }
        AssortedMethods.printIntArray(arr);
        AssortedMethods.printIntArray(validate);
        for (int i = 0; i < size; i++) {
            if (validate[i] != 0 || (i < (size - 1) && arr[i] > arr[i + 1])) {
                System.out.println("ERROR");
            }
        }
    }
}
