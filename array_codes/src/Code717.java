/**
 * 描述：
 *
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 *
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * 示例 2:
 *
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 *
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 *
 * 思考：
 * 遇到0的时候肯定是向后移动一位，
 * 遇到1 的时候肯定是向后移动两位，
 * 这样就可以看出，如果最后一位是0的时候到达末尾就是正解，
 * 否则最后一位或者倒数第二位是1的话，i就会大于或者等于数组的长度
 *
 */
public class Code717 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,1,1,0,1};
        System.out.println(isOneBitCharacter(nums));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length;) {
            if (bits[i]==0){
                i++;
                if(i==bits.length){
                    return true;
                }
            }else{
                i=i+2;
                if(i>=bits.length) {
                    return false;
                }
            }
        }
        return false;
    }

}
