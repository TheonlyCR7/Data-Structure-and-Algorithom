package Linked_List;

public class main {

    public static void main(String[] args){

        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 10; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.addElement(2, 999);
        System.out.println(linkedList);

        linkedList.deleteElement(7);
        System.out.println(linkedList);

        linkedList.deleteFirst();
        System.out.println(linkedList);

        linkedList.deleteLast();
        System.out.println(linkedList);
    }
}
