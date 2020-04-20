CREATE TABLE tbl_user
(
	user_id BIGINT(20) NOT NULL COMMENT '主键ID',
	user_name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	user_age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	PRIMARY KEY (user_id)
) charset = utf8;