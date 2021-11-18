import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Of52
 * @Author lihuasong
 * @Description
 *      输入两个链表，找出它们的第一个公共节点。
 * @Date 2021-11-18 20:48
 * @Version V1.0
 **/

public class Of52 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while (headA != null){
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB !=null){
            if (nodes.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    // 双指针法
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }

        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1!=l2){
            l1 = l1==null?headB:headA.next;
            l2 = l2==null?headA:headB.next;
        }

        return l1;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        l21.next = l12;

        ListNode intersectionNode = getIntersectionNode2(l11, l21);
        System.out.println(intersectionNode);
    }
}
