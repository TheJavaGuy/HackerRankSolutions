package org.thejavaguy.hackerrank.greedy.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class JimAndTheOrders {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfCustomers = Integer.parseInt(in.nextLine());
            final List<Customer> customers = new LinkedList<>();
            for (int i = 0; i < numberOfCustomers; ++i) {
                final String[] numberAndTime = in.nextLine().split(" ");
                final int servingTime = Integer.parseInt(numberAndTime[0]) + Integer.parseInt(numberAndTime[1]);
                customers.add(new Customer(i + 1, servingTime));
            }
            customers.sort(null);
            for (Customer customer : customers) {
                System.out.print(customer.id());
                System.out.print(" ");
            }
        }
    }

    private static class Customer implements Comparable<Customer> {
        private final int id;
        private final int servingTime;

        public Customer(int id, int servingTime) {
            super();
            this.id = id;
            this.servingTime = servingTime;
        }

        public int id() {
            return id;
        }

        @Override
        public int compareTo(Customer o) {
            if (this.servingTime < o.servingTime) {
                return -1;
            } else if (this.servingTime == o.servingTime) {
                if (this.id < o.id) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}
