package com.ruoyi.common.core.utils;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
/**
 * @ClassName TimeAPIUtils * @Description TODO
 * @Author lgn
 * @Date 18:02 2022/8/19
 * @Version 1.0
 **/
public class TimeAPIUtils {

    /**
     * 获取当前时间的时间戳(10位:不带毫秒)
     */
    public static Long getTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        return now.toEpochSecond(OffsetDateTime.now().getOffset());
    }

    /**
     * 获取当前时间的时间戳(13位:带毫秒)
     */
    public static Long getTimeStampWithMs() {
        LocalDateTime now = LocalDateTime.now();
        return now.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli();
    }

    /**
     * Long --> String
     */
    public static String long2String(Long time, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * String --> Long
     */
    public static Long string2Long(String time, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime parse = LocalDateTime.parse(time, dtf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取本月第一天
     */
    public static LocalDate firstDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取本月第N天
     */
    public static LocalDate dayOfThisMonth(int n) {
        LocalDate today = LocalDate.now();
        return today.withDayOfMonth(n);
    }

    /**
     * 获取本月最后一天
     */
    public static LocalDate lastDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取指定月的最后一天
     * @param month 1-12
     */
    public static LocalDate lastDayOfMonth(int year,int month) {
        LocalDate ofDate = LocalDate.of(year, month, 1);
        return ofDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取本月第一天的开始时间
     */
    public static String startOfThisMonth(String pattern) {
        LocalDateTime ofDateTime = LocalDateTime.of(firstDayOfThisMonth(), LocalTime.MIN);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return ofDateTime.format(dtf);
    }

    /**
     * 取本月最后一天的结束时间
     */
    public static String endOfThisMonth(String pattern) {
        LocalDateTime ofDateTime = LocalDateTime.of(lastDayOfThisMonth(), LocalTime.MAX);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return ofDateTime.format(dtf);
    }

    /**
     * 获取两个日期相差的月数
     */
    public static int getMonthDiff() {
        String text1 = "2020-06-02";
        Temporal temporal1 = LocalDate.parse(text1);
        String text2 = "2020-09-30";
        Temporal temporal2 = LocalDate.parse(text2);
        // 方法返回为相差月份
        Long l = ChronoUnit.MONTHS.between(temporal1, temporal2);
        System.out.println(l);

        return l.intValue();
    }

    /**
     *获取总的相差间隔
     */
    public static void endOfThisMonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        System.out.println("now:"+now);
        LocalDate startDate = LocalDate.parse("2021-05-26",formatter);

        System.out.println("相差天数:" + startDate.until(now, ChronoUnit.DAYS));
        System.out.println("相差月数:" + startDate.until(now, ChronoUnit.MONTHS));
        System.out.println("相差年数:" + startDate.until(now, ChronoUnit.YEARS));
    }

    public static void main(String[] args) {
        System.out.println(firstDayOfThisMonth());
        System.out.println(dayOfThisMonth(7));
        System.out.println(lastDayOfThisMonth());
        System.out.println(lastDayOfMonth(2020, 2));
        System.out.println(startOfThisMonth("yyyy-MM-dd HH:mm:ss"));
        System.out.println(endOfThisMonth("yyyy-MM-dd HH:mm:ss"));

        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println(today+"-------"+time);

        System.out.println("相差几个月："+getMonthDiff());
        System.out.println("差值："+49%49);
    }
}
