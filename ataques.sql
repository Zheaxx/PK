use pokemon;
drop table if exists ataques;
create table ataques (clave integer (4),
tipo varchar(30),nombre varchar(30),impactar integer(2),daño integer(2),requisitos integer(2),notas varchar(100),
 primary key (clave));
 
insert into ataques values (0001,'agua','Burbuja',02,02,02,'');
insert into ataques values (0002,'agua','Hidrobomba',05,08,07,'');
insert into ataques values (0003,'agua','Pistola agua',03,03,03,'');
insert into ataques values (0004,'agua','Rayo burbuja',03,04,05,'');
insert into ataques values (0005,'agua','Refugio',00,00,02,'+1 a la defensa.');

insert into ataques values (0006,'bicho','Chupavidas',04,04,05,'Recupera la mitad del daño.');
insert into ataques values (0007,'bicho','Disparo demora',03,00,02,'-1 velocidad del rival.');
insert into ataques values (0008,'bicho','Doble ataque',03,02,03,'Puede impactar 2 veces por turno. Si sale un 6 al impactar envenena.');
insert into ataques values (0009,'bicho','Pin Misil',02,02,02,'');

insert into ataques values (0010,'eléctrico','Impactrueno',02,02,02,'Si sale un 6 al impactar paraliza.');
insert into ataques values (0011,'eléctrico','Onda trueno',03,00,03,'paraliza al rival.');
insert into ataques values (0012,'eléctrico','Pueño trueno',03,04,05,'Si sale un 6 al impactar paraliza.');
insert into ataques values (0013,'eléctrico','Rayo',04,05,06,'Si sale un 6 al impactar paraliza.');
insert into ataques values (0014,'eléctrico','Trueno',05,08,07,'Si sale un 6 al impactar paraliza.');

insert into ataques values (0015,'fantasma','Lengüetazo',03,02,02,'Si sale un 5 o + al impactar paraliza.');
insert into ataques values (0016,'fantasma','Rayo Confuso',03,00,03,'Confunde al rival.');
insert into ataques values (0017,'fantasma','Tinieblas',01,00,03,'Daño = a nivel. Afecta a normal y psíquico.');

insert into ataques values (0018,'fuego','Ascuas',02,02,02,'Si sale un 6 al impactar quema.');
insert into ataques values (0019,'fuego','Giro fuego',03,03,03,'Si sale un 6 al impactar quema.');
insert into ataques values (0020,'fuego','Lanzallamas',03,04,05,'Si sale un 6 al impactar quema.');
insert into ataques values (0021,'fuego','Llamarada',05,08,07,'Si sale un 6 al impactar quema.');
insert into ataques values (0022,'fuego','Puño fuego',03,04,05,'Si sale un 6 al impactar quema.');

insert into ataques values (0023,'hielo','Niebla',00,00,02,'Niebla restaura todos los cambios pos y neg en las stats de pokemon en combate.');
insert into ataques values (0024,'hielo','Puño hielo',03,04,05,'');
insert into ataques values (0025,'hielo','Rayo aurora',03,03,03,'');
insert into ataques values (0026,'hielo','Rayo hielo',03,04,05,'Si sale un 6 al impactar y se hace crítico, congela.');
insert into ataques values (0027,'hielo','Ventisca',05,08,07,'Si sale un 6 al impactar y se hace crítico, congela.');

insert into ataques values (0028,'lucha','Doble patada',03,02,02,'Puede impactar 2 veces.');
insert into ataques values (0029,'lucha','Movimiento sísmico',01,00,02,'Daño = a nivel, afecta a fantasma');
insert into ataques values (0030,'lucha','Patada baja',04,03,03,'Si ataca primero y sale un 6 al impactar, el rival retrocede.');
insert into ataques values (0031,'lucha','Patada salto alta',05,08,07,'');
insert into ataques values (0032,'lucha','Sumisión',04,04,05,'Si ataca primero y sale un 6 al impactar, el rival retrocede.');

