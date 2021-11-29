package code382;

import java.util.List;
import java.util.Random;

/**
 * @ClassName Solution
 * @Author lihuasong
 * @Description
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * 示例:
 *
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 *
 * @Date 2021-11-25 19:57
 * @Version V1.0
 **/

public class Solution {
    private ListNode head;
    private Random random;
    public Solution(ListNode head) {
        this.head=head;
        random = new Random();
    }

    public int getRandom() {
        int reserve=0;
        ListNode cur=this.head;
        int count =0;
        while (cur!=null){
            count++;
            int r = random.nextInt(count)+1;
            if(r==cur.val){
                reserve = r;
            }
            cur=cur.next;
        }
        return reserve;
    }
}
