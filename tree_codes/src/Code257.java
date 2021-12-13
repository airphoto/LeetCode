import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * @ClassName Code257
 * @Author lihuasong
 * @Description
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 *  
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 *
 * 提示：
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 *  解题思路：利用后序遍历法
 * @Date 2021/12/13 21:53
 * @Version V1.0
 **/
public class Code257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root.left==null && root.right==null){
            result.add(root.val+"");
            return result;
        }

        List<TreeNode> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode node = root;

        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                nodes.add(node);
                node=node.left;
            }

            node = stack.pop();
            if(node.right==null || node.right==lastVisited){
                if(node.left==null && node.right==null){
                    StringBuilder sb = new StringBuilder();
                    for (TreeNode treeNode : nodes) {
                        sb.append("->").append(treeNode.val);
                    }
                    result.add(sb.delete(0,2).toString());
                }
                lastVisited=node;
                node=null;
                nodes.remove(lastVisited);
            }else{
                stack.push(node);
                node=node.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left=n2;
        n2.right=n4;
        n1.right=n3;
        System.out.println(binaryTreePaths(n1));
    }
}
