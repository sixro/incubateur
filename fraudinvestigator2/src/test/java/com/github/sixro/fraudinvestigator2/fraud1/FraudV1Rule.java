package com.github.sixro.fraudinvestigator2.fraud1;

import com.github.sixro.fraudinvestigator2.Statement;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.mvel2.MVEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Map;

public class FraudV1Rule implements Statement {

    private static final Logger LOG = LoggerFactory.getLogger(FraudV1Rule.class);

    private final String id;
    private final String code;
    private final int score;

    private final transient Serializable compiledCode;

    public FraudV1Rule(String id, String code, int score) {
        this.id = id;
        this.code = code;
        this.score = score;
        this.compiledCode = MVEL.compileExpression(code);
    }

    @Override
    public int evaluate(Map<String, Object> data) {
        try {
            LOG.info("Evaluating score of rule {} (score: {})...", id, score);

            Object ret = MVEL.executeExpression(compiledCode, data);
            Boolean matches = (Boolean) ret;
            int retScore = matches ? score : 0;

            LOG.info("... returning {} as score for rule {}", retScore, id);
            return retScore;
        } catch (Exception e) {
            LOG.error("Unable to evaluate score of rule {} having code '{}'", id, code, e);
            throw new RuntimeException("Unable to evaluate score of rule " + id + " having code '" + code + "'", e);
        }
    }

    @Override
    public String toString() {
        return id + "<" + score + ">";
    }
}
