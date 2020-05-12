import java.util.Random;

public class Main {

    //传进数组  和  是否为堆
    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        //判断数组是否为堆
        if(isHeapify)
            //如果是，则创建最大堆
            maxHeap = new MaxHeap<>(testData);
        else {
            //如果不是，创建新堆，将数组元素不断添加到其中
            maxHeap = new MaxHeap<>();
            for (int num : testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0; i < testData.length; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1; i < testData.length; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    public static void main( String [] args){

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for(int i = 0; i < n; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1; i < n; i ++)
            if(arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed");



        Integer[] testData = new Integer[n];
        for(int i = 0; i < n; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        //参数为false， 需要新建一个堆，再将数组中的元素添加到堆中   复杂度为O(nlog(n))
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        //参数为true,  将数组按堆的规则排序，复杂度为 (log(n))
        double time2 = testHeap(testData, true);
        System.out.println("with heapify: " + time2 + " s");

    }
}

//输出
//        Test MaxHeap completed
//        Test MaxHeap completed
//        Without heapify: 1.0158609 s
//        Test MaxHeap completed
//        with heapify: 0.7793214 s
