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
    PROPERTY_NAME varchar(255),
    RULE_CONDITION varchar(255),
    PROPERTY_VALUE varchar(255),
    SERVICE_CODE_ID uuid,
    --
    primary key (ID)
);
