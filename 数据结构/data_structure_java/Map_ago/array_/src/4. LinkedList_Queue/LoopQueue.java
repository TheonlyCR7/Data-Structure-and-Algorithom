package LinkedList_Queue;

import queue.Queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){

        //创建data泛类
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    //默认容量
    public LoopQueue(){
        this(10);
    }

    //获取容量
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return front == tail ;
    }

    @Override
    public int getSize(){
        return size;
    }

    //入队操作
    @Override
    public void enqueue(E e){

        //队列已满的条件
        if((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    //出队操作
    @Override
    public E dequeue(){

        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        //判断是否扩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    //获取队首
    @Override
    public E getFront(){
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty");
        return data[front];
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, data.length));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1)% data.length != tail)
                res.append("，");
        }
        res.append("] tail");
        return res.toString();
    }
    //空间扩容
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < size; i ++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<Integer>();

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
