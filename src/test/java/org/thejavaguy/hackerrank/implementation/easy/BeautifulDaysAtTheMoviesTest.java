package org.thejavaguy.hackerrank.implementation.easy;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeautifulDaysAtTheMoviesTest {
    private BeautifulDaysAtTheMovies sut;

    @Before
    public void setUp() throws Exception {
        sut = new BeautifulDaysAtTheMovies();
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    public void reverse_WhenSingleDigit_IsEqualToSelf() {
        for (int i = 1; i <= 9; ++i) {
            assertEquals(i, sut.reversed(i));
        }
    }

    @Test
    public void reverse_WhenEndingWithZero_LeadingZerosAreRemovedFromResult() {
        assertEquals(1, sut.reversed(10));
        assertEquals(2, sut.reversed(20));
        assertEquals(2, sut.reversed(200));
        assertEquals(2, sut.reversed(2000));
    }

    @Test
    public void reverse_WhenZeroIsInside_ReversesWholeNumber() {
        assertEquals(10101, sut.reversed(10101));
        assertEquals(102, sut.reversed(201));
    }

    @Test
    public void isBeautiful() {
        assertTrue(sut.isBeautiful(20, 6));
        assertFalse(sut.isBeautiful(21, 6));
        assertTrue(sut.isBeautiful(22, 6));
        assertFalse(sut.isBeautiful(23, 6));
    }
}
