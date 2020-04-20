Create Database If Not Exists demo Character Set UTF8;

CREATE TABLE IF NOT EXISTS demo.`user` (
(
	user_id BIGINT(20) NOT NULL COMMENT '主键ID',
	user_name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	user_age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='测试表';
