/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelProveedor;
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
public class DataBaseProveedor {

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
            Logger.getLogger(DataBase.DataBaseProveedor.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static List<ModelProveedor> buscaProveedor(String nombre,String rfc,boolean cond){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelProveedor> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            if(cond){
                String strQuery = "select * from proveedor where eliminado!=1 order by idproveedor;";
                System.out.println(strQuery);
                ResultSet res = sta.executeQuery(strQuery);
                while(res.next())
                    list.add(creaModeloProveedor(res));
            }else{
                String strQuery = "select * from proveedor where (nombre='"+nombre+"' || rfc='"+rfc+"') && eliminado!=1 order by idproveedor;";
                System.out.println(strQuery);
                ResultSet res = sta.executeQuery(strQuery);
                while(res.next()){
                    flag = true;
                    list.add(creaModeloProveedor(res));
                }
                if(!flag){
                    if(!nombre.equals("") && !rfc.equals(""))
                        strQuery = "select * from proveedor where (nombre like '"+nombre.charAt(0)+"%' || rfc like '"+rfc.charAt(0)+"%') && eliminado!=1 order by idproveedor;";
                    if(rfc.equals(""))
                        strQuery = "select * from proveedor where (nombre like '"+nombre.charAt(0)+"%') && eliminado!=1 order by idproveedor;";
                    else if(nombre.equals(""))
                        strQuery = "select * from proveedor where (rfc like '"+rfc.charAt(0)+"%') && eliminado!=1 order by idproveedor;";
                    System.out.println(strQuery);
                    res = sta.executeQuery(strQuery);
                    while(res.next())
                        list.add(creaModeloProveedor(res));    
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
    
    public static boolean addProveedor(ModelProveedor proveedor){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "insert into proveedor "+proveedor.addProveedor();
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
    
    public static boolean modifProveedor(ModelProveedor proveedor){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update proveedor "+proveedor.modInfo()+" where idproveedor = "+proveedor.getIdProveedor()+";";
            System.out.println(strQuery);
            sta.executeUpdate(strQuery);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseProveedor.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private static ModelProveedor creaModeloProveedor(ResultSet res){
        ModelProveedor modelProveedor = new ModelProveedor();
        try {
            modelProveedor.setIdProveedor(Integer.parseInt(res.getString("idProveedor")));
            modelProveedor.setNombre(res.getString("nombre"));
            modelProveedor.setaPaterno(res.getString("aPaterno"));
            modelProveedor.setaMaterno(res.getString("aMaterno"));
            modelProveedor.setRFC(res.getString("RFC"));
            modelProveedor.setMarca(res.getString("marca"));
            modelProveedor.setEmpresa(res.getString("empresa"));
            modelProveedor.setTelFijo(res.getString("telFijo"));
            modelProveedor.setTelCel(res.getString("telCel"));
            modelProveedor.setCalle(res.getString("calle"));
            modelProveedor.setNumInt(Integer.parseInt(res.getString("numInt")));
            modelProveedor.setNumExt(Integer.parseInt(res.getString("numExt")));
            modelProveedor.setColonia(res.getString("colonia"));
            modelProveedor.setCiudad(res.getString("ciudad"));
            modelProveedor.setEstado(res.getString("estado"));
            modelProveedor.setCodigoPostal(Integer.parseInt(res.getString("codigopostal")));
            modelProveedor.seteMail(res.getString("email"));
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelProveedor;
    }
    
    public static boolean eliminarProveedor(String idProveedor){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
                Statement sta = conn.createStatement();
                String strQuery = "update proveedor set eliminado = 1 where idproveedor = '"+idProveedor+"';";
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
    
    public static ModelProveedor findProveedor (String idProveedor){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        ModelProveedor proveedor = new ModelProveedor();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from proveedor where idProveedor='"+idProveedor+"' && eliminado!=1;";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                proveedor = creaModeloProveedor(res);
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
        return proveedor;
    }
    
    public static List<ModelProveedor> buscaProveedores(){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<ModelProveedor> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "SELECT IDPROVEEDOR, NOMBRE, APATERNO FROM PROVEEDOR ORDER BY NOMBRE;";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                ModelProveedor model = new ModelProveedor();
                model.setIdProveedor(Integer.parseInt(res.getString("idProveedor")));
                model.setNombre(res.getString("nombre"));
                model.setaPaterno(res.getString("aPaterno"));
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
