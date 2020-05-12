package LinkedList_Leecode;

public class Solution_vmhead {

    //使用虚拟头节点
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;

        ListNode prev = dummyhead;

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
