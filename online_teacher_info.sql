/*
Navicat MySQL Data Transfer

Source Server         : myDB
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : online_teacher_info

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-17 16:09:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `last_time` date DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'xu', '123', '2018-02-02', '0:0:0:0:0:0:0:1', '谢');

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `appointment_date` datetime DEFAULT NULL COMMENT '预约时间',
  `teacher_id` int(20) DEFAULT NULL COMMENT '教员id',
  `student_id` int(20) DEFAULT NULL COMMENT '学员id',
  `organiser` int(1) DEFAULT NULL COMMENT '预约发起人身份(1:学员，2：教员)',
  `status` int(1) DEFAULT '0' COMMENT '预约状态(0:待接受，1：已接受)',
  `teacher_name` varchar(10) DEFAULT NULL,
  `teacher_requirement_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('6', '2017-11-27 10:30:30', '1', '1', '1', '1', '李晓天', '1');
INSERT INTO `appointment` VALUES ('7', '2017-11-27 10:31:09', '1', '3', '1', '1', '李晓地', '1');
INSERT INTO `appointment` VALUES ('8', '2017-11-27 15:29:08', '4', '3', '2', '1', '谢小天', '1');
INSERT INTO `appointment` VALUES ('9', '2018-03-07 14:25:34', '1', '3', '2', '0', '李一', '4');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL COMMENT '学员id',
  `comment` varchar(255) DEFAULT NULL COMMENT '学员评价',
  `comment_time` date DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '好', '2018-03-02');

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `charge_date` datetime DEFAULT NULL COMMENT '充值时间',
  `charge_money` varchar(255) DEFAULT NULL COMMENT '充值金额',
  `status` int(11) DEFAULT NULL COMMENT '充值状态(0:成功，1:失败)',
  `organiser` int(11) DEFAULT NULL COMMENT '充值人身份(1:学员，2：教员)',
  `organiser_id` int(11) DEFAULT NULL COMMENT '充值人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES ('5', '2017-11-28 00:00:00', '100', '0', '1', '3');
INSERT INTO `deposit` VALUES ('6', '2017-11-29 13:31:07', '100', '0', '1', '3');
INSERT INTO `deposit` VALUES ('7', '2017-11-29 13:31:23', '100', '0', '1', '3');
INSERT INTO `deposit` VALUES ('8', '2017-11-29 13:39:29', '100', '0', '1', '3');
INSERT INTO `deposit` VALUES ('9', '2017-11-29 13:40:34', '100', '0', '1', '3');
INSERT INTO `deposit` VALUES ('10', '2018-02-04 21:33:33', '100', '0', '1', '3');
INSERT INTO `deposit` VALUES ('11', '2018-02-23 21:19:05', '100', '0', '2', '1');

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL COMMENT '教员id',
  `name` varchar(255) DEFAULT NULL COMMENT '教员姓名',
  `sex` int(11) DEFAULT NULL COMMENT '教员性别(0:男，1：女)',
  `education` varchar(255) DEFAULT NULL COMMENT '学历',
  `school_major` varchar(255) DEFAULT NULL COMMENT '学校专业',
  `subject` varchar(255) DEFAULT NULL COMMENT '可授课程',
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES ('3', '1', '李一', '1', '本科在读', '暨南大学电子信息系统', '初一初二科学,初三数学', '3');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `organsier` int(1) NOT NULL COMMENT '留言人身份：(1:学员，2：教员)',
  `add_date` datetime DEFAULT NULL,
  `organsier_id` int(20) NOT NULL COMMENT '留言人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '很好', '2', '2018-03-06 16:43:58', '1');

-- ----------------------------
-- Table structure for forder
-- ----------------------------
DROP TABLE IF EXISTS `forder`;
CREATE TABLE `forder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `release_date` datetime DEFAULT NULL COMMENT '发布时间',
  `subject` varchar(11) DEFAULT NULL COMMENT '年级科目',
  `status` int(11) DEFAULT '1' COMMENT '订单状态(1：待支付，2：成功 3：失败 4：关闭 )',
  `appointment_id` int(11) DEFAULT NULL COMMENT '预约记录id',
  `admin_id` int(11) DEFAULT NULL COMMENT '处理人id',
  `admin_name` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `teacher_requirement_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forder
-- ----------------------------
INSERT INTO `forder` VALUES ('1', '2017-11-28 14:51:14', '初2数学', '2', '1', '1', '谢', '1', '3', '1');
INSERT INTO `forder` VALUES ('2', '2017-11-28 16:45:04', '初2英语', '3', null, '1', '谢', '1', '3', '2');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教员id',
  `teacher_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '图片类型（0:头像,1:身份证，2：学生证，3：毕业证，4：教师资格证，5：工作证，6：等级证书，7：生活照片，8：其他照片）',
  `path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `status` int(11) DEFAULT '0' COMMENT '审核状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', '1', '0', 'tx_0.jpg', '2018-02-22 00:00:00', '0');
INSERT INTO `picture` VALUES ('3', '1', '0', 'tx_0.jpg', '2018-02-22 16:51:45', '1');
INSERT INTO `picture` VALUES ('4', '7', '0', 'Koala.jpg', '2018-03-01 11:14:32', '1');
INSERT INTO `picture` VALUES ('5', '6', '0', '45_avatar_max.jpg', '2018-03-05 10:21:01', '1');
INSERT INTO `picture` VALUES ('6', '1', '0', '45_avatar_max.jpg', '2018-03-05 16:09:50', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '学员用户名',
  `sex` int(11) DEFAULT NULL COMMENT '性别(0：男，1：女)',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(30) DEFAULT NULL COMMENT '注册邮箱',
  `last_ip` varchar(30) DEFAULT NULL COMMENT '上次登录ip',
  `last_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `balance` varchar(255) DEFAULT '0' COMMENT '账户余额',
  `isabled` int(11) DEFAULT '0' COMMENT '是否可用（0：未验证邮箱，1：禁用，2：可用）',
  `login_times` int(11) DEFAULT NULL COMMENT '登陆次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3', 'xie', '1', '123', '15913756471', '2357556894@qq.com', '0:0:0:0:0:0:0:1', '2018-03-07 00:00:00', null, '0', '2', '36');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` int(11) DEFAULT NULL COMMENT '性别(0:男，1：女)',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `education` varchar(255) DEFAULT NULL COMMENT '最高学历',
  `major` varchar(255) DEFAULT NULL COMMENT '所学专业',
  `university` varchar(255) DEFAULT NULL COMMENT '就读大学',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `description` varchar(255) DEFAULT NULL COMMENT '自我描述',
  `address` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `teaching_time` varchar(255) DEFAULT NULL COMMENT '辅导经验',
  `teaching_area` varchar(255) DEFAULT NULL COMMENT '教授区域',
  `teaching_way` varchar(255) DEFAULT NULL COMMENT '辅导方式',
  `teaching_subject` varchar(255) DEFAULT NULL COMMENT '教授科目',
  `foreign_level` varchar(255) DEFAULT NULL COMMENT '外语水平',
  `payment` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL COMMENT '家教经历',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `last_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_ip` varchar(255) DEFAULT NULL COMMENT '上次登录ip',
  `isabled` int(1) DEFAULT NULL COMMENT '是否可用（0：未验证邮箱，1：禁用，2：可用）',
  `identity` int(1) DEFAULT NULL COMMENT '职业(0:在校大学生，1：教师)',
  `qq` varchar(30) DEFAULT NULL,
  `current_status` varchar(255) DEFAULT NULL COMMENT '目前身份',
  `wechat` varchar(30) DEFAULT NULL,
  `login_times` int(30) DEFAULT NULL,
  `isverify` int(1) DEFAULT '0' COMMENT '(是否已验证身份，0：未验证身份信息，1：未验证教师信息，2：已验证)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'john', '李一', '123', '1', '1997-09-10', '本科在读', '电子信息系统', '广东财经大学', '23', '2357556894@qq.com', '性格开朗', '11', '1', '奉贤(四团/平安/邵厂),奉贤(奉城/塘外/洪庙/头桥)', '', '初一初二科学,初三数学', '英语四级', '执行阳光家教网薪水标准', '1', 'tx_0.jpg', '2018-03-08 10:13:39', '2018-03-13 14:31:49', '0:0:0:0:0:0:0:1', '2', '1', '123', '在校大一学生', '123', '15', '2');
INSERT INTO `teacher` VALUES ('6', '1', '1', '1', '0', '1937-02', '大专在读', '1', '广东金融学院', '1', '23575156894@qq.com', '11', '1', '16', '海珠 ', null, '幼小衔接 ', null, null, '11', '45_avatar_max.jpg', '2018-02-05 00:00:00', '2018-02-11 00:00:00', null, '2', '0', '1', '在校大一学生', '1', null, '0');
INSERT INTO `teacher` VALUES ('7', '1', '11', '1', '0', '1955-11', '大专毕业', '11', '广东金融学院', '1', '23575562894@qq.com', '1', '1', '0', '白云 ', null, '学前教育 ', null, null, '1', 'Koala.jpg', '2018-02-11 00:00:00', '2018-02-11 00:00:00', null, '1', '0', '1', '在校大三学生', '1', null, '0');
INSERT INTO `teacher` VALUES ('8', 'welljohn1', '谢友根1', '123', '1', '1956-01', '本科在读', '软件工程', '广东财经大学', '123', '2357556894@qq.com', '自学能力强', '1', '0', '海珠 荔湾 ', null, '数学,语文', null, null, '无家教经历', 'tx_0.jpg', '2017-11-30 00:00:00', '2017-11-25 00:00:00', null, '2', '0', '12', '本科在读', '11', null, '0');
INSERT INTO `teacher` VALUES ('9', 'welljohn1', '谢友根1', '123', '1', '1956-01', '本科在读', '软件工程', '广东财经大学', '123', '2357556894@qq.com', '自学能力强', '1', '0', '海珠 荔湾 ', null, '数学,语文', null, null, '无家教经历', 'tx_0.jpg', '2017-11-30 00:00:00', '2017-11-25 00:00:00', null, '2', '0', '12', '本科在读', '11', null, '0');

-- ----------------------------
-- Table structure for teacher_desire
-- ----------------------------
DROP TABLE IF EXISTS `teacher_desire`;
CREATE TABLE `teacher_desire` (
  `id` int(11) NOT NULL,
  `subject` varchar(255) DEFAULT NULL COMMENT '教授科目',
  `area` varchar(255) DEFAULT NULL COMMENT '教授区域',
  `coach_way` int(11) DEFAULT NULL COMMENT '辅导方式（0:教员上门，1：学员上门，2：网上辅导，3：协商）',
  `payment` varchar(255) DEFAULT NULL COMMENT '薪酬要求',
  `teacher_id` int(11) NOT NULL COMMENT '教员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_desire
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_requirement
-- ----------------------------
DROP TABLE IF EXISTS `teacher_requirement`;
CREATE TABLE `teacher_requirement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL COMMENT '学员id',
  `concat` varchar(11) DEFAULT NULL COMMENT '联系人',
  `sex` int(1) DEFAULT '0' COMMENT '联系人性别(0:男,1:女)',
  `age` varchar(30) DEFAULT NULL COMMENT '学员年龄',
  `grade` varchar(30) DEFAULT NULL COMMENT '学员年级',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `area` varchar(50) DEFAULT NULL COMMENT '所在区域',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `subject` varchar(255) DEFAULT NULL COMMENT '辅导科目',
  `student_description` varchar(255) DEFAULT NULL COMMENT '学员状态详细描述',
  `student_level` int(1) DEFAULT NULL COMMENT '学员状态(0:零基础,1:补差型,2:提高型,3:拔尖型)',
  `teaching_time` varchar(255) DEFAULT NULL COMMENT '授课时间',
  `require_count` int(10) DEFAULT NULL COMMENT '需求人数',
  `require_sex` int(1) DEFAULT '2' COMMENT '性别要求(0:男，1：女,2:无要求)',
  `identity` int(1) DEFAULT '3' COMMENT '身份要求（0：在职教员，1：在职教师，2：无）',
  `requirement` varchar(255) DEFAULT NULL COMMENT '资格要求',
  `payment` varchar(30) DEFAULT NULL COMMENT '薪酬要求',
  `teaching_type` varchar(30) DEFAULT NULL COMMENT '辅导方式()',
  `riding_allowance` int(1) DEFAULT '0' COMMENT '乘车补贴（0：无，1：有，2：部分，3：协商）',
  `release_time` datetime DEFAULT NULL,
  `release_status` int(11) DEFAULT '0' COMMENT '发布状态（0：未审核，1：发布中，2：审核不通过，3已关闭)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_requirement
-- ----------------------------
INSERT INTO `teacher_requirement` VALUES ('1', '3', 'hjjhhjk', '0', '1', '幼儿', '1', null, '松山湖', '1', '1', '1', '0', '1', '1', '2', '2', '1', '', '教员上门', '0', '2017-12-06 22:23:42', '3');
INSERT INTO `teacher_requirement` VALUES ('2', '3', '谢友根', '1', '12', '大二', '15913756471', null, '南昌', '', '数学', '', '1', '', '1', '2', '2', '过英语六级', '', '教员上门', '0', '2017-12-06 22:23:45', '0');
INSERT INTO `teacher_requirement` VALUES ('3', '3', '', '1', '', '', '', null, '南城', '', '', '', '0', '', '1', '2', '2', '', '', null, '0', null, '3');
INSERT INTO `teacher_requirement` VALUES ('4', '3', '', '0', '', '', '', null, '大岭山', '', '', '', '0', '', '1', '2', '2', '', '', null, '0', '2017-12-06 22:23:48', '1');
INSERT INTO `teacher_requirement` VALUES ('5', '3', '谢友根', '1', '12', '初二', '15913756471', null, '大朗', '', '初二英语', '', '1', '', '1', '1', '0', '', '', '教员上门', '0', null, '1');
INSERT INTO `teacher_requirement` VALUES ('6', '3', '谢友根', '1', '12', '二年级', '15913756461', null, '寮步', '', '初2英语', '', '0', '', '1', '1', '0', '', '', '教员上门,学员上门', '0', null, '1');
INSERT INTO `teacher_requirement` VALUES ('7', '3', '谢友根', '1', '12', '二年级', '15913756461', null, '东城', '', '初2英语', '', '0', '', '1', '1', '0', '', '', '教员上门,学员上门', '0', null, '1');
INSERT INTO `teacher_requirement` VALUES ('8', '4', '谢友根', '1', '12', '四年级', '15913756471', null, '22', '', '语文', '', '1', '', '1', '2', '2', '', '', null, '0', null, '0');
INSERT INTO `teacher_requirement` VALUES ('9', '5', '谢友根', '1', '12', '四年级', '15913756471', null, '22', '', '语文', '', '1', '', '1', '2', '2', '', '', null, '0', null, '0');
INSERT INTO `teacher_requirement` VALUES ('10', '6', '谢友根', '1', '12', '四年级', '15913756471', null, '22', '', '语文', '', '1', '', '1', '2', '2', '', '', null, '0', null, '0');
INSERT INTO `teacher_requirement` VALUES ('11', '7', '谢友根', '1', '12', '四年级', '15913756471', null, '22', '', '语文', '', '1', '', '1', '2', '2', '', '', null, '0', null, '2');
INSERT INTO `teacher_requirement` VALUES ('12', '6', 'a', '1', '1', '大四', '15913756471', null, '25', '1', '1', '1', '1', '1', '1', '0', '0', '', '', '教员上门', '2', null, '1');
