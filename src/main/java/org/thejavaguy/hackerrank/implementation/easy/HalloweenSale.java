package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class HalloweenSale {
    public int howManyGames(int p, int d, int m, int s) {
        if (s < p) {
            return 0;
        }
        int moneyLeft = s;
        int ret = 0;
        for (;;) {
            int price = Math.max(p - ret * d, m);
            if (price > moneyLeft) {
                break;
            }
            ++ret;
            moneyLeft -= price;
        }
        return ret;
    }

    public static void main(String[] args) {
        final HalloweenSale app = new HalloweenSale();
        try (Scanner in = new Scanner(System.in)) {
            String[] pdms = in.nextLine().split(" ");
            final int p = Integer.parseInt(pdms[0]);
            final int d = Integer.parseInt(pdms[1]);
            final int m = Integer.parseInt(pdms[2]);
            final int s = Integer.parseInt(pdms[3]);
            System.out.println(app.howManyGames(p, d, m, s));
        }
    }
}
