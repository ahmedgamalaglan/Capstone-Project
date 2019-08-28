package com.ahmed.gamal.matchatak.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateUtilTest {

    @Test
    public void testSeasonNum() {
        String res = DateUtil.seasonNum("2019-3-1", "2020-8-9");
        assertEquals("2019/2020", res);
    }

}