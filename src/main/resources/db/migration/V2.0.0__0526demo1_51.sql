CREATE TABLE `bonus_record` (
  `id` bigint(20) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  `year` int(255) DEFAULT NULL,
  `semester` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bonus_record
-- ----------------------------
INSERT INTO `bonus_record` VALUES ('1255870956245680130', '1254046663488663554', '创新创业', '10', 'ceshi', '1254042689511411714', '2015', '1');
INSERT INTO `bonus_record` VALUES ('1256063030580494338', '1255438094837010433', '社团活动', '10', '少时诵诗书', '1254042689511411714', '2016', '1');
