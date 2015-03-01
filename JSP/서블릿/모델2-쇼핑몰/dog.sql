CREATE TABLE dog(
id NUMBER PRIMARY KEY,
kind VARCHAR2(12),
price NUMBER,
image VARCHAR2(12),
country VARCHAR2(12),
height NUMBER,
weight NUMBER,
content VARCHAR2(200),
readcount NUMBER
)



CREATE SEQUENCE dog_seq;




insert into dog values (
	dog_seq.nextval,
	'Ǫ��',
	1000,
	'foo.jpg',
	'������',
	1,
	1,
	'Ǫ����',
	0
);

insert into dog values (
	dog_seq.nextval,
	'ǳ�갳',
	1500,
	'po.jpg',
	'�ѱ�',
	1,
	1,
	'ǳ�갳��',
	0
);

insert into dog values (
	dog_seq.nextval,
	'������',
	3000,
	'jin.jpg',
	'�ѱ�',
	1,
	1,
	'��������',
	0
);

insert into dog values (
	dog_seq.nextval,
	'��찳',
	5000,
	'sab.jpg',
	'����',
	1,
	1,
	'��찳��',
	0
);

insert into dog values (
	dog_seq.nextval,
	'��찳2',
	6000,
	'sab.jpg',
	'����',
	1,
	1,
	'��찳��',
	0
);

update dog set kind = '�ҵ�' where kind = '��찳2'