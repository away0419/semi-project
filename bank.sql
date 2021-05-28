/* ����� */

drop table account;
drop table bankuser cascade constraints;
drop table deal;
drop table accounttype;
drop sequence bankuser_seq;
drop sequence deal_seq;
drop sequence accounttype_seq;
drop sequence account_seq;
--select * from bankuser;
--select * from account;
--select * from account where userno=1;
--select * from accounttype;
--select * from deal order by dealdate desc;
--select * from deal where sendaccount=1000000000003 or takeaccount=1000000000003 order by dealdate desc;

CREATE TABLE bankuser (
	userNo NUMBER NOT NULL, /* ����ڹ�ȣ */
	userId VARCHAR2(20) UNIQUE NOT NULL, /* ���̵� */
	userpwd VARCHAR2(20) NOT NULL, /* ��й�ȣ */
	username VARCHAR2(20) NOT NULL, /* �̸� */
	jumin NUMBER UNIQUE NOT NULL, /* �ֹι�ȣ */
	tel VARCHAR2(20) NOT NULL, /* ��ȭ��ȣ */
	email VARCHAR2(30), /* �̸��� */
	joindate DATE DEFAULT sysdate NOT NULL /* ���Գ�¥ */
);


create sequence bankuser_seq
start with 1
increment by 1
nocache;

CREATE UNIQUE INDEX PK_bankuser
	ON bankuser (
		userNo ASC
	);

ALTER TABLE bankuser
	ADD
		CONSTRAINT PK_bankuser
		PRIMARY KEY (
			userNo
		);

/* ���� */
CREATE TABLE account (
	accountno NUMBER NOT NULL, /* ���¹�ȣ */
	acpwd NUMBER NOT NULL, /* ��й�ȣ */
	price NUMBER DEFAULT 0 NOT NULL, /* �ݾ� */
	typeno NUMBER NOT NULL, /* ������ȣ */
	userNo NUMBER NOT NULL, /* ����ڹ�ȣ */
	makedate DATE DEFAULT sysdate NOT NULL /* ������¥ */
);

create sequence account_seq
start with 1000000000000
increment by 1
nocache;

CREATE UNIQUE INDEX PK_account
	ON account (
		accountno ASC
	);

ALTER TABLE account
	ADD
		CONSTRAINT PK_account
		PRIMARY KEY (
			accountno
		);

/* �������� */
CREATE TABLE accounttype (
	typeno NUMBER NOT NULL, /* ������ȣ */
	typename VARCHAR2(20) UNIQUE NOT NULL, /* ���¸� */
	interest NUMBER DEFAULT 0 /* �������� */
);


create sequence accounttype_seq
start with 1
increment by 1
nocache;

CREATE UNIQUE INDEX PK_accounttype
	ON accounttype (
		typeno ASC
	);

ALTER TABLE accounttype
	ADD
		CONSTRAINT PK_accounttype
		PRIMARY KEY (
			typeno
		);
		
insert into accounttype values(accounttype_seq.nextval,'�Ϲݰ���',1);
insert into accounttype values(accounttype_seq.nextval,'�ſ����',2);
insert into accounttype values(accounttype_seq.nextval,'���ݰ���',3);


/* �ŷ����� */
CREATE TABLE deal (
	dealNo NUMBER NOT NULL, /* �ŷ���ȣ */
	sendAccount NUMBER, /* �������� */
	takeAccount NUMBER, /* �������� */
	sendPrice NUMBER DEFAULT 0, /* �����ݾ� */
	takePrice NUMBER DEFAULT 0, /* �����ݾ� */
	sendUser VARCHAR2(20) NOT NULL, /* ������� */
	takeUser VARCHAR2(20) NOT NULL, /* ������� */
	dealdate DATE DEFAULT sysdate NOT NULL /* �ŷ���¥ */
);

create sequence deal_seq
start with 1
increment by 1
nocache;

CREATE UNIQUE INDEX PK_deal
	ON deal (
		dealNo ASC
	);

ALTER TABLE deal
	ADD
		CONSTRAINT PK_deal
		PRIMARY KEY (
			dealNo
		);

ALTER TABLE account
	ADD
		CONSTRAINT FK_accounttype_TO_account
		FOREIGN KEY (
			typeno
		)
		REFERENCES accounttype (
			typeno
		);

ALTER TABLE account
	ADD
		CONSTRAINT FK_bankuser_TO_account
		FOREIGN KEY (
			userNo
		)
		REFERENCES bankuser (
			userNo
		);
		
        
insert into bankuser values(bankuser_seq.nextval,'admin','admin','admin',0000000000000,'000-0000-0000',null,'20000101');
insert into account values(account_seq.nextval,1111,1000000,1,1,'20000101');

insert into bankuser values(bankuser_seq.nextval,'aaa','aaa','ȫ�浿',9504051000212,'010-1111-1111',null,'20000101');
insert into account values(account_seq.nextval,1111,1000000,1,2,'20000101');
insert into account values(account_seq.nextval,1111,1000000,1,2,'20000101');
insert into account values(account_seq.nextval,1111,1000000,1,2,'20000101');
insert into account values(account_seq.nextval,1111,1000000,1,2,'20000101');
insert into account values(account_seq.nextval,1111,1000000,1,2,'20000101');

insert into deal values(deal_seq.nextval,1000000000000,1000000000001,1000,1000,'admin','ȫ�浿','20020520');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20020521');
insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'ȫ�浿','admin','20020522');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20020523');
insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'ȫ�浿','admin','20020524');

insert into deal values(deal_seq.nextval,1000000000000,1000000000001,1000,1000,'admin','ȫ�浿','20210520');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20210521');
insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'ȫ�浿','admin','20210522');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20210523');
insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'ȫ�浿','admin','20210524');
insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'ȫ�浿','admin','20210524');
insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'ȫ�浿','admin','20210524');
insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'admin','ȫ�浿','20210524');


insert into deal values(deal_seq.nextval,1000000000001,1000000000000,1000,1000,'ȫ�浿','admin','20210424');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20210423');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20210523');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20210523');
insert into deal values(deal_seq.nextval,1000000000000,1000000000001,2000,2000,'admin','ȫ�浿','20210524');

--select * from account;
commit;
