/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 05/07/2018 17:13:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES (1, 'Jack2', NULL, 5);
INSERT INTO `employees` VALUES (2, 'AA', 'aa@atguigu.com', 1);
INSERT INTO `employees` VALUES (3, 'BB', 'bb@atguigu.com', 2);
INSERT INTO `employees` VALUES (4, 'CC', 'cc@atguigu.com', 3);
INSERT INTO `employees` VALUES (5, 'DD', 'dd@atguigu.com', 3);
INSERT INTO `employees` VALUES (6, 'EE', 'ee@atguigu.com', 2);
INSERT INTO `employees` VALUES (7, 'XYZ', 'xyz@sina.com', 3);
INSERT INTO `employees` VALUES (8, 'Jack', NULL, 5);
INSERT INTO `employees` VALUES (9, 'Jack', NULL, 5);

SET FOREIGN_KEY_CHECKS = 1;
