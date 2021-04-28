DROP DATABASE IF EXISTS Reparacion_Equipos;
CREATE DATABASE Reparacion_Equipos;
USE Reparacion_Equipos;

Drop table if exists Cliente;
Create table Cliente (
	id int primary key not null auto_increment,
    nombre varchar(20) not null,
    nif char(9) unique not null,
    direccion varchar(50) not null,
    telefono char(9) not null,
    tarjetaDeCredito char(9) not null,
    cuentaCorriente char(11) not null
);

Insert into Cliente Values
(default , "Pepe", "74638264T", "C-Los Santos 34 5ºA", "608347586", "874639872", "ES874938376"),
(default , "Juan", "84756292G", "C-San Lorenzo 24 15ºC", "654783223", "498398578", "ES754834721"),
(default , "Aitor", "56748302F", "C-Marques de valdecilla 12 3ºD", "758694830", "567483980", "ES887499823");

Drop table if exists ClienteServicio;
Create table ClienteServicio (
	idCliente int not null,
    idServicio int not null
);

Insert into ClienteServicio Values
(1, 1),
(1, 3),
(2, 2),
(2, 1),
(3, 3);

Drop table if exists Servicio;
Create table Servicio (
	id int primary key not null auto_increment,
    fecha date not null,
    notas varchar(100) not null
);

Insert into Servicio values
(default, "2020-12-12", "El servicio se realizo con exito"),
(default, "2020-11-22", "El servicio se realizo con exito"),
(default, "2020-10-25", "El servicio se realizo con exito");

Alter table ClienteServicio add primary key (idCliente, idServicio),
add foreign key (idCliente) references Cliente(id),
add foreign key (idServicio) references Servicio(id);

Drop table if exists Compra;
Create table Compra (
	id int primary key not null auto_increment,
    precioTotal double not null,
    equipo int not null
);

Drop table if exists Equipo;
Create table Equipo (
	id int primary key not null auto_increment,
    precio double not null,
    modelo varchar(20) not null,
    lote int not null
);

Alter table Compra add foreign key (equipo) references equipo(id);

Drop table if exists Lote;
Create table Lote (
	id int primary key not null auto_increment,
    descuento int not null
);

Insert into Lote values
(default, 10),
(default, 25),
(default, 50);

Insert into Equipo values
(default, 244.99, "Equipo 1", 1),
(default, 399.99, "Equipo 2", 2),
(default, 495.49, "Equipo 3", 3);

Alter table Equipo add foreign key (lote) references Lote(id);

Drop table if exists Mantenimiento;
Create table Mantenimiento (
	id int primary key not null auto_increment,
    horasTrabajadas int not null
);

Alter table Mantenimiento add foreign key (id) references Servicio(id);

Drop table if exists Reparacion;
Create table Reparacion (
	id int primary key not null auto_increment,
    duraciontotal int not null,
    mantenimiento int not null,
    grupo int not null
);

Drop table if exists Grupo;
Create table Grupo (
	id int primary key not null auto_increment
);

Alter table Reparacion add foreign key (mantenimiento) references Mantenimiento(id),
add foreign key (grupo) references Grupo(id);

Drop table if exists Empleado;
Create table Empleado (
	id int primary key not null auto_increment,
    nombre varchar(20) not null,
    telefono char(9) not null,
    nif char(9) not null unique,
    apellido varchar(20) not null,
    direccion varchar(50) not null
);

Insert into Empleado values
(1, "JoseManuel", "785904034", "78594834Y", "Ramirez", "C\\Los Santos 23 4ºA"),
(2, "Eustaquio", "765889239", "56749823R", "Fernandez", "C\\Los Santos 45 3ºC"),
(3, "Federico", "657387298", "87498923G", "Garcia", "C\\Menendez Pelayo 3 3ºC"),
(4, "Rigoberta", "897869589", "34873892F", "Diaz", "C\\San Lorenzo 15 4ºA"),
(5, "Anastasia", "567388298", "64538723H", "Larios", "C\\Los Santos 34 10ºC"),
(6, "Susana", "756498231", "76583934R", "Diaz", "C\\Los Santos 23 5ºD"),
(7, "Federica", "875983847", "92837461J", "Lopez", "C\\San Lorenzo 13 3ºC"),
(8, "Fernando", "765874938", "64830289N", "Gomez", "C\\Los Santos 23 4ºD"),
(9, "Beatriz", "874590873", "74628712U", "Garcia", "C\\Los Santos 12 7ºD"),
(10, "Anastasia", "874875908", "12345678I", "Gomez", "C\\Menendez Pelayo 5 3ºA");

Drop table if exists Detaller;
Create table DeTaller (
	idEmpleado int primary key not null,
    senior boolean not null
);

Insert into Detaller values
(1, false),
(2, false),
(3, false);

Alter table DeTaller add foreign key (idEmpleado) references Empleado(id);

Drop table if exists Repartidor;
Create table Repartidor (
	idEmpleado int primary key not null
);

Insert into Repartidor values
(4),
(5),
(6);

Alter table Repartidor add foreign key (idEmpleado) references Empleado(id);

Drop table if exists EnvioRepartidor;
Create table EnvioRepartidor (
	idEnvio int not null,
    idRepartidor int not null
);

Drop table if exists Envio;
Create table Envio (
	id int primary key not null auto_increment,
    fechaDeSalida datetime not null,
    radioDeReparto int not null,
    precioTotal double not null,
    coste double not null,
    lugar varchar(20) not null
);

Alter table EnvioRepartidor add foreign key (idRepartidor) references Repartidor(idEmpleado),
add foreign key (idEnvio) references Envio(id),
add primary key (idEnvio, idRepartidor);

Insert into Envio values
(default, "2020-07-22", 20, 40.00, 20.00, "C-Los olmos 23");

Insert into EnvioRepartidor values
(1, 4),
(1, 5),
(1, 6);

Drop table if exists Sustituto;
Create table Sustituto (
	idEmpleado int primary key not null,
    edad char(3) not null,
    exclusionSocial boolean not null,
    baja int
);

Drop table if exists Baja;
Create table Baja (
	id int primary key not null auto_increment,
    fechaInicio datetime not null,
    fechaFin datetime,
    motivo varchar(50) not null
);

Alter table Sustituto add foreign key (baja) references Baja(id);

Insert into Baja values
(default, "2020-10-12", "2020-12-05", "Cuarentena por coronavirus"),
(default, "2020-05-23", "2020-09-16", "Ruptura de brazo"),
(default, "2020-09-04", "2021-01-25", "Fisura de muñeca");

Insert into Sustituto values
(7, 28, false, 1),
(8, 35, false, 2),
(9, 32, false, 3),
(10, 25, false, null);