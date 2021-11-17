import java.util.Arrays;

/**
 * @ClassName Of06
 * @Author lihuasong
 * @Description
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]

 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 *
 * @Date 2021-11-17 20:19
 * @Version V1.0
 **/

public class Of06 {
    public static int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[0];
        }
        int length=0;
        ListNode node = head;
        while (node.next!=null){
            length++;
            node = node.next;
        }
        int[] nodes = new int[length+1];
        nodes[length] = head.val;
        while (head.next!=null){
            length--;
            head = head.next;
            nodes[length]=head.val;
        }
        return nodes;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        System.out.println(Arrays.toString(reversePrint(node1)));
    }
}
