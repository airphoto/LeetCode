/**
 * @ClassName Code203
 * @Author lihuasong
 * @Description
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 *
 * @Date 2021-01-24 11:41
 * @Version V1.0
 **/

public class Code203 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node4 = new ListNode(6);
        node3.next = node4;


        ListNode head = removeElements(node1,2);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode tmp = pre;

        while (tmp.next != null){
            if (tmp.next.val == val){
                tmp.next = tmp.next.next;
            }else{
                tmp = tmp.next;
            }
        }

        return pre.next;
    }
}
