package com.goldmsg.logTool.utils;

import com.goldmsg.levam.base.tools.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Goldmsg
 */
public class DateUtil extends DateUtils {

    /**获取两个日期之间的日期*/
    private static List<String> getBetweenDates(Date startDate, Date endDate,String dateFmt) {
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(startDate);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(endDate);
        tempEnd.add(Calendar.DAY_OF_YEAR, 1);

        result.add(DateUtils.fromDateWithLocale(startDate, dateFmt));
        while (tempStart.before(tempEnd)) {
            result.add(DateUtils.fromDateWithLocale(tempStart.getTime(), dateFmt));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }

        return result;
    }

    /**
     * 将秒数转换为日时分秒，
     *
     * @param second
     * @return
     */
    public static String secondToTime(long second) {
        //转换天数
        long days = second / 86400;
        //剩余秒数
        second = second % 86400;
        //转换小时
        long hours = second / 3600;
        //剩余秒数
        second = second % 3600;
        //转换分钟
        long minutes = second / 60;
        //剩余秒数
        second = second % 60;
        if (days > 0) {
            return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
        } else {
            return hours + "小时" + minutes + "分" + second + "秒";
        }
    }
    //获取有效起止
    public static String getYxqz(String scsj, int storeDays) {
        String result=scsj;
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date=dateFormat.parse(scsj);
            Long time=date.getTime();
            Long day= 24L*3600L*1000L;
            Long newTime=time+storeDays*day;
            Date yxqz=new Date(newTime);
            result=dateFormat.format(yxqz);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static Date parseDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            return sdf.parse(date);
        } catch (Exception var4) {
            return null;
        }
    }

    public static  List<String> getBetweenDates(String startDate, String endDate,String dateFmt) {
        return getBetweenDates(parseDate(startDate, dateFmt), parseDate(endDate, dateFmt),dateFmt);
    }
}
