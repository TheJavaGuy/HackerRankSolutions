package org.thejavaguy.hackerrank.implementation.easy;

import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class FlatlandSpaceStations {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfCities = in.nextInt();
            final int numberOfStations = in.nextInt();
            if (numberOfCities == numberOfStations) {
                System.out.println(0);
                return;
            }
            final boolean[] citiesWithStations = new boolean[numberOfCities];
            for (int i = 0; i < numberOfStations; ++i) {
                citiesWithStations[in.nextInt()] = true;
            }
            int maxDistance = 0;
            int closestWesternStation = -1;
            int closestEasternStation = -1;
            for (int cityIndex = 0; cityIndex < numberOfCities; ++cityIndex) {
                if (citiesWithStations[cityIndex]) {
                    closestWesternStation = cityIndex;
                    continue;
                }
                for (int cityPtr = cityIndex + 1; cityPtr < numberOfCities; ++cityPtr) {
                    if (citiesWithStations[cityPtr]) {
                        closestEasternStation = cityPtr;
                        break;
                    }
                }
                int distWest = Integer.MAX_VALUE;
                if (closestWesternStation != -1) {
                    distWest = cityIndex - closestWesternStation;                    
                }
                int distEast = Integer.MAX_VALUE;
                if (closestEasternStation != -1) {
                    distEast = closestEasternStation - cityIndex;                    
                }
                int currentNearestDist = Math.min(distWest, distEast);
                if (currentNearestDist > maxDistance) {
                    maxDistance = currentNearestDist;
                }
                closestEasternStation = -1;
            }
            System.out.println(maxDistance);
        }
    }
}
