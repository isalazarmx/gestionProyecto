/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelUsuario;
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
public class DataBaseUsuario {
    
    public static String verProximoID(){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select auto_increment from information_schema.tables where table_schema='poscakeapp' and table_name='proveedor';";
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
    
    public static ModelUsuario buscaAdministrador(ModelUsuario user){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from usuario where eliminado != 1 && tipo = 3;";
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
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static ModelUsuario findUser(String username){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        ModelUsuario user = new ModelUsuario();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from usuario where username='"+username+"' && (eliminado!=1 && tipo != 3);";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                user.setIdUsuario(Integer.parseInt(res.getString("idUsuario")));
                user.setNombre(res.getString("nombre"));
                user.setaPaterno(res.getString("aPaterno"));
                user.setaMaterno(res.getString("aMaterno"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setTipo(Integer.parseInt(res.getString("tipo")));
                user.setIdEmpresa(Integer.parseInt(res.getString("Empresa_idEmpresa")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            String strQuery = "insert into usuario "+user.addVendedor();
            System.out.println(strQuery);
            sta.executeUpdate(strQuery);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static boolean modifUser(ModelUsuario user){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update usuario "+user.modInfo()+" where idusuario = "+user.getIdUsuario();
            System.out.println(strQuery);
            sta.executeUpdate(strQuery);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static List buscaUsuario(String nombre,String username,boolean cond){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelUsuario> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            if(cond){
                String strQuery = "select * from usuario where (eliminado!=1 && tipo!=3) order by nombre;";
                System.out.println(strQuery);
                ResultSet res = sta.executeQuery(strQuery);
                while(res.next())
                    list.add(creaModeloUsuario(res));
            }else{
                String strQuery = "select * from usuario where (nombre='"+nombre+"' || username='"+username+"') && (eliminado!=1 && tipo!=3) order by nombre;";
                System.out.println(strQuery);
                ResultSet res = sta.executeQuery(strQuery);
                while(res.next()){
                    flag = true;
                    list.add(creaModeloUsuario(res));
                }
                if(!flag){
                    if(!nombre.equals("") && !username.equals(""))
                        strQuery = "select * from usuario where (nombre like '"+nombre.charAt(0)+"%' || username like '"+username.charAt(0)+"%') && (eliminado!=1 && tipo!=3) order by nombre;";
                    if(username.equals(""))
                        strQuery = "select * from usuario where (nombre like '"+nombre.charAt(0)+"%') && (eliminado!=1 && tipo!=3) order by nombre;";
                    else if(nombre.equals(""))
                        strQuery = "select * from usuario where (username like '"+username.charAt(0)+"%') && (eliminado!=1 && tipo!=3) order by nombre;";
                    System.out.println(strQuery);
                    res = sta.executeQuery(strQuery);
                    while(res.next())
                        list.add(creaModeloUsuario(res));    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private static ModelUsuario creaModeloUsuario(ResultSet res){
        ModelUsuario modelUser = new ModelUsuario();
        try {
            modelUser.setIdUsuario(Integer.parseInt(res.getString("idusuario")));
            modelUser.setNombre(res.getString("nombre"));
            modelUser.setaPaterno(res.getString("aPaterno"));
            modelUser.setaMaterno(res.getString("aMaterno"));
            modelUser.setUsername(res.getString("username"));
            modelUser.setPassword(res.getString("password"));
            modelUser.setIdEmpresa(Integer.parseInt(res.getString("Empresa_idEmpresa")));
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelUser;
    }
    
    public static boolean eliminarUsuario(String username){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
                Statement sta = conn.createStatement();
                String strQuery = "update usuario set eliminado = 1 where username = '"+username+"';";
                System.out.println(strQuery);
                sta.executeUpdate(strQuery);
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
