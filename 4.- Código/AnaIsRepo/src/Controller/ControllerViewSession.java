/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelUsuario;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jesus
 */
public class ControllerViewSession {
    JTextField username;
    JPasswordField pass1;
    
    public ControllerViewSession(ArrayList components){
        this.username = (JTextField)components.get(0);
        this.pass1 = (JPasswordField)components.get(1);
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(username, 25);
        ControllerValidation.limitarCaracteres(pass1, 16);
    }
    
    public void next(JLabel labelStatus,Thread hilo, ModelUsuario user){
        if(!username.getText().equals("Nombre de usuario") && !username.getText().isEmpty()){
            if(!crearPass(pass1).equals("Password-01") && !pass1.getText().isEmpty()){
                if(ControllerConsults.validateSession(user)){
                    labelStatus.setText("Iniciando sistema");
                    hilo.resume();
                }else
                    ControllerViewMsj.muestraMensajeGlobo("Usuario y/o contraseña invalidos", username);
            }else
                ControllerViewMsj.muestraMensajeGlobo("Ingresa una contraseña", pass1);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre de usuario", username);
    }
    
    private String crearPass(JPasswordField pass) {
        String pas = "";
        char[] car = pass.getPassword();
        for (int i = 0; i < car.length; i++)
           pas = pas + car[i];
        return pas;
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