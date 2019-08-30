package com.ahmed.gamal.matchatak.utils;

public class DateUtil {

    public static String seasonNum( String endDate) {
        return endDate.subSequence(0, 4).toString();
    }
}
