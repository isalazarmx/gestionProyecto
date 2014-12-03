/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelCategoria;
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
public class DataBaseCategoria 
{
    public static String verProximoID(){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select auto_increment from information_schema.tables where table_schema='poscakeapp' and table_name='categoria';";
            System.out.println(strQuery);
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next())
                id = res.getString("Auto_increment");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
    
    ///Consultas agregadas-------------------
    //------------------- Metodo para agregar Categoria-------------------
    public static boolean addInfoCategoria(ModelCategoria model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "insert into categoria(nombre,descripcion,tipoProducto,elimiando) values "+model.addInfo();
            System.out.println(strQuery);
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
    
    //---------Metodo para checar existencia de categoria-----------------
    public static boolean checkExistCategoria(String nombre){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from categoria where nombre = '"+nombre+"' and elimiando=0;";
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
    public static LinkedList findCategoria(String cadena){
        LinkedList arrayCategoria=new LinkedList();
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from categoria where elimiando=0 and nombre like '%"+cadena+"%';";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next())
            {
                ModelCategoria categoria=new ModelCategoria();
                categoria.setIdCategoria(Integer.parseInt(res.getString("idCategoria")));
                categoria.setNombre(res.getString("nombre"));
                categoria.setDescripcion(res.getString("descripcion"));
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
    public static boolean deleteCategoria(String nombre){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update categoria set elimiando=1 where nombre='"+nombre+"';";
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
    
    
    
    //--------Obtiene una categoria----------------------
    public static ModelCategoria getCategoria(ModelCategoria categoria,String cadena){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from categoria where nombre = '"+cadena+"';";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                categoria.setIdCategoria(Integer.parseInt(res.getString("idCategoria")));
                categoria.setNombre(res.getString("nombre"));
                categoria.setDescripcion(res.getString("descripcion"));
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
    
    
    public static boolean modifCategoria(ModelCategoria categoria,String nombre){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update categoria "+categoria.modInfo()+" where nombre = '"+nombre+"';";            
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
    
    public static List<ModelCategoria> buscaCategorias(boolean tipoCategoria){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelCategoria> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery;
            if(tipoCategoria)
                strQuery = "SELECT * FROM CATEGORIA WHERE TIPOPRODUCTO = 3;";
            else
                strQuery = "SELECT * FROM CATEGORIA WHERE TIPOPRODUCTO = 2;";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                ModelCategoria model = new ModelCategoria();
                model.setIdCategoria(Integer.parseInt(res.getString("idCategoria")));
                model.setNombre(res.getString("nombre"));
                model.setDescripcion(res.getString("descripcion"));
                model.setTipoProducto(Integer.parseInt(res.getString("tipoProducto")));
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
}
