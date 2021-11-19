import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName Of27
 * @Author lihuasong
 * @Description
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 *
 *
 *
 * 输入: head = [1,2]
 * 输出: false
 *  
 *
 * 提示：
 *
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 * @Date 2021-11-19 20:01
 * @Version V1.0
 **/

public class Of27 {
    public static boolean isPalindrome(ListNode head) {

        Stack<Integer> set = new Stack<>();

        ListNode tmp = head;

        while (tmp!=null){
            set.push(tmp.val);
            tmp = tmp.next;
        }

        while (head!=null){
            if(set.pop()!=head.val){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(4);
        l11.next=l12;
        l12.next = l13;
        System.out.println(isPalindrome(l11));
    }
}
