import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Code112
 * @Author lihuasong
 * @Description
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 *
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 *
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @Date 2021/12/9 21:43
 * @Version V1.0
 **/
public class Code112 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }

        Queue<TreeNode> tq = new LinkedList<>();
        Queue<Integer> vq = new LinkedList<>();
        tq.offer(root);
        vq.offer(root.val);

        int levelSize = 1;

        while (!tq.isEmpty()){
            TreeNode node = tq.poll();
            Integer sum = vq.poll();
            levelSize--;
            if(node.left!=null){
                tq.offer(node.left);
                vq.offer(sum+node.left.val);
            }
            if(node.right!=null){
                tq.offer(node.right);
                vq.offer(sum+node.right.val);
            }

            if(levelSize==0){
                levelSize=vq.size();
            }

            if(node.left==null && node.right==null && sum==targetSum){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
