package leetcode;

import sun.rmi.runtime.Log;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 * @author pengwei
 * @date 2020/4/25
 */
public class LeetCode07 {

    public static int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        if (x % 10 == 0) {
            x = x / 10;
        }
        int tag = 1;
        if (x < 0) {
            tag = -tag;
            x = -x;
        }
        String s = Integer.toString(x);
        StringBuilder stringBuilder = new StringBuilder(s);
        String reverse = stringBuilder.reverse().toString();
        long num = Long.parseLong(reverse);
        if (tag == -1) {
            num = -num;
        }

        return (int) num == num ? (int) num : 0;
    }

    /**
     * 第一种方式不太好
     * @param x
     * @return
     */
    public static int reverse2(int x){


       int temp=0;
       while (x!=0){
           int num=x%10+temp*10;
           if ((num-num%10)/10!=temp){
               return 0;
           }
           temp=num;
           x=x/10;
       }

       return temp;

    }

    public static void main(String[] args) {


        int reverse = reverse2(Integer.MAX_VALUE);
        System.out.println(reverse);
    }

}
