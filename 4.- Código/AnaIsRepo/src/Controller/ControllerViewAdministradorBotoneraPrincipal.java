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
public class ControllerViewAdministradorBotoneraPrincipal {
    
    JButton inicio;
    JButton productos;
    JButton inventario;
    JButton clientes;
    JButton proveedores;
    JButton ventas;
    JButton pedidos;
    JButton reportes;
    String button01;
    String button02;
    String button03;
    String button04;
    String button05;
    String button06;
    String button07;
    String button08;
    
    public ControllerViewAdministradorBotoneraPrincipal(ArrayList components){
        this.button01 = "inicio";
        this.button02 = "producto";
        this.button03 = "inventario";
        this.button04 = "clientes";
        this.button05 = "proveedores";
        this.button06 = "ventas";
        this.button07 = "pedidos";
        this.button08 = "reportes";
        this.inicio = (JButton)components.get(0);
        this.productos = (JButton)components.get(1);
        this.inventario = (JButton)components.get(2);
        this.clientes = (JButton)components.get(3);
        this.proveedores = (JButton)components.get(4);
        this.ventas = (JButton)components.get(5);
        this.pedidos = (JButton)components.get(6);
        this.reportes = (JButton)components.get(7);
    }
    
    public void accionButton(int opc){
        confButton(inicio,button01,"Disable");
        confButton(productos,button02,"Disable");
        confButton(inventario,button03,"Disable");
        confButton(clientes,button04,"Disable");
        confButton(proveedores,button05,"Disable");
        confButton(ventas,button06,"Disable");
        confButton(pedidos,button07,"Disable");
        confButton(reportes,button08,"Disable");
        switch (opc){
            case 1: confButton(inicio,button01,"Enable");break;
            case 2: confButton(productos,button02,"Enable");break;
            case 3: confButton(inventario,button03,"Enable");break;
            case 4: confButton(clientes,button04,"Enable");break;
            case 5: confButton(proveedores,button05,"Enable");break;
            case 6: confButton(ventas,button06,"Enable");break;
            case 7: confButton(pedidos,button07,"Enable");break;
            case 8: confButton(reportes,button08,"Enable");break;
            case 9:break;    
        }
    }
    
    private void confButton(JButton button, String nomImagen, String accion){
        button.setIcon(new ImageIcon(getClass().getResource("/Image/"+nomImagen+""+accion+".png")));
    }
}
