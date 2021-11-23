/**
 * @ClassName Code86
 * @Author lihuasong
 * @Description
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *  
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *  解题思路：
 *  先找到大于等于x的节点的前一个节点 c，这个节点承接之后的 小于x的节点
 *
 *  然后从这个节点开始循环，找到每一个小于x的节点，将节点转移到c之后即可
 * @Date 2021-11-22 20:06
 * @Version V1.0
 **/

public class Code86 {
    public static ListNode partition(ListNode head, int x) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode pre = new ListNode(101);
        pre.next=head;

        ListNode c1 = pre;
        ListNode c2 = head;

        while (c2!=null){
            if(c2.val<x){
                c2=c2.next;
                c1=c1.next;
            }else {
                break;
            }
        }

        ListNode c3=c1;

        while (c2!=null){
            if(c2.val<x){
                ListNode t = c2;
                c3.next=c2.next;
                t.next=c1.next;
                c1.next=t;
                c1=c1.next;
                c2=c3.next;
            }else{
                c2=c2.next;
                c3=c3.next;
            }
        }

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
        System.out.println(partition(l1,2));
    }
}
