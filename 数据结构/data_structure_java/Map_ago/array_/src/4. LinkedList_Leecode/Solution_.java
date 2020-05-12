package LinkedList_Leecode;

class Solution_ {
    public ListNode removeElements(ListNode head, int val) {

        //将位于首部的节点删掉
        while(head.val == val && head != null)
            head = head.next;

        //若链表为空，则无操作
        if(head == null)
            return null;
        ListNode prev = head;

        //删除操作
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
                prev = prev.next;
            }
        }
        return head;
    }
}
