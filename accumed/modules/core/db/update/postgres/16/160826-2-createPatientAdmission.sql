alter table ACCUMED_PATIENT_ADMISSION add constraint FK_ACCUMED_PATIENT_ADMISSION_PATIENT_ID foreign key (PATIENT_ID) references ACCUMED_PATIENT(ID);
create index IDX_ACCUMED_PATIENT_ADMISSION_PATIENT on ACCUMED_PATIENT_ADMISSION (PATIENT_ID);
