import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Code82
 * @Author lihuasong
 * @Description
 * 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 *
 * @Date 2021-11-21 20:18
 * @Version V1.0
 **/

public class Code82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }

        ListNode pre = new ListNode(101);
        pre.next = head;

        ListNode pc = pre;
        ListNode current = head;

        HashMap<Integer,Integer> nums = new HashMap<>();
        while (current!=null){
            nums.put(current.val,nums.getOrDefault(current.val,0)+1);
            current = current.next;
        }

        current = head;

        while (current!=null){
            if (nums.get(current.val)>1){
                current=current.next;
            }else {
                pc.next=current;
                pc=pc.next;
                current=current.next;
            }
        }
        pc.next=null;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(7);
        ListNode l6 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        System.out.println(deleteDuplicates(l1));
    }
}
