import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName Code653
 * @Author lihuasong
 * @Description
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * 示例 2：
 *
 *
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * 示例 3：
 *
 * 输入: root = [2,1,3], k = 4
 * 输出: true
 * 示例 4：
 *
 * 输入: root = [2,1,3], k = 1
 * 输出: false
 * 示例 5：
 *
 * 输入: root = [2,1,3], k = 3
 * 输出: true
 *  
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 *
 * @Date 2021/12/9 23:30
 * @Version V1.0
 **/
public class Code653 {
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(set.contains(k-node.val)){
                return true;
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            set.add(node.val);
        }
        return false;
    }
}
