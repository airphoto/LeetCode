/**
 * @ClassName Of25
 * @Author lihuasong
 * @Description
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @Date 2021-11-18 19:58
 * @Version V1.0
 **/

public class Of25 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode c;

        while (pre !=null){
            if (l1!=null && l2 !=null){
                if(l1.val<l2.val){
                    c = l1;
                    l1 = l1.next;
                }else{
                    c = l2;
                    l2= l2.next;
                }
            }else if(l1!=null){
                c=l1;
                l1 = l1.next;
            }else if(l2!=null){
                c=l2;
                l2 = l2.next;
            }else{
                c=null;
            }
            pre.next = c;
            pre = pre.next;
        }

        return head.next;

    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode pre = head;

        while (l1!=null && l2 !=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2= l2.next;
            }
            pre = pre.next;
        }

        pre.next=l1!=null?l1:l2;

        return head.next;

    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode listNode = mergeTwoLists(l11, l21);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode= listNode.next;
        }
    }
}
