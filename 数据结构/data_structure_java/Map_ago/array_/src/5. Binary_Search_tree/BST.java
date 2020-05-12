package Binary_Search_tree;
import javax.xml.namespace.QName;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>>{

    private class Node{

        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素
    public void add(E e){

//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }
//        else
            root = add(root, e);

    }
    //向以node为根的二分搜索树中插入元素E，递归算法
    //返回插入新节点后二分树的根
    private Node add(Node node, E e){

//        //新增元素与节点比较大小，根据左右孩子是否为空，确定是否插入
//        if(e.equals(node.e))
//            return;
//        else if(e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size ++;
//            return;
//        }

        if(node == null){
            size ++;
            return new Node(e);
        }

        //该节点有左右孩子，往下走
        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    //元素查询
    public boolean contains(E e){

        return contains(root, e);
    }
    //元素查询
    private boolean contains(Node node, E e){

        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public void preOrder(){
        preOrder(root);
    }
    //前序，中序，后序 又称深度优先搜索
    //前序遍历，先访问节点，再访问该节点的孩子,
    private void preOrder(Node node){

        //终止条件
        if(node == null)
            return;

        //递归
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){

        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
        inOrder(root);
    }

    private void postOrder(Node node){

        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的非递归前序遍历
    public void preOrderNR(){

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    //二分搜索树的层序遍历,广度优先遍历
    public void leveOrder(){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }

    //去掉最大的，自己写的
    public void deleteMax(){
        deleteMax(root);
    }

    private void deleteMax(Node node){

        if(node == null)
            return;

         //return node.right == null? node = null: deleteMax(node.right);
        if(node.right == null)
            node.e = null;
        else
            deleteMax(node.right);
    }

    //去掉最小的，自己写的
    public void deleteMin(){
        deleteMin(root);
    }

    private void deleteMin(Node node){

        if(node == null)
            return;

        //return node.right == null? node = null: deleteMax(node.right);
        if(node.left == null)
            node.e = null;
        else
            deleteMin(node.left);
    }

    //删除指定元素，自己写的
    public void deleteElement(E e){
        deleteElement(root, e);
    }

    private boolean deleteElement(Node node, E e){

        if(node == null)
            return true;

        if(node == e) {
            node.e = null;
            return true;
        }
        return node.e.compareTo(e) == 1? deleteElement(node.left, e) : deleteElement(node.right, e);
    }

    //找到二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    //找到二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
    }

    //删除最小值所在节点，返回最小值
    public E removeMin(){
        E ret = minimum();
        removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            //存储右孩子
            Node rightNode = node.right;
            node.right = null;
            size--;
            //返回删除节点后新的二分搜索树的根
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除掉以node为根的二分搜索树的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {
            //存储左孩子
            Node leftNode = node.left;
            node.left = null;
            size--;
            //返回删除节点后新的二分搜索树的根
            return leftNode;
        }
        node.left = removeMax(node.right);
        return node;
    }

    //删除节点,用后继解决
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { //e == node.e

            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.right = null;
                size--;
                return leftNode;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    //删除节点,用前驱解决
    public void removeFirst(E e){
        root = removeFirst(root, e);
    }

    private Node removeFirst(Node node, E e) {

        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { //e == node.e

            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.right = null;
                size--;
                return leftNode;
            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，也可以是左孩子的最大节点
            //用这个节点顶替待删除节点的位置
            Node successor = maximum(node.left);
            successor.right = removeMax(node.left);
            successor.right = node.right;

            node.left = node.right = null;

            return successor;
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
            }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i ++)
            res.append("--");
        return res.toString();
    }

}
