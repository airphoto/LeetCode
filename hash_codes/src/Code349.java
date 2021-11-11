import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Code349
 * @Author lihuasong
 * @Description
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @Date 2021-11-11 20:18
 * @Version V1.0
 **/

public class Code349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> union = new HashSet<>();

        for(int i:nums2){
            if(set.contains(i)){
                union.add(i);
            }
        }

        int[] nums = new int[union.size()];
        int index=0;
        for (Integer integer : union) {
            nums[index]=integer;
            index++;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,1},new int[]{2,2})));
    }
}
