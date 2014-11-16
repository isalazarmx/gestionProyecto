/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelEmpresa;
import Model.ModelUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class ControllerConsults {
    
    public static boolean addInfoBussines(ModelEmpresa model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "insert into empresa values "+model.addInfo();
            sta.executeUpdate(strQuery);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerConsults.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static ModelEmpresa findInfoBussines(ModelEmpresa empresa){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from empresa;";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                empresa.setIdEmpresa(Integer.parseInt(res.getString("idEmpresa")));
                empresa.setNombre(res.getString("nombre"));
                empresa.setCalle(res.getString("calle"));
                empresa.setNumINT(Integer.parseInt(res.getString("numInt")));
                empresa.setNumExt(Integer.parseInt(res.getString("numExt")));
                empresa.setColonia(res.getString("colonia"));
                empresa.setCodigoPostal(Integer.parseInt(res.getString("codigoPostal")));
                empresa.setRFC(res.getString("RFC"));
                empresa.setPagWeb(res.getString("pagWeb"));
                empresa.seteMail(res.getString("e-mail"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerConsults.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empresa;
    }
    
    public static ModelUsuario findUser(ModelUsuario user){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from usuario where tipo = 3;";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                user.setIdEmpresa(Integer.parseInt(res.getString("idUsuario")));
                user.setNombre(res.getString("nombre"));
                user.setaPaterno(res.getString("aPaterno"));
                user.setaMaterno(res.getString("aMaterno"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setTipo(Integer.parseInt(res.getString("tipo")));
                user.setIdEmpresa(Integer.parseInt(res.getString("Empresa_idEmpresa")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerConsults.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerConnDBMS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    public static boolean checkExistUser(String username){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from usuario where username = '"+username+"';";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next())
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerConsults.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static boolean addUser(ModelUsuario user){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            user.setTipo(3);
            String strQuery = "insert into usuario values "+user.addInfo();
            System.out.println(strQuery);
            sta.executeUpdate(strQuery);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerConsults.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static boolean validateSession(ModelUsuario usuario){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from usuario where username = '"+usuario.getUsername()+"';";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                if(res.getString("password").equals(usuario.getPassword())){
                    usuario.setIdUsuario(Integer.parseInt(res.getString("idUsuario")));
                    usuario.setNombre(res.getString("nombre"));
                    usuario.setaPaterno(res.getString("aPaterno"));
                    usuario.setaMaterno(res.getString("aMaterno"));
                    usuario.setTipo(Integer.parseInt(res.getString("tipo")));
                    usuario.setIdEmpresa(Integer.parseInt(res.getString("Empresa_idEmpresa")));
                    flag = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerConsults.class.getName()).log(Level.SEVERE, null, ex);
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
