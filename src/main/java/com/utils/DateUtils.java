package com.utils;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;

public class DateUtils {
    public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    public static String getDate() {
	FieldPosition f = new FieldPosition(2);
	SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMAT);
	StringBuffer sb = new StringBuffer();
	StringBuffer sb2 = new StringBuffer();
	sb = sd.format(new java.util.Date(), sb2, f);
	return sb.toString();
    }

    public static java.util.Date textToDate(String inDate, String toTemplate) {
	try {
	    if (toTemplate == null) {
		toTemplate = DATE_FORMAT;
	    }
	    SimpleDateFormat formatter = new SimpleDateFormat(toTemplate);
	    return formatter.parse(inDate);
	} catch (Exception e) {
	    return null;
	}
    }

    public static java.util.Date textToDate(String inDate) {
	return textToDate(inDate, null);
    }

    public static int compareDate(String fromDate, String toDate) {
	int i = textToDate(fromDate, DATE_FORMAT).compareTo(
		textToDate(toDate, DATE_FORMAT));
	return i;
    }

    public static boolean isFuture(String Date) {
	int i = textToDate(Date, DATE_FORMAT).compareTo(
		textToDate(getDate(), DATE_FORMAT));
	return i > 0;
    }

    public static String formatDate(String date) {
	if (date == null) {
	    return null;
	}
	FieldPosition f = new FieldPosition(2);
	SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMAT);
	StringBuffer sb = new StringBuffer();
	StringBuffer sb2 = new StringBuffer();
	sb = sd.format(textToDate(date), sb2, f);
	return sb.toString();
    }
}
