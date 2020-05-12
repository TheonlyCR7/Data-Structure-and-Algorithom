package Stack;

import java.lang.reflect.Array;

public class ArrayStack<E> implements Stack<E> {


    //定义一个泛类
    array<E> array;

    //用户输入容积大小
    public ArrayStack(int capacity){
        array = new array<E>(capacity);
    }

    //创建一个泛类数组
    public ArrayStack(){
        array = new array<E>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    //判断数组是否为空
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    //获得容积
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    //去掉最后一个数据
    public E pop(){
        return array.removeLast();
    }

    //获取最后一位数据
    @Override
    public E peek(){
        return array.getLast();
    }

    //将栈作为结果形成字符串
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append("，");
        }
        res.append("] top");
        return res.toString();
    }
}
