import java.util.Arrays;

/**
 * @ClassName Code338
 * @Author lihuasong
 * @Description
 *
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *  
 * 提示：
 * 0 <= n <= 105
 *
 * 解题思路：
 *  求出当前值和之前状态的关系 nums[i/2]+nums[i%2]
 * @Date 2021-11-09 19:59
 * @Version V1.0
 **/

public class Code338 {

    public static int[] countBits(int n) {

        if(n==0) return new int[]{0};
        if(n==1) return new int[]{0,1};

        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;

        for(int i=2;i<=n;i++){
            nums[i] = nums[i/2]+nums[i%2];  // 核心的递推公式
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
