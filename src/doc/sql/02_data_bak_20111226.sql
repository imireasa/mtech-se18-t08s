USE vms;

LOCK TABLES `TB_CODE_CATEGORY` WRITE;
/*!40000 ALTER TABLE `TB_CODE_CATEGORY` DISABLE KEYS */;
INSERT INTO `TB_CODE_CATEGORY` VALUES 
(1,'COUNTRY','Country Code'),
(2,'PROPOSAL_STATUS','Proposal Status'),
(3,'PROJECT_STATUS','Project Status'),
(4,'TITLE','Title'),
(5,'USER_TYPE','User Type'),
(6,'PROJECT_INTREST_STATUS','Project Itrest Status'),
(7,'MEMBER_ROLE','Member Role'),
(8,'FEEDBACK_STATUS','Feedback Status'),
(9,'TASK_STATUS','Task Status');
(10,'CERTIFICATE_REQUEST_STATUS','Certificate Request Status');
(11,'CERTIFICATE_REQUEST_TYPE','Certificate Request Type');
/*!40000 ALTER TABLE `TB_CODE_CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `TB_CODE` WRITE;
/*!40000 ALTER TABLE `TB_CODE` DISABLE KEYS */;
INSERT INTO `TB_CODE` VALUES 
(1,1,'Singapore','Singapore'),
(2,1,'Philippines','Philippines'),
(3,1,'Myanmar','Myanmar'),
(4,2,'Submitted',''),
(5,2,'Approved',''),
(6,2,'Rejected',''),
(7,3,'New',''),
(8,3,'In Progress',''),
(9,3,'Close',''),
(10,4,'Mr.',''),
(11,4,'Ms.',''),
(12,4,'Mrs.',''),
(13,4,'Mdm.',''),
(14,4,'Dr.',''),
(15,4,'Sr.',''),
(16,4,'Miss',''),
(17,4,'Mstr.',''),
(18,4,'Prof.',''),
(19,4,'Unk.',''),
(20,5,'Volunteer',''),
(21,5,'Staff',''),
(22,6,'New',''),
(23,6,'Approved',''),
(24,6,'Rejected',''),
(25,6,'Withdraw',''),
(26,7,'Project Member',''),
(27,7,'Project Manager',''),
(28,7,'Project Leader',''),
(29,8,'Submitted',''),
(30,8,'Approved',''),
(31,8,'Rejected',''),
(32,9,'New',''),
(33,9,'Close',''),
(34,10,'Requested',''),
(35,10,'Processed',''),
(36,11,'Project',''),
(36,12,'Individual','');
/*!40000 ALTER TABLE `TB_CODE` ENABLE KEYS */;
UNLOCK TABLES;
