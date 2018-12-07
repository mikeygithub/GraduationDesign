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

 Date: 07/12/2018 14:59:18
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
  `admin_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_admin
-- ----------------------------
INSERT INTO `des_admin` VALUES (1, 'admin', 1, 'admin', NULL);

-- ----------------------------
-- Table structure for des_design
-- ----------------------------
DROP TABLE IF EXISTS `des_design`;
CREATE TABLE `des_design`  (
  `design_id` int(11) NOT NULL,
  `design_of_teacher` int(11) NULL DEFAULT NULL,
  `design_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `design_num` int(11) NULL DEFAULT NULL,
  `design_require` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`design_id`) USING BTREE,
  INDEX `des_design_ibfk_1`(`design_of_teacher`) USING BTREE,
  CONSTRAINT `des_design_ibfk_1` FOREIGN KEY (`design_of_teacher`) REFERENCES `des_teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_design
-- ----------------------------
INSERT INTO `des_design` VALUES (1, 1, '图书馆后台管理系统', 20, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (2, 2, '毕业设计选题系统', 50, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (3, 3, '食堂在线订餐系统', 50, '暂无');
INSERT INTO `des_design` VALUES (4, 4, '算法图形演示系统', 50, '暂无');
INSERT INTO `des_design` VALUES (5, 5, '二手交易平台系统', 20, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (6, 6, '网上在线商城系统', 50, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (7, 1, '时实在线聊天系统', 50, '暂无');
INSERT INTO `des_design` VALUES (8, 2, '淘淘乐商城系统', 50, '暂无');
INSERT INTO `des_design` VALUES (9, 3, '闲置车位租赁系统', 20, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (10, 4, '在线考勤点名系统', 50, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (11, 5, '在线编程练习系统', 50, '暂无');
INSERT INTO `des_design` VALUES (12, 6, '英语听力练习系统', 50, '暂无');
INSERT INTO `des_design` VALUES (13, 1, '图书馆后台管理系统', 20, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (14, 2, '毕业设计选题系统', 50, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (15, 3, '食堂在线订餐系统', 50, '暂无');
INSERT INTO `des_design` VALUES (16, 4, '算法图形演示系统', 50, '暂无');
INSERT INTO `des_design` VALUES (17, 5, '二手交易平台系统', 20, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (18, 6, '网上在线商城系统', 50, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (19, 1, '时实在线聊天系统', 50, '暂无');
INSERT INTO `des_design` VALUES (20, 2, '淘淘乐商城系统', 50, '暂无');
INSERT INTO `des_design` VALUES (21, 3, '闲置车位租赁系统', 20, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (22, 4, '在线考勤点名系统', 50, 'Swing + MySQL。在实现过程中，需利用面向对象程序设计理论的基础知识，充分体现出Java语言关于类、继承、封装与多态等核心概念，每一个类应包含数据成员和成员函数。');
INSERT INTO `des_design` VALUES (23, 5, '在线编程练习系统', 50, '暂无');
INSERT INTO `des_design` VALUES (24, 6, '英语听力练习系统', 50, '暂无');

-- ----------------------------
-- Table structure for des_student
-- ----------------------------
DROP TABLE IF EXISTS `des_student`;
CREATE TABLE `des_student`  (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_sex` int(11) NULL DEFAULT 0 COMMENT '0:未知，1：男。2：女',
  `student_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456',
  `student_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_student
-- ----------------------------
INSERT INTO `des_student` VALUES (1, 'mikey', 0, '222222', '18296297824');
INSERT INTO `des_student` VALUES (2, '2', 1, '2', '18299482842');
INSERT INTO `des_student` VALUES (3, '3', 1, '3', '18299482843');
INSERT INTO `des_student` VALUES (4, '4', 0, '4', '18299482844');
INSERT INTO `des_student` VALUES (5, '5', 0, '5', '18299482845');
INSERT INTO `des_student` VALUES (6, '6', 1, '6', '18299482846');
INSERT INTO `des_student` VALUES (7, '7', 1, '7', '18299482847');
INSERT INTO `des_student` VALUES (8, '8', 0, '8', '18299482848');
INSERT INTO `des_student` VALUES (9, '9', 0, '9', '18299482849');
INSERT INTO `des_student` VALUES (10, '10', 1, '10', '18299485541');

