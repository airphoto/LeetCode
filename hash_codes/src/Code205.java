import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Code205
 * @Author lihuasong
 * @Description
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 * 提示：可以假设 s 和 t 长度相同。
 *
 * @Date 2021-11-10 20:20
 * @Version V1.0
 **/

public class Code205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> datas = new HashMap<>();
        Map<Character,Integer> datat = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!datas.containsKey(s.charAt(i))){
                datas.put(s.charAt(i),i);
            }
            if(!datat.containsKey(t.charAt(i))){
                datat.put(t.charAt(i),i);
            }
            if(!datas.get(s.charAt(i)).equals(datat.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));
        System.out.println(isIsomorphic("paper","title"));
        System.out.println(isIsomorphic("badc","baba"));
    }
}
