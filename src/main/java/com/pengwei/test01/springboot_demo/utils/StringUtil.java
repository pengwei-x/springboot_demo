package com.pengwei.test01.springboot_demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * @author pengwei
 */
public final class StringUtil {

    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    private static final String regEx = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
    private static final Pattern SYMBOL_PATTERN = Pattern.compile(regEx);

    /**
     * 判断是否是空字符串 null和"" 都返回 true
     *
     * @param str 判断的字符串
     * @return 是否有效
     */
    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str) || "null".equals(str.toLowerCase());
    }


    /**
     * 字符串转换为Ascii
     *
     * @param value
     * @return
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * Ascii转换为字符串
     *
     * @param value
     * @return
     */
    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            // returns original String when possible
            return str;
        }
        return padding(pads, padChar).concat(str);
    }

    private static String padding(int repeat, char padChar)
            throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException(
                    "Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }

    /**
     * 把string array or list用给定的符号symbol连接成一个字符串
     * StringJoiner( delimiter,prefix,suffix)可传分隔符及前缀和后缀进行拼接
     *
     * @param list   需要处理的列表
     * @param symbol 链接的符号
     * @return 处理后的字符串
     */
    public static String joinString(List list, String symbol) {
        return joinString(list, symbol, null);
    }

    /**
     * 把string array or list用给定的符号symbol连接成一个字符串
     * StringJoiner( delimiter,prefix,suffix)可传分隔符及前缀和后缀进行拼接
     *
     * @param list        需要处理的列表
     * @param splitSymbol 分割的符号
     * @param wrapSymbol  包裹元素的符号 可以为空
     * @return 处理后的字符串
     */
    public static String joinString(List list, String splitSymbol, String wrapSymbol) {
        if (list != null) {
            StringJoiner stringJoiner = new StringJoiner(splitSymbol);
            for (Object o : list) {
                if (null != o) {
                    String temp = o.toString();
                    if (temp.trim().length() > 0) {
                        if (isNullOrEmpty(wrapSymbol)) {
                            stringJoiner.add(temp);
                        } else {
                            stringJoiner.add(wrapSymbol + temp + wrapSymbol);
                        }
                    }
                }
            }
            return stringJoiner.toString();
        }
        return "";
    }

    /**
     * 把string array or list用给定的符号symbol连接成一个字符串
     * StringJoiner( delimiter,prefix,suffix)可传分隔符及前缀和后缀进行拼接
     *
     * @param list   需要处理的列表
     * @param symbol 链接的符号
     * @return 处理后的字符串
     */
    public static String joinString(Object[] list, String symbol, String wrapSymbol) {
        if (list != null) {
            StringJoiner stringJoiner = new StringJoiner(symbol);
            for (Object o : list) {
                if (null != o) {
                    String temp = o.toString();
                    if (temp.trim().length() > 0) {
                        if (isNullOrEmpty(wrapSymbol)) {
                            stringJoiner.add(temp);
                        } else {
                            stringJoiner.add(wrapSymbol + temp + wrapSymbol);
                        }
                    }
                }
            }
            return stringJoiner.toString();
        }
        return "";
    }

    public static String joinString(Object[] list, String symbol) {
        if (list != null) {
            StringJoiner stringJoiner = new StringJoiner(symbol);
            for (Object o : list) {
                if (null != o) {
                    String temp = o.toString();
                    if (temp.trim().length() > 0) {
                        stringJoiner.add(temp);
                    }
                }
            }
            return stringJoiner.toString();
        }
        return "";
    }

    /**
     * 判定第一个字符串是否等于的第二个字符串中的某一个值
     *
     * @param str1 测试的字符串
     * @param str2 字符串数组(用,分割)
     * @return 是否包含
     */
    public static boolean requals(String str1, String str2) {
        if (str1 != null && str2 != null) {
            str2 = str2.replaceAll("\\s*", "");
            String[] arr = str2.split(",");
            for (String t : arr) {
                if (t.equals(str1.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判定第一个字符串是否等于的第二个字符串中的某一个值
     *
     * @param str1  测试的字符串
     * @param str2  字符串数组
     * @param split str2字符串的分隔符
     * @return 是否包含
     */
    public static boolean requals(String str1, String str2, String split) {
        if (str1 != null && str2 != null) {
            str2 = str2.replaceAll("\\s*", "");
            String[] arr = str2.split(split);
            for (String t : arr) {
                if (t.equals(str1.trim())) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 字符串省略截取
     * 字符串截取到指定长度size+...的形式
     *
     * @param subject 需要处理的字符串
     * @param size    截取的长度
     * @return 处理后的字符串
     */
    public static String subStringOmit(String subject, int size) {
        if (subject != null && subject.length() > size) {
            subject = subject.substring(0, size) + "...";
        }
        return subject;
    }


    /**
     * 截取字符串　超出的字符用symbol代替
     *
     * @param str    需要处理的字符串
     * @param len    字符串长度
     * @param symbol 最后拼接的字符串
     * @return 测试后的字符串
     */
    public static String subStringSymbol(String str, int len, String symbol) {
        String temp = "";
        if (str != null && str.length() > len) {
            temp = str.substring(0, len) + symbol;
        }
        return temp;
    }


    /**
     * 隐藏邮件地址前缀。
     *
     * @param email - EMail邮箱地址 例如: ssss@koubei.com 等等...
     * @return 返回已隐藏前缀邮件地址, 如 *********@koubei.com.
     */
    public static String getHideEmailPrefix(String email) {
        if (null != email) {
            int index = email.lastIndexOf('@');
            if (index > 0) {
                email = repeat("*", index).concat(email.substring(index));
            }
        }
        return email;
    }

    /**
     * repeat - 通过源字符串重复生成N次组成新的字符串。
     *
     * @param src - 源字符串 例如: 空格(" "), 星号("*"), "浙江" 等等...
     * @param num - 重复生成次数
     * @return 返回已生成的重复字符串
     */
    public static String repeat(String src, int num) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num; i++) {
            s.append(src);
        }
        return s.toString();
    }

    /**
     * 截取字符串左侧的Num位截取到末尾
     *
     * @param str1 处理的字符串
     * @param num  开始位置
     * @return 截取后的字符串
     */
    public static String ltrim(String str1, int num) {
        String tt = "";
        if (!isEmpty(str1) && str1.length() >= num) {
            tt = str1.substring(num, str1.length());
        }
        return tt;

    }

    /**
     * 截取字符串右侧第0位到第Num位
     *
     * @param str 处理的字符串
     * @param num 截取的位置
     * @return 截取后的字符串
     */
    public static String rtrim(String str, int num) {
        if (!isEmpty(str) && str.length() > num) {
            str = str.substring(0, str.length() - num);
        }
        return str;
    }

    /**
     * 根据指定的字符把源字符串分割成一个list
     *
     * @param src     处理的字符串
     * @param pattern 分割字符串
     * @return 处理后的list
     */
    public static List<String> parseString2List(String src, String pattern) {
        List<String> list = new ArrayList<>();
        if (src != null) {
            String[] tt = src.split(pattern);
            list.addAll(Arrays.asList(tt));
        }
        return list;
    }

    /**
     * 将字符串分割为特定的字符List
     *
     * @param params 字符串
     * @param clazz  转化的类型，支持Integer，Double，Long，Float
     * @param <T>
     * @return
     */
    public static <T> List<T> parseString2List(String params, Class<T> clazz) {
        if (StringUtil.isNullOrEmpty(params)) {
            return Collections.EMPTY_LIST;
        }
        List col = new ArrayList<>();
        for (String id : parseString2List(params, ",")) {
            if (clazz.getName().equalsIgnoreCase(Long.class.getName())) {
                col.add(Long.parseLong(id));
            }
            if (clazz.getName().equalsIgnoreCase(Integer.class.getName())) {
                col.add(Integer.parseInt(id));
            }
            if (clazz.getName().equalsIgnoreCase(Double.class.getName())) {
                col.add(Double.parseDouble(id));
            }
            if (clazz.getName().equalsIgnoreCase(Float.class.getName())) {
                col.add(Float.parseFloat(id));
            }
        }
        return col;
    }

    /**
     * 格式化一个float
     *
     * @param format 要格式化成的格式 such as #.00, #.#
     * @return 格式化后的字符串
     */
    public static String formatDouble(double f, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(f);
    }


    /**
     * 截取字符串左侧指定长度的字符串
     *
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串
     */
    public static String left(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(0, count);
    }

    /**
     * 截取字符串右侧指定长度的字符串
     *
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串
     * Summary 其他编码的有待测试
     */
    public static String right(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(input.length() - count, input.length());
    }


    /**
     * 页面中去除字符串中的空格、全角空格 、回车、换行符、制表符
     *
     * @param str 需要处理的字符串
     */
    public static String replaceBlank(String str) {
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            str = m.replaceAll("");

            try {
                //全角空格
                byte bytes[] = {(byte) 0xC2, (byte) 0xA0};
                String UTFSpace = new String(bytes, "utf-8");
                str = str.replaceAll(UTFSpace, "");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }


    /**
     * 字符串转换unicode.实现native2ascii.exe类似的功能
     *
     * @param string 需要处理的字符串
     */
    public static String string2Unicode(String string) {
        StringBuilder uni = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            String temp = "\\u" + String.valueOf(Integer.toHexString(string.charAt(i)));
            uni.append(temp);
        }
        return uni.toString();
    }

    /**
     * 转字符串 实现native2ascii.exe类似的功能
     *
     * @param unicode 需要处理的字符串
     */
    public static String unicode2String(String unicode) {
        StringBuilder str = new StringBuilder();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            str.append((char) data);
        }
        return str.toString();
    }

    /**
     * 获取字符串str在String中出现的次数
     *
     * @param string 处理的字符串
     * @param str    子字符串
     */
    public static int countSubStr(String string, String str) {
        if ((str == null) || (str.length() == 0) || (string == null) || (string.length() == 0)) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = string.indexOf(str, index)) != -1) {
            count++;
            index += str.length();
        }
        return count;
    }


    /**
     * 替换一个出现的子串
     *
     * @param s    source string
     * @param sub  substring to replace
     * @param with substring to replace with
     */
    public static String replaceFirst(String s, String sub, String with) {
        int i = s.indexOf(sub);
        if (i == -1) {
            return s;
        }
        return s.substring(0, i) + with + s.substring(i + sub.length());
    }


    /**
     * 替换最后一次出现的字串
     * Replaces the very last occurrence of a substring with supplied string.
     *
     * @param s    source string
     * @param sub  substring to replace
     * @param with substring to replace with
     */
    public static String replaceLast(String s, String sub, String with) {
        int i = s.lastIndexOf(sub);
        if (i == -1) {
            return s;
        }
        return s.substring(0, i) + with + s.substring(i + sub.length());
    }

    /**
     * 替换特殊字符
     *
     * @param source
     * @return
     */
    public static String replaceSpecialSymbols(String source) {
        Matcher m = SYMBOL_PATTERN.matcher(source);
        return m.replaceAll("").trim();
    }

    /**
     * 删除所有的子串
     * Removes all substring occurrences from the string.
     *
     * @param s   source string
     * @param sub substring to remove
     */
    public static String remove(String s, String sub) {
        int c = 0;
        int sublen = sub.length();
        if (sublen == 0) {
            return s;
        }
        int i = s.indexOf(sub, c);
        if (i == -1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        do {
            sb.append(s.substring(c, i));
            c = i + sublen;
        } while ((i = s.indexOf(sub, c)) != -1);
        if (c < s.length()) {
            sb.append(s.substring(c, s.length()));
        }
        return sb.toString();
    }

    /**
     * 将字符串首字母转大写
     *
     * @param str 需要处理的字符串
     */
    public static String upperFirstChar(String str) {
        if (isEmpty(str)) {
            return "";
        }
        char[] cs = str.toCharArray();
        if ((cs[0] >= 'a') && (cs[0] <= 'z')) {
            cs[0] -= (char) 0x20;
        }
        return String.valueOf(cs);
    }

    /**
     * 将字符串首字母转小写
     *
     * @param str
     * @return
     */
    public static String lowerFirstChar(String str) {
        if (isEmpty(str)) {
            return "";
        }
        char[] cs = str.toCharArray();
        if ((cs[0] >= 'A') && (cs[0] <= 'Z')) {
            cs[0] += (char) 0x20;
        }
        return String.valueOf(cs);
    }

    /**
     * 判读俩个字符串右侧的length个字符串是否一样
     *
     * @param str1
     * @param str2
     * @param length
     * @return
     */
    public static boolean rigthEquals(String str1, String str2, int length) {
        return right(str1, length).equals(right(str2, length));
    }

    /**
     * 判读俩个字符串左侧的length个字符串是否一样
     *
     * @param str1
     * @param str2
     * @param length
     * @return
     */
    public static boolean leftEquals(String str1, String str2, int length) {
        return left(str1, length).equals(left(str2, length));
    }

    /**
     * 返回一个字客符串
     *
     * @param o
     * @return
     */
    public static String g(Object o) {
        if (null == o || "NULL".equals(o.toString().toUpperCase())) {
            return "";
        } else {
            return o.toString().trim();
        }
    }

    public static boolean isNumeric(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static final boolean isShort(String value) {
        if (isEmpty(value)) {
            return false;
        }
        try {
            Short.parseShort(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static final boolean isInt(String value) {
        if (isEmpty(value)) {
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static final boolean isLong(String value) {
        if (isEmpty(value)) {
            return false;
        }
        try {
            Long.parseLong(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static final boolean isDouble(String value) {
        if (isEmpty(value)) {
            return false;
        }
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static final boolean isSame(String value1, String value2) {
        if ((isEmpty(value1)) && (isEmpty(value2))) {
            return true;
        }
        if ((!isEmpty(value1)) && (!isEmpty(value2))) {
            return value1.trim().equals(value2.trim());
        }
        return false;
    }

    /**
     * 去掉字符串前面的0
     * 例：0001230-->1230
     *
     * @param value
     * @return
     */
    public static String deleteHeadZero(String value) {
        return value.replaceAll("^(0+)", "");
    }

    /**
     * 指定长度字符串左边补0
     * 10 -> 010
     *
     * @param str
     * @param strLength
     * @return
     */
    public static String addZeroForNumStr(String str, int strLength) {
        int strLen = str.length();
        StringBuffer sb;
        while (strLen < strLength) {
            sb = new StringBuffer();
            sb.append("0").append(str);
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }

    /**
     * 指定长度字符串右边补0
     * 10 -> 100
     *
     * @param str
     * @param strLength
     * @return
     */
    public static String addZeroForNumEnd(String str, int strLength) {
        int strLen = str.length();
        StringBuffer sb;
        while (strLen < strLength) {
            sb = new StringBuffer();
            sb.append(str).append("0");
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }

    /**
     * 删除字符串中，开头的N个字符
     *
     * @param source      源串
     * @param replacement 要被删掉的字符串
     * @return
     */
    public static String removeStartChar(String source, String replacement) {
        // null或者空字符串的时候不处理
        if (source == null || source.length() == 0 || replacement == null || replacement.length() == 0) {
            return source;
        }
        // 要删除的字符串结束位置
        int end;
        // 正规表达式
        String regPattern = "[" + replacement + "]*+";
        Pattern pattern = Pattern.compile(regPattern, Pattern.CASE_INSENSITIVE);
        // 去掉原始字符串开头位置的指定字符
        Matcher matcher = pattern.matcher(source);
        if (matcher.lookingAt()) {
            end = matcher.end();
            source = source.substring(end);
        }
        // 返回处理后的字符串
        return source;
    }

    public static void main(String[] argc) {
        boolean result = isNumeric("");
        logger.info("result is:" + result);

        result = isNumeric(null);
        logger.info("result is:" + result);

        result = isNumeric("1234");
        logger.info("result is:" + result);

        result = isNumeric("123a");
        logger.info("result is:" + result);
    }

}
