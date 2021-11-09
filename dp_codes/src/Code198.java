import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code198
 * @Author lihuasong
 * @Description
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 示例 3：
 * 输入：[3,7,9,3,1,100]
 * 输出：112
 * 解释：偷窃 1 号房屋 (金额 = 3), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 6 号房屋 (金额 = 100)。
 *      偷窃到的最高金额 = 3 + 9 + 100 = 112 。
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 解题思路：
 *  当 nums的长度大于2时：
 *  当前（i）的值 和 截止到前一位（i-2）的每一个都求和然后取出最大值就只当前位置的最大值
 * @Date 2021-11-08 19:07
 * @Version V1.0
 **/

public class Code198 {

    public static int rob(int[] nums) {

        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        int max = Math.max(sum[0],sum[1]);
        for (int i = 2; i < nums.length; i++) {
            for(int j=0;j<i-1;j++){
                sum[i] = Math.max(nums[i]+sum[j],sum[i]);
                max = Math.max(max,sum[i]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{1,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{3,7,9,3,1,100}));
    }
}
