/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : ttms

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-08-18 19:24:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
/*
    private int userId;
    private String password;//密码：6-12位
    private String account;//账号：6位以上，//手机号 唯一 外键
    private int user_status;//1：病人，2：医生。0：管理员
    private String headPath;//头像路径
*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL DEFAULT '123456' COMMENT '密码',
  `user_status` int(1) NOT NULL DEFAULT '1' COMMENT '用户类型：1：病人，2：医生。0：管理员',
  `head_path` varchar(500) DEFAULT NULL COMMENT '头像路径',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登陆信息表';
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18829071821', '123456', '1','111111');
INSERT INTO `user` VALUES ('2', '17868814537', '123456', '2','222222');
INSERT INTO `user` VALUES ('3', '13542533427', '123456', '0','333333');
INSERT INTO `user` VALUES ('4', '18829071822', '123456', '2','一一一一一一');
INSERT INTO `user` VALUES ('5', '18829071823', '123456', '2','一一一一一一');
INSERT INTO `user` VALUES ('6', '18829071824', '123456', '2','一一一一一一');
INSERT INTO `user` VALUES ('7', '18829071825', '123456', '2','一一一一一一');
INSERT INTO `user` VALUES ('8', '18829071826', '123456', '2','一一一一一一');
INSERT INTO `user` VALUES ('9', '18829071827', '123456', '2','一一一一一一');
INSERT INTO `user` VALUES ('10', '18829071828', '123456', '2','一一一一一一');


/*
    private int sectionId;
    private String sectionName;
    private String sectionIntroduction;
*/
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `section_id` int(11) NOT NULL AUTO_INCREMENT,
  `section_name` varchar(20) NOT NULL ,
  `section_introduction` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='科室门诊';

-- ----------------------------
-- Records of section
-- ----------------------------
INSERT INTO `section` VALUES ('1', '心脏内科门诊', '略');
INSERT INTO `section` VALUES ('2', '肾脏内科门诊', '略');
INSERT INTO `section` VALUES ('3', '血液内科门诊', '略');
INSERT INTO `section` VALUES ('4', '内分泌内科门诊', '略');
INSERT INTO `section` VALUES ('5', '消化内科门诊', '略');
INSERT INTO `section` VALUES ('6', '消化外科门诊', '略');
INSERT INTO `section` VALUES ('7', '呼吸内科门诊', '略');
INSERT INTO `section` VALUES ('8', '老年病科门诊', '略');
INSERT INTO `section` VALUES ('9', '感染性疾病门诊', '略');
INSERT INTO `section` VALUES ('10', '肝胆胰脾外科门诊', '略');
INSERT INTO `section` VALUES ('11', '甲乳血管外科门诊', '略');
INSERT INTO `section` VALUES ('12', '骨科医院门诊', '略');
INSERT INTO `section` VALUES ('13', '泌尿外科门诊', '略');
INSERT INTO `section` VALUES ('14', '心血管外科门诊', '略');
INSERT INTO `section` VALUES ('15', '整形外科门诊', '略');
INSERT INTO `section` VALUES ('16', '烧伤与皮肤外科门诊', '略');
INSERT INTO `section` VALUES ('17', '神经外科门诊', '略');
INSERT INTO `section` VALUES ('18', '泌尿耳鼻咽喉头颈外科门诊', '略');
INSERT INTO `section` VALUES ('19', '眼科门诊', '略');
INSERT INTO `section` VALUES ('20', '皮肤科门诊', '略');
INSERT INTO `section` VALUES ('21', '儿科门诊', '略');
INSERT INTO `section` VALUES ('22', '妇产科门诊', '略');
INSERT INTO `section` VALUES ('23', '妇产科生殖中心', '略');
INSERT INTO `section` VALUES ('24', '中医科门诊', '略');
INSERT INTO `section` VALUES ('25', '肿瘤科门诊', '略');
INSERT INTO `section` VALUES ('26', '临床免疫科门诊', '略');
INSERT INTO `section` VALUES ('27', '理疗科门诊', '略');
INSERT INTO `section` VALUES ('28', '神经内科门诊', '略');
INSERT INTO `section` VALUES ('29', '心身科门诊', '略');
INSERT INTO `section` VALUES ('30', '麻醉科疼痛门诊', '略');
INSERT INTO `section` VALUES ('31', '介入诊疗门诊', '略');
INSERT INTO `section` VALUES ('32', '超声医学科', '略');
INSERT INTO `section` VALUES ('33', '核医学科门诊', '略');
INSERT INTO `section` VALUES ('34', '门诊部胸外科门诊', '略');
INSERT INTO `section` VALUES ('35', '放射治疗科门诊', '略');


-- ----------------------------
-- Table structure for patient
-- ----------------------------
/*  private int patientId;
    private String account;//账号,6位以上,外键，手机作为账号
    private String name;//名字
    private int sex;//1->男或0->女
    private int age;//年龄,大于等于0，以年为单位
    private String idNumber;//身份证号码
    private String phone;//电话
    private String address;//地址
*/
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `id_number` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='病人表';

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('1','18829071821', '小星', '1',
'18', '445381199901012544','18829071821','无');


