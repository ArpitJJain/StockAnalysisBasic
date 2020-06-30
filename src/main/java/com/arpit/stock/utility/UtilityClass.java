package com.arpit.stock.utility;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public interface UtilityClass {

    int PROCESSING_DATE_OFFSET = 0;

    SimpleDateFormat INPUT_FILE_FORMAT = new SimpleDateFormat("dd_MM_YYYY");
    String TOP_DAY_FILE_SUFFIX = INPUT_FILE_FORMAT.format(getCalendarDate(PROCESSING_DATE_OFFSET));

    SimpleDateFormat OUTPUT_DATA_FORMAT = new SimpleDateFormat("YYYYMMdd");
    String TOP_DAY_DATE = OUTPUT_DATA_FORMAT.format(getCalendarDate(PROCESSING_DATE_OFFSET));

    static String getStringValue(Object o){
        if (null == o || o.toString().isEmpty() || o.toString().isBlank()){
            return "";
        }else{
            return o.toString().trim();
        }
    }

    static Date getCalendarDate(int offsetInDate){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,offsetInDate);
        return cal.getTime();
    }
}
