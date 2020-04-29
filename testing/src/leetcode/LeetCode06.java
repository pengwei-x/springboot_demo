package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * @author pengwei
 * @date 2020/4/24
 */
public class LeetCode06 {


    public String convert(String s, int numRows) {

        if (s == null || s.isEmpty() || numRows == 1) {
            return s;
        }

        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }
        int symbol = 1;
        int index = 0;
        for (char c : s.toCharArray()) {
            array[index].append(c);
            index += symbol;
            if (index == 0 || index == numRows - 1) {
                symbol = -symbol;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(array[i]);
        }

        return stringBuilder.toString();
    }

    public String convert2(String s, int numRows) {

        if (s.isEmpty() || numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int symbol = 1;
        int index = 0;
        for (char c : s.toCharArray()) {
            list.get(index).append(c);
            index += symbol;
            if (index == 0 || index == numRows - 1) {
                symbol = -symbol;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder ss : list) {
            stringBuilder.append(ss);

        }

        return stringBuilder.toString();
    }

    public String convert3(String s, int numRows) {

        if (s.isEmpty() || numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();

    }

    public static void main(String[] args) {

        String leetcodeishiring = new LeetCode06().convert3("LEETCODEISHIRING", 3);
        System.out.println(leetcodeishiring);
    }

}
