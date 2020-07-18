package arithmetic;

/**
 * 斐波拉契
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * 解题思路
 * 0:0
 * 1:1
 * 2:1
 * 3:2
 * 4:3
 * 5:5
 * <p>
 * f(0)=0
 * f(1)=1
 * f(n)=f(n-1)+f(n-2) n>=2
 *
 * @author pengwei
 * @date 2020/7/18
 */
public class Fibonacci {

    public static void main(String[] args) {
        long timeMillis = System.currentTimeMillis();
         int n = testRecursion(38);
//
        //1137
        //39088169
        int n2 = testOptimize(38);
        System.out.println("时间：" + (System.currentTimeMillis() - timeMillis));
        System.out.println(n+"==="+n2);

    }

    /**
     * 递归
     *
     * @param number
     * @return
     */
    public static int testRecursion(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else if (1 < number && number <= 39) {
            return testRecursion(number - 1) + testRecursion(number - 2);
        } else {
            return 0;
        }
    }

    public static int testOptimize(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int temp = 0;
        if (n > 1 && n <= 39) {
            for (int i = 2; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
        }

        return temp;

    }

}
