import java.util.Arrays;

/**
 * @ClassName Code283
 * @Author lihuasong
 * @Description
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @Date 2021/1/23 19:25
 * @Version V1.0
 **/
public class Code283 {

    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,0,0,0,1};
//        int[] nums = {0,0,0,0,0};
//        int[] nums = {1};
//        int[] nums = {0};
        int[] nums = {1,1,1};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]==0){
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j]!=0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                    if (j==nums.length - 1){
                        return;
                    }
                }
            }
        }
    }

    /**
     * 思路：
     *      循环数组，如果当前元素不为0，使用额外的index记录长度，当元素为0时，停止index增长，
     *      继续循环后边的元素，
     *      将不为0的元素覆盖到index，同时增长index的大小
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                index++;
                nums[index] = nums[i];
                if(index!=i) {
                    nums[i] = 0;
                }
            }
        }
    }
}
