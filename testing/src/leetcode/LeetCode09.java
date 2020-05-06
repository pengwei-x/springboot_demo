package leetcode;

import org.apache.logging.log4j.util.StringBuilders;

/**
 * @author pengwei
 * @date 2020/4/29
 */
public class LeetCode09 {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder stringBuilder=new StringBuilder(s);
        String reverse = stringBuilder.reverse().toString();
        if (s.equals(reverse)){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

    }
}
