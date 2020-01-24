package com.github.sixro.fraudinvestigator2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatementGroupTest {

    public static final HashMap<String, Object> IGNORED_DATA = new HashMap<>();

    @Test public void one_statement() {
        StatementGroup group = new StatementGroup(asList(new FixedScoreStatement(10)));
        assertEquals(10, group.evaluate(IGNORED_DATA));
    }

    @Test public void multiple_statements() {
        StatementGroup group = new StatementGroup(asList(new FixedScoreStatement(10), new FixedScoreStatement(10)));
        assertEquals(20, group.evaluate(IGNORED_DATA));
    }

    @Test public void multiple_mvel_statements() {
        Map<String, Object> data = new HashMap<>();
        data.put("email", "fraudster@gmail.com");

        StatementGroup group = new StatementGroup(asList(
            new MVELStatement("1 * 2 * 3"),
            new MVELBooleanStatement("email ~= '.*fraud.*'", 1000),
            new MVELBooleanStatement("email ~= '.*abc.*'", 1000),
            new MVELBooleanStatement("email ~= '.*c123.*'", 1000),
            new MVELBooleanStatement("email ~= '.*au.*'", 1000)
        ));
        assertTrue(group.evaluate(data) > 1000);
    }

}