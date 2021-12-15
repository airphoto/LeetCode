import java.util.Stack;

/**
 * @ClassName Code606
 * @Author lihuasong
 * @Description
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * @Date 2021/12/15 22:11
 * @Version V1.0
 **/
public class Code606 {
    static StringBuilder sb = new StringBuilder();
    public static String tree2str(TreeNode root) {
        if(root.left ==null && root.right == null){
            return root.val+"";
        }
        preOrder(root.left);
        preOrder(root.right);
        String s = sb.toString().replace("())",")");
        return root.left!=null?root.val+s:root.val+"()"+s;
    }

    public static void preOrder(TreeNode root){

        if(root==null){
            return;
        }
        sb.append("(");
        sb.append(root.val);
        if(root.left==null){
            sb.append("()");
        }
        preOrder(root.left);
        preOrder(root.right);
        sb.append(")");
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left=t2;
        t2.left=t4;
        t1.right=t3;
        System.out.println(tree2str(t1));
    }
}
