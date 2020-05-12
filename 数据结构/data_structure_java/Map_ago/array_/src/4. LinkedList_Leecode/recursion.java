package LinkedList_Leecode;

public class recursion {

    //depth 递归深度
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        //最基本的问题
        if(head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + " : " + res);

        ListNode ret;
        if(head.val == val)
            ret = res;
        else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new recursion()).removeElements(head, 5, 0);
        System.out.println(res);
    }
}

//输出
//1->2->3->4->5->6->NULL
//        Call: remove 5 in 1->2->3->4->5->6->NULL
//        --Call: remove 5 in 2->3->4->5->6->NULL
//        ----Call: remove 5 in 3->4->5->6->NULL
//        ------Call: remove 5 in 4->5->6->NULL
//        --------Call: remove 5 in 5->6->NULL
//        ----------Call: remove 5 in 6->NULL
//        ------------Call: remove 5 in null
//        ------------Return: null
//        ----------After remove 5 : null
//        ----------Return: 6->NULL
//        --------After remove 5 : 6->NULL
//        --------Return: 6->NULL
//        ------After remove 5 : 6->NULL
//        ------Return: 4->6->NULL
//        ----After remove 5 : 4->6->NULL
//        ----Return: 3->4->6->NULL
//        --After remove 5 : 3->4->6->NULL
//        --Return: 2->3->4->6->NULL
//        After remove 5 : 2->3->4->6->NULL
//        Return: 1->2->3->4->6->NULL
//        1->2->3->4->6->NULL
