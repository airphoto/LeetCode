import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Code389
 * @Author lihuasong
 * @Description
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。

 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"

 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/5/11 22:56
 * @Version V1.0
 **/
public class Code389 {
    public static char findTheDifference1(String s, String t) {
        int[] data = new int[26];

        for(char c : s.toCharArray()){
            data[c-'a']++;
        }

        for(char c : t.toCharArray()){
            if( --data[c-'a'] < 0){
                return c;
            }
        }
        return 0;
    }

    public static char findTheDifference2(String s, String t) {
        Map<Character,Integer> datas = new HashMap<>();
        Map<Character,Integer> datat = new HashMap<>();

        for(char c : s.toCharArray()){
            datas.put(c,datas.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray()){
            datat.put(c,datat.getOrDefault(c,0)+1);
            if(!datas.containsKey(c) || datas.get(c)<datat.get(c)){
                return c;
            }
        }
        return 0;
    }
}
