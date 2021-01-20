/**
 * @ClassName Code766
 * @Author lihuasong
 * @Description
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,2,3,4,5],
 *   [5,1,2,3,4],
 *   [9,5,1,2,3],
 *   [6,9,5,1,2],
 *   [2,6,9,5,1]
 * ]
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 * 说明:
 * matrix 是一个包含整数的二维数组。
 * matrix 的行数和列数均在 [1, 20]范围内。
 * matrix[i][j] 包含的整数在 [0, 99]范围内。
 *
 * 思考：
 *      解法一：将边界的数值保存到一个数组中，然后寻找两个数组的index之间的规律
 *      解法二：
 *      第i行    [0,n-1] 与
 *      第i+1行的 [1,n]  相同
 * @Date 2021/1/19 21:43
 * @Version V1.0
 **/
public class Code766 {

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int[][] matrix = new int[][] {{1,2},{2,1},{1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int mlength = matrix[0].length;
        int hlength = matrix.length;
        int[] nums = new int[hlength+mlength-1];
        if(nums.length==1) {
            return true;
        }

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                if(i==0 || i1==0){
                    nums[index] = matrix[i][i1];
                    index ++;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(i<=mlength-1){
                int h1 = 0;
                int h2 = i;
                while (h1<hlength && h2<mlength){
                    if (nums[i] != matrix[h1][h2]){
                        return false;
                    }
                    h1++;
                    h2++;
                }
            }
            if (i>mlength-1){
                int h1 = i-mlength+1;
                int h2 = 0;
                while (h1<hlength && h2<mlength){
                    if (nums[i] != matrix[h1][h2]){
                        return false;
                    }
                    h1++;
                    h2++;
                }
            }
        }
        return true;
    }
}
