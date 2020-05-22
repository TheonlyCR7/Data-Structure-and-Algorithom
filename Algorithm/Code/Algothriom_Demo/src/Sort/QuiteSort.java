package Sort;

public class QuiteSort {
    public static void sort(Comparable[] a){

        int N = a.length;
        for(int i = 0; i < N; i ++){
            int min = i;
            for(int j = i+1; j < N; i++)
                if(less(a[j], a[min]))
                    min = j;

        }
    }
}
