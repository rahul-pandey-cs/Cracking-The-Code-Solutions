package Introduction;

import CtCILibrary.AssortedMethods;

public class QuickSortMyImplementation {


    static void quickSortImpl(int arr[], int left, int right) {

        int index = partition(arr, left, right);
        if (left < index-1) {
            quickSortImpl(arr, left, index-1);
        }

        if (right > index) {
            quickSortImpl(arr, index, right);
        }
    }

    static int partition(int arr[], int left, int right) {

        int pivot = arr[(left + right ) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr = AssortedMethods.randomArray(20, 0, 6);
        int[] arr1 = arr.clone();
        AssortedMethods.printIntArray(arr);
        AssortedMethods.printIntArray(arr1);
        Quicksort.quickSort(arr1, 0, arr1.length - 1);
        AssortedMethods.printIntArray(arr1);
        quickSortImpl(arr, 0, arr.length - 1);
        AssortedMethods.printIntArray(arr);
    }
}
