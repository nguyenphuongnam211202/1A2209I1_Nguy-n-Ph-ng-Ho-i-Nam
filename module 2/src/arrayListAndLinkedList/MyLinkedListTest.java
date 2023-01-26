package arrayListAndLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(2);
        linkedList.addFirst(5);
        linkedList.addFirst(3);
        linkedList.addLast(4);
        linkedList.printList();
    }
}
