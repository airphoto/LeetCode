/**
 * @ClassName Code643
 * @Author lihuasong
 * @Description
 * 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 提示：
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * @Date 2021/2/4 21:23
 * @Version V1.0
 **/
public class Code643 {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage2(nums,4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int max = 0;
        for (int i = k-1; i <nums.length; i++) {
            int sum = 0;
            for (int j = i-k+1; j <= i; j++) {
                sum+=nums[j];
            }
            max = i==k-1?sum:Math.max(sum,max);
        }
        return max*1.0/k;
    }

    public static double findMaxAverage2(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int sum = max;
        for (int i = k; i <nums.length; i++) {
            sum = sum+nums[i]-nums[i-k];
            max = Math.max(max,sum);
        }
        return max*1.0/k;
    }
}
