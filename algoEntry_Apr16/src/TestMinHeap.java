public class TestMinHeap {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = 300 - i;
        }
        MinHeap minHeap = new MinHeap(array);

        for (int i = 15; i >= 0; i--) {
            minHeap.add(i);
        }
        minHeap.extractMin();
        System.out.println(minHeap);
    }
}
