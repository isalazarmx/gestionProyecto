/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelProducto;
import Model.ModelVenta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nel
 */
public class DataBaseVenta 
{
    public static List buscaVentas(){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery="SELECT P.`idProducto` AS CODIGO,P.nombre AS ARTICULO,V.`tipoVenta`AS TIPOVENTA,V.`unidadesVendidas` AS CANTIDAD,P.`precioVenta` AS PRECIO,V.abono AS ABONO,V.resto AS RESTO,V.`precioTotal` AS IMPORTE \n" +
                            "FROM VENTA V\n" +
                            "JOIN PRODUCTO P\n" +
                            "ON (V.PRODUCTO_IDPRODUCTO=P.IDPRODUCTO);";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                List listTemp = new ArrayList<>();
                listTemp.add(res.getString("CODIGO"));
                listTemp.add(res.getString("ARTICULO"));
                listTemp.add(res.getInt("TIPOVENTA"));
                listTemp.add(res.getInt("CANTIDAD"));
                listTemp.add(res.getDouble("PRECIO"));
                listTemp.add(res.getDouble("ABONO"));
                listTemp.add(res.getDouble("RESTO"));
                listTemp.add(res.getDouble("IMPORTE"));
                list.add(listTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public static double buscaCantidadGanada(){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        double temp = 0;
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select sum(preciototal) as precio from venta;";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                temp = res.getDouble("precio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
    public static List buscaPorProveedor(int idproveedor, boolean tipoCategoria){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery;
            if(tipoCategoria)
                strQuery = "SELECT PPP.`idProveedor`,P.`idProducto`,P.nombre,FORMAT(P.cantidad,0) AS CANTIDAD,P.`precioCompra`,P.`precioVenta`, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA \n" +
                            "FROM PROVEEDOR PPP\n" +
                            "JOIN PROVEEDOR_HAS_PRODUCTO PP\n" +
                            "ON (PPP.`idProveedor`=PP.`Proveedor_idProveedor`)\n" +
                            "JOIN producto P\n" +
                            "ON(PP.`Producto_idProducto`=P.`idProducto`)\n" +
                            "WHERE PPP.`idProveedor`="+idproveedor+" AND P.`tipoProducto`=3;";
            else
                strQuery = "SELECT PPP.`idProveedor`,P.`idProducto`,P.nombre,FORMAT(P.cantidad,0) AS CANTIDAD,P.`precioCompra`,P.`precioVenta`, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA \n" +
                            "FROM PROVEEDOR PPP\n" +
                            "JOIN PROVEEDOR_HAS_PRODUCTO PP\n" +
                            "ON (PPP.`idProveedor`=PP.`Proveedor_idProveedor`)\n" +
                            "JOIN producto P\n" +
                            "ON(PP.`Producto_idProducto`=P.`idProducto`)\n" +
                            "WHERE PPP.`idProveedor`="+idproveedor+" AND P.`tipoProducto`=2;";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                List model = new ArrayList<>();
                model.add(res.getString("IDPRODUCTO"));
                model.add(res.getString("NOMBRE"));
                model.add(res.getString("CANTIDAD"));
                model.add(res.getString("PRECIOCOMPRA"));
                model.add(res.getString("PRECIOVENTA"));
                model.add(res.getString("GANANCIA"));
                list.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public static List buscaTotal(boolean tipoCategoria){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery;
            if(tipoCategoria)
                strQuery = "SELECT IDPRODUCTO,NOMBRE,FORMAT(CANTIDAD,0) AS CANTIDAD,TIPOUNIDAD,PRECIOCOMPRA,PRECIOVENTA, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA FROM PRODUCTO WHERE TIPOPRODUCTO = 3 AND ELIMINADO != 1 ORDER BY NOMBRE;";
            else
                strQuery = "SELECT IDPRODUCTO,NOMBRE,FORMAT(CANTIDAD,0) AS CANTIDAD,TIPOUNIDAD,PRECIOCOMPRA,PRECIOVENTA, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA FROM PRODUCTO WHERE TIPOPRODUCTO = 2 AND ELIMINADO != 1 ORDER BY NOMBRE;";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                List model = new ArrayList<>();
                model.add(res.getString("IDPRODUCTO"));
                model.add(res.getString("NOMBRE"));
                model.add(res.getString("CANTIDAD"));
                model.add(res.getString("PRECIOCOMPRA"));
                model.add(res.getString("PRECIOVENTA"));
                model.add(res.getString("GANANCIA"));
                list.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    private static ModelVenta creaModelo(ResultSet res){
        ModelVenta model = new ModelVenta();
        try {
            model.setIdProducto(res.getString("idProducto"));
            model.setTipoVenta(res.getInt("TIPOVENTA"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public static boolean checkExistProducto(String id){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "SELECT IDPRODUCTO FROM PRODUCTO WHERE IDPRODUCTO='"+id+"' AND ELIMINADO != 1;";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next())
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flag;
    }
    
    public static boolean addVenta(List<ModelVenta> model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            for (int i = 0; i < model.size(); i++) {
                Statement sta = conn.createStatement();
                ModelVenta modelTemp = model.get(i);
                String strQuery = "INSERT INTO venta"
+ "(FECHAENTREGA,KILOS,UNIDADESVENDIDAS,ABONO,RESTO,PRECIOTOTAL,ENTREGADO,ELIMINADO,DESCRIPCION,TIPOVENTA,USUARIO_IDUSUARIO,CLIENTE_IDCLIENTE,PRODUCTO_IDPRODUCTO) values "
+ "('"+modelTemp.getFechaEntrega()+"',"+modelTemp.getKilos()+","+modelTemp.getUnidadesVendidas()+","+modelTemp.getAbono()+","+modelTemp.getResto()+","+modelTemp.getPrecioTotal()+","+modelTemp.isEntregado()+",0,'"+modelTemp.getDescripcion()+"',"+modelTemp.getTipoVenta()+","+modelTemp.getIdUsuario()+","+modelTemp.getIdCliente()+",'"+modelTemp.getIdProducto()+"');";
                sta.executeUpdate(strQuery);
            }
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flag;
    }    
    
    public static boolean modificaProducto(ModelProducto model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            String strQuery = "UPDATE PRODUCTO SET IDPRODUCTO=?,NOMBRE=?,CANTIDAD=?,TIPOUNIDAD=?,PRECIOKILO=?,UNIDADEXISTENCIA=?,MINSTOCK=?,MAXSTOCK=?,PRECIOCOMPRA=?,INCREMENTOVENTA=?,PRECIOVENTA=?,IMAGE=?,TIPOPRODUCTO=?,EMPRESA_IDEMPRESA=?,CATEGORIA_IDCATEGORIA=? WHERE IDPRODUCTO='"+model.getIdProducto()+"';";
            PreparedStatement ps = conn.prepareStatement(strQuery);
            ps.setString(1,model.getIdProducto());
            ps.setString(2,model.getNombre());
            ps.setDouble(3,model.getCantidad());
            ps.setString(4,model.getTipoUnidad());
            ps.setDouble(5,model.getPrecioKilo());
            ps.setInt(6,model.getUnidadExistencia());
            ps.setInt(7,model.getMinStock());
            ps.setInt(8,model.getMaxStock());
            ps.setDouble(9,model.getPrecioCompra());
            ps.setDouble(10,model.getIncrementoVenta());
            ps.setDouble(11,model.getPrecioVenta());
            try {
                if(model.getRutaImagen()!=null)
                    ps.setBinaryStream(12,new FileInputStream(model.getRutaImagen()),(int)model.getRutaImagen().length());
                else
                    ps.setBlob(12,model.getImagen());
            } catch (FileNotFoundException ex) {
                ps.setBinaryStream(12, null);
            }
            ps.setInt(13,model.getTipoProducto());
            ps.setInt(14,model.getEmprsa_idempresa());
            ps.setInt(15,model.getCategoria_idcategoria());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flag;
    }    
    
    public static boolean eliminaProducto(String idProducto){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            String strQuery = "UPDATE PRODUCTO SET ELIMINADO = ? WHERE IDPRODUCTO='"+idProducto+"';";
            PreparedStatement ps = conn.prepareStatement(strQuery);
            ps.setInt(1,1);
            ps.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flag;
    }    
}
