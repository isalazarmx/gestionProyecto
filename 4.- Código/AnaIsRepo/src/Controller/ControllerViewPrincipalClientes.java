/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelEmpresa;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Carolina
 */
public class ControllerViewPrincipalClientes {
    JTextField cNombre;
    JTextField cRFC;
    
    
    public ControllerViewPrincipalClientes(ArrayList components){
        this.cNombre = (JTextField)components.get(0);
        this.cRFC = (JTextField)components.get(1);
    
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(cNombre, 40);
        ControllerValidation.soloTexto(cNombre);
        ControllerValidation.limitarCaracteres(cRFC, 15);   
    }
}

