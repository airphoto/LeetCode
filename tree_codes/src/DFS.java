import java.util.Stack;

/**
 * @ClassName DFS
 * @Author lihuasong
 * @Description
 *  实际上不管是前序遍历，还是中序遍历，亦或是后序遍历，都属于深度优先遍历。
 * @Date 2021/12/8 23:01
 * @Version V1.0
 **/
public class DFS {
    /**
     * 递归遍历
     * @param node
     */
    public static void dfs1(TreeNode node){
        if(node==null){
            return;
        }

        //此处是处理传进来的node节点的代码

        // 遍历左子树
        dfs1(node.left);

        // 遍历右子树
        dfs1(node.right);
    }

    /**
     * 非递归遍历
     *
     * 仔细观察深度优先遍历的特点，对二叉树来说，由于是先序遍历(先遍历当前节点，再遍历左节点，再遍历右节点)，所以我们有如下思路：
     * 对于每个节点来说，先遍历当前节点，然后把右节点压栈，再压左节点(这样弹栈的时候会先拿到左节点遍历，符合深度优先遍历要求)。
     * 弹栈，拿到栈顶的节点，如果节点不为空，重复步骤 1， 如果为空，结束遍历。
     * @param node
     */
    public static void dfs2(TreeNode node){
        if(node==null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode n = stack.pop();
            if(n.right!=null){
                stack.push(n.right);
            }
            if(n.left!=null){
                stack.push(n.right);
            }
        }
    }
}
