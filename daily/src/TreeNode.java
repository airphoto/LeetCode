/**
 * @ClassName TreeNode
 * @Author lihuasong
 * @Description
 * @Date 2021-11-18 19:47
 * @Version V1.0
 **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
