package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("your name")) {
            return "HA";
        }

        if (query.toLowerCase().contains("imperial")) {
            return "Imperial College is a university in London";
        }

        if (query.toLowerCase().contains("theresa may")) {
            return "2016";
        }

        if (query.toLowerCase().contains("banana")) {
            return "yellow";
        }

        if (query.toLowerCase().contains("eiffel tower")) {
            return "paris";
        }

        if (query.toLowerCase().contains("plus")) {
            try {
                String[] parts = query.split(" ");
                return Integer.toString(Integer.parseInt(parts[parts.length - 3]) + Integer.parseInt(parts[parts.length - 1]));
            } catch (Exception ex) {
                return "";
            }
        }

        if (query.toLowerCase().contains("minus")) {
            try {
                String[] parts = query.split(" ");
                return Integer.toString(Integer.parseInt(parts[parts.length - 3]) - Integer.parseInt(parts[parts.length - 1]));
            } catch (Exception ex) {
                return "";
            }
        }

        if (query.toLowerCase().contains("multiplied")) {
            try {
                String[] parts = query.split(" ");
                return Integer.toString(Integer.parseInt(parts[parts.length - 4]) * Integer.parseInt(parts[parts.length - 1]));
            } catch (Exception ex) {
                return "";
            }
        }

        if (query.toLowerCase().contains("largest")) {
            // which%20of%20the%20following%20numbers%20is%20the%20largest:%2044,%2017
            String[] parts = query.split(":");
            String[] numbers = parts[2].split(",");
            List<Integer> ns = new ArrayList<Integer>();
            for (String number : numbers) {
                ns.add(Integer.parseInt(number.trim()));
            }

            return Integer.toString(Collections.max(ns));
        }

        if (query.toLowerCase().contains("a square and a cube")) {
            String[] parts = query.split(":");
            String[] numbers = parts[2].split(",");
            List<Integer> ns = new ArrayList<>();
            List<String> results = new ArrayList<>();

            for (String number : numbers) {
                int n = Integer.parseInt(number.trim());
                double sqrt = Math.sqrt(n);
                double cbrt = Math.cbrt(n);
                if (sqrt - Math.floor(sqrt) == 0 && cbrt - Math.floor(cbrt) == 0) {
                    results.add(Integer.toString(n));
                }
            }

            return String.join(", ", results);
        }

        if (query.toLowerCase().contains("primes")) {
            String[] parts = query.split(":");
            String[] numbers = parts[2].split(",");
            List<Integer> ns = new ArrayList<>();
            List<String> results = new ArrayList<>();

            for (String number : numbers) {
                int n = Integer.parseInt(number.trim());
                if (isPrime(n)) {
                    results.add(Integer.toString(n));
                }
            }

            return String.join(", ", results);
        }

//        if (query.toLowerCase().contains("fibonacci")) {
//            String[] parts = query.split(": ")[1].split(" ");
//            String nth = parts[3].substring(0, parts[3].length() - 3);
//            int n = Integer.parseInt(nth);
//        }

        return "";
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; ++i) {
            // condition for nonprime number
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
