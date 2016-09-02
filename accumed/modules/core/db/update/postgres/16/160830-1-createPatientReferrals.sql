create table ACCUMED_PATIENT_REFERRALS (
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
    REFERRING_DOCTOR_ID uuid,
    REFERRAL_DATE date not null,
    --
    primary key (ID)
);
