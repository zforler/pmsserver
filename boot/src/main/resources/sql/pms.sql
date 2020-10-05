/*
Navicat MySQL Data Transfer

Source Server         : 33.100
Source Server Version : 50642
Source Host           : 192.168.33.100:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2020-10-01 09:21:15
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
INSERT INTO `batch` VALUES ('000002', '批次2', '0000', '1600951453', '1600951453');
INSERT INTO `batch` VALUES ('000101', '批次一', '0001', '1598779064', '1598779064');
INSERT INTO `batch` VALUES ('000102', '批次3', '0001', '1598779069', '1598779079');
INSERT INTO `batch` VALUES ('000201', '批次1', '0002', '1598797569', '1598797569');
INSERT INTO `batch` VALUES ('000202', '批次2', '0002', '1599446735', '1599446735');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of batch_item
-- ----------------------------
INSERT INTO `batch_item` VALUES ('1', '1231', '000101', '1598371200', '1598619777');
INSERT INTO `batch_item` VALUES ('2', '1232', '000101', '1597075200', '1597161600');
INSERT INTO `batch_item` VALUES ('3', '123', '000102', '1597939200', '1598630400');
INSERT INTO `batch_item` VALUES ('4', '2020133', '000201', '1598716800', '1598803200');
INSERT INTO `batch_item` VALUES ('5', '2356', '000201', '1598892780', '1598972400');
INSERT INTO `batch_item` VALUES ('6', 'test', '000001', '1600951408', '1601395200');
INSERT INTO `batch_item` VALUES ('7', 'testt1', '000002', '1600951479', '1601395200');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `card_id` varchar(8) NOT NULL,
  `card_no` varchar(64) DEFAULT NULL,
  `card_out_no` varchar(64) DEFAULT NULL,
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
INSERT INTO `card` VALUES ('00010001', '1111122', null, '12333', '2', '0001', '0', '1598594306', '1598594306', null);
INSERT INTO `card` VALUES ('00010002', '4t', '123111', '122', '1', '0001', '0', '1598594490', '1601089650', '');
INSERT INTO `card` VALUES ('00010003', '444', null, '', '1', '0001', '0', '1598679449', '1598679449', null);
INSERT INTO `card` VALUES ('00010004', '12', null, '', '1', '0001', '0', '1598760031', '1598760031', null);
INSERT INTO `card` VALUES ('00010005', '11222', null, '', '1', '0001', '0', '1598760037', '1598760037', null);
INSERT INTO `card` VALUES ('00010006', '3333', null, '', '1', '0001', '0', '1598760043', '1598760043', null);
INSERT INTO `card` VALUES ('00010007', '123444', null, '', '1', '0001', '0', '1598760049', '1598760049', null);
INSERT INTO `card` VALUES ('00010008', '55555', null, '', '1', '0001', '0', '1598760054', '1598760054', null);
INSERT INTO `card` VALUES ('00010009', 'rfff', null, '', '1', '0001', '0', '1598760062', '1598760062', null);
INSERT INTO `card` VALUES ('00010010', 'fffff', null, '', '1', '0001', '0', '1598760067', '1598760067', null);
INSERT INTO `card` VALUES ('00010011', 'fffff11', null, '', '1', '0001', '0', '1598760076', '1598760076', null);
INSERT INTO `card` VALUES ('00010012', '33334', null, '', '1', '0001', '0', '1598760088', '1598760088', null);
INSERT INTO `card` VALUES ('00010013', 'fffffffggg', null, '', '1', '0001', '0', '1598760113', '1598760113', null);
INSERT INTO `card` VALUES ('00010014', 'sdfgg', null, '', '1', '0001', '0', '1598760118', '1598760118', null);
INSERT INTO `card` VALUES ('00010015', 'asdf', null, '', '1', '0001', '0', '1598760122', '1598760122', null);
INSERT INTO `card` VALUES ('00010016', 'gggg', null, '', '1', '0001', '0', '1598760127', '1598760127', null);
INSERT INTO `card` VALUES ('00010017', '234551234', null, null, '1', '0001', '0', '1599482715', '1599482715', '自动导入');
INSERT INTO `card` VALUES ('00010018', '2345523455', null, null, '2', '0001', '0', '1599482715', '1599482715', '自动导入');
INSERT INTO `card` VALUES ('00010019', '2345512334', null, null, '1', '0001', '0', '1599482715', '1599482715', '自动导入');

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
INSERT INTO `customer` VALUES ('0004', 'rrr2', '山东rrr', 'rrrrr', '18363000394', '0', '0', '1599362632', '1599364559');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

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
INSERT INTO `department` VALUES ('17', '00020001', '0002', 'bumen', null, null, '1599448143', '0', '1', '0', '1');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `equipment_id` varchar(8) NOT NULL,
  `equipment_name` varchar(255) DEFAULT NULL,
  `equipment_type` int(2) DEFAULT NULL,
  `sub_count` int(10) unsigned DEFAULT '0',
  `customer_id` varchar(4) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  `create_time` int(11) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  `append` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('00000001', '1#11', '1', '3', '0000', '0', '1599269876', '1599270399', '');
INSERT INTO `equipment` VALUES ('00000002', '1#2', '0', '0', '0000', '0', '1599270411', '1599270411', null);
INSERT INTO `equipment` VALUES ('00010001', 'test', null, '2', '0001', '0', '1600956645', '1600956645', null);

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
INSERT INTO `menu_authority` VALUES ('0000', '27', '1');
INSERT INTO `menu_authority` VALUES ('0000', '28', '1');
INSERT INTO `menu_authority` VALUES ('0000', '29', '1');
INSERT INTO `menu_authority` VALUES ('0000', '30', '1');
INSERT INTO `menu_authority` VALUES ('0000', '31', '1');
INSERT INTO `menu_authority` VALUES ('0000', '32', '1');
INSERT INTO `menu_authority` VALUES ('0000', '33', '1');
INSERT INTO `menu_authority` VALUES ('0000', '34', '1');
INSERT INTO `menu_authority` VALUES ('0000', '35', '1');
INSERT INTO `menu_authority` VALUES ('0000', '36', '1');
INSERT INTO `menu_authority` VALUES ('0000', '37', '1');
INSERT INTO `menu_authority` VALUES ('0000', '38', '1');
INSERT INTO `menu_authority` VALUES ('0000', '39', '1');
INSERT INTO `menu_authority` VALUES ('0000', '40', '1');
INSERT INTO `menu_authority` VALUES ('0000', '41', '1');
INSERT INTO `menu_authority` VALUES ('0000', '42', '1');
INSERT INTO `menu_authority` VALUES ('0000', '43', '1');
INSERT INTO `menu_authority` VALUES ('0000', '44', '1');
INSERT INTO `menu_authority` VALUES ('0000', '45', '1');
INSERT INTO `menu_authority` VALUES ('0000', '46', '1');
INSERT INTO `menu_authority` VALUES ('0000', '47', '1');
INSERT INTO `menu_authority` VALUES ('0000', '48', '1');
INSERT INTO `menu_authority` VALUES ('0000', '49', '1');
INSERT INTO `menu_authority` VALUES ('0000', '50', '1');
INSERT INTO `menu_authority` VALUES ('0000', '51', '1');
INSERT INTO `menu_authority` VALUES ('0000', '52', '1');
INSERT INTO `menu_authority` VALUES ('0000', '53', '1');
INSERT INTO `menu_authority` VALUES ('0000', '54', '1');
INSERT INTO `menu_authority` VALUES ('0000', '55', '1');
INSERT INTO `menu_authority` VALUES ('0000', '56', '1');
INSERT INTO `menu_authority` VALUES ('0000', '57', '1');
INSERT INTO `menu_authority` VALUES ('0000', '58', '1');
INSERT INTO `menu_authority` VALUES ('0000', '59', '1');
INSERT INTO `menu_authority` VALUES ('0000', '60', '1');
INSERT INTO `menu_authority` VALUES ('0000', '61', '1');
INSERT INTO `menu_authority` VALUES ('0000', '62', '1');
INSERT INTO `menu_authority` VALUES ('0000', '63', '1');
INSERT INTO `menu_authority` VALUES ('0000', '64', '1');
INSERT INTO `menu_authority` VALUES ('0000', '65', '1');
INSERT INTO `menu_authority` VALUES ('0000', '66', '1');
INSERT INTO `menu_authority` VALUES ('0000', '67', '1');
INSERT INTO `menu_authority` VALUES ('0000', '68', '1');
INSERT INTO `menu_authority` VALUES ('0000', '69', '1');
INSERT INTO `menu_authority` VALUES ('0000', '70', '1');
INSERT INTO `menu_authority` VALUES ('0000', '71', '1');
INSERT INTO `menu_authority` VALUES ('0000', '72', '1');
INSERT INTO `menu_authority` VALUES ('0000', '73', '1');
INSERT INTO `menu_authority` VALUES ('0000', '74', '1');
INSERT INTO `menu_authority` VALUES ('0000', '75', '1');
INSERT INTO `menu_authority` VALUES ('0000', '76', '1');
INSERT INTO `menu_authority` VALUES ('0000', '77', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '1', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '2', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '3', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '4', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '5', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '6', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '8', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '9', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '10', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '35', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '64', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '65', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '66', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '67', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '68', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '69', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '70', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '72', '1');
INSERT INTO `menu_authority` VALUES ('00000001', '73', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '1', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '2', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '7', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '18', '1');
INSERT INTO `menu_authority` VALUES ('00000004', '25', '1');
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
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

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
INSERT INTO `menus` VALUES ('27', '我的报表', '/', '1', '0', '1', null, 'report', '', '3');
INSERT INTO `menus` VALUES ('28', '我的报表', '/report', '2', '1', '1', '27', 'report', 'report/report', '3');
INSERT INTO `menus` VALUES ('29', '系统设置', '/', '1', '1', '1', null, 'setting', '', '2');
INSERT INTO `menus` VALUES ('30', '菜单管理', '/menu', '2', '1', '1', '29', 'menu', 'system/menu', '2');
INSERT INTO `menus` VALUES ('31', '数据字典', '/dataItem', '2', '1', '1', '29', 'dataItem', 'system/dataItem', '2');
INSERT INTO `menus` VALUES ('32', '操作日志', '/operateLog', '2', '1', '1', '29', 'operateLog', 'system/operateLog', '2');
INSERT INTO `menus` VALUES ('33', '添加客户', '', '3', '1', '1', '4', '', '', '2');
INSERT INTO `menus` VALUES ('34', '设备详情', '/equipmentDetail', '2', '0', '1', '23', 'equipment', 'equipment/equipmentDetail', '3');
INSERT INTO `menus` VALUES ('35', '编辑客户信息', '', '3', '1', '1', '4', '', '', null);
INSERT INTO `menus` VALUES ('36', '添加IC卡', '', '3', '1', '1', '20', '', '', '2');
INSERT INTO `menus` VALUES ('37', '导入IC卡', '', '3', '1', '1', '20', '', '', '2');
INSERT INTO `menus` VALUES ('38', 'IC卡编辑', '', '3', '1', '1', '20', '', '', '3');
INSERT INTO `menus` VALUES ('39', 'IC卡锁定', '', '3', '1', '1', '20', '', '', '3');
INSERT INTO `menus` VALUES ('40', 'IC卡解锁', '', '3', '1', '1', '20', '', '', '3');
INSERT INTO `menus` VALUES ('41', '添加设备', '', '3', '1', '1', '24', '', '', '2');
INSERT INTO `menus` VALUES ('42', '编辑设备', '', '3', '1', '1', '24', '', '', '2');
INSERT INTO `menus` VALUES ('43', '添加终端', '', '3', '1', '1', '34', '', '', '2');
INSERT INTO `menus` VALUES ('44', '编辑终端', '', '3', '1', '1', '34', '', '', '2');
INSERT INTO `menus` VALUES ('45', '添加组织架构', '', '3', '1', '1', '22', '', '', '3');
INSERT INTO `menus` VALUES ('46', '编辑组织架构', '', '3', '1', '1', '22', '', '', '3');
INSERT INTO `menus` VALUES ('47', '分配员工', '', '3', '1', '1', '22', '', '', '3');
INSERT INTO `menus` VALUES ('48', '添加下级组织架构', '', '3', '1', '1', '22', '', '', '3');
INSERT INTO `menus` VALUES ('49', '移除员工', '', '3', '1', '1', '22', '', '', '3');
INSERT INTO `menus` VALUES ('50', '添加批次', '', '3', '1', '1', '15', '', '', '3');
INSERT INTO `menus` VALUES ('51', '编辑批次', '', '3', '1', '1', '15', '', '', '3');
INSERT INTO `menus` VALUES ('52', '关联批次', '', '3', '1', '1', '15', '', '', '3');
INSERT INTO `menus` VALUES ('53', '编辑关联批次', '', '3', '1', '1', '15', '', '', '3');
INSERT INTO `menus` VALUES ('54', '编辑计价规则', '', '3', '1', '1', '16', '', '', '3');
INSERT INTO `menus` VALUES ('55', '添加计价规则', '', '3', '1', '1', '16', '', '', '3');
INSERT INTO `menus` VALUES ('56', '添加产品', '', '3', '1', '1', '12', '', '', '3');
INSERT INTO `menus` VALUES ('57', '编辑产品', '', '3', '1', '1', '12', '', '', '3');
INSERT INTO `menus` VALUES ('58', '添加班次', '', '3', '1', '1', '17', '', '', '3');
INSERT INTO `menus` VALUES ('59', '编辑班次', '', '3', '1', '1', '17', '', '', '3');
INSERT INTO `menus` VALUES ('60', '添加规格', '', '3', '1', '1', '14', '', '', '3');
INSERT INTO `menus` VALUES ('61', '编辑规格', '', '3', '1', '1', '14', '', '', '3');
INSERT INTO `menus` VALUES ('62', '添加工艺', '', '3', '1', '1', '13', '', '', '3');
INSERT INTO `menus` VALUES ('63', '修改工艺', '', '3', '1', '1', '13', '', '', '3');
INSERT INTO `menus` VALUES ('64', '导入员工', '', '3', '1', '1', '6', '', '', '3');
INSERT INTO `menus` VALUES ('65', '添加员工', '', '3', '1', '1', '6', '', '', '3');
INSERT INTO `menus` VALUES ('66', '编辑员工', '', '3', '1', '1', '6', '', '', '3');
INSERT INTO `menus` VALUES ('67', '绑定IC卡', '', '3', '1', '1', '6', '', '', '3');
INSERT INTO `menus` VALUES ('68', '解绑IC卡', '', '3', '1', '1', '6', '', '', '3');
INSERT INTO `menus` VALUES ('69', '添加角色', '', '3', '1', '1', '10', '', '', '3');
INSERT INTO `menus` VALUES ('70', '修改角色', '', '3', '1', '1', '10', '', '', '3');
INSERT INTO `menus` VALUES ('71', '删除角色', '', '3', '1', '1', '10', '', '', '3');
INSERT INTO `menus` VALUES ('72', '添加用户', '', '3', '1', '1', '9', '', '', '3');
INSERT INTO `menus` VALUES ('73', '修改用户', '', '3', '1', '1', '9', '', '', '3');
INSERT INTO `menus` VALUES ('74', '锁定用户', '', '3', '1', '1', '9', '', '', '3');
INSERT INTO `menus` VALUES ('75', '解锁用户', '', '3', '1', '1', '9', '', '', '3');
INSERT INTO `menus` VALUES ('76', '重置用户密码', '', '3', '1', '1', '9', '', '', '3');
INSERT INTO `menus` VALUES ('77', '工资详情', '/daySalaryDetail', '2', '0', '1', '5', 'operateLog', 'salary/daySalaryDetail', '3');

-- ----------------------------
-- Table structure for price
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `price_id` varchar(8) DEFAULT NULL,
  `price_name` varchar(255) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `production_id` varchar(8) DEFAULT NULL,
  `spec_id` varchar(8) DEFAULT NULL,
  `technology_id` varchar(8) DEFAULT NULL,
  `staff_type` int(2) DEFAULT NULL,
  `shift_id` varchar(8) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `active_time` int(10) DEFAULT NULL,
  `reactive_time` int(10) DEFAULT NULL,
  `create_time` int(10) DEFAULT NULL,
  `update_time` int(10) DEFAULT NULL,
  `send_time` int(10) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `price_type` int(2) DEFAULT NULL,
  `append` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES ('1', '00010002', '', '0001', '00010001', '00010006', '00010004', '0', '', '120', '1599219920', '0', '1599211141', '1599219920', null, null, '1', '');
INSERT INTO `price` VALUES ('2', '00010001', '', '0001', '00010001', '00010006', '00010001', '0', '', '21000', '1599219447', '1599219510', '1599209637', '1599219510', '0', '0', '1', '');
INSERT INTO `price` VALUES ('3', '00010001', '', '0001', '00010001', '00010006', '00010001', '0', '', '210', '1599219510', '0', '1599209637', '1599219510', '0', '0', '1', '');
INSERT INTO `price` VALUES ('4', '00010003', null, '0001', '00010003', '', '', null, '', '100', null, '0', '1599219938', '1599219938', null, null, '1', null);
INSERT INTO `price` VALUES ('5', '00020001', null, '0002', '00020001', '00020001', '00020001', '0', '', '2200', null, '0', '1599446677', '1599446677', null, null, '1', null);
INSERT INTO `price` VALUES ('6', '00010004', null, '0001', '00010001', '', '', null, '', '100', null, '0', '1599569599', '1599569599', null, null, '1', null);
INSERT INTO `price` VALUES ('7', '00010005', null, '0001', '00010001', '00010001', '00010004', null, '', '100', null, '0', '1599569966', '1599569966', null, null, '2', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

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
INSERT INTO `production` VALUES ('11', '00000001', '123', '0000', '1599448184', '1599448184', '0');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` char(22) NOT NULL,
  `customer_id` char(4) DEFAULT NULL,
  `equipment_id` char(8) DEFAULT NULL COMMENT '设备id',
  `dispatch_sub_id` char(10) DEFAULT NULL COMMENT '发料终端id',
  `delivery_sub_id` char(10) DEFAULT NULL COMMENT '交料终端id',
  `sign_sub_id` char(10) DEFAULT NULL,
  `dispatch_card_no` char(8) DEFAULT NULL,
  `delivery_card_no` char(8) DEFAULT NULL,
  `sign_card_no` char(8) DEFAULT NULL,
  `price_type` int(2) unsigned DEFAULT '0' COMMENT '计价类型',
  `dispatch_kg` decimal(8,2) DEFAULT NULL,
  `delivery_count` decimal(8,2) DEFAULT NULL,
  `delivery_kg` decimal(8,2) DEFAULT NULL,
  `yield` decimal(4,2) unsigned DEFAULT '0.00' COMMENT '出成率',
  `price` decimal(8,2) DEFAULT NULL,
  `total_price` decimal(8,2) DEFAULT NULL,
  `price_id` char(8) DEFAULT NULL,
  `staff_no` char(12) DEFAULT NULL,
  `staff_name` varchar(15) DEFAULT NULL,
  `staff_type` int(2) DEFAULT NULL,
  `department_id` char(8) DEFAULT NULL,
  `department_name` varchar(64) DEFAULT NULL,
  `production_id` char(8) DEFAULT NULL,
  `production_name` varchar(32) DEFAULT NULL,
  `spec_id` char(8) DEFAULT NULL,
  `spec_name` varchar(32) DEFAULT NULL,
  `technology_id` char(8) DEFAULT NULL,
  `technology_name` varchar(32) DEFAULT NULL,
  `shift_id` char(6) DEFAULT NULL,
  `shift_name` varchar(32) DEFAULT NULL,
  `delay_time` int(10) DEFAULT NULL,
  `batch_id` char(6) DEFAULT NULL,
  `batch_name` varchar(64) DEFAULT NULL,
  `record_time` int(10) unsigned DEFAULT NULL,
  `report_time` int(10) DEFAULT NULL,
  `calc_time` int(10) unsigned DEFAULT '0' COMMENT '计算时间=记录时间+班次延时',
  `year` int(4) unsigned DEFAULT '0',
  `month` int(2) unsigned DEFAULT '0',
  `day` int(2) unsigned DEFAULT '0',
  `append` varchar(255) DEFAULT NULL,
  `sign_in_time` int(10) unsigned DEFAULT NULL COMMENT '签到时间',
  `sign_out_time` int(10) unsigned DEFAULT NULL COMMENT '签退时间',
  `work_time` int(10) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '0000', '1', '0000000101', '0000000102', null, '1', '2', null, '3', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1318', '谢淑清', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1599828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('10', '0000', '1', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1348', '蓝金荣', '0', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599987986', '1599987986', '1599987986', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('11', '0000', '1', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1399', '梁世群', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次1', '1599987986', '1599987986', '1599987986', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('12', '0000', '2', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '9.00', '9.00', '10.10', '1.00', '10.00', '123', '1403', '黄丽娜', '0', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次1', '1599987986', '1599987986', '1599987986', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('13', '0000', '2', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '100.00', '123', '1364', '荣永易', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次2', '1599987986', '1599987986', '1599987986', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('14', '0000', '3', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1322', '谢振英', '0', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次2', '1599987986', '1599987986', '1599987986', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('15', '0000', '4', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1357', '杨芳', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599987986', '1599987986', '1599987986', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('2', '0000', '1', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1348', '蓝金荣', '0', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1599828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('3', '0000', '1', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1399', '梁世群', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1597828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('311', '0001', '1', '1', '0001000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '0.00', '0.00', '123', '1399', '梁世群', '1', null, '虾车间', '00010002', '南美白虾2', '00010006', '160条', '00010002', '单抽肠', null, null, '0', '', '一批次', '1600957023', '1600957023', '1600957023', '2020', '9', '16', '24', null, null, null);
INSERT INTO `record` VALUES ('4', '0000', '2', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1403', '黄丽娜', '0', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1597828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('411', '0001', '2', '1', '0001000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '0.00', '0.00', '123', '1403', '黄丽娜', '0', null, '虾车间', '00010002', '南美白虾2', '00010006', '160条', '00010002', '单抽肠', null, null, '0', '', '一批次', '1600957023', '1600957023', '1600957023', '2020', '9', '16', '24', null, null, null);
INSERT INTO `record` VALUES ('5', '0000', '2', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1364', '荣永易', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1599828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('511', '0001', '2', '1', '0001000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '0.00', '0.00', '123', '1364', '荣永易', '1', null, '虾车间', '00010002', '南美白虾2', '00010006', '160条', '00010002', '单抽肠', null, null, '0', '', '一批次', '1600957023', '1600957023', '1600957023', '2020', '9', '16', '24', null, null, null);
INSERT INTO `record` VALUES ('7', '0000', '3', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1322', '谢振英', '0', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1598828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('711', '0001', '3', '1', '0001000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '0.00', '0.00', '123', '1322', '谢振英', '0', null, '虾车间', '00010002', '南美白虾2', '00010006', '160条', '00010002', '单抽肠', null, null, '0', '', '一批次', '1600957023', '1600957023', '1600957023', '2020', '9', '16', '24', null, null, null);
INSERT INTO `record` VALUES ('8', '0000', '4', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1357', '杨芳', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1599828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('811', '0001', '4', '11', '0001000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '0.00', '0.00', '123', '1357', '杨芳', '1', null, '虾车间', '00010002', '南美白虾2', '00010006', '160条', '00010002', '单抽肠', null, null, '0', '', '一批次', '1600957023', '1600957023', '1600957023', '2020', '9', '16', '24', null, null, null);
INSERT INTO `record` VALUES ('9', '0000', '1', '0000000101', '0000000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '1.00', '10.00', '123', '1318', '谢淑清', '1', null, '虾车间', null, '南美白虾2', null, '160条', null, '单抽肠', null, null, null, null, '一批次', '1599828987', '1599828987', '1599828987', '2020', '9', '16', null, null, null, null);
INSERT INTO `record` VALUES ('911', '0001', '1', '1', '0001000102', null, '1', '2', null, '1', '11.00', '10.00', '10.00', '10.10', '0.00', '0.00', '123', '1318', '谢淑清', '1', null, '虾车间', '00010002', '南美白虾2', '00010006', '160条', '00010002', '单抽肠', null, null, '0', '', '一批次', '1600957023', '1600957023', '1600957023', '2020', '9', '16', '24', null, null, null);

-- ----------------------------
-- Table structure for record_edit_log
-- ----------------------------
DROP TABLE IF EXISTS `record_edit_log`;
CREATE TABLE `record_edit_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` char(4) DEFAULT NULL,
  `equipment_id` char(8) DEFAULT NULL,
  `sub_equipment_id` char(10) DEFAULT NULL,
  `old_production_id` char(8) DEFAULT NULL,
  `old_production_name` varchar(255) DEFAULT NULL,
  `new_production_id` char(8) DEFAULT NULL,
  `new_production_name` varchar(255) DEFAULT NULL,
  `old_batch_id` char(10) DEFAULT NULL,
  `old_batch_name` varchar(255) DEFAULT NULL,
  `new_batch_id` char(10) DEFAULT NULL,
  `new_batch_name` varchar(255) DEFAULT NULL,
  `old_spec_id` char(8) DEFAULT NULL,
  `old_spec_name` varchar(255) DEFAULT NULL,
  `new_spec_id` char(8) DEFAULT NULL,
  `new_spec_name` varchar(255) DEFAULT NULL,
  `old_technology_id` char(8) DEFAULT NULL,
  `old_technology_name` varchar(255) DEFAULT NULL,
  `new_technology_id` char(255) DEFAULT NULL,
  `new_technology_name` varchar(255) DEFAULT NULL,
  `old_price` int(11) DEFAULT NULL,
  `new_price` int(11) DEFAULT NULL,
  `begin_time` int(11) DEFAULT NULL,
  `end_time` int(11) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  `append` varchar(255) DEFAULT NULL,
  `operate_user_id` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record_edit_log
-- ----------------------------
INSERT INTO `record_edit_log` VALUES ('23', '0001', null, '0001000102', '00010001', '产品1', '00010001', '产品1', '', null, '', null, '00010001', null, '00010006', null, '00010001', null, '00010001', null, null, '0', '1600876800', '1601086824', '1601086825', null, null);
INSERT INTO `record_edit_log` VALUES ('24', '0001', null, '0001000102', '00010001', '产品1', '00010002', '产品3', '', null, '', null, '00010006', '规格1', '00010002', '规格1', '00010001', null, '00010002', '工艺22', null, '0', '1600876800', '1601087030', '1601087031', null, null);
INSERT INTO `record_edit_log` VALUES ('25', '0001', null, '0001000102', '00010001', '产品1', '00010002', '产品3', '', null, '', null, '00010006', '规格1', '00010002', '规格1', '00010004', 'ff', '00010002', '工艺22', null, '0', '1600741487', '1601087098', '1601087099', null, null);
INSERT INTO `record_edit_log` VALUES ('26', '0001', null, '0001000102', '00010001', '产品1', '00010002', '产品3', '1', '1231', '1', '1231', '00010006', '规格1', '00010002', '规格1', '00010004', 'ff', '00010002', '工艺22', null, '0', '1600741487', '1601087098', '1601087106', null, null);

-- ----------------------------
-- Table structure for record_old
-- ----------------------------
DROP TABLE IF EXISTS `record_old`;
CREATE TABLE `record_old` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `record_id` char(22) DEFAULT NULL,
  `customer_id` char(4) DEFAULT NULL,
  `equipment_id` char(8) DEFAULT NULL COMMENT '设备id',
  `dispatch_sub_id` char(10) DEFAULT NULL COMMENT '发料终端id',
  `delivery_sub_id` char(10) DEFAULT NULL COMMENT '交料终端id',
  `sign_sub_id` char(10) DEFAULT NULL,
  `dispatch_card_no` char(8) DEFAULT NULL,
  `delivery_card_no` char(8) DEFAULT NULL,
  `sign_card_no` char(8) DEFAULT NULL,
  `price_type` int(2) unsigned DEFAULT '0' COMMENT '计价类型',
  `dispatch_kg` decimal(8,2) DEFAULT NULL,
  `delivery_count` decimal(8,2) DEFAULT NULL,
  `delivery_kg` decimal(8,2) DEFAULT NULL,
  `yield` decimal(4,2) unsigned DEFAULT '0.00' COMMENT '出成率',
  `price` decimal(8,2) DEFAULT NULL,
  `total_price` decimal(8,2) DEFAULT NULL,
  `price_id` char(8) DEFAULT NULL,
  `staff_no` char(12) DEFAULT NULL,
  `staff_name` varchar(15) DEFAULT NULL,
  `staff_type` int(2) DEFAULT NULL,
  `department_id` char(8) DEFAULT NULL,
  `department_name` varchar(64) DEFAULT NULL,
  `production_id` char(8) DEFAULT NULL,
  `production_name` varchar(32) DEFAULT NULL,
  `spec_id` char(8) DEFAULT NULL,
  `spec_name` varchar(32) DEFAULT NULL,
  `technology_id` char(8) DEFAULT NULL,
  `technology_name` varchar(32) DEFAULT NULL,
  `shift_id` char(6) DEFAULT NULL,
  `shift_name` varchar(32) DEFAULT NULL,
  `delay_time` int(10) DEFAULT NULL,
  `batch_id` char(6) DEFAULT NULL,
  `batch_name` varchar(64) DEFAULT NULL,
  `record_time` int(10) unsigned DEFAULT NULL,
  `report_time` int(10) DEFAULT NULL,
  `calc_time` int(10) unsigned DEFAULT '0' COMMENT '计算时间=记录时间+班次延时',
  `year` int(4) unsigned DEFAULT '0',
  `month` int(2) unsigned DEFAULT '0',
  `day` int(2) unsigned DEFAULT '0',
  `append` varchar(255) DEFAULT NULL,
  `sign_in_time` int(10) unsigned DEFAULT NULL COMMENT '签到时间',
  `sign_out_time` int(10) unsigned DEFAULT NULL COMMENT '签退时间',
  `work_time` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record_old
-- ----------------------------

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `report_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `report_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `status` int(10) unsigned DEFAULT '0',
  `create_time` int(11) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  `append` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('3', '生产记录', '/recordReport', 'report/recordReport', '0', '1599487309', '1599487363', '');
INSERT INTO `report` VALUES ('4', '出成率统计', '/yieldReport', 'report/yieldReport', '0', '1599987823', '1599989327', '');
INSERT INTO `report` VALUES ('5', '产量统计', '/procudtReport', 'report/procudtReport', '0', '1599989367', '1599989367', null);
INSERT INTO `report` VALUES ('6', '员工工资统计', '/salaryReport', 'report/salaryReport', '0', '1600000144', '1600000144', null);

-- ----------------------------
-- Table structure for report_auth
-- ----------------------------
DROP TABLE IF EXISTS `report_auth`;
CREATE TABLE `report_auth` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `report_id` int(11) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `update_time` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report_auth
-- ----------------------------
INSERT INTO `report_auth` VALUES ('5', '3', '0001', '1600001669');
INSERT INTO `report_auth` VALUES ('6', '3', '0002', '1600001669');
INSERT INTO `report_auth` VALUES ('7', '3', '0003', '1600001669');
INSERT INTO `report_auth` VALUES ('8', '3', '0004', '1600001669');
INSERT INTO `report_auth` VALUES ('11', '6', '0003', '1601083350');
INSERT INTO `report_auth` VALUES ('12', '6', '0004', '1601083350');

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
INSERT INTO `role` VALUES ('00000001', 'test', '0000', null, null, '1599917161');
INSERT INTO `role` VALUES ('00000004', '大司马', '0000', null, null, '1601081894');
INSERT INTO `role` VALUES ('00010001', 'test', '0001', null, '1598795621', '1598795621');
INSERT INTO `role` VALUES ('00020001', '系统管理员', '0002', null, null, '1598797244');
INSERT INTO `role` VALUES ('00020002', '办公室主任', '0002', null, null, '1598797805');

-- ----------------------------
-- Table structure for salary_adjust_log
-- ----------------------------
DROP TABLE IF EXISTS `salary_adjust_log`;
CREATE TABLE `salary_adjust_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `staff_no` varchar(64) DEFAULT NULL,
  `customer_id` varchar(4) DEFAULT NULL,
  `adjust` int(10) DEFAULT NULL,
  `subsidy` int(11) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  `operate_user_id` varchar(12) DEFAULT NULL,
  `append` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary_adjust_log
-- ----------------------------
INSERT INTO `salary_adjust_log` VALUES ('1', '1318', '0000', '100', '100', '2020', '9', '16', '1600090601', '00000000', '1');
INSERT INTO `salary_adjust_log` VALUES ('2', '1318', '0000', '200', '200', '2020', '9', '16', '1600090615', '00000000', '2');
INSERT INTO `salary_adjust_log` VALUES ('3', '1403', '0000', '-500', '200', '2020', '9', '16', '1600090843', '00000000', '测试');
INSERT INTO `salary_adjust_log` VALUES ('4', '1399', '0000', '0', '20000', '2020', '9', '16', '1600093850', '00000000', '');
INSERT INTO `salary_adjust_log` VALUES ('5', '1322', '0000', '1000', '1000', '2020', '9', '16', '1601110543', '00000000', null);

-- ----------------------------
-- Table structure for shift
-- ----------------------------
DROP TABLE IF EXISTS `shift`;
CREATE TABLE `shift` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shift
-- ----------------------------
INSERT INTO `shift` VALUES ('1', '000001', '白班1', '0000', '1599056228', '1599056299', '0', '18022', '67825', '1599051692');
INSERT INTO `shift` VALUES ('2', '000002', '夜班', '0000', '1599056194', '1599056565', '0', '69703', '73308', '1599052915');
INSERT INTO `shift` VALUES ('4', '000001', '白班', '0000', '1599056299', '1599056340', '0', '18022', '67825', '1599051692');
INSERT INTO `shift` VALUES ('5', '000001', '白班', '0000', '1599056340', '1599056578', '0', '21622', '67825', '1599051692');
INSERT INTO `shift` VALUES ('6', '000002', '夜班', '0000', '1599056565', '0', '60', '69703', '86400', '1599052915');
INSERT INTO `shift` VALUES ('7', '000001', '白班', '0000', '1599056578', '1599056742', '0', '0', '67825', '1599051692');
INSERT INTO `shift` VALUES ('8', '000001', '白班', '0000', '1599056742', '1599057319', '0', '0', '64225', '1599051692');
INSERT INTO `shift` VALUES ('9', '000001', '白班', '0000', '1599057319', '0', '0', '12300', '64225', '1599051692');
INSERT INTO `shift` VALUES ('10', '000004', 'qwe', '0000', '1599057445', '0', '0', '67031', '69556', '1599057445');
INSERT INTO `shift` VALUES ('11', '000101', '白班', '0001', '1599207568', '0', '0', '22810', '62422', '1599207568');
INSERT INTO `shift` VALUES ('13', '000103', '夜班', '0001', '1599207861', '0', '0', '66787', '84254', '1599207861');
INSERT INTO `shift` VALUES ('14', '000201', '白班', '0002', '1599447742', '0', '60', '0', '86400', '1599447742');

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
INSERT INTO `staff` VALUES ('000000000001', '234551234', 'tom', '1', '0', '0', '0', '0', '', '', null, '0000', '1599399125', '1599399125', '自动导入');
INSERT INTO `staff` VALUES ('000000000002', '2345523455', 'tom1', '2', '0', '0', '0', '1', '', '', null, '0000', '1599399125', '1599399125', '自动导入');
INSERT INTO `staff` VALUES ('000000000003', '2345512334', 'tom2', '1', '0', '0', '0', '0', '', '', null, '0000', '1599399125', '1599399125', '自动导入');
INSERT INTO `staff` VALUES ('000000000004', '', '1231', '1', '1599447602', '0', '0', '0', '', '', '', '0000', '1599447604', '1599447604', null);
INSERT INTO `staff` VALUES ('000000000005', '1318', '大饼', '1', '1600264665', '0', '0', '0', '', '', '', '0000', '1600264667', '1600264667', null);
INSERT INTO `staff` VALUES ('000100000001', '000100000001', '张三', '1', '1598425676', '1598441783', '1', '0', '', '', '', '0001', '1598426067', '1598441784', '');
INSERT INTO `staff` VALUES ('000100000002', '000100000002', '李四', '1', '1598427868', '0', '0', '0', '', '', '', '0001', '1598427869', '1598427869', null);
INSERT INTO `staff` VALUES ('000100000003', '000100000003', '顶顶顶', '1', '1598428000', '0', '0', '0', '', '', '', '0001', '1598428001', '1598428001', null);
INSERT INTO `staff` VALUES ('000100000004', '000100000004', '烦烦烦', '1', '1598429040', '0', '99', '0', '18363000394', '', '', '0001', '1598429041', '1598441603', '');
INSERT INTO `staff` VALUES ('000100000005', '000100000005', '1333', '1', '1598442287', '0', '0', '0', '', '', '', '0001', '1598442288', '1598442288', null);
INSERT INTO `staff` VALUES ('000100000006', '000100000006', '12333', '1', '1598442321', '0', '0', '0', '', '', '', '0001', '1598442322', '1598512404', '');
INSERT INTO `staff` VALUES ('000100000007', 'qwe', '123333', '1', '1598793385', '0', '0', '0', '', '', '', '0001', '1598793385', '1598793385', null);
INSERT INTO `staff` VALUES ('000100000008', '1333', '1333', '1', '1598794343', '0', '0', '0', '', '', '', '0001', '1598794344', '1598794344', null);
INSERT INTO `staff` VALUES ('000100000009', 'fffg', '13hbv', '1', '1598794759', '0', '0', '0', '', '', '', '0001', '1598794760', '1598794760', null);
INSERT INTO `staff` VALUES ('000100000010', '234551234', 'tom', '1', '0', '0', '0', '0', '', '', null, '0001', '1599399450', '1599399450', '自动导入');
INSERT INTO `staff` VALUES ('000100000011', '2345523455', 'tom1', '2', '0', '0', '0', '1', '', '', null, '0001', '1599399450', '1599399450', '自动导入');
INSERT INTO `staff` VALUES ('000100000012', '2345512334', 'tom2', '1', '0', '0', '0', '0', '', '', null, '0001', '1599399450', '1599399450', '自动导入');
INSERT INTO `staff` VALUES ('000200000001', '1333', '1333', '1', '1598794360', '0', '0', '0', '', '', '', '0002', '1598794361', '1601092523', '');
INSERT INTO `staff` VALUES ('000300000016', '234551234', 'tom', '1', '1580486400', '0', '0', '0', '', '', null, '0003', '1599401706', '1599401706', '自动导入');
INSERT INTO `staff` VALUES ('000300000017', '2345523455', 'tom1', '2', '1580572800', '0', '0', '1', '', '', null, '0003', '1599401706', '1599401706', '自动导入');
INSERT INTO `staff` VALUES ('000300000018', '2345512334', 'tom2', '1', '1580659200', '0', '0', '0', '', '', null, '0003', '1599401706', '1599401706', '自动导入');
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_card
-- ----------------------------
INSERT INTO `staff_card` VALUES ('1', '000100000002', '00010002', '1598594490', '1601089650');
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
INSERT INTO `staff_card` VALUES ('27', '000100000011', '00010019', '1599482734', '0');
INSERT INTO `staff_card` VALUES ('33', '000100000007', '00010002', '1601089650', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

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
INSERT INTO `staff_depart` VALUES ('30', '000200000001', '00020001', '1601092523', '0');

-- ----------------------------
-- Table structure for sub_equipment
-- ----------------------------
DROP TABLE IF EXISTS `sub_equipment`;
CREATE TABLE `sub_equipment` (
  `sub_equipment_id` varchar(10) NOT NULL,
  `sub_equipment_name` varchar(255) DEFAULT NULL,
  `type` int(11) unsigned DEFAULT NULL,
  `equipment_id` varchar(8) DEFAULT NULL,
  `staff_type_calc` int(2) unsigned DEFAULT NULL COMMENT '员工类型计费',
  `shift_calc` int(2) unsigned DEFAULT NULL COMMENT '班次计费',
  `create_time` int(11) DEFAULT NULL,
  `update_time` int(11) DEFAULT NULL,
  `append` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sub_equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_equipment
-- ----------------------------
INSERT INTO `sub_equipment` VALUES ('0000000101', '1-3', '1', '00000001', '1', '0', '1599289067', '1599289361', '');
INSERT INTO `sub_equipment` VALUES ('0000000102', '1-2', '1', '00000001', '0', '0', '1599289183', '1599289183', null);
INSERT INTO `sub_equipment` VALUES ('0000000103', '1-4', '1', '00000001', '1', '0', '1599740630', '1599740630', null);
INSERT INTO `sub_equipment` VALUES ('0001000101', 'testa', '0', '00010001', '0', '0', '1600956655', '1600956655', null);
INSERT INTO `sub_equipment` VALUES ('0001000102', 'testb', '1', '00010001', '0', '0', '1600956663', '1600956663', null);

-- ----------------------------
-- Table structure for sub_equipment_calc_log
-- ----------------------------
DROP TABLE IF EXISTS `sub_equipment_calc_log`;
CREATE TABLE `sub_equipment_calc_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sub_equipment_id` char(10) DEFAULT NULL,
  `type` int(2) unsigned DEFAULT NULL,
  `begin_time` int(10) unsigned DEFAULT NULL,
  `end_time` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sub_equipment_calc_log
-- ----------------------------
INSERT INTO `sub_equipment_calc_log` VALUES ('6', '0000000101', '1', '1599740214', '1599740247');
INSERT INTO `sub_equipment_calc_log` VALUES ('7', '0000000102', '2', '1599740221', '1599740238');
INSERT INTO `sub_equipment_calc_log` VALUES ('8', '0000000101', '2', '1599740228', '1599740288');
INSERT INTO `sub_equipment_calc_log` VALUES ('9', '0000000102', '1', '1599740233', '1599740273');
INSERT INTO `sub_equipment_calc_log` VALUES ('10', '0000000102', '2', '1599740253', '1599740263');
INSERT INTO `sub_equipment_calc_log` VALUES ('11', '0000000101', '1', '1599740258', '1599740289');
INSERT INTO `sub_equipment_calc_log` VALUES ('12', '0000000101', '1', '1599740293', '1599740317');
INSERT INTO `sub_equipment_calc_log` VALUES ('13', '0000000102', '2', '1599740294', '1599740320');
INSERT INTO `sub_equipment_calc_log` VALUES ('14', '0000000102', '1', '1599740296', '1599740299');
INSERT INTO `sub_equipment_calc_log` VALUES ('15', '0000000101', '2', '1599740297', '1599740316');
INSERT INTO `sub_equipment_calc_log` VALUES ('16', '0000000102', '1', '1599740310', '1599740319');
INSERT INTO `sub_equipment_calc_log` VALUES ('17', '0000000101', '1', '1599740360', '1599740595');
INSERT INTO `sub_equipment_calc_log` VALUES ('18', '0000000101', '2', '1599740599', '1601083186');
INSERT INTO `sub_equipment_calc_log` VALUES ('19', '0000000101', '1', '1599740843', '1601083189');
INSERT INTO `sub_equipment_calc_log` VALUES ('20', '0000000103', '1', '1599745277', '0');
INSERT INTO `sub_equipment_calc_log` VALUES ('21', '0000000101', '1', '1601083248', '0');

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
INSERT INTO `sys_dic` VALUES ('ACTIVE_FLAG', '生效标志', null);
INSERT INTO `sys_dic` VALUES ('CARD_STATUS', '电卡状态', null);
INSERT INTO `sys_dic` VALUES ('CARD_TYPE', '电卡类型', null);
INSERT INTO `sys_dic` VALUES ('DEPART_TYPE', '部门类型', null);
INSERT INTO `sys_dic` VALUES ('EQUIP_STATUS', '设备状态', null);
INSERT INTO `sys_dic` VALUES ('EQUIP_TYPE', '设备类型', null);
INSERT INTO `sys_dic` VALUES ('PRICE_TYPE', '计价类型', null);
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
) ENGINE=InnoDB AUTO_INCREMENT=522 DEFAULT CHARSET=utf8 COMMENT='数据字典项';

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
INSERT INTO `sys_dic_item` VALUES ('509', 'EQUIP_TYPE', '0', '发料', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('510', 'EQUIP_TYPE', '1', '交料计重', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('511', 'EQUIP_TYPE', '2', '交料计数', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('512', 'EQUIP_TYPE', '5', '签到', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('513', 'EQUIP_STATUS', '1', '在线', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('515', 'EQUIP_STATUS', '0', '离线', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('516', 'EQUIP_STATUS', '2', '故障', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('517', 'PRICE_TYPE', '1', '计重', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('518', 'PRICE_TYPE', '2', '计数', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('519', 'PRICE_TYPE', '3', '计时', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('520', 'ACTIVE_FLAG', '0', '不生效', null, null, null);
INSERT INTO `sys_dic_item` VALUES ('521', 'ACTIVE_FLAG', '1', '生效', null, null, null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `client_ip` varchar(100) DEFAULT '',
  `request_uri` varchar(255) DEFAULT '',
  `user_id` varchar(20) DEFAULT '',
  `request_method` varchar(10) DEFAULT '',
  `param_data` text,
  `return_data` text,
  `request_time` bigint(20) DEFAULT '0',
  `return_time` bigint(20) DEFAULT '0',
  `operate_time` bigint(20) DEFAULT '0',
  `http_status` varchar(20) DEFAULT '',
  `remark` varchar(255) DEFAULT '',
  `report_time` int(11) unsigned DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5456 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统日志表';

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
INSERT INTO `sys_seq` VALUES ('BATCH:0000', '3');
INSERT INTO `sys_seq` VALUES ('BATCH:0001', '3');
INSERT INTO `sys_seq` VALUES ('BATCH:0002', '3');
INSERT INTO `sys_seq` VALUES ('CARD:0001', '20');
INSERT INTO `sys_seq` VALUES ('CARD:null', '8');
INSERT INTO `sys_seq` VALUES ('CUSTOMER:', '5');
INSERT INTO `sys_seq` VALUES ('DEPART:0000', '6');
INSERT INTO `sys_seq` VALUES ('DEPART:0001', '11');
INSERT INTO `sys_seq` VALUES ('DEPART:0002', '2');
INSERT INTO `sys_seq` VALUES ('equipment:0000', '3');
INSERT INTO `sys_seq` VALUES ('equipment:0001', '2');
INSERT INTO `sys_seq` VALUES ('EQUIPSUB:00000001', '4');
INSERT INTO `sys_seq` VALUES ('EQUIPSUB:00010001', '3');
INSERT INTO `sys_seq` VALUES ('EQUIPSUB:null', '2');
INSERT INTO `sys_seq` VALUES ('PRICE:0000', '2');
INSERT INTO `sys_seq` VALUES ('PRICE:0001', '6');
INSERT INTO `sys_seq` VALUES ('PRICE:0002', '2');
INSERT INTO `sys_seq` VALUES ('PRODUCTION:0000', '2');
INSERT INTO `sys_seq` VALUES ('PRODUCTION:0001', '6');
INSERT INTO `sys_seq` VALUES ('PRODUCTION:0002', '3');
INSERT INTO `sys_seq` VALUES ('ROLE:0000', '5');
INSERT INTO `sys_seq` VALUES ('ROLE:0001', '2');
INSERT INTO `sys_seq` VALUES ('ROLE:0002', '3');
INSERT INTO `sys_seq` VALUES ('ROLE:null', '2');
INSERT INTO `sys_seq` VALUES ('SHIFT:0000', '5');
INSERT INTO `sys_seq` VALUES ('SHIFT:0001', '4');
INSERT INTO `sys_seq` VALUES ('SHIFT:0002', '2');
INSERT INTO `sys_seq` VALUES ('SPEC:0001', '3');
INSERT INTO `sys_seq` VALUES ('SPEC:0002', '3');
INSERT INTO `sys_seq` VALUES ('STAFF:0000', '6');
INSERT INTO `sys_seq` VALUES ('STAFF:0001', '13');
INSERT INTO `sys_seq` VALUES ('STAFF:0002', '2');
INSERT INTO `sys_seq` VALUES ('STAFF:0003', '19');
INSERT INTO `sys_seq` VALUES ('STAFF:null', '4');
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
INSERT INTO `user_info` VALUES ('00000005', '0000', 'test1', '25d55ad283aa400af464c76d713c07ad', 'tt33', '1', '1233333', '1598055857', '1599913293', '00000001', null, '');
INSERT INTO `user_info` VALUES ('00000006', '0000', 'taa', '25d55ad283aa400af464c76d713c07ad', 'ssss', '1', '123444', '1598056806', '1598056806', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000007', '0000', 'ttr', '25d55ad283aa400af464c76d713c07ad', 'sssss', '1', '1111', '1598057364', '1598057364', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000008', '0000', '1234', '25d55ad283aa400af464c76d713c07ad', '1231321', '1', '12313', '1598057403', '1598057403', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000009', '0000', '1234', '25d55ad283aa400af464c76d713c07ad', '1231321', '1', '12313', '1598057585', '1598057585', '00000001', null, null);
INSERT INTO `user_info` VALUES ('00000010', '0000', '曹子建', '25d55ad283aa400af464c76d713c07ad', '曹子建', '1', '12345678901', '1598710350', '1598710561', '00000004', '0', '');
INSERT INTO `user_info` VALUES ('00010001', '0001', '123', '25d55ad283aa400af464c76d713c07ad', '133333', '2', '123333', '1598102134', '1598795905', '00010001', '0', '');
INSERT INTO `user_info` VALUES ('00020001', '0002', 'juliwei', '25d55ad283aa400af464c76d713c07ad', '巨立炜', '1', '19963147413', '1598797188', '1598797188', '00020001', '0', null);
INSERT INTO `user_info` VALUES ('00020002', '0002', 'juliwei2', '25d55ad283aa400af464c76d713c07ad', '巨立炜2', '1', '19963147413', '1598797758', '1598797758', '00020002', '0', null);
INSERT INTO `user_info` VALUES ('00020003', '0002', 'juliwei3', '25d55ad283aa400af464c76d713c07ad', '巨立炜', '1', '19963147413', '1598871885', '1598871885', '00020001', '0', null);
