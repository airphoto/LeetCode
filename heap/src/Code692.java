import java.util.*;

/**
 * @ClassName Code692
 * @Author lihuasong
 * @Description
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * 注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 * @Date 2021/6/1 23:44
 * @Version V1.0
 **/
public class Code692 {
    public static void main(String[] args) {
        String[] values = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        for (String s : topKFrequent2(values, 4)) {
            System.out.println(s);
        }
        System.out.println("---------------");
        String[] values2 = {"i", "love", "leetcode", "i", "love", "coding"};
        for (String s : topKFrequent2(values2, 2)) {
            System.out.println(s);
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> data = new HashMap<>();
        for (String word : words) {
            data.put(word,data.getOrDefault(word,0)+1);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(data.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer valueCompare = o2.getValue()-o1.getValue();
                return valueCompare==0?o1.getKey().compareTo(o2.getKey()):valueCompare;
            }
        });

        List<String> result = new ArrayList<>();
        for (int i=0;i<k;i++){
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static List<String> topKFrequent2(String[] words, int k) {
        PriorityQueue<Map.Entry<String,Integer>> data = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer valueCompare = o2.getValue()-o1.getValue();
                return valueCompare==0?o1.getKey().compareTo(o2.getKey()):valueCompare;
            }
        });

        Map<String,Integer> pair = new HashMap<>();
        for (String word : words) {
            pair.put(word,pair.getOrDefault(word,0)+1);
        }

        data.addAll(pair.entrySet());

        List<String> result = new ArrayList<>();
        for (int i=0;i<k;i++){
            result.add(data.poll().getKey());
        }
        return result;
    }
}
