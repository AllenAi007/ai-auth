DROP DATABASE sso;
CREATE DATABASE sso;
USE sso;

DROP TABLE user_authorization;
CREATE TABLE user_authorization
(
  USER_ID           INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  USER_LOGIN_NAME   CHAR(32) NOT NULL UNIQUE,
  PASSWORD          CHAR(32),
  USER_FIRST_NAME   CHAR(32),
  USER_LAST_NAME    CHAR(32),
  LAST_LOGIN        DATETIME,
  LAST_LOGIN_IP     CHAR(32),
  LAST_LOGIN_SYSTEM CHAR(32),
  UPDATED_DATE      DATETIME,
  CREATED_DATE      DATETIME
);

DROP TABLE user_role;
CREATE TABLE user_role
(
  ID           INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  SYSTEM       CHAR(32),
  NAME         CHAR(32),
  DESC_EN      CHAR(64),
  DESC_CN      CHAR(128),
  UPDATED_DATE DATETIME,
  CREATED_DATE DATETIME
);

DROP TABLE user_roles;
CREATE TABLE user_roles
(
  user_id      INT(11) NOT NULL,
  user_role_id INT(11) NOT NULL,
  CONSTRAINT `FK_UR_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user_authorization` (`USER_ID`),
  CONSTRAINT `FK_UR_USER_ROLE_ID` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
);

DROP TABLE user_resource;
CREATE TABLE user_resource
(
  ID           INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NAME         CHAR(32),
  DESC_EN      CHAR(64),
  DESC_CN      CHAR(128),
  PATH         CHAR(32),
  ACTION       CHAR(32),
  UPDATED_DATE DATETIME,
  CREATED_DATE DATETIME
);


DROP TABLE user_role_resource;
CREATE TABLE user_role_resource
(
  user_role_id     INT(11) NOT NULL,
  user_resource_id INT(11) NOT NULL,
  CONSTRAINT `FK_URR_USER_ROLE_ID` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`),
  CONSTRAINT `FK_URR_USER_RESOURCE_ID` FOREIGN KEY (`user_resource_id`) REFERENCES `user_resource` (`id`)
);




