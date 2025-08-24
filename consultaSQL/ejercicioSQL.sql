-- #1 devolver la cantidad de clientes con mayor facturas

SELECT 
    c.id AS cliente_id,
    c.nombre AS cliente_nombre,
    COUNT(f.id) AS cantidad_facturas
FROM cliente c
JOIN factura f ON f.cliente_id = c.id
GROUP BY c.id, c.nombre
ORDER BY cantidad_facturas DESC
LIMIT 10;

-- #2 devolver top clientes que mas gastaron  
SELECT 
    c.id AS cliente_id,
    c.nombre AS cliente,
    SUM(fd.cantidad * p.precio) AS total_gastado
FROM cliente c
JOIN factura f ON f.cliente_id = c.id
JOIN factura_detalle fd ON fd.factura_id = f.id
JOIN producto p ON p.id = fd.producto_id
GROUP BY c.id, c.nombre
ORDER BY total_gastado DESC
LIMIT 10;

-- #3 Devolver las monedas mas utilizadas 

SELECT 
    m.id AS moneda_id,
    m.nombre AS moneda,
    COUNT(f.id) AS cantidad_facturas
FROM factura f
JOIN moneda m ON m.id = f.moneda_id
GROUP BY m.id, m.nombre
ORDER BY cantidad_facturas DESC
LIMIT 10;

-- #4 Devolver los proveedores de productos

SELECT 
    pr.id AS proveedor_id,
    pr.nombre AS proveedor,
    SUM(fd.cantidad * p.precio) AS total_vendido
FROM proveedor pr
JOIN producto p ON p.proveedor_id = pr.id
JOIN factura_detalle fd ON fd.producto_id = p.id
JOIN factura f ON f.id = fd.factura_id
GROUP BY pr.id, pr.nombre
ORDER BY total_vendido DESC
LIMIT 10;



-- #5 Devolver los productos mas vendidos
SELECT 
    p.id AS producto_id,
    p.nombre AS producto,
    SUM(fd.cantidad) AS total_vendido
FROM producto p
JOIN factura_detalle fd ON fd.producto_id = p.id
GROUP BY p.id, p.nombre
ORDER BY total_vendido DESC
LIMIT 10;

-- #6 Los productos menos venidos

SELECT 
    p.id AS producto_id,
    p.nombre AS producto,
    SUM(fd.cantidad) AS total_vendido
FROM producto p
LEFT JOIN factura_detalle fd ON fd.producto_id = p.id
GROUP BY p.id, p.nombre
ORDER BY total_vendido ASC
LIMIT 10;

-- #7 Consultar por una factura en especifico

SELECT 
    f.fecha_emision,
    c.nombre AS nombre_cliente,
    c.apellido AS apellido_cliente,
    p.nombre AS producto,
    fd.cantidad,
    ft.nombre AS tipo_factura
FROM factura f
JOIN cliente c ON c.id = f.cliente_id
JOIN factura_tipo ft ON ft.id = f.id
JOIN factura_detalle fd ON fd.factura_id = f.id
JOIN producto p ON p.id = fd.producto_id
WHERE f.id = 1;  

-- #8 mostrar las facturas ordenadas segun totales

SELECT 
    f.id AS factura_id,
    f.fecha_emision,
    SUM(fd.cantidad * p.precio) AS total_factura
FROM factura f
JOIN factura_detalle fd ON fd.factura_id = f.id
JOIN producto p ON p.id = fd.producto_id
GROUP BY f.id, f.fecha_emision
ORDER BY total_factura DESC;

-- #9 mostrar el iva10% de los monttos totales 

SELECT 
    f.id AS factura_id,
    f.fecha_emision,
    SUM(fd.cantidad * p.precio) AS total_factura,
    SUM(fd.cantidad * p.precio) * 0.10 AS iva_10
FROM factura f
JOIN factura_detalle fd ON fd.factura_id = f.id
JOIN producto p ON p.id = fd.producto_id
GROUP BY f.id, f.fecha_emision
ORDER BY total_factura DESC;
