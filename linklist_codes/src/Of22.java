/**
 * @ClassName Of22
 * @Author lihuasong
 * @Description
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * @Date 2021-11-17 20:49
 * @Version V1.0
 **/

public class Of22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null){
            return null;
        }

        int length=0;
        ListNode node = head;
        while (node!=null){
            length++;
            node = node.next;
        }

        while (length>k){
            length--;
            head = head.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = getKthFromEnd(node1,2);
        while (head !=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
