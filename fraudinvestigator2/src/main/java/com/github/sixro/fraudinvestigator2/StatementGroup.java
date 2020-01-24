package com.github.sixro.fraudinvestigator2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a group of statements where the final score is the sum of the inner scores.
 */
public class StatementGroup {

    private static final Logger LOG = LoggerFactory.getLogger(StatementGroup.class);

    private final List<? extends Statement> statements;

    public StatementGroup(List<? extends Statement> statements) {
        Objects.requireNonNull(statements);
        this.statements = statements;
    }

    public int evaluate(Map<String, Object> data) {
        LOG.info("Evaluating score on data using {} statements", statements.size());
        long start = System.currentTimeMillis();

        Integer score = statements
                .parallelStream()
                .map(s -> s.evaluate(data))
                .reduce(0, Integer::sum);

        LOG.info("... returning {} as score calculated in {} ms", score, System.currentTimeMillis() -start);
        return score;
    }

}
