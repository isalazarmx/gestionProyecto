/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import Model.Proveedor_has_Producto;
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
 * @author Jesus
 */
public class DataBaseProveedor_has_Producto {
    
    public static boolean addRegister(Proveedor_has_Producto model){
        boolean flag = false;
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            String strQuery = "INSERT INTO PROVEEDOR_HAS_PRODUCTO (PROVEEDOR_IDPROVEEDOR,PRODUCTO_IDPRODUCTO,PRODUCTO_EMPRESA_IDEMPRESA,PRODUCTO_CATEGORIA_IDCATEGORIA) VALUES (?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(strQuery);
            ps.setInt(1,model.getProoveedor_idproveedor());
            ps.setString(2,model.getProducto_idproducto());
            ps.setInt(3,model.getProducto_empresa_idempresa());
            ps.setInt(4,model.getProdcuto_categoria_idcategoria());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.DataBaseProveedor_has_Producto.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static List<Model.Proveedor_has_Producto> buscaRelations(){
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        List<Model.Proveedor_has_Producto> list = new ArrayList<>();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "SELECT * FROM PROVEEDOR_HAS_PRODUCTO";
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                Model.Proveedor_has_Producto model = creaModelo(res);
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
    
    private static Model.Proveedor_has_Producto creaModelo(ResultSet res){
        Model.Proveedor_has_Producto model = new Model.Proveedor_has_Producto();
        try {
            model.setProoveedor_idproveedor(res.getInt("Proveedor_idProveedor"));
            model.setProducto_idproducto(res.getString("producto_idproducto"));
            model.setProducto_empresa_idempresa(res.getInt("producto_empresa_idempresa"));
            model.setProdcuto_categoria_idcategoria(res.getInt("producto_categoria_idcategoria"));
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
