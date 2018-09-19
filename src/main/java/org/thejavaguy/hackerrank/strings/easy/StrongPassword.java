package org.thejavaguy.hackerrank.strings.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class StrongPassword {
    public int minimumNumber(String password) {
        int missingCategories = 0;
        if (!containsAtLeastOneDigit(password)) {
            ++missingCategories;
        }
        if (!containsAtLeastOneLowercase(password)) {
            ++missingCategories;
        }
        if (!containsAtLeastOneUppercase(password)) {
            ++missingCategories;
        }
        if (!containsAtLeastOneSpecial(password)) {
            ++missingCategories;
        }
        if (password.length() + missingCategories >= 6) {
            return missingCategories;
        }
        return 6 - password.length();
    }

    private boolean containsAtLeastOneDigit(String password) {
        return password
                .chars()
                .mapToObj(c -> (char)c)
                .anyMatch(c -> Character.isDigit(c));
    }

    private boolean containsAtLeastOneLowercase(String password) {
        return password
                .chars()
                .mapToObj(c -> (char)c)
                .anyMatch(c -> Character.isLowerCase(c));
    }

    private boolean containsAtLeastOneUppercase(String password) {
        return password
                .chars()
                .mapToObj(c -> (char)c)
                .anyMatch(c -> Character.isUpperCase(c));
    }

    private boolean containsAtLeastOneSpecial(String password) {
        return password
                .chars()
                .mapToObj(c -> (char)c)
                .anyMatch(c -> isSpecialCharacter(c));
    }

    private boolean isSpecialCharacter(char c) {
        String special = "!@#$%^&*()-+";
        return special
                .chars()
                .mapToObj(spec -> (char)spec)
                .anyMatch(spec -> spec == c);
    }


    public static void main(String[] args) {
        final StrongPassword app = new StrongPassword();
        try (Scanner in = new Scanner(System.in)) {
            final int length = Integer.parseInt(in.nextLine());
            final String password = in.nextLine();
            System.out.println(app.minimumNumber(password));
        }
    }
}
