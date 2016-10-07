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
);
