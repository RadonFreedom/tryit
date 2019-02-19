create table user
(
  id    int(11)     NOT NULL AUTO_INCREMENT,
  account  varchar(50) NOT NULL unique,
  password varchar(50) NOT NULL,
  name  varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

alter table user add column create_time char(19) not null;
