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
    SERVICE_NAME varchar(255) not null,
    --
    primary key (ID)
);
