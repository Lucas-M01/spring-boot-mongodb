package com.lucasmont.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.text.ParseException;

public class URL {
    
    public static String decodeParam(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Date convertDate(String s, Date defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(s);
        }
        catch (ParseException e) {
            return defaultValue;
        }
    }
}
