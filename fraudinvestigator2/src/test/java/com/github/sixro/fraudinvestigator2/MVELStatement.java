package com.github.sixro.fraudinvestigator2;

import org.mvel2.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Map;

public class MVELStatement implements Statement {

    private static final Logger LOG = LoggerFactory.getLogger(MVELStatement.class);

    private final String code;
    private final transient Serializable compiledCode;

    public MVELStatement(String code) {
        this.code = code;
        this.compiledCode = MVEL.compileExpression(code);
    }

    @Override
    public int evaluate(Map<String, Object> data) {
        LOG.info("Evaluating score on data using MVEL expression '{}' ...", code);
        try {
            Object ret = MVEL.executeExpression(compiledCode, data);
            Integer score = (Integer) ret;
            LOG.info("... returning {} as score of MVEL expression '{}'", score, code);
            return score;
        } catch (Exception e) {
            LOG.error("Unable to evaluate score on data using MVEL expression '{}'", code, e);
            throw new RuntimeException("Unable to evaluate score on data using MVEL expression '" + code + "'", e);
        }
    }

}
