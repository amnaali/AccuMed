-- begin ACCUMED_PATIENT
create table ACCUMED_PATIENT (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
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
    FAMILY_DOCTOR_ID uuid,
    notes text,
    HN_CHECK_DATE timestamp,
    response text,
    HL7_PATIENT_ID text,
    --
    primary key (ID)
)^
-- end ACCUMED_PATIENT
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
    FAX_NUMBER varchar(20),
    GROUP_NUMBER varchar(10),
    PRIMARY_SPECIALTY_ID uuid,
    MINISTRY_OF_HEALTH_OFFICE varchar(5),
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
)^-- end ACCUMED_PATIENT_ADMISSION

-- begin ACCUMED_CLAIM
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
    PROVIDER_ID uuid,
    CLAIM_TYPE integer,
    LOCATION varchar(255),
    FACILITY_ID uuid,
    ADMIT_DATE date,
    REFERRING_LAB varchar(255),
    MANUAL_REVIEW boolean,
    --
    primary key (ID)
)^
-- end ACCUMED_CLAIM
-- begin ACCUMED_CLAIM_LINE
create table ACCUMED_CLAIM_LINE (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLAIM_ID uuid,
    SERVICE_CODE_ID uuid,
    DIAGNOSTIC_CODE varchar(255),
    NO_OF_SERVICES integer,
    FEE double precision,
    SERVICE_DATE date,
    --
    primary key (ID)
)^
-- end ACCUMED_CLAIM_LINE
-- begin ACCUMED_SERVICE_CODE
create table ACCUMED_SERVICE_CODE (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SERVICE_CODE varchar(10) not null,
    DESCRIPTION varchar(255) not null,
    --
    primary key (ID)
)^
-- end ACCUMED_SERVICE_CODE
-- begin ACCUMED_SERVICE_CODE_RULE
create table ACCUMED_SERVICE_CODE_RULE (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    RULE_NAME varchar(255),
    PROPERTY_NAME varchar(255) not null,
    PROPERTY_VALUE varchar(255),
    SERVICE_CODE_ID uuid,
    RULE_OPERATOR varchar(255) not null,
    --
    primary key (ID)
)^
-- end ACCUMED_SERVICE_CODE_RULE
-- begin ACCUMED_BILLABLE_SERVICE_CODE
create table ACCUMED_BILLABLE_SERVICE_CODE (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BILLABLE_CODE varchar(255) not null,
    CODE_TYPE varchar(50) not null,
    FEE double precision not null,
    UNITS double precision not null,
    SERVICE_CODE_ID uuid not null,
    --
    primary key (ID)
)^
-- end ACCUMED_BILLABLE_SERVICE_CODE
-- begin ACCUMED_QUICK_SERVICE_CODE
create table ACCUMED_QUICK_SERVICE_CODE (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    QUICK_CODE varchar(255) not null,
    DESCRIPTION text,
    NUMBER_OF_SERVICES integer,
    DIAGNOSTIC_CODE varchar(255),
    PERCENTAGE_OF_FEE integer,
    DEFAULT_CODE boolean,
    --
    primary key (ID)
)^
-- end ACCUMED_QUICK_SERVICE_CODE
-- begin ACCUMED_QUICK_SERVICE_CODE_BILLABLE_SERVICE_CODE_LINK
create table ACCUMED_QUICK_SERVICE_CODE_BILLABLE_SERVICE_CODE_LINK (
    QUICK_SERVICE_CODE_ID uuid,
    BILLABLE_SERVICE_CODE_ID uuid,
    primary key (QUICK_SERVICE_CODE_ID, BILLABLE_SERVICE_CODE_ID)
)^
-- end ACCUMED_QUICK_SERVICE_CODE_BILLABLE_SERVICE_CODE_LINK
