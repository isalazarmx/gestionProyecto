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
public class ControllerViewPrincipalProveedor {
    JTextField pNombre;
    JTextField pRFC;
    
    
    public ControllerViewPrincipalProveedor(ArrayList components){
        this.pNombre = (JTextField)components.get(0);
        this.pRFC = (JTextField)components.get(1);
    
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(pNombre, 40);
        ControllerValidation.soloTexto(pNombre);
        ControllerValidation.limitarCaracteres(pRFC, 15);   
    }
}

