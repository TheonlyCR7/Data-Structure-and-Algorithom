package stack_leecode;

//import java.util.Stack;
public class Solution {

    public interface Stack<E> {

        int getSize();
        boolean isEmpty();
        void push(E e);

        E peek();

    }

    public class array<E> {

        //封装类，成员变量为私有
        private E[] data;
        private int size;

        //构造函数，传入数组容量
        public array(int capacity) {
            //java不支持new建立泛类,通过Object来建立
            data = (E[])new Object[capacity];
            size = 0;
        }

        //若不传入，默认为10
        public array() {
            this(10);
        }

        public int getSize() {
            return size;
        }

        //返回数组长度
        public int getCapacity() {
            return data.length;
        }

        //数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }


        public void addLast( E e) {

            //查看是否报错
            if (size == data.length) {
                throw new IllegalArgumentException("Addlast failed. array is full");
            }
            data[size] = e;
            size++;
        }

        public void addFirst(E e){
            for (int i = 0; i >= size - 1; i++){
                data[i + 1] = data[i];
            }
            data[0] = e;
        }

        public void add(int index, E e) {

            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Add failed. array is full");
            }

            //若不够，就扩容
            if(size == data.length)
                resize(2 *data.length);

            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = e;
            size++;
        }

        //获取index索引位置的元素
        public E get(int index){
            if(index < 0|| index >= size){
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            }
            return data[index];
        }

        public E getFirst(){
            return data[0];
        }

        public E getLast(){
            return data[size - 1];
        }

        void set(int index, E e) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Set failed. Index is illegal.");
            }
            data[index] = e;
            size ++;
        }

        public int find(E e){
            for(int i = 0;i < size; i++){
                if (data[i] == e){
                    return i;
                }
            }
            return -1;
        }

        public E delete(int index){
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Delete failed. Index is illegal.");

            E ret = data[index];
            for (int i = index; i <= size; i++){
                data[i] = data[i + 1];
            }
            size--;
            data[size] = null;  //loitering objects

            //当数据仅占空间的四分之一时，并且数据长度不为一时，进行缩容
            if(size == data.length / 4 && data.length / 2 != 0)
                resize(data.length / 2);
            return ret;
        }

        public boolean removeElement(E e){
            int index = find(e);
            if(index != -1)
                delete(index);
            return (index != -1);
        }

        public E removeLast(){
            return delete(size - 1);
        }

        //父类
        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
            res.append('[');
            for(int i = 0; i < size; i++){
                res.append(data[i]);
                if(i != size - 1)
                    res.append(",");
            }
            res.append(']');
            return res.toString();
        }

        //动态数组，为数组扩容
        private void resize(int newCapacity){
            E[] newData = (E[])new Object[newCapacity];
            for(int i = 0; i < size; i ++)
                newData[i] = data[i];
            data = newData;
        }
    }

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

    public boolean isValid(String s){

        ArrayStack<Character> stack = new ArrayStack<>();

        for(int i = 0;i < s.length();i ++){
            char c = s.charAt(i);
            if(c == '('|| c == '['|| c =='{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        System.out.println((new Solution()).isValid("(){}[]"));
        System.out.println((new Solution()).isValid("(}(}[]"));
    }
}
