package Introduction;

public class BinarySearchMyImplementation {


    static int binarySearchRecursiveMyImpl(int arr[], int element, int left, int right) {

        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (arr[mid] < element)
            return binarySearchRecursiveMyImpl(arr, element, mid + 1, right);
        else if (arr[mid] > element)
            return binarySearchRecursiveMyImpl(arr, element, left, mid - 1);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 9, 12, 15, 18};
        for (int i = 0; i < 20; i++) {
            int loc = BinarySearch.binarySearch(array, i);
            int loc2 = BinarySearch.binarySearchRecursive(array, i, 0, array.length - 1);
            int loc3 = BinarySearch.binarySearchRecursiveClosest(array, i, 0, array.length - 1);
            int loc4 = binarySearchRecursiveMyImpl(array, i, 0, array.length - 1);
            System.out.println(i + ": " + loc + " " + loc2 + " " + loc3 + " " + loc4);
        }
    }

}
