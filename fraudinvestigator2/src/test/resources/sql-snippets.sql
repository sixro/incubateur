select c.CHAIN_IDENTIFIER, count(*) as RULE_COUNT
    from fraudinvestigator.CHAINS c
        inner join fraudinvestigator.CHAIN_RULES cr on (c.CHAIN_IDENTIFIER = cr.CHAIN_IDENTIFIER)
        inner join fraudinvestigator.RULES r on (cr.RULE_IDENTIFIER = r.RULE_IDENTIFIER)
    group by c.CHAIN_IDENTIFIER
    order by RULE_COUNT desc
    ;

select r.RULE_IDENTIFIER, r.DESCRIPTION, r.EXPRESSION, cr.SCORE
    from fraudinvestigator.CHAINS c
        inner join fraudinvestigator.CHAIN_RULES cr on (c.CHAIN_IDENTIFIER = cr.CHAIN_IDENTIFIER)
        inner join fraudinvestigator.RULES r on (cr.RULE_IDENTIFIER = r.RULE_IDENTIFIER)
    where c.CHAIN_IDENTIFIER = 'EN_GB_LIVE_CHAIN'
      and c.ACTIVE = 1
      and c.STATUS = 'ENABLED'
      and r.DELETED = 0
;