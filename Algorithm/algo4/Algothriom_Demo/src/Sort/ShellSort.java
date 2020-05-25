package Sort;

import java.util.Arrays;
import java.util.Random;

import static Sort.SortExample.*;
// 优化后的插入排序
public class ShellSort {
    public static void sort(Comparable[] b) {

        Comparable[] a = new Comparable[b.length];
        for(int i = 0; i < b.length; i ++)
            a[i] = b[i];
        int n = a.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;

        //System.out.println(Arrays.toString(b));
        while (h >= 1) {
            // 将数组排序
            for (int i = h; i < n; i++)
                // 将 a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h]  之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            h /= 3;
            //System.out.println(Arrays.toString(b));
        }
        if(!isSorted(b))
            System.out.println("希尔排序失败");
    }

    public static void main(String[] args) {
        Comparable[] test2 = new Comparable[10];
        Random random = new Random();
        for(int i = 0; i < 10; i ++)
            test2[i] = random.nextInt(10);
        sort(test2);
    }
}
