import java.util.Stack;

/**
 * @ClassName Code445
 * @Author lihuasong
 * @Description
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 示例1：
 *
 *
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 *  
 *
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 *
 * 思路：先翻转两个链表，然后相加
 * @Date 2021-11-29 19:18
 * @Version V1.0
 **/

public class Code445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode lr1 = reverse(l1);
        ListNode lr2 = reverse(l2);

        ListNode pre = new ListNode(0);
        int t=0;
        while (lr1!=null || lr2!=null){
            int t1=0;
            int t2=0;
            if(lr1!=null){
                t1=lr1.val;
                lr1=lr1.next;
            }
            if (lr2!=null){
                t2=lr2.val;
                lr2=lr2.next;
            }
            ListNode value = new ListNode((t1+t2+t)%10);
            ListNode tn = pre.next;
            value.next=tn;
            pre.next=value;
            t=(t1+t2+t)/10;
        }

        if(t==1){
            ListNode value = new ListNode(1);
            ListNode tn = pre.next;
            value.next=tn;
            pre.next=value;
        }

        return pre.next;
    }

    private static ListNode reverse(ListNode ln){
        ListNode cn = null;
        ListNode c1 = ln;
        while (c1!=null){
            ListNode t= c1;
            c1 = c1.next;
            t.next=cn;
            cn=t;
        }

        return cn;
    }


    // 栈
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        Stack<Integer> t1 = new Stack<>();
        Stack<Integer> t2 = new Stack<>();

        while (l1!=null){
            t1.push(l1.val);
            l1=l1.next;
        }

        while (l2!=null){
            t2.push(l2.val);
            l2=l2.next;
        }

        ListNode pre = new ListNode(0);

        int t=0;
        while (!t1.isEmpty() || !t2.isEmpty()){
            int s1=0,s2=0;
            if(!t1.isEmpty()){
                s1=t1.pop();
            }
            if(!t2.isEmpty()){
                s2=t2.pop();
            }

            ListNode value = new ListNode((s1+s2+t)%10);
            value.next=pre.next;
            pre.next=value;
            t=(s1+s2+t)/10;
        }

        if(t==1){
            ListNode value = new ListNode(1);
            value.next=pre.next;
            pre.next=value;
        }


        return pre.next;
    }

    public static void main(String[] args) {
        ListNode ln11 = new ListNode(1);
        ListNode ln12 = new ListNode(2);
        ListNode ln13 = new ListNode(3);

        ListNode ln21 = new ListNode(9);
        ListNode ln22 = new ListNode(9);
        ListNode ln23 = new ListNode(9);

//        ln11.next=ln12;
//        ln12.next=ln13;

        ln21.next=ln22;
//        ln22.next=ln23;

        System.out.println(addTwoNumbers2(ln11,ln21));
//        System.out.println(reverse(ln11));
    }
}
