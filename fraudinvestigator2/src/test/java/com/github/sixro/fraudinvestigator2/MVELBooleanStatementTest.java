package com.github.sixro.fraudinvestigator2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MVELBooleanStatementTest {

    @Test public void match() {
        Map<String, Object> data = new HashMap<>();
        data.put("a", 1);
        MVELBooleanStatement st = new MVELBooleanStatement("a > 0", 100);
        assertEquals(100, st.evaluate(data));
    }

    @Test public void not_match() {
        Map<String, Object> data = new HashMap<>();
        data.put("a", 0);
        MVELBooleanStatement st = new MVELBooleanStatement("a > 0", 100);
        assertEquals(0, st.evaluate(data));
    }

}