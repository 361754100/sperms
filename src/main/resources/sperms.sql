/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : sperms

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-07-06 15:15:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for caculation_method
-- ----------------------------
DROP TABLE IF EXISTS `caculation_method`;
CREATE TABLE `caculation_method` (
  `cm_no` char(3) CHARACTER SET utf8 NOT NULL COMMENT '计费编号',
  `cm_day` int(11) DEFAULT NULL COMMENT '按天或按量',
  `cm_fee` int(11) DEFAULT NULL COMMENT '客户编号',
  `cm_remain` int(11) DEFAULT NULL COMMENT '保留',
  PRIMARY KEY (`cm_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='费用计算方式';

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_no` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '客户编号',
  `customer_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户姓名',
  `customer_sex` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户性别',
  `customer_age` int(11) DEFAULT NULL COMMENT '客户年龄',
  `customer_phone` char(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户手机',
  `customer_email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户邮箱',
  `customer_addr` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户邮箱',
  `customer_company` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户单位',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_no`),
  KEY `idx_customer_phone` (`customer_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户表';

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `e_id` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '设备编号',
  `e_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备名称',
  `e_standard` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '规格',
  `e_manufacturer` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产厂家',
  `e_type` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型',
  `e_date` datetime DEFAULT NULL COMMENT '生产日期',
  `e_state` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`e_id`),
  KEY `idx_equipment_e_state` (`e_state`),
  KEY `idx_equipment_e_type` (`e_type`),
  KEY `idx_equipment_e_manufacturer` (`e_manufacturer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备表';

-- ----------------------------
-- Table structure for equipment_enable
-- ----------------------------
DROP TABLE IF EXISTS `equipment_enable`;
CREATE TABLE `equipment_enable` (
  `e_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备编号',
  `ee_enable` int(11) DEFAULT NULL COMMENT '应用授权（0：关停；1：正常使用）',
  `ee_condition` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '状况',
  `ee_longitude` varchar(15) CHARACTER SET utf8 DEFAULT NULL COMMENT 'GPS经度',
  `ee_latitude` varchar(15) CHARACTER SET utf8 DEFAULT NULL COMMENT 'GPS纬度'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备应用表';

-- ----------------------------
-- Table structure for production_stat
-- ----------------------------
DROP TABLE IF EXISTS `production_stat`;
CREATE TABLE `production_stat` (
  `e_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备编号',
  `ps_date` datetime DEFAULT NULL COMMENT '开始日期',
  `ps_end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `ps_mount` int(11) DEFAULT NULL COMMENT '产量',
  KEY `idx_production_stat_e_id` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='生产统计表';

-- ----------------------------
-- Table structure for rent_manager
-- ----------------------------
DROP TABLE IF EXISTS `rent_manager`;
CREATE TABLE `rent_manager` (
  `trade_no` char(20) CHARACTER SET utf8 NOT NULL COMMENT '交易编号',
  `e_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备编号',
  `customer_no` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户编号',
  `rent_date` datetime DEFAULT NULL COMMENT '租借时间',
  `rent_end_date` datetime DEFAULT NULL COMMENT '租借结束时间',
  `cm_no` char(3) CHARACTER SET utf8 DEFAULT NULL COMMENT '计费方式',
  `rent_place` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '使用地点',
  PRIMARY KEY (`trade_no`),
  KEY `idx_rent_manager_e_id` (`e_id`),
  KEY `idx_rent_manager_customer_no` (`customer_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='租赁表';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '系统菜单',
  `menu_status` int(11) DEFAULT NULL COMMENT '菜单状态',
  `menu_url` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单链接',
  `menu_icon` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单图标',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点ID（默认根节点ID为0）',
  `menu_remark` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单备注',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`),
  KEY `idx_sys_menu_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统菜单表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名称',
  `role_status` int(11) DEFAULT NULL COMMENT '角色状态',
  `role_remark` varchar(200) DEFAULT NULL COMMENT '角色备注',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for sys_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_relation`;
CREATE TABLE `sys_role_menu_relation` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  KEY `idx_sys_role_menu_relation_role_id` (`role_id`) USING BTREE,
  KEY `idx_sys_role_menu_relation_menu_id` (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色与菜单关联表';

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '用户账号',
  `u_name` varchar(20) DEFAULT NULL,
  `u_password` varchar(20) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '用户角色类型',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for users_customer_relation
-- ----------------------------
DROP TABLE IF EXISTS `users_customer_relation`;
CREATE TABLE `users_customer_relation` (
  `u_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '系统用户账号',
  `customer_no` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户编号',
  KEY `idx_users_customer_relation_uid` (`u_id`),
  KEY `idx_users_customer_relation_customer_no` (`customer_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户与客户关联表';
