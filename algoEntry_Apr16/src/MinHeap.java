public class MinHeap {
    private int[] array;
    private int currSize;
    private int capacity;

    public MinHeap() {
        this.currSize = 0;
        this.capacity = 8;
        this.array = new int[this.capacity];
    }

    public MinHeap(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        this.currSize = input.length;
        this.capacity = input.length * 2;
        this.array = new int[this.capacity];

        for (int i = 0; i < this.currSize; i++) {
            this.array[i] = input[i];
        }
        buildHeap();

    }

    private void buildHeap() {
        for (int i = (this.currSize - 1) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    private void minHeapify(int i) {
        int p = i;
        while (p < this.currSize) {
            int l = left(p);
            int r = right(p);

            int min = p;

            if (l < this.currSize && array[l] < array[p]) { // if left child is smaller than the parent
                min = l;
            }
            if (r < this.currSize && array[r] < array[min]) {// if right child is smaller than the current min
                min = r;
            }

            if (min != p) {
                swap(p, min);
                p = min;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void doubleTheSize() {
        this.capacity *= 2;
        int[] bigArray = new int[this.capacity];
        for (int i = 0; i < this.currSize; i++) {
            bigArray[i] = this.array[i];
        }
        this.array = bigArray;
    }

    public int getMin() {
        return this.array[0];
    }

    public int extractMin() {
        if (this.currSize < 1) {
            throw new IllegalStateException("Out of Boundary");
        }
        int min = this.array[0];
        swap(0, --this.currSize);
        minHeapify(0);
        return min;
    }

    public void add(int val) {
        if (this.currSize == this.capacity) {
            doubleTheSize();
        }
        this.array[this.currSize] = val;
        int cur = this.currSize++;
        while (cur >= 0) {
            int p = parent(cur);
            if (p >= 0 && array[cur] < array[p]) { // from bottom to top
                swap(p, cur);
                cur = p;
            } else {
                break;
            }
        }
    }

    public int size() {
        return this.currSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.currSize - 1; i++) {
            sb.append(this.array[i] + ",");
        }
        sb.append(this.array[this.currSize - 1] + "]");
        return sb.toString();
    }
}
