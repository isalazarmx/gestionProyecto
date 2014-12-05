/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jesus
 */
public class ControllerImagenes {
    Image foto;
    private File ruta;
    
    public void buscaImagen(JPanel panel, JButton imagen){
        JFileChooser archivo = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("Formatos de archivos JPEG(*.jpeg,*.jpg), PNG(*.png)","jpg","jpeg","png");
        archivo.addChoosableFileFilter(filtroImagen);
        archivo.setDialogTitle("Abrir archivo");
        archivo.setDialogType(1);
        File rutaTemp = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"Pictures");
        archivo.setCurrentDirectory(rutaTemp);
        int ventana = archivo.showOpenDialog(panel);
        if(ventana == JFileChooser.APPROVE_OPTION){
            setRuta(archivo.getSelectedFile());
            foto = panel.getToolkit().getImage(String.valueOf(getRuta()));
            foto = foto.getScaledInstance(panel.getWidth(),panel.getHeight(), Image.SCALE_DEFAULT);
            imagen.setIcon(new ImageIcon(foto));
        }
    }
    
    public void cargaImagen(Blob imagen,JPanel panel,JButton button){
        try {
            byte[] data = imagen.getBytes(1,(int)imagen.length());
            BufferedImage img = null;
            try{
                img = ImageIO.read(new ByteArrayInputStream(data));
            }catch(IOException ex){
                Logger.getLogger(ControllerImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
            foto = img;
            foto = foto.getScaledInstance(panel.getWidth(),panel.getHeight(), Image.SCALE_DEFAULT);
            button.setIcon(new ImageIcon(foto));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the ruta
     */
    public File getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(File ruta) {
        this.ruta = ruta;
    }
}
