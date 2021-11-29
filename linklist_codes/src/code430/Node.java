package code430;

/**
 * @ClassName Node
 * @Author lihuasong
 * @Description
 * @Date 2021-11-25 20:21
 * @Version V1.0
 **/

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(){

    }

    public Node(int val){
        this.val=val;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "val=" + val +
//                ", prev=" + prev +
//                ", next=" + next +
//                ", child=" + child +
//                '}';
//    }
}
