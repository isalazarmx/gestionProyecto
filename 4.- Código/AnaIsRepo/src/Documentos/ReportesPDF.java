/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documentos;
import Controller.ControllerFechas;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teté
 */
public class ReportesPDF {
    java.awt.Font fuente = new java.awt.Font("Normal", Font.BOLD, 12);
    Color grisClaro = new Color(230, 230, 230);
    Color azulClaro = new Color(124, 195, 255);
    PdfWriter writer;
    String strRotuloPDF;
    private String[] rotulosColumnas;
    private int numReport;

    //Metodo principal del ejemplo
    public void GenerarPDF(String[] rotulosColumnas,int numReport) {
        this.rotulosColumnas = rotulosColumnas;
        this.numReport = numReport;
        String ruta = verificaReporte(numReport);
        try { //Hoja tamaño carta, rotarla (cambiar a horizontal)
            System.out.println(ruta);
            OutputStream file = new FileOutputStream(ruta);
            Document documento = new Document(PageSize.LETTER, 20, 20, 20, 20);
            PdfWriter.getInstance(documento, file);
            documento.open();
            agregarContenido(documento);
            agregarMetaDatos(documento);
            documento.add(new Paragraph(new Date().toString()));
            documento.close();
            JOptionPane.showMessageDialog(null, "Ha terminado!\nSu archivo es:\n" + ruta);
        } catch (FileNotFoundException | DocumentException | HeadlessException e) {
            e.getMessage();
        }
    }

    //agrega el contenido del documento; para este ejemplo agrega una tabla con datos y una imagen
    //Espera como entrada el documento donde agregara el contenido
    private void agregarContenido(Document document){
        Paragraph ParrafoHoja = new Paragraph();
        // AGREGAMOS LA IMAGEN
        try {
            Image foto = Image.getInstance(getClass().getResource("/Image/logoAnaIS.png"));
            foto.scaleToFit(40, 40);
            ParrafoHoja.add(foto);
        } catch (BadElementException | IOException e) {
            e.getMessage();
        }
        //Agregar  lineas en blanco
        agregarLineasEnBlanco(ParrafoHoja, 1);
        agregarTabla(ParrafoHoja);
        try {
            document.add(ParrafoHoja);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportesPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Se conecta la DB , obtiene los datos de la tabla (SELECT) y los acomoda en una tabla JTable de iText.
    // Espera como entrada el parrafo donde agregara la tabla
    private void agregarTabla(Paragraph parrafo){
        //Anchos de las columnas
        float anchosFilas[] = {1f, 1f, 1f, 1f, 1f};
        PdfPTable tabla = new PdfPTable(anchosFilas);
        // Porcentaje que ocupa a lo ancho de la pagina del PDF
        tabla.setWidthPercentage(90);
        //Alineacion horizontal centrada
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        //agregar celda que ocupa las  columnas de los rotulos
         PdfPCell cell0 = new PdfPCell(new Paragraph("Repostería AnaIs"));
        cell0.setColspan(5);
        cell0.setBackgroundColor(new BaseColor (66,139,202));
        //Centrar contenido de celda
        cell0.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cell = new PdfPCell(new Paragraph("Reporte sobre ventas"));
        cell.setColspan(5);
        cell.setBackgroundColor(new BaseColor (49,176,213));
        //Centrar contenido de celda
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //Color de fondo de la celda
//        cell.setBackgroundColor (azulClaro);        
        tabla.addCell(cell0);
        tabla.addCell(cell);
            // Mostrar los rotulos de las columnas
            for (int i = 0; i < rotulosColumnas.length; i++) {
                cell = new PdfPCell(new Paragraph(rotulosColumnas[i]));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(new BaseColor (248,248,248));
                tabla.addCell(cell);
            }
            switch(numReport){
                case 1:DataBase.DataBasePDF.pdfVendedores(cell, tabla);break;
                case 2:DataBase.DataBasePDF.pdfVendedores(cell, tabla);break;
                case 3:DataBase.DataBasePDF.pdfClientes(cell, tabla);break;
            }
            
        //Agregar la tabla con los datos al parrafo que nos llego como entrada
        parrafo.add(tabla);
    }  //Fin del metodo que crea la tabla

    //Agrega las lineas en blanco  especificadas a un parrafo especificado
    private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) {
        for (int i = 0; i < nLineas; i++) {
            parrafo.add(new Paragraph(" "));
        }
    }

    //Agrega los metadatos del documento
    //Titulo, Asunto, Palabras clave, Autor
    private static void agregarMetaDatos(Document document) {
        document.addTitle("Reporte de Ventas");
        document.addSubject("Repostería AnaIs");
        document.addKeywords("Line by Line");
        document.addAuthor("Line by Line");
    }
    
    private static String verificaReporte(int numReporte){
        String nomReporte = "";
        switch (numReporte) {
            case 1:nomReporte = "Vendedor";break;
        }
        return System.getProperty("user.dir")+ System.getProperty("file.separator") 
                           + "reports"+System.getProperty("file.separator")+nomReporte+ControllerFechas.getFechaActual()+".pdf";
    }
}
