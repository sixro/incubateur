package com.github.sixro.fraudinvestigator2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MVELStatementTest {

    @Test public void sum_of_numbers() {
        MVELStatement st = new MVELStatement("2 + 3");
        int score = st.evaluate(null);
        assertEquals(5, score);
    }

    @Test public void using_vars() {
        Map<String, Object> data = new HashMap<>();
        data.put("a", 1);
        data.put("b", 2);
        data.put("c", 3);
        MVELStatement st = new MVELStatement("a + b * c");
        int score = st.evaluate(data);
        assertEquals(7, score);
    }

}