/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : db_cjpg

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-04-01 12:47:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bg_jbxx
-- ----------------------------
DROP TABLE IF EXISTS `bg_jbxx`;
CREATE TABLE `bg_jbxx` (
  `qh` int(11) NOT NULL COMMENT '囚号',
  `jy` varchar(50) DEFAULT NULL COMMENT '监狱',
  `jq` varchar(50) DEFAULT NULL COMMENT '监区',
  `fjq` varchar(50) DEFAULT NULL COMMENT '分监区',
  `xm` varchar(50) DEFAULT NULL COMMENT '姓名',
  `xb` varchar(50) DEFAULT NULL COMMENT '性别',
  `bm` varchar(50) DEFAULT NULL COMMENT '别名',
  `csrq` datetime DEFAULT NULL COMMENT '出生日期',
  `nl` int(11) DEFAULT NULL COMMENT '年龄',
  `gj` varchar(50) DEFAULT NULL COMMENT '国籍',
  `mz` varchar(50) DEFAULT NULL COMMENT '民族',
  `whcd` varchar(50) DEFAULT NULL COMMENT '文化程度',
  `zzmm` varchar(50) DEFAULT NULL COMMENT '政治面貌',
  PRIMARY KEY (`qh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_jbxx
-- ----------------------------
INSERT INTO `bg_jbxx` VALUES ('1', '广东省监狱', '第一监区', '第一分区', '程科', '男', null, '2000-02-17 19:55:11', '18', '中国', '汉族', '小学', '群众');
INSERT INTO `bg_jbxx` VALUES ('22', '广东省', '第一监区', '第一分区', '黎明', '男', null, '1999-02-01 19:55:36', '19', '中国', '汉族', '初中', '群众');

-- ----------------------------
-- Table structure for bg_xxxx
-- ----------------------------
DROP TABLE IF EXISTS `bg_xxxx`;
CREATE TABLE `bg_xxxx` (
  `qh` int(11) NOT NULL COMMENT '囚号',
  `bqzy` varchar(50) DEFAULT NULL COMMENT '捕前职业',
  `zjlx` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `sg` varchar(50) DEFAULT NULL COMMENT '身高',
  `tz` varchar(50) DEFAULT NULL COMMENT '体重',
  `htzk` varchar(50) DEFAULT NULL COMMENT '婚姻状况',
  `hjdz` varchar(200) DEFAULT NULL COMMENT '户籍地址',
  `jtzz` varchar(200) DEFAULT NULL COMMENT '家庭地址',
  `hygx` varchar(50) DEFAULT NULL,
  `jtzc` varchar(100) DEFAULT NULL COMMENT '家庭支撑',
  `jtbg` varchar(100) DEFAULT NULL COMMENT '家庭变故',
  `wcnfjtzk` varchar(100) DEFAULT NULL COMMENT '未成年犯家庭状况',
  `sfdszn` varchar(5) DEFAULT NULL,
  `zmmc` varchar(100) DEFAULT NULL COMMENT '罪名名称',
  `rjrq` datetime DEFAULT NULL COMMENT '入监日期',
  `fylx` varchar(10) DEFAULT NULL,
  `gtfzlx` varchar(20) DEFAULT NULL COMMENT '共同犯罪参与类型',
  `bdlb` varchar(20) DEFAULT NULL COMMENT '刑罚变动',
  `xq` varchar(6) DEFAULT NULL COMMENT '刑期',
  `aflb` varchar(50) DEFAULT NULL COMMENT '案犯类别',
  `bznx` varchar(6) DEFAULT NULL COMMENT '剥夺政治权利期限',
  `qzcj` varchar(2) DEFAULT NULL COMMENT '是否驱逐出境',
  `xzjx` varchar(2) DEFAULT NULL COMMENT '否限制减刑',
  `fz` int(11) DEFAULT NULL COMMENT '罚金',
  `mscc` varchar(255) DEFAULT NULL COMMENT '没收财产',
  `fzss` varchar(255) DEFAULT NULL COMMENT '犯罪事实',
  `zklb` varchar(20) DEFAULT NULL,
  `zkxz1` varchar(20) DEFAULT NULL COMMENT '重控性质1',
  `zkxz2` varchar(20) DEFAULT NULL COMMENT '重控性质2',
  `rzlb` varchar(20) DEFAULT NULL COMMENT '认罪服判类别',
  `xfcs` int(11) DEFAULT NULL COMMENT '既往刑罚次数',
  `hfgdj` varchar(10) DEFAULT NULL COMMENT '分管等级',
  `sfsw` varchar(2) DEFAULT NULL COMMENT '是否“三无”罪犯',
  `sfsj` varchar(2) DEFAULT NULL COMMENT '是否三假罪犯 ',
  `ynsalb` varchar(10) DEFAULT NULL COMMENT '狱内案件立案案件类别',
  `ldnl` varchar(25) DEFAULT NULL COMMENT '劳动能力',
  `jblb` varchar(25) DEFAULT NULL COMMENT '疾病类别',
  `tafqx` varchar(100) DEFAULT NULL,
  `zmfl` varchar(50) DEFAULT NULL COMMENT '罪名分类',
  PRIMARY KEY (`qh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bg_xxxx
-- ----------------------------
INSERT INTO `bg_xxxx` VALUES ('1', '工人', '身份证', '166', '56', '未婚', '广东省所得到的', '广东省啥的', null, null, null, null, '否', null, '2017-02-08 19:58:09', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `bg_xxxx` VALUES ('22', '学生', '身份证', '172', '57', '未婚', '广东省当时当时多所', '广东省广州市', null, null, null, null, '否', null, '2017-08-14 19:58:41', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for grole_permiss
-- ----------------------------
DROP TABLE IF EXISTS `grole_permiss`;
CREATE TABLE `grole_permiss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `jh` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grole_permiss
-- ----------------------------
INSERT INTO `grole_permiss` VALUES ('1', '1', '1', '1234567');
INSERT INTO `grole_permiss` VALUES ('2', '2', '1', '2345678');

-- ----------------------------
-- Table structure for groupman
-- ----------------------------
DROP TABLE IF EXISTS `groupman`;
CREATE TABLE `groupman` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职务号',
  `gmname` varchar(50) DEFAULT NULL COMMENT '职务名称',
  `states` int(11) DEFAULT NULL COMMENT '状态，1、0',
  `zrid` int(11) DEFAULT NULL COMMENT '角色号，关联角色表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groupman
-- ----------------------------
INSERT INTO `groupman` VALUES ('1', '正监狱长', '1', '40000');
INSERT INTO `groupman` VALUES ('2', '副监狱长', '1', '40000');
INSERT INTO `groupman` VALUES ('3', '正处长', '1', '30000');
INSERT INTO `groupman` VALUES ('4', '副处长', '1', '30000');
INSERT INTO `groupman` VALUES ('5', '警员', '1', '10000');

-- ----------------------------
-- Table structure for jyxx
-- ----------------------------
DROP TABLE IF EXISTS `jyxx`;
CREATE TABLE `jyxx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jh` varchar(50) DEFAULT NULL COMMENT '警员账号',
  `ma` varchar(50) DEFAULT NULL COMMENT '密码',
  `xm` varchar(50) DEFAULT NULL COMMENT '姓名',
  `zw` int(11) DEFAULT NULL COMMENT '职务，关联职务表groupMan的id',
  `cjsj` datetime DEFAULT NULL COMMENT '创建时间',
  `scdlsj` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态，1、0',
  `jq` varchar(50) DEFAULT NULL COMMENT '监区',
  `xjq` varchar(50) DEFAULT NULL COMMENT '分监区',
  `xb` varchar(50) DEFAULT NULL COMMENT '性别',
  `sr` varchar(50) DEFAULT NULL COMMENT '生日',
  `bmh` varchar(50) DEFAULT NULL COMMENT '部门',
  `dz` varchar(50) DEFAULT NULL COMMENT '地址',
  `dh` varchar(50) DEFAULT NULL COMMENT '电话',
  `dzyj` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `bz` varchar(50) DEFAULT NULL COMMENT '备注',
  `zt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jyxx
-- ----------------------------
INSERT INTO `jyxx` VALUES ('1', '1234567', '123abc', '李晓明', '1', '2017-03-04 00:00:00', '2018-03-01 00:00:00', '1', '第一监区', '第二分区', '男', '1986-03-02 00:00:00.000', '人事部', '广东省广州市', '15656567878', '1276876@qq.com', null, null);
INSERT INTO `jyxx` VALUES ('2', '2345678', '123abc', '李丹', '2', '2017-03-05 00:00:00', '2018-03-06 00:00:00', '1', '第二监区', '第一分区', '女', '1988-03-02 00:00:00.000', '劳改部', '广东省广州市', '17856788765', '9976876@qq.com', null, null);

-- ----------------------------
-- Table structure for lb_bz
-- ----------------------------
DROP TABLE IF EXISTS `lb_bz`;
CREATE TABLE `lb_bz` (
  `pzid` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置id',
  `cjlbid` int(11) DEFAULT NULL COMMENT '出监量表id',
  `qysj` datetime DEFAULT NULL COMMENT '启用时间',
  `qyr` varchar(50) DEFAULT NULL COMMENT '启用人',
  `zt` varchar(50) DEFAULT NULL COMMENT '状态(0未启用，1已启用 注（只有一个启用状态）)',
  PRIMARY KEY (`pzid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lb_bz
-- ----------------------------

-- ----------------------------
-- Table structure for lb_cj
-- ----------------------------
DROP TABLE IF EXISTS `lb_cj`;
CREATE TABLE `lb_cj` (
  `cjlbbh` int(11) NOT NULL AUTO_INCREMENT COMMENT '出监量表编号',
  `fl` varchar(50) DEFAULT NULL COMMENT '分类',
  `wd` int(11) DEFAULT NULL COMMENT '维度编号，关联维度表',
  `yzbm` int(11) DEFAULT NULL COMMENT '因子编码',
  `yz` varchar(50) DEFAULT NULL COMMENT '因子',
  `fs` int(11) DEFAULT NULL COMMENT '分数',
  `qz` int(11) DEFAULT NULL COMMENT '权重',
  PRIMARY KEY (`cjlbbh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lb_cj
-- ----------------------------

-- ----------------------------
-- Table structure for lb_km
-- ----------------------------
DROP TABLE IF EXISTS `lb_km`;
CREATE TABLE `lb_km` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lbbh` int(11) DEFAULT NULL COMMENT '量表编号,可查找出监量表编号',
  `xindu` varchar(50) DEFAULT NULL COMMENT '信度',
  `xiaodu` varchar(50) DEFAULT NULL COMMENT '效度',
  `yzz` varchar(50) DEFAULT NULL COMMENT '研制者',
  `sj` datetime DEFAULT NULL COMMENT '时间',
  `jy` varchar(50) DEFAULT NULL COMMENT '监狱',
  `sm` varchar(50) DEFAULT NULL COMMENT '说明',
  `bz` varchar(50) DEFAULT NULL COMMENT '备注',
  `zt` varchar(50) DEFAULT NULL COMMENT '状态',
  `jd` int(11) DEFAULT NULL COMMENT '阶段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lb_km
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zpname` varchar(50) DEFAULT NULL,
  `states` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'create', '1');

-- ----------------------------
-- Table structure for sysadmin
-- ----------------------------
DROP TABLE IF EXISTS `sysadmin`;
CREATE TABLE `sysadmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `gmid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysadmin
-- ----------------------------
INSERT INTO `sysadmin` VALUES ('1', 'admin', '123abc', '1', '2');
INSERT INTO `sysadmin` VALUES ('2', 'firstfirst', '123abc', '5', '1');
INSERT INTO `sysadmin` VALUES ('3', 'twotwo', '123abc', '5', '1');
INSERT INTO `sysadmin` VALUES ('4', 'threethree', '123abc', '5', '1');
INSERT INTO `sysadmin` VALUES ('5', 'fourfour', '123abc', '5', '1');
INSERT INTO `sysadmin` VALUES ('6', 'fourst', '123abc', '5', '1');

-- ----------------------------
-- Table structure for t_crim_scale_relat
-- ----------------------------
DROP TABLE IF EXISTS `t_crim_scale_relat`;
CREATE TABLE `t_crim_scale_relat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crim_no` int(11) DEFAULT NULL COMMENT '囚号',
  `sconf_id` int(11) DEFAULT NULL COMMENT '配置编号',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `cr_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modif` varchar(255) DEFAULT NULL COMMENT '最后修改时间',
  `modifier` varchar(255) DEFAULT NULL COMMENT '最后修改人',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_crim_scale_relat
-- ----------------------------

-- ----------------------------
-- Table structure for t_dim
-- ----------------------------
DROP TABLE IF EXISTS `t_dim`;
CREATE TABLE `t_dim` (
  `dim_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维度id',
  `dim_name` varchar(50) DEFAULT NULL COMMENT '创建者',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `cr_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '描述',
  `last_modif` datetime DEFAULT NULL COMMENT '最后修改时间',
  `modifier` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `status` int(11) DEFAULT NULL COMMENT '状态（1未启用 ，2启用）',
  PRIMARY KEY (`dim_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dim
-- ----------------------------
INSERT INTO `t_dim` VALUES ('1', '维度1', '李小龙', '2018-01-02 17:34:51', '维度A', '2018-01-17 17:34:41', '李小龙', '2');

-- ----------------------------
-- Table structure for t_dim_factor_relat
-- ----------------------------
DROP TABLE IF EXISTS `t_dim_factor_relat`;
CREATE TABLE `t_dim_factor_relat` (
  `id` int(11) NOT NULL,
  `dim_id` int(11) DEFAULT NULL COMMENT '维度id',
  `f_id` int(11) DEFAULT NULL COMMENT '因子id',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `cr_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modif` datetime DEFAULT NULL COMMENT '最后修改时间',
  `modifier` varchar(255) DEFAULT NULL COMMENT '最后修改人',
  `status` int(11) DEFAULT NULL COMMENT '状态 1表示未启用  2表示启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dim_factor_relat
-- ----------------------------
INSERT INTO `t_dim_factor_relat` VALUES ('1', '1', '1', '李晓明', '2018-03-21 17:48:32', '2018-03-06 17:47:35', '李晓明', '2');

-- ----------------------------
-- Table structure for t_factor
-- ----------------------------
DROP TABLE IF EXISTS `t_factor`;
CREATE TABLE `t_factor` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '因子ID',
  `name` varchar(50) DEFAULT NULL COMMENT '因子名称',
  `f_score` int(11) DEFAULT NULL COMMENT '因子分数',
  `remark` varchar(50) DEFAULT NULL COMMENT '描述',
  `cr_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `last_modif` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `modifier` varchar(50) DEFAULT NULL COMMENT '最后修改者',
  `status` int(255) DEFAULT NULL COMMENT '状态（1未启用，2启用）',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_factor
-- ----------------------------
INSERT INTO `t_factor` VALUES ('1', '因子1', '60', '因子A', '2018-01-02 17:42:14', '李晓红', '2018-01-15 17:42:26', '李晓红', '2');

-- ----------------------------
-- Table structure for t_jczjdx
-- ----------------------------
DROP TABLE IF EXISTS `t_jczjdx`;
CREATE TABLE `t_jczjdx` (
  `qh` int(11) NOT NULL COMMENT '囚号',
  `xm` varchar(50) DEFAULT NULL COMMENT '罪犯姓名',
  `jq` varchar(50) DEFAULT NULL COMMENT '监区',
  `jh` int(11) DEFAULT NULL,
  `jhxm` varchar(50) DEFAULT NULL,
  `xjbh` int(11) DEFAULT NULL,
  `xjxm` varchar(50) DEFAULT NULL COMMENT '协警姓名',
  `status` int(11) DEFAULT NULL COMMENT '导入插入或更新操作标识',
  PRIMARY KEY (`qh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jczjdx
-- ----------------------------
INSERT INTO `t_jczjdx` VALUES ('1', '程科', '第一监区', '1234567', '李晓明', '1234567', '李晓明', '1');
INSERT INTO `t_jczjdx` VALUES ('22', '黎明', '第一监区', '1234567', '李晓明', '1234567', '李晓明', '1');

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `qst_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题编号，主键，自增',
  `dim_id` int(11) DEFAULT NULL COMMENT '维度表  关联编号',
  `org_id` varchar(50) DEFAULT NULL COMMENT '组织编号  标识监狱',
  `question` varchar(255) DEFAULT NULL COMMENT '问题',
  `type` int(11) DEFAULT NULL COMMENT '问题类型  1：单选，2：多选',
  `remark` varchar(50) DEFAULT NULL COMMENT '描述，判断依据',
  `options` varchar(255) DEFAULT NULL COMMENT '选项   有格式字符串，如：选项号,选项内容,关联因子ID,关联因子名称;...',
  `answer` varchar(255) DEFAULT NULL COMMENT '答案 可空，格式：选项号,选项号,...',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `cr_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modif` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `modifier` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `status` int(11) DEFAULT NULL COMMENT '-1未发布，1未启用，2已启用，10已弃用',
  PRIMARY KEY (`qst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question
-- ----------------------------

-- ----------------------------
-- Table structure for t_scale
-- ----------------------------
DROP TABLE IF EXISTS `t_scale`;
CREATE TABLE `t_scale` (
  `scale_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '量表编号',
  `name` varchar(50) DEFAULT NULL COMMENT '量表名称',
  `type` varchar(255) DEFAULT NULL COMMENT '量表种型  如A 访谈量表  B行为观察量表 ',
  `remark` varchar(255) DEFAULT NULL COMMENT '量表说明',
  `researher` varchar(255) DEFAULT NULL COMMENT '研制者',
  `creator` varchar(255) DEFAULT NULL COMMENT '创建人',
  `cr_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modif` datetime DEFAULT NULL COMMENT '最后修改时间',
  `modifier` varchar(255) DEFAULT NULL COMMENT '最后修改人',
  `status` varchar(255) DEFAULT NULL COMMENT '状态 启用状态，-1未发布，1未启用，2已启用，10已弃用',
  `scale` varchar(100) DEFAULT NULL COMMENT '量表json字符串',
  PRIMARY KEY (`scale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_scale
-- ----------------------------
INSERT INTO `t_scale` VALUES ('1', '量表1', 'DA', '量表DA', '李明杰', '李明杰', '2018-02-01 18:06:50', '2018-02-01 18:06:50', '李明杰', '2', null);

-- ----------------------------
-- Table structure for t_scale_conf
-- ----------------------------
DROP TABLE IF EXISTS `t_scale_conf`;
CREATE TABLE `t_scale_conf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '量表名称',
  `conf` varchar(50) DEFAULT NULL COMMENT '配置内容',
  `remark` varchar(50) DEFAULT NULL COMMENT '描述',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `cr_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modif` varchar(255) DEFAULT NULL COMMENT '最后修改时间',
  `modifier` varchar(255) DEFAULT NULL COMMENT '最后修改人',
  `status` int(11) DEFAULT NULL COMMENT '状态  启用状态，1未启用，2已启用,3已弃用	',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_scale_conf
-- ----------------------------

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL COMMENT '任务id',
  `crim_no` int(11) DEFAULT NULL COMMENT '囚号',
  `type` varchar(50) DEFAULT NULL COMMENT '任务类型',
  `name` varchar(50) DEFAULT NULL COMMENT '类型的名称',
  `basis` varchar(50) DEFAULT NULL COMMENT '任务依据',
  `describ` varchar(50) DEFAULT NULL COMMENT '任务描述(做什么)',
  `deadline` datetime DEFAULT NULL COMMENT '任务完成期限yyyy-MM-dd HH:mm:ss',
  `cop1_no` int(11) DEFAULT NULL COMMENT '专教警号',
  `cop2_no` int(11) DEFAULT NULL COMMENT '协教警号',
  `creator` varchar(50) DEFAULT NULL COMMENT '任务创建/发布人',
  `cr_time` datetime DEFAULT NULL COMMENT '任务发布时间yyyy-MM-dd HH:mm:ss',
  `last_modif` datetime DEFAULT NULL COMMENT 'modification最后修改时间',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人/任务执行人',
  `score` int(11) DEFAULT NULL COMMENT '做题完的成绩',
  `levl` varchar(50) DEFAULT NULL COMMENT '做题完评估危险',
  `status` int(11) NOT NULL COMMENT '-状态：-1未发布，1未开始，2处理中，3未完成/暂存，4已完成(不能再编辑)，10已取消',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '1', '1', 'otTk', '访谈', '访谈', '访谈', '2018-03-25 16:29:18', '1234567', '1234567', '李晓明', '2018-03-25 16:29:18', '2018-03-25 16:29:18', '李晓明', '79', '中等', '4');
INSERT INTO `t_task` VALUES ('2', '2', '1', 'otAct', '行为', '行为', '行为', '2018-04-05 19:38:36', '1234567', '1234567', '李晓明', '2018-02-21 19:39:09', '2018-03-18 19:39:14', '李晓明', '76', '中等', '4');
INSERT INTO `t_task` VALUES ('3', '1', '22', 'otTk', '访谈22', '访谈22', '访谈22', '2018-04-05 20:02:16', '1234567', '1234567', '李晓明', '2018-02-20 20:02:37', '2018-03-08 20:02:43', '李晓明', null, null, '1');
INSERT INTO `t_task` VALUES ('4', '2', '22', 'otAct', '行为22', '行为22', '行为22', '2018-04-11 15:00:33', '1234567', '1234567', '李晓明', '2018-02-26 15:00:52', '2018-03-18 15:00:58', '李晓明', null, null, '1');

-- ----------------------------
-- Table structure for t_tjzfz
-- ----------------------------
DROP TABLE IF EXISTS `t_tjzfz`;
CREATE TABLE `t_tjzfz` (
  `id` int(11) NOT NULL,
  `jq` varchar(50) DEFAULT NULL COMMENT '监区',
  `jg` int(11) DEFAULT NULL COMMENT '极高',
  `gd` int(11) DEFAULT NULL COMMENT '高等',
  `zd` int(11) DEFAULT NULL COMMENT '中等',
  `dd` int(11) DEFAULT NULL COMMENT '低等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tjzfz
-- ----------------------------
INSERT INTO `t_tjzfz` VALUES ('1', '一监区', '3', '4', '9', '30');
INSERT INTO `t_tjzfz` VALUES ('2', '二监区', '4', '2', '23', '13');
INSERT INTO `t_tjzfz` VALUES ('3', '三监区', '5', '3', '23', '13');

-- ----------------------------
-- Table structure for t_zyrymd
-- ----------------------------
DROP TABLE IF EXISTS `t_zyrymd`;
CREATE TABLE `t_zyrymd` (
  `qh` int(11) NOT NULL COMMENT '囚号',
  `xm` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sj` datetime DEFAULT NULL COMMENT '入监时间',
  `gyjq` varchar(50) DEFAULT NULL COMMENT '关押监区',
  `gyjy` varchar(50) DEFAULT NULL COMMENT '关押监狱',
  `ftzt` varchar(50) DEFAULT NULL COMMENT '访谈状态',
  `xwzt` varchar(50) DEFAULT NULL,
  `xlzt` varchar(50) DEFAULT NULL,
  `jd` char(50) DEFAULT NULL COMMENT '阶段，4为出监',
  PRIMARY KEY (`qh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zyrymd
-- ----------------------------
INSERT INTO `t_zyrymd` VALUES ('1', '程科', '2017-02-08 19:58:09', '第一监区', '广东省监狱', '4', '4', '4', '4');
INSERT INTO `t_zyrymd` VALUES ('22', '黎明', '2017-08-14 19:58:41', '第一监区', '广东省监狱', '1', '1', '1', '4');

-- ----------------------------
-- Table structure for wd
-- ----------------------------
DROP TABLE IF EXISTS `wd`;
CREATE TABLE `wd` (
  `wdbm` int(11) NOT NULL AUTO_INCREMENT COMMENT '维度编码',
  `wd` varchar(50) DEFAULT NULL,
  `xz` int(11) DEFAULT NULL COMMENT '选择',
  PRIMARY KEY (`wdbm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wd
-- ----------------------------

-- ----------------------------
-- Table structure for zrole
-- ----------------------------
DROP TABLE IF EXISTS `zrole`;
CREATE TABLE `zrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zrname` varchar(50) DEFAULT NULL,
  `states` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zrole
-- ----------------------------
INSERT INTO `zrole` VALUES ('10000', 'customers', '1');
INSERT INTO `zrole` VALUES ('30000', 'admin', '1');
INSERT INTO `zrole` VALUES ('40000', 'superadmin', '1');
