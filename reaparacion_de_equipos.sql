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

Drop table if exists ClienteServicio;
Create table ClienteServicio (
	idCliente int not null,
    idServicio int not null
);

Drop table if exists Servicio;
Create table Servicio (
	id int primary key not null auto_increment,
    fecha datetime not null,
    notas varchar(20) not null
);

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

Drop table if exists Detaller;
Create table DeTaller (
	idEmpleado int primary key not null,
    senior boolean not null
);

Alter table DeTaller add foreign key (idEmpleado) references Empleado(id);

Drop table if exists Repartidor;
Create table Repartidor (
	idEmpleado int primary key not null
);

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
    despachado boolean not null,
    radioDeReparto int not null,
    precioTotal double not null,
    coste double not null,
    lugar varchar(20) not null
);

Alter table EnvioRepartidor add foreign key (idRepartidor) references Repartidor(idEmpleado),
add foreign key (idEnvio) references Envio(id),
add primary key (idEnvio, idRepartidor);

Drop table if exists Sustituto;
Create table Sustituto (
	idEmpleado int primary key not null,
    edad char(3) not null,
    exclusionSocial boolean not null,
    baja int not null
);

Drop table if exists Baja;
Create table Baja (
	id int primary key not null auto_increment,
    fechaInicio datetime not null,
    fechaFin datetime,
    motivo varchar(50) not null
);

Alter table Sustituto add foreign key (baja) references Baja(id);
    