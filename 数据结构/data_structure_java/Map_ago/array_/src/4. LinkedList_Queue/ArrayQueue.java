package LinkedList_Queue;

import queue.Array;
import queue.Queue;

public class ArrayQueue<E> implements Queue<E> {

    private queue.Array<E> array;

    public ArrayQueue(int capacity){
        //创建array类的对象
        array = new queue.Array<E>(capacity);
    }

    public ArrayQueue(){
        array = new Array<E>();
    }

    //表示堆父类方法的重写
    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);
    }

    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue");
        res.append("front[");
        for (int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append("，");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
