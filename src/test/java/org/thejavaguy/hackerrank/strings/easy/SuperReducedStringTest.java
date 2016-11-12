package org.thejavaguy.hackerrank.strings.easy;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuperReducedStringTest {
    private static final String EMPTY_MARKER = "Empty String";
    private SuperReducedString sut;

    @Before
    public void setUp() throws Exception {
        sut = new SuperReducedString();
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    public void reduce_WhenEmptyString_ReturnsEmptyMarker() {
        assertEquals(EMPTY_MARKER, sut.reduce(""));
    }

    @Test
    public void reduce_WhenHasOnlyOneLetter_ReturnsSame() {
        assertEquals("a", sut.reduce("a"));
    }

    @Test
    public void reduce_WhenHasOnlyTwoSameLetters_ReturnsEmptyMarker() {
        assertEquals(EMPTY_MARKER, sut.reduce("aa"));
    }

    @Test
    public void reduce_WhenHasSameLettersAtTheEnd_ReducesSameLetters() {
        assertEquals("a", sut.reduce("abb"));
    }

    @Test
    public void reduce_WhenHasSameLettersAtTheBeginning_ReducesSameLetters() {
        assertEquals("b", sut.reduce("aab"));
    }

    @Test
    public void reduce_WhenNothignToReduce_ReturnsOriginString() {
        assertEquals("abc", sut.reduce("abc"));
    }
}
