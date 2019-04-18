use pokemon;

CREATE TABLE pokemonataques (
clavePoke integer(4), 
claveAtaq integer(4),   
CONSTRAINT alq_pel_pk PRIMARY KEY (clavePoke, claveAtaq),
FOREIGN KEY (clavePoke) REFERENCES pokedex(clave),
FOREIGN KEY (claveAtaq) REFERENCES ataques(clave)
);





