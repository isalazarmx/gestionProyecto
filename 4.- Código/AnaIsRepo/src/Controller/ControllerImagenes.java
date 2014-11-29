/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jesus
 */
public class ControllerImagenes {
    
    public void buscaImagen(JPanel panel, JLabel imagen){
        JFileChooser archivo = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("Formatos de archivos JPEG(*.jpeg,*.jpg), PNG(*.png)","jpg","jpeg","png");
        archivo.addChoosableFileFilter(filtroImagen);
        archivo.setDialogTitle("Abrir archivo");
        archivo.setDialogType(1);
        File ruta = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"Pictures");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(panel);
        if(ventana == JFileChooser.APPROVE_OPTION){
            File file = archivo.getSelectedFile();
            Image foto = panel.getToolkit().getImage(String.valueOf(file));
            foto = foto.getScaledInstance(panel.getWidth(),panel.getHeight(), Image.SCALE_DEFAULT);
            imagen.setIcon(new ImageIcon(foto));
        }
    }
}
