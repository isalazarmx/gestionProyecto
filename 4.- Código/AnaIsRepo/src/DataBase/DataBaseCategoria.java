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
    
        public static boolean addCategoria(ModelCategoria model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "INSERT INTO CATEGORIA (NOMBRE,DESCRIPCION,TIPOPRODUCTO,ELIMINADO) VALUES "+model.addInfo();
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
        
     public static boolean modificaCategoria(ModelCategoria model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "UPDATE CATEGORIA "+model.modInfo()+" WHERE IDCATEGORIA="+model.getIdCategoria()+";";
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
     
        public static boolean modifCategoria(String idCategoria){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "UPDATE CATEGORIA SET ELIMINADO = 1 WHERE IDCATEGORIA = "+idCategoria+";";
            System.out.println(strQuery);
            sta.executeUpdate(strQuery);
            flag = true;
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
        return flag;
    } 
        
    public static boolean checkExistCategoria(String nombre){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "SELECT * FROM CATEGORIA WHERE NOMBRE = '"+nombre+"' AND ELIMINADO = 0;";
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
    
    public static List<ModelCategoria> buscaCategorias(boolean tipoCategoria){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelCategoria> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery;
            if(tipoCategoria)
                strQuery = "SELECT * FROM CATEGORIA WHERE TIPOPRODUCTO = 3 AND ELIMINADO = 0 ORDER BY NOMBRE;";
            else
                strQuery = "SELECT * FROM CATEGORIA WHERE TIPOPRODUCTO = 2 AND ELIMINADO = 0 ORDER BY NOMBRE;";
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
