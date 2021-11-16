package code653;

/**
 * @ClassName TreeNode
 * @Author lihuasong
 * @Description
 *      定义一个二叉搜索树
 * @Date 2021-11-16 19:09
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
