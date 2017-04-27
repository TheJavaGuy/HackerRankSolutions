package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class DayOfTheProgrammer {
    private static final int[] daysNonLeap = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] daysLeap = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    private static final int[] daysTransition = {0,31,15,31,30,31,30,31,31,30,31,30,31};
    private static final int dayOfTheProgrammer = 256;
    
    private boolean isJulian(final int year) {
        return year >= 1700 && year <= 1917;
    }
    
    private boolean isTransition(final int year) {
        return year == 1918;
    }
    
    private boolean isLeapJulian(final int year) {
        return year % 4 == 0;
    }
    
    private boolean isLeapGregorian(final int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    
    private int monthForDayOfTheProgrammer(int[] days) {
        int startOfMonth = 0;
        int endOfMonth = 0;
        for (int i = 1; i < days.length; ++i) {
            endOfMonth += days[i];
            if (dayOfTheProgrammer >= startOfMonth && dayOfTheProgrammer <= endOfMonth) {
                return i;
            }
            startOfMonth = endOfMonth + 1;
        }
        return Integer.MAX_VALUE;
    }
    
    private int sumOfFirstMonths(int months, int[] days) {
        int ret = 0;
        for (int i = 1; i < months; ++i) {
            ret += days[i];
        }
        return ret;
    }
    
    public String result(int day, int month, int year) {
        return String.format("%02d.%02d.%4d", day, month, year);
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int year = in.nextInt();
            final DayOfTheProgrammer app = new DayOfTheProgrammer();
            if (app.isJulian(year)) {
                if (app.isLeapJulian(year)) {
                    //use daysleap
                    int month = app.monthForDayOfTheProgrammer(daysLeap);
                    int day = dayOfTheProgrammer - app.sumOfFirstMonths(month, daysLeap);
                    System.out.println(app.result(day, month, year));
                } else {
                    //use daysnonleap
                    int month = app.monthForDayOfTheProgrammer(daysNonLeap);
                    int day = dayOfTheProgrammer - app.sumOfFirstMonths(month, daysNonLeap);
                    System.out.println(app.result(day, month, year));
                }
            } else if (app.isTransition(year)) {
                //use daystransition
                int month = app.monthForDayOfTheProgrammer(daysTransition);
                int day = dayOfTheProgrammer - app.sumOfFirstMonths(month, daysTransition);
                System.out.println(app.result(day, month, year));
            } else {
                if (app.isLeapGregorian(year)) {
                    //use daysleap
                    int month = app.monthForDayOfTheProgrammer(daysLeap);
                    int day = dayOfTheProgrammer - app.sumOfFirstMonths(month, daysLeap);
                    System.out.println(app.result(day, month, year));
                } else {
                    //use daysnonleap
                    int month = app.monthForDayOfTheProgrammer(daysNonLeap);
                    int day = dayOfTheProgrammer - app.sumOfFirstMonths(month, daysNonLeap);
                    System.out.println(app.result(day, month, year));
                }
            }
        }
    }
}
