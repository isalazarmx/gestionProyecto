/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelProducto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nel
 */
public class DataBaseProducto 
{
    public static List<ModelProducto> buscaCategorias(boolean tipoCategoria){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelProducto> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery;
            if(tipoCategoria)
                strQuery = "SELECT * FROM PRODUCTO WHERE TIPOPRODUCTO = 3;";
            else
                strQuery = "SELECT * FROM CATEGORIA WHERE TIPOPRODUCTO = 2;";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                ModelProducto model = new ModelProducto();
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
                model.setRutaImagen(res.getString("RutaImagen"));
                model.setTipoProducto(res.getInt("tipoProducto"));
                model.setEmprsa_idempresa(res.getInt("empresa_idempresa"));
                model.setCategoria_idcategoria(res.getInt("categoria_idcategoria"));
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
    
    //----------------------------------------------------------------------
    
    ///Consultas agregadas-------------------
    //------------------- Metodo para agregar Categoria-------------------
    public static boolean addInfoProducto(ModelProducto model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
//            String strQuery = "insert into producto(nombre,descripcion,linkFoto,kilos,numPersonas,precioUnitario,eliminado,Categoria_idCategoria,Empresa_idEmpresa) values "+model.addInfo();
//            sta.executeUpdate(strQuery);
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
    
    //---------Metodo para checar existencia de categoria-----------------
    public static boolean checkExistProducto(String nombre){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from producto where nombre = '"+nombre+"' and eliminado=0;";
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
    
    
    //----------Obtiene todas las categorias-----------------
    public static LinkedList findProductos(String cadena){
        LinkedList arrayCategoria=new LinkedList();
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from producto where eliminado=0 and nombre like '%"+cadena+"%';";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next())
            {
                ModelProducto categoria=new ModelProducto();
//                categoria.setIdCategoria(Integer.parseInt(res.getString("idProducto")));
                categoria.setNombre(res.getString("nombre"));                
                arrayCategoria.add(categoria);
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
        return arrayCategoria;
    }
    
    
    //-----------Eliminar la categoria--------------
    public static boolean deleteProducto(String nombre){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update producto set eliminado=1 where nombre='"+nombre+"';";
            sta.executeUpdate(strQuery);            
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
    
    
    //----------obtiene la categoria-------------
    public static int idCategoria(String nombre){
        int idCategoria = 0;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select idCategoria from categoria where nombre = '"+nombre+"';";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                idCategoria=Integer.parseInt(res.getString("idCategoria"));                
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
        return idCategoria;
    }    
    
    public static int idProducto(String nombre){
        int idCategoria = 0;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select idProducto from producto where nombre = '"+nombre+"';";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                idCategoria=Integer.parseInt(res.getString("idProducto"));                
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
        return idCategoria;
    }    
    
    
    //--------Obtiene una categoria----------------------
    public static ModelProducto getProducto(ModelProducto categoria,String cadena){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from producto where nombre = '"+cadena+"';";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
//                categoria.setIdCategoria(Integer.parseInt(res.getString("idproducto")));
                categoria.setNombre(res.getString("nombre"));
//                categoria.setDescripcion(res.getString("descripcion"));
//                categoria.setLinkFoto(res.getString("linkFoto"));
//                categoria.setKilos(Integer.parseInt(res.getString("kilos")));
//                categoria.setNumPersonas(Integer.parseInt(res.getString("numPersonas")));
//                categoria.setPrecioUnitario(Double.parseDouble(res.getString("precioUnitario")));
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
        return categoria;
    }
    
    
    public static boolean modifProdcuto(ModelProducto categoria,String nombre){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
//            String strQuery = "update producto "+categoria.modInfo()+" where nombre = '"+nombre+"';";            
//            sta.executeUpdate(strQuery);
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
