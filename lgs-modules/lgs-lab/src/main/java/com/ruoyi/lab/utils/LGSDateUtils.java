package com.ruoyi.lab.utils;

import com.ruoyi.lab.domain.LgsOperationSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils * @Description TODO
 * @Author lgn
 * @Date 10:04 2022/8/21
 * @Version 1.0
 **/
public class LGSDateUtils {

    /**
     * 每隔x天
     * @param support
     * @return
     */
    public static boolean x_date(LgsOperationSupport support){
        boolean flag=false;

        try {
            int redate=support.getDateInterval()-support.getReminderDate();//例：每7天执行一次，提前三天通知。7-3=4 就是每4天执行一次

            //时间日期格式化 java8格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            System.out.println("now:"+now);

            String format = support.getCompletionTime().format(formatter);//LocalDateTime转string
            LocalDate startDate = LocalDate.parse(format,formatter);
            System.out.println("相差天数:" + startDate.until(now, ChronoUnit.DAYS));

            Long ldate=startDate.until(now, ChronoUnit.DAYS);//相差天数
            if ((ldate.intValue()%redate)==0){//符合条件 相差的天数是周期的倍数（比如相差49天，每7天执行一次）
                //例如：资产的“设备放行时间”是1月5日，规则是【每隔5天】，那么1月11日、1月16日、1月21日……就是此任务的
                // 【任务截止日期】。任务的【任务开始日期】由字段”提醒时间“来决定。
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 每个月的当天
     * @param support
     * @return
     */
    public static boolean each_month(LgsOperationSupport support){
        boolean flag=false;

        try {
            //LocalDateTime转Date
            Date date = Date.from( support.getCompletionTime().atZone( ZoneId.systemDefault()).toInstant());
            String str=getBefore_n_Day(date,support.getReminderDate());//提前提醒

            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date reminderDate =sdf.parse(str);//提前n天
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(reminderDate);

            int n_date=calendar.get(Calendar.DATE);//每月的第n天

            Calendar calendar_now = Calendar.getInstance();
            calendar_now.setTime(new Date());

            int now_date=calendar_now.get(Calendar.DATE);//今天
            System.out.println("n_date:"+n_date+"   now_date:"+now_date);

            if (n_date==now_date){//今天 等于 每月的第n天
                flag=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * x_month
     * @param support
     * @return
     */
    public static boolean x_month(LgsOperationSupport support){
        boolean flag=false;

        try {
            Date date = Date.from( support.getCompletionTime().atZone( ZoneId.systemDefault()).toInstant());
            String text1=getBefore_n_Day(date,support.getReminderDate());//根据完成日期 计算提前提醒日期

            //String text1 = "2020-08-02";
            Temporal temporal1 = LocalDate.parse(text1);

            Date myDate = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String text2 = sdf1.format(myDate);//当前日期

            //String text2 = "2020-09-01";
            Temporal temporal2 = LocalDate.parse(text2);
            // 方法返回为相差月份
            Long l = ChronoUnit.MONTHS.between(temporal1, temporal2);
            System.out.println("方法返回为相差月份:"+l.intValue());

            if ((l.intValue()%support.getDateInterval())==0){//符合条件 相差的月数是周期的倍数（比如相差12个月，每6个月执行一次）
                //例如：资产的“设备放行时间”是1月5日，规则是【每隔3月】，那么4月5日、7月5日、10月5日……就是此任务的【任务截止日期】。
                // 任务的【任务开始日期】由字段”提醒时间“来决定。

                Date reminderDate =sdf1.parse(text1);//提前n天

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(reminderDate);
                int reminder_date=calendar.get(Calendar.DATE);//周期中的第n天

                Calendar calendar_now = Calendar.getInstance();
                calendar_now.setTime(myDate);
                int now_date=calendar_now.get(Calendar.DATE);//今天

                System.out.println("reminder_date:"+reminder_date +"  now_date:"+now_date);

                if (reminder_date==now_date){
                    flag=true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return flag;
    }

    /**
     * 一年
     * 每一年的今天
     * @param support
     * @return
     */
    public static boolean a_year(LgsOperationSupport support){
        boolean flag=false;
        try {
            //LocalDateTime转Date
            Date date = Date.from( support.getCompletionTime().atZone( ZoneId.systemDefault()).toInstant());
            String str=getBefore_n_Day(date,support.getReminderDate());//提前提醒

            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date123 =sdf.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date123);

            LocalDate date1 = LocalDate.now();
            System.out.println("date1->LocalDate.now():"+LocalDate.now());
            //LocalDate date2 = LocalDate.of(2021,8,21);
            LocalDate date2 = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DATE));
            System.out.println("date2->提前n天的系统完成日期:"+date2);

            MonthDay birthday = MonthDay.of(date2.getMonth(),date2.getDayOfMonth());
            MonthDay currentMonthDay = MonthDay.from(date1);
            if(currentMonthDay.equals(birthday)){
                System.out.println("是你的生日");
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 获取当前系统时间的前 N 天时间
     * @param currentdate
     * @return Date
     * @version: 1.0
     * @return
     */
    public static String getBefore_n_Day(Date currentdate,int n) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentdate);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        currentdate = calendar.getTime();
        String dayTime=format.format(currentdate);
        return dayTime;
    }

    /**
     * 获取当前月第n天：
     * @param dt
     * @return
     */
    public static Date getMonth_n_Day(Date dt,int n) {
        //获取当前月第一天：
        Calendar ca = Calendar.getInstance();
        ca.setTime(dt);
        // ca.add(Calendar.MONTH, 0); 此方法可以获取前n月或后n月
        ca.set(Calendar.DAY_OF_MONTH,n);//设置为1号,当前日期既为本月第一天
        ca.set(Calendar.HOUR, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    /**
     * 日期差值
     * @return
     */
    public static void getDiffer() {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        System.out.println("now:"+now);
        LocalDate startDate = LocalDate.parse("2021-05-26",formatter1);

        System.out.println("相差天数:" + startDate.until(now, ChronoUnit.DAYS));
        System.out.println("相差月数:" + startDate.until(now, ChronoUnit.MONTHS));
        System.out.println("相差年数:" + startDate.until(now, ChronoUnit.YEARS));
    }

    public static void main(String[] args) throws ParseException {
        // String 转换为 LocalDateTime
        String dateStr = "2022-01-21";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        date = formatter.parse(dateStr);

        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        //System.out.println(getBefore_n_Day(new Date(),4));
        LgsOperationSupport support=new LgsOperationSupport();
        support.setCompletionTime(localDateTime);
        support.setReminderDate(3);
        support.setDateInterval(7);


        //System.out.println(x_date(support));
        //System.out.println(each_month(support));
        System.out.println(x_month(support));
        //System.out.println(a_year(support));



    }
}
