-- Generation time: Sun, 26 Jan 2020 20:59:50 +0000
-- Host: mysql.hostinger.ro
-- DB name: u574849695_25
/*!40030 SET NAMES UTF8 */;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `tb_perif_device`;
CREATE TABLE `tb_perif_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gateway_id` int(11) NOT NULL,
  `vendor` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `date_created` datetime NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `gateway_id` (`gateway_id`),
  CONSTRAINT `tb_perif_device_ibfk_1` FOREIGN KEY (`gateway_id`) REFERENCES `tb_gateway` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `tb_perif_device` VALUES ('1','1','Von LLC','1989-10-16 18:47:11','0'),
('2','2','Rempel-Hickle','2018-09-25 20:04:11','0'),
('3','3','Heller, Bechtelar and Romaguera','2015-10-19 09:20:42','0'),
('4','4','Barton Inc','2017-02-23 12:03:05','0'),
('5','5','Bernier, Kirlin and Carter','1991-06-14 22:42:13','0'),
('6','6','Connelly, Koepp and Hammes','1989-02-08 22:17:22','0'),
('7','7','Labadie, Kunde and Eichmann','2002-10-01 18:10:28','0'),
('8','8','Crooks, Walker and McCullough','1996-09-15 10:31:06','0'),
('9','9','Kuphal-Daniel','2016-04-23 17:08:57','0'),
('10','10','Kertzmann, Mann and Ullrich','1977-01-24 07:48:38','0'),
('11','11','Terry-Schumm','1973-01-29 04:00:30','0'),
('12','12','Greenfelder Ltd','1992-07-07 03:33:03','0'),
('13','13','Ratke Inc','2016-07-23 01:40:45','0'),
('14','14','Dare-Nitzsche','1978-08-23 22:14:52','0'),
('15','15','Gislason, Skiles and Nicolas','1978-09-05 09:46:14','0'); 




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

