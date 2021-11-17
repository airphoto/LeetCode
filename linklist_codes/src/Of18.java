/**
 * @ClassName Of18
 * @Author lihuasong
 * @Description
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * 解题思路：
 *      在head前设置一个前置node，然后从这个前置node开始遍历，这样就可以遍历到head，最后head为node.next就可以了，
 *      这样就算初始的head删除了，node.next也会取到值
 * @Date 2021-11-17 20:31
 * @Version V1.0
 **/

public class Of18 {
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next=head;

        ListNode current = pre;

        while (current!=null && current.next != null){
            if(current.next.val==val){
                current.next=current.next.next;
            }
            current=current.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = deleteNode(node1,1);
        while (head !=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
