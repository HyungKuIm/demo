insert into employee
    (no, birthday, first_name, last_name, mail_address, sex)
values
        (nextval(emp_no_seq), '1984-09-05', '송이', '한', 'han@kgc.com', 'female');

insert into employee
(no, birthday, first_name, last_name, mail_address, sex)
values
    (nextval(emp_no_seq), '1994-10-17', '소영', '이', 'leesy@kgc.com', 'female');

insert into employee
(no, birthday, first_name, last_name, mail_address, sex)
values
    (nextval(emp_no_seq), null, '은진', '박', null, 'female');

insert into employee
(no, birthday, first_name, last_name, mail_address, sex)
values
    (nextval(emp_no_seq), null, '예솔', '이', null, 'female');

insert into authentication (id, password, valid_date, employee_no)
values
    ('songi', '1234', '2029-12-31', 1);

insert into authentication (id, password, valid_date, employee_no)
values
    ('sylee', '1234', '2029-12-31', 2);
insert into authentication (id, password, valid_date, employee_no)
values
    ('ejpark', '1234', '2029-12-31', 3);
insert into authentication (id, password, valid_date, employee_no)
values
    ('yslee', '1234', '2029-12-31', 4);

insert into authorization (role,name) values ('admin', '관리자');
insert into authorization (role,name) values ('staff', '중간관리자');
insert into authorization (role,name) values ('user', '일반사용자');

insert into employee_authorization (employee_no, authorization_role) values (1, 'admin');
insert into employee_authorization (employee_no, authorization_role) values (1, 'staff');
insert into employee_authorization (employee_no, authorization_role) values (2, 'staff');
insert into employee_authorization (employee_no, authorization_role) values (3, 'user');
insert into employee_authorization (employee_no, authorization_role) values (4, 'user');