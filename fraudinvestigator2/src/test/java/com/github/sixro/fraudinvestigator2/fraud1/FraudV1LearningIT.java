package com.github.sixro.fraudinvestigator2.fraud1;

import com.github.sixro.fraudinvestigator2.StatementGroup;
import com.github.sixro.fraudinvestigator2.fraud1.model.Order;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FraudV1LearningIT {

    private static final Logger LOG = LoggerFactory.getLogger(FraudV1LearningIT.class);

    private static final DriverManagerDataSource DATA_SOURCE = new DriverManagerDataSource(
            System.getProperty("integration-test.datasource.url", "jdbc:mysql://qa-db.qa.bravofly.intra:3306/fraudinvestigator"),
            System.getProperty("integration-test.datasource.username", "c_developer"),
            System.getProperty("integration-test.datasource.password", "developer123"));
    private Repository repo = new JdbcRepository(DATA_SOURCE);

    @Test public void load_all_rules_of_a_specific_chain() {
        List<FraudV1Rule> list = repo.findChainRules("EN_GB_LIVE_CHAIN");

        LOG.info("... creating data...");
        Map<String, Object> data = new HashMap<>();
        data.put("order", loadOrder("/order.json"));
        LOG.info("... data created: {}", data);

        StatementGroup group = new StatementGroup(list);
        int score = group.evaluate(data);
        assertEquals(1, score);
    }

    private Order loadOrder(String orderAsJsonFile) {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(FraudV1LearningIT.class.getResourceAsStream(orderAsJsonFile)));
        return gson.fromJson(reader, Order.class);
    }


}
