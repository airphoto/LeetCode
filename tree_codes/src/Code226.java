import java.util.Stack;

/**
 * @ClassName Code226
 * @Author lihuasong
 * @Description
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * @Date 2021/12/9 23:05
 * @Version V1.0
 **/
public class Code226 {
    public static TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }

            TreeNode tmp = node.left;
            node.left=node.right;
            node.right = tmp;
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
