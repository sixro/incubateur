package com.github.sixro.fraudinvestigator2;

import java.util.Map;

/**
 * Represents a statement to evaluate on an object.
 */
public interface Statement {

    /**
     * Returns the score evaluated on specified data.
     *
     * @param data some properties key/value
     * @return the score evaluated on specified data
     */
    int evaluate(Map<String, Object> data);

}
