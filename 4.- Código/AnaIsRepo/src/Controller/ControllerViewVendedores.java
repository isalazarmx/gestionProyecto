/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelUsuario;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jesus
 */
public class ControllerViewVendedores {
    JTextField name;
    JTextField aPaterno;
    JTextField aMaterno;
    JTextField username;
    JPasswordField pass1;
    JPasswordField pass2;
    JButton userData;
    
    public ControllerViewVendedores(ArrayList components){
        this.name = (JTextField)components.get(0);
        this.aPaterno = (JTextField)components.get(1);
        this.aMaterno = (JTextField)components.get(2);
        this.username = (JTextField)components.get(3);
        this.pass1 = (JPasswordField)components.get(4);
        this.pass2 = (JPasswordField)components.get(5);
        if(components.size() > 6)
            this.userData = (JButton)components.get(6);
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(name, 25);
        ControllerValidation.limitarCaracteres(aPaterno, 20);
        ControllerValidation.limitarCaracteres(aMaterno, 20);
        ControllerValidation.limitarCaracteres(username, 25);
        ControllerValidation.limitarCaracteres(pass1, 16);
        ControllerValidation.limitarCaracteres(pass2, 16);
    }
    
    public void addUser(JLabel labelStatus,int idEmpresa){
        if(!name.getText().equals("Nombre (*)") && !name.getText().isEmpty()){
            if(!username.getText().equals("Username (*)") && !username.getText().isEmpty()){
                if(!crearPass(pass1).equals("Password-01") && !pass1.getText().isEmpty()){
                    if(!crearPass(pass2).equals("Password-02") && !pass2.getText().isEmpty()){
                        if(!ControllerConsults.checkExistUser(username.getText())){
                            if(ControllerValidation.validarContrasenias(pass1,pass2)){
                                ModelUsuario user = new ModelUsuario();
                                user.setNombre(name.getText());
                                user.setaPaterno(reviewInfo(aPaterno,"Apellido paterno",true));
                                user.setaMaterno(reviewInfo(aMaterno,"Apellido materno",true));
                                user.setUsername(username.getText());
                                user.setPassword(crearPass(pass1));
                                user.setTipo(2);
                                user.setIdEmpresa(idEmpresa);
                                 if(ControllerConsults.addUser(user,false)){
                                    labelStatus.setText("Datos de administrador agregados");
                                }else
                                    labelStatus.setText("Error interno para almacenar la información");
                            }
                        }else
                            ControllerViewMsj.muestraMensajeGlobo("El nombre de usuario ya existe", username);
                    }else
                        ControllerViewMsj.muestraMensajeGlobo("Completa el formulario para la contraseña", pass2);
                }else
                    ControllerViewMsj.muestraMensajeGlobo("Ingresa una contraseña", pass1);
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agrega un username", username);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre de usuario", name);
    }
    
    public void guardarCambios(JLabel labelStatus,int idEmpresa,ModelUsuario user){
        if(!name.getText().equals("Nombre (*)") && !name.getText().isEmpty()){
            if(!username.getText().equals("Username (*)") && !username.getText().isEmpty()){
                if(!crearPass(pass1).equals("Password-01") && !pass1.getText().isEmpty()){
                    if(!crearPass(pass2).equals("Password-02") && !pass2.getText().isEmpty()){
                        if(acceptUsername(user)){
                            if(ControllerValidation.validarContrasenias(pass1,pass2)){
                                user.setNombre(name.getText());
                                user.setaPaterno(reviewInfo(aPaterno,"Apellido paterno",true));
                                user.setaMaterno(reviewInfo(aMaterno,"Apellido materno",true));
                                user.setUsername(username.getText());
                                user.setPassword(crearPass(pass1));
                                 if(ControllerConsults.modifUser(user)){
                                    labelStatus.setText("Datos almacenados con éxito");
                                    userData.setText("Bienvenido, "+user.getNombre()+" "+user.getaPaterno());
                                }else
                                    labelStatus.setText("Error interno para almacenar la información");
                            }
                        }else
                            ControllerViewMsj.muestraMensajeGlobo("El nombre de usuario ya existe", username);
                    }else
                        ControllerViewMsj.muestraMensajeGlobo("Completa el formulario para la contraseña", pass2);
                }else
                    ControllerViewMsj.muestraMensajeGlobo("Ingresa una contraseña", pass1);
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agrega un username", username);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre de usuario", name);
    }
    
    public boolean acceptUsername(ModelUsuario user){
        if(ControllerConsults.checkExistUser(username.getText())){
            if(user.getUsername().equals(username.getText()))
                return true;
            else
                return false;
        }else
            return true;
    }
    
    public void identificaInfo(ModelUsuario model){
        if(!model.getNombre().equals("")){
            name.setForeground(Color.black);
            name.setText(model.getNombre());
        }if(!model.getaPaterno().equals("")){
            aPaterno.setText(model.getaPaterno());
            aPaterno.setForeground(Color.black);
        }if(!model.getaMaterno().equals("")){
            aMaterno.setText(model.getaMaterno());
            aMaterno.setForeground(Color.black);
        }if(!model.getUsername().equals("")){
            username.setText(model.getUsername());
            username.setForeground(Color.black);
        }if(!model.getPassword().equals("")){
            pass1.setForeground(Color.black);
            pass2.setForeground(Color.black);
            pass1.setText(model.getPassword());
            pass2.setText(model.getPassword());
        }
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
