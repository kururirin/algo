public class MyArrayList<E> {
    private E[] elements;
    private int capacity = 256;
    private int size = 0;

    public MyArrayList() {
        this.elements = (E[]) new Object[this.capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.elements = (E[]) new Object[this.capacity];
    }

    public int size() {
        return this.size;
    }

    public void doubleSize() {
        capacity = capacity * 2;
        E[] newElements = (E[]) new Object[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    public void add(E element) {
        if (this.size == this.capacity) {
            this.doubleSize();
        }
        this.elements[this.size] = element;
        this.size++;
    }

    public void validIndex(int index) {
        if (index <0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
    }

    public E get(int index) {
        this.validIndex(index);
        return this.elements[index];
    }

    public void set(int index, E element) {
        this.validIndex(index);
        this.elements[index] = element;
    }

    public void insert(int index, E element) {
        this.validIndex(index);
        if (this.size == this.capacity) {
            this.doubleSize();
        }
        this.size ++;
        E newElement = element;
        for (int i=index;i<this.size;i++){
            E tempElement = this.elements[i];
            this.elements[i] = newElement;
            newElement = tempElement;
        }
    } // set value to index i, 后面shift

    public void delete(int index) {
        this.validIndex(index);
        for (int i=index; i<this.size;i++){
            this.elements[i] = this.elements[i+1];
        }
        this.size--;

    } // delete index i, 后面shift

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i =0; i<this.size-1; i++){
            sb.append(this.elements[i] + ",");
        }
        sb.append(this.elements[this.size-1]);
        sb.append("]");
        return sb.toString();
    }

    public void print() {
        // print whole array list contents
        System.out.println(this);
    }
}