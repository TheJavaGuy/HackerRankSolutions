package org.thejavaguy.hackerrank.implementation.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class ACMICPCTeam {
    private final Map<Integer, List<String>> topicsCountByTeam;
    
    public ACMICPCTeam() {
        topicsCountByTeam = new TreeMap<>();
    }
    
    public void add(Integer topicCount, String team) {
        if (topicsCountByTeam.containsKey(topicCount)) {
            topicsCountByTeam.get(topicCount).add(team);
        } else {
            List<String> value = new ArrayList<>();
            value.add(team);
            topicsCountByTeam.put(topicCount, value);
        }
    }
    
    public int maxNumberOfTopics() {
        Integer max = Integer.MIN_VALUE;
        Iterator<Integer> iter = topicsCountByTeam.keySet().iterator();
        while (iter.hasNext()) {
            max = iter.next();
        }
        return max.intValue();
    }
    
    public int numberOfTeams() {
        Integer max = Integer.MIN_VALUE;
        Iterator<Integer> iter = topicsCountByTeam.keySet().iterator();
        while (iter.hasNext()) {
            max = iter.next();
        }
        return topicsCountByTeam.get(max).size();
    }
    
    private int howManyTopicsKnow(int person1, int person2, boolean[][] topicsPeopleMatrix) {
        int ret = 0;
        for (int topicIndex = 0; topicIndex < topicsPeopleMatrix[0].length; ++topicIndex) {
            if (topicsPeopleMatrix[person1][topicIndex] || topicsPeopleMatrix[person2][topicIndex]) {
                ++ret;
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfPeople = in.nextInt();
            final int numberOfTopics = in.nextInt();
            in.nextLine();
            final String[] topicsByPeople = new String[numberOfPeople];
            for (int i = 0; i < numberOfPeople; ++i) {
                topicsByPeople[i] = in.nextLine();
            }
            final boolean[][] topicsPeopleMatrix = new boolean[numberOfPeople][numberOfTopics];
            for (int i = 0; i < numberOfPeople; ++i) {
                for (int j = 0; j < numberOfTopics; ++j) {
                    if (topicsByPeople[i].charAt(j) == '0') {
                        topicsPeopleMatrix[i][j] = false;
                    } else {
                        topicsPeopleMatrix[i][j] = true;
                    }
                }
                
            }
            final ACMICPCTeam app = new ACMICPCTeam();
            for (int person1 = 0; person1 < topicsPeopleMatrix.length - 1; ++person1) {
                for (int person2 = person1 + 1; person2 < topicsPeopleMatrix.length; ++person2) {
                    int topicsKnown = app.howManyTopicsKnow(person1, person2, topicsPeopleMatrix);
                    app.add(Integer.valueOf(topicsKnown), person1 + "|" + person2);
                }
            }
            System.out.println(app.maxNumberOfTopics());
            System.out.println(app.numberOfTeams());
        }
    }
}
