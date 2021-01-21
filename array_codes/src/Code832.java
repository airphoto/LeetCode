/**
 * @ClassName Code832
 * @Author lihuasong
 * @Description
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 示例 2:
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * 说明:
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * @Date 2021/1/21 21:15
 * @Version V1.0
 **/
public class Code832 {

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int[][] nums = new int[][]{{1,0,0,1},{1,1,0,0},{0,1,1,1},{1,0,1,0}};
        int[][] ints = flipAndInvertImage2(nums);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf(i+" ");
            }
            System.out.println("");
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int length = A[0].length;
        for (int[] ints : A) {
            for (int i1 = 0; i1 < (ints.length+1)/2; i1++) {
                int tmp = ints[i1];
                ints[i1] = ints[length-i1-1]^1;
                ints[length-i1-1] = tmp^1;
            }
        }
        return A;
    }

    public static int[][] flipAndInvertImage2(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                result[i][i1] = 1-A[i][A[i].length-i1-1];
            }
        }
        return result;
    }
}
