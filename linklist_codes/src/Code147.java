/**
 * @ClassName Code147
 * @Author lihuasong
 * @Description
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @Date 2021-11-24 20:02
 * @Version V1.0
 **/

public class Code147 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next=head;

        ListNode sorted = head;      // 已经排好序
        ListNode current = head.next;// 排好序之后的节点

        while (current!=null){
            // 如果排好序的节点的值小于后边的节点的值，那么直接后移
            if(sorted.val<=current.val){
                sorted=sorted.next;
            }else{
                // 否则从开始节点依次对比
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
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;

        System.out.println(insertionSortList(l1));
    }
}
