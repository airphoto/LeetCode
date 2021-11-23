import java.util.Stack;

/**
 * @ClassName Code143
 * @Author lihuasong
 * @Description
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * 提示：
 *
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 *
 *  找中间节点，然后后半段翻转，或者直接用栈就可以了
 * @Date 2021-11-23 20:50
 * @Version V1.0
 **/

public class Code143 {
    public static void reorderList(ListNode head) {
        if(head.next==null){
            return;
        }
        ListNode pre = head;
        int length = 0;
        ListNode current = pre;

        while (current!=null){
            length++;
            current=current.next;
        }

        current=pre;
        Stack<ListNode> stack = new Stack<>();

        int half=0;
        while (current!=null){
            half++;
            if(half>length/2){
                stack.push(current);
            }
            current=current.next;
        }
        current=pre;

        while (!stack.isEmpty()){
            ListNode t = current.next;
            ListNode r = stack.pop();
            current.next=r;
            r.next=t;
            current=current.next.next;
        }
        current.next=null;
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

        reorderList(l1);

        while (l1!=null){
            System.out.println(l1.val);
            l1=l1.next;
        }
    }
}
