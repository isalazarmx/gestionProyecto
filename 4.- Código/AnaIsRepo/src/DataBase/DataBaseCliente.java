/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelCliente;
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
 * @author Jesus
 */
public class DataBaseCliente {
    
    public static String verProximoID(){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select auto_increment from information_schema.tables where table_schema='reposteria' and table_name='cliente';";
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
    
    public static boolean addCliente(ModelCliente user){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "insert into cliente "+user.addCliente();
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

    public static boolean modifUser(ModelCliente cliente){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update cliente "+cliente.modInfo()+" where idcliente = "+cliente.getIdCliente()+";";
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
     
    public static List buscaCliente(String nombre,String rfc,boolean cond){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelCliente> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            if(cond){
                String strQuery = "select * from cliente where eliminado!=1 order by idcliente;";
                System.out.println(strQuery);
                ResultSet res = sta.executeQuery(strQuery);
                while(res.next())
                    list.add(creaModeloCliente(res));
            }else{
                String strQuery = "select * from cliente where (nombre='"+nombre+"' || rfc='"+rfc+"') && eliminado!=1 order by idcliente;";
                System.out.println(strQuery);
                ResultSet res = sta.executeQuery(strQuery);
                while(res.next()){
                    flag = true;
                    list.add(creaModeloCliente(res));
                }
                if(!flag){
                    if(!nombre.equals("") && !rfc.equals(""))
                        strQuery = "select * from cliente where (nombre like '"+nombre.charAt(0)+"%' || rfc like '"+rfc.charAt(0)+"%') && eliminado!=1 order by idcliente;";
                    if(rfc.equals(""))
                        strQuery = "select * from cliente where (nombre like '"+nombre.charAt(0)+"%') && eliminado!=1 order by idcliente;";
                    else if(nombre.equals(""))
                        strQuery = "select * from cliente where (rfc like '"+rfc.charAt(0)+"%') && eliminado!=1 order by idcliente;";
                    System.out.println(strQuery);
                    res = sta.executeQuery(strQuery);
                    while(res.next())
                        list.add(creaModeloCliente(res));    
                }
            }
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
        return list;
    }

    private static ModelCliente creaModeloCliente(ResultSet res){
        ModelCliente modelCliente = new ModelCliente();
        try {
            modelCliente.setIdCliente(Integer.parseInt(res.getString("idcliente")));
            modelCliente.setNombre(res.getString("nombre"));
            modelCliente.setaPaterno(res.getString("aPaterno"));
            modelCliente.setaMaterno(res.getString("aMaterno"));
            modelCliente.setRFC(res.getString("RFC"));
            modelCliente.setTelFijo(Integer.parseInt(res.getString("telFijo")));
            modelCliente.setTelCel(Integer.parseInt(res.getString("telCel")));
            modelCliente.setCalle(res.getString("calle"));
            modelCliente.setNumInt(Integer.parseInt(res.getString("numInt")));
            modelCliente.setNumExt(Integer.parseInt(res.getString("numExt")));
            modelCliente.setColonia(res.getString("colonia"));
            modelCliente.setCiudad(res.getString("ciudad"));
            modelCliente.setEstado(res.getString("estado"));
            modelCliente.setCodigoPostal(Integer.parseInt(res.getString("codigopostal")));
            modelCliente.seteMail(res.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelCliente;
    }
    
    public static ModelCliente findCliente (String idCliente){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        ModelCliente cliente = new ModelCliente();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from cliente where idCliente='"+idCliente+"' && eliminado!=1;";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                cliente = creaModeloCliente(res);
            }
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
        return cliente;
    }
  
    public static boolean eliminarCliente(String idCliente){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
                Statement sta = conn.createStatement();
                String strQuery = "update cliente set eliminado = 1 where idcliente = '"+idCliente+"';";
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
}
