
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `role_permission`;
DROP TABLE IF EXISTS `permission`;

CREATE TABLE `user` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`useremail` varchar(255) NULL DEFAULT NULL COMMENT '邮箱',
`status` int DEFAULT NULL,
`code` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `role` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `user_role` (
`user_id` bigint(11) NOT NULL,
`role_id` bigint(11) NOT NULL
);
CREATE TABLE `role_permission` (
`role_id` bigint(11) NOT NULL,
`permission_id` bigint(11) NOT NULL
);
CREATE TABLE `permission` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`url` varchar(255) NOT NULL,
`name` varchar(255) NOT NULL,
`description` varchar(255) NULL,
`pid` bigint(11) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `book` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`book_Name` varchar(255) NOT NULL,
`author` varchar(255) NOT NULL,
`price` decimal(8,2) NULL,
`publish_Time` Datetime NULL DEFAULT NULL COMMENT '出版时间',
`update_Time` Datetime NULL DEFAULT NULL COMMENT '修改时间',
`booksize` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);


CREATE TABLE `shopping_cat` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`quantity` INT(11) NOT NULL,
`book_Id` BIGINT(20) NOT NULL,
`user_Id` BIGINT(20) NULL,
PRIMARY KEY (`id`)
);


INSERT INTO user (id, username, password) VALUES (1,'user','202cb962ac59075b964b07152d234b70');
INSERT INTO user (id, username , password) VALUES (2,'admin','202cb962ac59075b964b07152d234b70');
INSERT INTO role (id, name) VALUES (1,'USER');
INSERT INTO role (id, name) VALUES (2,'ADMIN');
INSERT INTO permission (id, url, name, pid) VALUES (1,'/user/common','common',0);
INSERT INTO permission (id, url, name, pid) VALUES (2,'/user/admin','admin',0);
INSERT INTO permission (id, url, name, pid) VALUES (3,'/user/registerUser','registerUser',0);
INSERT INTO permission (id, url, name, pid) VALUES (4,'/user/checkCode','checkCode',0);
INSERT INTO permission (id, url, name, pid) VALUES (5,'/user/admin','admin',0);
INSERT INTO permission (id, url, name, pid) VALUES (6,'/user/admin','admin',0);
INSERT INTO permission (id, url, name, pid) VALUES (7,'/book/save','admin',0);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 2);