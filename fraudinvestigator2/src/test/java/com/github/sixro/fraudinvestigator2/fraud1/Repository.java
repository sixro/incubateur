package com.github.sixro.fraudinvestigator2.fraud1;

import java.util.List;

public interface Repository {

    List<FraudV1Rule> findChainRules(String chainID);

}
