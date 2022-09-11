import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * @ClassName Code686
 * @Author lihuasong
 * @Description
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 *
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 *
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 *
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 * 提示：
 * 1 <= a.length <= 104
 * 1 <= b.length <= 104
 * a 和 b 由小写英文字母组成
 *
 * @Date 2021/12/22 20:52
 * @Version V1.0
 **/
public class Code686 {

    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        int step1 = cost[0];
        int step2 = cost[1];

        for(int i=2;i<cost.length;i++){
            int t = Math.min(step1+cost[i-1],step2+cost[i]);
            step1=step2;
            step2=t;
        }
        return Math.min(step1,step2);
    }

    public static void main(String[] args) {

    }
}
