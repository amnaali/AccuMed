alter table ACCUMED_CLAIM drop column MANUAL_REVIEW cascade ;
alter table ACCUMED_CLAIM add column MANUAL_REVIEW boolean ;
