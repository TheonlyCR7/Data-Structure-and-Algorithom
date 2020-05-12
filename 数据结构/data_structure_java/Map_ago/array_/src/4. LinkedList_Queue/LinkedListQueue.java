package LinkedList_Queue;

import Linked_List.LinkedList;
import Linked_List.Stack;

public class LinkedListQueue<E> implements Queue<E> {

    //内部类
    //将节点设置为私有
    private class Node{
        //设置为公开
        //存放数据
        public E e;
        public Node next;

        public Node(E e, Node next){
            //将用户传来的数据转为节点，链接
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    //构造函数
    public LinkedListQueue(){

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    //入队操作
    @Override
    public void enqueue(E e){
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }
        else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    //出队操作
    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("dequeue failed");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null)
            tail = null;
        size --;
        return retNode.e;

    }

    //获取首个元素
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue failed");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");

        Node cur = head;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
