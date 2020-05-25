package Sort;

import java.util.Scanner;

/**
 *排序算法类的模板
 */
public class SortExample {
    public static void sort(Comparable[] a){
        //排序算法实现
    }

    public static boolean less(Comparable v, Comparable w){
        //对元素进行比较
        return v.compareTo(w)<0;
    }

    public static void exch(Comparable[] a,int i,int j){
        //交换元素
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void show(Comparable[] a){
        //在单行中打印数组
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"");
            System.out.println();
        }
    }

    public static boolean isSorted(Comparable[] a){
        //测试数组元素是否有序
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static  void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String line=scanner.nextLine();
            String[] a=line.split(" ");
            sort(a);
            assert isSorted(a);
            show(a);
        }


    }
}
