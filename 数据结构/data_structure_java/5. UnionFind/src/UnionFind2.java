// 通过树形成的并查集 2
public class UnionFind2 implements UF{

    private int[] parent;

    public UnionFind2(int size){

        parent = new int[size];

        for(int i = 0; i < size; i ++)
            parent[i] = i;
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    // 找到 p 节点对应的根节点
    // O(h) 复杂度， h 为树的高度
    private int find(int p){

        if(p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while(p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    // 查看元素 p 和 元素 q 是否所属一个集合
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 在合并过程中，可能会出现树不断增加高度，而不是宽度，形成类似链表的结构，使时间变慢
    @Override
    public void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }

}
