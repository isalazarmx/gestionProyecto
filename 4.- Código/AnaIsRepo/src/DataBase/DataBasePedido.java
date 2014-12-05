/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.ModelProducto;
import Model.ModeloPedidos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teté
 */
public class DataBasePedido {
        ///Consultas agregadas-------------------
    //------------------- Metodo para agregar Categoria-------------------
    public static boolean addInfoPedido(ModelProducto model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
//            String strQuery = "insert into ventaPedido(abono,resto,entregado,descripcion) values "+model.addInfo();
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
    public static boolean checkExistPedido(String idVenta){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from venta where idVenta = '"+idVenta+"' and eliminado=0;";
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
    public static LinkedList findPedido(String id){
        LinkedList arrayPedido=new LinkedList();
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from ventaPedido where entregado=0 and idventaPedido like '%"+id+"%';";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next())
            {
                ModeloPedidos pedidos=new ModeloPedidos();
                pedidos.setIdventaPedido(Integer.parseInt(res.getString("idventaPedido")));                
                arrayPedido.add(pedidos);
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
        return arrayPedido;
    }
    
    
    //-----------Eliminar la categoria--------------
    public static boolean deletePedido(String id){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "update venta set eliminado=1 where idVenta='"+id+"';";
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
    
    
 

    
    //--------Obtiene una categoria----------------------
    public static ModeloPedidos getPedido (ModeloPedidos pedido,String id){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from venta where idVenta = '"+id+"';";
            ResultSet res = sta.executeQuery(strQuery);
            if(res.next()){
                  pedido.setIdventaPedido(Integer.parseInt(res.getString("idventaPedido")));
                  pedido.setAbono(Integer.parseInt(res.getString("abono")));
                  pedido.setResto(Integer.parseInt(res.getString("resto")));
                  pedido.setDescripcion(res.getString("descripcion"));
                  
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
        return pedido;
    }
    
   
    
}
