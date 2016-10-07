alter table ACCUMED_CLAIM add constraint FK_ACCUMED_CLAIM_PATIENT_ID foreign key (PATIENT_ID) references ACCUMED_PATIENT(ID);
