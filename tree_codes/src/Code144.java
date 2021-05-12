
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Code144
 * @Author lihuasong
 * @Description
 * @Date 2021/5/12 22:12
 * @Version V1.0
 **/
public class Code144 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node3,null);
        TreeNode root = new TreeNode(1,null,node2);

        for (Integer integer : preorderTraversal2(root)) {
            System.out.println(integer);
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        if(root==null) {
            return data;
        }
        add(root,data);
        return data;
    }

    private static void add(TreeNode root,List<Integer> data){
        if(root == null){
            return ;
        }
        data.add(root.val);
        add(root.left,data);
        add(root.right,data);
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        if(root==null) {
            return data;
        }

        return data;
    }

}
