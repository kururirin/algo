public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        for (int i=0;i<10;i++){
            myList.add(i);
        }
        System.out.println(myList.size());
        System.out.println(myList);
        System.out.println(myList.get(5));

        myList.add(2,200);
        System.out.println(myList);

        myList.remove(2);
        System.out.println(myList);
    }
}
