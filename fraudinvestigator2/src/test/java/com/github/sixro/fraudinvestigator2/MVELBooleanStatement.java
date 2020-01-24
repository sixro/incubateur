package com.github.sixro.fraudinvestigator2;

import org.mvel2.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents a statement using MVEL language where the statement
 * is just a boolean expression and the fixed score is returned only
 * when the expression is true otherwise 0 is returned.
 */
public class MVELBooleanStatement implements Statement {

    private static final Logger LOG = LoggerFactory.getLogger(MVELBooleanStatement.class);

    private final String code;
    private final int score;
    private final transient Serializable compiledCode;

    public MVELBooleanStatement(String code, int score) {
        this.code = code;
        this.score = score;
        this.compiledCode = MVEL.compileExpression(code);
    }

    @Override
    public int evaluate(Map<String, Object> data) {
        try {
            LOG.info("Evaluating score on data using MVEL expression '{}' ...", code);
            Object ret = MVEL.executeExpression(compiledCode, data);
            Boolean matches = (Boolean) ret;
            int retScore = matches ? score : 0;
            LOG.info("... returning {} as score of MVEL expression '{}'", retScore, code);
            return retScore;
        } catch (Exception e) {
            LOG.error("Unable to evaluate score on data using MVEL expression '{}'", code, e);
            throw new RuntimeException("Unable to evaluate score on data using MVEL expression '" + code + "'", e);
        }
    }
}
