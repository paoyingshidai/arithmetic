/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.18 : Database - mybatis
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mybatis`;

/*Table structure for table `t_category` */

DROP TABLE IF EXISTS `t_category`;

CREATE TABLE `t_category` (
  `category_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) DEFAULT NULL,
  `lft` BIGINT(20) DEFAULT NULL,
  `rgt` BIGINT(20) DEFAULT NULL,
  `level` int(10) DEFAULT NULL COMMENT '层级',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父亲节点 ID',
  PRIMARY KEY (`category_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4


/*Data for the table `t_category` */

/*Table structure for table `t_food` */

DROP TABLE IF EXISTS `t_food`;

CREATE TABLE `t_food` (
  `food_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fname` varchar(20) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `t_food` */

insert  into `t_food`(`food_id`,`fname`) values (1,'\"fname\"'),(2,'\"fname\"'),(3,'fname'),(4,'fname'),(5,'fname'),(6,'fname'),(7,'fname'),(8,'fname'),(9,'fname'),(10,'fname'),(11,'fname'),(12,'fname'),(13,'fname'),(14,'fname'),(15,'fname'),(16,'fname'),(17,'fname'),(18,'fname'),(19,'fname'),(20,'fname'),(21,'fname'),(22,'fname'),(23,'fname'),(24,'fname'),(25,'fname'),(26,'fname'),(27,'fname'),(28,'fname'),(29,'fname'),(30,'fname'),(31,'fname'),(32,'fname'),(33,'fname'),(34,'fname'),(35,'fname');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`username`,`password`) values (1,'useranme','password'),(2,'useranme','password');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
