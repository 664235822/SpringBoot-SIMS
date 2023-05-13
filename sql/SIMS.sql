-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: SIMS
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adminmenu`
--

DROP TABLE IF EXISTS `adminmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adminmenu` (
  `menuid` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COMMENT='管理员菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminmenu`
--

LOCK TABLES `adminmenu` WRITE;
/*!40000 ALTER TABLE `adminmenu` DISABLE KEYS */;
INSERT INTO `adminmenu` VALUES (1),(2),(3),(4),(5),(6),(7),(9),(10),(14),(15),(17),(18),(23),(27),(28),(29),(34),(35),(39),(40),(41),(42),(43),(44),(45);
/*!40000 ALTER TABLE `adminmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sId` int DEFAULT NULL COMMENT '学生id',
  `AttendanceType` int DEFAULT NULL COMMENT '考勤类型',
  `AttendanceTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '考勤时间',
  `subId` int DEFAULT NULL COMMENT '科目id',
  `classId` int DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='考勤表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendancetype`
--

DROP TABLE IF EXISTS `attendancetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendancetype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `AttendanceType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='考勤类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendancetype`
--

LOCK TABLES `attendancetype` WRITE;
/*!40000 ALTER TABLE `attendancetype` DISABLE KEYS */;
INSERT INTO `attendancetype` VALUES (1,'签到'),(2,'迟到'),(3,'缺勤'),(4,NULL);
/*!40000 ALTER TABLE `attendancetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `character`
--

DROP TABLE IF EXISTS `character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `character` (
  `stateId` int NOT NULL AUTO_INCREMENT,
  `info` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stateId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `character`
--

LOCK TABLES `character` WRITE;
/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` VALUES (1,'管理员'),(2,'教师'),(3,'学生');
/*!40000 ALTER TABLE `character` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `classCode` varchar(45) DEFAULT NULL COMMENT '班级编号',
  `className` varchar(45) DEFAULT NULL COMMENT '班级名称',
  `createMessage` varchar(45) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gradeId` int DEFAULT NULL COMMENT '年级ID(关联年级表)',
  `cid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `classCode_UNIQUE` (`classCode`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'100001','1801班','admin','2023-05-08 20:20:50',1,1,1),(2,'100002','1802班','admin','2023-05-08 20:21:17',1,1,1),(3,'100201','2001班','admin','2023-05-09 22:06:45',3,2,4);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `college` (
  `cid` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '学院名称',
  `cstatus` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '状态 1启用 0停用',
  `cremark` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (1,'人工智能与大数据学院','1','理工类'),(2,'化学与分子工程学院','1','理工类');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gradeCode` int DEFAULT NULL COMMENT '年级编号',
  `gradeName` varchar(45) DEFAULT NULL COMMENT '年级名称',
  `createMessage` varchar(45) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='年级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,1000,'2018级','admin','2023-05-08 20:19:26',1,1),(2,1001,'2019级','admin','2023-05-08 20:19:38',1,1),(3,1002,'2020级','admin','2023-05-09 22:04:26',1,1),(4,1003,'2021级','admin','2023-05-09 22:18:37',1,2);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habit`
--

DROP TABLE IF EXISTS `habit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `col1` int DEFAULT NULL,
  `col2` int DEFAULT NULL,
  `col3` int DEFAULT NULL,
  `col4` int DEFAULT NULL,
  `col5` int DEFAULT NULL,
  `col6` int DEFAULT NULL,
  `col7` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habit`
--

LOCK TABLES `habit` WRITE;
/*!40000 ALTER TABLE `habit` DISABLE KEYS */;
INSERT INTO `habit` VALUES (1,'admin',9,17,14,28,0,0,0);
/*!40000 ALTER TABLE `habit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL COMMENT '登录帐号(内置管理员帐号：admin、root)',
  `pwd` varchar(255) DEFAULT NULL COMMENT '登录密码(内置管理员密码：123456)',
  `stateId` int DEFAULT NULL COMMENT '角色(关联角色表)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COMMENT='登陆';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (2,'admin','123456',1),(3,'t487726','123456z',2),(4,'t488736','123456c',2),(5,'t489549','123456z',2),(6,'S2023683549058','123456',3),(7,'S2023683549143','123456',3),(10,'S2023683549262','123456',3),(12,'S2023683549355','123456',3),(13,'S2023683549402','123456',3),(15,'t408865','123456w',2),(16,'S2023683641445','123456',3),(17,'S2023683641515','123456',3),(18,'S2023683641570','123456',3),(19,'S2023683641612','123456',3),(20,'S2023683641699','123456',3),(21,'t421853','123456z',2),(22,'t422590','123456t',2),(23,'t935452','123456h',2);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `mid` int NOT NULL AUTO_INCREMENT COMMENT '专业主键',
  `mname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '专业名称',
  `mstatus` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '状态 1启用 0停用',
  `mremark` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '备注',
  `cid` int DEFAULT NULL COMMENT '院系id 父级关系',
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'软件工程','1','语言编程类',1),(2,'数字媒体','1','媒体类',1),(3,'材料化学','0','理工类',2),(4,'生物与医药','1','理工类',2),(5,'工业催化','1','理工类',2);
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menuId` int NOT NULL AUTO_INCREMENT,
  `menuName` varchar(45) DEFAULT NULL,
  `Parent` int DEFAULT NULL COMMENT '父级',
  `url` varchar(45) DEFAULT NULL COMMENT '地址指向',
  `icon` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'教师管理',0,NULL,NULL),(2,'权限管理',0,NULL,''),(3,'年级管理',0,NULL,''),(4,'班级管理',0,NULL,''),(5,'科目管理',0,NULL,''),(6,'学生管理',0,NULL,''),(7,'成绩管理',0,NULL,''),(8,'考勤管理',0,NULL,''),(9,'管理教师',1,'ShowTeachers.jsp','layui-icon-username'),(10,'添加教师用户',1,'AddTeacher.jsp','layui-icon-add-circle'),(14,'更改权限',2,'SetState.jsp','layui-icon-auz'),(15,'添加年级',3,'AddGrade.jsp','layui-icon-add-circle'),(17,'班级管理',4,'ShowClass.jsp','layui-icon-group'),(18,'添加班级信息',4,'AddClass.jsp','layui-icon-add-circle'),(23,'科目管理',5,'AddSubject.jsp','layui-icon-list'),(27,'查看科任老师信息',5,'ShowSubTeachers.jsp','layui-icon-search'),(28,'管理学生',6,'ShowStudents.jsp','layui-icon-friends'),(29,'添加学生',6,'AddStudent.jsp','layui-icon-add-circle'),(34,'查看成绩',7,'ShowResult.jsp','layui-icon-search'),(35,'录入成绩',7,'AddResult.jsp','layui-icon-edit'),(36,'考勤管理',8,'ManageAttendance.jsp','layui-icon-survey'),(37,'查看考勤',8,'ShowAttendance.jsp','layui-icon-log'),(38,'添加考勤',8,'AddAttendance.jsp','layui-icon-add-circle'),(39,'学院管理',0,NULL,NULL),(40,'专业管理',0,NULL,NULL),(41,'管理学院',39,'ManageCollege.jsp',NULL),(42,'管理专业',40,'ManageMajor.jsp',NULL),(43,'修改成绩审核',7,'CheckResult.jsp',NULL),(44,'添加学院',39,'AddCollege.jsp',NULL),(45,'添加专业',40,'AddMajor.jsp',NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subId` int DEFAULT NULL COMMENT '科目id（关联科目）',
  `sId` int DEFAULT NULL COMMENT '学生id',
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  `result` double DEFAULT '0' COMMENT '学生成绩',
  `actualResult` double DEFAULT NULL,
  `tid` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (1,4,5,'2023-05-08 20:39:35',88,89,'t489549','1'),(2,4,4,'2023-05-08 20:39:35',79,NULL,NULL,NULL),(3,4,3,'2023-05-08 20:39:35',66,NULL,NULL,NULL),(4,4,2,'2023-05-08 20:39:35',60,NULL,NULL,NULL),(5,4,1,'2023-05-08 20:39:35',59,NULL,NULL,NULL),(6,6,10,'2023-05-10 16:28:53',88,NULL,NULL,NULL),(7,6,9,'2023-05-10 16:28:53',78,NULL,NULL,NULL),(8,6,8,'2023-05-10 16:28:53',68,NULL,NULL,NULL),(9,6,7,'2023-05-10 16:28:53',99,NULL,NULL,NULL),(10,6,6,'2023-05-10 16:28:53',100,NULL,NULL,NULL),(11,6,10,'2023-05-10 16:28:53',88,NULL,NULL,NULL),(12,6,9,'2023-05-10 16:28:53',78,NULL,NULL,NULL),(13,6,8,'2023-05-10 16:28:53',68,NULL,NULL,NULL),(14,6,7,'2023-05-10 16:28:53',99,NULL,NULL,NULL),(15,6,6,'2023-05-10 16:28:53',100,NULL,NULL,NULL);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `qq` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `classId` int DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'S2023683549058','张三',23,'男','356985454','15984756325','',1,1,1),(2,'S2023683549143','李四',23,'女','245698745','14569875236','',1,1,1),(3,'S2023683549262','王舞',23,'女','159874568','15288866631','',1,1,1),(4,'S2023683549355','赵柳',24,'女','9874215','15248796358','',1,1,1),(5,'S2023683549402','张理',24,'男','2534865795','19881155663','',1,1,1),(6,'S2023683641445','王丽丽',21,'女','874569','15962384759','',3,2,4),(7,'S2023683641515','张小丽',20,'女','879654','12365897457','',3,2,4),(8,'S2023683641570','胡图图',21,'男','569874','14896327547','',3,2,4),(9,'S2023683641612','胡英俊',21,'男','365984','14856972354','',3,2,4),(10,'S2023683641699','张壮壮',21,'男','789654','15988776652','',3,2,4);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentmenu`
--

DROP TABLE IF EXISTS `studentmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentmenu` (
  `menuId` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3 COMMENT='学生菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentmenu`
--

LOCK TABLES `studentmenu` WRITE;
/*!40000 ALTER TABLE `studentmenu` DISABLE KEYS */;
INSERT INTO `studentmenu` VALUES (5),(6),(7),(27),(28),(34);
/*!40000 ALTER TABLE `studentmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subjectCode` varchar(45) DEFAULT NULL COMMENT '编号',
  `subjectName` varchar(45) DEFAULT NULL COMMENT '名称',
  `createMessage` varchar(45) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gradeId` int DEFAULT NULL COMMENT '年级ID(关联年级表)',
  `cid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subjectCode_UNIQUE` (`subjectCode`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='科目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'1000','项目工程','admin','2023-05-08 20:24:33',2,1,1),(2,'1001','软件测试','admin','2023-05-08 20:24:58',2,1,1),(3,'1002','人机交互','admin','2023-05-08 20:25:10',2,1,1),(4,'1003','计算机网络','admin','2023-05-08 20:25:37',2,1,1),(5,'1004','JAVA企业级开发','admin','2023-05-08 20:26:01',2,1,1),(6,'1005','生物化学','admin','2023-05-09 22:20:30',3,2,4),(7,'1006','细胞生物学','admin','2023-05-09 22:22:39',3,2,4);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL COMMENT '登录帐号(关联登陆账号)',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `age` int DEFAULT NULL COMMENT '年龄',
  `education` varchar(100) DEFAULT NULL COMMENT '学历',
  `goodAt` varchar(100) DEFAULT NULL COMMENT '擅长',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `qq` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT 'qq',
  `email` varchar(45) DEFAULT NULL COMMENT 'E-mail',
  `address` varchar(100) DEFAULT '不详' COMMENT '地址',
  `introduction` varchar(100) DEFAULT NULL COMMENT '个人简介',
  `cid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'t487726','张老师','男',36,'硕士','数据库应用','15926348752','159623487','159623487@qq.com','四川眉山','助教老师',1,1),(2,'t488736','猜老师','男',37,'硕士','软件工程','15874623984','159847562','159847562@qq.com','四川乐山','',1,1),(3,'t489549','周老师','女',55,'博士','小程序开发与应用','14785236954','236541896','236541896@qq.com','台湾','',1,1),(5,'t408865','吴老师','男',55,'博士','生物与医药','15962348753','258963145','258963145@qq.com','浙江台州','',2,4),(6,'t421853','皱老师','女',45,'硕士','细胞生物学','15984632758','569874123','569874123@qq.com','','',4,2),(7,'t422590','唐老师','女',36,'硕士','化工原理','14562398745','569874568','569874568@qq.com','','',5,2),(8,'t935452','霍老师','男',45,'博士','数字媒体技术','15984632755','258964785','258964785@qq.com','','',1,2);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherclass`
--

DROP TABLE IF EXISTS `teacherclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherclass` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tId` int DEFAULT NULL COMMENT '教师id（关联教师）',
  `classId` int DEFAULT NULL COMMENT '班级id（关联班级）',
  `subId` int DEFAULT NULL COMMENT '科目id（关联科目）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='教师班级关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherclass`
--

LOCK TABLES `teacherclass` WRITE;
/*!40000 ALTER TABLE `teacherclass` DISABLE KEYS */;
INSERT INTO `teacherclass` VALUES (1,2,1,4),(2,5,3,6),(3,6,3,7);
/*!40000 ALTER TABLE `teacherclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachermenu`
--

DROP TABLE IF EXISTS `teachermenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachermenu` (
  `menuId` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COMMENT='教师菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachermenu`
--

LOCK TABLES `teachermenu` WRITE;
/*!40000 ALTER TABLE `teachermenu` DISABLE KEYS */;
INSERT INTO `teachermenu` VALUES (1),(5),(6),(7),(9),(27),(28),(29),(34),(35);
/*!40000 ALTER TABLE `teachermenu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-13 19:07:27
