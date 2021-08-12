/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : integration

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 12/08/2021 18:28:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账户UUID',
  `account_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账户姓名',
  `account_sex` enum('男','女','未知') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '未知' COMMENT '账户性别',
  `account_age` int NOT NULL DEFAULT 18 COMMENT '账户年龄',
  `account_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '账户所在地',
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '张三', '男', 20, '上海');
INSERT INTO `account` VALUES ('2', '李四', '女', 18, '安徽');
INSERT INTO `account` VALUES ('3', '李四', '女', 18, '安徽');
INSERT INTO `account` VALUES ('4', '张三', '男', 20, '上海');
INSERT INTO `account` VALUES ('5', '张三', '男', 30, '上海');
INSERT INTO `account` VALUES ('6', '李四', '女', 48, '安徽');

SET FOREIGN_KEY_CHECKS = 1;
