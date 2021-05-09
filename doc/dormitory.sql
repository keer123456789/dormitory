/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : dormitory

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 09/05/2021 22:53:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '宿舍楼id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '宿舍楼姓名',
  `room_size` int(11) NULL DEFAULT NULL COMMENT '房间大小  4-4人间 6-6人间',
  `floor_size` int(11) NULL DEFAULT NULL COMMENT '楼层数',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '宿管人员id',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别 0-男；1-女',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '宿舍楼信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of block
-- ----------------------------
INSERT INTO `block` VALUES (1, '3号楼-男', 6, 5, 2, 0);
INSERT INTO `block` VALUES (2, '4号楼-女', 4, 5, 2, 1);
INSERT INTO `block` VALUES (3, '5号楼-男', 6, 5, NULL, 0);
INSERT INTO `block` VALUES (4, '6号楼-女', 4, 5, NULL, 1);
INSERT INTO `block` VALUES (5, '7号楼-男', 6, 5, NULL, 0);
INSERT INTO `block` VALUES (6, '8号楼-女', 4, 5, NULL, 1);
INSERT INTO `block` VALUES (7, '9号楼-男', 6, 5, NULL, 0);
INSERT INTO `block` VALUES (8, '10号楼-女', 4, 5, NULL, 1);

-- ----------------------------
-- Table structure for floor
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `block_id` int(11) NULL DEFAULT NULL COMMENT '楼号',
  `floor_num` int(11) NULL DEFAULT NULL COMMENT '楼层',
  `image_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '楼层平面图位置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of floor
-- ----------------------------
INSERT INTO `floor` VALUES (1, '1层', 1, 1, NULL);
INSERT INTO `floor` VALUES (2, '2层', 1, 2, NULL);
INSERT INTO `floor` VALUES (3, '3层', 1, 3, NULL);
INSERT INTO `floor` VALUES (4, '4层', 1, 4, NULL);
INSERT INTO `floor` VALUES (5, '5层', 1, 5, NULL);
INSERT INTO `floor` VALUES (6, '1层', 2, 1, NULL);
INSERT INTO `floor` VALUES (7, '2层', 2, 2, NULL);
INSERT INTO `floor` VALUES (8, '3层', 2, 3, NULL);
INSERT INTO `floor` VALUES (9, '4层', 2, 4, NULL);
INSERT INTO `floor` VALUES (10, '5层', 2, 5, NULL);
INSERT INTO `floor` VALUES (11, '1层', 3, 1, NULL);
INSERT INTO `floor` VALUES (12, '2层', 3, 2, NULL);
INSERT INTO `floor` VALUES (13, '3层', 3, 3, NULL);
INSERT INTO `floor` VALUES (14, '4层', 3, 4, NULL);
INSERT INTO `floor` VALUES (15, '5层', 3, 5, NULL);
INSERT INTO `floor` VALUES (16, '1层', 4, 1, NULL);
INSERT INTO `floor` VALUES (17, '2层', 4, 2, NULL);
INSERT INTO `floor` VALUES (18, '3层', 4, 3, NULL);
INSERT INTO `floor` VALUES (19, '4层', 4, 4, NULL);
INSERT INTO `floor` VALUES (20, '5层', 4, 5, NULL);
INSERT INTO `floor` VALUES (21, '1层', 5, 1, NULL);
INSERT INTO `floor` VALUES (22, '2层', 5, 2, NULL);
INSERT INTO `floor` VALUES (23, '3层', 5, 3, NULL);
INSERT INTO `floor` VALUES (24, '4层', 5, 4, NULL);
INSERT INTO `floor` VALUES (25, '5层', 5, 5, NULL);
INSERT INTO `floor` VALUES (26, '1层', 6, 1, NULL);
INSERT INTO `floor` VALUES (27, '2层', 6, 2, NULL);
INSERT INTO `floor` VALUES (28, '3层', 6, 3, NULL);
INSERT INTO `floor` VALUES (29, '4层', 6, 4, NULL);
INSERT INTO `floor` VALUES (30, '5层', 6, 5, NULL);
INSERT INTO `floor` VALUES (31, '1层', 7, 1, NULL);
INSERT INTO `floor` VALUES (32, '2层', 7, 2, NULL);
INSERT INTO `floor` VALUES (33, '3层', 7, 3, NULL);
INSERT INTO `floor` VALUES (34, '4层', 7, 4, NULL);
INSERT INTO `floor` VALUES (35, '5层', 7, 5, NULL);
INSERT INTO `floor` VALUES (36, '1层', 8, 1, NULL);
INSERT INTO `floor` VALUES (37, '2层', 8, 2, NULL);
INSERT INTO `floor` VALUES (38, '3层', 8, 3, NULL);
INSERT INTO `floor` VALUES (39, '4层', 8, 4, NULL);
INSERT INTO `floor` VALUES (40, '5层', 8, 5, NULL);

-- ----------------------------
-- Table structure for object
-- ----------------------------
DROP TABLE IF EXISTS `object`;
CREATE TABLE `object`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物品名称',
  `floor_id` int(11) NULL DEFAULT NULL COMMENT '楼层id',
  `x` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '楼层平面图中的标记位置 x',
  `y` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '楼层平面图中标记位置y',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物品类别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '物品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of object
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '宿舍房间id',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房间名称',
  `size` int(11) NULL DEFAULT NULL COMMENT '床位总个数',
  `empty_size` int(11) NULL DEFAULT NULL COMMENT '空床位个数',
  `floor_id` int(11) NULL DEFAULT NULL COMMENT '宿舍所在楼层id',
  `x` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 x轴坐标',
  `y` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 y轴坐标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '房间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '101', 6, 0, 1, '130', '156');
INSERT INTO `room` VALUES (2, '102', 6, 0, 1, '22', '366');
INSERT INTO `room` VALUES (3, '103', 6, 0, 1, '238', '156');
INSERT INTO `room` VALUES (4, '104', 6, 0, 1, '130', '366');
INSERT INTO `room` VALUES (5, '105', 6, 2, 1, '346', '156');
INSERT INTO `room` VALUES (6, '106', 4, 0, 1, '346', '366');
INSERT INTO `room` VALUES (7, '107', 4, 0, 1, '454', '156');
INSERT INTO `room` VALUES (8, '108', 4, 0, 1, '454', '366');
INSERT INTO `room` VALUES (9, '109', 4, 0, 1, '562', '156');
INSERT INTO `room` VALUES (10, '110', 4, 0, 1, '562', '366');
INSERT INTO `room` VALUES (11, '201', 4, 0, 2, '130', '156');
INSERT INTO `room` VALUES (12, '202', 4, 0, 2, '22', '366');
INSERT INTO `room` VALUES (13, '203', 4, 1, 2, '238', '156');
INSERT INTO `room` VALUES (14, '204', 4, 0, 2, '130', '366');
INSERT INTO `room` VALUES (15, '205', 4, 0, 2, '346', '156');
INSERT INTO `room` VALUES (16, '206', 4, 0, 2, '346', '366');
INSERT INTO `room` VALUES (17, '207', 4, 0, 2, '454', '156');
INSERT INTO `room` VALUES (18, '208', 4, 0, 2, '454', '366');
INSERT INTO `room` VALUES (19, '209', 4, 0, 2, '562', '156');
INSERT INTO `room` VALUES (20, '210', 6, 6, 2, '562', '366');
INSERT INTO `room` VALUES (21, '301', 6, 6, 3, '130', '156');
INSERT INTO `room` VALUES (22, '302', 6, 6, 3, '22', '366');
INSERT INTO `room` VALUES (23, '303', 6, 6, 3, '238', '156');
INSERT INTO `room` VALUES (24, '304', 6, 6, 3, '130', '366');
INSERT INTO `room` VALUES (25, '305', 6, 6, 3, '346', '156');
INSERT INTO `room` VALUES (26, '306', 6, 6, 3, '346', '366');
INSERT INTO `room` VALUES (27, '307', 6, 6, 3, '454', '156');
INSERT INTO `room` VALUES (28, '308', 6, 6, 3, '454', '366');
INSERT INTO `room` VALUES (29, '309', 6, 6, 3, '562', '156');
INSERT INTO `room` VALUES (30, '310', 6, 6, 3, '562', '366');
INSERT INTO `room` VALUES (31, '401', 6, 6, 4, '130', '156');
INSERT INTO `room` VALUES (32, '402', 6, 6, 4, '22', '366');
INSERT INTO `room` VALUES (33, '403', 6, 6, 4, '238', '156');
INSERT INTO `room` VALUES (34, '404', 6, 6, 4, '130', '366');
INSERT INTO `room` VALUES (35, '405', 6, 6, 4, '346', '156');
INSERT INTO `room` VALUES (36, '406', 6, 6, 4, '346', '366');
INSERT INTO `room` VALUES (37, '407', 6, 6, 4, '454', '156');
INSERT INTO `room` VALUES (38, '408', 6, 6, 4, '454', '366');
INSERT INTO `room` VALUES (39, '409', 6, 6, 4, '562', '156');
INSERT INTO `room` VALUES (40, '410', 6, 6, 4, '562', '366');
INSERT INTO `room` VALUES (41, '501', 6, 6, 5, '130', '156');
INSERT INTO `room` VALUES (42, '502', 6, 6, 5, '22', '366');
INSERT INTO `room` VALUES (43, '503', 6, 6, 5, '238', '156');
INSERT INTO `room` VALUES (44, '504', 6, 6, 5, '130', '366');
INSERT INTO `room` VALUES (45, '505', 6, 6, 5, '346', '156');
INSERT INTO `room` VALUES (46, '506', 6, 6, 5, '346', '366');
INSERT INTO `room` VALUES (47, '507', 6, 6, 5, '454', '156');
INSERT INTO `room` VALUES (48, '508', 6, 6, 5, '454', '366');
INSERT INTO `room` VALUES (49, '509', 6, 6, 5, '562', '156');
INSERT INTO `room` VALUES (50, '510', 6, 6, 5, '562', '366');
INSERT INTO `room` VALUES (51, '101', 4, 4, 6, '130', '156');
INSERT INTO `room` VALUES (52, '102', 4, 4, 6, '22', '366');
INSERT INTO `room` VALUES (53, '103', 4, 4, 6, '238', '156');
INSERT INTO `room` VALUES (54, '104', 4, 4, 6, '130', '366');
INSERT INTO `room` VALUES (55, '105', 4, 4, 6, '346', '156');
INSERT INTO `room` VALUES (56, '106', 4, 4, 6, '346', '366');
INSERT INTO `room` VALUES (57, '107', 4, 4, 6, '454', '156');
INSERT INTO `room` VALUES (58, '108', 4, 4, 6, '454', '366');
INSERT INTO `room` VALUES (59, '109', 4, 4, 6, '562', '156');
INSERT INTO `room` VALUES (60, '110', 4, 4, 6, '562', '366');
INSERT INTO `room` VALUES (61, '201', 4, 4, 7, '130', '156');
INSERT INTO `room` VALUES (62, '202', 4, 4, 7, '22', '366');
INSERT INTO `room` VALUES (63, '203', 4, 4, 7, '238', '156');
INSERT INTO `room` VALUES (64, '204', 4, 4, 7, '130', '366');
INSERT INTO `room` VALUES (65, '205', 4, 3, 7, '346', '156');
INSERT INTO `room` VALUES (66, '206', 4, 4, 7, '346', '366');
INSERT INTO `room` VALUES (67, '207', 4, 4, 7, '454', '156');
INSERT INTO `room` VALUES (68, '208', 4, 4, 7, '454', '366');
INSERT INTO `room` VALUES (69, '209', 4, 4, 7, '562', '156');
INSERT INTO `room` VALUES (70, '210', 4, 4, 7, '562', '366');
INSERT INTO `room` VALUES (71, '301', 4, 4, 8, '130', '156');
INSERT INTO `room` VALUES (72, '302', 4, 4, 8, '22', '366');
INSERT INTO `room` VALUES (73, '303', 4, 4, 8, '238', '156');
INSERT INTO `room` VALUES (74, '304', 4, 4, 8, '130', '366');
INSERT INTO `room` VALUES (75, '305', 4, 4, 8, '346', '156');
INSERT INTO `room` VALUES (76, '306', 4, 4, 8, '346', '366');
INSERT INTO `room` VALUES (77, '307', 4, 4, 8, '454', '156');
INSERT INTO `room` VALUES (78, '308', 4, 4, 8, '454', '366');
INSERT INTO `room` VALUES (79, '309', 4, 4, 8, '562', '156');
INSERT INTO `room` VALUES (80, '310', 4, 4, 8, '562', '366');
INSERT INTO `room` VALUES (81, '401', 4, 4, 9, '130', '156');
INSERT INTO `room` VALUES (82, '402', 4, 4, 9, '22', '366');
INSERT INTO `room` VALUES (83, '403', 4, 4, 9, '238', '156');
INSERT INTO `room` VALUES (84, '404', 4, 4, 9, '130', '366');
INSERT INTO `room` VALUES (85, '405', 4, 4, 9, '346', '156');
INSERT INTO `room` VALUES (86, '406', 4, 4, 9, '346', '366');
INSERT INTO `room` VALUES (87, '407', 4, 4, 9, '454', '156');
INSERT INTO `room` VALUES (88, '408', 4, 4, 9, '454', '366');
INSERT INTO `room` VALUES (89, '409', 4, 4, 9, '562', '156');
INSERT INTO `room` VALUES (90, '410', 4, 4, 9, '562', '366');
INSERT INTO `room` VALUES (91, '501', 4, 4, 10, '130', '156');
INSERT INTO `room` VALUES (92, '502', 4, 4, 10, '22', '366');
INSERT INTO `room` VALUES (93, '503', 4, 4, 10, '238', '156');
INSERT INTO `room` VALUES (94, '504', 4, 4, 10, '130', '366');
INSERT INTO `room` VALUES (95, '505', 4, 4, 10, '346', '156');
INSERT INTO `room` VALUES (96, '506', 4, 4, 10, '346', '366');
INSERT INTO `room` VALUES (97, '507', 4, 4, 10, '454', '156');
INSERT INTO `room` VALUES (98, '508', 4, 4, 10, '454', '366');
INSERT INTO `room` VALUES (99, '509', 4, 4, 10, '562', '156');
INSERT INTO `room` VALUES (100, '510', 4, 4, 10, '562', '366');
INSERT INTO `room` VALUES (101, '101', 6, 6, 11, '130', '156');
INSERT INTO `room` VALUES (102, '102', 6, 6, 11, '22', '366');
INSERT INTO `room` VALUES (103, '103', 6, 6, 11, '238', '156');
INSERT INTO `room` VALUES (104, '104', 6, 6, 11, '130', '366');
INSERT INTO `room` VALUES (105, '105', 6, 6, 11, '346', '156');
INSERT INTO `room` VALUES (106, '106', 6, 6, 11, '346', '366');
INSERT INTO `room` VALUES (107, '107', 6, 6, 11, '454', '156');
INSERT INTO `room` VALUES (108, '108', 6, 6, 11, '454', '366');
INSERT INTO `room` VALUES (109, '109', 6, 6, 11, '562', '156');
INSERT INTO `room` VALUES (110, '110', 6, 6, 11, '562', '366');
INSERT INTO `room` VALUES (111, '201', 6, 6, 12, '130', '156');
INSERT INTO `room` VALUES (112, '202', 6, 6, 12, '22', '366');
INSERT INTO `room` VALUES (113, '203', 6, 6, 12, '238', '156');
INSERT INTO `room` VALUES (114, '204', 6, 6, 12, '130', '366');
INSERT INTO `room` VALUES (115, '205', 6, 6, 12, '346', '156');
INSERT INTO `room` VALUES (116, '206', 6, 6, 12, '346', '366');
INSERT INTO `room` VALUES (117, '207', 6, 6, 12, '454', '156');
INSERT INTO `room` VALUES (118, '208', 6, 6, 12, '454', '366');
INSERT INTO `room` VALUES (119, '209', 6, 6, 12, '562', '156');
INSERT INTO `room` VALUES (120, '210', 6, 6, 12, '562', '366');
INSERT INTO `room` VALUES (121, '301', 6, 6, 13, '130', '156');
INSERT INTO `room` VALUES (122, '302', 6, 6, 13, '22', '366');
INSERT INTO `room` VALUES (123, '303', 6, 6, 13, '238', '156');
INSERT INTO `room` VALUES (124, '304', 6, 6, 13, '130', '366');
INSERT INTO `room` VALUES (125, '305', 6, 6, 13, '346', '156');
INSERT INTO `room` VALUES (126, '306', 6, 6, 13, '346', '366');
INSERT INTO `room` VALUES (127, '307', 6, 6, 13, '454', '156');
INSERT INTO `room` VALUES (128, '308', 6, 6, 13, '454', '366');
INSERT INTO `room` VALUES (129, '309', 6, 6, 13, '562', '156');
INSERT INTO `room` VALUES (130, '310', 6, 6, 13, '562', '366');
INSERT INTO `room` VALUES (131, '401', 6, 6, 14, '130', '156');
INSERT INTO `room` VALUES (132, '402', 6, 6, 14, '22', '366');
INSERT INTO `room` VALUES (133, '403', 6, 6, 14, '238', '156');
INSERT INTO `room` VALUES (134, '404', 6, 6, 14, '130', '366');
INSERT INTO `room` VALUES (135, '405', 6, 6, 14, '346', '156');
INSERT INTO `room` VALUES (136, '406', 6, 6, 14, '346', '366');
INSERT INTO `room` VALUES (137, '407', 6, 6, 14, '454', '156');
INSERT INTO `room` VALUES (138, '408', 6, 6, 14, '454', '366');
INSERT INTO `room` VALUES (139, '409', 6, 6, 14, '562', '156');
INSERT INTO `room` VALUES (140, '410', 6, 6, 14, '562', '366');
INSERT INTO `room` VALUES (141, '501', 6, 6, 15, '130', '156');
INSERT INTO `room` VALUES (142, '502', 6, 6, 15, '22', '366');
INSERT INTO `room` VALUES (143, '503', 6, 6, 15, '238', '156');
INSERT INTO `room` VALUES (144, '504', 6, 6, 15, '130', '366');
INSERT INTO `room` VALUES (145, '505', 6, 6, 15, '346', '156');
INSERT INTO `room` VALUES (146, '506', 6, 6, 15, '346', '366');
INSERT INTO `room` VALUES (147, '507', 6, 6, 15, '454', '156');
INSERT INTO `room` VALUES (148, '508', 6, 6, 15, '454', '366');
INSERT INTO `room` VALUES (149, '509', 6, 6, 15, '562', '156');
INSERT INTO `room` VALUES (150, '510', 6, 6, 15, '562', '366');
INSERT INTO `room` VALUES (151, '101', 4, 4, 16, '130', '156');
INSERT INTO `room` VALUES (152, '102', 4, 4, 16, '22', '366');
INSERT INTO `room` VALUES (153, '103', 4, 4, 16, '238', '156');
INSERT INTO `room` VALUES (154, '104', 4, 4, 16, '130', '366');
INSERT INTO `room` VALUES (155, '105', 4, 4, 16, '346', '156');
INSERT INTO `room` VALUES (156, '106', 4, 4, 16, '346', '366');
INSERT INTO `room` VALUES (157, '107', 4, 4, 16, '454', '156');
INSERT INTO `room` VALUES (158, '108', 4, 4, 16, '454', '366');
INSERT INTO `room` VALUES (159, '109', 4, 4, 16, '562', '156');
INSERT INTO `room` VALUES (160, '110', 4, 4, 16, '562', '366');
INSERT INTO `room` VALUES (161, '201', 4, 4, 17, '130', '156');
INSERT INTO `room` VALUES (162, '202', 4, 4, 17, '22', '366');
INSERT INTO `room` VALUES (163, '203', 4, 4, 17, '238', '156');
INSERT INTO `room` VALUES (164, '204', 4, 4, 17, '130', '366');
INSERT INTO `room` VALUES (165, '205', 4, 4, 17, '346', '156');
INSERT INTO `room` VALUES (166, '206', 4, 4, 17, '346', '366');
INSERT INTO `room` VALUES (167, '207', 4, 4, 17, '454', '156');
INSERT INTO `room` VALUES (168, '208', 4, 4, 17, '454', '366');
INSERT INTO `room` VALUES (169, '209', 4, 4, 17, '562', '156');
INSERT INTO `room` VALUES (170, '210', 4, 4, 17, '562', '366');
INSERT INTO `room` VALUES (171, '301', 4, 4, 18, '130', '156');
INSERT INTO `room` VALUES (172, '302', 4, 4, 18, '22', '366');
INSERT INTO `room` VALUES (173, '303', 4, 4, 18, '238', '156');
INSERT INTO `room` VALUES (174, '304', 4, 4, 18, '130', '366');
INSERT INTO `room` VALUES (175, '305', 4, 4, 18, '346', '156');
INSERT INTO `room` VALUES (176, '306', 4, 4, 18, '346', '366');
INSERT INTO `room` VALUES (177, '307', 4, 4, 18, '454', '156');
INSERT INTO `room` VALUES (178, '308', 4, 4, 18, '454', '366');
INSERT INTO `room` VALUES (179, '309', 4, 4, 18, '562', '156');
INSERT INTO `room` VALUES (180, '310', 4, 4, 18, '562', '366');
INSERT INTO `room` VALUES (181, '401', 4, 4, 19, '130', '156');
INSERT INTO `room` VALUES (182, '402', 4, 4, 19, '22', '366');
INSERT INTO `room` VALUES (183, '403', 4, 4, 19, '238', '156');
INSERT INTO `room` VALUES (184, '404', 4, 4, 19, '130', '366');
INSERT INTO `room` VALUES (185, '405', 4, 4, 19, '346', '156');
INSERT INTO `room` VALUES (186, '406', 4, 4, 19, '346', '366');
INSERT INTO `room` VALUES (187, '407', 4, 4, 19, '454', '156');
INSERT INTO `room` VALUES (188, '408', 4, 4, 19, '454', '366');
INSERT INTO `room` VALUES (189, '409', 4, 4, 19, '562', '156');
INSERT INTO `room` VALUES (190, '410', 4, 4, 19, '562', '366');
INSERT INTO `room` VALUES (191, '501', 4, 4, 20, '130', '156');
INSERT INTO `room` VALUES (192, '502', 4, 4, 20, '22', '366');
INSERT INTO `room` VALUES (193, '503', 4, 4, 20, '238', '156');
INSERT INTO `room` VALUES (194, '504', 4, 4, 20, '130', '366');
INSERT INTO `room` VALUES (195, '505', 4, 4, 20, '346', '156');
INSERT INTO `room` VALUES (196, '506', 4, 4, 20, '346', '366');
INSERT INTO `room` VALUES (197, '507', 4, 4, 20, '454', '156');
INSERT INTO `room` VALUES (198, '508', 4, 4, 20, '454', '366');
INSERT INTO `room` VALUES (199, '509', 4, 4, 20, '562', '156');
INSERT INTO `room` VALUES (200, '510', 4, 4, 20, '562', '366');
INSERT INTO `room` VALUES (201, '101', 6, 6, 21, '130', '156');
INSERT INTO `room` VALUES (202, '102', 6, 6, 21, '22', '366');
INSERT INTO `room` VALUES (203, '103', 6, 6, 21, '238', '156');
INSERT INTO `room` VALUES (204, '104', 6, 6, 21, '130', '366');
INSERT INTO `room` VALUES (205, '105', 6, 6, 21, '346', '156');
INSERT INTO `room` VALUES (206, '106', 6, 6, 21, '346', '366');
INSERT INTO `room` VALUES (207, '107', 6, 6, 21, '454', '156');
INSERT INTO `room` VALUES (208, '108', 6, 6, 21, '454', '366');
INSERT INTO `room` VALUES (209, '109', 6, 6, 21, '562', '156');
INSERT INTO `room` VALUES (210, '110', 6, 6, 21, '562', '366');
INSERT INTO `room` VALUES (211, '201', 6, 6, 22, '130', '156');
INSERT INTO `room` VALUES (212, '202', 6, 6, 22, '22', '366');
INSERT INTO `room` VALUES (213, '203', 6, 6, 22, '238', '156');
INSERT INTO `room` VALUES (214, '204', 6, 6, 22, '130', '366');
INSERT INTO `room` VALUES (215, '205', 6, 6, 22, '346', '156');
INSERT INTO `room` VALUES (216, '206', 6, 6, 22, '346', '366');
INSERT INTO `room` VALUES (217, '207', 6, 6, 22, '454', '156');
INSERT INTO `room` VALUES (218, '208', 6, 6, 22, '454', '366');
INSERT INTO `room` VALUES (219, '209', 6, 6, 22, '562', '156');
INSERT INTO `room` VALUES (220, '210', 6, 6, 22, '562', '366');
INSERT INTO `room` VALUES (221, '301', 6, 6, 23, '130', '156');
INSERT INTO `room` VALUES (222, '302', 6, 6, 23, '22', '366');
INSERT INTO `room` VALUES (223, '303', 6, 6, 23, '238', '156');
INSERT INTO `room` VALUES (224, '304', 6, 6, 23, '130', '366');
INSERT INTO `room` VALUES (225, '305', 6, 6, 23, '346', '156');
INSERT INTO `room` VALUES (226, '306', 6, 6, 23, '346', '366');
INSERT INTO `room` VALUES (227, '307', 6, 6, 23, '454', '156');
INSERT INTO `room` VALUES (228, '308', 6, 6, 23, '454', '366');
INSERT INTO `room` VALUES (229, '309', 6, 6, 23, '562', '156');
INSERT INTO `room` VALUES (230, '310', 6, 6, 23, '562', '366');
INSERT INTO `room` VALUES (231, '401', 6, 6, 24, '130', '156');
INSERT INTO `room` VALUES (232, '402', 6, 6, 24, '22', '366');
INSERT INTO `room` VALUES (233, '403', 6, 6, 24, '238', '156');
INSERT INTO `room` VALUES (234, '404', 6, 6, 24, '130', '366');
INSERT INTO `room` VALUES (235, '405', 6, 6, 24, '346', '156');
INSERT INTO `room` VALUES (236, '406', 6, 6, 24, '346', '366');
INSERT INTO `room` VALUES (237, '407', 6, 6, 24, '454', '156');
INSERT INTO `room` VALUES (238, '408', 6, 6, 24, '454', '366');
INSERT INTO `room` VALUES (239, '409', 6, 6, 24, '562', '156');
INSERT INTO `room` VALUES (240, '410', 6, 6, 24, '562', '366');
INSERT INTO `room` VALUES (241, '501', 6, 6, 25, '130', '156');
INSERT INTO `room` VALUES (242, '502', 6, 6, 25, '22', '366');
INSERT INTO `room` VALUES (243, '503', 6, 6, 25, '238', '156');
INSERT INTO `room` VALUES (244, '504', 6, 6, 25, '130', '366');
INSERT INTO `room` VALUES (245, '505', 6, 6, 25, '346', '156');
INSERT INTO `room` VALUES (246, '506', 6, 6, 25, '346', '366');
INSERT INTO `room` VALUES (247, '507', 6, 6, 25, '454', '156');
INSERT INTO `room` VALUES (248, '508', 6, 6, 25, '454', '366');
INSERT INTO `room` VALUES (249, '509', 6, 6, 25, '562', '156');
INSERT INTO `room` VALUES (250, '510', 6, 6, 25, '562', '366');
INSERT INTO `room` VALUES (251, '101', 4, 4, 26, '130', '156');
INSERT INTO `room` VALUES (252, '102', 4, 4, 26, '22', '366');
INSERT INTO `room` VALUES (253, '103', 4, 4, 26, '238', '156');
INSERT INTO `room` VALUES (254, '104', 4, 4, 26, '130', '366');
INSERT INTO `room` VALUES (255, '105', 4, 4, 26, '346', '156');
INSERT INTO `room` VALUES (256, '106', 4, 4, 26, '346', '366');
INSERT INTO `room` VALUES (257, '107', 4, 4, 26, '454', '156');
INSERT INTO `room` VALUES (258, '108', 4, 4, 26, '454', '366');
INSERT INTO `room` VALUES (259, '109', 4, 4, 26, '562', '156');
INSERT INTO `room` VALUES (260, '110', 4, 4, 26, '562', '366');
INSERT INTO `room` VALUES (261, '201', 4, 4, 27, '130', '156');
INSERT INTO `room` VALUES (262, '202', 4, 4, 27, '22', '366');
INSERT INTO `room` VALUES (263, '203', 4, 4, 27, '238', '156');
INSERT INTO `room` VALUES (264, '204', 4, 4, 27, '130', '366');
INSERT INTO `room` VALUES (265, '205', 4, 4, 27, '346', '156');
INSERT INTO `room` VALUES (266, '206', 4, 4, 27, '346', '366');
INSERT INTO `room` VALUES (267, '207', 4, 4, 27, '454', '156');
INSERT INTO `room` VALUES (268, '208', 4, 4, 27, '454', '366');
INSERT INTO `room` VALUES (269, '209', 4, 4, 27, '562', '156');
INSERT INTO `room` VALUES (270, '210', 4, 4, 27, '562', '366');
INSERT INTO `room` VALUES (271, '301', 4, 4, 28, '130', '156');
INSERT INTO `room` VALUES (272, '302', 4, 4, 28, '22', '366');
INSERT INTO `room` VALUES (273, '303', 4, 4, 28, '238', '156');
INSERT INTO `room` VALUES (274, '304', 4, 4, 28, '130', '366');
INSERT INTO `room` VALUES (275, '305', 4, 4, 28, '346', '156');
INSERT INTO `room` VALUES (276, '306', 4, 4, 28, '346', '366');
INSERT INTO `room` VALUES (277, '307', 4, 4, 28, '454', '156');
INSERT INTO `room` VALUES (278, '308', 4, 4, 28, '454', '366');
INSERT INTO `room` VALUES (279, '309', 4, 4, 28, '562', '156');
INSERT INTO `room` VALUES (280, '310', 4, 4, 28, '562', '366');
INSERT INTO `room` VALUES (281, '401', 4, 4, 29, '130', '156');
INSERT INTO `room` VALUES (282, '402', 4, 4, 29, '22', '366');
INSERT INTO `room` VALUES (283, '403', 4, 4, 29, '238', '156');
INSERT INTO `room` VALUES (284, '404', 4, 4, 29, '130', '366');
INSERT INTO `room` VALUES (285, '405', 4, 4, 29, '346', '156');
INSERT INTO `room` VALUES (286, '406', 4, 4, 29, '346', '366');
INSERT INTO `room` VALUES (287, '407', 4, 4, 29, '454', '156');
INSERT INTO `room` VALUES (288, '408', 4, 4, 29, '454', '366');
INSERT INTO `room` VALUES (289, '409', 4, 4, 29, '562', '156');
INSERT INTO `room` VALUES (290, '410', 4, 4, 29, '562', '366');
INSERT INTO `room` VALUES (291, '501', 4, 4, 30, '130', '156');
INSERT INTO `room` VALUES (292, '502', 4, 4, 30, '22', '366');
INSERT INTO `room` VALUES (293, '503', 4, 4, 30, '238', '156');
INSERT INTO `room` VALUES (294, '504', 4, 4, 30, '130', '366');
INSERT INTO `room` VALUES (295, '505', 4, 4, 30, '346', '156');
INSERT INTO `room` VALUES (296, '506', 4, 4, 30, '346', '366');
INSERT INTO `room` VALUES (297, '507', 4, 4, 30, '454', '156');
INSERT INTO `room` VALUES (298, '508', 4, 4, 30, '454', '366');
INSERT INTO `room` VALUES (299, '509', 4, 4, 30, '562', '156');
INSERT INTO `room` VALUES (300, '510', 4, 4, 30, '562', '366');
INSERT INTO `room` VALUES (301, '101', 6, 6, 31, '130', '156');
INSERT INTO `room` VALUES (302, '102', 6, 6, 31, '22', '366');
INSERT INTO `room` VALUES (303, '103', 6, 6, 31, '238', '156');
INSERT INTO `room` VALUES (304, '104', 6, 6, 31, '130', '366');
INSERT INTO `room` VALUES (305, '105', 6, 6, 31, '346', '156');
INSERT INTO `room` VALUES (306, '106', 6, 6, 31, '346', '366');
INSERT INTO `room` VALUES (307, '107', 6, 6, 31, '454', '156');
INSERT INTO `room` VALUES (308, '108', 6, 6, 31, '454', '366');
INSERT INTO `room` VALUES (309, '109', 6, 6, 31, '562', '156');
INSERT INTO `room` VALUES (310, '110', 6, 6, 31, '562', '366');
INSERT INTO `room` VALUES (311, '201', 6, 6, 32, '130', '156');
INSERT INTO `room` VALUES (312, '202', 6, 6, 32, '22', '366');
INSERT INTO `room` VALUES (313, '203', 6, 6, 32, '238', '156');
INSERT INTO `room` VALUES (314, '204', 6, 6, 32, '130', '366');
INSERT INTO `room` VALUES (315, '205', 6, 6, 32, '346', '156');
INSERT INTO `room` VALUES (316, '206', 6, 6, 32, '346', '366');
INSERT INTO `room` VALUES (317, '207', 6, 6, 32, '454', '156');
INSERT INTO `room` VALUES (318, '208', 6, 6, 32, '454', '366');
INSERT INTO `room` VALUES (319, '209', 6, 6, 32, '562', '156');
INSERT INTO `room` VALUES (320, '210', 6, 6, 32, '562', '366');
INSERT INTO `room` VALUES (321, '301', 6, 6, 33, '130', '156');
INSERT INTO `room` VALUES (322, '302', 6, 6, 33, '22', '366');
INSERT INTO `room` VALUES (323, '303', 6, 6, 33, '238', '156');
INSERT INTO `room` VALUES (324, '304', 6, 6, 33, '130', '366');
INSERT INTO `room` VALUES (325, '305', 6, 6, 33, '346', '156');
INSERT INTO `room` VALUES (326, '306', 6, 6, 33, '346', '366');
INSERT INTO `room` VALUES (327, '307', 6, 6, 33, '454', '156');
INSERT INTO `room` VALUES (328, '308', 6, 6, 33, '454', '366');
INSERT INTO `room` VALUES (329, '309', 6, 6, 33, '562', '156');
INSERT INTO `room` VALUES (330, '310', 6, 6, 33, '562', '366');
INSERT INTO `room` VALUES (331, '401', 6, 6, 34, '130', '156');
INSERT INTO `room` VALUES (332, '402', 6, 6, 34, '22', '366');
INSERT INTO `room` VALUES (333, '403', 6, 6, 34, '238', '156');
INSERT INTO `room` VALUES (334, '404', 6, 6, 34, '130', '366');
INSERT INTO `room` VALUES (335, '405', 6, 6, 34, '346', '156');
INSERT INTO `room` VALUES (336, '406', 6, 6, 34, '346', '366');
INSERT INTO `room` VALUES (337, '407', 6, 6, 34, '454', '156');
INSERT INTO `room` VALUES (338, '408', 6, 6, 34, '454', '366');
INSERT INTO `room` VALUES (339, '409', 6, 6, 34, '562', '156');
INSERT INTO `room` VALUES (340, '410', 6, 6, 34, '562', '366');
INSERT INTO `room` VALUES (341, '501', 6, 6, 35, '130', '156');
INSERT INTO `room` VALUES (342, '502', 6, 6, 35, '22', '366');
INSERT INTO `room` VALUES (343, '503', 6, 6, 35, '238', '156');
INSERT INTO `room` VALUES (344, '504', 6, 6, 35, '130', '366');
INSERT INTO `room` VALUES (345, '505', 6, 6, 35, '346', '156');
INSERT INTO `room` VALUES (346, '506', 6, 6, 35, '346', '366');
INSERT INTO `room` VALUES (347, '507', 6, 6, 35, '454', '156');
INSERT INTO `room` VALUES (348, '508', 6, 6, 35, '454', '366');
INSERT INTO `room` VALUES (349, '509', 6, 6, 35, '562', '156');
INSERT INTO `room` VALUES (350, '510', 6, 6, 35, '562', '366');
INSERT INTO `room` VALUES (351, '101', 4, 4, 36, '130', '156');
INSERT INTO `room` VALUES (352, '102', 4, 4, 36, '22', '366');
INSERT INTO `room` VALUES (353, '103', 4, 4, 36, '238', '156');
INSERT INTO `room` VALUES (354, '104', 4, 4, 36, '130', '366');
INSERT INTO `room` VALUES (355, '105', 4, 4, 36, '346', '156');
INSERT INTO `room` VALUES (356, '106', 4, 4, 36, '346', '366');
INSERT INTO `room` VALUES (357, '107', 4, 4, 36, '454', '156');
INSERT INTO `room` VALUES (358, '108', 4, 4, 36, '454', '366');
INSERT INTO `room` VALUES (359, '109', 4, 4, 36, '562', '156');
INSERT INTO `room` VALUES (360, '110', 4, 4, 36, '562', '366');
INSERT INTO `room` VALUES (361, '201', 4, 4, 37, '130', '156');
INSERT INTO `room` VALUES (362, '202', 4, 4, 37, '22', '366');
INSERT INTO `room` VALUES (363, '203', 4, 4, 37, '238', '156');
INSERT INTO `room` VALUES (364, '204', 4, 4, 37, '130', '366');
INSERT INTO `room` VALUES (365, '205', 4, 4, 37, '346', '156');
INSERT INTO `room` VALUES (366, '206', 4, 4, 37, '346', '366');
INSERT INTO `room` VALUES (367, '207', 4, 4, 37, '454', '156');
INSERT INTO `room` VALUES (368, '208', 4, 4, 37, '454', '366');
INSERT INTO `room` VALUES (369, '209', 4, 4, 37, '562', '156');
INSERT INTO `room` VALUES (370, '210', 4, 4, 37, '562', '366');
INSERT INTO `room` VALUES (371, '301', 4, 4, 38, '130', '156');
INSERT INTO `room` VALUES (372, '302', 4, 4, 38, '22', '366');
INSERT INTO `room` VALUES (373, '303', 4, 4, 38, '238', '156');
INSERT INTO `room` VALUES (374, '304', 4, 4, 38, '130', '366');
INSERT INTO `room` VALUES (375, '305', 4, 4, 38, '346', '156');
INSERT INTO `room` VALUES (376, '306', 4, 4, 38, '346', '366');
INSERT INTO `room` VALUES (377, '307', 4, 4, 38, '454', '156');
INSERT INTO `room` VALUES (378, '308', 4, 4, 38, '454', '366');
INSERT INTO `room` VALUES (379, '309', 4, 4, 38, '562', '156');
INSERT INTO `room` VALUES (380, '310', 4, 4, 38, '562', '366');
INSERT INTO `room` VALUES (381, '401', 4, 4, 39, '130', '156');
INSERT INTO `room` VALUES (382, '402', 4, 4, 39, '22', '366');
INSERT INTO `room` VALUES (383, '403', 4, 4, 39, '238', '156');
INSERT INTO `room` VALUES (384, '404', 4, 4, 39, '130', '366');
INSERT INTO `room` VALUES (385, '405', 4, 4, 39, '346', '156');
INSERT INTO `room` VALUES (386, '406', 4, 4, 39, '346', '366');
INSERT INTO `room` VALUES (387, '407', 4, 4, 39, '454', '156');
INSERT INTO `room` VALUES (388, '408', 4, 4, 39, '454', '366');
INSERT INTO `room` VALUES (389, '409', 4, 4, 39, '562', '156');
INSERT INTO `room` VALUES (390, '410', 4, 4, 39, '562', '366');
INSERT INTO `room` VALUES (391, '501', 4, 4, 40, '130', '156');
INSERT INTO `room` VALUES (392, '502', 4, 4, 40, '22', '366');
INSERT INTO `room` VALUES (393, '503', 4, 4, 40, '238', '156');
INSERT INTO `room` VALUES (394, '504', 4, 4, 40, '130', '366');
INSERT INTO `room` VALUES (395, '505', 4, 4, 40, '346', '156');
INSERT INTO `room` VALUES (396, '506', 4, 4, 40, '346', '366');
INSERT INTO `room` VALUES (397, '507', 4, 4, 40, '454', '156');
INSERT INTO `room` VALUES (398, '508', 4, 4, 40, '454', '366');
INSERT INTO `room` VALUES (399, '509', 4, 4, 40, '562', '156');
INSERT INTO `room` VALUES (400, '510', 4, 4, 40, '562', '366');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `identity_num` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '房间号',
  `bed_num` int(11) NULL DEFAULT NULL COMMENT '床位号',
  `nation` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '民族',
  `sex` int(11) NOT NULL DEFAULT 0 COMMENT '性别 0-男  1-女',
  `academy` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学院：信息，物流',
  `major` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专业',
  `class_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '行政班级号',
  `region` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地区',
  `phone_num` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '学生状态  0-正常 1-休学  2-退宿',
  `task_id` int(11) NULL DEFAULT NULL COMMENT '任务id 表示学生属于的批次',
  `x` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 x轴位置',
  `y` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 y轴位置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张3', '111231456', 65, 1, '汉', 0, '信息', '计算机', '123', '北京', '12345678934', '丝滑', 0, 1, '238', '26');
