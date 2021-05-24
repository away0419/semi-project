/* 사용자 */

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
	userNo NUMBER NOT NULL, /* 사용자번호 */
	userId VARCHAR2(20) UNIQUE NOT NULL, /* 아이디 */
	userpwd VARCHAR2(20) NOT NULL, /* 비밀번호 */
	username VARCHAR2(20) NOT NULL, /* 이름 */
	jumin NUMBER UNIQUE NOT NULL, /* 주민번호 */
	tel VARCHAR2(20) NOT NULL, /* 전화번호 */
	email VARCHAR2(30), /* 이메일 */
	joindate DATE DEFAULT sysdate NOT NULL /* 가입날짜 */
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

/* 계좌 */
CREATE TABLE account (
	accountno NUMBER NOT NULL, /* 계좌번호 */
	acpwd NUMBER NOT NULL, /* 비밀번호 */
	price NUMBER DEFAULT 0 NOT NULL, /* 금액 */
	typeno NUMBER NOT NULL, /* 종류번호 */
	userNo NUMBER NOT NULL, /* 사용자번호 */
	makedate DATE DEFAULT sysdate NOT NULL /* 개설날짜 */
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

/* 계좌종류 */
CREATE TABLE accounttype (
	typeno NUMBER NOT NULL, /* 종류번호 */
	typename VARCHAR2(20) UNIQUE NOT NULL, /* 계좌명 */
	interest NUMBER DEFAULT 0 /* 연간이율 */
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
		
insert into accounttype values(accounttype_seq.nextval,'일반계좌',1);
insert into accounttype values(accounttype_seq.nextval,'신용계좌',2);
insert into accounttype values(accounttype_seq.nextval,'적금계좌',3);


/* 거래내역 */
CREATE TABLE deal (
	dealNo NUMBER NOT NULL, /* 거래번호 */
	sendAccount NUMBER, /* 보낸계좌 */
	takeAccount NUMBER, /* 받은계좌 */
	sendPrice NUMBER DEFAULT 0, /* 보낸금액 */
	takePrice NUMBER DEFAULT 0, /* 받은금액 */
	sendUser VARCHAR2(20) NOT NULL, /* 보낸사람 */
	takeUser VARCHAR2(20) NOT NULL, /* 받은사람 */
	dealdate DATE DEFAULT sysdate NOT NULL /* 거래날짜 */
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
		
        
insert into bankuser values(bankuser_seq.nextval,'ddd','ddd','관리자',1000000000000,'000-0000-0000',null,default);
insert into account values(account_seq.nextval,0000,1000000,1,1,default);

commit;
