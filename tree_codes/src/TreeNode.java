import java.util.Stack;

/**
 * @ClassName TreeNode
 * @Author lihuasong
 * @Description
 * @Date 2021/5/12 22:11
 * @Version V1.0
 **/
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

    /**
     * 前序遍历 访问顺序：根节点、前序遍历左子树、前序遍历右子树
     *
     * @param root
     */
    public static void preOrderByIteration(TreeNode root){
        if (root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
     }

    /**
     * 中序遍历 ：
     * @param root
     */
     public static void inOrderByIteration(TreeNode root) {
        if(root==null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node!=null || !stack.isEmpty()){
                while (node!=null){
                    stack.push(node);
                    node=node.left;
                }
            node = stack.pop();
            System.out.println(node.val);
            node=node.right;
        }
     }

    /**
     * 后续遍历
     * @param root
     */
    public static void postOrderByIteration(TreeNode root){
        if(root==null){
            return;
        }

        TreeNode node = root;
        TreeNode lastVisited = null;
        Stack<TreeNode> stack = new Stack<>();

        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }

            node = stack.pop();
            if(node.right!=null || node.right==lastVisited){
                System.out.println(node.val);
                lastVisited=node;
                node=null;
            }else{
                stack.push(node);
                node=node.right;
            }
        }
     }
}
