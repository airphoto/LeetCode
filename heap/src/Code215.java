import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @ClassName Code215
 * @Author lihuasong
 * @Description
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @Date 2021/6/1 23:10
 * @Version V1.0
 **/
public class Code215 {
    public static void main(String[] args) {
//        System.out.println(findKthLargest3(new int[]{3,2,1,5,6,4},2));
//        System.out.println(findKthLargest3(new int[]{3,2,3,1,2,4,5,5,6},4));
        System.out.println(findKthLargest3(new int[]{3,2,1},3));
    }

    // 排序
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    // 排序
    public static int findKthLargest3(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++) {
            int current = nums[i];
            int l=i;
            for (int j = i+1; j <nums.length; j++) {
                if(current<nums[j]){
                    current = nums[j];
                    l = j;
                }
            }
            nums[l] = nums[i];
            nums[i] = current;
            if(i==k-1){
                return current;
            }
        }
        return nums[k-1];
    }

    // 堆
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }

        for (int i=1;i<k;i++){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}
