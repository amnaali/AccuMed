alter table ACCUMED_SERVICE_CODE_RULE add column RULE_OPERATOR varchar(50) not null default '=' ;
alter table ACCUMED_SERVICE_CODE_RULE drop column RULE_CONDITION cascade ;
