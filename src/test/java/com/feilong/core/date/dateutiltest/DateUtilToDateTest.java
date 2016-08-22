/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.date.dateutiltest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.feilong.core.date.DateUtil.toDate;

import static com.feilong.core.DatePattern.COMMON_DATE;
import static com.feilong.core.DatePattern.COMMON_DATE_AND_TIME_WITHOUT_SECOND;
import static com.feilong.core.DatePattern.TIMESTAMP_WITH_MILLISECOND;

/**
 * The Class DateUtilToDateTest.
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 */
public class DateUtilToDateTest{

    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtilToDateTest.class);

    /**
     * Test string2 date.
     */
    @Test
    public void testToDate(){

        LOGGER.debug("" + toDate("2016-06-28T01:21:12-0800", "yyyy-MM-dd'T'HH:mm:ssZ"));
        LOGGER.debug("" + toDate("2016-06-28T01:21:12+0800", "yyyy-MM-dd'T'HH:mm:ssZ"));

        LOGGER.debug("" + toDate("2016-02-33", COMMON_DATE));

        // 商品上线时间
        LOGGER.debug("" + toDate("20130102140806000", TIMESTAMP_WITH_MILLISECOND));
    }

    @Test(expected = NullPointerException.class)
    public void testToDateNull(){
        toDate(null, COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToDateEmpty(){
        toDate("", COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToDateEmpty1(){
        toDate(" ", COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    //*****************************************************************

    @Test(expected = NullPointerException.class)
    public void testToDateNullPattern(){
        toDate("2016-06-30 15:36", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToDateEmptyPatterns(){
        toDate("2016-06-30 15:36");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToDateNullPatternElement(){
        toDate("2016-06-30 15:36", (String) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToDate1(){
        toDate("2016-06-30 15:36 ", COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    @Test
    public void testToDate2(){
        toDate(StringUtils.trimToEmpty("2016-06-30 15:36 "), COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }
}