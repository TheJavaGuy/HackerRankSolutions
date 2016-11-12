package org.thejavaguy.hackerrank.implementation.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author ivan
 *
 */
public final class CutTheSticks {
    public int lengthOfCut(final List<Integer> sticks) {
        int ret = Integer.MAX_VALUE;
        for (Integer stick : sticks) {
            if (stick.intValue() < ret) {
                ret = stick.intValue();
            }
        }
        return ret;
    }

    public void cut(final List<Integer> sticks, final int lengthOfCut) {
        for (ListIterator<Integer> iter = sticks.listIterator(); iter.hasNext();) {
            Integer stickToCut = iter.next();
            final int newLength = stickToCut.intValue() - lengthOfCut;
            iter.remove();
            if (newLength > 0) {
                iter.add(Integer.valueOf(newLength));
            }
        }
    }

    public static void main(String[] args) {
        final CutTheSticks app = new CutTheSticks();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfSticks = in.nextInt();
            List<Integer> sticks = new LinkedList<>();
            for (int i = 0; i < numberOfSticks; ++i) {
                sticks.add(Integer.valueOf(in.nextInt()));
            }
            for (;;) {
                if (sticks.isEmpty()) {
                    break;
                }
                final int length = app.lengthOfCut(sticks);
                System.out.println(sticks.size());
                app.cut(sticks, length);
            }
        }
    }
}
