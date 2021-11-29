package code430;

import com.sun.glass.events.mac.NpapiEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Author lihuasong
 * @Description
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021-11-25 20:20
 * @Version V1.0
 **/

public class Solution {
    public static Node flatten(Node head) {
        if(head==null){
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node c = head;
        stack.push(head);
        while (!stack.isEmpty()){
            Node n = stack.pop();
            if(n.next!=null){
                stack.push(n.next);
            }
            if(n.child!=null){
                stack.push(n.child);
            }

            n.child=null;
            c.next=n;
            n.prev=c;
            c=c.next;
        }
        head.prev=null;
        return head;
    }



    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next=n2;
        n1.child=n3;
        n3.child=n4;
        n3.next=n6;
        n4.next=n5;

        Node flatten = flatten(n1);
//        System.out.println(flatten);
        while (flatten!=null){
//            System.out.println("current:"+flatten.val+"next:"+flatten.next!=null?flatten.next.val:-1+",pre:"+flatten.prev!=null?flatten.prev.val:-2);
            System.out.println("current:"+flatten.val+",next:"+(flatten.next!=null?flatten.next.val:-1)+",pre:"+(flatten.prev!=null?flatten.prev.val:-2));
//            System.out.println("current:"+flatten);
            flatten=flatten.next;
        }
    }
}
