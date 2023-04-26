public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        int temp = arr[right];
        arr[right] = arr[start];
        arr[start] = temp;
        return right;
    }
}
