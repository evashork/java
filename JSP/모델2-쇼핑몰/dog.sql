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
	'Çªµé',
	1000,
	'foo.jpg',
	'ÇÁ¶û½º',
	1,
	1,
	'ÇªµéÀº',
	0
);

insert into dog values (
	dog_seq.nextval,
	'Ç³»ê°³',
	1500,
	'po.jpg',
	'ÇÑ±¹',
	1,
	1,
	'Ç³»ê°³Àº',
	0
);

insert into dog values (
	dog_seq.nextval,
	'Áøµµ°³',
	3000,
	'jin.jpg',
	'ÇÑ±¹',
	1,
	1,
	'Áøµµ°³Àº',
	0
);

insert into dog values (
	dog_seq.nextval,
	'»ð»ì°³',
	5000,
	'sab.jpg',
	'ºÏÇÑ',
	1,
	1,
	'»ð»ì°³Àº',
	0
);

insert into dog values (
	dog_seq.nextval,
	'»ð»ì°³2',
	6000,
	'sab.jpg',
	'ºÏÇÑ',
	1,
	1,
	'»ð»ì°³Àº',
	0
);

update dog set kind = 'ºÒµ¶' where kind = '»ð»ì°³2'