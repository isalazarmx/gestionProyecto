/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jesus
 */
public class ControllerViewAdministrador {
    
    JButton inicio;
    JButton productos;
    JButton inventario;
    JButton proveedores;
    JButton ventas;
    JButton reportes;
    String button01;
    String button02;
    String button03;
    String button04;
    String button05;
    String button06;
    
    public ControllerViewAdministrador(ArrayList components){
        this.button01 = "inicio";
        this.button02 = "producto";
        this.button03 = "inventario";
        this.button04 = "proveedores";
        this.button05 = "ventas";
        this.button06 = "reportes";
        this.inicio = (JButton)components.get(0);
        this.productos = (JButton)components.get(1);
        this.inventario = (JButton)components.get(2);
        this.proveedores = (JButton)components.get(3);
        this.ventas = (JButton)components.get(4);
        this.reportes = (JButton)components.get(5);
    }
    
    public void accionButton(int opc){
        confButton(inicio,button01,"Disable");
        confButton(productos,button02,"Disable");
        confButton(inventario,button03,"Disable");
        confButton(proveedores,button04,"Disable");
        confButton(ventas,button05,"Disable");
        confButton(reportes,button06,"Disable");
        switch (opc){
            case 1: confButton(inicio,button01,"Enable");break;
            case 2: confButton(productos,button02,"Enable");break;
            case 3: confButton(inventario,button03,"Enable");break;
            case 4: confButton(proveedores,button04,"Enable");break;
            case 5: confButton(ventas,button05,"Enable");break;
            case 6: confButton(reportes,button06,"Enable");break;
        }
    }
    
    private void confButton(JButton button, String nomImagen, String accion){
        button.setIcon(new ImageIcon(getClass().getResource("/Image/"+nomImagen+""+accion+".png")));
    }
}
