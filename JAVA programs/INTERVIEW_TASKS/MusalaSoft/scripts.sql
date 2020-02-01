CREATE SCHEMA gateways; 

use gateways;

create table tb_gateway(
   id INT NOT NULL AUTO_INCREMENT,
   serial_number VARCHAR(60)  NOT NULL,
   name VARCHAR(100) NOT NULL,
   IPv4 varbinary(16),
   PRIMARY KEY (id)
);

create table tb_perif_device(

   id INT NOT NULL AUTO_INCREMENT,
   gateway_id INT NOT NULL, 
   vendor VARCHAR(100) NOT NULL,
   date_created DATETIME NOT NULL,
   status BOOLEAN NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (gateway_id) REFERENCES tb_gateway(id)
);

INSERT INTO `tb_gateway` VALUES ('1','7706204','velit','117.251.127.173'),
('2','','quae','121.80.134.207'),
('3','','delectus','48.136.141.247'),
('4','33395963','nostrum','206.97.191.104'),
('5','2681','eligendi','202.145.92.197'),
('6','3326832','facilis','113.120.39.246'),
('7','91','sed','214.175.247.50'),
('8','7806','hic','189.132.184.19'),
('9','845508941','eum','119.86.47.22'),
('10','279991','facere','151.28.150.146'),
('11','99','laborum','190.53.147.205'),
('12','56089','velit','187.232.241.124'),
('13','5','soluta','171.72.235.219'),
('14','676269','sequi','49.157.222.84'),
('15','594628613','accusamus','187.60.17.179'); 


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
('15','15','Gislason, Skiles and Nicolas','1978-09-05 09:46:14','0'),
('16','4','Barton Inc1','2017-02-23 12:03:05','0'),
('17','4','Barton Inc2','2017-02-23 12:03:05','0'),
('18','4','Barton Inc3','2017-02-23 12:03:05','0'),
('19','4','Barton Inc4','2017-02-23 12:03:05','0'),
('20','4','Barton Inc5','2017-02-23 12:03:05','0'),
('21','4','Barton Inc6','2017-02-23 12:03:05','0'); 