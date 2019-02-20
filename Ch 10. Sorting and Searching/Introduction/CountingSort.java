package Introduction;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class CountingSort {

    static void countingSortImpl(int arr[]) {

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        Arrays.fill(count, 0);

        System.out.println("Max: " + max + "Min: " + min + "Count: " + Arrays.toString(count) + ": " + count.length + ": " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        System.out.println(Arrays.toString(count));
        for (int j = 1; j < count.length; j++) {
            count[j] += count[j - 1];
        }

        System.out.println(Arrays.toString(count));
        for (int k = 0; k < arr.length; k++) {
            output[count[arr[k] - min] - 1] = arr[k];
            count[arr[k] - min]--;
        }

        for (int l = 0; l < arr.length; l++) {
            arr[l] = output[l];
        }

    }

    public static void main(String[] args) {
        int[] arr = AssortedMethods.randomArray(20, 0, 6);
        AssortedMethods.printIntArray(arr);
        countingSortImpl(arr);
        AssortedMethods.printIntArray(arr);
    }
}
