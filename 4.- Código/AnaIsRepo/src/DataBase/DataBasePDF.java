/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Controller.ControllerConnDBMS;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teté
 */
public class DataBasePDF {
    
    public static String pdfVendedores(PdfPCell cell, PdfPTable tabla){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from usuario where eliminado!= 1 && tipo!=3;";
            System.out.println(strQuery);
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                cell = new PdfPCell(new Paragraph(res.getString("idusuario")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("nombre")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("aPaterno")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("aMaterno")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("username")));
                tabla.addCell(cell);
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
        return id;
    }
    
    
    
        public static String pdfProveedores(PdfPCell cell, PdfPTable tabla){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from proveedor;";
            System.out.println(strQuery);
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                cell = new PdfPCell(new Paragraph(res.getString("idProveedor")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("nombre")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("aPaterno")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("aMaterno")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("marca")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("email")));
                tabla.addCell(cell);
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
        return id;
    }
        
        
        public static String pdfClientes(PdfPCell cell, PdfPTable tabla){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from cliente;";
            System.out.println(strQuery);
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                cell = new PdfPCell(new Paragraph(res.getString("idCliente")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("nombre")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("aPaterno")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("aMaterno")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("telFijo")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("telCel")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("email")));
                tabla.addCell(cell);
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
        return id;
    }
  
   
        public static String pdfVentas(PdfPCell cell, PdfPTable tabla){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from ventas;";
            System.out.println(strQuery);
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                cell = new PdfPCell(new Paragraph(res.getString("idVenta")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("tipoVenta")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("fechaVenta")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("precioTotal")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("usuario_idusuario")));
                tabla.addCell(cell);
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
        return id;
    }
        
        
            public static String pdfProductos(PdfPCell cell, PdfPTable tabla){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select * from producto;";
            System.out.println(strQuery);
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                cell = new PdfPCell(new Paragraph(res.getString("idProducto")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("nombre")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("kilos")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("precioUnitario")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("Categoria_idCategoria")));
                tabla.addCell(cell);
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
        return id;
    }
            
            
            public static String pdfPedidos(PdfPCell cell, PdfPTable tabla){
        String id = "";
        ControllerConnDBMS controller = new ControllerConnDBMS();
        Connection conn = controller.connectDB();
        try {
            Statement sta = conn.createStatement();
            String strQuery = "select v.ventaPedido_idventaPedido,v.precioTotal,p.abono,p.resto,p.entregado,p.descripcion"
                    + "       where v.ventaPedido_idventaPedido=p.idventaPedido from venta;";
            System.out.println(strQuery);
            ResultSet res = sta.executeQuery(strQuery);
            while(res.next()){
                cell = new PdfPCell(new Paragraph(res.getString("ventaPedido_idventaPedido")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("precioTotal")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("abono")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("resto")));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(res.getString("entregado")));
                tabla.addCell(cell);
            }   cell = new PdfPCell(new Paragraph(res.getString("descripción")));
                tabla.addCell(cell);
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
        
}
