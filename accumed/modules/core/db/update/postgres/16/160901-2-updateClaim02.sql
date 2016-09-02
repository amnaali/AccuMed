alter table ACCUMED_CLAIM add column PROVIDER_ID uuid ;
alter table ACCUMED_CLAIM drop column DOCTOR_ID cascade ;
