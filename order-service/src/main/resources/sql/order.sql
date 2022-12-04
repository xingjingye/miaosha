/*
 Navicat Premium Data Transfer

 Source Server         : myConnection
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : seckill_demo

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 04/12/2022 22:15:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `goods_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `goods_price` decimal(10, 2) NOT NULL,
  `goods_num` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1000000001, 1, 'xiaomi13', 3999.00, 1, 'zzu', '2022-11-26 12:53:51');
INSERT INTO `order` VALUES (2, 1000000001, 2, 'xiaomi13pro', 4999.00, 1, 'zzu', '2022-11-26 12:54:18');
INSERT INTO `order` VALUES (3, 1000000001, 3, 'xiaomi13ultra', 5999.00, 1, 'zzu', '2022-11-26 12:54:22');
INSERT INTO `order` VALUES (4, 1000000002, 3, 'xiaomi13ultra', 5999.00, 1, 'zzu', '2022-11-26 13:02:12');
INSERT INTO `order` VALUES (5, 1000000002, 2, 'xiaomi13pro', 4999.00, 1, 'zzu', '2022-11-26 13:02:34');
INSERT INTO `order` VALUES (6, 1000000002, 1, 'xiaomi13', 3999.00, 1, 'zzu', '2022-11-26 13:02:38');
INSERT INTO `order` VALUES (7, 1000000003, 1, 'xiaomi13', 3999.00, 1, 'zzu', '2022-11-26 13:06:24');
INSERT INTO `order` VALUES (8, 1000000003, 2, 'xiaomi13pro', 4999.00, 1, 'zzu', '2022-11-26 13:06:49');
INSERT INTO `order` VALUES (9, 1000000003, 3, 'xiaomi13ultra', 5999.00, 1, 'zzu', '2022-11-26 13:07:23');
INSERT INTO `order` VALUES (10, 1000000003, 1, 'xiaomi13', 3999.00, 1, 'zzu', '2022-11-26 13:14:41');
INSERT INTO `order` VALUES (11, 1000000003, 2, 'xiaomi13pro', 4999.00, 1, 'zzu', '2022-11-26 13:14:46');
INSERT INTO `order` VALUES (12, 1000000003, 3, 'xiaomi13ultra', 5999.00, 1, 'zzu', '2022-11-26 13:14:51');
INSERT INTO `order` VALUES (13, 1000000001, 3, 'xiaomi13ultra', 5999.00, 1, 'zzu', '2022-11-26 13:21:50');
INSERT INTO `order` VALUES (14, 1000000001, 2, 'xiaomi13pro', 4999.00, 1, 'zzu', '2022-11-26 13:21:54');
INSERT INTO `order` VALUES (15, 1000000001, 1, 'xiaomi13', 3999.00, 1, 'zzu', '2022-11-26 13:21:57');
INSERT INTO `order` VALUES (16, 1000000001, 1, 'xiaomi13', 3999.00, 1, 'zzu', '2022-11-26 16:46:47');
INSERT INTO `order` VALUES (17, 1000000001, 1, 'xiaomi13', 3999.00, 1, 'zzu', '2022-11-26 17:04:27');

SET FOREIGN_KEY_CHECKS = 1;
