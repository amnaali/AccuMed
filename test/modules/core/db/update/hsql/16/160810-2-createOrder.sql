alter table TEST_ORDER add constraint FK_TEST_ORDER_CUSTOMER_ID foreign key (CUSTOMER_ID) references TEST_CUSTOMER(ID);
create index IDX_TEST_ORDER_CUSTOMER on TEST_ORDER (CUSTOMER_ID);
