
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class sortMethod<T extends Comparable> {

    public T[] selectionSort(T arr[], int n) {

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            T middle = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = middle;
        }
        return arr;
    }

    public T[] insertionSort1(T arr[], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    T middle = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = arr[j];
                } else
                    break;
            }
        }
        return arr;
    }

    public T[] insertionSort2(T arr[], int n) {
        for (int i = 0; i < n; i++) {
            T e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
        return arr;
    }

    // 希尔排序
    public T[] shellsort(T a[], int n) {
        int i, j, gap;

        for (gap = n / 2; gap > 0; gap /= 2) //步长
            for (i = 0; i < gap; i++)        //直接插入排序
            {
                for (j = i + gap; j < n; j += gap)
                    if (a[j].compareTo(a[j - gap]) > 0) {
                        T temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k].compareTo(temp) > 0) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
            }
        return a;
    }

    // 归并排序
    public void mergeSort(T arr[], int n){
        mergeSort(arr, 0, n-1);
    }

    private T[] mergeSort(T arr[], int l, int r){

        if (l >= r)
            return arr;

        int mid = (l+r) / 2;
        mergeSort(arr, l , mid);
        mergeSort(arr, mid+1, r);
        mergeSort(arr, l, mid, r);

        return arr;
    }

    private T[] mergeSort(T arr[], int l, int mid, int r){
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        for(int i = l; i <= r; i++)
            aux[i-l] = arr[i];

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i =l, j = mid+l;
        for(int k = l; k <= r; k++){
            if(i > mid){       // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j ++;
            }else if(j > r){    // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i ++;
            }else if(aux[i-l].compareTo(aux[j-l]) < 0){ // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l];
                i++;
            }else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l];
                j ++;
            }
        }
    }


    public static void main(String[] args) {
        sortMethod<Integer> test = new sortMethod<Integer>();
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer arr1[] = new Integer[n];
        Integer arr2[] = new Integer[n];
        Integer arr3[] = new Integer[n];
        Integer arr4[] = new Integer[n];

        for (int i = 0; i < n; i ++) {    // 随机数生成
            arr1[i] = random.nextInt(n*10);
            arr2[i] = random.nextInt(n*10);
            arr3[i] = random.nextInt(n*10);
            arr4[i] = random.nextInt(n*10);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));

        double start_time = System.nanoTime();   // 记录当前时间 纳秒

        System.out.println("0: " + Arrays.toString(test.selectionSort(arr1, n )));

        double end_time = System.nanoTime();  // 记录当前时间 纳秒

        double start_time1 = System.nanoTime();

        System.out.println("1: " + Arrays.toString(test.insertionSort1(arr2, n )));

        double end_time1 = System.nanoTime();

        double start_time2 = System.nanoTime();

        System.out.println("2: " + Arrays.toString(test.insertionSort2(arr3, n )));

        double end_time2 = System.nanoTime();

        double start_time3 = System.nanoTime();

        System.out.println("3: " + Arrays.toString(test.shellsort(arr4, n )));

        double end_time3 = System.nanoTime();

        System.out.println("selectionSort: " + (end_time - start_time) / 1000000000 + " s");
        System.out.println("insertionSort1: " + (end_time1 - start_time1) / 1000000000 + " s");
        System.out.println("insertionSort2: " + (end_time2 - start_time2) / 1000000000 + " s");
        System.out.println("shellsort: " + (end_time3 - start_time3) / 1000000000 + " s");
    }
}
