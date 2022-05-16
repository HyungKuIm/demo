insert into employee
    (no, birthday, first_name, last_name, mail_address, sex)
values
        (nextval(emp_no_seq), '1990-01-31', '타니', '오', 'otani@angels.com', 'male');

insert into employee
(no, birthday, first_name, last_name, mail_address, sex)
values
    (nextval(emp_no_seq), '1985-02-10', '태용', '신', 'shin@indonesia.com', 'male');

insert into employee
(no, birthday, first_name, last_name, mail_address, sex)
values
    (nextval(emp_no_seq), null, '은진', '박', null, 'female');