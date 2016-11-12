package org.thejavaguy.hackerrank.warmup;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.thejavaguy.hackerrank.warmup.TimeConversion;

public class TimeConversionTest {
    private TimeConversion sut;
    
    @Before
    public void setUp() throws Exception {
        sut = new TimeConversion();
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    public void ampmToMilitary_WhenMidnight_ReturnsProperTime() {
        assertEquals("00:00:00", sut.ampmToMilitary("12:00:00AM"));
    }
    
    @Test
    public void ampmToMilitary_WhenNoon_ReturnsProperTime() {
        assertEquals("12:00:00", sut.ampmToMilitary("12:00:00PM"));
    }
    
    @Test
    public void ampmToMilitary_When7AM_ReturnsProperTime() {
        assertEquals("07:00:00", sut.ampmToMilitary("07:00:00AM"));
    }
    
    @Test
    public void ampmToMilitary_When7PM_ReturnsProperTime() {
        assertEquals("19:05:45", sut.ampmToMilitary("07:05:45PM"));
    }
}
