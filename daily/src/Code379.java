/**
 * @ClassName Code379
 * @Author lihuasong
 * @Description
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *
 * @Date 2021-11-19 19:27
 * @Version V1.0
 **/

public class Code379 {
    public static int integerReplacement(int n) {


        while (n!=1){
            if(n%2==0){
                n=n/2;
            }else{
                n=n+1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
