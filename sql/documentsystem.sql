/*
Navicat MySQL Data Transfer

Source Server         : CAIZHIHAO
Source Server Version : 50549
Source Host           : 192.168.18.142:3306
Source Database       : documentsystem

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-05-27 17:14:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `did` varchar(200) NOT NULL,
  `dname` varchar(50) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `dtype` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `isShare` int(10) DEFAULT NULL,
  `isGarbage` int(10) DEFAULT NULL,
  `u_id` varchar(50) DEFAULT NULL,
  `filesize` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('40862e49-65f2-4e9d-bcc4-f3bd942d47a6', '妇联4', '2019-05-24 09:56:41', '.jpg', 'C:/Users/CAIZHIHAO/Desktop/upload/ee63d6da-5825-4080-b1bb-41011fbd87b5.jpg', '1', '0', '1', '10M');
INSERT INTO `document` VALUES ('5c42250b-5c77-4f2d-8c73-3f37b2a0bdf3', '树形菜单', '2019-05-25 12:37:36', '.zip', 'C:/Users/CAIZHIHAO/Desktop/upload/d4c4c3b1-0145-450d-b833-72e1ca751abb.zip', '1', '0', '1', '10M');
INSERT INTO `document` VALUES ('669bb76e-dcd9-4d54-8cdb-d6b580aca823', '捕获', '2019-05-25 17:59:47', '.PNG', 'C:/Users/CAIZHIHAO/Desktop/upload/0a8a3bef-31b1-47ca-8d00-f035ab794dab.PNG', '0', '0', '1', '0.929038M');
INSERT INTO `document` VALUES ('7511ca89-e2ff-4295-be3b-856cfe352931', '03', '2019-05-25 18:00:19', '.PNG', 'C:/Users/CAIZHIHAO/Desktop/upload/cbe24ae7-d86d-4e3f-9ad2-107432dc78bd.PNG', '1', '0', '1', '0.267057M');
INSERT INTO `document` VALUES ('9d7847da-eb7b-4fbf-a6f6-11671ac4a723', 'Sleep Away', '2019-05-25 17:42:55', '.mp3', 'C:/Users/CAIZHIHAO/Desktop/upload/538ecf67-55bf-47a1-a90d-0893ce4fb639.mp3', '0', '0', '1', '4.842M');
INSERT INTO `document` VALUES ('9f98345d-f6e9-42de-aa92-03776217c8d9', 'A', '2019-05-27 02:02:36', '.PNG', 'C:/Users/CAIZHIHAO/Desktop/upload/403b03f2-55b4-4b1f-9579-df1ca480b110.PNG', '1', '0', '1', '0.047883M');
INSERT INTO `document` VALUES ('a5084e78-c24e-445b-a247-8fb55362e157', '捕获', '2019-05-25 17:58:50', '.PNG', 'C:/Users/CAIZHIHAO/Desktop/upload/fc2b4abc-7293-4e24-85cd-62f5867be571.PNG', '0', '0', '1', '0.929038M');
INSERT INTO `document` VALUES ('a579ce27-81b7-41c2-ae61-8a94b7e099b5', 'linux常用命令', '2019-05-27 01:27:23', '.txt', 'C:/Users/CAIZHIHAO/Desktop/upload/6260de0d-2b82-40a3-b1e1-2176019ed154.txt', '1', '0', '3c6e26df-2698-410e-bf8f-543258c0ca06', '0.007391M');
INSERT INTO `document` VALUES ('b60538eb-6bd7-48b6-8259-83f70d963b41', 'Kalimba', '2019-05-25 17:44:55', '.mp3', 'C:/Users/CAIZHIHAO/Desktop/upload/32105123-8c8a-4d31-8168-8dc203d40324.mp3', '0', '0', '1', '8M');
INSERT INTO `document` VALUES ('b644d81c-e452-4cf4-8c97-2d8f563da238', '02', '2019-05-25 18:00:19', '.PNG', 'C:/Users/CAIZHIHAO/Desktop/upload/663ef356-4986-4e86-b09f-d498a532cc21.PNG', '1', '0', '1', '0.16732M');
INSERT INTO `document` VALUES ('bf00c2b3-187e-4293-83a4-3a5f68942b0a', 'lingyuner', '2019-05-27 01:27:23', '.jpg', 'C:/Users/CAIZHIHAO/Desktop/upload/6260de0d-2b82-40a3-b1e1-2176019ed154.jpg', '1', '0', '3c6e26df-2698-410e-bf8f-543258c0ca06', '0.065244M');
INSERT INTO `document` VALUES ('c5fdc624-4a75-44af-8bea-1b8e04836b0c', 'Chrysanthemum', '2019-05-24 09:56:41', '.jpg', 'C:/Users/CAIZHIHAO/Desktop/upload/5cb885ba-d1d5-4874-89ae-f2f9b86d7417.jpg', '0', '0', '1', '10M');
INSERT INTO `document` VALUES ('cfccdc19-9e4c-4a44-99e3-2ae33400ef18', 'A', '2019-05-25 18:00:19', '.PNG', 'C:/Users/CAIZHIHAO/Desktop/upload/bd3e5deb-b609-42ef-ae43-67fa4fea768e.PNG', '0', '0', '1', '0.047883M');
INSERT INTO `document` VALUES ('da6bd3ec-f6cd-482a-96a2-f7e8329f820f', 'config', '2019-05-27 01:25:54', '.plist', 'C:/Users/CAIZHIHAO/Desktop/upload/c17fff2c-63e9-4e20-ad16-ab9a477cce07.plist', '1', '0', '3c6e26df-2698-410e-bf8f-543258c0ca06', '0.008379M');
INSERT INTO `document` VALUES ('e1e29857-89da-48ac-aab7-9bb0e82815bc', '02', '2019-05-27 01:50:58', '.PNG', 'C:/Users/CAIZHIHAO/Desktop/upload/c2b2b858-a2f2-40ce-a27e-9714a00038d5.PNG', '0', '0', '1', '0.16732M');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(200) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'czh', '123456', '21@qq.com', '1966-01-01', 'male');
INSERT INTO `user` VALUES ('2', 'LPL', '456789', 'asf@qq.com', '2004-01-12', 'fmale');
INSERT INTO `user` VALUES ('3bef1d29-3713-4b73-91ad-0eb4bf1753f0', 'test04', '123456', '15212@qq.com', '2019-05-08', 'male');
INSERT INTO `user` VALUES ('3c6e26df-2698-410e-bf8f-543258c0ca06', 'fwj', '123456', '13212@qq.com', '1997-01-05', 'fmale');
INSERT INTO `user` VALUES ('c655ac90-6b38-4a1d-a5bd-09ff9dbaac15', 'test02', '123456', '15212@qq.com', '2019-05-09', 'male');
INSERT INTO `user` VALUES ('e145f16f-5897-4fa6-84cb-6ae51d3297c8', 'test01', '123456', '15212@qq.com', '2001-03-30', 'fmale');
INSERT INTO `user` VALUES ('f09db5ba-d16f-49be-8e9e-cd08a39d20d4', 'test03', '123456', '15212@qq.com', '2019-05-07', 'male');
