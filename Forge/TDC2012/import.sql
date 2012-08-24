INSERT INTO  UnidadeFederativa (nome, sigla, version, id) values ('Santa Catarina', 'SC', 0, 1);
INSERT INTO  Cidade (estado_id, nome, version, id) values (1, 'Joinville', 0, 1);
INSERT INTO  Cidade (estado_id, nome, version, id) values (1,'Florianópolis', 0, 2);
INSERT INTO  UnidadeFederativa (nome, sigla, version, id) values ('Paraná','PR', 0, 2);
INSERT INTO  Cidade (estado_id, nome, version, id) values (2, 'Curitiba', 0, 3);
INSERT INTO  Cidade (estado_id, nome, version, id) values (2, 'Cascavel', 0, 4);

call next value for hibernate_sequence;
call next value for hibernate_sequence;
call next value for hibernate_sequence;
call next value for hibernate_sequence;
call next value for hibernate_sequence;
call next value for hibernate_sequence;