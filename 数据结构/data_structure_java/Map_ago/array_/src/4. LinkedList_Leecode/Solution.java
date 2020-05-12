package LinkedList_Leecode;

//203
//删除链表中等于给定值 val 的所有节点。
//
//        示例:
//        输入: 1->2->6->3->4->5->6, val = 6
//        输出: 1->2->3->4->5

import Linked_List.LinkedList;

/**为Leecode中预定给的函数
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        //将位于首部的节点删掉
        while(head.val == val && head != null){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        //若链表为空，则无操作
        if(head == null)
            return null;
        ListNode prev = head;

        //删除操作
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else{
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 5);
        System.out.println(res);

        ListNode res2 = (new Solution_vmhead()).removeElements(head, 6);
        System.out.println(res);
    }
}
