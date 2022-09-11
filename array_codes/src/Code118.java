import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Code118
 * @Author lihuasong
 * @Description
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *  
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 * @Date 2021/12/28 22:20
 * @Version V1.0
 **/
public class Code118 {
    public static List<List<Integer>> generate(int numRows) {
        if(numRows==1){
            ArrayList<List<Integer>> lists = new ArrayList<>();
            lists.add(Collections.singletonList(1));
            return lists;
        }else if(numRows == 2){
            ArrayList<List<Integer>> lists = new ArrayList<>();
            lists.add(Collections.singletonList(1));
            lists.add(Arrays.asList(1,1));
            return lists;
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(1));
        lists.add(Arrays.asList(1,1));

        for (int i=2;i<numRows;i++){
            List<Integer> data = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if (j==0 || j==i){
                    data.add(1);
                }else{
                    data.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                }
            }
            lists.add(data);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(generate(8));
    }
}
