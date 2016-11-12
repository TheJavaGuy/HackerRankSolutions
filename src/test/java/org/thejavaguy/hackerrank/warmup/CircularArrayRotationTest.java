package org.thejavaguy.hackerrank.warmup;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.thejavaguy.hackerrank.warmup.CircularArrayRotation;

public class CircularArrayRotationTest {
    private CircularArrayRotation sut;
    
    @Before
    public void setUp() throws Exception {
        sut = new CircularArrayRotation();
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    public void rotateRightCircular_WhenHas1Element_StaysSame() {
        int[] arrorig = new int[]{1};
        int[] arr = new int[]{1};
        sut.rotateRightCircular(arr);
        assertArrayEquals(arrorig, arr);
    }
    
    @Test
    public void rotateRightCircular_WhenHas3Elements_IsRotatedProperly() {
        int[] expected = new int[]{3,1,2};
        int[] arr = new int[]{1,2,3};
        sut.rotateRightCircular(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    public void rotateRightCircular_WhenHas3ElementsAnd2Rotations_IsRotatedProperly() {
        int[] expected = new int[]{2,3,1};
        int[] arr = new int[]{1,2,3};
        sut.rotateRightCircular(arr);
        sut.rotateRightCircular(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    public void rotateRightCircularWithPlaces_WhenHas3ElementsAnd2Rotations_IsRotatedProperly() {
        int[] expected = new int[]{2,3,1};
        int[] arr = new int[]{1,2,3};
        sut.rotateRightCircular(arr, 2);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(expected, arr);
    }
    
    @Test
    public void rotateRightCircularWithPlaces_WhenHas4ElementsAnd2Rotations_IsRotatedProperly() {
        int[] expected = new int[]{3,4,1,2};
        int[] arr = new int[]{1,2,3,4};
        sut.rotateRightCircular(arr, 2);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(expected, arr);
    }
    
    @Test
    public void rotateRightCircular_WhenNumberOfElementsIsEqualToNumberOfRotations_StaysSame() {
        int[] expected = new int[]{1,2,3};
        int[] arr = new int[]{1,2,3};
        sut.rotateRightCircular(arr);
        sut.rotateRightCircular(arr);
        sut.rotateRightCircular(arr);
        assertArrayEquals(expected, arr);
    }
}
