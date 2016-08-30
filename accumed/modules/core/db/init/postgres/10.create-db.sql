-- begin ACCUMED_PATIENT
create table ACCUMED_PATIENT (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
<<<<<<< HEAD
    VERSION integer not null,
=======
>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
<<<<<<< HEAD
    --
    MEMBER_NUMBER varchar(20),
    VERSION_CODE varchar(12),
    EXPIRED_ON timestamp,
    FIRST_NAME varchar(100),
    MIDDLE_NAME varchar(100),
    LAST_NAME varchar(100),
    BIRTH_DATE timestamp,
    GENDER varchar(50),
    EMAIL varchar(255),
    ADDRESS_LINE1 varchar(255),
    ADDRESS_LINE2 varchar(255),
    city varchar(100),
    province varchar(100),
    POSTAL_CODE varchar(20),
    country varchar(20),
    HOME_PHONE varchar(20),
    WORK_PHONE varchar(20),
    CELL_PHONE varchar(20),
    REFERRING_DOCTOR varchar(255),
    FAMILY_DOCTOR varchar(255),
    FACILITY_CODE varchar(255),
    ADMIT_DATE timestamp,
    notes text,
    HN_CHECK_DATE timestamp,
    response text,
    HL7_PATIENT_ID text,
    FAM_DOC_ID uuid,
=======
    VERSION integer,
    --
    patientid double precision,
    healthnum text,
    versioncode text,
    expyear timestamp,
    fname text,
    lname text,
    dob timestamp,
    sex text,
    address text,
    city text,
    province text,
    postalcode text,
    country text,
    hphone text,
    wphone text,
    refdoc text,
    famdoc text,
    facilitynum text,
    admitdate timestamp,
    notes text,
    batchid text,
    hncheckdate timestamp,
    status double precision,
    response text,
    hl7patid text,
    flag varchar(1),
>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994
    --
    primary key (ID)
)^
-- end ACCUMED_PATIENT
<<<<<<< HEAD
-- begin ACCUMED_FACILITY
create table ACCUMED_FACILITY (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FACILITY_CODE varchar(20) not null,
    FACILITY_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ACCUMED_FACILITY
-- begin ACCUMED_PROVIDER
create table ACCUMED_PROVIDER (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PROVIDER_ID varchar(20),
    TITLE varchar(20),
    FIRST_NAME varchar(100) not null,
    LAST_NAME varchar(100) not null,
    MIDDLE_NAME varchar(100),
    EMAIL varchar(255),
    ADDRESS_LINE1 varchar(100),
    ADDRESS_LINE2 varchar(100),
    CITY varchar(100),
    PROVINCE varchar(100),
    COUNTRY varchar(20),
    POSTAL_CODE varchar(20),
    WORK_PHONE varchar(20),
    CELL_PHONE varchar(20),
    GROUP_NUMBER integer,
    PRIMARY_SPECIALTY_ID uuid,
    MINISTRY_OF_HEALTH_OFFICE_ID uuid,
    --
    primary key (ID)
)^
-- end ACCUMED_PROVIDER
-- begin ACCUMED_SPECIALITY
create table ACCUMED_SPECIALITY (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SPECIALTY_CODE varchar(6) not null,
    SPECIALTY_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ACCUMED_SPECIALITY
-- begin ACCUMED_MINISTRY_OF_HEALTH_OFFICE
create table ACCUMED_MINISTRY_OF_HEALTH_OFFICE (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    OFFICE_CODE varchar(5) not null,
    OFFICE_CITY varchar(100) not null,
    CLAIM_CARD_CODE varchar(5),
    --
    primary key (ID)
)^
-- end ACCUMED_MINISTRY_OF_HEALTH_OFFICE
-- begin ACCUMED_PATIENT_ADMISSION
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
    FACILITY_ID uuid not null,
    ADMIT_DATE date not null,
    PATIENT_ID uuid,
    --
    primary key (ID)
)^
-- end ACCUMED_PATIENT_ADMISSION
=======
>>>>>>> 802bc6e5bed0cad934e8937b5e727eb925303994
