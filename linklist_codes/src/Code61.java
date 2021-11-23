/**
 * @ClassName Code61
 * @Author lihuasong
 * @Description
 *      旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * 解题思路：
 *      先计算链表长度n，k%n之后才是需要移动的实际长度，循环只有将后边的截取，就可以了
 * @Date 2021-11-21 19:46
 * @Version V1.0
 **/

public class Code61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null){
            return head;
        }

        int length=0;

        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode current = head;
        while (current!=null){
            length++;
            current=current.next;
        }

        int tp = k%length;
        if(tp==0){
            return head;
        }

        current=head;
        ListNode node = current;
        while (length-tp>0){
            length--;
            node=current;
            current=current.next;
        }

        node.next=null;

        ListNode cc = current;
        ListNode tt = cc;
        while (cc!=null){
            tt=cc;
            cc=cc.next;
        }

        tt.next = pre.next;
        pre.next=current;

        return pre.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        System.out.println(rotateRight(l1,2));
    }
}
