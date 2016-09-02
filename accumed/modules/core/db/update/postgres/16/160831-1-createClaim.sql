create table ACCUMED_CLAIM (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PATIENT_ID uuid,
    REFERRED_BY_ID uuid,
    DOCTOR_ID uuid,
    CLAIM_TYPE varchar(255),
    LOCATION varchar(255),
    FACILITY_ID uuid,
    ADMIT_DATE date,
    REFERRING_LAB varchar(255),
    MANUAL_REVIEW varchar(255),
    --
    primary key (ID)
);
