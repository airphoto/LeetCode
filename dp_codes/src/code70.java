/**
 * @ClassName code70
 * @Author lihuasong
 * @Description
 * @Date 2021-11-06 12:41
 * @Version V1.0
 **/

public class code70 {
    public static int climbStairs(int n) {

        if(n==1) return 1;
        if(n==2) return 2;

        int t1=1,t2=2,r=3;

        for(int i=2;i<n;i++){
            r=t1+t2;
            t1=t2;
            t2=r;
        }

        return r;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
