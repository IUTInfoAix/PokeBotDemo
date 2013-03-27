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
insert into OWNER VALUES ("@cybsip", "@Dracaufeu13");

CREATE TABLE POKEMON
   (    NOM VARCHAR(20),
        RACE VARCHAR(20),
        PV INT,
        NIVEAU VARCHAR(20),
        XP VARCHAR(20),
        ATTS INT,
        DEFS INT,
        ATTSPE INT,
        DEFSPE INT,
        VIT INT,
        PRIMARY KEY (NOM),
        FOREIGN KEY (NOM) REFERENCES OWNER(POKEMON)
   );
 
INSERT INTO POKEMON VALUES ( "@GwenGoupix" , "Goupix" , 100 , "N.1" , "XP.0" , 0 , 0 , 0 , 0 , 0 );
INSERT INTO POKEMON VALUES ( "@Smogogo13" , "Smogogo" , 100 , "N.1" , "XP.0" , 0 , 0 , 0 , 0 , 0 );
INSERT INTO POKEMON VALUES ( "@Dracaufeu13" , "Dracaufeu" , 100 , "N.1" , "XP.0" , 0 , 0 , 0 , 0 , 0 );
