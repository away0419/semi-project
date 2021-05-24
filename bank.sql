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
--select * from deal;
--update account set price=10000000
--where accountno=1000000000003;

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
		
        
insert into bankuser values(bankuser_seq.nextval,'ddd','ddd','������',1000000000000,'000-0000-0000',null,default);
insert into account values(account_seq.nextval,0000,1000000,1,1,default);

commit;
