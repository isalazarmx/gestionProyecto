/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documentos;

import Controller.ControllerFechas;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author Teté
 */
public class ClaseAlmacenProducto {
     public static void main(String[] args) {

    }
    int i;
    String nombre_archivo;
   Connection con;
   ResultSet rs;

    public void crearExcel() {
        try {

            // Defino el Libro de Excel
            HSSFWorkbook wb = new HSSFWorkbook();

            // Creo la Hoja en Excel
            Sheet sheet1 = wb.createSheet("Productos");
            Sheet sheet2 = wb.createSheet("hoja2");
            Sheet sheet3 = wb.createSheet("hoja3");

            // quito las lineas del libro para darle un mejor acabado
//            sheet.setDisplayGridlines(false);
            sheet1.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
            sheet2.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
            sheet3.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));

            // creo una nueva fila
            Row trow = sheet1.createRow((short) 0);
            createTituloCell(wb, trow, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Productos existentes-Repostería AnaIS " + ControllerFechas.getFechaActual());
            

            // Creo la cabecera de mi listado en Excel
            Row row = sheet1.createRow((short) 2);

            createCell(wb, row, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Código de producto", true, true);
            createCell(wb, row, 1, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Nombre", true, true);
            createCell(wb, row, 2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Cantidad", true, true);
            createCell(wb, row, 3, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Existencia", true, true);
            createCell(wb, row, 4, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Precio de venta", true, true);
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/poscakeapp", "root", "");

            try ( // Creamos un Statement para poder hacer peticiones a la bd
                    Statement stat = con.createStatement()) {
                ResultSet resultado = stat.executeQuery("select idProducto, nombre, cantidad,UnidadExistencia, precioVenta from producto where tipoProducto=3 ");
                while (resultado.next()) {
                    
                    //creamos la fila
                    Row fila = sheet1.createRow(3 + i);
                    
                    String idProducto = String.valueOf(resultado.getString("idProducto"));
                    String nombre = String.valueOf(resultado.getString("nombre"));
                    String cantidad = String.valueOf(resultado.getInt("cantidad"));
                    String UnidadExistencia = String.valueOf(resultado.getInt("UnidadExistencia"));
                    String precioVenta = String.valueOf(resultado.getInt("precioVenta"));
                    //String Image = String.valueOf(resultado.getBlob("Image"));
                    // Creo las celdas de mi fila, se puede poner un diseño a la celda
                    System.out.println(i + " /// " + idProducto + " - " + nombre + " - " + cantidad + " - " + UnidadExistencia + " - " + precioVenta + " - " /*+ Image*/);
                    
                    creandoCelda(wb, fila, 0, idProducto);
                    creandoCelda(wb, fila, 1, nombre);
                    creandoCelda(wb, fila, 2, cantidad);
                    creandoCelda(wb, fila, 3, UnidadExistencia);
                    creandoCelda(wb, fila, 4, precioVenta);
                    //creandoCelda(wb, fila, 5, Image);
                    i++;
                }
            }
              con.close();


//            Definimos el tamaño de las celdas, podemos definir un tamaña especifico o hacer que 
//            la celda se acomode según su tamaño
            Sheet ssheet = wb.getSheetAt(0);
            ssheet.autoSizeColumn(0);
            ssheet.autoSizeColumn(1);
            ssheet.autoSizeColumn(2);
            ssheet.autoSizeColumn(3);
            ssheet.autoSizeColumn(4);
            ssheet.autoSizeColumn(5);
            ssheet.autoSizeColumn(6);
            ssheet.autoSizeColumn(7);

            //Ajustando la hoja de una pagina

            Sheet sheet = wb.createSheet("format sheet");
            PrintSetup ps = sheet.getPrintSetup();
            sheet.setAutobreaks(true);
            ps.setFitHeight((short) 1);
            ps.setFitWidth((short) 1);

            //Area de impresion
            wb.setPrintArea(0, 0, 1, 0, 9);

            String strRuta = System.getProperty("user.dir")+ System.getProperty("file.separator") 
                           + "reports"+System.getProperty("file.separator")+"Productos"+ControllerFechas.getFechaActual()+".xls";
                    //"C:\\Users\\Teté\\Documents\\GitHub\\gestionProyecto\\4.- Código\\AnaIsRepo" + ControllerFechas.getFechaActual() + ".xls";

            try (FileOutputStream fileOut = new FileOutputStream(strRuta)) {
                wb.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Se ha creado!\nSu archivo es:\n" + strRuta);

        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "El archivo no se ha creado debido a que otro usuario esta haciendo uso de el.\nSe recomienda cerrar el archivo");
        }
    }

    private static void createTituloCell(HSSFWorkbook wb, Row row, int column, short halign, short valign, String strContenido) {
        CreationHelper ch = wb.getCreationHelper();
        Cell cell = row.createCell(column);
        cell.setCellValue(ch.createRichTextString(strContenido));
        

        HSSFFont cellFont = wb.createFont();
        cellFont.setFontHeightInPoints((short) 11);
        cellFont.setFontName(HSSFFont.FONT_ARIAL);
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cellStyle.setFont(cellFont);
        cell.setCellStyle(cellStyle);
   
        
       
    }

    private static void creandoCelda(Workbook wb, Row row, int column, String strContenido) {
        CreationHelper ch = wb.getCreationHelper();

        Cell cell = row.createCell(column);
        cell.setCellValue(ch.createRichTextString(strContenido));
        
    }

    private static void createCell(Workbook wb, Row row, int column, short halign, short valign, String strContenido, boolean booBorde, boolean booCabecera) {
        CreationHelper ch = wb.getCreationHelper();
        Cell cell = row.createCell(column);
        cell.setCellValue(ch.createRichTextString(strContenido));
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
    
        if (booBorde) {
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
            cellStyle.setBottomBorderColor((short) 8);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
            cellStyle.setLeftBorderColor((short) 8);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
            cellStyle.setRightBorderColor((short) 8);
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
            cellStyle.setTopBorderColor((short) 8);
        }
        if (booCabecera) {
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
            cellStyle.setBottomBorderColor((short) 8);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
            cellStyle.setLeftBorderColor((short) 8);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
            cellStyle.setRightBorderColor((short) 8);
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
            cellStyle.setTopBorderColor((short) 8);

            cellStyle.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        }
        cell.setCellStyle(cellStyle);
    }
    
}
