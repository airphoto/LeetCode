import java.util.Stack;

/**
 * @ClassName Code234
 * @Author lihuasong
 * @Description
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 * @Date 2021/12/6 20:40
 * @Version V1.0
 **/
public class Code234 {
    public static boolean isPalindrome(ListNode head) {

        ListNode h = head;
        ListNode right = reverse(getMid(h));

        while (head!=null && right!=null){
            if(head.val!=right.val){
                return false;
            }
            head = head.next;
            right = right.next;
        }

        return true;
    }

    /**
     * 如果是奇数个，返回的值中间的节点；
     * 如果是偶数个，返回的是截断后的首个节点。
     * @param head
     * @return
     */
    public static ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode t = head;
            head = head.next;
            t.next = pre;
            pre = t;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(1);
        ListNode ln5 = new ListNode(1);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
//        ln4.next = ln5;
        System.out.println(isPalindrome(ln1));
    }
}
