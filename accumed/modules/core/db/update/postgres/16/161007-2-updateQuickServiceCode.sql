update ACCUMED_QUICK_SERVICE_CODE set QUICK_CODE = '' where QUICK_CODE is null ;
alter table ACCUMED_QUICK_SERVICE_CODE alter column QUICK_CODE set not null ;
