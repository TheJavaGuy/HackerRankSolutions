package org.thejavaguy.hackerrank.implementation.medium;

import java.util.Scanner;

public final class TheTimeInWords {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int hours = Integer.parseInt(in.nextLine());
            final int minutes = Integer.parseInt(in.nextLine());
            final String[] hoursStr = new String[] {"",
                    "one","two","three","four","five","six","seven","eight","nine","ten",
                    "eleven","twelve","thirteen","fourteen","quarter","sixteen","seventeen","eighteen","nineteen"
            };
            if (minutes == 0) {
                System.out.println(hoursStr[hours] + " o' clock");
            } else if (minutes == 1) {
                System.out.println("one minute past " + hoursStr[hours]);
            } else if (minutes >= 2 && minutes <= 19) {
                String minutesLiteral = minutes == 15 ? "" : " minutes";
                System.out.println(hoursStr[minutes] + minutesLiteral + " past " + hoursStr[hours]);
            } else if (minutes >= 20 && minutes <= 29) {
                System.out.println("twenty " + hoursStr[minutes - 20] + " minutes past " + hoursStr[hours]);
            } else if (minutes == 30) {
                System.out.println("half past " + hoursStr[hours]);
            } else if (minutes >= 31 && minutes <= 40) {
                System.out.println("twenty " + hoursStr[60 - minutes - 20] + " minutes to " + hoursStr[hours + 1]);
            } else if (minutes >= 41 && minutes <= 50) {
                String minutesLiteral = (60 - minutes) == 15 ? "" : " minutes";
                System.out.println(hoursStr[60 - minutes] + minutesLiteral + " to " + hoursStr[hours + 1]);
            } else if (minutes >= 51 && minutes <= 59) {
                System.out.println(hoursStr[60 - minutes] + " minutes to " + hoursStr[hours + 1]);
            }
        }
    }
}
