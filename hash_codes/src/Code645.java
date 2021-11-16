import java.util.*;

/**
 * @ClassName Code645
 * @Author lihuasong
 * @Description
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 * @Date 2021-11-15 20:44
 * @Version V1.0
 **/

public class Code645 {

    public static int[] findErrorNums(int[] nums) {
        int[] bak = new int[nums.length];

        int twice=0;
        for (int num : nums) {
            if (bak[num-1]!=0){
                twice=num;
            }
            bak[num-1]=1;
        }
        int miss = 0;
        for (int i = 0; i < bak.length; i++) {
            if(bak[i]==0){
                miss=i+1;
                break;
            }
        }
        return new int[]{twice,miss};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{3,2,3,4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,1})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{2,2})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,1,3})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{3,3,1})));
    }
}
