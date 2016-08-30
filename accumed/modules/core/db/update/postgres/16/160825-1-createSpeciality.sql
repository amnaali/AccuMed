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
);
