/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documentos;

import Controller.ControllerFechas;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class ClaseAlmacenXLS {
        public static void main(String[] args) {
//        ClaseAlmacenXLS objPruebaBlog = new ClaseAlmacenXLS();
//        objPruebaBlog.crearExcel();
            new ClaseAlmacenXLS().crearExcel();
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
            createTituloCell(wb, trow, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Productos en almacén");
            
            // Creo la cabecera de mi listado en Excel
            Row fil4 = sheet1.createRow((short) 4);
            Row fil5 = sheet1.createRow((short) 5);
            Row fil6 = sheet1.createRow((short) 6);
            Row fil7 = sheet1.createRow((short) 7);
            createCell(wb, fil4, 0, CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT, "Repostería AnaIS", false, false);
            createCell(wb, fil5, 0, CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT, "Reporte de Almacén", false, false);
            createCell(wb, fil6, 0, CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT, "generado el dia:", false, false);
            createCell(wb, fil7, 0, CellStyle.ALIGN_LEFT, CellStyle.ALIGN_LEFT, ControllerFechas.getFechaActual(), false, false);

            // Creo la cabecera de mi listado en Excel
            Row row = sheet1.createRow((short) 2);

            createCell(wb, row, 0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Código de producto", true, true);
            createCell(wb, row, 1, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Nombre", true, true);
            createCell(wb, row, 2, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Existencia", true, true);
            createCell(wb, row, 3, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Mínimo en existencia", true, true);
            createCell(wb, row, 4, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Máximo en existencia", true, true);
            createCell(wb, row, 5, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Código de proveedor", true, true);
            createCell(wb, row, 6, CellStyle.ALIGN_RIGHT, CellStyle.VERTICAL_JUSTIFY, "Eliminado", true, true);
            createCell(wb, row, 7, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER, "Precio por unidad", true, true);

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/reposteria", "root", "");

            try ( // Creamos un Statement para poder hacer peticiones a la bd
                    Statement stat = con.createStatement()) {
                ResultSet resultado = stat.executeQuery("select idInsumo, nombre, unidadExistencia, minStock, maxStock, Proveedor_idProveedor, eliminado, "
                        + "precioUnidad from insumo order by nombre");
                while (resultado.next()) {
                    
                    //creamos la fila
                    Row fila = sheet1.createRow(3 + i);
                    
                    String idInsumo = String.valueOf(resultado.getInt("idInsumo"));
                    String nombre = String.valueOf(resultado.getString("nombre"));
                    String existencia = String.valueOf(resultado.getInt("unidadExistencia"));
                    String minS = String.valueOf(resultado.getInt("minStock"));
                    String maxS = String.valueOf(resultado.getInt("maxStock"));
                    String idProv = String.valueOf(resultado.getInt("Proveedor_idProveedor"));
                    String eliminado = String.valueOf(resultado.getBoolean("eliminado"));
                    String precioU = String.valueOf(resultado.getFloat("precioUnidad"));
                    // Creo las celdas de mi fila, se puede poner un diseño a la celda
                    System.out.println(i + " /// " + idInsumo + " - " + nombre + " - " + existencia + " - " + minS + " - " + maxS + " - " + idProv +
                            " - " + eliminado + " - " + precioU);
                    
                    creandoCelda(wb, fila, 0, idInsumo);
                    creandoCelda(wb, fila, 1, nombre);
                    creandoCelda(wb, fila, 2, existencia);
                    creandoCelda(wb, fila, 3, minS);
                    creandoCelda(wb, fila, 4, maxS);
                    creandoCelda(wb, fila, 5, idProv);
                    creandoCelda(wb, fila, 6, eliminado);
                    creandoCelda(wb, fila, 7, precioU);
                    
                    i++;
                }
            }
              con.close();


//             Definimos el tamaño de las celdas, podemos definir un tamaña especifico o hacer que 
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

            String strRuta = "C:\\Users\\Teté\\Documents\\GitHub\\gestionProyecto\\4.- Código\\AnaIsRepo" + ControllerFechas.getFechaActual() + ".xls";

            try (FileOutputStream fileOut = new FileOutputStream(strRuta)) {
                wb.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Ha terminado!\nSu archivo es:\n" + strRuta);

        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "El archivo no se ha creado debido a que otro usuario esta haciendo uso de el.\nSe recomienda cerrar el archivo");
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
