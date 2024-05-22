CREATE TABLE tb_usuario (
id_usuario serial primary key,
Nombre varchar (80),
Correo varchar (50),
Pass varchar (50)
)

SELECT * FROM tb_usuario

------------------------------------

CREATE TABLE tb_proveedor (
id_proveedor serial primary key,
Nombre_Proveedor varchar (100),
Apellido_Proveedor varchar (100),
cedula integer,
Telefono integer,
)

SELECT * FROM tb_proveedor

-------------------------------------

CREATE TABLE tb_productos (
id_productos serial primary key,
Cod_Barras varchar (100),
Nombre_Producto varchar (100),
Proveedor varchar (100),
Stock integer,
Precio decimal (12,2),
Fecha date default (current_timestamp)
)

SELECT * FROM tb_productos

-------------------------------------

CREATE TABLE tb_detalle (
id_detalle serial primary key,
Cod_Producto integer,
Cantidad integer,
Precio decimal (10,2),
id_venta integer
)

SELECT * FROM tb_detalle
-----------------------------------------

CREATE TABLE tb_ventas (
id_ventas serial primary key,
Cliente varchar (100),
Vendedor varchar (100),
Total decimal (10,2),
Fecha date default (current_timestamp)
)

SELECT * FROM tb_ventas

-----------------------------------------

CREATE TABLE tb_config (
id_config serial primary key,
Nombre varchar (100),
Ruc varchar (80),
Telefono integer,
Direccion varchar (80),
Razon varchar (100)
)

SELECT * FROM tb_config
