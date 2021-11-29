/**
 * @ClassName Code148
 * @Author lihuasong
 * @Description
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 * 提示：
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * @Date 2021-11-25 19:40
 * @Version V1.0
 **/

public class Code148 {
    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next=head;

        ListNode sorted=head;
        ListNode current=head.next;
        while (current!=null){
            if(sorted.val<=current.val){
                sorted=sorted.next;
            }else {
                ListNode t=pre;
                while (t.next.val<=current.val){
                    t=t.next;
                }
                sorted.next=current.next;
                current.next=t.next;
                t.next=current;
            }
            current=sorted.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
//        l4.next=l5;

        System.out.println(sortList(l1));
    }
}
