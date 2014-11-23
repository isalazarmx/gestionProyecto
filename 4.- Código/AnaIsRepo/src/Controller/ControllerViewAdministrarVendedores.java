/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelUsuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus
 */
public class ControllerViewVendedores {
    JTextField nombre;
    JTextField username;
    JLabel labelCount;
    ControllerTables controllerTable;
    
    public ControllerViewVendedores(ArrayList components){
        this.controllerTable = new ControllerTables();
        this.nombre = (JTextField)components.get(0);
        this.username = (JTextField)components.get(1);
        this.labelCount = (JLabel)components.get(2);
        controllerTable.setTabla((JTable)components.get(3));
        controllerTable.setModelTable((DefaultTableModel)components.get(4));
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(nombre, 50);
        ControllerValidation.limitarCaracteres(username, 25);
        controllerTable.getTabla().setModel(controllerTable.getModelTable());
    }
    
    public void buscaUsuario(boolean flag){
        if(flag || ((!nombre.getText().equals("Nombre") && !nombre.getText().isEmpty())
            || (!username.getText().equals("Username") && !username.getText().isEmpty()))){
            limpiaBusqueda();
            String nom = reviewInfo(nombre,"Nombre",true);
            String user = reviewInfo(username,"Username",true);
            List list = ControllerConsults.buscaUsuario(nom, user, flag);
            int count = list.size();
            if(!list.isEmpty()){
                for (int i = 0; i < list.size(); i++) {
                    ModelUsuario usuario = (ModelUsuario)list.get(i);
                    String[] datos = {usuario.getNombre(),usuario.getaPaterno(),usuario.getaMaterno(),usuario.getUsername(),usuario.getPassword()};
                    controllerTable.agregarDatos(datos);
                }
                if(list.size() > 1)
                    labelCount.setText("Lo sentimos, no hay coincidencias con la busqueda, pero encontramos "+count+" posibles resutaldos");
                else if ((((ModelUsuario)list.get(0)).getNombre().equals(nom) || ((ModelUsuario)list.get(0)).getUsername().equals(user)))
                    labelCount.setText("Busqueda realizada con éxito");
                else
                    labelCount.setText("Lo sentimos, no hay coincidencias con la busqueda, pero encontramos "+count+" posibles resutaldos");
            }else
                labelCount.setText("Lo sentimos, no se encontro ninguna coincidencía");
        }else{
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre o un username para iniciar la busqueda", nombre);
        }
    }
    
    public void limpiaBusqueda(){
        int cantidadEliminar = controllerTable.getTabla().getRowCount();
        for (int i = cantidadEliminar-1;i>=0;i--)
            controllerTable.getModelTable().removeRow(i);
    }
    
//    public void addUser(JLabel labelStatus,int idEmpresa){
//        if(!nombre.getText().equals("Nombre") && !nombre.getText().isEmpty()){
//            if(!username.getText().equals("Username") && !username.getText().isEmpty()){
//                if(!crearPass(pass1).equals("Password-01") && !pass1.getText().isEmpty()){
//                    if(!crearPass(pass2).equals("Password-02") && !pass2.getText().isEmpty()){
//                        if(!ControllerConsults.checkExistUser(username.getText())){
//                            if(ControllerValidation.validarContrasenias(pass1,pass2)){
//                                ModelUsuario user = new ModelUsuario();
//                                user.setNombre(name.getText());
//                                user.setaPaterno(reviewInfo(aPaterno,"Apellido paterno",true));
//                                user.setaMaterno(reviewInfo(aMaterno,"Apellido materno",true));
//                                user.setUsername(username.getText());
//                                user.setPassword(crearPass(pass1));
//                                user.setTipo(2);
//                                user.setIdEmpresa(idEmpresa);
//                                 if(ControllerConsults.addUser(user,false)){
//                                    labelStatus.setText("Vendedor agregado con éxito");
//                                    limpiaCampos();
//                                 }else
//                                    labelStatus.setText("Error interno para almacenar la información");
//                            }
//                        }else
//                            ControllerViewMsj.muestraMensajeGlobo("El nombre de usuario ya existe", username);
//                    }else
//                        ControllerViewMsj.muestraMensajeGlobo("Completa el formulario para la contraseña", pass2);
//                }else
//                    ControllerViewMsj.muestraMensajeGlobo("Ingresa una contraseña", pass1);
//            }else
//                ControllerViewMsj.muestraMensajeGlobo("Agrega un username", username);
//        }else
//            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre de usuario", name);
//    }
    
//    public void guardarCambios(JLabel labelStatus,int idEmpresa,ModelUsuario user){
//        if(!name.getText().equals("Nombre (*)") && !name.getText().isEmpty()){
//            if(!username.getText().equals("Username (*)") && !username.getText().isEmpty()){
//                if(!crearPass(pass1).equals("Password-01") && !pass1.getText().isEmpty()){
//                    if(!crearPass(pass2).equals("Password-02") && !pass2.getText().isEmpty()){
//                        if(acceptUsername(user)){
//                            if(ControllerValidation.validarContrasenias(pass1,pass2)){
//                                user.setNombre(name.getText());
//                                user.setaPaterno(reviewInfo(aPaterno,"Apellido paterno",true));
//                                user.setaMaterno(reviewInfo(aMaterno,"Apellido materno",true));
//                                user.setUsername(username.getText());
//                                user.setPassword(crearPass(pass1));
//                                 if(ControllerConsults.modifUser(user)){
//                                    labelStatus.setText("Datos almacenados con éxito");
//                                }else
//                                    labelStatus.setText("Error interno para almacenar la información");
//                            }
//                        }else
//                            ControllerViewMsj.muestraMensajeGlobo("El nombre de usuario ya existe", username);
//                    }else
//                        ControllerViewMsj.muestraMensajeGlobo("Completa el formulario para la contraseña", pass2);
//                }else
//                    ControllerViewMsj.muestraMensajeGlobo("Ingresa una contraseña", pass1);
//            }else
//                ControllerViewMsj.muestraMensajeGlobo("Agrega un username", username);
//        }else
//            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre de usuario", name);
//    }
    
//    public boolean acceptUsername(ModelUsuario user){
//        if(ControllerConsults.checkExistUser(username.getText())){
//            if(user.getUsername().equals(username.getText()))
//                return true;
//            else
//                return false;
//        }else
//            return true;
//    }
    
//    public void identificaInfo(ModelUsuario model){
//        if(!model.getNombre().equals("")){
//            name.setForeground(Color.black);
//            name.setText(model.getNombre());
//        }if(!model.getaPaterno().equals("")){
//            aPaterno.setText(model.getaPaterno());
//            aPaterno.setForeground(Color.black);
//        }if(!model.getaMaterno().equals("")){
//            aMaterno.setText(model.getaMaterno());
//            aMaterno.setForeground(Color.black);
//        }if(!model.getUsername().equals("")){
//            username.setText(model.getUsername());
//            username.setForeground(Color.black);
//        }if(!model.getPassword().equals("")){
//            pass1.setForeground(Color.black);
//            pass2.setForeground(Color.black);
//            pass1.setText(model.getPassword());
//            pass2.setText(model.getPassword());
//        }
//    }
    
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
    
    public void limpiaCampos(){
        limpiaJtextField(nombre,"Nombre");
        limpiaJtextField(username,"Username");
    }
    
    private void limpiaJtextField(JTextField box, String msj){
        box.setForeground(new Color(180,180,180));
        box.setText(msj);
    }
}
