package com.ljy.day11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Demo {
    public static void main(String[] args){
        Date date = new Date();
        System.out.println(date);
        //long型号的时间
        long time= System.currentTimeMillis();
        System.out.println(time);
        System.out.println("=======================");
        new Demo().dateFormat();
        simpleDateFormat();
        calendar();
        System.out.println("=======================");
        getRandom();
    }


    /**
     * 日期格式化工具类
     */
    private void dateFormat(){
        DateFormat instance = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);
        String format = instance.format(new Date());
        System.out.println(format);

    }

    private static void simpleDateFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        String format = sdf.format(new Date());
        System.out.println(format);
    }

    private static void calendar(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int week = calendar.get(Calendar.DAY_OF_WEEK);//星期几 默认从1开始算,取1-7之间的值 1代表星期天
        System.out.println(year+"-"+(month+1)+"-"+day+"-"+week);
    }

    public static void getRandom(){
        Random r = new Random();
        /*for (int i = 0;i<100;i++) {
            System.out.println(r.nextInt(100));
        }*/

        //-100 -- 100之间
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt()%100);

        }
    }

    public static boolean checkPhone(String phone){
        if (phone==null || phone.length()!=11)return false;
        try {
            Long.valueOf(phone);
            char secChar = phone.charAt(1);
            return phone.startsWith("1")&&(secChar=='3'||secChar=='5'||secChar=='7'||secChar=='8');
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

}
