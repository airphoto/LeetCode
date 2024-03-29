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
     * 非递归
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
     * 前序遍历 递归
     *
     * @param root
     */
    public static void preOrderByRecursive(TreeNode root){
        if (root==null){
            return;
        }
        // 处理数据
        System.out.println(root.val);
        preOrderByRecursive(root.left);
        preOrderByRecursive(root.right);
    }

    /**
     * 中序遍历 ：
     * 非递归
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
     * 中序遍历 ：
     * 递归
     * @param root
     */
    public static void inOrderByRecursive(TreeNode root) {
        if(root==null){
            return;
        }
        inOrderByRecursive(root.left);
        // 处理数据
        System.out.println(root.val);

        inOrderByRecursive(root.right);
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
            if(node.right==null || node.right==lastVisited){
                System.out.println(node.val);
                lastVisited=node;
                node=null;
            }else{
                stack.push(node);
                node=node.right;
            }
        }
     }

    /**
     * 后续遍历
     * @param root
     */
    public static void postOrderByIteration2(TreeNode root){
        if(root==null){
            return;
        }

        Stack<TreeNode> src = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        src.push(root);
        while (!src.isEmpty()){
            TreeNode p = src.pop();
            result.push(p);
            if(p.left != null){
                src.push(p.left);
            }
            if(p.right!=null){
                src.push(p.right);
            }
        }

        while (!result.isEmpty()){
            System.out.println(result.pop().val);
        }
    }

    /**
     * 后续遍历
     * 递归
     * @param root
     */
    public static void postOrderByRecursive(TreeNode root){
        if(root==null){
            return;
        }

        postOrderByRecursive(root.left);
        postOrderByRecursive(root.right);
        // 处理数据
        System.out.println(root.val);
    }

    public static int height(TreeNode root){
        if(root==null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right=t2;
        t2.left=t3;
        System.out.println(height(t1));
    }
}
