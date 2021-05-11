create table bankuser(
    seq number primary key,
    id varchar2(20) unique not null,
    pwd varchar2(20) not null,
    joindate date default sysdate
);

create sequence bankuser_seq
start with 1
increment by 1
nocache;

insert into bankuser values(bankuser_seq.nextval,'admin','admin',default);
select * from bankuser;

drop table bankuser;
drop sequence bankuser_seq;
---------------

create table bankaccount(
    account number primary key,
    user_seq number references bankuser(seq),
    pwd number(4) not null,
    balance number default 0,
    makedate date default sysdate
);

drop table bankaccount;
drop sequence account_seq;
create sequence account_seq
start with 1111111111111
increment by 1
nocache;


insert into bankaccount values(account_seq.nextval,2,5555,default,default);
select * from bankaccount;
