alter table ACCUMED_MINISTRY_OF_HEALTH_OFFICE add column OFFICE_CITY varchar(100) not null default '' ;
alter table ACCUMED_MINISTRY_OF_HEALTH_OFFICE drop column OFFICE_NAME cascade ;
