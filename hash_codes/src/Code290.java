import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Code290
 * @Author lihuasong
 * @Description
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * @Date 2021-11-11 19:54
 * @Version V1.0
 **/

public class Code290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] field = s.split(" ");

        if(field.length!=pattern.length()){
            return false;
        }


        Map<Character,String> datac = new HashMap<>();
        Map<String,Character> datas = new HashMap<>();

        for (int i = 0; i < field.length; i++) {
            if(!datac.containsKey(pattern.charAt(i))){
                datac.put(pattern.charAt(i),field[i]);
            }
            if(!datas.containsKey(field[i])){
                datas.put(field[i],pattern.charAt(i));
            }

            if(!datac.get(pattern.charAt(i)).equals(field[i]) || datas.get(field[i])!=pattern.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat cat"));
        System.out.println(wordPattern("abba","cat cat cat cat"));
    }
}
