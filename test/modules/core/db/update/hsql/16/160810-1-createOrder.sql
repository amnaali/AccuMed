create table TEST_ORDER (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ timestamp not null,
    AMOUNT decimal(19, 2) not null,
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
);
