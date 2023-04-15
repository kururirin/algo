public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> newArrayList = new MyArrayList<>();

        for (int i =0; i< 300;i++) {
            newArrayList.add(i);
        }

        System.out.println(newArrayList.size());
        newArrayList.delete(1);
        System.out.println(newArrayList.size());
        newArrayList.print();
        newArrayList.insert(1,1);
        System.out.println(newArrayList.size());
        newArrayList.print();
    }
}