insert into ataques values (0033,'normal','Arañazo',02,02,00,'');
insert into ataques values (0034,'normal','Ataque arena',03,00,00,'+1 a la dificultad del rival para impactar.');
insert into ataques values (0035,'normal','Ataque rápido',02,02,02,'Si se decide utilizar este ataque se ataca primero.');
insert into ataques values (0036,'normal','Autodestrucción',01,15,03,'Atacante debilitado tras su uso,solo para: voltorb + ev, geodude + ev, koffing +ev.');
insert into ataques values (0037,'normal','Cabezazo',04,09,06,'Ataque de 2 turnos, el primero se prepara el segundo ataca.');
insert into ataques values (0038,'normal','Canto',04,00,03,'Duerme al rival, solo para: clefairy + ev, Jigglypuff + ev, Chansey y Lapras.');
insert into ataques values (0039,'normal','Cornada',03,04,05,'');
insert into ataques values (0040,'normal','Corte',03,03,03,'');
insert into ataques values (0041,'normal','Cuchillada',03,04,05,'+1 al ataque solo durante este ataque, no se acumula.');
insert into ataques values (0042,'normal','Danza espada',00,00,02,'+2 al daño acumulable.');
insert into ataques values (0043,'normal','Derribo',04,07,05,'El atacante recibe su nivel en daño al hacer el ataque.');
insert into ataques values (0044,'normal','Doble filo',03,08,07,'El atacante recibe su nivel en daño al hacer el ataque.');
insert into ataques values (0045,'normal','Foco Energia',00,00,03,'+1 al ataque acumulable.');
insert into ataques values (0046,'normal','Golpe cuerpo',03,04,06,'Si sale un 6, paraliza.');
insert into ataques values (0047,'normal','Hipercolmillo',04,04,05,'Si ataca primero y en impactar sale un 6, el rival retrocede.');
insert into ataques values (0048,'normal','Hiperrayo',04,10,07,'Ataque de 2 turnos, el primero realiza el ataque y al segundo se recupera.');
insert into ataques values (0049,'normal','Chirrido',04,00,03,'-1 defensa al rival.');
insert into ataques values (0050,'normal','Mordisco',03,03,03,'Si ataca primero y en impactar sale un 6, el rival retrocede');
insert into ataques values (0051,'normal','Perforador',06,99,06,'No afecta a pokemon con velocidad superior al atacante');
insert into ataques values (0052,'normal','Placaje',02,02,00,'');
insert into ataques values (0053,'normal','Rapidez',00,03,03,'Afecta a Excavar y a Vuelo');
insert into ataques values (0054,'normal','Recuperación',00,00,05,' Recupera la mitad de sus ps redondeando hacia arriba');
insert into ataques values (0055,'normal','Rizo defensa',00,00,03,'+1 a la defensa');
insert into ataques values (0056,'normal','Salpicadura',00,00,00,'No ocurre nada');
insert into ataques values (0057,'normal','Supersónico',04,00,03,'Confunde al rival');
insert into ataques values (0058,'normal','Tornado',02,02,00,'');
insert into ataques values (0059,'normal','Transformación',00,00,00,' El pokémon pasa a ser una copia del enemigo.');

insert into ataques values (0060,'planta','Látigo cepa',02,02,02,'');
insert into ataques values (0061,'planta','Hoja afilada',03,03,03,'');
insert into ataques values (0062,'planta','Rayo solar',03,08,07,' Ataque de 2 turnos, el primero se prepara y al segundo se realiza el ataque.');
insert into ataques values (0063,'planta','Megaagotar',03,03,05,' Recupera la mitad del daño realizado.');
insert into ataques values (0064,'planta','Somnífero',04,00,03,'Duerme al rival');
insert into ataques values (0065,'planta','Paralizador',03,00,03,'Paraliza al rival');

insert into ataques values (0066,'psíquico','Psicorrayo',03,04,05,'Si sale un 6, confunde al rival.');
insert into ataques values (0067,'psíquico','Come sueños',03,08,06,' Solo se puede realizar el ataque si el rival está dormido. Recupera la mitad del daño causado.');
insert into ataques values (0068,'psíquico','Confusión',03,03,03,'Si sale un 6, confunde al rival.');
insert into ataques values (0069,'psíquico','Hipnosis',04,00,03,'Duerme al al rival.');
insert into ataques values (0070,'psíquico','Descanso',00,00,04,'Recuperas toda la vida, pero duermes durante 2 turnos.');
insert into ataques values (0071,'psíquico','Psíquico',03,06,07,'Si sale 6 en impacto y se realiza ataque crítico, baja en 1 la defensa del rival.');
insert into ataques values (0072,'psíquico','Teletransporte',00,00,02,'Huyes del combate apareciendo en la última ciudad visitada');

insert into ataques values (0073,'roca','Avalancha',03,03,03,'');
insert into ataques values (0074,'roca','Lanzarrocas',03,04,05,'');

insert into ataques values (0075,'tierra','Excavar',03,05,05,'2 turnos, el primero excava, es invulnerable menos por terremoto (doble de daño) y el segundo ataca.');
insert into ataques values (0076,'tierra','Fisura',06,99,06,' Golpe fulminante, pero no afecta a Pokémon cuya velocidad sea superior a la del usuario.');
insert into ataques values (0077,'tierra','Terremoto',03,08,08,'');

insert into ataques values (0078,'veneno','Picotazo venenoso',02,01,02,'Con 5 o + en el impacto, envenena al rival');
insert into ataques values (0079,'veneno','Tóxico',04,00,03,'Envenena al rival');
insert into ataques values (0080,'veneno','Polución',03,02,03,'Con 5 o + en el impacto, envenena al rival');
insert into ataques values (0081,'veneno','Ácido',03,03,04,'Si sale 6 en impacto y se realiza ataque crítico, baja en 1 la defensa del rival.');

insert into ataques values (0082,'volador','Ataque ala',03,03,03,'');
insert into ataques values (0083,'volador','Picotazo',02,02,02,'');
insert into ataques values (0084,'volador','Vuelo',03,04,05,'En 2 turnos, el 1º vuela, se vuelve invulnerable menos por transformación y rapidez y el 2º ataca.');
insert into ataques values (0085,'volador','Pico taladro',03,04,05,'');
insert into ataques values (0086,'volador','Ataque aéreo',04,10,07,'Ataque de 2 turnos, el primero lo prepara y al segundo realiza el ataque.');

insert into ataques values (0087,'dragón','Furia dragón',03,07,03,'Siempre quita 7 independientemente de modificadores.');



