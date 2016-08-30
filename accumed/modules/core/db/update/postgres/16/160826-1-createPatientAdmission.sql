create table ACCUMED_PATIENT_ADMISSION (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FACILITY_CODE varchar(255) not null,
    ADMIT_DATE date not null,
    PATIENT_ID uuid,
    --
    primary key (ID)
);
