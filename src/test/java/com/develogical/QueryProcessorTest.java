package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutImperial() throws Exception {
        assertThat(queryProcessor.process("Imperial"),
                containsString("university"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("your name"),
                containsString("HA"));
    }

    @Test
    public void knowsLargest() throws Exception {
        assertThat(queryProcessor.process(":which of the following numbers is the largest: 44, 17, 36"),
                containsString("44"));
    }

    @Test
    public void knowsMultiply() throws Exception {
        assertThat(queryProcessor.process("7a1eb5b0: what is 6 multiplied by 18"),
                containsString(Integer.toString(6 * 18)));
    }

    @Test
    public void knowsCube() throws Exception {
        assertThat(queryProcessor.process("b5874d50: which of the following numbers is both a square and a cube: 285, 729"),
                containsString("729"));
    }

    @Test
    public void knowsPrimes() throws Exception {
        assertThat(queryProcessor.process("b5874d50: which of the following numbers is both a square and a cube: 285, 729"),
                containsString("729"));
    }

    @Test
    public void knowsFib() throws Exception {
        assertThat(queryProcessor.process("55e9c510: what is the 14th number in the Fibonacci sequence"),
                containsString("377"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
