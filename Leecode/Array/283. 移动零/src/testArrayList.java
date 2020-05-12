import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class testArrayList {
    public static void main(String[] args) {
        //创建集合对象，接口new实现类
        List list=new ArrayList();
        //1  add
        list.add("hello");
        list.add(123);//自动装箱
        //list.add(new Scanner(System.in));
        //2   集合中元素个数
//        System.out.println(list.size());
//        System.out.println("是否为空 "+list.isEmpty());
//        System.out.println(list);

        List list2 = new ArrayList();
        list2.add("hello");
        list2.add(123);
        // 将list2 所有元素都加入 list
        list.addAll(list2);
//        System.out.println("list集合中的元素个数"+list.size());
//        System.out.println(list2);
          System.out.println(list);

        //		list.remove(123);
        list.remove(0);
        // System.out.println(list);
        list.remove(new Integer(123));    //认为123是索引
        // System.out.println(list);

        //认为123是索引
        }
    }


