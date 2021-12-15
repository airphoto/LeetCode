import java.util.*;

/**
 * @ClassName Code501
 * @Author lihuasong
 * @Description
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @Date 2021/12/15 21:21
 * @Version V1.0
 **/
public class Code501 {
    public static int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Map<Integer,Integer> targetNumbers = new HashMap<>();
        int max=1;
        Map<Integer, List<Integer>> numbersTargets = new HashMap<>();

        while (!stack.isEmpty()){
            TreeNode p = stack.pop();
            int num = targetNumbers.getOrDefault(p.val,0)+1;
            max = Math.max(num,max);
            targetNumbers.put(p.val,num);
            List<Integer> list = numbersTargets.getOrDefault(num,new ArrayList<>());
            list.add(p.val);
            numbersTargets.put(num,list);
            if(p.right!=null){
                stack.push(p.right);
            }
            if(p.left!=null){
                stack.push(p.left);
            }
        }

        return numbersTargets.get(max).stream().mapToInt(x->x).toArray();
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.right=t2;
        t2.left=t3;
        System.out.println(Arrays.toString(findMode(t1)));
    }
}