INSERT INTO `student` VALUES ('10', '张12', '1112321', 15, 2, '汉', 0, '信息', '计算机', '132', '北京', '12345678900', '丝滑', 0, 1, '346', '49');
INSERT INTO `student` VALUES ('11', '张13', '1112322', 15, 3, '汉', 0, '信息', '计算机', '133', '北京', '12345678900', '丝滑', 0, 1, '346', '72');
INSERT INTO `student` VALUES ('12', '张14', '1112323', 15, 4, '汉', 0, '信息', '计算机', '134', '北京', '12345678900', '丝滑', 0, 1, '346', '95');
INSERT INTO `student` VALUES ('13', '张15', '1112324', 16, 1, '汉', 0, '信息', '计算机', '135', '北京', '12345678900', '丝滑', 0, 1, '346', '389');
INSERT INTO `student` VALUES ('14', '张16', '1112325', 16, 2, '汉', 0, '信息', '计算机', '136', '北京', '12345678900', '丝滑', 0, 1, '346', '412');
INSERT INTO `student` VALUES ('15', '张17', '1112326', 16, 3, '汉', 0, '信息', '计算机', '137', '北京', '12345678900', '丝滑', 0, 1, '346', '435');
INSERT INTO `student` VALUES ('16', '张18', '1112327', 16, 4, '汉', 0, '信息', '计算机', '138', '北京', '12345678900', '丝滑', 0, 1, '346', '458');
INSERT INTO `student` VALUES ('17', '张19', '1112328', 17, 1, '汉', 0, '信息', '计算机', '139', '北京', '12345678900', '丝滑', 0, 1, '454', '26');
INSERT INTO `student` VALUES ('18', '张20', '1112329', 17, 2, '汉', 0, '信息', '计算机', '140', '北京', '12345678900', '丝滑', 0, 1, '454', '49');
INSERT INTO `student` VALUES ('19', '张21', '1112330', 17, 3, '汉', 0, '信息', '计算机', '141', '北京', '12345678900', '丝滑', 0, 1, '454', '72');
INSERT INTO `student` VALUES ('2', '张4', '1112313', 13, 2, '汉', 0, '信息', '计算机', '124', '北京', '12345678900', '丝滑', 0, 1, '238', '49');
INSERT INTO `student` VALUES ('20', '张22', '1112331', 17, 4, '汉', 0, '信息', '计算机', '142', '北京', '12345678900', '丝滑', 0, 1, '454', '95');
INSERT INTO `student` VALUES ('21', '张23', '1112332', 18, 1, '汉', 0, '信息', '计算机', '143', '北京', '12345678900', '丝滑', 0, 1, '454', '389');
INSERT INTO `student` VALUES ('22', '张24', '1112333', 18, 2, '汉', 0, '信息', '计算机', '144', '北京', '12345678900', '丝滑', 0, 1, '454', '412');
INSERT INTO `student` VALUES ('23', '张25', '1112334', 18, 3, '汉', 0, '信息', '计算机', '145', '北京', '12345678900', '丝滑', 0, 1, '454', '435');
INSERT INTO `student` VALUES ('24', '张26', '1112335', 18, 4, '汉', 0, '信息', '计算机', '146', '北京', '12345678900', '丝滑', 0, 1, '454', '458');
INSERT INTO `student` VALUES ('25', '张27', '1112336', 19, 1, '汉', 0, '信息', '计算机', '147', '北京', '12345678900', '丝滑', 0, 1, '562', '26');
INSERT INTO `student` VALUES ('26', '张28', '1112337', 19, 2, '汉', 0, '信息', '计算机', '148', '北京', '12345678900', '丝滑', 0, 1, '562', '49');
INSERT INTO `student` VALUES ('27', '张29', '1112338', 19, 3, '汉', 0, '信息', '计算机', '149', '北京', '12345678900', '丝滑', 0, 1, '562', '72');
INSERT INTO `student` VALUES ('28', '张30', '1112339', 19, 4, '汉', 0, '信息', '计算机', '150', '北京', '12345678900', '丝滑', 0, 1, '562', '95');
INSERT INTO `student` VALUES ('3', '张5', '1112314', 13, 3, '汉', 0, '信息', '计算机', '125', '北京', '12345678900', '丝滑', 0, 1, '238', '72');
INSERT INTO `student` VALUES ('4', '张6', '1112315', 13, 4, '汉', 0, '信息', '计算机', '126', '北京', '12345678900', '丝滑', 0, 1, '238', '95');
INSERT INTO `student` VALUES ('5', '张7', '1112316', 14, 1, '汉', 0, '信息', '计算机', '127', '北京', '12345678900', '丝滑', 0, 1, '130', '389');
INSERT INTO `student` VALUES ('6', '张8', '1112317', 14, 2, '汉', 0, '信息', '计算机', '128', '北京', '12345678900', '丝滑', 0, 1, '130', '412');
INSERT INTO `student` VALUES ('7', '张9', '1112318', 14, 3, '汉', 0, '信息', '计算机', '129', '北京', '12345678900', '丝滑', 0, 1, '130', '435');
INSERT INTO `student` VALUES ('8', '张10', '1112319', 14, 4, '汉', 0, '信息', '计算机', '130', '北京', '12345678900', '丝滑', 0, 1, '130', '458');
INSERT INTO `student` VALUES ('9', '张11', '1112320', 15, 1, '汉', 0, '信息', '计算机', '131', '北京', '12345678900', '丝滑', 0, 1, '346', '26');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `room_size_male` int(11) NULL DEFAULT NULL COMMENT '男生房间大小',
  `thread_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '线程id',
  `status` int(11) NULL DEFAULT NULL COMMENT '任务状态 0-未开始 1-正在运行 2-运行结束  -1-任务失败',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '导入学生信息文件（excel）位置',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `male_block` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '男宿舍楼号，逗号分割',
  `female_block` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '女宿舍楼号，逗号分割',
  `room_size_female` int(11) NULL DEFAULT NULL COMMENT '女生房间大小',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, 4, '77', 1, 'E:\\code\\mywork\\dormitory\\server\\file\\file\\学生模板.xlsx', NULL, '1', '2', 4);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userid',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `role` int(11) NOT NULL DEFAULT 1 COMMENT '用户角色 0-admin 1-宿管',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 0, '123456');
INSERT INTO `user` VALUES (2, 'zjl', 1, '123456');
INSERT INTO `user` VALUES (3, 'string', 1, 'string');
INSERT INTO `user` VALUES (4, 'Rick', 1, '123');
INSERT INTO `user` VALUES (5, 'lh', 1, '123');
INSERT INTO `user` VALUES (6, 'lhhh', 1, '123');

SET FOREIGN_KEY_CHECKS = 1;
