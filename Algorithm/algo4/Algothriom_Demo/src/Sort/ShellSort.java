package Sort;

import java.util.Arrays;
import java.util.Random;

import static Sort.SortExample.*;
// 优化后的插入排序
public class ShellSort {
    public static void sort(Comparable[] b) {

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);
        int n = a.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            // 将数组排序
            for (int i = h; i < n; i++){  // i++ 进入下一个小数组的排序  每隔 h-1个元素为一个数组
                // 将 a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h]  之中
                // 先进行判断 a[j-h] 是否大于 a[j]  若不是不交换
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {  // 保证这个小数组的有序性
                    exch(a, j, j - h);
                }
            }

            h /= 3; // h 变化  当 h变为 1 时， 变为普通插入排序
        }
        if(!isSorted(a))
            System.out.println("希尔排序失败");
    }

    public static void main(String[] args) {
        Comparable[] test2 = new Comparable[10];
        Random random = new Random();
        for(int i = 0; i < 10; i ++)
            test2[i] = random.nextInt(100);
        sort(test2);
    }
}
