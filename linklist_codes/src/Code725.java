/**
 * @ClassName Code725
 * @Author lihuasong
 * @Description
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 *
 *  
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 * @Date 2021-11-29 20:01
 * @Version V1.0
 **/

public class Code725 {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        if(head==null){
            return result;
        }

        int length = 0;
        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode c = pre.next;
        while (c!=null){
            length++;
            c=c.next;
        }

        int mean = length>=k?length/k:1;
        int lt = length>k?length%k:0;

        c=pre.next;
        while (c!=null){
            for (int i=0;i<k;i++){
                ListNode p = new ListNode(0);
                ListNode pc = p;
                int len = mean;
                if (lt-1>=i){
                    len=len+1;
                }
                while (len>0){
                    if(c!=null) {
                        pc.next=c;
                        pc=c;
                        c = c.next;
                    }
                    len--;
                }
                pc.next=null;
                result[i]=p.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode ln11 = new ListNode(1);
        ListNode ln12 = new ListNode(2);
        ListNode ln13 = new ListNode(3);
        ListNode ln14 = new ListNode(4);
        ln11.next=ln12;
        ln12.next=ln13;
        ln13.next=ln14;

        ListNode[] listNodes = splitListToParts(ln11, 5);
        for (ListNode listNode : listNodes) {
            System.out.println(listNode);
        }
    }
}
