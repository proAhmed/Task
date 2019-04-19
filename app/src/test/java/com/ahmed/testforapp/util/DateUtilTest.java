package com.ahmed.testforapp.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateUtilTest {

    @Test
    public void convertDateWrongFormat() {
        assertEquals(DateUtil.convertDate("25/8/2018"),"25/8/2018");
    }
    @Test
    public void convertDate() {
        assertEquals(DateUtil.convertDate("2018-08-23"),"23-Aug-2018");
    }
}