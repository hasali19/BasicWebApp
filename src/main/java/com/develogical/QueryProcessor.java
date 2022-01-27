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

        if (query.toLowerCase().contains("imperial")) {
            return "Imperial College is a university in London";
        }

        if (query.toLowerCase().contains("your name")) {
            return "HA";
        }

        if (query.toLowerCase().contains("plus")) {
            try {
                String[] parts = query.split(" ");
                return Integer.toString(Integer.parseInt(parts[parts.length - 3]) + Integer.parseInt(parts[parts.length - 1]));
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

        return "";
    }
}
