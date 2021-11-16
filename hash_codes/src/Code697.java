import java.util.*;

/**
 * @ClassName Code697
 * @Author lihuasong
 * @Description
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 *
 * @Date 2021-11-16 19:41
 * @Version V1.0
 **/

public class Code697 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,Map<String,Integer>> data = new HashMap<>();
        Map<Integer,Set<Integer>> maxd = new HashMap<>();

        int max = -1;
        for (int i=0;i<nums.length;i++) {

            Map<String,Integer> mm = data.getOrDefault(nums[i],new HashMap<>());
            if (!mm.containsKey("min")){
                mm.put("min",i);
            }
            mm.put("max",i);
            mm.put("num",mm.getOrDefault("num",0)+1);

            data.put(nums[i],mm);
            if(mm.get("num")>max){
                max = mm.get("num");
            }
            if(mm.get("num")==max){
                Set<Integer> ss = maxd.getOrDefault(max,new HashSet<>());
                ss.add(nums[i]);
                maxd.put(max,ss);
            }
        }

        int min=nums.length;
        for (Integer integer : maxd.get(max)) {
            Map<String, Integer> stm = data.get(integer);
            min = Math.min(stm.get("max")-stm.get("min")+1,min);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,3,3,1}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,3,3,1,4,2}));
    }
}
