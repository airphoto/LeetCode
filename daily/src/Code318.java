import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Code318
 * @Author lihuasong
 * @Description
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。
 * 如果不存在这样的两个单词，返回 0。
 *
 *示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *  
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 * @Date 2021-11-17 19:15
 * @Version V1.0
 **/

public class Code318 {
    public static int maxProduct(String[] words) {
        Map<String, Set<Character>> data = new HashMap<>();
        data.put(words[0],words[0].chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));

        Set<Character> contains = new HashSet<>();
        int max = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int i1 = i+1; i1 < words.length; i1++) {
                if(!data.containsKey(words[i1])){
                    data.put(words[i1],words[i1].chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
                }
                contains.clear();
                contains.addAll(data.get(words[i]));
                contains.retainAll(data.get(words[i1]));
                if(contains.isEmpty()){
                  max=Math.max(max,words[i].length()*words[i1].length());
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }
}
