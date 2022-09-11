/**
 * @ClassName Code110
 * @Author lihuasong
 * @Description
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 *
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 *
 * @Date 2021/12/9 21:11
 * @Version V1.0
 **/
public class Code110 {
    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static Integer getHeight(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            return 1+Math.max(left,right);
        }
    }

    public static void main(String[] args) {

    }
}
