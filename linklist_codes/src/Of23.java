/**
 * @ClassName Of23
 * @Author lihuasong
 * @Description
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * @Date 2021-11-19 19:45
 * @Version V1.0
 **/

public class Of23 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB ==null){
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2){
            h1 = h1==null?headB:h1.next;
            h2 = h2==null?headA:h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(8);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(1);
        l21.next = l22;
        l22.next = l23;
        l23.next= l13;

        System.out.println(getIntersectionNode(l11,l21));
    }
}
