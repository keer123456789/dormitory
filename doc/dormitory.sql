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

 Date: 02/05/2021 22:36:46
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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '宿舍楼信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of block
-- ----------------------------
INSERT INTO `block` VALUES (1, '3号楼-男', 6, 5, 2, 0);
INSERT INTO `block` VALUES (2, '4号楼-女', 4, 5, NULL, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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

-- ----------------------------
-- Table structure for object
-- ----------------------------
DROP TABLE IF EXISTS `object`;
CREATE TABLE `object`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物品名称',
  `floor_id` int(11) NULL DEFAULT NULL COMMENT '楼层id',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '楼层平面图中的标记位置',
  `type` int(11) NULL DEFAULT NULL COMMENT '物品类别   0-消防器材 1-灯 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '物品信息表' ROW_FORMAT = Dynamic;

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
  `location_x` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 x轴坐标',
  `location_y` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 y轴坐标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '房间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '101', 4, 0, 1, NULL, NULL);
INSERT INTO `room` VALUES (2, '102', 4, 0, 1, NULL, NULL);
INSERT INTO `room` VALUES (3, '103', 4, 0, 1, NULL, NULL);
INSERT INTO `room` VALUES (4, '104', 4, 0, 1, NULL, NULL);
INSERT INTO `room` VALUES (5, '105', 4, 0, 1, NULL, NULL);
INSERT INTO `room` VALUES (6, '106', 4, 0, 1, NULL, NULL);
INSERT INTO `room` VALUES (7, '107', 4, 0, 1, NULL, NULL);
INSERT INTO `room` VALUES (8, '108', 6, 6, 1, NULL, NULL);
INSERT INTO `room` VALUES (9, '109', 6, 6, 1, NULL, NULL);
INSERT INTO `room` VALUES (10, '110', 6, 6, 1, NULL, NULL);
INSERT INTO `room` VALUES (11, '201', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (12, '202', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (13, '203', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (14, '204', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (15, '205', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (16, '206', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (17, '207', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (18, '208', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (19, '209', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (20, '210', 6, 6, 2, NULL, NULL);
INSERT INTO `room` VALUES (21, '301', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (22, '302', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (23, '303', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (24, '304', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (25, '305', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (26, '306', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (27, '307', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (28, '308', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (29, '309', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (30, '310', 6, 6, 3, NULL, NULL);
INSERT INTO `room` VALUES (31, '401', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (32, '402', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (33, '403', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (34, '404', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (35, '405', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (36, '406', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (37, '407', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (38, '408', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (39, '409', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (40, '410', 6, 6, 4, NULL, NULL);
INSERT INTO `room` VALUES (41, '501', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (42, '502', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (43, '503', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (44, '504', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (45, '505', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (46, '506', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (47, '507', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (48, '508', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (49, '509', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (50, '510', 6, 6, 5, NULL, NULL);
INSERT INTO `room` VALUES (51, '101', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (52, '102', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (53, '103', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (54, '104', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (55, '105', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (56, '106', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (57, '107', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (58, '108', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (59, '109', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (60, '110', 4, 4, 6, NULL, NULL);
INSERT INTO `room` VALUES (61, '201', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (62, '202', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (63, '203', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (64, '204', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (65, '205', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (66, '206', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (67, '207', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (68, '208', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (69, '209', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (70, '210', 4, 4, 7, NULL, NULL);
INSERT INTO `room` VALUES (71, '301', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (72, '302', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (73, '303', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (74, '304', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (75, '305', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (76, '306', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (77, '307', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (78, '308', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (79, '309', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (80, '310', 4, 4, 8, NULL, NULL);
INSERT INTO `room` VALUES (81, '401', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (82, '402', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (83, '403', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (84, '404', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (85, '405', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (86, '406', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (87, '407', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (88, '408', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (89, '409', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (90, '410', 4, 4, 9, NULL, NULL);
INSERT INTO `room` VALUES (91, '501', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (92, '502', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (93, '503', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (94, '504', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (95, '505', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (96, '506', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (97, '507', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (98, '508', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (99, '509', 4, 4, 10, NULL, NULL);
INSERT INTO `room` VALUES (100, '510', 4, 4, 10, NULL, NULL);

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
  `location_x` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 x轴位置',
  `location_y` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '平面图位置 y轴位置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张3', '1112313', 1, 1, '汉', 0, '信息', '计算机', '123', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('10', '张12', '1112321', 3, 2, '汉', 0, '信息', '计算机', '132', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('11', '张13', '1112322', 3, 3, '汉', 0, '信息', '计算机', '133', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('12', '张14', '1112323', 3, 4, '汉', 0, '信息', '计算机', '134', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('13', '张15', '1112324', 4, 1, '汉', 0, '信息', '计算机', '135', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('14', '张16', '1112325', 4, 2, '汉', 0, '信息', '计算机', '136', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('15', '张17', '1112326', 4, 3, '汉', 0, '信息', '计算机', '137', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('16', '张18', '1112327', 4, 4, '汉', 0, '信息', '计算机', '138', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('17', '张19', '1112328', 5, 1, '汉', 0, '信息', '计算机', '139', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('18', '张20', '1112329', 5, 2, '汉', 0, '信息', '计算机', '140', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('19', '张21', '1112330', 5, 3, '汉', 0, '信息', '计算机', '141', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('2', '张4', '1112313', 1, 2, '汉', 0, '信息', '计算机', '124', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('20', '张22', '1112331', 5, 4, '汉', 0, '信息', '计算机', '142', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('21', '张23', '1112332', 6, 1, '汉', 0, '信息', '计算机', '143', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('22', '张24', '1112333', 6, 2, '汉', 0, '信息', '计算机', '144', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('23', '张25', '1112334', 6, 3, '汉', 0, '信息', '计算机', '145', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('24', '张26', '1112335', 6, 4, '汉', 0, '信息', '计算机', '146', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('25', '张27', '1112336', 7, 1, '汉', 0, '信息', '计算机', '147', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('26', '张28', '1112337', 7, 2, '汉', 0, '信息', '计算机', '148', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('27', '张29', '1112338', 7, 3, '汉', 0, '信息', '计算机', '149', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('28', '张30', '1112339', 7, 4, '汉', 0, '信息', '计算机', '150', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('3', '张5', '1112314', 1, 3, '汉', 0, '信息', '计算机', '125', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('4', '张6', '1112315', 1, 4, '汉', 0, '信息', '计算机', '126', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('5', '张7', '1112316', 2, 1, '汉', 0, '信息', '计算机', '127', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('6', '张8', '1112317', 2, 2, '汉', 0, '信息', '计算机', '128', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('7', '张9', '1112318', 2, 3, '汉', 0, '信息', '计算机', '129', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('8', '张10', '1112319', 2, 4, '汉', 0, '信息', '计算机', '130', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);
INSERT INTO `student` VALUES ('9', '张11', '1112320', 3, 1, '汉', 0, '信息', '计算机', '131', '北京', '12345678900', '丝滑', 0, 1, NULL, NULL);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `room_size` int(11) NULL DEFAULT NULL COMMENT '房间大小',
  `thread_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '线程id',
  `status` int(11) NULL DEFAULT NULL COMMENT '任务状态 0-未开始 1-正在运行 2-运行结束  -1-任务失败',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '导入学生信息文件（excel）位置',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `male_block` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '男宿舍楼号，逗号分割',
  `female_block` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '女宿舍楼号，逗号分割',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, 4, '70', 1, 'E:\\code\\mywork\\dormitory\\server\\file\\file\\学生模板.xlsx', NULL, '1', '2');

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 0, '123456');
INSERT INTO `user` VALUES (2, 'zjl', 1, '123456');

SET FOREIGN_KEY_CHECKS = 1;
