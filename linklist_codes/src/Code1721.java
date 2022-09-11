/**
 * @ClassName Code1721
 * @Author lihuasong
 * @Description
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 *
 * 示例 3：
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 * 示例 4：
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 *
 * 示例 5：
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 *
 * @Date 2021/12/7 21:02
 * @Version V1.0
 **/
public class Code1721 {
    public static ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = head;
        while (current!=null){
            length++;
            current=current.next;
        }

        int nex = length-k+1;

        if(nex==k){
            return pre.next;
        }else {
            int dura = Math.abs(nex-k);

            ListNode slow = pre;
             int k1 = Math.min(k-1,nex-1);
             while (k1>0){
                 k1--;
                 slow=slow.next;
             }
             ListNode fast = slow;
             while (dura>0){
                 dura--;
                 fast=fast.next;
             }
             ListNode t1 = slow.next;
             slow.next = fast.next;
             fast.next = t1;
             ListNode t2= t1.next;
             slow = slow.next;
             t1.next=slow.next;
             slow.next = t2;
        }
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
        l3.next=l4;
        l4.next=l5;

        System.out.println(swapNodes(l1,5));
    }
}
