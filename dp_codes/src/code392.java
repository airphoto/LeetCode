/**
 * @ClassName code392
 * @Author lihuasong
 * @Description
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * 解题思路：
 * 循环t字符串，从起点开始只有当t[i]=s[j]时，j才会自增，当j==s的长度时，就代表s是t的字串
 * @Date 2021-11-09 20:24
 * @Version V1.0
 **/

public class code392 {
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        if(t.length()==0){
            return false;
        }

        int j=0;
        for (int i = 0; i < t.toCharArray().length; i++) {
            if (t.charAt(i)==s.charAt(j)){
                j++;
                if(j==s.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("b","abc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
