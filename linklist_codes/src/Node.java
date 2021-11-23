/**
 * @ClassName Node
 * @Author lihuasong
 * @Description
 * @Date 2021-11-23 19:56
 * @Version V1.0
 **/

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}