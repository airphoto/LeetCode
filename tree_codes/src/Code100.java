import java.util.Stack;

/**
 * @ClassName Code100
 * @Author lihuasong
 * @Description
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 * @Date 2021/12/8 22:31
 * @Version V1.0
 **/
public class Code100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==q;
        }

        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        ps.push(p);
        qs.push(q);

        while (!qs.isEmpty()|| !ps.isEmpty()){
            TreeNode qn = qs.pop();
            TreeNode pn = ps.pop();
            boolean lefteq = (qn.left==null) == (pn.left==null);
            boolean righteq = (qn.right==null) == (pn.right==null);
            boolean valeq = qn.val==pn.val;

            if(!lefteq || !righteq || !valeq){
                return false;
            }

            if(qn.left!=null){
                qs.push(qn.left);
            }
            if (qn.right!=null){
                qs.push(qn.right);
            }

            if(pn.left!=null){
                ps.push(pn.left);
            }
            if (pn.right!=null){
                ps.push(pn.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        p.left=p1;

        TreeNode q = new TreeNode(1);

        System.out.println(isSameTree(p,q));
    }
}
