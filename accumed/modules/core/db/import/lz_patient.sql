-- Create new columns
alter table lz_patient add column CREATE_TS timestamp ;
alter table lz_patient add column CREATED_BY varchar(50) ;
alter table lz_patient add column ID uuid not null default newid() ;
alter table lz_patient add constraint PK_lz_patient primary key (ID) ;
alter table lz_patient add column VERSION integer ;
alter table lz_patient add column UPDATE_TS timestamp ;
alter table lz_patient add column UPDATED_BY varchar(50) ;
alter table lz_patient add column DELETE_TS timestamp ;
alter table lz_patient add column DELETED_BY varchar(50) ;
update lz_patient set CREATE_TS = current_timestamp,
 CREATED_BY = 'import',
 VERSION = 0,
 UPDATE_TS = current_timestamp,
 UPDATED_BY = 'import' ;
