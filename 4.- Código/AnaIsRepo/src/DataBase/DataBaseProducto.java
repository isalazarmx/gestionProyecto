/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelProducto;
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
public class DataBaseProducto 
{
    public static List<ModelProducto> buscaProductos(boolean tipoCategoria){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelProducto> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery;
            if(tipoCategoria)
                strQuery = "SELECT * FROM PRODUCTO WHERE TIPOPRODUCTO = 3 AND ELIMINADO != 1 ORDER BY NOMBRE;";
            else
                strQuery = "SELECT * FROM PRODUCTO WHERE TIPOPRODUCTO = 2 AND ELIMINADO != 1 ORDER BY NOMBRE;";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                ModelProducto model = creaModelo(res);
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
    
    public static List buscaPorCategoria(int idcategoria, boolean tipoCategoria){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery;
            if(tipoCategoria)
                strQuery = "SELECT IDPRODUCTO,NOMBRE,FORMAT(CANTIDAD,0) AS CANTIDAD,TIPOUNIDAD,PRECIOCOMPRA,PRECIOVENTA, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA FROM PRODUCTO WHERE TIPOPRODUCTO = 3 AND ELIMINADO != 1 AND CATEGORIA_IDCATEGORIA = "+idcategoria+" ORDER BY NOMBRE;";
            else
                strQuery = "SELECT IDPRODUCTO,NOMBRE,FORMAT(CANTIDAD,0),TIPOUNIDAD,PRECIOCOMPRA,PRECIOVENTA, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA FROM PRODUCTO WHERE TIPOPRODUCTO = 2 AND ELIMINADO != 1 AND CATEGORIA_IDCATEGORIA = "+idcategoria+" ORDER BY NOMBRE;";
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
                strQuery = "SELECT IDPRODUCTO,NOMBRE,FORMAT(CANTIDAD,0),TIPOUNIDAD,PRECIOCOMPRA,PRECIOVENTA, CONCAT('$ ',FORMAT(((PRECIOVENTA-PRECIOCOMPRA)*CANTIDAD),2)) AS GANANCIA FROM PRODUCTO WHERE TIPOPRODUCTO = 2 AND ELIMINADO != 1 ORDER BY NOMBRE;";
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
    
    private static ModelProducto creaModelo(ResultSet res){
        ModelProducto model = new ModelProducto();
        try {
            model.setIdProducto(res.getString("idProducto"));
            model.setNombre(res.getString("nombre"));
            model.setCantidad(res.getInt("cantidad"));
            model.setTipoUnidad(res.getString("tipoUnidad"));
            model.setUnidadExistencia(res.getInt("UnidadExistencia"));
            model.setMinStock(res.getInt("minStock"));
            model.setMaxStock(res.getInt("maxStock"));
            model.setPrecioCompra(res.getDouble("precioCompra"));
            model.setIncrementoVenta(res.getDouble("incrementoVenta"));
            model.setPrecioVenta(res.getDouble("precioVenta"));
            model.setImagen(res.getBlob("image"));
            model.setTipoProducto(res.getInt("tipoProducto"));
            model.setEmprsa_idempresa(res.getInt("empresa_idempresa"));
            model.setCategoria_idcategoria(res.getInt("categoria_idcategoria"));
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseProducto.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static boolean addProducto(ModelProducto model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            String strQuery = "INSERT INTO PRODUCTO (IDPRODUCTO,NOMBRE,CANTIDAD,TIPOUNIDAD,UNIDADEXISTENCIA,MINSTOCK,MAXSTOCK,PRECIOCOMPRA,INCREMENTOVENTA,PRECIOVENTA,IMAGE,TIPOPRODUCTO,EMPRESA_IDEMPRESA,CATEGORIA_IDCATEGORIA) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(strQuery);
            ps.setString(1,model.getIdProducto());
            ps.setString(2,model.getNombre());
            ps.setDouble(3,model.getCantidad());
            ps.setString(4,model.getTipoUnidad());
            ps.setInt(5,model.getUnidadExistencia());
            ps.setInt(6,model.getMinStock());
            ps.setInt(7,model.getMaxStock());
            ps.setDouble(8,model.getPrecioCompra());
            ps.setDouble(9,model.getIncrementoVenta());
                        ps.setDouble(10,model.getPrecioVenta());
            try {
                if(model.getRutaImagen() != null)
                    ps.setBinaryStream(11,new FileInputStream(model.getRutaImagen()),(int)model.getRutaImagen().length());
                else
                    ps.setBlob(11,model.getImagen());
            } catch (FileNotFoundException ex) {
                ps.setBinaryStream(11, null);
            }
            ps.setInt(12,model.getTipoProducto());
            ps.setInt(13,model.getEmprsa_idempresa());
            ps.setInt(14,model.getCategoria_idcategoria());
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
    
    public static boolean modificaProducto(ModelProducto model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            String strQuery = "UPDATE PRODUCTO SET IDPRODUCTO=?,NOMBRE=?,CANTIDAD=?,TIPOUNIDAD=?,UNIDADEXISTENCIA=?,MINSTOCK=?,MAXSTOCK=?,PRECIOCOMPRA=?,INCREMENTOVENTA=?,PRECIOVENTA=?,IMAGE=?,TIPOPRODUCTO=?,EMPRESA_IDEMPRESA=?,CATEGORIA_IDCATEGORIA=? WHERE IDPRODUCTO='"+model.getIdProducto()+"';";
            PreparedStatement ps = conn.prepareStatement(strQuery);
            ps.setString(1,model.getIdProducto());
            ps.setString(2,model.getNombre());
            ps.setDouble(3,model.getCantidad());
            ps.setString(4,model.getTipoUnidad());
            ps.setInt(5,model.getUnidadExistencia());
            ps.setInt(6,model.getMinStock());
            ps.setInt(7,model.getMaxStock());
            ps.setDouble(8,model.getPrecioCompra());
            ps.setDouble(9,model.getIncrementoVenta());
            ps.setDouble(10,model.getPrecioVenta());
            try {
                if(model.getRutaImagen()!=null)
                    ps.setBinaryStream(11,new FileInputStream(model.getRutaImagen()),(int)model.getRutaImagen().length());
                else
                    ps.setBlob(11,model.getImagen());
            } catch (FileNotFoundException ex) {
                ps.setBinaryStream(11, null);
            }
            ps.setInt(12,model.getTipoProducto());
            ps.setInt(13,model.getEmprsa_idempresa());
            ps.setInt(14,model.getCategoria_idcategoria());
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
