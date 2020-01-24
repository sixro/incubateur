package com.github.sixro.fraudinvestigator2.fraud1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcRepository implements Repository{

    private static final Logger LOG = LoggerFactory.getLogger(JdbcRepository.class);

    private final JdbcTemplate jdbcTemplate;

    public JdbcRepository(DataSource dataSource) {
        this(new JdbcTemplate(dataSource));
    }

    public JdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<FraudV1Rule> findChainRules(String chainID) {
        LOG.info("Loading rules of chain '{}' ...", chainID);
        List<FraudV1Rule> list = jdbcTemplate.query("select r.RULE_IDENTIFIER, r.DESCRIPTION, r.EXPRESSION, cr.SCORE\n" +
                        "    from fraudinvestigator.CHAINS c\n" +
                        "        inner join fraudinvestigator.CHAIN_RULES cr on (c.CHAIN_IDENTIFIER = cr.CHAIN_IDENTIFIER)\n" +
                        "        inner join fraudinvestigator.RULES r on (cr.RULE_IDENTIFIER = r.RULE_IDENTIFIER)\n" +
                        "    where c.CHAIN_IDENTIFIER = ?\n" +
                        "      and c.ACTIVE = 1\n" +
                        "      and c.STATUS = 'ENABLED'\n" +
                        "      and r.DELETED = 0" +
                        "      and r.EXPRESSION not like 'score.%'",
                new Object[]{ chainID },
                FraudV1RuleRowMapper.INSTANCE
        );
        LOG.info("... returning {} rules: {}", list.size(), list);
        return list;
    }

    private static class FraudV1RuleRowMapper implements RowMapper<FraudV1Rule> {

        private static final Logger LOG = LoggerFactory.getLogger(FraudV1RuleRowMapper.class);

        public static final FraudV1RuleRowMapper INSTANCE = new FraudV1RuleRowMapper();

        @Override
        public FraudV1Rule mapRow(ResultSet rs, int i) throws SQLException {
            String id = rs.getString("RULE_IDENTIFIER");
            String desc = rs.getString("DESCRIPTION");
            String expression = rs.getString("EXPRESSION");
            int score = rs.getInt("SCORE");

            LOG.debug("Creating {} with id {}, expression '{}' and score {} described as '{}'...", FraudV1Rule.class.getSimpleName(), id, expression, score, desc);
            return new FraudV1Rule(id, expression, score);
        }

    }

}
