package org.thejavaguy.hackerrank.warmup;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class TimeConversion {
    private static final String SEPARATOR = ":";

    public String ampmToMilitary(final String ampm) {
        final String[] components = ampm.split(":");
        final int hour = Integer.parseInt(components[0]);
        final int minute = Integer.parseInt(components[1]);
        final int second = Integer.parseInt(components[2].substring(0, 2));
        final String timeSuffix = components[2].substring(2, 4);
        if (timeSuffix.equals("AM")) {
            if (hour == 12) {
                return militaryTime(0, minute, second);
            } else {
                return militaryTime(hour, minute, second);
            }
        } else {
            if (hour == 12) {
                return militaryTime(hour, minute, second);
            } else {
                return militaryTime(12 + hour, minute, second);
            }
        }
    }

    private String militaryTime(final int hour, final int minute, final int second) {
        return withLeadingZero(hour) + SEPARATOR + withLeadingZero(minute) + SEPARATOR + withLeadingZero(second);
    }

    private String withLeadingZero(final int origin) {
        return String.format("%1$02d", origin);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String time = in.next();
            TimeConversion app = new TimeConversion();
            System.out.println(app.ampmToMilitary(time));
        }
    }
}
