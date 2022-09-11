import java.util.Arrays;

/**
 * @ClassName Code1019
 * @Author lihuasong
 * @Description
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *  
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 *
 * @Date 2021-12-01 19:55
 * @Version V1.0
 **/

public class Code1019 {
    public static int[] nextLargerNodes(ListNode head) {
        if(head==null){
            return new int[0];
        }

        int len=0;
        ListNode pre=null;
        while (head!=null){
            ListNode t = head;
            head=head.next;
            t.next = pre;
            pre=t;
            len++;
        }

        int[] data = new int[len];
        int i = len-1;
        int max=0;
        int nx=0;
        while (pre!=null){
            if(pre.val>=max){
                data[i]=0;
                max=pre.val;
            }else if(pre.val >= nx || nx==max){
                data[i]=max;
            }else{
                max=nx;
                data[i]=max;
            }
            nx=pre.val;
            pre=pre.next;
            i--;
        }

        data[len-1]=0;
        return data;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(1);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
//        l6.next=l7;
        l7.next=l8;
        System.out.println(Arrays.toString(nextLargerNodes(l1)));
    }
}
