package queue;

import java.util.Random;

public class Main extends LoopQueue{

    //比较普通队列与循环队列在操作上的时间复杂度的不同
    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < opCount; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 10000000000.0;
    }
    public static void main(String[] args){

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time:" + time1 + "S");

        LoopQueue<Integer> LoopQueue = new LoopQueue<>();
        double time2 = testQueue(arrayQueue, opCount);
        System.out.println("LoopQueue, time:" + time2 + "S");
    }
}

//输出为
//ArrayQueue, time : 8.23423453 s
//LoopQueue, time :  0.063838492 s