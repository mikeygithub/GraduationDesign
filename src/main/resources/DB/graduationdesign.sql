/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : graduationdesign

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 28/11/2018 14:56:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for des_admin
-- ----------------------------
DROP TABLE IF EXISTS `des_admin`;
CREATE TABLE `des_admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_sex` int(11) NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_admin
-- ----------------------------
INSERT INTO `des_admin` VALUES (1, 'admin', 1, 'admin');

-- ----------------------------
-- Table structure for des_design
-- ----------------------------
DROP TABLE IF EXISTS `des_design`;
CREATE TABLE `des_design`  (
  `design_id` int(11) NOT NULL,
  `design_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `design_num` int(11) NULL DEFAULT NULL,
  `design_require` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`design_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_design
-- ----------------------------
INSERT INTO `des_design` VALUES (1, 'java程序设计', 20, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');

-- ----------------------------
-- Table structure for des_student
-- ----------------------------
DROP TABLE IF EXISTS `des_student`;
CREATE TABLE `des_student`  (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_sex` int(11) NULL DEFAULT 0 COMMENT '0:未知，1：男。2：女',
  `student_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_student
-- ----------------------------
INSERT INTO `des_student` VALUES (1, 'student', 1, 'student');

-- ----------------------------
-- Table structure for des_teacher
-- ----------------------------
DROP TABLE IF EXISTS `des_teacher`;
CREATE TABLE `des_teacher`  (
  `teacher_id` int(11) NOT NULL,
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_sex` int(11) NULL DEFAULT 0,
  `teacher_info` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_teacher
-- ----------------------------
INSERT INTO `des_teacher` VALUES (1, 'teacher', 1, '教师信息简介', 'teacher');

-- ----------------------------
-- Table structure for des_wish
-- ----------------------------
DROP TABLE IF EXISTS `des_wish`;
CREATE TABLE `des_wish`  (
  `wish_id` int(11) NOT NULL,
  `wish_fist` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wish_second` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`wish_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_wish
-- ----------------------------
INSERT INTO `des_wish` VALUES (1, 'java程序设计', '算法设计');

SET FOREIGN_KEY_CHECKS = 1;
