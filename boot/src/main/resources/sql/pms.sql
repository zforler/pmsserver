/*
Navicat MySQL Data Transfer

Source Server         : 33.100
Source Server Version : 50642
Source Host           : 192.168.33.100:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2020-09-02 15:29:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for batch
-- ----------------------------
DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `batch_id` varchar(6) NOT NULL,
  `batch_name` varchar(32) NOT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `create_time` int(10) unsigned DEFAULT NULL,
  `update_time` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batch
-- ----------------------------
INSERT INTO `batch` VALUES ('000001', '批次一', '0000', '1598779051', '1598779051');
INSERT INTO `batch` VALUES ('000101', '批次一', '0001', '1598779064', '1598779064');
INSERT INTO `batch` VALUES ('000102', '批次3', '0001', '1598779069', '1598779079');
INSERT INTO `batch` VALUES ('000201', '批次1', '0002', '1598797569', '1598797569');

-- ----------------------------
-- Table structure for batch_item
-- ----------------------------
DROP TABLE IF EXISTS `batch_item`;
CREATE TABLE `batch_item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_id` varchar(255) NOT NULL,
  `batch_id` varchar(6) DEFAULT NULL,
  `begin_time` int(10) DEFAULT NULL,
  `end_time` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batch_item
-- ----------------------------
INSERT INTO `batch_item` VALUES ('1', '1231', '000101', '1598371200', '1598619777');
INSERT INTO `batch_item` VALUES ('2', '1232', '000101', '1597075200', '1597161600');
INSERT INTO `batch_item` VALUES ('3', '123', '000102', '1597939200', '1598630400');
INSERT INTO `batch_item` VALUES ('4', '批次2', '000201', '1598716800', '1598803200');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `card_id` varchar(8) NOT NULL,
  `card_no` varchar(64) DEFAULT NULL,
  `card_name` varchar(64) DEFAULT NULL,
  `card_type` int(2) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `status` int(2) unsigned DEFAULT NULL,
  `create_time` int(10) unsigned DEFAULT '0',
  `update_time` int(10) unsigned DEFAULT '0',
  `append` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('00010001', '1111122', '12333', '2', '0001', '0', '1598594306', '1598594306', null);
INSERT INTO `card` VALUES ('00010002', '4t', '122', '1', '0001', '0', '1598594490', '1598594490', null);
INSERT INTO `card` VALUES ('00010003', '444', '', '1', '0001', '0', '1598679449', '1598679449', null);
INSERT INTO `card` VALUES ('00010004', '12', '', '1', '0001', '0', '1598760031', '1598760031', null);
INSERT INTO `card` VALUES ('00010005', '11222', '', '1', '0001', '0', '1598760037', '1598760037', null);
INSERT INTO `card` VALUES ('00010006', '3333', '', '1', '0001', '0', '1598760043', '1598760043', null);
INSERT INTO `card` VALUES ('00010007', '123444', '', '1', '0001', '0', '1598760049', '1598760049', null);
INSERT INTO `card` VALUES ('00010008', '55555', '', '1', '0001', '0', '1598760054', '1598760054', null);
INSERT INTO `card` VALUES ('00010009', 'rfff', '', '1', '0001', '0', '1598760062', '1598760062', null);
INSERT INTO `card` VALUES ('00010010', 'fffff', '', '1', '0001', '0', '1598760067', '1598760067', null);
INSERT INTO `card` VALUES ('00010011', 'fffff11', '', '1', '0001', '0', '1598760076', '1598760076', null);
INSERT INTO `card` VALUES ('00010012', '33334', '', '1', '0001', '0', '1598760088', '1598760088', null);
INSERT INTO `card` VALUES ('00010013', 'fffffffggg', '', '1', '0001', '0', '1598760113', '1598760113', null);
INSERT INTO `card` VALUES ('00010014', 'sdfgg', '', '1', '0001', '0', '1598760118', '1598760118', null);
INSERT INTO `card` VALUES ('00010015', 'asdf', '', '1', '0001', '0', '1598760122', '1598760122', null);
INSERT INTO `card` VALUES ('00010016', 'gggg', '', '1', '0001', '0', '1598760127', '1598760127', null);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` varchar(4) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `concator` varchar(15) DEFAULT NULL,
  `concator_phone` varchar(32) DEFAULT NULL,
  `status` int(2) unsigned DEFAULT '0',
  `equipment_count` int(4) unsigned DEFAULT '0',
  `create_time` int(10) unsigned DEFAULT NULL,
  `update_time` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('0000', '云平台', null, null, null, '0', '0', null, null);
INSERT INTO `customer` VALUES ('0001', '公司一', '山东青岛', '1111', '1111233', '0', '0', '1598060822', '1598060878');
INSERT INTO `customer` VALUES ('0002', '青岛炜凯', '山东省青岛市', '巨立炜', '19963147413', '0', '0', '1598709861', '1598709861');
INSERT INTO `customer` VALUES ('0003', '123', '123', '123', '123', '0', '0', '1598849542', '1598849542');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `department_id` varchar(64) NOT NULL,
  `customer_id` varchar(4) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  `parents` varchar(255) DEFAULT NULL,
  `begin_time` int(10) unsigned DEFAULT '0',
  `end_time` int(10) unsigned DEFAULT '0',
  `type` int(2) unsigned DEFAULT NULL,
  `status` int(2) unsigned DEFAULT '0',
  `staff_count` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '00010003', '0001', '公司1', null, null, '1598174764', '1598177728', '1', '1', '0');
INSERT INTO `department` VALUES ('2', '00010004', '0001', '公司2', null, null, '1598175540', '0', '1', '0', '0');
INSERT INTO `department` VALUES ('3', '00010005', '0001', '车间1', '00010003', '00010003', '1598175816', '1598177765', '2', '1', '0');
INSERT INTO `department` VALUES ('4', '00010006', '0001', '班组1', '00010005', '00010003,00010005', '1598176311', '0', '3', '0', '2');
INSERT INTO `department` VALUES ('5', '00010007', '0001', '班组2', '00010005', '00010003,00010005', '1598176612', '0', '3', '0', '0');
INSERT INTO `department` VALUES ('6', '00010008', '0001', '部门1', '00010004', '00010004', '1598177371', '0', '1', '0', '0');
INSERT INTO `department` VALUES ('7', '00010009', '0001', '车间1', '00010008', '00010004,00010008', '1598177380', '0', '3', '0', '0');
INSERT INTO `department` VALUES ('8', '00010003', '0001', 'test1', null, null, '1598177728', '0', '1', '0', '0');
INSERT INTO `department` VALUES ('9', '00010005', '0001', '车间11', '00010003', '00010003', '1598177765', '0', '2', '0', '0');
INSERT INTO `department` VALUES ('10', '00010010', '0001', 'ass', '00010005', '00010003,00010005', '1598244415', '0', '3', '0', '0');
INSERT INTO `department` VALUES ('11', '00000001', '0000', '公司', null, null, '1598621206', '0', '1', '0', '0');
INSERT INTO `department` VALUES ('12', '00000002', '0000', '部门', '00000001', 'null,00000001', '1598621218', '0', '1', '0', '0');
INSERT INTO `department` VALUES ('13', '00000003', '0000', '部门', '00000001', 'null,00000001', '1598621229', '1598621256', '1', '1', '0');
INSERT INTO `department` VALUES ('14', '00000003', '0000', '部门1', '00000001', 'null,00000001', '1598621256', '0', '1', '0', '0');
INSERT INTO `department` VALUES ('15', '00000004', '0000', '车间', '00000003', '00000001,00000003', '1598621274', '0', '2', '0', '0');
INSERT INTO `department` VALUES ('16', '00000005', '0000', '班组', '00000004', '00000003,00000004', '1598621301', '0', '3', '0', '2');

-- ----------------------------
-- Table structure for menu_authority
-- ----------------------------
DROP TABLE IF EXISTS `menu_authority`;
CREATE TABLE `menu_authority` (
  `role_id` varchar(8) NOT NULL COMMENT '角色编码',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `authed` tinyint(1) DEFAULT '0' COMMENT '授权标志',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_authority
-- ----------------------------
INSERT INTO `menu_authority` VALUES ('0000', '1', '1');
INSERT INTO `menu_authority` VALUES ('0000', '2', '1');
INSERT INTO `menu_authority` VALUES ('0000', '3', '1');
INSERT INTO `menu_authority` VALUES ('0000', '4', '1');
INSERT INTO `menu_authority` VALUES ('0000', '5', '1');
INSERT INTO `menu_authority` VALUES ('0000', '6', '1');
INSERT INTO `menu_authority` VALUES ('0000', '7', '1');
INSERT INTO `menu_authority` VALUES ('0000', '8', '1');
INSERT INTO `menu_authority` VALUES ('0000', '9', '1');
INSERT INTO `menu_authority` VALUES ('0000', '10', '1');
INSERT INTO `menu_authority` VALUES ('0000', '11', '1');
INSERT INTO `menu_authority` VALUES ('0000', '12', '1');
INSERT INTO `menu_authority` VALUES ('0000', '13', '1');
INSERT INTO `menu_authority` VALUES ('0000', '14', '1');
INSERT INTO `menu_authority` VALUES ('0000', '15', '1');
INSERT INTO `menu_authority` VALUES ('0000', '16', '1');
INSERT INTO `menu_authority` VALUES ('0000', '17', '1');
INSERT INTO `menu_authority` VALUES ('0000', '18', '1');
INSERT INTO `menu_authority` VALUES ('0000', '19', '1');
INSERT INTO `menu_authority` VALUES ('0000', '20', '1');
INSERT INTO `menu_authority` VALUES ('0000', '21', '1');
INSERT INTO `menu_authority` VALUES ('0000', '22', '1');
INSERT INTO `menu_authority` VALUES ('0000', '23', '1');
INSERT INTO `menu_authority` VALUES ('0000', '24', '1');
INSERT INTO `menu_authority` VALUES ('0000', '25', '1');
INSERT INTO `menu_authority` VALUES ('0000', '26', '1');
INSERT INTO `menu_authority` VALUES ('0000', '27', '1');
INSERT INTO `menu_authority` VALUES ('0000', '28', '1');
INSERT INTO `menu_authority` VALUES ('0000', '29', '1');
INSERT INTO `menu_authority` VALUES ('0000', '30', '1');
INSERT INTO `menu_authority` VALUES ('0000', '31', '1');
INSERT INTO `menu_authority` VALUES ('0000', '32', '1');
INSERT INTO `menu_authority` VALUES ('0000', '33', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '1', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '2', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '3', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '4', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '5', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '6', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '7', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '1', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '2', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '5', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '6', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '7', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '8', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '9', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '10', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '11', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '12', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '13', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '14', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '15', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '16', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '17', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '18', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '19', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '20', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '21', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '22', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '23', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '24', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '25', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '26', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '27', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '28', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '1', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '2', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '8', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '9', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '10', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '11', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '12', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '13', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '14', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '15', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '16', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '17', '1');
INSERT INTO `menu_authority` VALUES ('00010001', '18', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '1', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '2', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '5', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '6', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '7', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '8', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '9', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '10', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '11', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '12', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '13', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '14', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '15', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '16', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '17', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '18', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '19', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '20', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '21', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '22', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '23', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '24', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '25', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '26', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '27', '1');
INSERT INTO `menu_authority` VALUES ('00020001', '28', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '1', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '2', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '5', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '6', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '7', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '8', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '9', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '10', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '11', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '12', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '13', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '14', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '15', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '16', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '17', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '18', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '19', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '20', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '21', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '22', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '23', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '24', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '25', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '26', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '27', '1');
INSERT INTO `menu_authority` VALUES ('00020002', '28', '1');

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `menu_id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `type` smallint(2) DEFAULT NULL,
  `hidden` smallint(2) DEFAULT NULL,
  `close` smallint(2) DEFAULT NULL,
  `parent_id` int(4) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `file_path` varchar(128) DEFAULT NULL,
  `level` smallint(2) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '首页', '/', '1', '0', '0', null, 'index', '', '2');
INSERT INTO `menus` VALUES ('2', '首页', '/index', '2', '1', '0', '1', 'index', 'index/index', '2');
INSERT INTO `menus` VALUES ('3', '客户管理', '/', '1', '0', '1', null, 'custom', '', '2');
INSERT INTO `menus` VALUES ('4', '客户管理', '/customer', '2', '1', '1', '3', 'custom', 'customer/customer', '2');
INSERT INTO `menus` VALUES ('5', '人事薪资', '/', '1', '1', '0', null, 'solid', '', '3');
INSERT INTO `menus` VALUES ('6', '员工管理', '/staff', '2', '1', '1', '5', 'staff', 'staff/staff', '3');
INSERT INTO `menus` VALUES ('7', '工资统计', '/salary', '2', '1', '1', '5', 'salary', 'salary/salary', '3');
INSERT INTO `menus` VALUES ('8', '用户管理', '/', '1', '1', '1', null, 'user', '', '3');
INSERT INTO `menus` VALUES ('9', '用户管理', '/user', '2', '1', '1', '8', 'user', 'user/user', '3');
INSERT INTO `menus` VALUES ('10', '角色管理', '/role', '2', '1', '1', '8', 'role', 'user/role', '3');
INSERT INTO `menus` VALUES ('11', '生产管理', '/', '1', '1', '1', null, 'product', '', '3');
INSERT INTO `menus` VALUES ('12', '产品管理', '/production', '2', '1', '1', '11', 'production', 'production/production', '3');
INSERT INTO `menus` VALUES ('13', '工艺管理', '/technology', '2', '1', '1', '11', 'technology', 'production/technology', '3');
INSERT INTO `menus` VALUES ('14', '规格管理', '/spec', '2', '1', '1', '11', 'spec', 'production/spec', '3');
INSERT INTO `menus` VALUES ('15', '批次管理', '/batch', '2', '1', '1', '11', 'batch', 'production/batch', '3');
INSERT INTO `menus` VALUES ('16', '工价管理', '/price', '2', '1', '1', '11', 'price', 'production/price', '3');
INSERT INTO `menus` VALUES ('17', '班次管理', '/shift', '2', '1', '1', '11', 'shift', 'production/shift', '3');
INSERT INTO `menus` VALUES ('18', '交料修正', '/productEdit', '2', '1', '1', '11', 'productEdit', 'production/productEdit', '3');
INSERT INTO `menus` VALUES ('19', '电卡管理', '/', '1', '0', '0', null, 'card', '', '3');
INSERT INTO `menus` VALUES ('20', '电卡管理', '/card', '2', '1', '1', '19', 'card', 'card/card', '3');
INSERT INTO `menus` VALUES ('21', '组织架构管理', '/', '1', '0', '0', null, 'organization', '', '3');
INSERT INTO `menus` VALUES ('22', '组织架构管理', '/organization', '2', '1', '1', '21', 'organization', 'organization/organization', '3');
INSERT INTO `menus` VALUES ('23', '设备管理', '/', '1', '1', '1', null, 'equipment', '', '3');
INSERT INTO `menus` VALUES ('24', '设备管理', '/equipment', '2', '1', '1', '23', 'equip', 'equipment/equipment', '3');
INSERT INTO `menus` VALUES ('25', '设备故障日志', '/equipmentFaultLog', '2', '1', '1', '23', 'equipmentFaultLog', 'equipment/equipmentFaultLog', '3');
INSERT INTO `menus` VALUES ('26', '生产记录', '/productLog', '2', '1', '1', '23', 'productLog', 'equipment/productLog', '3');
INSERT INTO `menus` VALUES ('27', '我的报表', '/', '1', '0', '1', null, 'report', '', '3');
INSERT INTO `menus` VALUES ('28', '我的报表', '/report', '2', '1', '1', '27', 'report', 'report/report', '3');
INSERT INTO `menus` VALUES ('29', '系统设置', '/', '1', '1', '1', null, 'setting', '', '2');
INSERT INTO `menus` VALUES ('30', '菜单管理', '/menu', '2', '1', '1', '29', 'menu', 'system/menu', '2');
INSERT INTO `menus` VALUES ('31', '数据字典', '/dataItem', '2', '1', '1', '29', 'dataItem', 'system/dataItem', '2');
INSERT INTO `menus` VALUES ('32', '操作日志', '/operateLog', '2', '1', '1', '29', 'operateLog', 'system/operateLog', '2');
INSERT INTO `menus` VALUES ('33', '添加客户', '', '3', '1', '1', '4', '', '', '2');

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `production_id` varchar(8) NOT NULL,
  `production_name` varchar(32) NOT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `create_time` int(10) DEFAULT NULL,
  `begin_time` int(10) unsigned DEFAULT '0',
  `end_time` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of production
-- ----------------------------
INSERT INTO `production` VALUES ('1', '00010001', '产品1', '0001', '1598748038', '0', '0');
INSERT INTO `production` VALUES ('2', '00010002', '产品3', '0001', '1598748136', '0', '0');
INSERT INTO `production` VALUES ('3', '00010003', '123', '0001', '1598748771', '1598748771', '1598748771');
INSERT INTO `production` VALUES ('4', '00010003', '1234', '0001', '1598748771', '1598748804', '1598748771');
INSERT INTO `production` VALUES ('5', '00010003', '12345', '0001', '1598748771', '1598748937', '1598749028');
INSERT INTO `production` VALUES ('6', '00010003', '123456', '0001', '1598748771', '1598749028', '0');
INSERT INTO `production` VALUES ('7', '00010004', '产品2', '0001', '1598752316', '1598752316', '0');
INSERT INTO `production` VALUES ('8', '00010005', '123', '0001', '1598752686', '1598752686', '0');
INSERT INTO `production` VALUES ('9', '00020001', '南美白虾', '0002', '1598791563', '1598791563', '0');
INSERT INTO `production` VALUES ('10', '00020002', '罗非鱼', '0002', '1598791572', '1598791572', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(8) NOT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `level` int(2) unsigned DEFAULT '0',
  `create_time` int(10) unsigned DEFAULT '0',
  `update_time` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0000', '超级管理员', '0000', '1', '0', '0');
INSERT INTO `role` VALUES ('00000001', 'test', '0000', '2', '1597980152', '1597980152');
INSERT INTO `role` VALUES ('00000004', '大司马', '0000', null, null, '1598710616');
INSERT INTO `role` VALUES ('00010001', 'test', '0001', null, '1598795621', '1598795621');
INSERT INTO `role` VALUES ('00020001', '系统管理员', '0002', null, null, '1598797244');
INSERT INTO `role` VALUES ('00020002', '办公室主任', '0002', null, null, '1598797805');

-- ----------------------------
-- Table structure for shift
-- ----------------------------
DROP TABLE IF EXISTS `shift`;
CREATE TABLE `shift` (
  `id` int(10) NOT NULL,
  `shift_id` varchar(6) DEFAULT NULL,
  `shift_name` varchar(32) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `active_time` int(10) DEFAULT NULL,
  `reactive_time` int(10) DEFAULT NULL,
  `delay_time` int(4) DEFAULT NULL,
  `begin_time` int(10) DEFAULT NULL,
  `end_time` int(10) DEFAULT NULL,
  `create_time` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shift
-- ----------------------------

-- ----------------------------
-- Table structure for spec
-- ----------------------------
DROP TABLE IF EXISTS `spec`;
CREATE TABLE `spec` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `spec_id` varchar(8) DEFAULT NULL,
  `spec_name` varchar(64) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `production_id` varchar(8) DEFAULT NULL,
  `create_time` int(10) DEFAULT NULL,
  `begin_time` int(11) DEFAULT NULL,
  `end_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spec
-- ----------------------------
INSERT INTO `spec` VALUES ('1', '00010006', '规格1', '0001', '00010001', '1598753854', '1598753854', '0');
INSERT INTO `spec` VALUES ('2', '00010001', '规格11', '0001', '00010001', '1598754255', '1598754255', '1598754266');
INSERT INTO `spec` VALUES ('3', '00010002', '规格1', '0001', '00010002', '1598754262', '1598754262', '0');
INSERT INTO `spec` VALUES ('4', '00010001', '规格111', '0001', '00010001', '1598754255', '1598754266', '0');
INSERT INTO `spec` VALUES ('5', '00020001', '31/40', '0002', '00020001', '1598791642', '1598791642', '0');
INSERT INTO `spec` VALUES ('6', '00020002', '统级', '0002', '00020002', '1598791657', '1598791657', '0');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` varchar(12) NOT NULL,
  `staff_no` varchar(64) DEFAULT NULL,
  `staff_name` varchar(15) DEFAULT NULL,
  `sex` smallint(2) unsigned DEFAULT '1',
  `entry_time` int(10) unsigned DEFAULT '0',
  `leave_time` int(10) unsigned DEFAULT '0',
  `status` smallint(2) unsigned DEFAULT '0',
  `staff_type` int(2) unsigned DEFAULT '0' COMMENT '0正式工1临时工',
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `idcard` varchar(64) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `create_time` int(10) unsigned DEFAULT '0',
  `update_time` int(10) unsigned DEFAULT '0',
  `append` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('000100000001', '000100000001', '张三', '1', '1598425676', '1598441783', '1', '0', '', '', '', '0001', '1598426067', '1598441784', '');
INSERT INTO `staff` VALUES ('000100000002', '000100000002', '李四', '1', '1598427868', '0', '0', '0', '', '', '', '0001', '1598427869', '1598427869', null);
INSERT INTO `staff` VALUES ('000100000003', '000100000003', '顶顶顶', '1', '1598428000', '0', '0', '0', '', '', '', '0001', '1598428001', '1598428001', null);
INSERT INTO `staff` VALUES ('000100000004', '000100000004', '烦烦烦', '1', '1598429040', '0', '99', '0', '18363000394', '', '', '0001', '1598429041', '1598441603', '');
INSERT INTO `staff` VALUES ('000100000005', '000100000005', '1333', '1', '1598442287', '0', '0', '0', '', '', '', '0001', '1598442288', '1598442288', null);
INSERT INTO `staff` VALUES ('000100000006', '000100000006', '12333', '1', '1598442321', '0', '0', '0', '', '', '', '0001', '1598442322', '1598512404', '');
INSERT INTO `staff` VALUES ('000100000007', 'qwe', '123333', '1', '1598793385', '0', '0', '0', '', '', '', '0001', '1598793385', '1598793385', null);
INSERT INTO `staff` VALUES ('000100000008', '1333', '1333', '1', '1598794343', '0', '0', '0', '', '', '', '0001', '1598794344', '1598794344', null);
INSERT INTO `staff` VALUES ('000100000009', 'fffg', '13hbv', '1', '1598794759', '0', '0', '0', '', '', '', '0001', '1598794760', '1598794760', null);
INSERT INTO `staff` VALUES ('000200000001', '1333', '1333', '1', '1598794360', '0', '0', '0', '', '', '', '0002', '1598794361', '1598794361', null);
INSERT INTO `staff` VALUES ('001', '001', '001', '1', '1598792297', '0', '0', '0', '', '', '', '0002', '1598792298', '1598792298', null);
INSERT INTO `staff` VALUES ('123', '123', '1233', '1', '1598442356', '0', '99', '0', '', '', '', '0001', '1598442358', '1598442358', null);
INSERT INTO `staff` VALUES ('12333', '12333', '张三', '1', '1598775956', '0', '0', '0', '', '', '', '0001', '1598775957', '1598775957', null);
INSERT INTO `staff` VALUES ('er333', 'er333', '12344', '1', '1598511934', '0', '99', '0', '', '', '', '0001', '1598511936', '1598511936', null);
INSERT INTO `staff` VALUES ('ffff', 'ffff', 'rrrr', '1', '1598679460', '0', '0', '0', '', '', '', '0001', '1598679465', '1598679465', null);

-- ----------------------------
-- Table structure for staff_card
-- ----------------------------
DROP TABLE IF EXISTS `staff_card`;
CREATE TABLE `staff_card` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(12) DEFAULT NULL,
  `card_id` varchar(8) DEFAULT NULL,
  `begin_time` int(10) unsigned DEFAULT '0',
  `end_time` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_card
-- ----------------------------
INSERT INTO `staff_card` VALUES ('1', '000100000002', '00010002', '1598594490', '0');
INSERT INTO `staff_card` VALUES ('2', 'ffff', '00010003', '1598679465', '0');
INSERT INTO `staff_card` VALUES ('3', '000100000001', '00010004', '1598761173', '1598762069');
INSERT INTO `staff_card` VALUES ('4', '000100000001', '00010005', '1598761173', '1598762071');
INSERT INTO `staff_card` VALUES ('5', '000100000001', '00010006', '1598761211', '1598772455');
INSERT INTO `staff_card` VALUES ('6', '000100000001', '00010001', '1598761211', '1598772455');
INSERT INTO `staff_card` VALUES ('7', '000100000001', '00010007', '1598761211', '1598772456');
INSERT INTO `staff_card` VALUES ('8', '000100000001', '00010004', '1598762079', '1598772456');
INSERT INTO `staff_card` VALUES ('9', '000100000001', '00010005', '1598762079', '1598772456');
INSERT INTO `staff_card` VALUES ('10', '000100000001', '00010008', '1598762079', '0');
INSERT INTO `staff_card` VALUES ('11', '000100000001', '00010009', '1598762079', '0');
INSERT INTO `staff_card` VALUES ('12', '000100000001', '00010010', '1598762079', '1598794652');
INSERT INTO `staff_card` VALUES ('14', '000100000001', '00010004', '1598773275', '1598793411');
INSERT INTO `staff_card` VALUES ('15', '000100000001', '00010005', '1598773275', '1598793410');
INSERT INTO `staff_card` VALUES ('16', '000100000001', '00010006', '1598793400', '1598793410');
INSERT INTO `staff_card` VALUES ('17', '000100000001', '00010007', '1598793400', '1598793409');
INSERT INTO `staff_card` VALUES ('25', '000100000006', '00010010', '1598794652', '0');
INSERT INTO `staff_card` VALUES ('26', '000100000003', '00010005', '1598794661', '0');

-- ----------------------------
-- Table structure for staff_depart
-- ----------------------------
DROP TABLE IF EXISTS `staff_depart`;
CREATE TABLE `staff_depart` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(64) DEFAULT NULL,
  `department_id` varchar(8) DEFAULT NULL,
  `begin_time` int(10) unsigned DEFAULT '0',
  `end_time` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_depart
-- ----------------------------
INSERT INTO `staff_depart` VALUES ('3', '000100000004', '00010007', '1598429041', '1598441591');
INSERT INTO `staff_depart` VALUES ('8', '000100000004', '00010006', '1598441591', '1598441603');
INSERT INTO `staff_depart` VALUES ('9', '000100000004', '00010010', '1598441603', '0');
INSERT INTO `staff_depart` VALUES ('20', '000100000001', '00010006', '1598503599', '0');
INSERT INTO `staff_depart` VALUES ('21', '000100000002', '00010006', '1598503599', '0');
INSERT INTO `staff_depart` VALUES ('22', '000100000003', '00010007', '1598504047', '1598621636');
INSERT INTO `staff_depart` VALUES ('23', '000100000005', '00010007', '1598504047', '1598621634');
INSERT INTO `staff_depart` VALUES ('24', '000100000006', '00010006', '1598504397', '1598512404');
INSERT INTO `staff_depart` VALUES ('25', '123', '00010006', '1598504397', '1598504398');
INSERT INTO `staff_depart` VALUES ('26', 'er333', '00010010', '1598511957', '1598511971');
INSERT INTO `staff_depart` VALUES ('27', '000100000006', '00010007', '1598512404', '1598621632');

-- ----------------------------
-- Table structure for sys_dic
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic` (
  `code` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `append` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典';

-- ----------------------------
-- Records of sys_dic
-- ----------------------------
INSERT INTO `sys_dic` VALUES ('CARD_STATUS', '电卡状态', null);
INSERT INTO `sys_dic` VALUES ('CARD_TYPE', '电卡类型', null);
INSERT INTO `sys_dic` VALUES ('DEPART_TYPE', '部门类型', null);
INSERT INTO `sys_dic` VALUES ('SEX', '性别', null);
INSERT INTO `sys_dic` VALUES ('STAFF_STATUS', '员工状态', null);
INSERT INTO `sys_dic` VALUES ('STAFF_TYPE', '员工类型', null);

-- ----------------------------
-- Table structure for sys_dic_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic_item`;
CREATE TABLE `sys_dic_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL,
  `item_code` varchar(64) DEFAULT NULL,
  `item_name` varchar(64) DEFAULT NULL,
  `item_order` int(11) DEFAULT NULL,
  `parent_code` varchar(64) DEFAULT NULL,
  `item_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=509 DEFAULT CHARSET=utf8 COMMENT='数据字典项';

-- ----------------------------
-- Records of sys_dic_item
-- ----------------------------
INSERT INTO `sys_dic_item` VALUES ('494', 'SEX', '1', '男', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('495', 'SEX', '2', '女', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('496', 'DEPART_TYPE', '1', '部门', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('497', 'DEPART_TYPE', '2', '车间', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('498', 'DEPART_TYPE', '3', '班组', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('500', 'STAFF_TYPE', '0', '正式工', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('501', 'STAFF_TYPE', '1', '临时工', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('502', 'STAFF_STATUS', '0', '在职', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('503', 'STAFF_STATUS', '1', '离职', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('504', 'CARD_TYPE', '1', '员工卡', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('505', 'CARD_TYPE', '2', '发料卡', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('506', 'CARD_STATUS', '0', '正常', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('507', 'CARD_STATUS', '2', '锁定', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('508', 'CARD_STATUS', '4', '作废', null, null, null);

-- ----------------------------
-- Table structure for sys_seq
-- ----------------------------
DROP TABLE IF EXISTS `sys_seq`;
CREATE TABLE `sys_seq` (
  `seq_key` varchar(64) NOT NULL COMMENT '序号KEY',
  `next_index` int(11) unsigned DEFAULT NULL COMMENT '下一个序号',
  PRIMARY KEY (`seq_key`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统关键业务编号序号表';

-- ----------------------------
-- Records of sys_seq
-- ----------------------------
INSERT INTO `sys_seq` VALUES ('BATCH:0000', '2');
INSERT INTO `sys_seq` VALUES ('BATCH:0001', '3');
INSERT INTO `sys_seq` VALUES ('BATCH:0002', '2');
INSERT INTO `sys_seq` VALUES ('CARD:0001', '17');
INSERT INTO `sys_seq` VALUES ('CARD:null', '2');
INSERT INTO `sys_seq` VALUES ('CUSTOMER:', '4');
INSERT INTO `sys_seq` VALUES ('DEPART:0000', '6');
INSERT INTO `sys_seq` VALUES ('DEPART:0001', '11');
INSERT INTO `sys_seq` VALUES ('PRODUCTION:0001', '6');
INSERT INTO `sys_seq` VALUES ('PRODUCTION:0002', '3');
INSERT INTO `sys_seq` VALUES ('ROLE:0000', '5');
INSERT INTO `sys_seq` VALUES ('ROLE:0001', '2');
INSERT INTO `sys_seq` VALUES ('ROLE:0002', '3');
INSERT INTO `sys_seq` VALUES ('ROLE:null', '2');
INSERT INTO `sys_seq` VALUES ('SPEC:0001', '3');
INSERT INTO `sys_seq` VALUES ('SPEC:0002', '3');
INSERT INTO `sys_seq` VALUES ('STAFF:0001', '10');
INSERT INTO `sys_seq` VALUES ('STAFF:0002', '2');
INSERT INTO `sys_seq` VALUES ('TECH:0001', '10');
INSERT INTO `sys_seq` VALUES ('TECH:0002', '3');
INSERT INTO `sys_seq` VALUES ('USER:0000', '11');
INSERT INTO `sys_seq` VALUES ('USER:0001', '2');
INSERT INTO `sys_seq` VALUES ('USER:0002', '4');

-- ----------------------------
-- Table structure for technology
-- ----------------------------
DROP TABLE IF EXISTS `technology`;
CREATE TABLE `technology` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `technology_id` varchar(8) NOT NULL,
  `technology_name` varchar(64) NOT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `production_id` varchar(8) DEFAULT NULL,
  `create_time` int(10) unsigned DEFAULT NULL,
  `begin_time` int(10) unsigned DEFAULT NULL,
  `end_time` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technology
-- ----------------------------
INSERT INTO `technology` VALUES ('1', '00010001', '工艺1', '0001', '00010001', '1598751609', '1598751609', '1598752725');
INSERT INTO `technology` VALUES ('2', '00010002', '工艺2', '0001', '00010002', '1598751639', '1598751639', '1598751784');
INSERT INTO `technology` VALUES ('3', '00010002', '工艺22', '0001', '00010002', '1598751639', '1598751784', '0');
INSERT INTO `technology` VALUES ('4', '00010003', 'fff', '0001', '00010003', '1598751798', '1598751798', '0');
INSERT INTO `technology` VALUES ('5', '00010004', 'ff', '0001', '00010001', '1598751803', '1598751803', '0');
INSERT INTO `technology` VALUES ('6', '00010005', '工艺1', '0001', '00010002', '1598752708', '1598752708', '0');
INSERT INTO `technology` VALUES ('7', '00010001', '工艺2', '0001', '00010001', '1598751609', '1598752725', '0');
INSERT INTO `technology` VALUES ('8', '00020001', '剥虾仁开背', '0002', '00020001', '1598791617', '1598791617', '0');
INSERT INTO `technology` VALUES ('9', '00020002', '开片', '0002', '00020002', '1598791627', '1598791627', '0');

-- ----------------------------
-- Table structure for time_price
-- ----------------------------
DROP TABLE IF EXISTS `time_price`;
CREATE TABLE `time_price` (
  `id` int(11) NOT NULL,
  `department_id` varchar(64) DEFAULT NULL,
  `price` int(10) unsigned DEFAULT '0',
  `begin_time` int(10) unsigned DEFAULT '0',
  `end_time` int(10) unsigned DEFAULT '0',
  `type` smallint(2) unsigned DEFAULT '0' COMMENT '0继承父节点价格1自定义',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of time_price
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(8) NOT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `real_name` varchar(15) DEFAULT NULL,
  `sex` int(2) unsigned DEFAULT '1',
  `phone` varchar(32) DEFAULT NULL,
  `create_time` int(10) unsigned DEFAULT '0',
  `update_time` int(10) unsigned DEFAULT '0',
  `role_id` varchar(8) DEFAULT NULL,
  `status` int(2) unsigned DEFAULT '0' COMMENT '99删除',
  `append` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('00000000', '0000', 'admin', '25d55ad283aa400af464c76d713c07ad', '超级管理员', '1', '1', null, null, '0000', '0', null);
INSERT INTO `user_info` VALUES ('00000005', '0000', 'test1', '25d55ad283aa400af464c76d713c07ad', 'tt33', '1', '1233333', '1598055857', '1598057024', '', null, '');
INSERT INTO `user_info` VALUES ('00000006', '0000', 'taa', '25d55ad283aa400af464c76d713c07ad', 'ssss', '1', '123444', '1598056806', '1598056806', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000007', '0000', 'ttr', '25d55ad283aa400af464c76d713c07ad', 'sssss', '1', '1111', '1598057364', '1598057364', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000008', '0000', '1234', '25d55ad283aa400af464c76d713c07ad', '1231321', '1', '12313', '1598057403', '1598057403', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000009', '0000', '1234', '25d55ad283aa400af464c76d713c07ad', '1231321', '1', '12313', '1598057585', '1598057585', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000010', '0000', '曹子建', '25d55ad283aa400af464c76d713c07ad', '曹子建', '1', '12345678901', '1598710350', '1598710561', '00000004', '0', '');
INSERT INTO `user_info` VALUES ('00010001', '0001', '123', '25d55ad283aa400af464c76d713c07ad', '133333', '2', '123333', '1598102134', '1598795905', '00010001', '0', '');
INSERT INTO `user_info` VALUES ('00020001', '0002', 'juliwei', '25d55ad283aa400af464c76d713c07ad', '巨立炜', '1', '19963147413', '1598797188', '1598797188', '00020001', '0', null);
INSERT INTO `user_info` VALUES ('00020002', '0002', 'juliwei2', '25d55ad283aa400af464c76d713c07ad', '巨立炜2', '1', '19963147413', '1598797758', '1598797758', '00020002', '0', null);
INSERT INTO `user_info` VALUES ('00020003', '0002', 'juliwei3', '25d55ad283aa400af464c76d713c07ad', '巨立炜', '1', '19963147413', '1598871885', '1598871885', '00020001', '0', null);
