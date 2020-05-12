//208. 实现 Trie (前缀树)
// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

import java.util.TreeMap;

public class Trie208 {

    private class Node{

        //当前节点是否为一个单词的结尾
        public boolean isWord;
        //到下个节点的映射   Character 到 Node 的映射
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        //默认为false
        public Node(){
            this(false);
        }
    }
    //根节点
    private Node root;
    //b保存单词个数
    private int size;

    //构造函数，
    public Trie208(){
        root = new Node();
        size = 0;
    }

    //向 Trie 中添加一个新的单词 word   非递归
    public void insert(String word){

        Node cur = root;
        for(int i = 0; i < word.length(); i ++){
            //取出单词的第 i 个字母
            char c = word.charAt(i);
            //判断 此节点是否已经指向c
            if(cur.next.get(c) == null)
                //若无，则创建
                cur.next.put(c, new Node());
            //  将cur的节点 赋给 cur  向下走
            cur = cur.next.get(c);
        }

        //若isword  为  false  则不为新单词
        if(!cur.isWord) {
            //标记为新单词
            cur.isWord = true;
            //  Trie 保存的单词数加一
            size++;
        }
    }

    //查询单词
    public boolean search(String word){

        Node cur = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    //查询是否在Trie 中有单词以 preefix 为前缀  如：  panda 以  pan 为前缀
    public boolean startsWith(String prefix){

        Node cur = root;
        for(int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}
