public interface UF {

    int getSize();
    // p q 是否相连
    boolean isConnected(int p, int q);
    // 合并元素 p q  所在的集合
    void unionElements(int p, int q);
    // void unionElement(int p, int q);
}
