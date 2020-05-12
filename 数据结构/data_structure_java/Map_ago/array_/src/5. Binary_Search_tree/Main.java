package Binary_Search_tree;

import Binary_Search_tree.BST;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        Binary_Search_tree.BST<Integer> bst = new Binary_Search_tree.BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        //创造树
        for(int num: nums)
            bst.add(num);

        //遍历树
        bst.preOrder();
        System.out.println();
        System.out.println(bst);

        //遍历树
        bst.inOrder();
        System.out.println();
        System.out.println(bst);

        //遍历树
        bst.postOrder();
        System.out.println();
        System.out.println(bst);

        //非递归
        bst.preOrderNR();
        System.out.println();

        bst.leveOrder();
        System.out.println();



        //找到最值
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());

        //自己写的
        bst.deleteMax();
        System.out.println(bst);

        bst.deleteMin();
        System.out.println(bst);


        Binary_Search_tree.BST<Integer> bst1 = new BST<>();
        Random random = new Random();

        int n = 100;

        for(int i = 0; i < n; i ++)
            bst1.add(random.nextInt(10000));

        ArrayList<Integer> nums1 = new ArrayList<>();
        while(!bst1.isEmpty())
            nums1.add(bst1.removeMin());

        System.out.println(nums1);
        for(int i = 1; i < nums1.size(); i ++)
            if(nums1.get(i - 1) > nums1.get(i))
                throw new IllegalArgumentException(("Error"));
        System.out.println("removeMin test completed");

        bst.removeFirst(3);
        System.out.println(bst);


    }
}
