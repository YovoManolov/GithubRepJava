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