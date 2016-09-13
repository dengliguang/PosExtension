# ���ݿ� 
#�������ݿ�
DROP DATABASE IF EXISTS posextension_db;
CREATE DATABASE posextension_db;

#ʹ�����ݿ� 
use posextension_db;
#����
CREATE TABLE channel_tb(
channel_id int(11) NOT NULL AUTO_INCREMENT COMMENT '����id',
name varchar(255) COMMENT '��������',
url varchar(255) COMMENT '����url',
salt varchar(255) COMMENT '��',
fill_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '��дʱ��',
PRIMARY KEY (channel_id),
INDEX idx_fill_time (fill_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='������';
#�����û��� 
CREATE TABLE user_tb(
user_id int(11) NOT NULL AUTO_INCREMENT COMMENT '�û�id',
name varchar(255) COMMENT '�û���',
phone varchar(255) COMMENT '�ֻ���',
password varchar(255) COMMENT '����',
phone_code varchar(255) COMMENT '��֤��',
address varchar(255) COMMENT '��ϵ��ַ',
remark longtext  COMMENT '��ע',
fill_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '��дʱ��',
channel_id int(11) COMMENT '����id�����',
PRIMARY KEY (user_id),
CONSTRAINT FK_CHANNEL_USER FOREIGN KEY (channel_id) REFERENCES channel_tb (channel_id),
INDEX idx_channel_id (channel_id) USING BTREE,
INDEX idx_fill_time (fill_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='�û���';
#��������Ա��
CREATE TABLE admin_tb(
admin_id int(11) NOT NULL AUTO_INCREMENT COMMENT '�û�id',
name varchar(255) COMMENT '�˻���',
password varchar(255) COMMENT '����',
update_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '��¼ʱ��',
PRIMARY KEY (admin_id),
INDEX idx_update_time (update_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='�����';
