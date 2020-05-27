CREATE TABLE `class` (
  `id` bigint(20) NOT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `profession_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1253978896370528257', '信息管理与信息系统1班', '1253978896336973825');
INSERT INTO `class` VALUES ('1253978896395694082', '信息管理与信息系统2班', '1253978896336973825');
INSERT INTO `class` VALUES ('1253979323161931778', '计算机1班', '1253979323136765953');
INSERT INTO `class` VALUES ('1253979323170320385', '计算机2班', '1253979323136765953');
INSERT INTO `class` VALUES ('1254433213238038530', '会计1班', '1254433213208678402');
INSERT INTO `class` VALUES ('1254433213259010050', '会计2班', '1254433213208678402');
INSERT INTO `class` VALUES ('1254785260277837825', '三十三1班', '1254785260244283394');
INSERT INTO `class` VALUES ('1254785260298809346', '三十三2班', '1254785260244283394');
