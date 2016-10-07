alter table ACCUMED_CLAIM_LINE add column SERVICE_CODE_ID uuid ;
alter table ACCUMED_CLAIM_LINE drop column SERVICE_CODE cascade ;
