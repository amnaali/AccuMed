-- alter table ACCUMED_PATIENT_ADMISSION add column FACILITY_CODE_ID uuid ^
-- update ACCUMED_PATIENT_ADMISSION set FACILITY_CODE_ID = <default_value> ;
-- alter table ACCUMED_PATIENT_ADMISSION alter column FACILITY_CODE_ID set not null ;
alter table ACCUMED_PATIENT_ADMISSION add column FACILITY_CODE_ID uuid not null ;
alter table ACCUMED_PATIENT_ADMISSION drop column FACILITY_CODE cascade ;
