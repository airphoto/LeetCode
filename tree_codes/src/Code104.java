import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Code104
 * @Author lihuasong
 * @Description
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @Date 2021/12/8 23:45
 * @Version V1.0
 **/
public class Code104 {

    /**
     * 非递归方式  层序遍历求深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int levelSize=1;
        int height=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize--;

            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }

            if(levelSize==0){
                levelSize=queue.size();
                height=height+1;
            }
        }
        return height;
    }

    /**
     * 递归方式
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int left = maxDepth2(root.left);
            int right = maxDepth2(root.right);
            return 1+Math.max(left,right);
        }
    }
}
