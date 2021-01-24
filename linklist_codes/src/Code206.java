/**
 * @ClassName Code206
 * @Author lihuasong
 * @Description
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @Date 2021-01-24 12:23
 * @Version V1.0
 **/

public class Code206 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node4 = new ListNode(6);
        node3.next = node4;

        ListNode head = reverseList(node1);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        while (head.next != null){
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = head;
            pre.next = tmp;
        }

        return pre.next;
    }

}
