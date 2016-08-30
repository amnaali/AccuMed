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
    POSTAL_CODE varchar(20),
    WORK_PHONE varchar(20),
    CELL_PHONE varchar(20),
    GROUP_NUMBER integer,
    PRIMARY_SPECIALTY_ID uuid,
    MINISTRY_OF_HEALTH_OFFICE_ID uuid,
    --
    primary key (ID)
);
