import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Code387
 * @Author lihuasong
 * @Description
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * @Date 2021-11-11 21:02
 * @Version V1.0
 **/

public class Code387 {
    public static int firstUniqChar(String s) {
        Map<Character,Integer> firstIndex = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(!firstIndex.containsKey(chars[i])){
                firstIndex.put(chars[i],i);
            }else {
                chars[firstIndex.get(chars[i])]='0';
                chars[i]='0';
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>'0'){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("lllll"));
    }
}
