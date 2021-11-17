/**
 * @ClassName Code771
 * @Author lihuasong
 * @Description
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 * 示例 1：
 *
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * 示例 2：
 *
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 *  
 *
 * 提示：
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 *
 * @Date 2021-11-17 20:01
 * @Version V1.0
 **/

public class Code771 {
    public static int numJewelsInStones(String jewels, String stones) {
        int[] chars = new int[52];

        for(int i=0;i<stones.length();i++){
            char c = stones.charAt(i);
            if(c<='Z'){
                chars[c-'A']=chars[c-'A']+1;
            }else{
                chars[c-'a' + 26]=chars[c-'a' + 26]+1;
            }
        }

        int sum = 0;
        for(int i=0;i<jewels.length();i++){
            char c = jewels.charAt(i);
            if(c<='Z'){
                sum+=chars[c-'A'];
            }else{
                sum+=chars[c-'a' + 26];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbb"));
        System.out.println(numJewelsInStones("z","ZZ"));
        System.out.println(numJewelsInStones("EXoODCGRiT","DrQZz"));
    }
}
