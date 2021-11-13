import java.util.*;

/**
 * @ClassName Code500
 * @Author lihuasong
 * @Description
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 *
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * 示例 1：
 *
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 *
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 *
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * @Date 2021-11-13 21:55
 * @Version V1.0
 **/

public class Code500 {

    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";

        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), 2);
        }
        for (int i = 0; i < s3.length(); i++) {
            map.put(s3.charAt(i), 3);
        }

        List<String> list = new ArrayList<>();

        for (String word : words) {
            char c0 = word.charAt(0)<'a'?(char)(word.charAt(0)+32):word.charAt(0);
            int index = map.get(c0);
            boolean add = true;
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if (map.get(c < 'a' ? (char) (c + 32) : c) != index) {
                    add = false;
                    break;
                }
            }
            if (add) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
//        System.out.println(Arrays.toString(findWords(new String[]{"omk"})));
//        System.out.println(Arrays.toString(findWords(new String[]{"o"})));
//        System.out.println(Arrays.toString(findWords(new String[]{"adsdf","sfd"})));
        System.out.println(Arrays.toString(findWords(new String[]{"Aasdfghjkl","Qwertyuiop","zZxcvbnm"})));
    }

}
