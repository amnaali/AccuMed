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
    SERVICE_CODE varchar(255),
    DIAGNOSTIC_CODE varchar(255),
    NO_OF_SERVICES integer,
    FEE double precision,
    SERVICE_DATE date,
    --
    primary key (ID)
);
