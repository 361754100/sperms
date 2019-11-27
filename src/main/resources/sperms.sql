/*
Navicat MySQL Data Transfer

Source Server         : localhost(sperms)
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : db_sperms

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2019-11-27 16:59:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for caculation_method
-- ----------------------------
DROP TABLE IF EXISTS `caculation_method`;
CREATE TABLE `caculation_method` (
  `cm_no` char(3) CHARACTER SET utf8 NOT NULL COMMENT '计费编号',
  `cm_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '计费名称',
  `cm_type` int(11) DEFAULT NULL COMMENT '按天或按量,1=按量;2=按天;3=其它',
  `cm_unit` int(11) DEFAULT NULL COMMENT '计量单位',
  `cm_price` double(11,0) DEFAULT NULL COMMENT '单价',
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
  `customer_wx` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户微信号',
  `customer_qq` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户QQ号',
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
  `e_id` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '设备编号',
  `e_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备名称',
  `e_standard` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '规格',
  `e_manufacturer` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产厂家',
  `e_type` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型',
  `e_date` datetime DEFAULT NULL COMMENT '生产日期',
  `e_state` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '状态（1：在线、2：离线、3：停机、4：故障、9：其它)',
  `e_enable` int(11) DEFAULT NULL COMMENT '授权（0：关停；1：正常使用）',
  `e_longitude` varchar(15) CHARACTER SET utf8 DEFAULT NULL COMMENT 'GPS经度',
  `e_latitude` varchar(15) CHARACTER SET utf8 DEFAULT NULL COMMENT 'GPS纬度',
  `e_condition` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '状况描述',
  `android_type` int(11) DEFAULT NULL COMMENT '0 /1  信号类型（0：表示只有0/1信号类型，1：表示可以传输一个Byte类型）',
  `android_address` int(11) DEFAULT NULL COMMENT '安卓modbux数据类型',
  `android_pwd` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '安卓端密钥',
  PRIMARY KEY (`e_id`),
  KEY `idx_equipment_e_state` (`e_state`),
  KEY `idx_equipment_e_type` (`e_type`),
  KEY `idx_equipment_e_manufacturer` (`e_manufacturer`),
  KEY `idx_equipment_e_date` (`e_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备表';

-- ----------------------------
-- Table structure for equipment_enable
-- ----------------------------
DROP TABLE IF EXISTS `equipment_enable`;
CREATE TABLE `equipment_enable` (
  `e_id` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '设备编号',
  `ee_enable` int(11) DEFAULT NULL COMMENT '应用授权（0：关停；1：正常使用）',
  `ee_condition` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '状况',
  `ee_longitude` varchar(15) CHARACTER SET utf8 DEFAULT NULL COMMENT 'GPS经度',
  `ee_latitude` varchar(15) CHARACTER SET utf8 DEFAULT NULL COMMENT 'GPS纬度',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备应用表';

-- ----------------------------
-- Table structure for equipment_err_code
-- ----------------------------
DROP TABLE IF EXISTS `equipment_err_code`;
CREATE TABLE `equipment_err_code` (
  `err_code` varchar(4) NOT NULL COMMENT '设备故障号',
  `err_name` varchar(20) DEFAULT NULL COMMENT '故障名称',
  `err_desc` varchar(50) DEFAULT NULL COMMENT '故障描述',
  PRIMARY KEY (`err_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备故障表';

-- ----------------------------
-- Table structure for lock_rule
-- ----------------------------
DROP TABLE IF EXISTS `lock_rule`;
CREATE TABLE `lock_rule` (
  `lr_no` char(3) NOT NULL COMMENT '锁机策略编号',
  `lr_name` varchar(20) DEFAULT NULL,
  `lr_type` int(11) DEFAULT NULL COMMENT '按天或按量, 1:按量；2:按天；3:其他；',
  `lr_unit` int(11) DEFAULT NULL COMMENT '锁机天数',
  `lr_total` double DEFAULT NULL COMMENT '锁机金额(设备生成的产值达到一定额度后，自动锁机)',
  PRIMARY KEY (`lr_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自动停/锁机策略';

-- ----------------------------
-- Table structure for monitor_pic
-- ----------------------------
DROP TABLE IF EXISTS `monitor_pic`;
CREATE TABLE `monitor_pic` (
  `pic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片编号',
  `e_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备编号',
  `pic_time` datetime DEFAULT NULL,
  `pic_path` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片路径',
  `pic_filename` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片文件名',
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='监控图片';

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pro_id` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '脚手架类别编号',
  `pro_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '脚手架类别名称',
  `pro_type` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '脚手架型号',
  `pro_size` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '脚手架规格',
  `pro_material` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '脚手材质',
  `pro_length` double(11,0) DEFAULT NULL COMMENT '脚手架长度/mm',
  `pro_weight_std` double DEFAULT NULL COMMENT '脚手架理论重量/kg',
  `pro_weight_actual` double DEFAULT NULL COMMENT '脚手架实际重量/kg',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='产品类别';

-- ----------------------------
-- Table structure for production_stat
-- ----------------------------
DROP TABLE IF EXISTS `production_stat`;
CREATE TABLE `production_stat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `e_id` varchar(40) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备编号',
  `ps_date` datetime DEFAULT NULL COMMENT '开始日期',
  `ps_end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `ps_mount` int(11) DEFAULT NULL COMMENT '产量',
  `pro_id` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '产品类别编号',
  `ps_quantity` int(11) DEFAULT NULL COMMENT '数量/根',
  PRIMARY KEY (`id`),
  KEY `idx_production_stat_e_id` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='生产统计表';

-- ----------------------------
-- Table structure for rent_manager
-- ----------------------------
DROP TABLE IF EXISTS `rent_manager`;
CREATE TABLE `rent_manager` (
  `trade_no` char(32) NOT NULL COMMENT '交易编号',
  `e_id` varchar(40) DEFAULT NULL COMMENT '设备编号',
  `customer_no` varchar(20) DEFAULT NULL COMMENT '客户编号',
  `rent_date` datetime DEFAULT NULL COMMENT '租借时间',
  `rent_begin_date` datetime DEFAULT NULL COMMENT '租借开始时间',
  `rent_end_date` datetime DEFAULT NULL COMMENT '租借结束时间',
  `cm_no` char(3) DEFAULT NULL COMMENT '计费方式',
  `rent_place` varchar(50) DEFAULT NULL COMMENT '使用地点',
  `auto_lock` int(11) DEFAULT NULL COMMENT '是否启动自动锁机策略, 0：不启动；1：启动；启动后，同时会检查结束时间，进行确认是否自动锁机',
  `lr_mount` int(11) DEFAULT NULL COMMENT '产量总额(达标锁机), 0为无限量',
  PRIMARY KEY (`trade_no`),
  KEY `idx_rent_manager_customer_no` (`customer_no`),
  KEY `idx_rent_manager_rent_begin_date` (`rent_begin_date`),
  KEY `idx_rent_manager_rent_date` (`rent_date`),
  KEY `idx_rent_manager_rent_end_date` (`rent_end_date`),
  KEY `idx_rent_manager_cm_no` (`cm_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='租赁表';

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修流水号(主键)',
  `e_id` varchar(40) DEFAULT NULL COMMENT '设备编号',
  `r_time` datetime DEFAULT NULL COMMENT '维修时间',
  `r_manufacturer` varchar(50) DEFAULT NULL COMMENT '维修厂家',
  `err_code` varchar(4) DEFAULT NULL COMMENT '故障代码编号',
  `r_state` varchar(20) DEFAULT NULL COMMENT '维修状态（0：维修完成；1：未维修）',
  `r_cost` double DEFAULT NULL COMMENT '维修费用',
  `r_person` varchar(20) DEFAULT NULL COMMENT '维修负责人',
  `down_time` datetime DEFAULT NULL COMMENT '故障时间',
  PRIMARY KEY (`id`),
  KEY `idx_repair_r_time` (`r_time`),
  KEY `idx_repair_err_code` (`err_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设备维修表';

-- ----------------------------
-- Table structure for scrapp
-- ----------------------------
DROP TABLE IF EXISTS `scrapp`;
CREATE TABLE `scrapp` (
  `e_id` varchar(40) NOT NULL COMMENT '设备编号',
  `sc_time` datetime DEFAULT NULL COMMENT '报废日期',
  `sc_reason` varchar(100) DEFAULT NULL COMMENT '报废原因',
  PRIMARY KEY (`e_id`),
  KEY `idx_scrapp_sc_time` (`sc_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='备报废表';

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `store_id` varchar(20) NOT NULL COMMENT '仓库号',
  `store_name` varchar(20) DEFAULT NULL COMMENT '仓库名称',
  `store_place` varchar(100) DEFAULT NULL COMMENT '所在区域',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库表';

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='系统菜单表';

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='系统角色表';

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
  `u_password` varchar(50) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '用户角色类型',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '3', '2019-08-01 16:01:43', '2019-09-09 00:22:50');

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
