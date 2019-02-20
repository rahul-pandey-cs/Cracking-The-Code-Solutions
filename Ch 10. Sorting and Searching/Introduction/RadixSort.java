package Introduction;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class RadixSort {

    static void countingSortForRadixImpl(int[] arr, int exp) {

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        System.out.println(" Value: " + Arrays.toString(count));
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        System.out.println(" Value: " + Arrays.toString(count));
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = AssortedMethods.randomArray(20, 0, 169);
        AssortedMethods.printIntArray(arr);

        int m = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; m / exp > 0; exp = exp * 10) {
            countingSortForRadixImpl(arr, exp);
            System.out.println(" Array now: " + Arrays.toString(arr));
        }

        AssortedMethods.printIntArray(arr);

    }
}
