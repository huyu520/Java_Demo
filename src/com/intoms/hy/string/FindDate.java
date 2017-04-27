package com.intoms.hy.string;

import java.text.SimpleDateFormat;
import java.util.*;


public class FindDate {
	
    public static void main(String[] args) throws Exception {  
        String start = "2017-12-25 00:00:00";  
        String end = "2019-01-02 23:59:59";  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date dBegin = sdf.parse(start);  
        Date dEnd = sdf.parse(end);  
        List<Date> listDate = new ArrayList<>(getDatesBetweenTwoDate(dBegin, dEnd));  
        for(int i=0;i<listDate.size();i++){  
            System.out.println(sdf.format(listDate.get(i)));  
        }  
    }  
  
    /** 
     * 根据开始时间和结束时间返回时间段内的时间集合 
     *  
     * @param beginDate 
     * @param endDate 
     * @return List 
     */  
    public static Set<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {  
        Set<Date> lDate = new HashSet<Date>();  
        lDate.add(beginDate);// 把开始时间加入集合  
//        lDate.
        Calendar cal = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间  
        cal.setTime(beginDate);  
        boolean bContinue = true;  
        while (bContinue) {  
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
            cal.add(Calendar.DAY_OF_MONTH, 1);  
            // 测试此日期是否在指定日期之后  
            if (endDate.after(cal.getTime())) {  
                lDate.add(cal.getTime());  
            } else {  
                break;  
            }  
        }  
        lDate.add(endDate);// 把结束时间加入集合  
        return lDate;  
    }  
}
