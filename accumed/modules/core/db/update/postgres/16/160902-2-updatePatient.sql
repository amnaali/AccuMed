alter table ACCUMED_PATIENT add column FAMILY_DOCTOR_ID uuid ;
alter table ACCUMED_PATIENT drop column FAMILY_DOCTOR cascade ;
alter table ACCUMED_PATIENT drop column FACILITY_CODE cascade ;
alter table ACCUMED_PATIENT drop column ADMIT_DATE cascade ;
alter table ACCUMED_PATIENT drop column FAM_DOC_ID cascade ;
