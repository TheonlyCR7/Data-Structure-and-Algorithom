package Sort;


import static Sort.SortExample.*;

public class insertSort {
    public static void sort(Comparable[] b){

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        int N = a.length;
        for(int i = 0; i < N; i ++){
            // 循环时要保证当前索引数据小于左边的数据  否则终止循环
            for(int j = i; j > 0 && less(a[j], a[j-1]); j --)
                exch(a, j, j-1);
        }
        if(!isSorted(a))
            System.out.println("插入排序失败");
        // System.out.println(Arrays.toString(a));
    }
}
