update ACCUMED_SERVICE_CODE_RULE set RULE_CONDITION = '=' where RULE_CONDITION is null ;
alter table ACCUMED_SERVICE_CODE_RULE alter column RULE_CONDITION set not null ;
