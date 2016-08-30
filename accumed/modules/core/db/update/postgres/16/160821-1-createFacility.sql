create table ACCUMED_FACILITY (
    ID bigint,
    UUID uuid not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    --
    FACILITY_CODE varchar(20),
    FACILITY_NAME varchar(255),
    --
    primary key (ID)
);
