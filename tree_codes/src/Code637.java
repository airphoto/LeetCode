import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Code637
 * @Author lihuasong
 * @Description
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * 提示：
 * 节点值的范围在32位有符号整数范围内。
 *
 * @Date 2021/12/15 22:47
 * @Version V1.0
 **/
public class Code637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        int ls=1;
        Double levelSum=0.0;
        List<Double> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize--;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            levelSum+=node.val;
            if(levelSize==0){
                levelSize=queue.size();
                if(ls>0) {
                    list.add((double) levelSum / ls);
                }
                ls=levelSize;
                levelSum=0.0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2147483647);
        TreeNode t2 = new TreeNode(2147483647);
        TreeNode t3 = new TreeNode(2147483647);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
//        t3.left=t4;
//        t3.right=t5;
        System.out.println(averageOfLevels(t1));
    }
}
