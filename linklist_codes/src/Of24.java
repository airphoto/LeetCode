/**
 * @ClassName Of24
 * @Author lihuasong
 * @Description
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * @Date 2021-11-17 20:55
 * @Version V1.0
 **/

public class Of24 {
    public static ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }

        ListNode pre = null;
        ListNode current = head;

        while (current != null){
            ListNode tmp = current;
            current = current.next;
            tmp.next = pre;
            pre = tmp;
        }

        return pre;

    }

    public static void main(String[] args) {

    }
}
