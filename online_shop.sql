-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: online_shop
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `online_user`
--

DROP TABLE IF EXISTS `online_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `online_user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  `USER_SEX` varchar(1) NOT NULL,
  `USER_BIRTHDAY` date DEFAULT NULL,
  `USER_IDENTITY_CODE` varchar(60) DEFAULT NULL,
  `USER_EMAIL` varchar(60) DEFAULT NULL,
  `USER_MOBILE` varchar(11) DEFAULT NULL,
  `USER_ADDRESS` varchar(200) NOT NULL,
  `USER_STATUS` decimal(6,0) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `online_user`
--

LOCK TABLES `online_user` WRITE;
/*!40000 ALTER TABLE `online_user` DISABLE KEYS */;
INSERT INTO `online_user` VALUES ('admin','admin','123','T','2020-03-30',NULL,'aaa@bbb.com','087415157','淮安区',2),('admin1','admin1','123','W','2020-03-30',NULL,'aaa@bbb.com','12345678901','淮安',2),('admin2','admin2','123','T','2020-03-30',NULL,'aaa@bbb.com','12345678901','淮安',2),('admin3','admin3','123','W','2020-03-30',NULL,'aaa@bbb.com','12345678901','淮安',2),('admin4','admin4','123','W','2020-03-30',NULL,'aaa@bbb.com','12345678901','淮安',2),('admin5','admin5','123','T','2020-03-30',NULL,'aaa@bbb.com','12345678901','淮安',2),('cq','陈权','123','W','2020-04-01',NULL,'333@999.com','654123222','灰墩',1),('fems','福尔摩斯','123','T','2020-04-01',NULL,'333@ttt.com','333211111','贝克街',1),('htl','韩天乐','123','T','2020-05-08',NULL,'1056077429@qq.com','087415157','涟水县',2),('lcs','刘成盛','123','T','2020-04-01',NULL,'985@211.com','321444114','北集',1),('ls','李四','111','T','2020-04-01',NULL,'HHH@163.com','002135452','清江浦区',1),('zl','赵六','123','T','2020-04-01',NULL,'aaa@eee.com','321467888','泗洪',1),('zs','张三','123','W','2020-04-01',NULL,'aaa@ccc.com','987123456','淮阴区',1),('zsf','张三丰','123','T','2020-05-08',NULL,'aaa@bbb.com','12345678901','武当山',1),('zwj','张无忌','123','T','2020-05-08',NULL,'aaa@bbb.com','09456321562','武当山',1),('zy','赵云','111','T','2020-04-02',NULL,'333@lll.com','987456321','常山',1);
/*!40000 ALTER TABLE `online_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-16 18:45:03
