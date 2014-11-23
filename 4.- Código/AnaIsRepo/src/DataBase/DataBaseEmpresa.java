/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelEmpresa;
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
public class DataBaseEmpresa {
    
    public static boolean agregaDatosEmpresa(ModelEmpresa model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "insert into empresa values "+model.addInfo();
            sta.executeUpdate(strQuery);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static ModelEmpresa buscaEmpresa(ModelEmpresa empresa){
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
                empresa.setCiudad(res.getString("ciudad"));
                empresa.setColonia(res.getString("colonia"));
                empresa.setEstado(res.getString("estado"));
                empresa.setCodigoPostal(Integer.parseInt(res.getString("codigoPostal")));
                empresa.setRFC(res.getString("RFC"));
                empresa.setPagWeb(res.getString("pagWeb"));
                empresa.seteMail(res.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static boolean modifEmpresa(ModelEmpresa empresa){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update empresa "+empresa.modInfo()+" where idempresa = "+empresa.getIdEmpresa()+";";
            System.out.println(strQuery);
            sta.executeUpdate(strQuery);
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
