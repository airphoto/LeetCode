import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Code409
 * @Author lihuasong
 * @Description
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @Date 2021-11-13 21:27
 * @Version V1.0
 **/

public class Code409 {
    public static int longestPalindrome(String s) {
        if(s.length()==1){
            return 1;
        }

        Map<Character,Integer> data = new HashMap<>();

        for(int i=0;i<s.length();i++){
            data.put(s.charAt(i),data.getOrDefault(s.charAt(i),0)+1);
        }

        int flag=0;
        int sum=0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : data.entrySet()) {
            if (characterIntegerEntry.getValue() > 1){
                sum += (characterIntegerEntry.getValue()/2)*2;
            }
            if(characterIntegerEntry.getValue()%2!=0){
                flag=1;
            }
        }
        return sum+flag;
    }

    public static int longestPalindrome2(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(longestPalindrome("abdccccdd"));
        System.out.println(longestPalindrome("Aa"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("aaa"));
        System.out.println(longestPalindrome("tattarrattat"));
    }
}
