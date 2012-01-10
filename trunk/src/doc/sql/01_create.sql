/*
SQLyog Ultimate v9.50 
MySQL - 5.5.12 : Database - vms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vms` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `vms`;

/*Table structure for table `tb_certificate_request` */

DROP TABLE IF EXISTS `tb_certificate_request`;

CREATE TABLE `tb_certificate_request` (
  `CERT_REQ_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_ID` bigint(19) NOT NULL,
  `REQ_TP` bigint(19) NOT NULL,
  `REQ_STS` bigint(19) NOT NULL,
  `REQ_DTE` datetime NOT NULL,
  `REQ_BY` varchar(20) NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`CERT_REQ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `tb_code` */

DROP TABLE IF EXISTS `tb_code`;

CREATE TABLE `tb_code` (
  `CD_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `CAT_ID` bigint(19) NOT NULL,
  `VAL` varchar(50) NOT NULL,
  `CD_DESC` varchar(100) NOT NULL,
  PRIMARY KEY (`CD_ID`),
  KEY `FKTB_CODE317331` (`CAT_ID`),
  CONSTRAINT `FKTB_CODE317331` FOREIGN KEY (`CAT_ID`) REFERENCES `tb_code_category` (`CAT_ID`),
  CONSTRAINT `tb_code_ibfk_1` FOREIGN KEY (`CAT_ID`) REFERENCES `tb_code_category` (`CAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_code_category` */

DROP TABLE IF EXISTS `tb_code_category`;

CREATE TABLE `tb_code_category` (
  `CAT_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `NME` varchar(50) NOT NULL,
  `CD_CAT_DESC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_document` */

DROP TABLE IF EXISTS `tb_document`;

CREATE TABLE `tb_document` (
  `DOC_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `REF_ID` bigint(19) NOT NULL,
  `REF_TP` bigint(19) NOT NULL COMMENT 'Reference type of the business type. Refer to code category ',
  `FLE_NME` varchar(100) NOT NULL,
  `FLE` blob NOT NULL,
  `DOC_DESC` varchar(255) DEFAULT NULL,
  `DEL_IND` tinyint(1) NOT NULL DEFAULT '0',
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`DOC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_menu_function` */

DROP TABLE IF EXISTS `tb_menu_function`;

CREATE TABLE `tb_menu_function` (
  `MENU_FUNC_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRNT_MENU_FUNC_ID` bigint(19) DEFAULT NULL,
  `MENU_FUNC_NME` varchar(100) NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL,
  PRIMARY KEY (`MENU_FUNC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_permission` */

DROP TABLE IF EXISTS `tb_permission`;

CREATE TABLE `tb_permission` (
  `PERMI_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `URI` varchar(1000) NOT NULL,
  `PERMI_DESC` varchar(200) DEFAULT NULL,
  `MENU_FUNC_ID` bigint(19) DEFAULT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL,
  PRIMARY KEY (`PERMI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project` */

DROP TABLE IF EXISTS `tb_project`;

CREATE TABLE `tb_project` (
  `PRJ_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `NME` varchar(100) NOT NULL,
  `PRJ_DESC` varchar(255) NOT NULL,
  `PRJ_MGR` varchar(20) DEFAULT NULL,
  `STR_DTE` datetime NOT NULL,
  `END_DTE` datetime NOT NULL,
  `CTRY_CD` bigint(19) NOT NULL,
  `LOC` varchar(255) NOT NULL,
  `RMK` varchar(500) DEFAULT NULL,
  `PRJ_PROP_ID` bigint(19) DEFAULT NULL,
  `STS_CD` bigint(19) NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PRJ_ID`),
  KEY `FKTB_PROJECT334276` (`PRJ_PROP_ID`),
  CONSTRAINT `FKTB_PROJECT334276` FOREIGN KEY (`PRJ_PROP_ID`) REFERENCES `tb_project_proposal` (`PRJ_PROP_ID`),
  CONSTRAINT `tb_project_ibfk_1` FOREIGN KEY (`PRJ_PROP_ID`) REFERENCES `tb_project_proposal` (`PRJ_PROP_ID`),
  CONSTRAINT `tb_project_ibfk_2` FOREIGN KEY (`PRJ_PROP_ID`) REFERENCES `tb_project_proposal` (`PRJ_PROP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_experience` */

DROP TABLE IF EXISTS `tb_project_experience`;

CREATE TABLE `tb_project_experience` (
  `PRJ_EXP_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_ID` bigint(19) NOT NULL,
  `CONT` text NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` varchar(20) NOT NULL,
  PRIMARY KEY (`PRJ_EXP_ID`),
  KEY `FKTB_PROJECT154073` (`PRJ_ID`),
  CONSTRAINT `FKTB_PROJECT154073` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_experience_ibfk_1` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_experience_ibfk_2` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_feedback` */

DROP TABLE IF EXISTS `tb_project_feedback`;

CREATE TABLE `tb_project_feedback` (
  `PRJ_FB_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_ID` bigint(19) NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  `CONT` text NOT NULL,
  `APPR_BY` varchar(20) DEFAULT NULL,
  `APPR_DTE` datetime DEFAULT NULL,
  `STS_CD` bigint(19) NOT NULL DEFAULT '0',
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PRJ_FB_ID`),
  KEY `FKTB_PROJECT303640` (`PRJ_ID`),
  CONSTRAINT `FKTB_PROJECT303640` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_feedback_ibfk_1` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_feedback_ibfk_2` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_interest` */

DROP TABLE IF EXISTS `tb_project_interest`;

CREATE TABLE `tb_project_interest` (
  `PRJ_INTRST_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_ID` bigint(19) NOT NULL,
  `REQ_BY` varchar(20) NOT NULL,
  `APPR_BY` varchar(20) DEFAULT NULL,
  `APPR_DTE` datetime DEFAULT NULL,
  `APPR_RMK` varchar(255) DEFAULT NULL,
  `STS_CD` bigint(19) NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) DEFAULT NULL,
  `UPD_DTE` datetime DEFAULT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PRJ_INTRST_ID`),
  KEY `FKTB_PROJECT169016` (`PRJ_ID`),
  CONSTRAINT `FKTB_PROJECT169016` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_interest_ibfk_1` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_interest_ibfk_2` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_member` */

DROP TABLE IF EXISTS `tb_project_member`;

CREATE TABLE `tb_project_member` (
  `PRJ_MBR_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_ID` bigint(19) NOT NULL,
  `USR_LOGIN_ID` varchar(20) NOT NULL,
  `ROLE_CD` bigint(19) NOT NULL,
  `ACT_IND` tinyint(1) NOT NULL DEFAULT '1',
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PRJ_MBR_ID`),
  KEY `FKTB_PROJECT662350` (`PRJ_ID`),
  CONSTRAINT `FKTB_PROJECT662350` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_member_ibfk_1` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_member_ibfk_2` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_proposal` */

DROP TABLE IF EXISTS `tb_project_proposal`;

CREATE TABLE `tb_project_proposal` (
  `PRJ_PROP_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `NME` varchar(100) NOT NULL,
  `PRJ_PROP_DESC` varchar(255) DEFAULT NULL,
  `CTRY_CD` bigint(19) NOT NULL,
  `LOC` varchar(255) NOT NULL,
  `EST_DUR` int(2) NOT NULL,
  `PROPOSER_ID` varchar(20) NOT NULL,
  `APPR_BY` varchar(20) DEFAULT NULL,
  `APPR_DTE` datetime DEFAULT NULL,
  `STS_CD` bigint(19) NOT NULL,
  `RMK` varchar(500) DEFAULT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PRJ_PROP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_proposal_document` */

DROP TABLE IF EXISTS `tb_project_proposal_document`;

CREATE TABLE `tb_project_proposal_document` (
  `PROP_DOC_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_PROP_ID` bigint(19) NOT NULL,
  `DOC_ID` bigint(19) NOT NULL,
  PRIMARY KEY (`PROP_DOC_ID`),
  KEY `FKTB_PROJECT324928` (`DOC_ID`),
  KEY `FKTB_PROJECT47632` (`PRJ_PROP_ID`),
  CONSTRAINT `FKTB_PROJECT324928` FOREIGN KEY (`DOC_ID`) REFERENCES `tb_document` (`DOC_ID`),
  CONSTRAINT `FKTB_PROJECT47632` FOREIGN KEY (`PRJ_PROP_ID`) REFERENCES `tb_project_proposal` (`PRJ_PROP_ID`),
  CONSTRAINT `tb_project_proposal_document_ibfk_1` FOREIGN KEY (`DOC_ID`) REFERENCES `tb_document` (`DOC_ID`),
  CONSTRAINT `tb_project_proposal_document_ibfk_2` FOREIGN KEY (`PRJ_PROP_ID`) REFERENCES `tb_project_proposal` (`PRJ_PROP_ID`),
  CONSTRAINT `tb_project_proposal_document_ibfk_3` FOREIGN KEY (`DOC_ID`) REFERENCES `tb_document` (`DOC_ID`),
  CONSTRAINT `tb_project_proposal_document_ibfk_4` FOREIGN KEY (`PRJ_PROP_ID`) REFERENCES `tb_project_proposal` (`PRJ_PROP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_task` */

DROP TABLE IF EXISTS `tb_project_task`;

CREATE TABLE `tb_project_task` (
  `PRJ_TASK_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_ID` bigint(19) NOT NULL,
  `NME` varchar(100) NOT NULL,
  `PRJ_TASK_DESC` varchar(255) DEFAULT NULL,
  `ODR_NO` int(3) NOT NULL,
  `STR_DTE` datetime NOT NULL,
  `END_DTE` datetime NOT NULL,
  `STS_CD` bigint(19) NOT NULL,
  `DEL_IND` tinyint(1) DEFAULT '0',
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PRJ_TASK_ID`),
  KEY `FKTB_PROJECT627018` (`PRJ_ID`),
  CONSTRAINT `FKTB_PROJECT627018` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_task_ibfk_1` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`),
  CONSTRAINT `tb_project_task_ibfk_2` FOREIGN KEY (`PRJ_ID`) REFERENCES `tb_project` (`PRJ_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_project_task_member` */

DROP TABLE IF EXISTS `tb_project_task_member`;

CREATE TABLE `tb_project_task_member` (
  `PRJ_TASK_MBR_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `PRJ_TASK_ID` bigint(19) NOT NULL,
  `USR_LOGIN_ID` varchar(20) NOT NULL,
  `DEL_IND` tinyint(1) NOT NULL DEFAULT '0',
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PRJ_TASK_MBR_ID`),
  KEY `FKTB_PROJECT235243` (`PRJ_TASK_ID`),
  CONSTRAINT `FKTB_PROJECT235243` FOREIGN KEY (`PRJ_TASK_ID`) REFERENCES `tb_project_task` (`PRJ_TASK_ID`),
  CONSTRAINT `tb_project_task_member_ibfk_1` FOREIGN KEY (`PRJ_TASK_ID`) REFERENCES `tb_project_task` (`PRJ_TASK_ID`),
  CONSTRAINT `tb_project_task_member_ibfk_2` FOREIGN KEY (`PRJ_TASK_ID`) REFERENCES `tb_project_task` (`PRJ_TASK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `ROLE_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `ROLE_CD` bigint(20) NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_role_function` */

DROP TABLE IF EXISTS `tb_role_function`;

CREATE TABLE `tb_role_function` (
  `ROLE_FUNC_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `MENU_FUNC_ID` bigint(19) NOT NULL,
  `ROLE_ID` bigint(19) NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL,
  PRIMARY KEY (`ROLE_FUNC_ID`),
  KEY `FKTB_ROLE_FU704974` (`MENU_FUNC_ID`),
  KEY `FKTB_ROLE_FU644199` (`ROLE_ID`),
  CONSTRAINT `FKTB_ROLE_FU644199` FOREIGN KEY (`ROLE_ID`) REFERENCES `tb_role` (`ROLE_ID`),
  CONSTRAINT `FKTB_ROLE_FU704974` FOREIGN KEY (`MENU_FUNC_ID`) REFERENCES `tb_menu_function` (`MENU_FUNC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `USR_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `USR_LOGIN_ID` varchar(20) NOT NULL,
  `TP_CD` bigint(19) NOT NULL,
  `TITLE_CD` bigint(19) NOT NULL,
  `NME` varchar(100) NOT NULL,
  `DOB` date DEFAULT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PWD` varchar(50) NOT NULL,
  `MOBILE` varchar(100) DEFAULT NULL,
  `ADDR` varchar(255) DEFAULT NULL,
  `POST_CD` int(6) DEFAULT NULL,
  `CTRY_CD` bigint(19) DEFAULT NULL,
  `ACT_IND` tinyint(1) NOT NULL DEFAULT '0',
  `JOIN_DTE` datetime NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`USR_ID`),
  UNIQUE KEY `USR_LOGIN_ID` (`USR_LOGIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_user_detail` */

DROP TABLE IF EXISTS `tb_user_detail`;

CREATE TABLE `tb_user_detail` (
  `USR_DTL_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `USR_ID` bigint(19) NOT NULL,
  `INTRST` varchar(255) DEFAULT NULL,
  `SKILL_SET` varchar(255) DEFAULT NULL,
  `QUAL_ATT` varchar(255) DEFAULT NULL,
  `JOB_TITLE_CD` bigint(19) DEFAULT NULL,
  `SALARY` decimal(14,2) DEFAULT NULL,
  PRIMARY KEY (`USR_DTL_ID`),
  UNIQUE KEY `USR_ID` (`USR_ID`),
  KEY `FKTB_USER_DE115797` (`USR_ID`),
  CONSTRAINT `FKTB_USER_DE115797` FOREIGN KEY (`USR_ID`) REFERENCES `tb_user` (`USR_ID`),
  CONSTRAINT `tb_user_detail_ibfk_1` FOREIGN KEY (`USR_ID`) REFERENCES `tb_user` (`USR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `USR_ROLE_ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` bigint(19) NOT NULL,
  `USR_ID` bigint(19) NOT NULL,
  `CREATED_BY` varchar(20) NOT NULL,
  `CREATED_DTE` datetime NOT NULL,
  `UPD_BY` varchar(20) NOT NULL,
  `UPD_DTE` datetime NOT NULL,
  `VERSION` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`USR_ROLE_ID`),
  KEY `FKTB_USER_RO554008` (`ROLE_ID`),
  CONSTRAINT `FKTB_USER_RO554008` FOREIGN KEY (`ROLE_ID`) REFERENCES `tb_role` (`ROLE_ID`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `tb_role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
