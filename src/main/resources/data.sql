insert into LABEL
values ('10001', '1', 'Family');

insert into LABEL
values ('10002', '2', 'Colleague');

insert into LABEL
values ('10003', '3', 'Classmate');

insert into CONTACT
values ('20001', 'Meqdad', 'Khamehyar', null);

insert into CONTACT
values ('20002', 'Mahdi', 'Khamehyar', null);

insert into CONTACT
values ('20003', 'Amin', 'Khamehyar', null);

insert into CONTACT
values ('20004', 'Hossein', 'Hosseini', null);

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

insert into ENTRY
values ('30006', 'HomeFax', '02155667788', '20004');

insert into LABEL_CONTACT
values (20001, 10002);

insert into LABEL_CONTACT
values (20001, 10003);

insert into LABEL_CONTACT
values (20003, 10002);
