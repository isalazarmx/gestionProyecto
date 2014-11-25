/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documentos;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import Documentos.Fechas;
import java.awt.Color;
import java.io.OutputStream;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Teté
 */
public class ClaseProveedorPdf {
     Fechas fecha = new Fechas();
    java.awt.Font fuente = new java.awt.Font("Normal", Font.BOLD, 12);
    Color grisClaro = new Color(230, 230, 230);
    Color azulClaro = new Color(124, 195, 255);
    PdfWriter writer;
    String strRotuloPDF;
    Connection con;
    ResultSet rs;

    //Metodo principal del ejemplo
    public void GenerarPDF() {

        try { //Hoja tamaño carta, rotarla (cambiar a horizontal)

            String strRuta = "C:\\Users\\Teté\\Documents\\GitHub\\gestionProyecto\\4.- Código\\Proveedor" + fecha.getFechaActual() + ".pdf";
            OutputStream file = new FileOutputStream(strRuta);

            Document documento = new Document(PageSize.LETTER, 20, 20, 20, 20);
            PdfWriter.getInstance(documento, file);
            documento.open();

            agregarContenido(documento);
            agregarMetaDatos(documento);

            documento.add(new Paragraph(new Date().toString()));
            documento.close();

            JOptionPane.showMessageDialog(null, "Ha terminado!\nSu archivo es:\n" + strRuta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //agrega el contenido del documento; para este ejemplo agrega una tabla con datos y una imagen
    //Espera como entrada el documento donde agregara el contenido
    private void agregarContenido(Document document) throws DocumentException {
        Paragraph ParrafoHoja = new Paragraph();

        // AGREGAMOS LA IMAGEN
        try {
            Image foto = Image.getInstance("C:\\Users\\Teté\\Documents\\GitHub\\gestionProyecto\\4.- Código\\AnaIsRepo\\src\\Image\\ventasInfo.png");
            foto.scaleToFit(50, 50);
            ParrafoHoja.add(foto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Agregar  lineas en blanco
        agregarLineasEnBlanco(ParrafoHoja, 1);
        // AGREGAMOS LA TABLA
        agregarTabla(ParrafoHoja);




        document.add(ParrafoHoja);

    }

    //Se conecta la DB , obtiene los datos de la tabla (SELECT) y los acomoda en una tabla JTable de iText.
    // Espera como entrada el parrafo donde agregara la tabla
    private void agregarTabla(Paragraph parrafo) throws BadElementException 
    {
        //Anchos de las columnas
        float anchosFilas[] = {1f, 1f, 1f, 1f, 1f};
        PdfPTable tabla = new PdfPTable(anchosFilas);
        String rotulosColumnas[] = {"Código de Proveedor", "Marca", "Teléfono Fijo", "Teléfono Celular", "E-mail"};
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

        try {
            // Mostrar los rotulos de las columnas
            for (int i = 0; i < rotulosColumnas.length; i++) {
                cell = new PdfPCell(new Paragraph(rotulosColumnas[i]));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(new BaseColor (248,248,248));
                tabla.addCell(cell);
            }
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/reposteria", "root", "");

            // Creamos un Statement para poder hacer peticiones a la bd
            Statement stat = con.createStatement();
            ResultSet resultado = stat.executeQuery("select idProveedor,marca,telFijo,telCel,email from proveedor");

            //Iterar Mientras haya una fila siguiente
            while (resultado.next()) {           //Agregar celdas
                cell = new PdfPCell(new Paragraph(resultado.getInt("idProveedor")));
                tabla.addCell(cell);

                cell = new PdfPCell(new Paragraph(resultado.getString("marca")));
                tabla.addCell(cell);

                cell = new PdfPCell(new Paragraph(resultado.getInt("telFijo")));
                tabla.addCell(cell);

                cell = new PdfPCell(new Paragraph(resultado.getInt("telCel")));
                tabla.addCell(cell);
                
                cell = new PdfPCell(new Paragraph(resultado.getString("email")));
                tabla.addCell(cell);

            }
            stat.close();
            con.close();

            } catch (Exception e) {
            System.out.println("Excepcion al ejecutar CONSULTA!!!");
            //Mostrar la traza de la pila
            e.printStackTrace();
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
    
 
  public static void main(String[] args) {
    //Llamamos por el método para generar el pdf
    new ClaseProveedorPdf().GenerarPDF();
  }
    
}
