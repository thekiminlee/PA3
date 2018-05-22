

DROP TABLE IF EXISTS purchased;

CREATE TABLE purchased (
	id int unsigned not null auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	phone_num varchar(10) not null, 
	email varchar(50) not null,
	product varchar(50) not null,
	quantity int unsigned not null,
	address text not null,
	card_num varchar(16) not null,
	shipping varchar(30) not null,

	PRIMARY KEY (id)
);