package Linked_List;

//使用泛类
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

    public E removeFirst(){
        return delete(0);
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
