alter table ACCUMED_PATIENT_ADMISSION add constraint FK_ACCUMED_PATIENT_ADMISSION_FACILITY_CODE_ID foreign key (FACILITY_CODE_ID) references ACCUMED_FACILITY(ID);
create index IDX_ACCUMED_PATIENT_ADMISSION_FACILITY_CODE on ACCUMED_PATIENT_ADMISSION (FACILITY_CODE_ID);
