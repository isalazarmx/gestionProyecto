
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