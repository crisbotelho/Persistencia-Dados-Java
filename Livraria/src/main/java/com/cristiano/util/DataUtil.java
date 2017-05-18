package com.cristiano.util;

import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	public static Date createDate(int ano, int mes, int dia){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.MONTH, mes);
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		
		return calendar.getTime();
	}
}
