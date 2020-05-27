-- ----------------------------
-- Table structure for book
-- ----------------------------

CREATE TABLE IF NOT EXISTS `book`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `book_Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(8, 2) NULL DEFAULT NULL,
  `publish_Time` datetime(0) NULL DEFAULT NULL COMMENT '出版时间',
  `update_Time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `booksize` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `smallImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (20, '三国演义', '罗贯中', 15.00, '2019-05-05 00:00:00', '2020-05-18 05:49:11', '2', NULL);
INSERT INTO `book` VALUES (21, 'SHUIH', '123', 1.00, NULL, '2020-05-24 07:39:47', '1', NULL);







-- ----------------------------
-- Table structure for permission
-- ----------------------------
CREATE TABLE IF NOT EXISTS `permission`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` bigint(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '/user/common', 'common', NULL, 0);
INSERT INTO `permission` VALUES (2, '/user/admin', 'admin', NULL, 0);
INSERT INTO `permission` VALUES (3, '/book/save', 'admin', NULL, 0);
INSERT INTO `permission` VALUES (4, '/Shopping', 'admin', NULL, 0);
INSERT INTO `permission` VALUES (5, '/user', 'admin', NULL, 0);
INSERT INTO `permission` VALUES (6, '/book/delete', 'admin', NULL, 0);
INSERT INTO `permission` VALUES (7, '/user/loginUser', 'admin', NULL, 0);
INSERT INTO `permission` VALUES (8, '/login', 'admin', NULL, 0);







-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE IF NOT EXISTS `role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'USER');
INSERT INTO `role` VALUES (2, 'ADMIN');





-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
CREATE TABLE IF NOT EXISTS `role_permission`  (
  `role_id` bigint(11) NOT NULL,
  `permission_id` bigint(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (2, 1);
INSERT INTO `role_permission` VALUES (2, 2);
INSERT INTO `role_permission` VALUES (2, 3);





-- ----------------------------
-- Table structure for shopping_cat
-- ----------------------------
CREATE TABLE IF NOT EXISTS `shopping_cat`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `book_id` bigint(20) NOT NULL,
  `num` int(20) NULL DEFAULT NULL COMMENT '数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_cat
-- ----------------------------
INSERT INTO `shopping_cat` VALUES (1, 2, 21, 1, 1.00);
INSERT INTO `shopping_cat` VALUES (2, 2, 20, 1, 1.00);




-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE IF NOT EXISTS `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `useremail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user', '202cb962ac59075b964b07152d234b70', '1551949453@qq.com', 0, NULL, NULL);
INSERT INTO `user` VALUES (2, 'admin', '202cb962ac59075b964b07152d234b70', '1551949453@qq.com', 0, NULL, NULL);
INSERT INTO `user` VALUES (3, 'zs', '202cb962ac59075b964b07152d234b70', '1551949453@qq.com', 0, NULL, NULL);
INSERT INTO `user` VALUES (4, 'ww', '202cb962ac59075b964b07152d234b70', '1551949453@qq.com', 0, NULL, NULL);



CREATE TABLE IF NOT EXISTS `user_role`  (
  `user_id` bigint(11) NOT NULL,
  `role_id` bigint(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 1);
INSERT INTO `user_role` VALUES (2, 2);
