import java.util.*;

/**
 * @ClassName Code350
 * @Author lihuasong
 * @Description
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * @Date 2021-11-11 20:37
 * @Version V1.0
 **/

public class Code350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for (int i : nums1) {
            map1.put(i,map1.getOrDefault(i,0)+1);
        }

        for (int i : nums2){
            if(map1.containsKey(i)) {
                map2.put(i, map2.getOrDefault(i, 0) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map2.entrySet()) {
            int min = Math.min(integerIntegerEntry.getValue(),map1.get(integerIntegerEntry.getKey()));
            for (int i = 0; i < min; i++) {
                list.add(integerIntegerEntry.getKey());
            }
        }

        return list.stream().mapToInt(x->x).toArray();

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
}
