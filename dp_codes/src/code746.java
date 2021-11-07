import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName code746
 * @Author lihuasong
 * @Description
 *
 * 746. 使用最小花费爬楼梯
 *
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 *
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 *
 * 提示：
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 *
 * 理解题意需要注意两点：
 * 第i级台阶是第i-1级台阶的阶梯顶部。
 * 踏上第i级台阶花费cost[i]，直接迈一大步跨过而不踏上去则不用花费。

到达第i级台阶的阶梯顶部的最小花费，有两个选择：

先付出最小总花费minCost[i-1]到达第i级台阶（即第i-1级台阶的阶梯顶部），踏上第i级台阶需要再花费cost[i]，再迈一步到达第i级台阶的阶梯顶部，最小总花费为minCost[i-1] + cost[i])；
先付出最小总花费minCost[i-2]到达第i-1级台阶（即第i-2级台阶的阶梯顶部），踏上第i-1级台阶需要再花费cost[i-1]，再迈两步跨过第i级台阶直接到达第i级台阶的阶梯顶部，最小总花费为minCost[i-2] + cost[i-1])；
则minCost[i]是上面这两个最小总花费中的最小值。
minCost[i] = min(minCost[i-1] + cost[i], minCost[i-2] + cost[i-1])。
台阶的数组从0开始计数。可以用-1代表地面，并设cost[-1] = 0。
最小总花费的初始值为：
第0级台阶： minCost[0] = min(cost[-1], cost[0]) = min(0, cost[0]) = 0，
第1级台阶： minCost[1] = min(cost[0], cost[1])。

参考
https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/

 * @Date 2021-11-06 13:03
 * @Version V1.0
 **/

public class code746 {
    public static int minCostClimbingStairs(int[] cost) {

        int minCost0 = 0;
        int minCost1 = Math.min(cost[0], cost[1]);
        int minCost = 0;
        for (int i = 2; i < cost.length; i++) {
            minCost = Math.min(minCost1 + cost[i], minCost0 + cost[i - 1]);
            minCost0 = minCost1;
            minCost1 = minCost;
        }
        return minCost;

    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20,50,1}));
//        System.out.println("---------------------------");
//        System.out.println(minCostClimbingStairs(new int[]{1,2,1,1,4}));
//        System.out.println("---------------------------");
//        System.out.println(minCostClimbingStairs(new int[]{10,15,20,300,1000}));
//        System.out.println("---------------------------");
//        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
//        System.out.println("---------------------------");
//        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1, 1,1}));
//        System.out.println("---------------------------");

    }
}
