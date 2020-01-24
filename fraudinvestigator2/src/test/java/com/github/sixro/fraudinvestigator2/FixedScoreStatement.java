package com.github.sixro.fraudinvestigator2;

import java.util.Map;

public class FixedScoreStatement implements Statement {
    private final int score;

    public FixedScoreStatement(int score) {
        this.score = score;
    }

    @Override
    public int evaluate(Map<String, Object> data) {
        return score;
    }
}
