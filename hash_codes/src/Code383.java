import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Code383
 * @Author lihuasong
 * @Description
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，
 * 判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *  
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * @Date 2021-11-15 20:10
 * @Version V1.0
 **/

public class Code383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> ransomMap = new HashMap<>();
        Map<Character,Integer> magaMap = new HashMap<>();

        for(int i=0;i<ransomNote.length();i++){
            ransomMap.put(ransomNote.charAt(i),ransomMap.getOrDefault(ransomNote.charAt(i),0)+1);
        }

        for(int i=0;i<magazine.length();i++){
            magaMap.put(magazine.charAt(i),magaMap.getOrDefault(magazine.charAt(i),0)+1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : ransomMap.entrySet()) {
            if(characterIntegerEntry.getValue()>magaMap.getOrDefault(characterIntegerEntry.getKey(),0)){
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character,Integer> magaMap = new HashMap<>();

        for(int i=0;i<magazine.length();i++){
            magaMap.put(magazine.charAt(i),magaMap.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(!magaMap.containsKey(c)||magaMap.get(c)==0){
                return false;
            }

            magaMap.put(c,magaMap.get(c)-1);

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct2("a","b"));
        System.out.println(canConstruct2("ab","bb"));
        System.out.println(canConstruct2("aa","aab"));
    }
}
