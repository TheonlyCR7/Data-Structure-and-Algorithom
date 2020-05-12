import java.util.TreeMap;

public class Trie {

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
    public Trie(){
        root = new Node();
        size = 0;
    }

    //获得Trie 中存储的单词数量
    public int getSize(){
        return size;
    }

    //向 Trie 中添加一个新的单词 word   非递归
    public void add(String word){

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

    //向 Trie 中添加一个新的单词 word   递归
    public void add1(String word){

        Node cur = root;
        //结束条件
        if(word == null){
            cur.isWord = true;
            size ++;
            return;
        }
    }

    //查询单词
    public boolean contains(String word){

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
    public boolean isPrefix(String prefix){

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
