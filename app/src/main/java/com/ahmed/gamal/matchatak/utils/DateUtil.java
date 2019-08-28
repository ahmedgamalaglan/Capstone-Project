package com.ahmed.gamal.matchatak.utils;

public class DateUtil {

    public static String seasonNum(String startDate, String endDate) {
        return startDate.subSequence(0, 4).toString() + "/" + endDate.subSequence(0, 4).toString();
    }
}
