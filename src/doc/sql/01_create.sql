CREATE TABLE TB_USER (
USR_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'The primary key of TB_USER.',
USR_LOGIN_ID VARCHAR(20) NOT NULL COMMENT 'The user login ID',
TP_CD BIGINT NOT NULL COMMENT 'User Type Code - Refer to  CAT_NME - User Type',
NME VARCHAR(100) NOT NULL COMMENT 'The name of a user.',
EMAIL VARCHAR(100) NOT NULL COMMENT 'Email',
PWD VARCHAR(50) COMMENT 'The password of this user ID.',
MOBILE VARCHAR(100) COMMENT 'Mobile',
ADDR VARCHAR(255) COMMENT 'Address',
POST_CD INT (6) COMMENT 'Postal Code',
CTRY_CD BIGINT COMMENT 'Country code - refer to CAT_NME - Country',
ACT_IND TINYINT NOT NULL DEFAULT 0 COMMENT 'Active Indicator',
JOIN_DTE DATE NOT NULL COMMENT 'Joined Date',
CREATED_BY VARCHAR(20) NOT NULL COMMENT 'Created by.',
CREATED_DTE DATE DEFAULT current_timestamp COMMENT 'Creation date.',
UPD_BY VARCHAR(66) NOT NULL COMMENT 'Updated By',
UPD_DTE DATE NOT NULL COMMENT 'Updated Date',
VERSION INT NOT NULL COMMENT 'The version number of the current record.  For the new created record, the version number should be 1. Increments by one, each time the record is updated.  Used to prevent concurrent update via the web front-end.'
);

CREATE TABLE TB_ROLE (
ROLE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'The primary key of TB_ROLE.',
ROLE_CD VARCHAR(20) COMMENT 'The role code. Refer to code type ''. ',
CREATED_BY VARCHAR(66) NOT NULL COMMENT 'Record created by.',
CREATED_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Recordcreation date.',
LS_UPD_BY VARCHAR(66) NOT NULL COMMENT 'Record ast modified by.',
LS_UPD_TS TIMESTAMP NOT NULL COMMENT 'Record last modified by.',
VERSION INT NOT NULL COMMENT 'The version number of the current record.  For the new created record, the version number should be 1. Increments by one, each time the record is updated.  Used to prevent concurrent update via the web front-end.'
);

CREATE TABLE TB_USER_ROLE (
USR_ROLE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'The primary key of TB_USER_ROLE.',
USR_SEQ_ID INT NOT NULL COMMENT 'The primary key of TB_USER.',
ROLE_ID INT NOT NULL COMMENT 'The primary key of TB_ROLE.',
CREATED_BY VARCHAR(66) NOT NULL,
CREATED_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Recordcreation date.',
LS_UPD_BY VARCHAR(66) NOT NULL COMMENT 'Record ast modified by.',
LS_UPD_TS TIMESTAMP NOT NULL COMMENT 'Record last modified by.',
VERSION INT NOT NULL COMMENT 'The version number of the current record.  For the new created record, the version number should be 1. Increments by one, each time the record is updated.  Used to prevent concurrent update via the web front-end.'
);

CREATE TABLE TB_PERMISSION (
PERMI_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'The primary key of TB_PERMISSION.',
URI VARCHAR(1000) NOT NULL COMMENT 'The unique request identifier of the URL or button.',
PERMI_DESC VARCHAR(200) COMMENT 'The description of the permission.',
CREATED_BY VARCHAR(66) NOT NULL COMMENT 'Record created by.',
CREATED_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Recordcreation date.',
LS_UPD_BY VARCHAR(66) NOT NULL COMMENT 'Record ast modified by.',
LS_UPD_TS TIMESTAMP NOT NULL COMMENT 'Record last modified by.',
VERSION INT NOT NULL COMMENT 'The version number of the current record.  For the new created record, the version number should be 1. Increments by one, each time the record is updated.  Used to prevent concurrent update via the web front-end.'
);

CREATE TABLE TB_PERMISSION_ROLE (
PERMI_ROLE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'The primary key of TB_PERMISSION_ROLE.',
ROLE_ID INT COMMENT 'The role ID that ties to this permission.',
CREATED_BY VARCHAR(66) NOT NULL COMMENT 'Record created by.',
CREATED_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Recordcreation date.',
LS_UPD_BY VARCHAR(66) NOT NULL COMMENT 'Record ast modified by.',
LS_UPD_TS TIMESTAMP NOT NULL COMMENT 'Record last modified by.',
VERSION INT NOT NULL COMMENT 'The version number of the current record.  For the new created record, the version number should be 1. Increments by one, each time the record is updated.  Used to prevent concurrent update via the web front-end.'
);

CREATE TABLE TB_MENU_FUNCTION (
MENU_FUNC_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'The primary key of TB_MENU_FUNCTION.',
PERMI_ID INT COMMENT 'The primary key of TB_PERMISSION.',
PRNT_MENU_FUNC_ID VARCHAR(100)COMMENT 'Parent of the menu or function.',
MENU_FUNC_NME VARCHAR(100) COMMENT 'The name of the menu or function.',
CREATED_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Recordcreation date.',
LS_UPD_BY VARCHAR(66) NOT NULL COMMENT 'Record ast modified by.',
LS_UPD_TS TIMESTAMP NOT NULL COMMENT 'Record last modified by.',
VERSION INT NOT NULL COMMENT 'The version number of the current record.  For the new created record, the version number should be 1. Increments by one, each time the record is updated.  Used to prevent concurrent update via the web front-end.'
);