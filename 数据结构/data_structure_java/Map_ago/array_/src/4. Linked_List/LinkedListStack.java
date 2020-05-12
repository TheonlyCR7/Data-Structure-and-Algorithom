package Linked_List;

import queue.ArrayQueue;
import queue.LoopQueue;
import queue.Queue;

import java.util.Random;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    //构造函数
    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E pop(){
        return list.deleteElement(0);
    }

    @Override
    public E peek(){
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(list);
        return res.toString();
    }

    //比较普通队列与循环队列在操作上的时间复杂度的不同
    private static double testStack(Stack<Integer> stack, int opCount){
        //记录初始值
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < opCount; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i ++)
            stack.pop();

        //记录结束值
        long endTime = System.nanoTime();

        //单位为纳秒，除以100亿，为秒
        return (endTime - startTime) / 10000000000.0;
    }
    public static void main(String[] args){

        int opCount = 100000;

        ArrayStack<Integer> arraystack = new ArrayStack<>();
        double time1 = testStack(arraystack, opCount);
        System.out.println("ArrayStack, time:" + time1 + "S");

        LinkedListStack<Integer> linedListStack = new LinkedListStack<>();
        double time2 = testStack(linedListStack, opCount);
        System.out.println("LinkedListStack, time:" + time2 + "S");
    }

    //输出结果为
    // ArrayStack, time: 0.06348539 s
    // LinkedListStack, time: 0.02843534 s
    //链表占用空间较小
    //两者复杂度上区别不大，但链表进行new操作较多
}
