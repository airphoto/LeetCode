import java.util.Stack;

/**
 * @ClassName Code24
 * @Author lihuasong
 * @Description
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *  
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *  
 *
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 *
 * @Date 2021-11-21 18:05
 * @Version V1.0
 **/

public class Code24 {
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode tmp = pre;
        while (tmp.next!=null && tmp.next.next!=null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
//        l4.next=l5;
        System.out.println(swapPairs(l1));
    }
}
