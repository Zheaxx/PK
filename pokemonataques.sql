use pokemon;
drop table if exists pokemonataques;

CREATE TABLE pokemonataques (
clavePoke integer(4) CONSTRAINT pok_fk REFERENCES pokedex, 
claveAtaq integer(4) CONSTRAINT ataq_fk REFERENCES ataques,   
CONSTRAINT alq_pel_pk PRIMARY KEY (clavePoke, claveAtaq);

insert into pokemonataques values (0001,60);