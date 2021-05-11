import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @ClassName Code496
 * @Author lihuasong
 * @Description
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/5/11 21:37
 * @Version V1.0
 **/
public class Code496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> tmp = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] result = new int[nums1.length];

        for (int i : nums2) {
            stack2.push(i);
        }

        for (int i = 0;i< nums1.length; i++) {
            int max = -1;
            while (stack2.peek() != nums1[i]){
                int current = stack2.pop();
                max=current>nums1[i]?current:max;
                tmp.push(current);
            }
            while (!tmp.isEmpty()){
                stack2.push(tmp.pop());
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = nextGreaterElement(new int[]{2,4}, new int[]{1,2, 3, 4});
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }
}
