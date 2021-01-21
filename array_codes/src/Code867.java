/**
 * @ClassName Code867
 * @Author lihuasong
 * @Description
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],
 *       [4,5,6],
 *       [7,8,9]]
 *
 * 输出：[[1,4,7],
 *       [2,5,8],
 *       [3,6,9]]
 * 示例 2：
 *
 * 输入：[[1,2,3],
 *       [4,5,6]]
 * 输出：[[1,4],
 *       [2,5],
 *       [3,6]]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 *
 * @Date 2021/1/21 22:04
 * @Version V1.0
 **/
public class Code867 {

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums = new int[][]{{1,2,3},{4,5,6}};
        int[][] transpose = transpose(nums);

        for (int[] ints : transpose) {
            for (int anInt : ints) {
                System.out.printf(anInt+" ");
            }
            System.out.println("");
        }
    }
    public static int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                result[i][i1] = A[i1][i];
            }
        }
        return result;
    }
}
