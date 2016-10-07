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
    QUICK_CODE varchar(255),
    DESCRIPTION text,
    NUMBER_OF_SERVICES integer,
    DIAGNOSTIC_CODE varchar(255),
    PERCENTAGE_OF_FEE integer,
    DEFAULT_CODE boolean,
    --
    primary key (ID)
);
