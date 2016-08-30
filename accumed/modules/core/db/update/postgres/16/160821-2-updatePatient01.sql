update ACCUMED_PATIENT set VERSION = 0 where VERSION is null ;
alter table ACCUMED_PATIENT alter column VERSION set not null ;
