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
            String strQuery = "select * from usuario;";
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
}
