
// 第一版的并查集
// unionElements   复杂度为  O(n)
// isConnected     复杂度为  O(1)

public class UnionFind1 implements UF{

    // 创建集合
    private int[] id;

    public UnionFind1(int size){
        // 容量为 size 的集合
        id = new int[size];

        for(int i = 0; i < id.length; i ++)
            id[i] = i;
    }

    @Override
    public int getSize(){
        return id.length;
    }

    // 查找元素 p 对应的集合编号
    private int find(int p){
        if(p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is not of bound.");
        return id[p];
    }

    // 查看元素 p 和元素 q 是否所属同一个集合
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 合并元素 p 和元素 q 所属的集合
    @Override
    public void unionElements(int p, int q){

        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
            return;

        for(int i = 0; i < id.length; i ++)
            if(id[i] != pID)
                id[i] = pID;
    }

}
