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
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('5172', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"4db724d97019494c904f225321ba6c1100000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599363570783', '1599363571191', '408', '200', '用户登录', '1599363571');
INSERT INTO `sys_log` VALUES ('5173', '127.0.0.1', '/updateCustomer', '00000000', 'POST', '{\"customerId\":[\"0004\"],\"company\":[\"rrr2\"],\"address\":[\"山东rrr\"],\"concator\":[\"rrrrr\"],\"concatorPhone\":[\"18363000394\"],\"status\":[\"0\"],\"equipmentCount\":[\"0\"],\"createTime\":[\"1599362632\"],\"updateTime\":[\"1599362632\"],\"token\":[\"4db724d97019494c904f225321ba6c1100000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"customerId\":\"0004\",\"company\":\"rrr2\",\"address\":\"山东---', '1599364559237', '1599364559279', '42', '200', '修改客户', '1599364559');
INSERT INTO `sys_log` VALUES ('5174', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"16391b8c5fe04c908e113e3f06fb725a00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599379132524', '1599379132917', '393', '200', '用户登录', '1599379132');
INSERT INTO `sys_log` VALUES ('5175', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"e9a32764cbca4a97b4a339040db49dab00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599379416532', '1599379416938', '406', '200', '用户登录', '1599379416');
INSERT INTO `sys_log` VALUES ('5176', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"d215216b859142e3a0ac9a924737108d00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599392494144', '1599392494531', '387', '200', '用户登录', '1599392494');
INSERT INTO `sys_log` VALUES ('5177', '127.0.0.1', '/fileupload', null, 'POST', '{}', null, '1599392747477', '1599392747478', '1', '200', '/fileupload', '1599392747');
INSERT INTO `sys_log` VALUES ('5178', '127.0.0.1', '/fileupload', null, 'POST', '{}', null, '1599393152795', '1599393152807', '12', '200', '/fileupload', '1599393152');
INSERT INTO `sys_log` VALUES ('5179', '127.0.0.1', '/fileupload', null, 'POST', '{}', null, '1599393287556', '1599393287556', '0', '200', '/fileupload', '1599393287');
INSERT INTO `sys_log` VALUES ('5180', '127.0.0.1', '/fileupload', null, 'POST', '{}', null, '1599393323220', '1599393323221', '1', '200', '/fileupload', '1599393323');
INSERT INTO `sys_log` VALUES ('5181', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', null, '1599393653945', '1599393653945', '0', '200', '/fileupload', '1599393653');
INSERT INTO `sys_log` VALUES ('5182', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"文件格式错误\"}', '1599393774221', '1599393774361', '140', '200', '/fileupload', '1599393774');
INSERT INTO `sys_log` VALUES ('5183', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', null, '1599393786448', '1599393791104', '4656', '200', '/fileupload', '1599393791');
INSERT INTO `sys_log` VALUES ('5184', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工性别错误\"}', '1599397290658', '1599397291283', '625', '200', '/fileupload', '1599397291');
INSERT INTO `sys_log` VALUES ('5185', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工性别错误\"}', '1599397322554', '1599397403675', '81121', '200', '/fileupload', '1599397403');
INSERT INTO `sys_log` VALUES ('5186', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工编号格式错误\"}', '1599397896966', '1599397897562', '596', '200', '/fileupload', '1599397897');
INSERT INTO `sys_log` VALUES ('5187', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工编号格式错误\"}', '1599397945554', '1599397945630', '76', '200', '/fileupload', '1599397945');
INSERT INTO `sys_log` VALUES ('5188', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工编号格式错误\"}', '1599398013984', '1599398034551', '20567', '200', '/fileupload', '1599398034');
INSERT INTO `sys_log` VALUES ('5189', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，班组信息不存在\"}', '1599398078570', '1599398085878', '7308', '200', '/fileupload', '1599398085');
INSERT INTO `sys_log` VALUES ('5190', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第3行，员工编号格式错误\"}', '1599398135890', '1599398156682', '20792', '200', '/fileupload', '1599398156');
INSERT INTO `sys_log` VALUES ('5191', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1}', '1599398208702', '1599398208803', '101', '200', '/fileupload', '1599398208');
INSERT INTO `sys_log` VALUES ('5192', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1}', '1599398397618', '1599398398455', '837', '200', '/fileupload', '1599398398');
INSERT INTO `sys_log` VALUES ('5193', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1}', '1599398414871', '1599398414960', '89', '200', '/fileupload', '1599398414');
INSERT INTO `sys_log` VALUES ('5194', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1}', '1599398444626', '1599398486896', '42270', '200', '/fileupload', '1599398486');
INSERT INTO `sys_log` VALUES ('5195', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1}', '1599398493245', '1599398646196', '152951', '200', '/fileupload', '1599398646');
INSERT INTO `sys_log` VALUES ('5196', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"ids for this class must be manually assigned before calling save(): com.wk.bean.Staff; nested exception is org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save(): com.wk.bean.Staff\"}', '1599398683039', '1599398693833', '10794', '200', '/fileupload', '1599398693');
INSERT INTO `sys_log` VALUES ('5197', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"could not execute statement; nested exception is org.hibernate.exception.GenericJDBCException: could not execute statement\"}', '1599398765164', '1599398766081', '917', '200', '/fileupload', '1599398766');
INSERT INTO `sys_log` VALUES ('5198', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"ids for this class must be manually assigned before calling save(): com.wk.bean.Staff; nested exception is org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save(): com.wk.bean.Staff\"}', '1599398963595', '1599398964525', '930', '200', '/fileupload', '1599398964');
INSERT INTO `sys_log` VALUES ('5199', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599399016143', '1599399017068', '925', '200', '/fileupload', '1599399017');
INSERT INTO `sys_log` VALUES ('5200', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599399124823', '1599399125769', '946', '200', '/fileupload', '1599399125');
INSERT INTO `sys_log` VALUES ('5201', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0000\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工编号已存在\"}', '1599399171394', '1599399171504', '110', '200', '/fileupload', '1599399171');
INSERT INTO `sys_log` VALUES ('5202', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0001\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599399450209', '1599399450424', '215', '200', '/fileupload', '1599399450');
INSERT INTO `sys_log` VALUES ('5203', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599399716459', '1599399803661', '87202', '200', '/fileupload', '1599399803');
INSERT INTO `sys_log` VALUES ('5204', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工编号已存在\"}', '1599399842106', '1599399842191', '85', '200', '/fileupload', '1599399842');
INSERT INTO `sys_log` VALUES ('5205', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599399869420', '1599399900938', '31518', '200', '/fileupload', '1599399900');
INSERT INTO `sys_log` VALUES ('5206', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工编号已存在\"}', '1599399947456', '1599399965218', '17762', '200', '/fileupload', '1599399965');
INSERT INTO `sys_log` VALUES ('5207', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599399990440', '1599400295601', '305161', '200', '/fileupload', '1599400295');
INSERT INTO `sys_log` VALUES ('5208', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599400335776', '1599400401554', '65778', '200', '/fileupload', '1599400401');
INSERT INTO `sys_log` VALUES ('5209', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"could not execute statement; SQL [n/a]; nested exception is org.hibernate.exception.DataException: could not execute statement\"}', '1599400776033', '1599400776796', '763', '200', '/fileupload', '1599400776');
INSERT INTO `sys_log` VALUES ('5210', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"could not execute statement; SQL [n/a]; nested exception is org.hibernate.exception.DataException: could not execute statement\"}', '1599400834994', '1599400845209', '10215', '200', '/fileupload', '1599400845');
INSERT INTO `sys_log` VALUES ('5211', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"could not execute statement; SQL [n/a]; nested exception is org.hibernate.exception.DataException: could not execute statement\"}', '1599400858199', '1599400894051', '35852', '200', '/fileupload', '1599400894');
INSERT INTO `sys_log` VALUES ('5212', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599400924044', '1599400924982', '938', '200', '/fileupload', '1599400924');
INSERT INTO `sys_log` VALUES ('5213', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，员工编号已存在\"}', '1599401682984', '1599401683091', '107', '200', '/fileupload', '1599401683');
INSERT INTO `sys_log` VALUES ('5214', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"1\"],\"customerId\":[\"0003\"],\"token\":[\"d215216b859142e3a0ac9a924737108d00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599401706771', '1599401706877', '106', '200', '/fileupload', '1599401706');
INSERT INTO `sys_log` VALUES ('5215', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"9436d1102a244631a51d9059cc2ff23000000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599447511330', '1599447511434', '104', '200', '用户登录', '1599447511');
INSERT INTO `sys_log` VALUES ('5216', '218.56.65.142', '/staff', '00000000', 'POST', '{\"staffNo\":[\"\"],\"staffName\":[\"1231\"],\"sex\":[\"1\"],\"departmentId\":[\"\"],\"staffType\":[\"0\"],\"entryTime\":[\"1599447602\"],\"leaveTime\":[\"0\"],\"status\":[\"0\"],\"phone\":[\"\"],\"address\":[\"\"],\"idcard\":[\"\"],\"cardId\":[\"\"],\"customerId\":[\"0000\"],\"token\":[\"9436d1102a244631a51d9059cc2ff23000000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"staffId\":\"000000000004\",\"staffNo\":\"\",\"staffName\":\"1231\",\"sex\":1,\"entryTime\":1599447602,\"leaveTime\":0,\"status\":0,\"staffType\":0,\"phone\":\"\",\"address\":\"\",\"idcard\":\"\",\"customerId\":\"0000\",\"createTime\":1599447604,\"updateTime\":1599447604}}', '1599447604393', '1599447604583', '190', '200', '添加员工', '1599447604');
INSERT INTO `sys_log` VALUES ('5217', '180.143.23.21', '/login', '00020001', 'POST', '{\"userName\":[\"juliwei\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00020001\",\"roleName\":\"系统管理员\",\"customerId\":\"0002\",\"updateTime\":1598797244},\"user\":{\"userId\":\"00020001\",\"customerId\":\"0002\",\"userName\":\"juliwei\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"巨立炜\",\"sex\":1,\"phone\":\"19963147413\",\"createTime\":1598797188,\"updateTime\":1598797188,\"roleId\":\"00020001\",\"status\":0},\"token\":\"56892c34427148dc833be33a9fb6443900020001\",\"customer\":{\"customerId\":\"0002\",\"company\":\"青岛炜凯\",\"address\":\"山东省青岛市\",\"concator\":\"巨立炜\",\"concatorPhone\":\"19963147413\",\"status\":0,\"equipmentCount\":0,\"createTime\":1598709861,\"updateTime\":1598709861}}}', '1599447672890', '1599447672910', '20', '200', '用户登录', '1599447672');
INSERT INTO `sys_log` VALUES ('5218', '180.143.23.21', '/shift', '00020001', 'POST', '{\"shiftName\":[\"白班\"],\"beginTime\":[\"0\"],\"endTime\":[\"86400\"],\"delayTime\":[\"60\"],\"customerId\":[\"0002\"],\"token\":[\"56892c34427148dc833be33a9fb6443900020001\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":14,\"shiftId\":\"000201\",\"shiftName\":\"白班\",\"customerId\":\"0002\",\"activeTime\":1599447742,\"reactiveTime\":0,\"delayTime\":60,\"beginTime\":0,\"endTime\":86400,\"createTime\":1599447742}}', '1599447741997', '1599447742060', '63', '200', '添加班次', '1599447742');
INSERT INTO `sys_log` VALUES ('5219', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"f5b1ad8d7c7c4b86b28408d60533270500000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599448083216', '1599448083292', '76', '200', '用户登录', '1599448083');
INSERT INTO `sys_log` VALUES ('5220', '180.143.23.21', '/department', '00020001', 'POST', '{\"name\":[\"bumen\"],\"type\":[\"1\"],\"customerId\":[\"0002\"],\"token\":[\"56892c34427148dc833be33a9fb6443900020001\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":17,\"departmentId\":\"00020001\",\"customerId\":\"0002\",\"name\":\"bumen\",\"beginTime\":1599448143,\"endTime\":0,\"type\":1,\"status\":0,\"staffCount\":0}}', '1599448143795', '1599448143892', '97', '200', '添加部门', '1599448143');
INSERT INTO `sys_log` VALUES ('5221', '180.143.23.21', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"3fbf727664e2487ea2ef160be3f58dcc00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599448174766', '1599448174784', '18', '200', '用户登录', '1599448174');
INSERT INTO `sys_log` VALUES ('5222', '218.56.65.142', '/production', '00000000', 'POST', '{\"productionName\":[\"123\"],\"customerId\":[\"0000\"],\"token\":[\"f5b1ad8d7c7c4b86b28408d60533270500000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"productionId\":\"00000001\",\"productionName\":\"123\",\"customerId\":\"0000\",\"createTime\":1599448184,\"id\":11,\"beginTime\":1599448184,\"endTime\":0}}', '1599448184635', '1599448184672', '37', '200', '添加产品', '1599448184');
INSERT INTO `sys_log` VALUES ('5223', '180.143.23.21', '/batchItem', '00000000', 'POST', '{\"itemId\":[\"2356\"],\"beginTime\":[\"1598892780\"],\"endTime\":[\"1598972400\"],\"batchId\":[\"000201\"],\"customerId\":[\"0002\"],\"token\":[\"3fbf727664e2487ea2ef160be3f58dcc00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":5,\"itemId\":\"2356\",\"batchId\":\"000201\",\"beginTime\":1598892780,\"endTime\":1598972400}}', '1599448601967', '1599448602045', '78', '200', '添加自定义批次', '1599448602');
INSERT INTO `sys_log` VALUES ('5224', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"356d61a4b3a24ee8a398ad10b066236200000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599449018941', '1599449019033', '92', '200', '用户登录', '1599449019');
INSERT INTO `sys_log` VALUES ('5225', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"d8f975538dcc4bccb92363a9b8e4a1d300000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599449345144', '1599449345240', '96', '200', '用户登录', '1599449345');
INSERT INTO `sys_log` VALUES ('5226', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"b7fe01a8640943779aaaee1414366d5700000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599457314696', '1599457314792', '96', '200', '用户登录', '1599457314');
INSERT INTO `sys_log` VALUES ('5227', '127.0.0.1', '/login', null, 'POST', '{\"userName\":[\"admin\"],\"password\":[\"123456678\"],\"token\":[\"\"]}', '{\"errorcode\":1,\"message\":\"用户名或密码错误\"}', '1599481485887', '1599481486188', '301', '200', '用户登录', '1599481486');
INSERT INTO `sys_log` VALUES ('5228', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"bac64e44427047ccb645d5f5a93bf67500000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599481491145', '1599481491209', '64', '200', '用户登录', '1599481491');
INSERT INTO `sys_log` VALUES ('5229', '127.0.0.1', '/fileupload', null, 'POST', '{\"type\":[\"2\"]}', null, '1599482346480', '1599482346483', '3', '200', '/fileupload', '1599482346');
INSERT INTO `sys_log` VALUES ('5230', '127.0.0.1', '/fileupload', null, 'POST', '{\"type\":[\"2\"]}', null, '1599482396484', '1599482396485', '1', '200', '/fileupload', '1599482396');
INSERT INTO `sys_log` VALUES ('5231', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"2\"],\"customerId\":[\"0001\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，IC卡类型错误\"}', '1599482453097', '1599482453686', '589', '200', '/fileupload', '1599482453');
INSERT INTO `sys_log` VALUES ('5232', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"2\"],\"customerId\":[\"0001\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，IC卡类型错误\"}', '1599482507428', '1599482549555', '42127', '200', '/fileupload', '1599482549');
INSERT INTO `sys_log` VALUES ('5233', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"2\"],\"customerId\":[\"0001\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599482591375', '1599482592322', '947', '200', '/fileupload', '1599482592');
INSERT INTO `sys_log` VALUES ('5234', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"2\"],\"customerId\":[\"0001\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599482672962', '1599482673965', '1003', '200', '/fileupload', '1599482673');
INSERT INTO `sys_log` VALUES ('5235', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"2\"],\"customerId\":[\"0001\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599482714306', '1599482715246', '940', '200', '/fileupload', '1599482715');
INSERT INTO `sys_log` VALUES ('5236', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010019\"],\"cardNo\":[\"2345512334\"],\"cardName\":[\"\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1599482715\"],\"updateTime\":[\"1599482715\"],\"append\":[\"自动导入\"],\"staffId\":[\"000100000011\"],\"staffName\":[\"\"],\"beginTime\":[\"0\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599482734160', '1599482734193', '33', '200', '修改卡', '1599482734');
INSERT INTO `sys_log` VALUES ('5237', '127.0.0.1', '/report', '00000000', 'POST', '{\"reportName\":[\"生产记录\"],\"path\":[\"/recordReport\"],\"filePath\":[\"record/recordReport\"],\"customerId\":[\"0001\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"reportId\":3,\"reportName\":\"生产记录\",\"path\":\"/recordReport\",\"filePath\":\"record/recordReport\",\"status\":0,\"createTime\":1599487309,\"updateTime\":1599487309}}', '1599487309110', '1599487309182', '72', '200', '添加报表', '1599487309');
INSERT INTO `sys_log` VALUES ('5238', '127.0.0.1', '/updateReport', '00000000', 'POST', '{\"reportId\":[\"3\"],\"reportName\":[\"生产记录\"],\"path\":[\"/recordReport\"],\"filePath\":[\"report/recordReport\"],\"status\":[\"0\"],\"createTime\":[\"1599487309\"],\"updateTime\":[\"1599487309\"],\"append\":[\"\"],\"customerId\":[\"0000\"],\"token\":[\"bac64e44427047ccb645d5f5a93bf67500000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599487363953', '1599487364088', '135', '200', '修改报表', '1599487364');
INSERT INTO `sys_log` VALUES ('5239', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"e40988ad1fcd434baf0fe8298a5a829d00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599554190744', '1599554191094', '350', '200', '用户登录', '1599554191');
INSERT INTO `sys_log` VALUES ('5240', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"958c739469a8458dac99ffeb0dfb54ad00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599569227366', '1599569227397', '31', '200', '用户登录', '1599569227');
INSERT INTO `sys_log` VALUES ('5241', '127.0.0.1', '/sysDic', '00000000', 'POST', '{\"code\":[\"PRICE_TYPE\"],\"name\":[\"计价类型\"],\"token\":[\"958c739469a8458dac99ffeb0dfb54ad00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"code\":\"PRICE_TYPE\",\"name\":\"计价类型\"}}', '1599569264536', '1599569264584', '48', '200', '添加数据字典', '1599569264');
INSERT INTO `sys_log` VALUES ('5242', '127.0.0.1', '/sysDicItem', '00000000', 'POST', '{\"itemCode\":[\"1\"],\"itemName\":[\"计重\"],\"code\":[\"PRICE_TYPE\"],\"token\":[\"958c739469a8458dac99ffeb0dfb54ad00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":517,\"code\":\"PRICE_TYPE\",\"itemCode\":\"1\",\"itemName\":\"计重\"}}', '1599569273871', '1599569273962', '91', '200', '添加子码', '1599569273');
INSERT INTO `sys_log` VALUES ('5243', '127.0.0.1', '/sysDicItem', '00000000', 'POST', '{\"itemCode\":[\"2\"],\"itemName\":[\"计数\"],\"code\":[\"PRICE_TYPE\"],\"token\":[\"958c739469a8458dac99ffeb0dfb54ad00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":518,\"code\":\"PRICE_TYPE\",\"itemCode\":\"2\",\"itemName\":\"计数\"}}', '1599569281979', '1599569282001', '22', '200', '添加子码', '1599569282');
INSERT INTO `sys_log` VALUES ('5244', '127.0.0.1', '/sysDicItem', '00000000', 'POST', '{\"itemCode\":[\"3\"],\"itemName\":[\"计时\"],\"code\":[\"PRICE_TYPE\"],\"token\":[\"958c739469a8458dac99ffeb0dfb54ad00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":519,\"code\":\"PRICE_TYPE\",\"itemCode\":\"3\",\"itemName\":\"计时\"}}', '1599569288620', '1599569288635', '15', '200', '添加子码', '1599569288');
INSERT INTO `sys_log` VALUES ('5245', '127.0.0.1', '/price', '00000000', 'POST', '{\"priceType\":[\"1\"],\"staffType\":[\"\"],\"shiftId\":[\"\"],\"productionId\":[\"00010001\"],\"specId\":[\"\"],\"technologyId\":[\"\"],\"price\":[\"100\"],\"customerId\":[\"0001\"],\"token\":[\"958c739469a8458dac99ffeb0dfb54ad00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":6,\"priceId\":\"00010004\",\"shiftId\":\"\",\"price\":100,\"reactiveTime\":0,\"createTime\":1599569599,\"updateTime\":1599569599,\"customerId\":\"0001\",\"productionId\":\"00010001\",\"specId\":\"\",\"technologyId\":\"\"}}', '1599569599569', '1599569599707', '138', '200', '添加价格', '1599569599');
INSERT INTO `sys_log` VALUES ('5246', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"46cdfe29804943d0b8d8cd6e43ef8b5700000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599569940607', '1599569941131', '524', '200', '用户登录', '1599569941');
INSERT INTO `sys_log` VALUES ('5247', '127.0.0.1', '/price', '00000000', 'POST', '{\"priceType\":[\"2\"],\"staffType\":[\"\"],\"shiftId\":[\"\"],\"productionId\":[\"00010001\"],\"specId\":[\"00010001\"],\"technologyId\":[\"00010004\"],\"price\":[\"100\"],\"customerId\":[\"0001\"],\"token\":[\"46cdfe29804943d0b8d8cd6e43ef8b5700000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":7,\"priceId\":\"00010005\",\"shiftId\":\"\",\"price\":100,\"reactiveTime\":0,\"createTime\":1599569966,\"updateTime\":1599569966,\"customerId\":\"0001\",\"productionId\":\"00010001\",\"specId\":\"00010001\",\"technologyId\":\"00010004\",\"priceType\":2}}', '1599569966013', '1599569966148', '135', '200', '添加价格', '1599569966');
INSERT INTO `sys_log` VALUES ('5248', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"2739afece12144a8898c2c2e7f56f2eb00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599736916947', '1599736917694', '747', '200', '用户登录', '1599736917');
INSERT INTO `sys_log` VALUES ('5249', '127.0.0.1', '/sysDic', '00000000', 'POST', '{\"code\":[\"ACTIVE_FLAG\"],\"name\":[\"生效标志\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"code\":\"ACTIVE_FLAG\",\"name\":\"生效标志\"}}', '1599737067874', '1599737067948', '74', '200', '添加数据字典', '1599737067');
INSERT INTO `sys_log` VALUES ('5250', '127.0.0.1', '/sysDicItem', '00000000', 'POST', '{\"itemCode\":[\"0\"],\"itemName\":[\"不生效\"],\"code\":[\"ACTIVE_FLAG\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":520,\"code\":\"ACTIVE_FLAG\",\"itemCode\":\"0\",\"itemName\":\"不生效\"}}', '1599737090921', '1599737091215', '294', '200', '添加子码', '1599737091');
INSERT INTO `sys_log` VALUES ('5251', '127.0.0.1', '/sysDicItem', '00000000', 'POST', '{\"itemCode\":[\"1\"],\"itemName\":[\"生效\"],\"code\":[\"ACTIVE_FLAG\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":521,\"code\":\"ACTIVE_FLAG\",\"itemCode\":\"1\",\"itemName\":\"生效\"}}', '1599737097584', '1599737097596', '12', '200', '添加子码', '1599737097');
INSERT INTO `sys_log` VALUES ('5252', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"2\"],\"status\":[\"0\"],\"msg\":[\"确认关闭班次类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599739879454', '1599739879464', '10', '200', '修改终端支持计费类型', '1599739879');
INSERT INTO `sys_log` VALUES ('5253', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"2\"],\"status\":[\"1\"],\"msg\":[\"确认开启班次类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599739882589', '1599739882624', '35', '200', '修改终端支持计费类型', '1599739882');
INSERT INTO `sys_log` VALUES ('5254', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"2\"],\"status\":[\"0\"],\"msg\":[\"确认关闭班次类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599739989512', '1599739989967', '455', '200', '修改终端支持计费类型', '1599739989');
INSERT INTO `sys_log` VALUES ('5255', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"2\"],\"status\":[\"1\"],\"msg\":[\"确认开启班次类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740013176', '1599740013209', '33', '200', '修改终端支持计费类型', '1599740013');
INSERT INTO `sys_log` VALUES ('5256', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"1\"],\"status\":[\"1\"],\"msg\":[\"确认开启员工类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740020774', '1599740020794', '20', '200', '修改终端支持计费类型', '1599740020');
INSERT INTO `sys_log` VALUES ('5257', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"2\"],\"status\":[\"1\"],\"msg\":[\"确认开启班次类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740022395', '1599740022409', '14', '200', '修改终端支持计费类型', '1599740022');
INSERT INTO `sys_log` VALUES ('5258', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"1\"],\"status\":[\"0\"],\"msg\":[\"确认关闭员工类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740031621', '1599740031638', '17', '200', '修改终端支持计费类型', '1599740031');
INSERT INTO `sys_log` VALUES ('5259', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"2\"],\"status\":[\"0\"],\"msg\":[\"确认关闭班次类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740036973', '1599740036988', '15', '200', '修改终端支持计费类型', '1599740036');
INSERT INTO `sys_log` VALUES ('5260', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"2\"],\"status\":[\"1\"],\"msg\":[\"确认开启班次类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740059035', '1599740059120', '85', '200', '修改终端支持计费类型', '1599740059');
INSERT INTO `sys_log` VALUES ('5261', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"1\"],\"status\":[\"1\"],\"msg\":[\"确认开启员工类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740092722', '1599740092740', '18', '200', '修改终端支持计费类型', '1599740092');
INSERT INTO `sys_log` VALUES ('5262', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"type\":[\"1\"],\"status\":[\"0\"],\"msg\":[\"确认关闭员工类型计费?\"],\"flag\":[\"true\"],\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740097819', '1599740097834', '15', '200', '修改终端支持计费类型', '1599740097');
INSERT INTO `sys_log` VALUES ('5263', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740200093', '1599740200107', '14', '200', '修改终端支持计费类型', '1599740200');
INSERT INTO `sys_log` VALUES ('5264', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740204637', '1599740204651', '14', '200', '修改终端支持计费类型', '1599740204');
INSERT INTO `sys_log` VALUES ('5265', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740208653', '1599740208842', '189', '200', '修改终端支持计费类型', '1599740208');
INSERT INTO `sys_log` VALUES ('5266', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740214685', '1599740214699', '14', '200', '修改终端支持计费类型', '1599740214');
INSERT INTO `sys_log` VALUES ('5267', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"1\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740221588', '1599740221603', '15', '200', '修改终端支持计费类型', '1599740221');
INSERT INTO `sys_log` VALUES ('5268', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740228116', '1599740228131', '15', '200', '修改终端支持计费类型', '1599740228');
INSERT INTO `sys_log` VALUES ('5269', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740233692', '1599740233707', '15', '200', '修改终端支持计费类型', '1599740233');
INSERT INTO `sys_log` VALUES ('5270', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740238970', '1599740238985', '15', '200', '修改终端支持计费类型', '1599740238');
INSERT INTO `sys_log` VALUES ('5271', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740247915', '1599740247930', '15', '200', '修改终端支持计费类型', '1599740247');
INSERT INTO `sys_log` VALUES ('5272', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"1\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740253521', '1599740253535', '14', '200', '修改终端支持计费类型', '1599740253');
INSERT INTO `sys_log` VALUES ('5273', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740258058', '1599740258071', '13', '200', '修改终端支持计费类型', '1599740258');
INSERT INTO `sys_log` VALUES ('5274', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740263426', '1599740263463', '37', '200', '修改终端支持计费类型', '1599740263');
INSERT INTO `sys_log` VALUES ('5275', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740273522', '1599740273537', '15', '200', '修改终端支持计费类型', '1599740273');
INSERT INTO `sys_log` VALUES ('5276', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740288210', '1599740288225', '15', '200', '修改终端支持计费类型', '1599740288');
INSERT INTO `sys_log` VALUES ('5277', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740289466', '1599740289480', '14', '200', '修改终端支持计费类型', '1599740289');
INSERT INTO `sys_log` VALUES ('5278', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740293330', '1599740293344', '14', '200', '修改终端支持计费类型', '1599740293');
INSERT INTO `sys_log` VALUES ('5279', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"1\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740294706', '1599740294719', '13', '200', '修改终端支持计费类型', '1599740294');
INSERT INTO `sys_log` VALUES ('5280', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740296004', '1599740296017', '13', '200', '修改终端支持计费类型', '1599740296');
INSERT INTO `sys_log` VALUES ('5281', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740297441', '1599740297455', '14', '200', '修改终端支持计费类型', '1599740297');
INSERT INTO `sys_log` VALUES ('5282', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740299121', '1599740299136', '15', '200', '修改终端支持计费类型', '1599740299');
INSERT INTO `sys_log` VALUES ('5283', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740310977', '1599740311041', '64', '200', '修改终端支持计费类型', '1599740311');
INSERT INTO `sys_log` VALUES ('5284', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740316650', '1599740316663', '13', '200', '修改终端支持计费类型', '1599740316');
INSERT INTO `sys_log` VALUES ('5285', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740317858', '1599740317875', '17', '200', '修改终端支持计费类型', '1599740317');
INSERT INTO `sys_log` VALUES ('5286', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740319083', '1599740319096', '13', '200', '修改终端支持计费类型', '1599740319');
INSERT INTO `sys_log` VALUES ('5287', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000102\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740320273', '1599740320286', '13', '200', '修改终端支持计费类型', '1599740320');
INSERT INTO `sys_log` VALUES ('5288', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740360977', '1599740361132', '155', '200', '修改终端支持计费类型', '1599740361');
INSERT INTO `sys_log` VALUES ('5289', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740595481', '1599740595534', '53', '200', '修改终端支持计费类型', '1599740595');
INSERT INTO `sys_log` VALUES ('5290', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"2\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740599784', '1599740599798', '14', '200', '修改终端支持计费类型', '1599740599');
INSERT INTO `sys_log` VALUES ('5291', '127.0.0.1', '/subEquipment', '00000000', 'POST', '{\"subEquipmentName\":[\"1-4\"],\"type\":[\"1\"],\"customerId\":[\"0000\"],\"equipmentId\":[\"00000001\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"subEquipmentId\":\"0000000103\",\"subEquipmentName\":\"1-4\",\"type\":1,\"equipmentId\":\"00000001\",\"createTime\":1599740630,\"updateTime\":1599740630,\"staffTypeCalc\":0,\"shiftCalc\":0}}', '1599740630348', '1599740630444', '96', '200', '添加终端', '1599740630');
INSERT INTO `sys_log` VALUES ('5292', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599740843361', '1599740843377', '16', '200', '修改终端支持计费类型', '1599740843');
INSERT INTO `sys_log` VALUES ('5293', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000103\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"2739afece12144a8898c2c2e7f56f2eb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599745277939', '1599745278022', '83', '200', '修改终端支持计费类型', '1599745278');
INSERT INTO `sys_log` VALUES ('5294', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"1e5d4316f19b453e858ce97624f112eb00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599748073796', '1599748073856', '60', '200', '用户登录', '1599748073');
INSERT INTO `sys_log` VALUES ('5295', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"6c47ac5adb2643b7af642bae7dadc92700000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599789474998', '1599789475538', '540', '200', '用户登录', '1599789475');
INSERT INTO `sys_log` VALUES ('5296', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"5fa0a52b521b4e0f8c67bd6723ffd42500000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599789600896', '1599789600947', '51', '200', '用户登录', '1599789600');
INSERT INTO `sys_log` VALUES ('5297', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"8c7eec0aaea54f989151fd7ba365b5ee00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599826215739', '1599826216112', '373', '200', '用户登录', '1599826216');
INSERT INTO `sys_log` VALUES ('5298', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"1b07d7bd90794218a3a4993fa8d19a0700000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599873729604', '1599873732028', '2424', '200', '用户登录', '1599873732');
INSERT INTO `sys_log` VALUES ('5299', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"85beb0e4c8bb4b34807ef825cbb0187800000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599912294165', '1599912294705', '540', '200', '用户登录', '1599912294');
INSERT INTO `sys_log` VALUES ('5300', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑客户信息\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"\"],\"parentId\":[\"4\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":35,\"name\":\"编辑客户信息\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":4,\"icon\":\"\",\"filePath\":\"\"}}', '1599912346098', '1599912346141', '43', '200', '添加菜单', '1599912346');
INSERT INTO `sys_log` VALUES ('5301', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加IC卡\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"2\"],\"parentId\":[\"20\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":36,\"name\":\"添加IC卡\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":20,\"icon\":\"\",\"filePath\":\"\",\"level\":2}}', '1599912400859', '1599912400872', '13', '200', '添加菜单', '1599912400');
INSERT INTO `sys_log` VALUES ('5302', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"导入IC卡\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"2\"],\"parentId\":[\"20\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":37,\"name\":\"导入IC卡\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":20,\"icon\":\"\",\"filePath\":\"\",\"level\":2}}', '1599912416782', '1599912416791', '9', '200', '添加菜单', '1599912416');
INSERT INTO `sys_log` VALUES ('5303', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"IC卡编辑\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"20\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":38,\"name\":\"IC卡编辑\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":20,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912441656', '1599912441665', '9', '200', '添加菜单', '1599912441');
INSERT INTO `sys_log` VALUES ('5304', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"IC卡锁定\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"20\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":39,\"name\":\"IC卡锁定\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":20,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912456640', '1599912456649', '9', '200', '添加菜单', '1599912456');
INSERT INTO `sys_log` VALUES ('5305', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"IC卡解锁\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"20\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":40,\"name\":\"IC卡解锁\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":20,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912471519', '1599912471528', '9', '200', '添加菜单', '1599912471');
INSERT INTO `sys_log` VALUES ('5306', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加设备\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"2\"],\"parentId\":[\"24\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":41,\"name\":\"添加设备\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":24,\"icon\":\"\",\"filePath\":\"\",\"level\":2}}', '1599912493051', '1599912493060', '9', '200', '添加菜单', '1599912493');
INSERT INTO `sys_log` VALUES ('5307', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑设备\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"2\"],\"parentId\":[\"24\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":42,\"name\":\"编辑设备\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":24,\"icon\":\"\",\"filePath\":\"\",\"level\":2}}', '1599912509612', '1599912509621', '9', '200', '添加菜单', '1599912509');
INSERT INTO `sys_log` VALUES ('5308', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加终端\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"2\"],\"parentId\":[\"34\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":43,\"name\":\"添加终端\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":34,\"icon\":\"\",\"filePath\":\"\",\"level\":2}}', '1599912526174', '1599912526184', '10', '200', '添加菜单', '1599912526');
INSERT INTO `sys_log` VALUES ('5309', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑终端\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"2\"],\"parentId\":[\"34\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":44,\"name\":\"编辑终端\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":34,\"icon\":\"\",\"filePath\":\"\",\"level\":2}}', '1599912544430', '1599912544439', '9', '200', '添加菜单', '1599912544');
INSERT INTO `sys_log` VALUES ('5310', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加组织架构\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"22\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":45,\"name\":\"添加组织架构\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":22,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912568617', '1599912568626', '9', '200', '添加菜单', '1599912568');
INSERT INTO `sys_log` VALUES ('5311', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑组织架构\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"22\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":46,\"name\":\"编辑组织架构\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":22,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912581962', '1599912581971', '9', '200', '添加菜单', '1599912581');
INSERT INTO `sys_log` VALUES ('5312', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"分配员工\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"22\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":47,\"name\":\"分配员工\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":22,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912592720', '1599912592732', '12', '200', '添加菜单', '1599912592');
INSERT INTO `sys_log` VALUES ('5313', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加下级组织架构\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"22\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":48,\"name\":\"添加下级组织架构\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":22,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912604979', '1599912604990', '11', '200', '添加菜单', '1599912604');
INSERT INTO `sys_log` VALUES ('5314', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"移除员工\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"22\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":49,\"name\":\"移除员工\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":22,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912615469', '1599912615478', '9', '200', '添加菜单', '1599912615');
INSERT INTO `sys_log` VALUES ('5315', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加批次\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"15\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":50,\"name\":\"添加批次\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":15,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912648873', '1599912648884', '11', '200', '添加菜单', '1599912648');
INSERT INTO `sys_log` VALUES ('5316', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑批次\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"15\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":51,\"name\":\"编辑批次\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":15,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912659353', '1599912659362', '9', '200', '添加菜单', '1599912659');
INSERT INTO `sys_log` VALUES ('5317', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"关联批次\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"15\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":52,\"name\":\"关联批次\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":15,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912670824', '1599912670833', '9', '200', '添加菜单', '1599912670');
INSERT INTO `sys_log` VALUES ('5318', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑关联批次\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"15\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":53,\"name\":\"编辑关联批次\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":15,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912682037', '1599912682046', '9', '200', '添加菜单', '1599912682');
INSERT INTO `sys_log` VALUES ('5319', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑计价规则\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"16\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":54,\"name\":\"编辑计价规则\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":16,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912710529', '1599912710538', '9', '200', '添加菜单', '1599912710');
INSERT INTO `sys_log` VALUES ('5320', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加计价规则\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"16\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":55,\"name\":\"添加计价规则\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":16,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912724575', '1599912724584', '9', '200', '添加菜单', '1599912724');
INSERT INTO `sys_log` VALUES ('5321', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加产品\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"12\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":56,\"name\":\"添加产品\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":12,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912742750', '1599912742761', '11', '200', '添加菜单', '1599912742');
INSERT INTO `sys_log` VALUES ('5322', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑产品\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"12\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":57,\"name\":\"编辑产品\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":12,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912752991', '1599912753000', '9', '200', '添加菜单', '1599912753');
INSERT INTO `sys_log` VALUES ('5323', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加班次\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"17\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":58,\"name\":\"添加班次\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":17,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912770695', '1599912770704', '9', '200', '添加菜单', '1599912770');
INSERT INTO `sys_log` VALUES ('5324', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑班次\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"17\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":59,\"name\":\"编辑班次\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":17,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912781132', '1599912781142', '10', '200', '添加菜单', '1599912781');
INSERT INTO `sys_log` VALUES ('5325', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加规格\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"14\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":60,\"name\":\"添加规格\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":14,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912796769', '1599912796779', '10', '200', '添加菜单', '1599912796');
INSERT INTO `sys_log` VALUES ('5326', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑规格\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"14\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":61,\"name\":\"编辑规格\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":14,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912807210', '1599912807220', '10', '200', '添加菜单', '1599912807');
INSERT INTO `sys_log` VALUES ('5327', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加工艺\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"13\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":62,\"name\":\"添加工艺\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":13,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912826825', '1599912826833', '8', '200', '添加菜单', '1599912826');
INSERT INTO `sys_log` VALUES ('5328', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"修改工艺\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"13\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":63,\"name\":\"修改工艺\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":13,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912837957', '1599912837966', '9', '200', '添加菜单', '1599912837');
INSERT INTO `sys_log` VALUES ('5329', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"导入员工\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"6\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":64,\"name\":\"导入员工\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":6,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912853901', '1599912853909', '8', '200', '添加菜单', '1599912853');
INSERT INTO `sys_log` VALUES ('5330', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加员工\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"6\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":65,\"name\":\"添加员工\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":6,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912882384', '1599912882392', '8', '200', '添加菜单', '1599912882');
INSERT INTO `sys_log` VALUES ('5331', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"编辑员工\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"6\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":66,\"name\":\"编辑员工\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":6,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912895043', '1599912895051', '8', '200', '添加菜单', '1599912895');
INSERT INTO `sys_log` VALUES ('5332', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"绑定IC卡\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"6\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":67,\"name\":\"绑定IC卡\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":6,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912907438', '1599912907447', '9', '200', '添加菜单', '1599912907');
INSERT INTO `sys_log` VALUES ('5333', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"解绑IC卡\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"6\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":68,\"name\":\"解绑IC卡\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":6,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912917003', '1599912917012', '9', '200', '添加菜单', '1599912917');
INSERT INTO `sys_log` VALUES ('5334', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加角色\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"10\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":69,\"name\":\"添加角色\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":10,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912934672', '1599912934682', '10', '200', '添加菜单', '1599912934');
INSERT INTO `sys_log` VALUES ('5335', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"修改角色\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"10\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":70,\"name\":\"修改角色\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":10,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912944389', '1599912944398', '9', '200', '添加菜单', '1599912944');
INSERT INTO `sys_log` VALUES ('5336', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"删除角色\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"10\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":71,\"name\":\"删除角色\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":10,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912954848', '1599912954856', '8', '200', '添加菜单', '1599912954');
INSERT INTO `sys_log` VALUES ('5337', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"添加用户\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"9\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":72,\"name\":\"添加用户\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":9,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912966733', '1599912966741', '8', '200', '添加菜单', '1599912966');
INSERT INTO `sys_log` VALUES ('5338', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"修改用户\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"9\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":73,\"name\":\"修改用户\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":9,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912978300', '1599912978309', '9', '200', '添加菜单', '1599912978');
INSERT INTO `sys_log` VALUES ('5339', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"锁定用户\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"9\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":74,\"name\":\"锁定用户\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":9,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912990153', '1599912990161', '8', '200', '添加菜单', '1599912990');
INSERT INTO `sys_log` VALUES ('5340', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"解锁用户\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"9\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":75,\"name\":\"解锁用户\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":9,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599912998913', '1599912998922', '9', '200', '添加菜单', '1599912998');
INSERT INTO `sys_log` VALUES ('5341', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"重置用户密码\"],\"path\":[\"\"],\"type\":[\"3\"],\"hidden\":[\"1\"],\"close\":[\"1\"],\"filePath\":[\"\"],\"icon\":[\"\"],\"level\":[\"3\"],\"parentId\":[\"9\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":76,\"name\":\"重置用户密码\",\"path\":\"\",\"type\":3,\"hidden\":1,\"close\":1,\"parentId\":9,\"icon\":\"\",\"filePath\":\"\",\"level\":3}}', '1599913009546', '1599913009555', '9', '200', '添加菜单', '1599913009');
INSERT INTO `sys_log` VALUES ('5342', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,3,4,33,35,6,64,65,66,67,68\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913184}}', '1599913184599', '1599913184719', '120', '200', '修改角色', '1599913184');
INSERT INTO `sys_log` VALUES ('5343', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,3,4,33,35,65,66,67,68\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"85beb0e4c8bb4b34807ef825cbb0187800000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913202}}', '1599913202782', '1599913202846', '64', '200', '修改角色', '1599913202');
INSERT INTO `sys_log` VALUES ('5344', '127.0.0.1', '/login', null, 'POST', '{\"userName\":[\"test\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":1,\"message\":\"用户名或密码错误\"}', '1599913221077', '1599913221083', '6', '200', '用户登录', '1599913221');
INSERT INTO `sys_log` VALUES ('5345', '127.0.0.1', '/login', null, 'POST', '{\"userName\":[\"test\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":1,\"message\":\"用户名或密码错误\"}', '1599913226053', '1599913226058', '5', '200', '用户登录', '1599913226');
INSERT INTO `sys_log` VALUES ('5346', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"9efdab4190314161afe1777f84b4696900000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913232814', '1599913232824', '10', '200', '用户登录', '1599913232');
INSERT INTO `sys_log` VALUES ('5347', '127.0.0.1', '/login', '00000008', 'POST', '{\"userName\":[\"1234\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913202},\"user\":{\"userId\":\"00000008\",\"customerId\":\"0000\",\"userName\":\"1234\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"1231321\",\"sex\":1,\"phone\":\"12313\",\"createTime\":1598057403,\"updateTime\":1598057403,\"roleId\":\"00000001\"},\"token\":\"15a29a0642444caeac2618f315fb0af200000008\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913257176', '1599913257185', '9', '200', '用户登录', '1599913257');
INSERT INTO `sys_log` VALUES ('5348', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"348e96812421487f81edc4900533506300000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913269078', '1599913269088', '10', '200', '用户登录', '1599913269');
INSERT INTO `sys_log` VALUES ('5349', '127.0.0.1', '/updateUser', '00000000', 'POST', '{\"userId\":[\"00000005\"],\"customerId\":[\"0000\"],\"userName\":[\"test1\"],\"password\":[\"\"],\"realName\":[\"tt33\"],\"sex\":[\"1\"],\"phone\":[\"1233333\"],\"createTime\":[\"1598055857\"],\"updateTime\":[\"1598057024\"],\"roleId\":[\"00000001\"],\"roleName\":[\"\"],\"status\":[\"0\"],\"append\":[\"\"],\"token\":[\"348e96812421487f81edc4900533506300000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"userId\":\"00000005\",\"customerId\":\"0000\",\"userName\":\"test1\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"tt33\",\"sex\":1,\"phone\":\"1233333\",\"createTime\":1598055857,\"updateTime\":1599913293,\"roleId\":\"00000001\",\"append\":\"\"}}', '1599913293247', '1599913293267', '20', '200', '修改用户', '1599913293');
INSERT INTO `sys_log` VALUES ('5350', '127.0.0.1', '/resetPass', '00000000', 'POST', '{\"userId\":[\"00000005\"],\"customerId\":[\"0000\"],\"token\":[\"348e96812421487f81edc4900533506300000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599913303697', '1599913303728', '31', '200', '重置密码', '1599913303');
INSERT INTO `sys_log` VALUES ('5351', '127.0.0.1', '/login', '00000005', 'POST', '{\"userName\":[\"test1\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913202},\"user\":{\"userId\":\"00000005\",\"customerId\":\"0000\",\"userName\":\"test1\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"tt33\",\"sex\":1,\"phone\":\"1233333\",\"createTime\":1598055857,\"updateTime\":1599913293,\"roleId\":\"00000001\",\"append\":\"\"},\"token\":\"ac24f0f376bf47b2861f60406b0f4eb600000005\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913316887', '1599913316896', '9', '200', '用户登录', '1599913316');
INSERT INTO `sys_log` VALUES ('5352', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"764fc003001843dba358efa34b79c74200000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913333473', '1599913333483', '10', '200', '用户登录', '1599913333');
INSERT INTO `sys_log` VALUES ('5353', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,3,4,33,35,5,6,64,65,66,67,68,7\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"764fc003001843dba358efa34b79c74200000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913356}}', '1599913356842', '1599913356895', '53', '200', '修改角色', '1599913356');
INSERT INTO `sys_log` VALUES ('5354', '127.0.0.1', '/login', '00000005', 'POST', '{\"userName\":[\"test1\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913356},\"user\":{\"userId\":\"00000005\",\"customerId\":\"0000\",\"userName\":\"test1\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"tt33\",\"sex\":1,\"phone\":\"1233333\",\"createTime\":1598055857,\"updateTime\":1599913293,\"roleId\":\"00000001\",\"append\":\"\"},\"token\":\"b0e0b6bd803544cc96d4e1fa9fb491c900000005\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913383010', '1599913383019', '9', '200', '用户登录', '1599913383');
INSERT INTO `sys_log` VALUES ('5355', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"c20f1135d1ee44aab940075d4c553b9500000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913408114', '1599913408124', '10', '200', '用户登录', '1599913408');
INSERT INTO `sys_log` VALUES ('5356', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,3,4,33,35,64,65,66,7\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"c20f1135d1ee44aab940075d4c553b9500000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913426}}', '1599913426979', '1599913427025', '46', '200', '修改角色', '1599913427');
INSERT INTO `sys_log` VALUES ('5357', '127.0.0.1', '/login', '00000005', 'POST', '{\"userName\":[\"test1\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913426},\"user\":{\"userId\":\"00000005\",\"customerId\":\"0000\",\"userName\":\"test1\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"tt33\",\"sex\":1,\"phone\":\"1233333\",\"createTime\":1598055857,\"updateTime\":1599913293,\"roleId\":\"00000001\",\"append\":\"\"},\"token\":\"ee4eaa7873934ba382faad080142b5ac00000005\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913437070', '1599913437078', '8', '200', '用户登录', '1599913437');
INSERT INTO `sys_log` VALUES ('5358', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"7e7966543cf942dea9228f7f27c22d6400000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599913475898', '1599913475906', '8', '200', '用户登录', '1599913475');
INSERT INTO `sys_log` VALUES ('5359', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,35\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"7e7966543cf942dea9228f7f27c22d6400000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599913501}}', '1599913501072', '1599913501102', '30', '200', '修改角色', '1599913501');
INSERT INTO `sys_log` VALUES ('5360', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,35,3,4,64,5,6\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"7e7966543cf942dea9228f7f27c22d6400000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599916629}}', '1599916629823', '1599916629895', '72', '200', '修改角色', '1599916629');
INSERT INTO `sys_log` VALUES ('5361', '127.0.0.1', '/login', '00000005', 'POST', '{\"userName\":[\"test1\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599916629},\"user\":{\"userId\":\"00000005\",\"customerId\":\"0000\",\"userName\":\"test1\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"tt33\",\"sex\":1,\"phone\":\"1233333\",\"createTime\":1598055857,\"updateTime\":1599913293,\"roleId\":\"00000001\",\"append\":\"\"},\"token\":\"70220b703ea24512b75dba32106fb69f00000005\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599916641408', '1599916641417', '9', '200', '用户登录', '1599916641');
INSERT INTO `sys_log` VALUES ('5362', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"ce8934792ee746f5894ce7acd800728f00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599916665677', '1599916665686', '9', '200', '用户登录', '1599916665');
INSERT INTO `sys_log` VALUES ('5363', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,35,3,4,6,64,5,65,66,67,68\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"ce8934792ee746f5894ce7acd800728f00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599916832}}', '1599916832399', '1599916832461', '62', '200', '修改角色', '1599916832');
INSERT INTO `sys_log` VALUES ('5364', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,35,3,4,6,64,5,65,66,67,68,72,8,9,73,69,70\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"ce8934792ee746f5894ce7acd800728f00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599916858}}', '1599916858144', '1599916858208', '64', '200', '修改角色', '1599916858');
INSERT INTO `sys_log` VALUES ('5365', '127.0.0.1', '/login', '00000005', 'POST', '{\"userName\":[\"test1\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599916858},\"user\":{\"userId\":\"00000005\",\"customerId\":\"0000\",\"userName\":\"test1\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"tt33\",\"sex\":1,\"phone\":\"1233333\",\"createTime\":1598055857,\"updateTime\":1599913293,\"roleId\":\"00000001\",\"append\":\"\"},\"token\":\"1ccd0006dbaa48be9daeb4e17485452c00000005\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599916872924', '1599916872934', '10', '200', '用户登录', '1599916872');
INSERT INTO `sys_log` VALUES ('5366', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"4d6e4685f43e414a96b90008a019fa1f00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599916897816', '1599916897844', '28', '200', '用户登录', '1599916897');
INSERT INTO `sys_log` VALUES ('5367', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"test\"],\"auth\":[\"1,2,35,3,4,6,64,5,65,66,67,68,72,8,9,73,69,10,70\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000001\"],\"token\":[\"4d6e4685f43e414a96b90008a019fa1f00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599917161}}', '1599917161589', '1599917161652', '63', '200', '修改角色', '1599917161');
INSERT INTO `sys_log` VALUES ('5368', '127.0.0.1', '/login', '00000005', 'POST', '{\"userName\":[\"test1\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"00000001\",\"roleName\":\"test\",\"customerId\":\"0000\",\"updateTime\":1599917161},\"user\":{\"userId\":\"00000005\",\"customerId\":\"0000\",\"userName\":\"test1\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"tt33\",\"sex\":1,\"phone\":\"1233333\",\"createTime\":1598055857,\"updateTime\":1599913293,\"roleId\":\"00000001\",\"append\":\"\"},\"token\":\"9b912836b7f04fbda61ab98165019c1d00000005\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599917171129', '1599917171139', '10', '200', '用户登录', '1599917171');
INSERT INTO `sys_log` VALUES ('5369', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"194c3fe15fe542bab3a8bd2e4648feeb00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599987512502', '1599987512544', '42', '200', '用户登录', '1599987512');
INSERT INTO `sys_log` VALUES ('5370', '127.0.0.1', '/report', '00000000', 'POST', '{\"reportName\":[\"出成率统计\"],\"path\":[\"yieldReport.vue\"],\"filePath\":[\"report/yieldReport\"],\"customerId\":[\"0000\"],\"token\":[\"194c3fe15fe542bab3a8bd2e4648feeb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"reportId\":4,\"reportName\":\"出成率统计\",\"path\":\"yieldReport.vue\",\"filePath\":\"report/yieldReport\",\"status\":0,\"createTime\":1599987823,\"updateTime\":1599987823}}', '1599987823213', '1599987823247', '34', '200', '添加报表', '1599987823');
INSERT INTO `sys_log` VALUES ('5371', '127.0.0.1', '/updateReport', '00000000', 'POST', '{\"reportId\":[\"4\"],\"reportName\":[\"出成率统计\"],\"path\":[\"yieldReport\"],\"filePath\":[\"report/yieldReport\"],\"status\":[\"0\"],\"createTime\":[\"1599987823\"],\"updateTime\":[\"1599987823\"],\"append\":[\"\"],\"customerId\":[\"0000\"],\"token\":[\"194c3fe15fe542bab3a8bd2e4648feeb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599989318404', '1599989318872', '468', '200', '修改报表', '1599989318');
INSERT INTO `sys_log` VALUES ('5372', '127.0.0.1', '/updateReport', '00000000', 'POST', '{\"reportId\":[\"4\"],\"reportName\":[\"出成率统计\"],\"path\":[\"/yieldReport\"],\"filePath\":[\"report/yieldReport\"],\"status\":[\"0\"],\"createTime\":[\"1599987823\"],\"updateTime\":[\"1599989318\"],\"append\":[\"\"],\"customerId\":[\"0000\"],\"token\":[\"194c3fe15fe542bab3a8bd2e4648feeb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1599989327171', '1599989327317', '146', '200', '修改报表', '1599989327');
INSERT INTO `sys_log` VALUES ('5373', '127.0.0.1', '/report', '00000000', 'POST', '{\"reportName\":[\"产量统计\"],\"path\":[\"/procudtReport\"],\"filePath\":[\"report/procudtReport\"],\"customerId\":[\"0000\"],\"token\":[\"194c3fe15fe542bab3a8bd2e4648feeb00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"reportId\":5,\"reportName\":\"产量统计\",\"path\":\"/procudtReport\",\"filePath\":\"report/procudtReport\",\"status\":0,\"createTime\":1599989367,\"updateTime\":1599989367}}', '1599989367065', '1599989367081', '16', '200', '添加报表', '1599989367');
INSERT INTO `sys_log` VALUES ('5374', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"430ad6f3a6604815838087a1f076ea4a00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1599999216106', '1599999216254', '148', '200', '用户登录', '1599999216');
INSERT INTO `sys_log` VALUES ('5375', '127.0.0.1', '/report', '00000000', 'POST', '{\"reportName\":[\"员工工资统计\"],\"path\":[\"/salaryReport\"],\"filePath\":[\"report/salaryReport\"],\"customerId\":[\"0000\"],\"token\":[\"430ad6f3a6604815838087a1f076ea4a00000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"reportId\":6,\"reportName\":\"员工工资统计\",\"path\":\"/salaryReport\",\"filePath\":\"report/salaryReport\",\"status\":0,\"createTime\":1600000144,\"updateTime\":1600000144}}', '1600000144617', '1600000144839', '222', '200', '添加报表', '1600000144');
INSERT INTO `sys_log` VALUES ('5376', '127.0.0.1', '/shareReport', '00000000', 'POST', '{\"customerIds\":[\"0001,0002,0003,0004\"],\"reportId\":[\"3\"],\"token\":[\"430ad6f3a6604815838087a1f076ea4a00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1600001669810', '1600001670551', '741', '200', '分配报表', '1600001670');
INSERT INTO `sys_log` VALUES ('5377', '127.0.0.1', '/deleteReport', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"reportId\":[\"1\"],\"token\":[\"430ad6f3a6604815838087a1f076ea4a00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1600002264086', '1600002264189', '103', '200', '删除报表', '1600002264');
INSERT INTO `sys_log` VALUES ('5378', '127.0.0.1', '/deleteReport', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"reportId\":[\"2\"],\"token\":[\"430ad6f3a6604815838087a1f076ea4a00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1600004027245', '1600004027280', '35', '200', '删除报表', '1600004027');
INSERT INTO `sys_log` VALUES ('5379', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"f34388c9b80e43eead2d663defc0c61300000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600083415208', '1600083420537', '5329', '200', '用户登录', '1600083420');
INSERT INTO `sys_log` VALUES ('5380', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"951f468e6e7d4d8888e8835373cf0af900000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600083412167', '1600083420537', '8370', '200', '用户登录', '1600083420');
INSERT INTO `sys_log` VALUES ('5381', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"d4803b1079ef45389e0cf9955727674400000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600083424566', '1600083425022', '456', '200', '用户登录', '1600083425');
INSERT INTO `sys_log` VALUES ('5382', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"100\"],\"subsidy\":[\"100\"],\"append\":[\"1\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"14\"],\"customerId\":[\"0000\"],\"token\":[\"d4803b1079ef45389e0cf9955727674400000000\"]}', null, '1600090199624', '1600090199657', '33', '200', '添加工资调整', '1600090199');
INSERT INTO `sys_log` VALUES ('5383', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"100\"],\"subsidy\":[\"100\"],\"append\":[\"1\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"14\"],\"customerId\":[\"0000\"],\"token\":[\"d4803b1079ef45389e0cf9955727674400000000\"]}', '{\"errorcode\":1,\"message\":\"error performing isolated work; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: error performing isolated work\"}', '1600090532125', '1600090532417', '292', '200', '添加工资调整', '1600090532');
INSERT INTO `sys_log` VALUES ('5384', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"100\"],\"subsidy\":[\"100\"],\"append\":[\"1\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"14\"],\"customerId\":[\"0000\"],\"token\":[\"d4803b1079ef45389e0cf9955727674400000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":1,\"customerId\":\"0000\",\"adjust\":100,\"subsidy\":100,\"year\":2020,\"month\":9,\"day\":14,\"updateTime\":1600090601,\"operateUserId\":\"00000000\",\"append\":\"1\"}}', '1600090601215', '1600090601531', '316', '200', '添加工资调整', '1600090601');
INSERT INTO `sys_log` VALUES ('5385', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"200\"],\"subsidy\":[\"200\"],\"append\":[\"2\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"14\"],\"customerId\":[\"0000\"],\"token\":[\"d4803b1079ef45389e0cf9955727674400000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":2,\"customerId\":\"0000\",\"adjust\":200,\"subsidy\":200,\"year\":2020,\"month\":9,\"day\":14,\"updateTime\":1600090615,\"operateUserId\":\"00000000\",\"append\":\"2\"}}', '1600090615910', '1600090615923', '13', '200', '添加工资调整', '1600090615');
INSERT INTO `sys_log` VALUES ('5386', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"-500\"],\"subsidy\":[\"200\"],\"append\":[\"测试\"],\"staffNo\":[\"1403\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"14\"],\"customerId\":[\"0000\"],\"token\":[\"d4803b1079ef45389e0cf9955727674400000000\"]}', '{\"errorcode\":1,\"message\":\"could not execute statement; SQL [n/a]; nested exception is org.hibernate.exception.DataException: could not execute statement\"}', '1600090814871', '1600090814914', '43', '200', '添加工资调整', '1600090814');
INSERT INTO `sys_log` VALUES ('5387', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"-500\"],\"subsidy\":[\"200\"],\"append\":[\"测试\"],\"staffNo\":[\"1403\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"14\"],\"customerId\":[\"0000\"],\"token\":[\"d4803b1079ef45389e0cf9955727674400000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":3,\"staffNo\":\"1403\",\"customerId\":\"0000\",\"adjust\":-500,\"subsidy\":200,\"year\":2020,\"month\":9,\"day\":14,\"updateTime\":1600090843,\"operateUserId\":\"00000000\",\"append\":\"测试\"}}', '1600090843762', '1600090843774', '12', '200', '添加工资调整', '1600090843');
INSERT INTO `sys_log` VALUES ('5388', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"0\"],\"subsidy\":[\"20000\"],\"append\":[\"\"],\"staffNo\":[\"1399\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"14\"],\"customerId\":[\"0000\"],\"token\":[\"d4803b1079ef45389e0cf9955727674400000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":4,\"staffNo\":\"1399\",\"customerId\":\"0000\",\"adjust\":0,\"subsidy\":20000,\"year\":2020,\"month\":9,\"day\":14,\"updateTime\":1600093850,\"operateUserId\":\"00000000\",\"append\":\"\"}}', '1600093850634', '1600093850763', '129', '200', '添加工资调整', '1600093850');
INSERT INTO `sys_log` VALUES ('5389', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"8b14e64f61434bbf84754b52f0c21ae700000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600169332053', '1600169333064', '1011', '200', '用户登录', '1600169333');
INSERT INTO `sys_log` VALUES ('5390', '127.0.0.1', '/menus', '00000000', 'POST', '{\"name\":[\"工资详情\"],\"path\":[\"/daySalaryDetail\"],\"type\":[\"2\"],\"hidden\":[\"0\"],\"close\":[\"1\"],\"filePath\":[\"salary/daySalaryDetail\"],\"icon\":[\"operateLog\"],\"level\":[\"3\"],\"parentId\":[\"7\"],\"token\":[\"8b14e64f61434bbf84754b52f0c21ae700000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"menuId\":77,\"name\":\"工资详情\",\"path\":\"/daySalaryDetail\",\"type\":2,\"hidden\":0,\"close\":1,\"parentId\":7,\"icon\":\"operateLog\",\"filePath\":\"salary/daySalaryDetail\",\"level\":3}}', '1600170323570', '1600170323626', '56', '200', '添加菜单', '1600170323');
INSERT INTO `sys_log` VALUES ('5391', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"91de120acbe34d2090bdcd454ebf93f100000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600180149857', '1600180149889', '32', '200', '用户登录', '1600180149');
INSERT INTO `sys_log` VALUES ('5392', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"e40d0714f74c4f7b914b2c1dc7406ae500000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600215578120', '1600215578640', '520', '200', '用户登录', '1600215578');
INSERT INTO `sys_log` VALUES ('5393', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"572a3873c2d247a380fb0c136e7ff26700000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600259838795', '1600259839197', '402', '200', '用户登录', '1600259839');
INSERT INTO `sys_log` VALUES ('5394', '127.0.0.1', '/staff', '00000000', 'POST', '{\"staffNo\":[\"1318\"],\"staffName\":[\"大饼\"],\"sex\":[\"1\"],\"departmentId\":[\"\"],\"staffType\":[\"0\"],\"entryTime\":[\"1600264665\"],\"leaveTime\":[\"0\"],\"status\":[\"0\"],\"phone\":[\"\"],\"address\":[\"\"],\"idcard\":[\"\"],\"cardId\":[\"\"],\"customerId\":[\"0000\"],\"token\":[\"572a3873c2d247a380fb0c136e7ff26700000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"staffId\":\"000000000005\",\"staffNo\":\"1318\",\"staffName\":\"大饼\",\"sex\":1,\"entryTime\":1600264665,\"leaveTime\":0,\"status\":0,\"staffType\":0,\"phone\":\"\",\"address\":\"\",\"idcard\":\"\",\"customerId\":\"0000\",\"createTime\":1600264667,\"updateTime\":1600264667}}', '1600264667206', '1600264667913', '707', '200', '添加员工', '1600264667');
INSERT INTO `sys_log` VALUES ('5395', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"536773765580450c8eb581fcf9bd882c00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600400126023', '1600400126969', '946', '200', '用户登录', '1600400126');
INSERT INTO `sys_log` VALUES ('5396', '127.0.0.1', '/login', null, 'POST', '{\"userName\":[\"lqf\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":1,\"message\":\"用户名或密码错误\"}', '1600593926257', '1600593926704', '447', '200', '用户登录', '1600593926');
INSERT INTO `sys_log` VALUES ('5397', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"78131ec680424f4fa07bedb0a4f96e1800000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600593932668', '1600593932769', '101', '200', '用户登录', '1600593932');
INSERT INTO `sys_log` VALUES ('5398', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"46778b8bd7744da9af95c41abcbfc43300000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600605615966', '1600605616002', '36', '200', '用户登录', '1600605616');
INSERT INTO `sys_log` VALUES ('5399', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"ea47252c875a4fdca7d2fcccab501cee00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600862690907', '1600862691454', '547', '200', '用户登录', '1600862691');
INSERT INTO `sys_log` VALUES ('5400', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"cac4e894a8a9422d906de7f32a853cb600000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1600951032332', '1600951032886', '554', '200', '用户登录', '1600951032');
INSERT INTO `sys_log` VALUES ('5401', '127.0.0.1', '/batchItem', '00000000', 'POST', '{\"itemId\":[\"test\"],\"beginTime\":[\"1600951408\"],\"endTime\":[\"1601395200\"],\"batchId\":[\"000001\"],\"customerId\":[\"0000\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":6,\"itemId\":\"test\",\"batchId\":\"000001\",\"beginTime\":1600951408,\"endTime\":1601395200}}', '1600951412755', '1600951412821', '66', '200', '添加自定义批次', '1600951412');
INSERT INTO `sys_log` VALUES ('5402', '127.0.0.1', '/batch', '00000000', 'POST', '{\"batchName\":[\"批次2\"],\"customerId\":[\"0000\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"batchId\":\"000002\",\"batchName\":\"批次2\",\"customerId\":\"0000\",\"createTime\":1600951453,\"updateTime\":1600951453}}', '1600951453897', '1600951454022', '125', '200', '添加批次', '1600951454');
INSERT INTO `sys_log` VALUES ('5403', '127.0.0.1', '/batchItem', '00000000', 'POST', '{\"itemId\":[\"testt\"],\"beginTime\":[\"1600951479\"],\"endTime\":[\"1601395200\"],\"batchId\":[\"000002\"],\"customerId\":[\"0000\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":7,\"itemId\":\"testt\",\"batchId\":\"000002\",\"beginTime\":1600951479,\"endTime\":1601395200}}', '1600951483218', '1600951483260', '42', '200', '添加自定义批次', '1600951483');
INSERT INTO `sys_log` VALUES ('5404', '127.0.0.1', '/updateBatchItem', '00000000', 'POST', '{\"id\":[\"7\"],\"itemId\":[\"testt1\"],\"batchId\":[\"000002\"],\"beginTime\":[\"1600951479\"],\"endTime\":[\"1601395200\"],\"customerId\":[\"0000\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1600951523168', '1600951523601', '433', '200', '修改自定义批次', '1600951523');
INSERT INTO `sys_log` VALUES ('5405', '127.0.0.1', '/equipment', '00000000', 'POST', '{\"equipmentName\":[\"test\"],\"equipmentType\":[\"\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"equipmentId\":\"00010001\",\"equipmentName\":\"test\",\"customerId\":\"0001\",\"status\":0,\"createTime\":1600956645,\"updateTime\":1600956645,\"subCount\":0}}', '1600956645826', '1600956645925', '99', '200', '添加设备', '1600956645');
INSERT INTO `sys_log` VALUES ('5406', '127.0.0.1', '/subEquipment', '00000000', 'POST', '{\"subEquipmentName\":[\"testa\"],\"type\":[\"0\"],\"customerId\":[\"0001\"],\"equipmentId\":[\"00010001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"subEquipmentId\":\"0001000101\",\"subEquipmentName\":\"testa\",\"type\":0,\"equipmentId\":\"00010001\",\"createTime\":1600956655,\"updateTime\":1600956655,\"staffTypeCalc\":0,\"shiftCalc\":0}}', '1600956655626', '1600956655689', '63', '200', '添加终端', '1600956655');
INSERT INTO `sys_log` VALUES ('5407', '127.0.0.1', '/subEquipment', '00000000', 'POST', '{\"subEquipmentName\":[\"testb\"],\"type\":[\"1\"],\"customerId\":[\"0001\"],\"equipmentId\":[\"00010001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"subEquipmentId\":\"0001000102\",\"subEquipmentName\":\"testb\",\"type\":1,\"equipmentId\":\"00010001\",\"createTime\":1600956663,\"updateTime\":1600956663,\"staffTypeCalc\":0,\"shiftCalc\":0}}', '1600956663412', '1600956663437', '25', '200', '添加终端', '1600956663');
INSERT INTO `sys_log` VALUES ('5408', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600956689\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600956689977', '1600956690001', '24', '200', '添加修改记录', '1600956690');
INSERT INTO `sys_log` VALUES ('5409', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600956689\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600956908753', '1600956908786', '33', '200', '添加修改记录', '1600956908');
INSERT INTO `sys_log` VALUES ('5410', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600957048\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957049734', '1600957049799', '65', '200', '添加修改记录', '1600957049');
INSERT INTO `sys_log` VALUES ('5411', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600957048\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957051432', '1600957051446', '14', '200', '添加修改记录', '1600957051');
INSERT INTO `sys_log` VALUES ('5412', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600957048\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957063852', '1600957109889', '46037', '200', '添加修改记录', '1600957109');
INSERT INTO `sys_log` VALUES ('5413', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600957048\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957126538', '1600957126925', '387', '200', '添加修改记录', '1600957126');
INSERT INTO `sys_log` VALUES ('5414', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600957048\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957129531', '1600957129552', '21', '200', '添加修改记录', '1600957129');
INSERT INTO `sys_log` VALUES ('5415', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600956684\"],\"endTime\":[\"1600957048\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957147708', '1600957170823', '23115', '200', '添加修改记录', '1600957170');
INSERT INTO `sys_log` VALUES ('5416', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957228\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957228810', '1600957228831', '21', '200', '添加修改记录', '1600957228');
INSERT INTO `sys_log` VALUES ('5417', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957228\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957241120', '1600957433560', '192440', '200', '添加修改记录', '1600957433');
INSERT INTO `sys_log` VALUES ('5418', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957228\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"ids for this class must be manually assigned before calling save(): com.wk.bean.RecordOld; nested exception is org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save(): com.wk.bean.RecordOld\"}', '1600957669143', '1600957669575', '432', '200', '添加修改记录', '1600957669');
INSERT INTO `sys_log` VALUES ('5419', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957228\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"成功修改6条记录\"}', '1600957829203', '1600957829975', '772', '200', '添加修改记录', '1600957829');
INSERT INTO `sys_log` VALUES ('5420', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957965\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600957967043', '1600957967087', '44', '200', '添加修改记录', '1600957967');
INSERT INTO `sys_log` VALUES ('5421', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010001\"],\"newTechnologyId\":[\"00010004\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957965\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"成功修改6条记录\"}', '1600957978137', '1600958015823', '37686', '200', '添加修改记录', '1600958015');
INSERT INTO `sys_log` VALUES ('5422', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010001\"],\"newTechnologyId\":[\"00010004\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957965\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600958036307', '1600958036683', '376', '200', '添加修改记录', '1600958036');
INSERT INTO `sys_log` VALUES ('5423', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010001\"],\"newTechnologyId\":[\"00010004\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957965\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1600958059090', '1600958059195', '105', '200', '添加修改记录', '1600958059');
INSERT INTO `sys_log` VALUES ('5424', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600957965\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"成功修改6条记录\"}', '1600958063539', '1600958063736', '197', '200', '添加修改记录', '1600958063');
INSERT INTO `sys_log` VALUES ('5425', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010001\"],\"newTechnologyId\":[\"00010004\"],\"newPrice\":[\"100\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600790400\"],\"endTime\":[\"1600958124\"],\"customerId\":[\"0001\"],\"token\":[\"cac4e894a8a9422d906de7f32a853cb600000000\"]}', '{\"errorcode\":0,\"message\":\"成功修改6条记录\"}', '1600958125116', '1600958125305', '189', '200', '添加修改记录', '1600958125');
INSERT INTO `sys_log` VALUES ('5426', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"4067bccf5b4743f89378b5533bf86f3200000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1601080387419', '1601080387948', '529', '200', '用户登录', '1601080387');
INSERT INTO `sys_log` VALUES ('5427', '127.0.0.1', '/updaterole', '00000000', 'POST', '{\"roleName\":[\"大司马\"],\"auth\":[\"1,2,7,18,25,27,28\"],\"customerId\":[\"0000\"],\"roleId\":[\"00000004\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"roleId\":\"00000004\",\"roleName\":\"大司马\",\"customerId\":\"0000\",\"updateTime\":1601081894}}', '1601081893973', '1601081894224', '251', '200', '修改角色', '1601081894');
INSERT INTO `sys_log` VALUES ('5428', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"2\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601083186652', '1601083186743', '91', '200', '修改终端支持计费类型', '1601083186');
INSERT INTO `sys_log` VALUES ('5429', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"0\"],\"type\":[\"1\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601083189793', '1601083189852', '59', '200', '修改终端支持计费类型', '1601083189');
INSERT INTO `sys_log` VALUES ('5430', '127.0.0.1', '/calcSwitch', '00000000', 'POST', '{\"customerId\":[\"0000\"],\"subEquipmentId\":[\"0000000101\"],\"status\":[\"1\"],\"type\":[\"1\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601083248371', '1601083248473', '102', '200', '修改终端支持计费类型', '1601083248');
INSERT INTO `sys_log` VALUES ('5431', '127.0.0.1', '/shareReport', '00000000', 'POST', '{\"customerIds\":[\"0001,0002,0003,0004\"],\"reportId\":[\"6\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601083350202', '1601083350283', '81', '200', '分配报表', '1601083350');
INSERT INTO `sys_log` VALUES ('5432', '127.0.0.1', '/cancleShareReport', '00000000', 'POST', '{\"customerIds\":[\"0001,0002\"],\"reportId\":[\"6\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601083360571', '1601083360586', '15', '200', '取消分配报表', '1601083360');
INSERT INTO `sys_log` VALUES ('5433', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000101\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1598926261\"],\"endTime\":[\"1601086270\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1601086279357', '1601086279401', '44', '200', '添加修改记录', '1601086279');
INSERT INTO `sys_log` VALUES ('5434', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1598889600\"],\"endTime\":[\"1601086457\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"成功修改6条记录\"}', '1601086458813', '1601086458893', '80', '200', '添加修改记录', '1601086458');
INSERT INTO `sys_log` VALUES ('5435', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010002\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010002\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010002\"],\"newTechnologyId\":[\"00010004\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1601086565\"],\"endTime\":[\"1601086568\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1601086595617', '1601086595637', '20', '200', '添加修改记录', '1601086595');
INSERT INTO `sys_log` VALUES ('5436', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010002\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010002\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010002\"],\"newTechnologyId\":[\"00010004\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000101\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600963200\"],\"endTime\":[\"1601086727\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1601086729630', '1601086729641', '11', '200', '添加修改记录', '1601086729');
INSERT INTO `sys_log` VALUES ('5437', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010001\"],\"oldSpecId\":[\"00010001\"],\"newSpecId\":[\"00010006\"],\"oldTechnologyId\":[\"00010001\"],\"newTechnologyId\":[\"00010001\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600876800\"],\"endTime\":[\"1601086824\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"newProductionName\":[\"产品1\"],\"oldProductionName\":[\"产品1\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1601086825582', '1601086825609', '27', '200', '添加修改记录', '1601086825');
INSERT INTO `sys_log` VALUES ('5438', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010002\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010002\"],\"oldTechnologyId\":[\"00010001\"],\"newTechnologyId\":[\"00010002\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600876800\"],\"endTime\":[\"1601087030\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"newProductionName\":[\"产品3\"],\"oldProductionName\":[\"产品1\"],\"newSpecName\":[\"规格1\"],\"oldSpecName\":[\"规格1\"],\"newTechnologyName\":[\"工艺22\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"成功修改6条记录\"}', '1601087031281', '1601087031347', '66', '200', '添加修改记录', '1601087031');
INSERT INTO `sys_log` VALUES ('5439', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010002\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010002\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010002\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"\"],\"newBatchId\":[\"\"],\"beginTime\":[\"1600741487\"],\"endTime\":[\"1601087098\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"newProductionName\":[\"产品3\"],\"oldProductionName\":[\"产品1\"],\"newSpecName\":[\"规格1\"],\"oldSpecName\":[\"规格1\"],\"newTechnologyName\":[\"工艺22\"],\"oldTechnologyName\":[\"ff\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1601087099150', '1601087099162', '12', '200', '添加修改记录', '1601087099');
INSERT INTO `sys_log` VALUES ('5440', '127.0.0.1', '/recordEditLog', '00000000', 'POST', '{\"oldProductionId\":[\"00010001\"],\"newProductionId\":[\"00010002\"],\"oldSpecId\":[\"00010006\"],\"newSpecId\":[\"00010002\"],\"oldTechnologyId\":[\"00010004\"],\"newTechnologyId\":[\"00010002\"],\"newPrice\":[\"0\"],\"subEquipmentId\":[\"0001000102\"],\"oldBatchId\":[\"1\"],\"newBatchId\":[\"1\"],\"beginTime\":[\"1600741487\"],\"endTime\":[\"1601087098\"],\"customerId\":[\"0001\"],\"price\":[\"NaN\"],\"newProductionName\":[\"产品3\"],\"oldProductionName\":[\"产品1\"],\"newSpecName\":[\"规格1\"],\"oldSpecName\":[\"规格1\"],\"newTechnologyName\":[\"工艺22\"],\"oldTechnologyName\":[\"ff\"],\"newBatchName\":[\"1231\"],\"oldBatchName\":[\"1231\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":1,\"message\":\"未查询到相关记录\"}', '1601087106130', '1601087106162', '32', '200', '添加修改记录', '1601087106');
INSERT INTO `sys_log` VALUES ('5441', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"f2a8579c95f9426bbcf8b25e3d99818600000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1601088726312', '1601088726383', '71', '200', '用户登录', '1601088726');
INSERT INTO `sys_log` VALUES ('5442', '171.111.136.255', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"f6c967689f6c438195977f01ed294add00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1601088773476', '1601088773500', '24', '200', '用户登录', '1601088773');
INSERT INTO `sys_log` VALUES ('5443', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010002\"],\"cardNo\":[\"4t\"],\"cardName\":[\"122\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1598594490\"],\"updateTime\":[\"1598594490\"],\"append\":[\"\"],\"staffId\":[\"000100000002\"],\"staffName\":[\"李四\"],\"beginTime\":[\"0\"],\"cardOutNo\":[\"123\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601088918681', '1601088918756', '75', '200', '修改卡', '1601088918');
INSERT INTO `sys_log` VALUES ('5444', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010002\"],\"cardNo\":[\"qwwww\"],\"cardName\":[\"122\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1598594490\"],\"updateTime\":[\"1598594490\"],\"append\":[\"\"],\"staffId\":[\"000100000002\"],\"staffName\":[\"李四\"],\"beginTime\":[\"0\"],\"cardOutNo\":[\"qweee\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601089054098', '1601089054194', '96', '200', '修改卡', '1601089054');
INSERT INTO `sys_log` VALUES ('5445', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010002\"],\"cardNo\":[\"4t\"],\"cardName\":[\"122\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1598594490\"],\"updateTime\":[\"1598594490\"],\"append\":[\"\"],\"staffId\":[\"000100000002\"],\"staffName\":[\"李四\"],\"beginTime\":[\"0\"],\"cardOutNo\":[\"123\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601089431083', '1601089431290', '207', '200', '修改卡', '1601089431');
INSERT INTO `sys_log` VALUES ('5446', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010002\"],\"cardNo\":[\"4t\"],\"cardName\":[\"122\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1598594490\"],\"updateTime\":[\"1601089431\"],\"append\":[\"\"],\"staffId\":[\"000100000002\"],\"staffName\":[\"李四\"],\"beginTime\":[\"0\"],\"cardOutNo\":[\"1231\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601089515311', '1601089515348', '37', '200', '修改卡', '1601089515');
INSERT INTO `sys_log` VALUES ('5447', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010002\"],\"cardNo\":[\"4t\"],\"cardName\":[\"122\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1598594490\"],\"updateTime\":[\"1601089515\"],\"append\":[\"\"],\"staffId\":[\"000100000002\"],\"staffName\":[\"李四\"],\"beginTime\":[\"0\"],\"cardOutNo\":[\"12311\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601089523288', '1601089523337', '49', '200', '修改卡', '1601089523');
INSERT INTO `sys_log` VALUES ('5448', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010002\"],\"cardNo\":[\"4t\"],\"cardName\":[\"122\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1598594490\"],\"updateTime\":[\"1601089523\"],\"append\":[\"\"],\"staffId\":[\"000100000002\"],\"staffName\":[\"李四\"],\"beginTime\":[\"0\"],\"cardOutNo\":[\"123111\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601089641594', '1601089641776', '182', '200', '修改卡', '1601089641');
INSERT INTO `sys_log` VALUES ('5449', '127.0.0.1', '/updateCard', '00000000', 'POST', '{\"cardId\":[\"00010002\"],\"cardNo\":[\"4t\"],\"cardName\":[\"122\"],\"cardType\":[\"1\"],\"customerId\":[\"0001\"],\"status\":[\"0\"],\"createTime\":[\"1598594490\"],\"updateTime\":[\"1601089641\"],\"append\":[\"\"],\"staffId\":[\"000100000007\"],\"staffName\":[\"李四\"],\"beginTime\":[\"0\"],\"cardOutNo\":[\"123111\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601089650141', '1601089650188', '47', '200', '修改卡', '1601089650');
INSERT INTO `sys_log` VALUES ('5450', '127.0.0.1', '/fileupload', '00000000', 'POST', '{\"type\":[\"2\"],\"customerId\":[\"0001\"],\"token\":[\"4067bccf5b4743f89378b5533bf86f3200000000\"]}', '{\"errorcode\":1,\"message\":\"第1行，IC卡内号已存在\"}', '1601089883444', '1601089884234', '790', '200', '文件导入', '1601089884');
INSERT INTO `sys_log` VALUES ('5451', '171.111.136.255', '/updateStaff', '00000000', 'POST', '{\"staffId\":[\"000200000001\"],\"staffNo\":[\"1333\"],\"staffName\":[\"1333\"],\"sex\":[\"1\"],\"entryTime\":[\"1598794360\"],\"leaveTime\":[\"0\"],\"status\":[\"0\"],\"staffType\":[\"0\"],\"phone\":[\"\"],\"address\":[\"\"],\"idcard\":[\"\"],\"customerId\":[\"0002\"],\"createTime\":[\"1598794361\"],\"updateTime\":[\"1598794361\"],\"append\":[\"\"],\"departmentId\":[\"00020001\"],\"departmentName\":[\"\"],\"cardId\":[\"\"],\"parents\":[\"\"],\"token\":[\"f6c967689f6c438195977f01ed294add00000000\"]}', '{\"errorcode\":0,\"message\":\"success\"}', '1601092522957', '1601092523252', '295', '200', '修改员工', '1601092523');
INSERT INTO `sys_log` VALUES ('5452', '171.111.136.255', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"4cc091256f584a9a8dc43226531c836c00000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1601099996602', '1601099996633', '31', '200', '用户登录', '1601099996');
INSERT INTO `sys_log` VALUES ('5453', '127.0.0.1', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"c1f85869bc634c69ba6b5bd65703916900000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1601109720552', '1601109720956', '404', '200', '用户登录', '1601109720');
INSERT INTO `sys_log` VALUES ('5454', '127.0.0.1', '/addSalaryAdjustLog', '00000000', 'POST', '{\"adjust\":[\"1000\"],\"subsidy\":[\"1000\"],\"staffNo\":[\"1322\"],\"year\":[\"2020\"],\"month\":[\"9\"],\"day\":[\"16\"],\"customerId\":[\"0000\"],\"token\":[\"c1f85869bc634c69ba6b5bd65703916900000000\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"id\":5,\"staffNo\":\"1322\",\"customerId\":\"0000\",\"adjust\":1000,\"subsidy\":1000,\"year\":2020,\"month\":9,\"day\":16,\"updateTime\":1601110543,\"operateUserId\":\"00000000\"}}', '1601110543226', '1601110543288', '62', '200', '添加工资调整', '1601110543');
INSERT INTO `sys_log` VALUES ('5455', '218.56.65.142', '/login', '00000000', 'POST', '{\"userName\":[\"admin\"],\"password\":[\"12345678\"],\"token\":[\"\"]}', '{\"errorcode\":0,\"message\":\"success\",\"data\":{\"role\":{\"roleId\":\"0000\",\"roleName\":\"超级管理员\",\"customerId\":\"0000\",\"level\":1,\"createTime\":0,\"updateTime\":0},\"user\":{\"userId\":\"00000000\",\"customerId\":\"0000\",\"userName\":\"admin\",\"password\":\"25d55ad283aa400af464c76d713c07ad\",\"realName\":\"超级管理员\",\"sex\":1,\"phone\":\"1\",\"roleId\":\"0000\",\"status\":0},\"token\":\"7d0dcf30d2894365a5542e84d87fbee200000000\",\"customer\":{\"customerId\":\"0000\",\"company\":\"云平台\",\"status\":0,\"equipmentCount\":0}}}', '1601381755643', '1601381755902', '259', '200', '用户登录', '1601381755');

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
