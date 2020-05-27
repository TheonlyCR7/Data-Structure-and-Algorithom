package Sort;

import java.util.Arrays;

import static Sort.SortExample.*;

// 快速排序
public class SelectSort {
    public static void sort(Comparable[] b){

        // 复制数组
        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        int N = a.length;
        for(int i = 0; i < N; i ++){
            int min = i;
            for(int j = i+1; j < N; j++)
                if(less(a[j], a[min]))   // 当 a[j] < a[min]时，为true  所以为从小到大排列
                    min = j;
            exch(a, i, min);   // 在数组a中交换索引为 i min 的数据
        }
        if(!isSorted(a))
            System.out.println("选择排序失败");
        // System.out.println(Arrays.toString(a));
    }
}
