import java.util.Arrays;

/**
 * @ClassName code213
 * @Author lihuasong
 * @Description
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，
 * 每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 *
 * [2,3,2] = 3
 * [2,3,100] = 100
 * [2,3,100,1] = 102
 * [2,3,100,1,3] = 103
 * [2,3,100,1,3,4] = 105
 *
 * @Date 2021-11-08 19:42
 * @Version V1.0
 **/

public class code213 {
    public static int rob(int[] nums) {
        int length = nums.length;
        if(length==1) return nums[0];
        if(length==2) return Math.max(nums[0],nums[1]);

        int[] sum = new int[length];
        int[] first = new int[length];

        sum[0] = nums[0];
        sum[1] = nums[1];
        first[0] = 0;
        first[1] = 1;

        for(int i=2;i<length;i++){
            for(int j=0;j<i-1;j++){
                if(i<length-1 && sum[j]+nums[i]>=sum[i]){
                    sum[i] = sum[j]+nums[i];
                    first[i] = first[j];
                }else if (i==length-1 && sum[j]+nums[i]-(first[j]==0?nums[0]:0)>=sum[i]){
                    sum[i] = sum[j]+nums[i]-(first[j]==0?nums[0]:0);
                    first[i] = first[j];
                }
            }
        }
        int max = 0;
        for (int i : sum) {
            max = Math.max(max,i);
        }

        System.out.println(Arrays.toString(sum)+"-"+Arrays.toString(first));
        return max;
    }

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2,1,2,6,1,8,10,10}));
//        System.out.println(rob(new int[]{2,2,4,3,2,5}));
//        System.out.println(rob(new int[]{1,1,1,2}));
//        System.out.println(rob(new int[]{0}));
//        System.out.println(rob(new int[]{1,2,3,1}));
//        System.out.println(rob(new int[]{2,3,2}));
//        System.out.println(rob(new int[]{2,3,100}));
//        System.out.println(rob(new int[]{2,3,100,1}));
//        System.out.println(rob(new int[]{2,3,100,1,3}));
//        System.out.println(rob(new int[]{2,3,100,1,3,4}));
    }
}
