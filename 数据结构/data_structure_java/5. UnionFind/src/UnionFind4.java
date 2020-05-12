// 通过树形成的并查集 自己写的，解决深度问题
public class UnionFind4 implements UF{

    private int[] parent;
    private int sizes = 0;

    public UnionFind4(int size){

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

        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while(p != parent[p]) {
            p = parent[p];
            sizes ++;
        }
        return p;
    }

    // 查看元素 p 和 元素 q 是否所属一个集合
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q){

        int pRont = find(p);
        int p_size = sizes;
        sizes = 0;
        int qRoot = find(q);
        int q_size = sizes;

        if(p_size >= q_size)
            parent[q_size] = p_size;
        else
            parent[p_size] = q_size;
        sizes = 0;
    }

}
