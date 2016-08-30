alter table ACCUMED_PATIENT_ADMISSION add constraint FK_ACCUMED_PATIENT_ADMISSION_FACILITY_ID foreign key (FACILITY_ID) references ACCUMED_FACILITY(ID);
create index IDX_ACCUMED_PATIENT_ADMISSION_FACILITY on ACCUMED_PATIENT_ADMISSION (FACILITY_ID);
