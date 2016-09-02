alter table ACCUMED_PROVIDER add column MINISTRY_OF_HEALTH_OFFICE varchar(5) ;
alter table ACCUMED_PROVIDER drop column MINISTRY_OF_HEALTH_OFFICE_ID cascade ;
