/**
 * @ClassName Code520
 * @Author lihuasong
 * @Description
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：word = "USA"
 * 输出：true
 *
 * 示例 2：
 * 输入：word = "FlaG"
 * 输出：false
 *  
 * 提示：
 *
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * 注意： 小写字母的Unicode 比大写字母 大
 * @Date 2021-11-13 20:59
 * @Version V1.0
 **/

public class Code520 {
    public static boolean detectCapitalUse(String word) {
        if (word.length()==1){
            return true;
        }

        char c1 = word.charAt(0);
        char c2 = word.charAt(1);
        if (c1>'Z' && c2<='Z'){
            return false;
        }

        for(int i=2;i<word.length();i++){
            char c = word.charAt(i);
            if(c1>'Z'){
                if(c<='Z'){
                    return false;
                }
            }else if(c2 <= 'Z'){
                if(c > 'Z'){
                    return false;
                }
            }else{
                if(c <= 'Z'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("A"));
        System.out.println(detectCapitalUse("b"));
        System.out.println(detectCapitalUse("bA"));
        System.out.println(detectCapitalUse("AB"));
        System.out.println(detectCapitalUse("Ab"));
    }
}
