
//实现一个 MapSum 类里的两个方法，insert 和 sum。
//
//        对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
//
//        对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。

import java.util.TreeMap;

class MapSum {

    //定义节点
    private class Node{

        // 键值
        public int value;
        // 到下个节点的映射   Character 到 Node 的映射
        public TreeMap<Character, Node> next;

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }

        //默认为false
        public Node(){
            this(0);
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public MapSum() {

        root = new Node();

    }

    public void insert(String word, int val) {

        Node cur = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for(int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    // 递归
    private int sum(Node node){

        if(node.next.size() == 0)
            return node.value;

        int res = node.value;
        for(char c: node.next.keySet())
            res += sum(node.next.get(c));

        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
