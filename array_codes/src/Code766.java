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
 *
 * @Date 2021/1/19 21:43
 * @Version V1.0
 **/
public class Code766 {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int mlength = matrix[0].length;
        int[] nums = new int[matrix.length+mlength-1];
        if(nums.length==1) {
            return true;
        }

        int index = 0;
        int length = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                if(i==0 || i1==0){
                    nums[index] = matrix[i][i1];
                    index ++;
                } else if (nums[length - i*mlength -1] != matrix[i][i1]){
                    return false;
                }
                length +=1;
            }

        }
        return true;
    }
}
