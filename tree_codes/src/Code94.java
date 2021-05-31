import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code94
 * @Author lihuasong
 * @Description
 *          二叉树的中序遍历
 * @Date 2021/5/31 20:39
 * @Version V1.0
 **/
public class Code94 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node3,null);
        TreeNode root = new TreeNode(1,null,node2);

        for (Integer integer : inorderTraversal(root)) {
            System.out.println(integer);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addData(result,root);
        return result;
    }

    public static void addData(List<Integer> result,TreeNode root){
        if(root==null){
            return;
        }

        addData(result,root.left);
        result.add(root.val);
        addData(result,root.right);
    }


}
