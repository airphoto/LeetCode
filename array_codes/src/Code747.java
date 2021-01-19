/**
 * @ClassName Code747
 * @Author lihuasong
 * @Description
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *  
 * 提示:
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
 *
 * 思考：
 * 分别找出最大值和次最大值，看两个值是否有两倍关系
 * @Date 2021/1/19 21:16
 * @Version V1.0
 **/
public class Code747 {

    public static void main(String[] args) {
//        int[] numx = new int[]{3,6,1,0};
//        int[] numx = new int[]{1,2,3,4};
//        int[] numx = new int[]{1,2,3,6};
//        int[] numx = new int[]{0,0,0,0,1};
        int[] numx = new int[]{0,0,4,2};
        System.out.println(dominantIndex(numx));
    }

    public static int dominantIndex(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        int max = nums[0];
        int pMax = 0;
        int index = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>max){
                pMax = max;
                max = nums[i];
                index = i;
            }
            if(nums[i]>pMax && nums[i]<max){
                pMax = nums[i];
            }
        }

        return max>=pMax*2?index:-1;
    }
}
