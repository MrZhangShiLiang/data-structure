package com.zsl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zsl
 * @date 2019/10/30
 * 日期工具类
 * 使用要求：JDK 8以上
 */
public class DateUtil {

    //使用方式
    public static void main(String[] args) throws Exception {
        // 节假日
//        String holidays = "2019/01/01,2019/01/04,2019/01/05,2019/01/06,2019/01/07,2019/01/08,2019/01/09,2019/01/10,2019/04/05,2019/04/06,2019/04/07,2019/05/01,2019/06/07,2019/06/08,2019/06/09,2019/09/13,2019/09/14,2019/09/15,2019/10/01,2019/10/02,2019/10/03,2019/10/04,2019/10/05,2019/10/06,2019/10/07";
        String holidays = "";
        // 设置工作日
        int num = 3;
        // 当前时间
        //String today = sdfs.format(new Date("2020/01/12 00:00:00"));
        String today = "2019/11/02 01:00:00";
        //String today = DateTool.getCurDateTime();
        System.out.println("当前,日期为==============" + today);
        // num个工作日前
        String workDayStart = getWorkDayStart(holidays,today , num);
        System.out.println(num + "个工作日前,日期为========" + workDayStart);
        // num个工作日后
        String workDayEnd = getWorkDayEnd(holidays, today, num);
        System.out.println(num + "个工作日后,日期为========" + workDayEnd);
        System.out.println(workDayEnd.substring(0, 10));
        System.out.println(workDayStart.substring(0, 10));
    }

    /** 时间格式 yyyy/MM/dd HH:mm:ss*/
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";

    /** 时间格式 yyyy/MM/dd*/
    public static String YYYY_MM_DD = "yyyy/MM/dd";

