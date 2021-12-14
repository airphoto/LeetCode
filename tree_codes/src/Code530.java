import java.util.Stack;

/**
 * @ClassName Code530
 * @Author lihuasong
 * @Description
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 提示：
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * @Date 2021/12/14 22:24
 * @Version V1.0
 **/
public class Code530 {
    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer min = Integer.MAX_VALUE;
        Integer pre = -new Double(Math.pow(10,5)).intValue();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            min=Math.min(min,root.val-pre);
            pre=root.val;
            root = root.right;
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(99999);
        TreeNode t5 = new TreeNode(100000);
        t4.left=t2;
        t2.left=t1;
        t2.right=t3;
        t4.right=t5;
        System.out.println(getMinimumDifference(t4));

//        System.out.println(10 - Integer.MIN_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
