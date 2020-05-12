import java.util.TreeMap;

class WordDictionary {

    private class Node{

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }
    // 根节点
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        Node cur = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    // 递归     在node 节点搜索  word 为字符串   字符串第 index 个字符
    private boolean match(Node node, String word, int index){

        // 递归结束条件
        if(index == word.length())
            return node.isWord;

        // 取出字符串word 中的  第index 个字符
        char c = word.charAt(index);
        if(c != '.'){
            if(node.next.get(c) == null)
                return false;
            // 节点映射不为空， 向下寻找
            return match(node.next.get(c), word, index + 1);
        }
        else{
            for(char nextChar: node.next.keySet())
                // 从该节点不断向下匹配
                if(match(node.next.get(nextChar), word, index + 1))
                    return true;
            // 从该节点向下匹配都不成功
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
