package com.develogical;

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
            String[] parts = query.split(" ");
            return Integer.toString(Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]));
        }

        return "";
    }
}
