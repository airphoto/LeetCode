/**
 * @ClassName Code92
 * @Author lihuasong
 * @Description
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * @Date 2021-11-22 20:24
 * @Version V1.0
 **/

public class Code92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null){
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next=head;

        ListNode ln = pre; // ln记录left之前的那个节点
        int index=1;
        while (index<left){
            ln=ln.next;
            index++;
        }

        ListNode rn = ln.next; // 记录的是right之后的节点
        ListNode rnp=null;
        while (index<=right){  // left和right之间的节点进行翻转
            index++;
            ListNode t = rn;
            rn=rn.next;
            t.next=rnp;
            rnp=t;
        }
        ln.next=rnp;    // left前的那个节点直接链接翻转的节点

        ListNode t = rnp;
        while (t.next!=null){  // 循环翻转之后的节点，最后一个节点链接right之后的节点
            t=t.next;
        }
        t.next=rn;

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
//        l3.next=l4;
//        l4.next=l5;

        System.out.println(reverseBetween(l1,1,2));
    }
}
