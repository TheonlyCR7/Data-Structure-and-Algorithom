package array;

public class main {
    public static void main(String[] args){

        //创建数据类型为整型数组，泛类
        array<Integer> arr = new array<Integer>();
        for (int i = 0; i < 10; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.delete(2);
        System.out.println(arr);


        System.out.println(arr);
    }
}
