update ACCUMED_SERVICE_CODE_RULE set PROPERTY_NAME = '' where PROPERTY_NAME is null ;
alter table ACCUMED_SERVICE_CODE_RULE alter column PROPERTY_NAME set not null ;
alter table ACCUMED_SERVICE_CODE_RULE alter column RULE_OPERATOR set data type varchar(255) ;
