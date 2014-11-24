/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author Teté
 */
public class ControllerViewPedidos {
    JTextField idCliente;
    JTextField nombreCliente;
    JTextField fechaPedido;
    
    
public ControllerViewPedidos(ArrayList components){
    this.idCliente = (JTextField)components.get(0);
    this.fechaPedido = (JTextField)components.get(1);
    this.nombreCliente = (JTextField)components.get(2);
    }

public void validations(){
    ControllerValidation.soloNumeros(idCliente);
    ControllerValidation.limitarCaracteres(nombreCliente, 25);
    ControllerValidation.soloTexto(nombreCliente);
    ControllerValidation.validarFecha(fechaPedido, null);
    ControllerValidation.soloNumeros(fechaPedido);
}
    
private String reviewInfo(JTextField box, String value,boolean flag){
        if(flag){
            if(box.getText().equals(value))
                return "";
            else
                return box.getText();
        }else{
            if(box.getText().equals(value))
                return "0";
            else
                return box.getText();
        }
        
    }
    
}