-- ----------------------------
-- Table structure for des_teacher
-- ----------------------------
DROP TABLE IF EXISTS `des_teacher`;
CREATE TABLE `des_teacher`  (
  `teacher_id` int(11) NOT NULL,
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_sex` int(11) NULL DEFAULT 0,
  `teacher_info` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456',
  `teacher_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_teacher
-- ----------------------------
INSERT INTO `des_teacher` VALUES (1, '李老师', 1, '教师信息简介，', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (2, '冀老师', 1, '教师信息简介', 'teacher', '18358464856');
INSERT INTO `des_teacher` VALUES (3, '王老师', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (4, '晓老师', 0, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (5, '陈老师', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (6, '张老师', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (7, '7', 1, '教师信息简介，', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (8, '8', 1, '教师信息简介', 'teacher', '18358464856');
INSERT INTO `des_teacher` VALUES (9, '9', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (10, '10', 0, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (11, '11', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (12, '12', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (13, '13', 0, '教师信息简介', '123456', '18276297822');
INSERT INTO `des_teacher` VALUES (14, '14', 0, '教师信息简介', '123456', '18276297822');
INSERT INTO `des_teacher` VALUES (15, '15', 0, '教师信息简介', '123456', '18276297822');
INSERT INTO `des_teacher` VALUES (16, '16', 0, '教师信息简介', '123456', '18276297822');
INSERT INTO `des_teacher` VALUES (17, '17', 1, '教师信息简介，', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (18, '18', 1, '教师信息简介', 'teacher', '18358464856');
INSERT INTO `des_teacher` VALUES (19, '19', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (20, '20', 0, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (21, '21', 1, '教师信息简介', 'teacher', '18276297822');
INSERT INTO `des_teacher` VALUES (22, '22', 1, '教师信息简介', 'teacher', '18276297822');

-- ----------------------------
-- Table structure for des_title_of_student
-- ----------------------------
DROP TABLE IF EXISTS `des_title_of_student`;
CREATE TABLE `des_title_of_student`  (
  `des_of_stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `des_of_stu` int(11) NOT NULL COMMENT '学生外键',
  `des_of_title` int(11) NULL DEFAULT NULL COMMENT '课设外键',
  `des_state` int(11) NULL DEFAULT 0 COMMENT '录取状态：0.待录取，1.已经录取，2未录取',
  `des_wish_order` int(11) NULL DEFAULT NULL COMMENT '志愿类型：0.第一志愿，1，第二志愿',
  PRIMARY KEY (`des_of_stu_id`) USING BTREE,
  INDEX `des_of_stu`(`des_of_stu`) USING BTREE,
  INDEX `des_of_title`(`des_of_title`) USING BTREE,
  CONSTRAINT `des_title_of_student_ibfk_1` FOREIGN KEY (`des_of_stu`) REFERENCES `des_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `des_title_of_student_ibfk_2` FOREIGN KEY (`des_of_title`) REFERENCES `des_design` (`design_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of des_title_of_student
-- ----------------------------
INSERT INTO `des_title_of_student` VALUES (11, 1, 10, 1, 0);
INSERT INTO `des_title_of_student` VALUES (12, 1, 2, 0, 1);
INSERT INTO `des_title_of_student` VALUES (15, 2, 9, 0, 0);
INSERT INTO `des_title_of_student` VALUES (16, 2, 12, 0, 1);
INSERT INTO `des_title_of_student` VALUES (17, 3, 11, 0, 0);
INSERT INTO `des_title_of_student` VALUES (18, 3, 7, 0, 1);
INSERT INTO `des_title_of_student` VALUES (19, 4, 4, 0, 0);
INSERT INTO `des_title_of_student` VALUES (20, 4, 5, 0, 1);
INSERT INTO `des_title_of_student` VALUES (21, 5, 10, 0, 0);
INSERT INTO `des_title_of_student` VALUES (22, 5, 4, 0, 1);
INSERT INTO `des_title_of_student` VALUES (23, 6, 9, 0, 0);
INSERT INTO `des_title_of_student` VALUES (24, 6, 10, 0, 1);
INSERT INTO `des_title_of_student` VALUES (25, 7, 4, 0, 0);
INSERT INTO `des_title_of_student` VALUES (26, 7, 6, 0, 1);

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
