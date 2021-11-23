/**
 * @ClassName Code19
 * @Author lihuasong
 * @Description
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * @Date 2021-11-21 17:35
 * @Version V1.0
 **/

public class Code19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;

        int length=0;
        ListNode current = head;
        while (current!=null){
            length++;
            current = current.next;
        }

        current = pre;
        while (length > n){
            current = current.next;
            length--;
        }

        ListNode next = current.next;
        current.next = next.next;

        return  pre.next;
    }

    // 双指针法，只循环一次就可以了
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode node1 = pre;
        ListNode node2 = pre;

        int tmp = 0;
        while (node2!=null){
            node2 = node2.next;
            if(tmp==n+1){
                node1 = node1.next;
            }else {
                tmp++;
            }
        }

        ListNode next = node1.next;
        node1.next = next.next;

        return  pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;

        System.out.println(removeNthFromEnd2(l1,1));
    }
}
