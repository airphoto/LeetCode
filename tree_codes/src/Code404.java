import java.util.Stack;

/**
 * @ClassName Code404
 * @Author lihuasong
 * @Description
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @Date 2021/12/13 22:54
 * @Version V1.0
 **/
public class Code404 {
    public static int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum=0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null){
                if(node.left.left==null && node.left.right==null){
                  sum+=node.left.val;
                }
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left=n2;
        n1.right=n3;
        n3.right=n5;
        n3.left=n4;
        System.out.println(sumOfLeftLeaves(n1));
    }
}
