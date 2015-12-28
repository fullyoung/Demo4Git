package myUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class dateUtil {
	/**
	 * @author fy
	 * @return String
	 * @param ����Ҫ���ʽ�������ڣ����û�����������򷵻ؽ�������
	 * */
	public static String getDate(Date date,String s){
		if(s=null){
			return "��ʽ����ȷ";
		}
		SimpleDateFormat sdf =new SimpleDateFormat(s);
		String resDate=null;
		if(date=null){
			Date todayD =new Date();
			resDate=sdf.format(todayD);

		}else{
			resDate=sdf.format(date);
		}
		return resDate;
	}

	/**
	 * @author fy
	 * @return String
	 * @param ���������������ڷ������ڲ�
	 * */
	public static String getDateApart(Date date1,Date date2){
		String dateApart=null;
		long date1Number=date1.getTime();
		long date2Number=date2.getTime();
		int apart=(int) ((date2Number-date1Number)/1000/60/60/24);
		dateApart=String.valueOf(apart) ;
		return dateApart;
	}
	/**
	 * @author fy
	 * @return Date
	 * @param ����s��������,s�ĸ�ʽΪ"yyyy-MM-dd HH:mm:ss"
	 * */
	public static Date getDay(String s) throws ParseException{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =sdf.parse(s);
		return date;
	}
}
