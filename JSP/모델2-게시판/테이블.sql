create table board(
num NUMBER not null primary key , --�Խ��� �� ��ȣ
writer varchar2(10) not null, -- �ۼ��� (ȸ�� ���̵�)
email varchar2(30), -- �̸���
subject varchar2(50) not null,-- ������
passwd varchar2(12) not null,--��й�ȣ
reg_date timestamp(6) not null,--�ۼ���
readcount NUMBER default 0,--��ȸ��
ref NUMBER not null,-- �� �׷� ��ȣ, ���� �� ����, ���
re_step NUMBER not null, -- ���� �׷쿡�� �� ��� ����
re_level NUMBER not null, -- ��� ���� - �鿩���� ���� 
content varchar2(4000) not null, -- �� ����
ip varchar(20) not null -- �ۼ��� ������
);

create SEQUENCE board_seq; --�ڵ����� �Ϸù�ȣ�� ��������

select * from board