-- Table structure for doctor
-- ----------------------------
/*
    private int doctorId;
    private String account;//账号,6位以上,外键，手机作为账号
    private String name;//名字
    private int sex;//1->男或0->女
    private int age;//年龄,大于等于0，以年为单位
    private String idNumber;//身份证号码
    private String phone;//电话
    private String address;//地址
    private String introduction;//医生简介
    private String forte;//特长
    private int sectionId;//属于哪个科室
*/

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `account` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `introduction` varchar(100) DEFAULT NULL,
  `forte` varchar(30) DEFAULT NULL,
  `id_number` varchar(20) NOT NULL,
  `section_id` int(11) NOT NULL,
  `honour` varchar(10) DEFAULT NULL,
   PRIMARY KEY (`doctor_id`),
   UNIQUE KEY `account` (`account`),
   KEY `doctor_section` (`section_id`),
   CONSTRAINT `doctor_section` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='医生表';

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '凯莉', '1', '18', '17868814537',
'17868814537','wu ','wu',  '445381199808092533', '1','教授');
INSERT INTO `doctor` VALUES ('2', '左而', '1', '18', '18829071822',
'18829071822','wu ','wu',  '445381199808102533', '1','副教授');
INSERT INTO `doctor` VALUES ('3', '小明', '1', '18', '18829071823',
'18829071823','wu ','wu',  '445381199808102433', '1','主任医师');
INSERT INTO `doctor` VALUES ('4', '小李', '1', '18', '18829071824',
'18829071824','wu ','wu',  '445381199808102633', '2','副主任医师');
INSERT INTO `doctor` VALUES ('5', '小红', '1', '18', '18829071825',
'18829071825','wu ','wu',  '445381199808102733', '3','教授');
INSERT INTO `doctor` VALUES ('6', '小广', '1', '18', '18829071826',
'18829071825','wu ','wu',  '445381199808102733', '3','教授');
INSERT INTO `doctor` VALUES ('7', '小华', '1', '18', '18829071827',
'18829071825','wu ','wu',  '445381199808102733', '3','教授');
INSERT INTO `doctor` VALUES ('8', '小迪', '1', '18', '18829071828',
'18829071825','wu ','wu',  '445381199808102733', '3','教授');



/*
    private int adminId;
    private String account;//账号,6位以上,外键，手机作为账号
    private String name;//名字
    private int sex;//1->男或0->女
    private int age;//年龄,大于等于0，以年为单位
    private String idNumber;//身份证号码
    private String phone;//电话
    private String address;//地址
 */
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `id_number` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '13542533427', '左左', '1','18',
'445381199610292533','13542533427','wu');





-- ----------------------------
-- Table structure for patient_record
-- ----------------------------
/*
    private int patientRecordId;
    private int patientId;
    private int doctorId;
    private Date admissionTime;//入院时间
    private String chief;//主诉
    private String nowHistory;//现病史
    private String pastHistory;//过去病史
    private String personalHistory;//个人史
    private String familyHistory;//家族病史
    private String physicalExamination;//体格检查
    private String therapeuticExamination;//辅助检查
    private String diagnosis;//初步/最后诊断
*/
DROP TABLE IF EXISTS `patient_record`;
CREATE TABLE `patient_record` (
  `patient_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `admission_time` datetime  NOT NULL,
  `chief` varchar(20),
  `now_history` varchar(20),
  `past_history` varchar(20),
  `personal_history` varchar(20),
  `family_history` varchar(20),
  `physical_examination` varchar(20),
  `therapeutic_examination` varchar(20),
  `diagnosis` varchar(20),
  PRIMARY KEY (`patient_record_id`),
  KEY `FK_patient` (`patient_id`),
  KEY `FK_doctor` (`doctor_id`),
  CONSTRAINT `FK_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='病历';

-- ----------------------------
-- Records of patient_record
-- ----------------------------
INSERT INTO `patient_record` VALUES ('1', '1', '1', '2017-08-11 08:00:00'
,'主诉','现病史','过去病史','个人史','家族史','体格检查','辅助检查','最后诊断');


-- ----------------------------
-- Table structure for book
-- ----------------------------
/*
    private int bookId;
    private int doctorId;
    private int patientId;
    private Date bookTime;//预约时间
    private boolean isAvaliablity;//是否生效
    private boolean isCancle;//是否取消
*/
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `book_time` datetime NOT NULL,
  `is_avaliablity` boolean default true NOT NULL,
  `is_cancle` boolean default false NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `FK_schedule_id` (`schedule_id`),
  KEY `FK_patient_id` (`patient_id`),
  CONSTRAINT `FK_schedule_id` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='预约表';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '1', '1', '2020-08-11 08:00:00', '1','0');

/*
1.预约挂号需要在2小时内支付费用，请于就诊前半小时至各楼层自助机上进行报到取号等候就诊
2.同一用户同一天只能预约两个专家号，同一科室限约一个
3.取消预约：请于就诊前一天取消预约，就诊当日需到窗口进行退费操作
4.医生停诊：预约号自动消失，不做顺延，会及时推送消息给患者
5.黑名单：若未能按约定前来取号，号源作废，费用不予退还，违约两次，则计入黑名单半年内无法预约
6.法定节假日期间，预约挂号暂停，以当日出诊医生为准
7.每日夜间23:00至次日凌晨1:30系统维护期间不可进行预约挂号
	医生值班安排表
	由管理员操作
	//默认一上午或下午40个号
	只能预约未来一周的号
	一个schedule就是半天的班，早上开始的上班时间为上午
	下午开始的上班时间为下午班
*/

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) NOT NULL,
  `w` int(1) default 1 NOT NULL,
  `remainder` int(3) default 40 NOT NULL,
  `work_time_start` date NOT NULL,
  `is_cancle` boolean default false NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `FK_doctor_id` (`doctor_id`),
  CONSTRAINT `FK_doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='排班表';

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '1','1', '40', '2029-03-05','0');
INSERT INTO `schedule` VALUES ('2', '1','2', '40', '2029-03-07','0');
INSERT INTO `schedule` VALUES ('3', '1','1', '40', '2029-03-08','0');
INSERT INTO `schedule` VALUES ('4', '2','1', '40', '2029-03-09','0');





