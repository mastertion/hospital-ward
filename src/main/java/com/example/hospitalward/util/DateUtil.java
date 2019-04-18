package com.example.hospitalward.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName:  DateUtil   
 * @Description:TODO描述：   日期转化工具类
 * @author: 李正旭
 * @date:   2018年10月6日 上午9:26:51
 */
public class DateUtil {
		/**
		 * 
		 * @Description:TODO描述： 时间转字符串  
		 * @author: 李正旭
		 * @date:   2018年10月6日 上午9:27:10    
		 * @param date
		 * @return
		 */
	    public static String  dateToString (Date date) {
	       
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      return sdf.format(date);
	        
	    }
	    /**
	     * 
	     * @Description:TODO描述：   字符串转时间
	     * @author: 李正旭
	     * @date:   2018年10月6日 上午9:27:31    
	     * @param string
	     * @return
	     */
	    public static Date stringToDate (String string) {
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		      try {
				return sdf.parse(string);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

	    }
	    
}
