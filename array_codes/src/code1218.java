import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName code1218
 * @Author lihuasong
 * @Description
 *
 * 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 * 示例 1：
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 *
 * 示例 2：
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 *
 * 示例 3：
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 *
 * 思路：
 * 动态规划的问题
 * 顺序循环数据，
 * 1：如果当前 arr[i]-difference 在之前没有出现过，那么以当前值为开始的子序列为1
 * 2：如果当前 arr[i]-difference 在之前出现过，那么当前子序列的长度就是之前出现过的序列长度加1
 *
 * @Date 2021-11-05 19:38
 * @Version V1.0
 **/

public class code1218 {

    public static int longestSubsequence(int[] arr, int difference) {
        int max=1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i-difference,0)+1);
            max=max>map.get(i)?max:map.get(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1,2,3,4},1));
        System.out.println(longestSubsequence(new int[]{1,3,5,7},1));
        System.out.println(longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
    }

}
