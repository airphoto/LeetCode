/**
 * @ClassName M0202
 * @Author lihuasong
 * @Description
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * @Date 2021-11-19 20:36
 * @Version V1.0
 **/

public class M0202 {
    public static int kthToLast(ListNode head, int k) {

        ListNode pre = null;
        while (head!=null){
            ListNode tmp = head;
            head = head.next;
            tmp.next = pre;
            pre = tmp;
        }

        while (k>1){
            pre = pre.next;
            k--;
        }

        return pre.val;

    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next=l12;
        l12.next = l13;
        System.out.println(kthToLast(l11,2));
    }
}
