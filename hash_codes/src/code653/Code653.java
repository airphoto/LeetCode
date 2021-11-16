package code653;

import java.util.*;

/**
 * @ClassName code653.Code653
 * @Author lihuasong
 * @Description
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *示例 1：
 *
 *
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 *
 * 示例 2：
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 *
 * 示例 3：
 * 输入: root = [2,1,3], k = 4
 * 输出: true
 *
 * 示例 4：
 * 输入: root = [2,1,3], k = 1
 * 输出: false
 *
 * 示例 5：
 * 输入: root = [2,1,3], k = 3
 * 输出: true
 *  
 * 提示:
 *
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 *
 * 本次测试没有问题，但是提交之后显示错误
 *
 * @Date 2021-11-16 19:04
 * @Version V1.0
 **/

public class Code653 {
    public static boolean findTarget(TreeNode root, int k) {
        Map<Integer, Set<Integer>> data = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        data.put(root.val,new HashSet<>());

        stack.push(root.left);
        stack.push(root.right);

        // 深度优先遍历
        while (!stack.empty()){
            TreeNode node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            for (Map.Entry<Integer, Set<Integer>> entry : data.entrySet()) {
                Set<Integer> values = data.getOrDefault(entry.getKey(),new HashSet<>());
                values.add(entry.getKey()+node.val);
                if(values.contains(k)){
                    return true;
                }
                data.put(entry.getKey(),values);
            }
        }

        return false;
    }
    public static void main(String[] args) {
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(3,node2,node4);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node6 = new TreeNode(6,null,node7);
//        TreeNode node5 = new TreeNode(5,node3,node6);
//
//        System.out.println(findTarget(node3,7));
//
        TreeNode node1 = new TreeNode(1);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node2_2 = new TreeNode(2,node1,node3_2);

        System.out.println(findTarget(node2_2,3));

    }
}
