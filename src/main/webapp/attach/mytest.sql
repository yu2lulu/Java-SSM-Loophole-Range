/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 127.0.0.1:3306
 Source Schema         : mytest

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 24/06/2021 15:02:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Userinfo
-- ----------------------------
DROP TABLE IF EXISTS `Userinfo`;
CREATE TABLE `Userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Userinfo
-- ----------------------------
BEGIN;
INSERT INTO `Userinfo` VALUES (1, '张三', 19, '男', '123123');
INSERT INTO `Userinfo` VALUES (6, 'root', 12, '女', 'root');
COMMIT;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `author` varchar(255) DEFAULT NULL,
  `ctime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
BEGIN;
INSERT INTO `article` VALUES (1, '六月的雨', '　　那些装载过所有情节的季节，只有自己才可以去泅渡，并且，不被允许回头——题辞。微尘陌上\n\n1.\n\n六月，又是半夏渐浓时，烟雨于飞，又朦胧了一座浅浅的城。\n\n南国的那个村落，幽栖于水乡的僻静处，炊烟袅袅，檐下的燕子已是来归。\n\n我素衣简装，自你的身前行经，打马而过的瞬间，偶然侧目，依稀看见，你临雨顾影的样子，白衣轻绸一袭，如那年六月的莲花开落，是一种令人胆战心惊的美丽。\n\n在这个半夏幽栖的城，烟雨雨霖铃。\n\n燕子已归，六月的柳絮已飞。\n\n南国水乡，烟雨朦胧了一座城！\n\n2.\n\n你在伞下的衣襟闪动，细雨轻轻，宛如一朵朵细小的花蕾抹过青丝绸帕上的影迹，是一壶青花淋湿了烟雨。\n\n我与你，不远不近，朦胧的烟雨，正好烟青了一个季节，你眼角的余光落在六月的半途，惊醒了半夏渐行的每一步步履，一步一莲，像一段精美的文字。\n\n烟雨朦胧，你置身于景中，而我正是赏景的人，看着你愈加浅淡的行影，不由得写下让自己心动的文字，感叹又唏嘘。\n\n时间如是！\n\n我的六月，又朦胧了一场烟雨！\n\n3.\n\n一个季节的来去，是顺水而流的船，如一份深情的留白，永恒漂流，不允许回头！\n\n我有些小小的失落的寂寞，正如这朦胧的六月烟雨，落在你的伞中，如花儿开落枝头，落在这梅庄那亩浅浅的池，开成涟漪。\n\n或许，我与你，只是一次偶然的不期而遇，在不远不近的距离。\n\n柳絮已飞，又是一城春去矣！\n\n每一岁，每一季，每一个生命个体，没有轮回，只是一场无从握住的归去。然而，一声叹息里，浅浅的，或许，也有着一些些无可奈何的欢喜？\n\n世界如是！\n\n红豆生南国，朦胧了又一场烟雨。', '微尘陌上', '2021-06-15 17:41');
COMMIT;

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `projecct` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
BEGIN;
INSERT INTO `result` VALUES (1, 1, 100, '英语');
INSERT INTO `result` VALUES (2, 6, 10, '数学');
INSERT INTO `result` VALUES (3, 1, 99, '化学');
INSERT INTO `result` VALUES (4, 1, 150, '理综');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
