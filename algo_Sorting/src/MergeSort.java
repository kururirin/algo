import java.util.Arrays;
public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int[] helper = new int[array.length];
        sort(array, helper, 0, array.length - 1);
    }

    private static void sort(int[] array, int[] helper, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, helper, left, mid);
            sort(array, helper, mid + 1, right);
            merge(array, helper, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (helper[i] <= helper[j]) {
                array[k++] = helper[i++];
            } else {
                array[k++] = helper[j++];
            }
        }
        while (i <= mid) {
            array[k++] = helper[i++];
        }
        // No need to copy remaining elements from the right subarray because they are already in their correct place.
    }
    public static void main(String[] args) {
        int[] array = { 5, 2, 9, 1, 5, 6 };
        System.out.println("Before sorting: " + Arrays.toString(array));
        MergeSort.mergeSort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
