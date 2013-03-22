CREATE DATABASE Pokemon;

grant all privileges on Pokemon.* to monUser@localhost identified by 'monPassword';

use Pokemon;

CREATE TABLE OWNER 
   (	PRENOM VARCHAR(20), 
	POKEMON VARCHAR(20),
	PRIMARY KEY (POKEMON)
   ) ;

insert into OWNER VALUES ("@CloudDeLuna", "@GwenGoupix");
insert into OWNER VALUES ("@cybsip", "@Smogogo13");

CREATE TABLE POKEMON
   (	NOM VARCHAR(20),
	RACE VARCHAR(20),
	PV VARCHAR(20),
	NIVEAU VARCHAR(20),
	PRIMARY KEY (NOM),
	FOREIGN KEY (NOM) REFERENCES OWNER(POKEMON)
   );

insert into POKEMON VALUES ( "@GwenGoupix" , "Goupix" , "PV.100" , "N.1" );
insert into POKEMON VALUES ( "@Smogogo13" , "Smogogo" , "PV.100" , "N.1" );
