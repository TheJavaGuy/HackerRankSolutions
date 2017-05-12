package org.thejavaguy.hackerrank.implementation.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public class LisasWorkbook {
    class Chapter {
        private final int startingPage;
        private final int maxProblemsPerPage;
        private final int numberOfProblems;
        private final List<Page> pages;
        
        public Chapter(final int startingPage, final int maxProblemsPerPage, final int numberOfProblems) {
            this.startingPage = startingPage;
            this.maxProblemsPerPage = maxProblemsPerPage;
            this.numberOfProblems = numberOfProblems;
            this.pages = new ArrayList<>();
        }
        
        public void fillPages() {
            if (!pages.isEmpty()) {
                return;
            }
            int remainingProblems = numberOfProblems;
            int nextPageNumber = startingPage;
            int currentProblem = 1;
            Page currentPage = null;
            for (;;) {
                if (remainingProblems == 0) {
                    break;
                }
                if (currentPage == null) {
                    currentPage = new Page(nextPageNumber);
                    pages.add(currentPage);
                }
                currentPage.addProblem(currentProblem);
                --remainingProblems;
                ++currentProblem;
                if (currentPage.size() == maxProblemsPerPage) {
                    currentPage = null;
                    ++nextPageNumber;
                }
            }
        }
        
        public int endingPageNumber() {
            return pages.get(pages.size() - 1).number();
        }
        
        public int numberOfSpecialProblems() {
            int ret = 0;
            for (Page page : pages) {
                ret += page.numberOfSpecialProblems();
            }
            return ret;
        }
    }
    
    class Page {
        private final int number;
        private final Set<Integer> problemNumbers;
        
        public Page(final int number) {
            this.number = number;
            this.problemNumbers = new TreeSet<>();
        }
        
        public void addProblem(int problem) {
            problemNumbers.add(Integer.valueOf(problem));
        }
        
        public int size() {
            return problemNumbers.size();
        }
        
        public int number() {
            return number;
        }
        
        public int numberOfSpecialProblems() {
            if (problemNumbers.contains(Integer.valueOf(number))) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    public static void main(String[] args) {
        final LisasWorkbook app = new LisasWorkbook();
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfChapters = in.nextInt();
            final int maxProblemsPerPage = in.nextInt();
            final int[] problemsPerChapter = new int[numberOfChapters];
            final List<Chapter> chapters = new ArrayList<>();
            for (int i = 0; i < numberOfChapters; ++i) {
                problemsPerChapter[i] = in.nextInt();
                if (i == 0) {
                    chapters.add(app.new Chapter(1, maxProblemsPerPage, problemsPerChapter[i]));
                    chapters.get(i).fillPages();
                } else {
                    chapters.add(app.new Chapter(chapters.get(i-1).endingPageNumber() + 1, maxProblemsPerPage, problemsPerChapter[i]));
                    chapters.get(i).fillPages();
                }
            }
            int numberOfSpecialProblems = 0;
            for (Chapter chapter : chapters) {
                numberOfSpecialProblems += chapter.numberOfSpecialProblems();
            }
            System.out.println(numberOfSpecialProblems);
        }
    }
}
