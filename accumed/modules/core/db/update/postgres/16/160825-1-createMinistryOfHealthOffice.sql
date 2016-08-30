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
    OFFICE_NAME varchar(255) not null,
    CLAIM_CARD_CODE varchar(5),
    --
    primary key (ID)
);
