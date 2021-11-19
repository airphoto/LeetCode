/**
 * @ClassName Code2
 * @Author lihuasong
 * @Description
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * @Date 2021-11-19 20:51
 * @Version V1.0
 **/

public class Code2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(1);

        int tmp=0;
        while (l1 != null && l2 != null){
            int sum = l1.val+l2.val+tmp;
            ListNode current = new ListNode(sum%10);
            current.next = pre.next;
            pre.next = current;
            l1=l1.next;
            l2=l2.next;
            tmp=sum/10;
        }

        ListNode next = l1==null?l2:l1;
        while (next!=null){
            int sum = next.val+tmp;
            ListNode current = new ListNode(sum%10);
            current.next = pre.next;
            pre.next = current;
            next = next.next;
            tmp=sum/10;
        }

        ListNode head =  tmp==1?pre:pre.next;

        ListNode p = null;
        while (head!=null){
            ListNode tp = head;
            head = head.next;
            tp.next = p;
            p = tp;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(0);
        ListNode l13 = new ListNode(1);
        l11.next=l12;
        l12.next = l13;


        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        l21.next=l22;
        l22.next=l23;

        ListNode listNode = addTwoNumbers(l11, l21);

        StringBuffer sb = new StringBuffer();

        while (listNode!=null){
            sb.append(listNode.val);
            listNode=listNode.next;
        }

        System.out.println(sb.toString());
    }
}
