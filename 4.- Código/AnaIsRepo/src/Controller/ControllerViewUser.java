/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelUsuario;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jesus
 */
public class ControllerViewUser {
    JTextField name;
    JTextField aPaterno;
    JTextField aMaterno;
    JTextField username;
    JPasswordField pass1;
    JPasswordField pass2;
    
    public ControllerViewUser(ArrayList components){
        this.name = (JTextField)components.get(0);
        this.aPaterno = (JTextField)components.get(1);
        this.aMaterno = (JTextField)components.get(2);
        this.username = (JTextField)components.get(3);
        this.pass1 = (JPasswordField)components.get(4);
        this.pass2 = (JPasswordField)components.get(5);
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(name, 25);
        ControllerValidation.limitarCaracteres(aPaterno, 20);
        ControllerValidation.limitarCaracteres(aMaterno, 20);
        ControllerValidation.limitarCaracteres(username, 25);
        ControllerValidation.limitarCaracteres(pass1, 16);
        ControllerValidation.limitarCaracteres(pass2, 16);
    }
    
    public void next(JLabel labelStatus,Thread hilo,int idEmpresa,ModelUsuario user){
        if(!name.getText().equals("Nombre (*)") && !name.getText().isEmpty()){
            if(!username.getText().equals("Username (*)") && !username.getText().isEmpty()){
                if(!ControllerConsults.checkExistUser(username.getText())){
                    if(ControllerValidation.validarContrasenias(pass1,pass2)){
                        user = new ModelUsuario();
                        user.setNombre(name.getText());
                        user.setaPaterno(reviewInfo(aPaterno,"Apellido paterno",true));
                        user.setaMaterno(reviewInfo(aMaterno,"Apellido materno",true));
                        user.setUsername(username.getText());
                        user.setPassword(crearPass(pass1));
                        user.setIdEmpresa(idEmpresa);
                         if(ControllerConsults.addUser(user)){
                            labelStatus.setText("Datos de administrador agregados");
                            hilo.resume();
                        }else
                            labelStatus.setText("Error interno para almacenar la información");
                    }
                }else
                    ControllerViewMsj.muestraMensajeGlobo("El nombre de usuario ya existe", username);
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agrega un username", username);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre de usuario", name);
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