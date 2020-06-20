package com.FFFANS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
public static Date convertStringToDate(String dateString,String format) {
	SimpleDateFormat formatter=new SimpleDateFormat(format);
	Date date=null;
	try {
		System.out.println("Date String: "+dateString);
		date=formatter.parse(dateString);
		System.out.println(date);
		System.out.println(date.getTime() );
	}
	catch(ParseException e){
		e.printStackTrace();
	}
		return date;
	}

public static String convertStringToString(Date d) {
	String newstring="";
	
		newstring = new SimpleDateFormat("yyyy-MM-dd").format(d);
		System.out.println(d);
		System.out.println(newstring);
 return newstring;
 }

public static Date convertdate(String d) throws ParseException {
	SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date d1=sd.parse(d);
	java.sql.Date sqd=new java.sql.Date(d1.getTime());
	System.out.println(sqd);
	return sqd;
}


}

