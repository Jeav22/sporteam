
create table partido(
id serial not null,
ubicacion varchar(30) not null,
fecha date not null,
equipo1 varchar(30) not null,
equipo2 varchar(30) not null,
marcadorequipo1 int,
marcadorequipo2 int,
apuesta int,
primary key(id)
);

create table evento(
id serial not null,
fecha date not null,
limite int not null,
tipo varchar(30) not null,
descripcion varchar(150) not null,
direccion varchar(30) not null,
primary key(id)
);

create table usuario(
id serial not null,
nombre varchar(30) not null,
correo varchar(30) not null,
contrasena varchar(30) not null,
celular varchar(30) not null,
noIdentificacion int not null,
primary key(id)
);

create table apuesta(
id serial not null,
valor int not null,
equipo varchar(30) not null,
id_partido int not null,
id_usuario int not null,
primary key(id),
foreign key(id_partido) references partido (id),
foreign key(id_usuario) references usuario (id)
);


create table jugadores(
id_partido int,
id_usuario int,
foreign key(id_partido) references partido (id),
foreign key(id_usuario) references usuario (id)
);

create table participantes(
id_evento int,
id_usuario int,
foreign key(id_evento) references evento (id),
foreign key(id_usuario) references usuario (id)
);


insert into partido(ubicacion, fecha, equipo1, equipo2, marcadorequipo1, marcadorequipo2) values('Canchas la bolera','2018-03-20','Aguilas','Perros',2,1);

insert into evento(tipo, fecha, descripcion, direccion, limite) values('Cucapatada',now(), 'Cucapatada todos contra todos', 'Canchas la bolera',15);

insert into usuario(nombre, celular, correo, contrasena, noIdentificacion) values('Nicolas Chicuazuque', '3113331113', 'nicolas@mail.com', '1234', 123456789);
insert into usuario(nombre, celular, correo, contrasena, noIdentificacion) values('Andres Felipe', '3004442224', 'felipe@mail.com', '1234', 234567891);
insert into usuario(nombre, celular, correo, contrasena, noIdentificacion) values('Jorge Eduardo', '3023592109', 'jorge@mail.com', '1234', 345678912);

insert into apuesta(valor, equipo, id_partido, id_usuario) values(23000, 'Aguilas', 1, 3);

insert into jugadores(id_partido, id_usuario) values (1, 1);
insert into jugadores(id_partido, id_usuario) values (1, 2);

insert into participantes(id_evento, id_usuario) values(1, 1);
insert into participantes(id_evento, id_usuario) values(1, 2);
insert into participantes(id_evento, id_usuario) values(1, 3);
