import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName M0201
 * @Author lihuasong
 * @Description
 * @Date 2021-11-19 20:21
 * @Version V1.0
 **/

public class M0201 {
    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head==null){
            return null;
        }
        Set<Integer> set = new HashSet<>();

        ListNode pre = head;
        set.add(pre.val);
        ListNode current = head.next;
        while (current!=null){
            if (set.contains(current.val)){
                current = current.next;
                pre.next = current;
            }else{
                set.add(current.val);
                current = current.next;
                pre = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(4);
        l11.next=l12;
        l12.next = l13;
        System.out.println(removeDuplicateNodes(l11));
    }

}
