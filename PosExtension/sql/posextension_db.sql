# 数据库 
#创建数据库
DROP DATABASE IF EXISTS posextension_db;
CREATE DATABASE posextension_db;

#使用数据库 
use posextension_db;
#渠道
CREATE TABLE channel_tb(
channel_id int(11) NOT NULL AUTO_INCREMENT COMMENT '渠道id',
name varchar(255) COMMENT '渠道名称',
url varchar(255) COMMENT '渠道url',
salt varchar(255) COMMENT '盐',
fill_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '填写时间',
PRIMARY KEY (channel_id),
INDEX idx_fill_time (fill_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='渠道表';
#创建用户表 
CREATE TABLE user_tb(
user_id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
name varchar(255) COMMENT '用户名',
phone varchar(255) COMMENT '手机号',
password varchar(255) COMMENT '密码',
phone_code varchar(255) COMMENT '验证码',
address varchar(255) COMMENT '联系地址',
remark longtext  COMMENT '备注',
fill_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '填写时间',
channel_id int(11) COMMENT '渠道id，外键',
PRIMARY KEY (user_id),
CONSTRAINT FK_CHANNEL_USER FOREIGN KEY (channel_id) REFERENCES channel_tb (channel_id),
INDEX idx_channel_id (channel_id) USING BTREE,
INDEX idx_fill_time (fill_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';
#创建管理员表
CREATE TABLE admin_tb(
admin_id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
name varchar(255) COMMENT '账户名',
password varchar(255) COMMENT '密码',
update_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
PRIMARY KEY (admin_id),
INDEX idx_update_time (update_time) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='管理表';
