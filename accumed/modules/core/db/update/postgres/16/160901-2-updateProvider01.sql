alter table ACCUMED_PROVIDER drop column GROUP_NUMBER cascade ;
alter table ACCUMED_PROVIDER add column GROUP_NUMBER varchar(10) ;
