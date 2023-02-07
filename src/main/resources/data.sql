insert into LABEL
values ('10001', '1', 'Family');

insert into LABEL
values ('10002', '2', 'Colleague');

insert into LABEL
values ('10003', '3', 'Classmate');

insert into CONTACT (ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CREATED_DATE, LAST_MODIFIED_DATE)
values ('20001', 'Meqdad', null, 'Khamehyar', current_timestamp, current_timestamp);

insert into CONTACT (ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CREATED_DATE, LAST_MODIFIED_DATE)
values ('20002', 'Mahdi', null, 'Khamehyar', current_timestamp, current_timestamp);

insert into CONTACT (ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CREATED_DATE, LAST_MODIFIED_DATE)
values ('20003', 'Amin', null, 'Khamehyar', current_timestamp, current_timestamp);

insert into CONTACT (ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, CREATED_DATE, LAST_MODIFIED_DATE)
values ('20004', 'Hossein', 'Ali', 'Hosseini', current_timestamp, current_timestamp);

insert into ENTRY
values ('30001', 'Mobile', '09123456789', '20001');

insert into ENTRY
values ('30002', 'Home', '02112345678', '20001');

insert into ENTRY
    values ('30003', 'Mobile', '09334567890', '20002');

insert into ENTRY
values ('30004', 'Work', '02123456789', '20002');

insert into ENTRY
values ('30005', 'Mobile', '09919876543', '20003');

/*insert into ENTRY
values ('30006', 'HomeFax', '02155667788', '20004');*/

insert into CONTACT_LABEL
values (20001, 10002);

insert into CONTACT_LABEL
values (20001, 10003);

insert into CONTACT_LABEL
values (20003, 10002);
