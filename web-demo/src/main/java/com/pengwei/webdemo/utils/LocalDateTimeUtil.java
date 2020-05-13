package com.pengwei.webdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * JDK1.8  LocalDateTime
 * LocalDateTime 是个线程安全的类
 *
 * @author pengwei
 * @date 2020/5/13
 */
public class LocalDateTimeUtil {

    /**
     * 日期时间类型格式
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期时间类型格式
     */
    public static final String DATETIME_FORMAT_SIMPALE = "yy-MM-dd HH:mm:ss";

    /**
     * 日期类型格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 日期类型格式 年月
     */
    public static final String DATE_FORMAT_YYMM = "yyMM";

    /**
     * 时间类型的格式
     */
    public static final String TIME_FORMAT = "HH:mm:ss.SSS";

    public static final String TIME_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String TIME_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 日期时间类型格式，yyyy/MM/dd HH:mm:ss
     */
    public static final String DATETIME_FORMAT_SLASH = "yyyy/MM/dd HH:mm:ss";


    /**
     * 将Date类型转化为指定格式字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String getStringByDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    /**
     * 将指定格式的字符串转化为Date
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date getDateByString(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将Date类型转化为指定格式字符串
     *
     * @param format
     * @return
     */
    public static String getCurrentDate(String format) {
        return getStringByDate(new Date(), format);
    }


    /**
     * 将Date转化为LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime getLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


    /**
     * 比较两个Date的时间大小
     *
     * @param date
     * @param date2
     * @return
     */
    public static boolean getLocalDateTime(Date date, Date date2) {
        if (date.compareTo(date2) == 1) {
            return true;
        }
        return false;
    }


    /**
     * 比较两个Date的时间大小
     *
     * @param localDateTime
     * @return
     */
    public static Date getDataByLocalDateTime(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 将指定格式String类型日期转化为LocalDateTime
     *
     * @param format
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getLocalDateTimeByString(String format, String localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(localDateTime, df);
    }


    /**
     * 获取指定LocalDateTime的秒数
     *
     * @param localDateTime
     * @return
     */
    public static Long getSecondByLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }


    /**
     * 获取指定LocalDateTime的毫秒数
     *
     * @param localDateTime
     * @return
     */
    public static Long getMillSecondByLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    /**
     * 将LocalDateTime转化为指定格式字符串
     *
     * @param localDateTime
     * @param format
     * @return
     */
    public static String getStringByLocalDateTime(LocalDateTime localDateTime, String format) {
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }


    /**
     * 将LocalDateTime转化为默认yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @param localDateTime
     * @return
     */
    public static String getDefaultStringByLocalDateTime(LocalDateTime localDateTime) {
        return getStringByLocalDateTime(localDateTime, DATETIME_FORMAT);
    }

    /**
     * 将LocalDateTime转化为yy-MM-dd HH:mm:ss格式字符串
     *
     * @param localDateTime
     * @return
     */
    public static String getYYYYMMDDHHMMByLocalDateTime(LocalDateTime localDateTime) {
        return getStringByLocalDateTime(localDateTime, DATETIME_FORMAT_SIMPALE);
    }

    /**
     * 将LocalDateTime转化为yy-mm-dd 格式字符串
     *
     * @param localDateTime
     * @return
     */
    public static String getYYYYMMDDByLocalDateTime(LocalDateTime localDateTime) {
        return getStringByLocalDateTime(localDateTime, DATE_FORMAT);
    }

    /**
     * 获取当前LocalDateTime并转化为指定格式字符串
     *
     * @param format
     * @return
     */
    public static String getCurrentLocalDateTime(String format) {
        return getStringByLocalDateTime(LocalDateTime.now(), format);
    }


    /**
     * 获取一天的开始时间
     *
     * @param localDateTime
     * @return
     */
    public static String getStartTime(LocalDateTime localDateTime) {
        return getDefaultStringByLocalDateTime(localDateTime.with(LocalTime.MIN));
    }

    /**
     * 获取当天的开始时间
     *
     * @return
     */
    public static String getStartTime() {
        return getDefaultStringByLocalDateTime(LocalDateTime.now());
    }


    /**
     * 获取一天的结束时间 23:59:59
     *
     * @param localDateTime
     * @return
     */
    public static String getEndTime(LocalDateTime localDateTime) {
        return getDefaultStringByLocalDateTime(localDateTime.with(LocalTime.MAX));
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getEndTime() {
        return getDefaultStringByLocalDateTime(LocalDateTime.now());
    }

    /**
     * 计算两个指定格式String日期字符串的时间差(精确到毫秒)
     *
     * @param localDateTime1
     * @param localDateTime2
     * @return
     */
    public static boolean getCompareLocalDateTime(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        if (localDateTime1.isBefore(localDateTime2)) {
            return true;
        }
        return false;
    }

    /**
     * 计算两个指定格式String日期字符串的时间差(精确到毫秒)
     *
     * @param format
     * @param time1
     * @param time2
     * @return
     */
    public static Long getCompareSecondLocalDateTime(String format, String time1, String time2) {
        System.out.println("接收到的参数为:" + format + "," + time1 + "," + time2);
        LocalDateTime localDateTime1 = getLocalDateTimeByString(format, time1);
        LocalDateTime localDateTime2 = getLocalDateTimeByString(format, time2);
        if (getMillSecondByLocalDateTime(localDateTime1) > getMillSecondByLocalDateTime(localDateTime2)) {
            return getMillSecondByLocalDateTime(localDateTime1) - getMillSecondByLocalDateTime(localDateTime2);
        }
        return getMillSecondByLocalDateTime(localDateTime2) - getMillSecondByLocalDateTime(localDateTime1);
    }

    /**
     * 获取两个LocalDateTime的天数差
     *
     * @param localDateTime1
     * @param localDateTime2
     * @return
     */
    public static Long getCompareDayLocalDateTime(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        if (getCompareLocalDateTime(localDateTime1, localDateTime2)) {
            Duration duration = Duration.between(localDateTime1, localDateTime2);
            return duration.toDays();
        } else {
            Duration duration = Duration.between(localDateTime2, localDateTime1);
            return duration.toDays();
        }
    }

    /**
     * 获取两个LocalDateTime的小时差
     *
     * @param localDateTime1
     * @param localDateTime2
     * @return
     */
    public static Long getCompareYearLocalDateTime(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        if (getCompareLocalDateTime(localDateTime1, localDateTime2)) {
            Duration duration = Duration.between(localDateTime1, localDateTime2);
            return duration.toHours();
        } else {
            Duration duration = Duration.between(localDateTime2, localDateTime1);
            return duration.toHours();
        }
    }

    public static void main(String[] args) {
        String endTime = getStartTime();
        System.out.println(endTime);
    }
}
