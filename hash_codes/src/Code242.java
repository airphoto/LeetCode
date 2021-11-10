import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Code242
 * @Author lihuasong
 * @Description
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * @Date 2021-11-10 20:42
 * @Version V1.0
 **/

public class Code242 {
    public static boolean isAnagram(String s, String t) {
        if(t.length()!=s.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chart);

        for(int i=0;i<s.length();i++){
            if(chars[i]!=chart[i]){
                return false;
            }
        }

        return true;
    }

    // 这个不对，异常点在哪呢？
    public static boolean isAnagram2(String s, String t) {
        if(t.length()!=s.length()){
            return false;
        }
        Map<Character,Integer> datas = new HashMap<>();
        Map<Character,Integer> datat = new HashMap<>();

        for(int i=0;i<s.length();i++){
            datas.put(s.charAt(i),datas.getOrDefault(s.charAt(i),1)+1);
            datat.put(t.charAt(i),datat.getOrDefault(t.charAt(i),1)+1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : datas.entrySet()) {
            if(datat.getOrDefault(characterIntegerEntry.getKey(),0)!=characterIntegerEntry.getValue()){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ala","laa"));
        System.out.println(isAnagram("rat","car"));
        System.out.println(isAnagram("anagram","nagaram"));

        System.out.println(isAnagram2("ala","laa"));
        System.out.println(isAnagram2("rat","car"));
        System.out.println(isAnagram2("anagram","nagaram"));
    }
}
