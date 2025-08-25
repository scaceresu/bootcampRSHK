package x4mv.enlace;

public class Consultas {

    String query1 = "SELECT \n" + //
                                "    c.id AS cliente_id,\n" + //
                                "    c.nombre AS cliente_nombre,\n" + //
                                "    COUNT(f.id) AS cantidad_facturas\n" + //
                                "FROM cliente c\n" + //
                                "JOIN factura f ON f.cliente_id = c.id\n" + //
                                "GROUP BY c.id, c.nombre\n" + //
                                "ORDER BY cantidad_facturas DESC\n" + //
                                "LIMIT 10;";

    String query2 = "SELECT \n" + //
                "    c.id AS cliente_id,\n" + //
                "    c.nombre AS cliente,\n" + //
                "    SUM(fd.cantidad * p.precio) AS total_gastado\n" + //
                "FROM cliente c\n" + //
                "JOIN factura f ON f.cliente_id = c.id\n" + //
                "JOIN factura_detalle fd ON fd.factura_id = f.id\n" + //
                "JOIN producto p ON p.id = fd.producto_id\n" + //
                "GROUP BY c.id, c.nombre\n" + //
                "ORDER BY total_gastado DESC\n" + //
                "LIMIT 10;" ;
    
    String query3 = "SELECT \n" + //
                "    m.id AS moneda_id,\n" + //
                "    m.nombre AS moneda,\n" + //
                "    COUNT(f.id) AS cantidad_facturas\n" + //
                "FROM factura f\n" + //
                "JOIN moneda m ON m.id = f.moneda_id\n" + //
                "GROUP BY m.id, m.nombre\n" + //
                "ORDER BY cantidad_facturas DESC\n" + //
                "LIMIT 10;";
    
    String query4 = "SELECT \n" + //
                "    pr.id AS proveedor_id,\n" + //
                "    pr.nombre AS proveedor,\n" + //
                "    SUM(fd.cantidad * p.precio) AS total_vendido\n" + //
                "FROM proveedor pr\n" + //
                "JOIN producto p ON p.proveedor_id = pr.id\n" + //
                "JOIN factura_detalle fd ON fd.producto_id = p.id\n" + //
                "JOIN factura f ON f.id = fd.factura_id\n" + //
                "GROUP BY pr.id, pr.nombre\n" + //
                "ORDER BY total_vendido DESC\n" + //
                "LIMIT 10;\n" + //
                "";

    String query5 = "SELECT \n" + //
                "    p.id AS producto_id,\n" + //
                "    p.nombre AS producto,\n" + //
                "    SUM(fd.cantidad) AS total_vendido\n" + //
                "FROM producto p\n" + //
                "JOIN factura_detalle fd ON fd.producto_id = p.id\n" + //
                "GROUP BY p.id, p.nombre\n" + //
                "ORDER BY total_vendido DESC\n" + //
                "LIMIT 10;";
    
    String query6 = "SELECT \n" + //
                "    p.id AS producto_id,\n" + //
                "    p.nombre AS producto,\n" + //
                "    SUM(fd.cantidad) AS total_vendido\n" + //
                "FROM producto p\n" + //
                "LEFT JOIN factura_detalle fd ON fd.producto_id = p.id\n" + //
                "GROUP BY p.id, p.nombre\n" + //
                "ORDER BY total_vendido ASC\n" + //
                "LIMIT 10;";

    String query7 = "SELECT \n" + //
                "    f.fecha_emision,\n" + //
                "    c.nombre AS nombre_cliente,\n" + //
                "    c.apellido AS apellido_cliente,\n" + //
                "    p.nombre AS producto,\n" + //
                "    fd.cantidad,\n" + //
                "    ft.nombre AS tipo_factura\n" + //
                "FROM factura f\n" + //
                "JOIN cliente c ON c.id = f.cliente_id\n" + //
                "JOIN factura_tipo ft ON ft.id = f.id\n" + //
                "JOIN factura_detalle fd ON fd.factura_id = f.id\n" + //
                "JOIN producto p ON p.id = fd.producto_id\n" + //
                "WHERE f.id = 1;  ";

    String query8 = "SELECT \n" + //
                "    f.id AS factura_id,\n" + //
                "    f.fecha_emision,\n" + //
                "    SUM(fd.cantidad * p.precio) AS total_factura\n" + //
                "FROM factura f\n" + //
                "JOIN factura_detalle fd ON fd.factura_id = f.id\n" + //
                "JOIN producto p ON p.id = fd.producto_id\n" + //
                "GROUP BY f.id, f.fecha_emision\n" + //
                "ORDER BY total_factura DESC;\n" + //
                "";
    
    String query9 = "SELECT \n" + //
                "    f.id AS factura_id,\n" + //
                "    f.fecha_emision,\n" + //
                "    SUM(fd.cantidad * p.precio) AS total_factura,\n" + //
                "    SUM(fd.cantidad * p.precio) * 0.10 AS iva_10\n" + //
                "FROM factura f\n" + //
                "JOIN factura_detalle fd ON fd.factura_id = f.id\n" + //
                "JOIN producto p ON p.id = fd.producto_id\n" + //
                "GROUP BY f.id, f.fecha_emision\n" + //
                "ORDER BY total_factura DESC;";


    Consultas(){

    }
    
}
