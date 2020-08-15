package com.wx.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtil {
	public final static int MIN_TIME = 1325347200;
	public final static String HOUR_MINTE_SECOND_INIT = " 00:00:00";

	/**
	 *
	 * @return
	 */
	public static long getCurrentInMillis()
	{
		return System.currentTimeMillis();
	}

	/**
	 *
	 * @return
	 */
	public static int getCurrentInSecond()
	{
		return (int) (getCurrentInMillis() / 1000);
	}

	/**
	 * 获取当天零点的时间戳
	 * @return
	 */
	public static int getCurrentDateStamp(){
		int t=(int )(getCurrentInMillis() / 1000);
		String strDate=stampToDate(t,"yyyy-MM-dd");
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(strDate);

			return (int) (date.getTime()/1000);
		} catch (ParseException e) {
			return 0;
		}

	}

	/**
	 *
	 * @param t
	 * @param format
	 * @return
	 */
	public static String formatTime(long t, String format){
		Date dt = new Date(t);
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(dt);
	}

	/**
	 *
	 * @param format
	 * @return
	 */
	public static String formatCurrentTimeString(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(Calendar.getInstance(Locale.CHINA).getTime());
	}

	/**
	 *
	 * @return
	 */
	public static int getMinutesOfDay() {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		return calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);
	}
	/**
	 * @return
	 */
	public static int getSecondOfDay() {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		return calendar.get(Calendar.HOUR_OF_DAY) * 3600 + calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.SECOND);
	}
	/**
	 /**
	 * 获取本月第一天的时间戳
	 * @return
	 */
	public static int getCurrentMonthInSecond(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}
	public static int getDayOfCurrentMonth(){
		String days=stampToDate(getCurrentInSecond(),"dd");
		return Integer.valueOf(days);
	}
	public static int getMaxDayOfLastMonth(){
		String days=stampToDate(getLastMonthMaxDay(),"dd");
		return Integer.valueOf(days);
	}
	public static int getLastMonthMaxDay(){
		Calendar calendar=Calendar.getInstance();

		int month=calendar.get(Calendar.MONTH);

		calendar.set(Calendar.MONTH, month-1);

		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return (int) (calendar.getTimeInMillis() / 1000);
	}
	public static int getLastMonthOfDay(int days){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, days);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}
	public static int getLast2MonthOfDay(int days){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.MONTH, -2);
		c.set(Calendar.DAY_OF_MONTH, days);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}
	public static int getCurrentMonthOfDay(int days){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(Calendar.DAY_OF_MONTH, days);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}

	 /**
	 * 获取最近一个月第一天的时间戳
	 * @return
	 */
	public static int getLastMonthInSecond(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.MONTH, -1);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}

	 /**
	 * 获取本年第一天的时间戳
	 * @return
	 */
	public static int getCurrentYearInSecond(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取最近12个月第一天的时间戳
	 * @return
	 */
	public static int getLastYearInSecond(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.MONTH, -11);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取一年之前的时间戳
	 * @return
	 */
	public static int getOneYearBeforeInSecond(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.MONTH, -11);
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取本季度第一天的时间戳
	 * @return
	 */
	public static int getCurrentQuarterInSecond(){
		Calendar c = Calendar.getInstance(Locale.CHINA);

		int currentMonth = c.get(Calendar.MONTH) + 1;
		if (currentMonth >= 1 && currentMonth <= 3){
			c.set(Calendar.MONTH, 0);
		}else if(currentMonth >= 4 && currentMonth <= 6){
			c.set(Calendar.MONTH, 3);
		}else if(currentMonth >= 7 && currentMonth <= 9){
			c.set(Calendar.MONTH, 6);
		}else if(currentMonth >= 10 && currentMonth <= 12){
			c.set(Calendar.MONTH, 9);
		}

		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取最近一个季度第一天的时间戳
	 * @return
	 */
	public static int getLastQuarterInSecond(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.MONTH, -2);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取本周第一天的时间戳
	 * @return
	 */
	public static int getCurrentWeekInSecond() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		return (int) (c.getTimeInMillis() / 1000);
	}

	/**
	 * 获取最近一周第一天的时间戳
	 * @return
	 */
	public static int getLastWeekInSecond() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.add(Calendar.DAY_OF_MONTH, -6);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date date = c.getTime();
		return (int) (c.getTimeInMillis() / 1000);
	}


	/**
	 * 获取指定天"MM-dd"的总秒数
	 * @param dayString
	 * @return
	 */
	public static int getDayTotalSeconds(String dayString){
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		int total = 86400;
		try {
			Calendar c = Calendar.getInstance(Locale.CHINA);
			int year = c.get(Calendar.YEAR);
			int currentMonth = c.get(Calendar.MONTH);
			int currentDay = c.get(Calendar.DAY_OF_MONTH);

			Date date = format.parse(year + "-" + dayString);
			c.setTime(date);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			c.add(Calendar.DAY_OF_MONTH, 1);
			long endTime = c.getTimeInMillis()/1000;

			//如果是当天，结束时间为当前时间
			if(month == currentMonth && day == currentDay){
				endTime = new Date().getTime()/1000;
			}
			total = (int) (endTime - date.getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
			return total;
		}
		return total;
	}

	/**
	 * 获取指定月份"yyyy-MM"的总秒数
	 * @param monthString
	 * @return
	 */
	public static int getMonthTotalSeconds(String monthString){
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
		int total = 2592000;
		try {
			Date date = format.parse(monthString);
			Calendar c = Calendar.getInstance(Locale.CHINA);
			int currentYear = c.get(Calendar.YEAR);
			int currentMonth = c.get(Calendar.MONTH);

			c.setTime(date);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			c.add(Calendar.MONTH, 1);
			long endTime = c.getTimeInMillis()/1000;

			//如果是当月，结束时间为当前时间
			if(year == currentYear && month == currentMonth){
				endTime = new Date().getTime()/1000;
			}
			total = (int) (endTime - date.getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
			return total;
		}
		return total;
	}

	/**
	 * 获取指定年份"yyyy"的总秒数
	 * @param yearString
	 * @return
	 */
	public static int getYearTotalSeconds(String yearString){
		SimpleDateFormat format =  new SimpleDateFormat("yyyy");
		int total = 31536000;
		try {
			Date date = format.parse(yearString);
			Calendar c = Calendar.getInstance(Locale.CHINA);
			int currentYear = c.get(Calendar.YEAR);

			c.setTime(date);
			int year = c.get(Calendar.YEAR);
			c.add(Calendar.YEAR, 1);
			long endTime = c.getTimeInMillis()/1000;

			//如果是当年，结束时间为当前时间
			if(year == currentYear){
				endTime = new Date().getTime()/1000;
			}
			total = (int) (endTime - date.getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
			return total;
		}
		return total;
	}


	/**
	 * 将年月日时分秒转换为时间戳
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static int getCurrentInSecondByStringTime(String time) throws ParseException{
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse(time);

		return (int) (date.getTime()/1000);

	}
	/*
     * 将时间戳转换为日期时间
     */
	public static String stampToDate(int t){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		res = simpleDateFormat.format(new Date(Long.valueOf(t+"000")));

		return res;
	}
	/*
     * 将时间戳转换为日期时间
     */
	public static String stampToDate(int t,String dateformat){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);
		res = simpleDateFormat.format(new Date(Long.valueOf(t+"000")));

		return res;
	}
	/*
     * 将时间戳转换为日期时间
     */
	public static String stampToTime(int t){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		res = simpleDateFormat.format(new Date(Long.valueOf(t+"000")));

		return res;
	}
	public static int ymdToStamp(int y,int m,int d){
		String time=String.format("%04d-%02d-%02d", y,m,d);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(time);

			return (int) (date.getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int ymdTimeToStamp(int ymdTime){
		int d = ymdTime & 0xFF;
		int m =(ymdTime >> 8) & 0xFF;
		int y = (ymdTime >> 16) & 0xFF ;
		y += 1980;
		String time=String.format("%04d-%02d-%02d", y,m,d);
//		System.out.println(time);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(time);

			return (int) (date.getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int ymdStamp(){
		LocalDate localDate = LocalDate.now();
		String time=String.format("%04d-%02d-%02d", localDate.getYear(),localDate.getMonth().getValue(),localDate.getDayOfMonth());
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(time);

			return (int) (date.getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 时间戳转为YYYYmmddHHmmss格式，传小于等于0的默认取当前时间戳
	 * @param t
	 * @return
	 */
	public static String stampToYmdhis(int t){
		if (t < 1){
			t = (int) (System.currentTimeMillis() / 1000);
		}
		String res = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		try {
			res = simpleDateFormat.format(new Date(t * 1000L));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 时间戳转为YYYYmmdd格式，传小于等于0的默认取当前时间戳
	 * @param t
	 * @return
	 */
	public static String stampToYmd(int t){
		if (t < 1){
			t = (int) (System.currentTimeMillis() / 1000);
		}
		String res = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		try {
			res = simpleDateFormat.format(new Date(t * 1000L));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	//获取当前时间与凌晨0点的秒数
	public static int getCurrentSeconds(){
		int t1= getCurrentInSecond();
		int t2= getCurrentDateStamp();
		return t1-t2;
	}


	/**
	 * 时间戳转为YYYY-mm-dd格式，传小于等于0的默认取当前时间戳
	 * @param t
	 * @return
	 */
	public static String stampToYmdFormat(int t){
		if (t < 1){
			t = (int) (System.currentTimeMillis() / 1000);
		}
		String res = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		try {
			res = simpleDateFormat.format(new Date(t * 1000L));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 获取指定零点的时间戳
	 * @return
	 */
	public static Long getSpecTimestamp(int year, int month, int day){
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.set(year, month, day);
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date=sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime()/1000;
	}

	/**
	 * 验证 年-月-日 时间格式是否合法
	 * @param timeStr
	 * @return
	 */
	public static boolean valiDateTime(String timeStr) {
		String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(timeStr);
		if (matcher.matches()) {
			pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
			matcher = pattern.matcher(timeStr);
			if (matcher.matches()) {
				int y = Integer.valueOf(matcher.group(1));
				int m = Integer.valueOf(matcher.group(2));
				int d = Integer.valueOf(matcher.group(3));
				if (d > 28) {
					Calendar c = Calendar.getInstance();
					c.set(y, m-1, 1);
					int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
					return (lastDay >= d);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * 计算最近interval个月的时间戳
	 * @param interval
	 * @return
	 */
	public static long getStampByInterval(int interval){
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.add(Calendar.MONTH, -interval);
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(sdf.format(date));
		}catch (ParseException e){
			e.printStackTrace();
		}
		return date.getTime()/1000;
	}

	public static int getHourByTimeStamp(int timeStamp){
		long ms = 1000;
		String date = timeStampToDate(timeStamp*ms);
		String hour = date.substring(11, 13);
		return Integer.parseInt(hour);
	}

	private static String timeStampToDate(long timeStamp){
		Date  date = new Date(timeStamp);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = simpleDateFormat.format(date);
		return dateStr;
	}

	/**
	 * yyyy-MM-dd转化为时间戳
	 * @param ymdFormat
	 * @return
	 */
	public static int getStampFromYmdFormat(String ymdFormat){

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		int time = getCurrentInSecond();
		try {
			time = (int) (simpleDateFormat.parse(ymdFormat).getTime()/1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	public static void main(String[] args) {
//		int t1= TimeUtil.getCurrentInSecond();
//		System.out.println("t1:"+t1);
//		int t2= TimeUtil.getCurrentDateStamp();
//
//		System.out.println("t2:"+t2);
//		int t3=t1-t2;
//		System.out.println("t3:"+t3);
		int t4=getMaxDayOfLastMonth();
		System.out.println("t4:"+t4);
//		int t5 = getLastMonthOfDay(t4);
//		System.out.println(stampToDate(t5));
//		int t6 = getCurrentMonthOfDay(t4);
//		System.out.println(stampToDate(t6));

	}
}
