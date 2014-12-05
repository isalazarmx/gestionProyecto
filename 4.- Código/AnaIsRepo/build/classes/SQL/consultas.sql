
descselect auto_increment from information_schema.tables where table_schema='poscakeapp' and table_name='categoria';
desc categoria;
select * from categoria;
SELECT IDCATEGORIA,NOMBRE FROM CATEGORIA WHERE TIPOPRODUCTO = 3;
desc proveedor;
DESC PRODUCTO;
SELECT * FROM CATEGORIA WHERE TIPOPRODUCTO = 3 AND ELIMINADO != 0;
select * from producto;

SELECT P.`idProveedor`, P.nombre,P.`aPaterno`,PPP.`idProducto`,PPP.nombre,C.nombre
FROM PROVEEDOR P
JOIN PROVEEDOR_HAS_PRODUCTO PP
ON (P.`idProveedor`=PP.`Proveedor_idProveedor`)
JOIN PRODUCTO PPP
ON (PP.`Producto_idProducto`=PPP.`idProducto`)
JOIN CATEGORIA C
ON (PP.`Producto_Categoria_idCategoria`=C.`idCategoria`)
ORDER BY 4;

select * from proveedor order by nombre;
select idproducto,nombre,format(cantidad,0)as cantidad,preciocompra,precioventa,concat('$ ',format(((precioventa-preciocompra)*cantidad),2)) as ganancia from producto where eliminado != 1;
SELECT IDPROVEEDOR, NOMBRE, APATERNO FROM PROVEEDOR WHERE ELIMINADO !=1 ORDER BY NOMBRE;

SELECT PPP.`idProveedor`,PPP.nombre,PPP.`aPaterno`,P.`idProducto`,P.nombre,FORMAT(P.cantidad,0) AS CANTIDAD,P.`precioCompra`,P.`precioVenta`, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA 
FROM PROVEEDOR PPP
JOIN PROVEEDOR_HAS_PRODUCTO PP
ON (PPP.`idProveedor`=PP.`Proveedor_idProveedor`)
JOIN producto P
ON(PP.`Producto_idProducto`=P.`idProducto`);