    /** 格式化*/
    public static SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);

    /** 格式化*/
    public static SimpleDateFormat sdfs = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);

    /** 日历对象*/
    private static Calendar CALENDAR;

    /**
     * 获取当前时间距月底还有几天
     * @return
     */
    public static Integer getCurDaysEndOfMonth(){
         Calendar calendar = Calendar.getInstance();
         return calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定时间距离月底还有几天
     * @param date
     * @return
     */
    public static Integer getAssignDaysEndOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);

    }

    /**
     * 获取指定日期最大日数，参数为null时，返回当前时间最大日数，即月末号数
     * @param date
     * @return
     */
    public static Integer getAssignMonthEndDay(Date date){
        Calendar temp = Calendar.getInstance();
        if (null!=date){
            temp.setTime(date);
        }
        return temp.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期最小日数，参数为null时，返回当前时间最小日数，即月初号数
     * @param date
     * @return
     */
    public static Integer getAssignMonthStartDay(Date date){
        Calendar temp = Calendar.getInstance();
        if (null!=date){
            temp.setTime(date);
        }
        return temp.getActualMinimum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Date getCurDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 将Date类型转为字符串格式
     * @param date 传入的时间
     * @param dateFormatStr 格式化的字符串 可为null
     * @return String 的时间串，dateFormatStr为null时返回时间格式为yyyy/MM/dd HH:mm:ss
     */
    public static String parseDate2String(Date date,String dateFormatStr){
        String temp = YYYY_MM_DD_HH_MM_SS;
        if (null!=dateFormatStr && dateFormatStr.length()>0){
            temp = dateFormatStr;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(temp);
        return simpleDateFormat.format(date);
    }

    /**
     * 将时间字符串转Date类型
     * @param dateStr 时间字符串,传入的格式要和第二个参数类型保持一致
     * @param dateStrFormat 格式化串，传null则使用默认yyyy/MM/dd HH:mm:ss
     * @return Date类型对象
     */
    public static Date parseString2Date(String dateStr,String dateStrFormat){
        String strTemp = YYYY_MM_DD_HH_MM_SS;
        if (null != dateStrFormat && dateStrFormat.length() > 0){
            strTemp = dateStrFormat;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strTemp);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     *
     * @param calendar 日历对象
     * @return 指定日期的年数，calendar为null时，返回当前时间的年份份
     */
    public static Integer getAssignYear(Calendar calendar){
        CALENDAR = null == calendar ? Calendar.getInstance() : calendar;
        return CALENDAR.get(Calendar.YEAR);
    }

    /**
     *
     * @param calendar 日历对象
     * @return 指定时间的月份,calendar为null时，返回当前时间的月份
     */
    public static Integer getAssignMonth(Calendar calendar){
        CALENDAR = null == calendar ? Calendar.getInstance() : calendar;
        return CALENDAR.get(Calendar.MONTH) + 1;
    }

    /**
     *
     * @param calendar 日历对象
     * @return 指定时间的几号,calendar为null时，返回当前时间的几号数
     */
    public static Integer getAssignDayOfMonth(Calendar calendar){
        CALENDAR = null == calendar ? Calendar.getInstance() : calendar;
        return CALENDAR.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前时间之前n个工作日的日期
     *
     * @param holidays 节假日（日期格式：2019/01/01,2019/01/04,2019/01/05,......）
     * @param today    当前日期（日期格式：2019/01/01 08:08:08）
     * @param num      需要设置的n个工作日
     * @return
     * @throws Exception
     */
    public static String getWorkDayStart(String holidays, String today, int num) throws Exception {
        // 转化为数组
        String[] dayArr = holidays.split(",");
        List<String> holidayList = new ArrayList<String>(Arrays.asList(dayArr));
        // 将字符串转换成日期
        Date date = sdfs.parse(today);

        // 获取工作日
        Date workDay = getWorkDay(holidayList, num, date, -1);
        String workDayStr = sdf.format(workDay);
        long workTime = getTime(today, workDayStr) - 1000;    // 减1秒

        return sdfs.format(new Date(workTime));
    }

    /**
     * 获取当前时间之后n个工作日的日期
     *
     * @param holidays 节假日（日期格式：2019/01/01,2019/01/04,2019/01/05,......）
     * @param today    当前日期（日期格式：2019/01/01 08:08:08）
     * @param num      需要设置的n个工作日
     * @return
     * @throws Exception
     */
    public static String getWorkDayEnd(String holidays, String today, int num) throws Exception {
        // 转化为数组
        String[] dayArr = holidays.split(",");
        List<String> holidayList = new ArrayList<String>(Arrays.asList(dayArr));

        // 将字符串转换成日期
        Date date = sdfs.parse(today);

        // 获取工作日
        Date workDay = getWorkDay(holidayList, num, date, 1);
        String workDayStr = sdf.format(workDay);
        long workTime = getTime(today, workDayStr) + 1000;    // 加1秒

        return sdfs.format(new Date(workTime));

    }

    /**
     * 获取工作日
     *
     * @param holidayList 节假日（日期格式：2019/01/01,2019/01/04,2019/01/05,......）
     * @param num         需要设置的n个工作日
     * @param day         目标日期
     * @return
     * @throws Exception
     */
    public static Date getWorkDay(List<String> holidayList, int num, Date day, int n) throws Exception {
        int delay = 1;
        while (delay <= num) {
            // 获取前一天或后一天日期
            Date endDay = getDate(day, n);
            String time = sdf.format(endDay);

            //当前日期+1即tomorrow,判断是否是节假日,同时要判断是否是周末,都不是则将scheduleActiveDate日期+1,直到循环num次即可
            if (!isWeekend(time) && !isHoliday(time, holidayList)) {
                delay++;
            } else if (isWeekend(time)) {
                System.out.println(time + "::是周末");
            } else if (isHoliday(time, holidayList)) {
                System.out.println(time + "::是节假日");
            }
            day = endDay;
        }
        return day;
    }

    /**
     * yyyy/MM/dd HH:mm:ss格式日期---获取时间戳精确到秒
     *
     * @param start 开始日期（日期格式：2019/01/01 08:08:08）
     * @param end   结束日期（日期格式：2019/01/01 08:08:08）
     * @return
     * @throws Exception
     */
    public static long getTime(String start, String end) throws Exception {
        if (StringUtil.isEmpty(start) || StringUtil.isEmpty(end)) {
            throw new RuntimeException("today is empty");
        }

        long time1 = sdfs.parse(start).getTime();
        long time2 = sdf.parse(start).getTime();
        long time3 = sdf.parse(end).getTime();

        long time = time3 + (time1 - time2);

        return time;
    }

    /**
     * 获取前一天或后一天日期
     *
     * @param date 日期
     * @param n    判断参数
     * @return
     */
    public static Date getDate(Date date, int n) {
        if (n > 0) {    // 获取前一天
            date = getTomorrow(date);
        }
        if (n < 0) {    // 获取后一天
            date = getYesterday(date);
        }
        return date;
    }

    /**
     * 获取后一天的日期
     *
     * @param date
     * @return
     */
    public static Date getTomorrow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取前一天的日期
     *
     * @param date
     * @return
     */
    public static Date getYesterday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 判断是否是周末
     *
     * @param sdate
     * @return
     * @throws Exception
     */
    public static boolean isWeekend(String sdate) throws Exception {
        Date date = sdf.parse(sdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 判断是否是节假日
     *
     * @param sdate
     * @param list
     * @return
     * @throws Exception
     */
    public static boolean isHoliday(String sdate, List<String> list) throws Exception {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (sdate.equals(list.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
