CREATE DATABASE Pokemon;

grant all privileges on Pokemon.* to monUser@localhost identified by 'monPassword';

CREATE TABLE OWNER 
   (	PRENOM VARCHAR(20), 
	POKEMON VARCHAR(20),
	PRIMARY KEY (POKEMON)
   ) ;

insert into OWNER VALUES ("@CloudDeLuna", "@GwenGoupix");


