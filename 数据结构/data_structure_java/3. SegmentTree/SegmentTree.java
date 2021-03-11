import java.util.Objects;

public class SegmentTree<E> {

    //线段树
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){

        this.merger = merger;

        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i ++)
            //data数组记录线段树节点的长度
            data[i] = arr[i];

        //给予分配4n 倍的存储空间
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    //取出节点的左孩子
    private int leftChild(int index){
        return 2 * index + 2;
    }
    //取出节点的右孩子
    private int rightChild(int index){
        return 2 * index + 2;
    }

    //在treeIndex 的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){

        //递归终止条件
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        //不可用  mid = (l + r) / 2   避免整数溢出  超出int范围

        //建立节点的左右节点，线段树
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E query(int queryL, int queryR){

        //判断要搜索的区间是否合法
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

        //调用私有query
        return  query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以treeIndex 为根的线段树中 [l...r] 的范围里，搜索区间 [queryL...queryR] 的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR){

        //找到 即结束递归
        if(l == queryL && r == queryR)
            return tree[treeIndex];

        //将线段树分为两部分，向下走
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //判断要搜索的区间与线段树的关系
        if(queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if(queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);
    }

    //将index 位置的值，更新为e
    public void set(int index, E e){

        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    //在以treeIndex 为根的线段树中更新index 的值为 e
    private void set(int treeIndex, int l, int r, int index, E e){

        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if(index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else //index < mid
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0; i < tree.length; i ++){
            if(tree[i] != null){
                res.append(tree[i]);
            }
            else
                res.append("null");
            if(i != tree.length - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }
}
