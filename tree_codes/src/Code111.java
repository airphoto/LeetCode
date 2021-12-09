import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Code111
 * @Author lihuasong
 * @Description
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * @Date 2021/12/9 21:29
 * @Version V1.0
 **/
public class Code111 {
    public static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize = 1;
        int height = 0;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize--;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }

            if(node.left==null && node.right==null){
                return height+1;
            }

            if(levelSize==0){
                levelSize=queue.size();
                height++;
            }
        }
        return height;
    }
}
