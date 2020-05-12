package LinkedList_Leecode;

import Linked_List.LinkedList;

public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

        //最基本的问题
        if(head == null)
            return null;

        head.next = removeElements(head.next, val);
        //if else 可以被三元表达式代替
//        if(head.val == val){
//            return head.next;
//        }
//        else{
//            return head;
//        }
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 5);
        System.out.println(res);
    }
}
