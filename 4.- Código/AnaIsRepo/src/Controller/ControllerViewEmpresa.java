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
 * @author Jesus
 */
public class ControllerViewEmpresa {
    JTextField nameBussines;
    JTextField rfc;
    JTextField street;
    JTextField numInt;
    JTextField numExt;
    JTextField ciudad;
    JTextField col;
    JComboBox estado;
    JTextField codePost;
    JTextField pagWeb;
    JTextField eMail;
    
    public ControllerViewEmpresa(ArrayList components){
        this.nameBussines = (JTextField)components.get(0);
        this.rfc = (JTextField)components.get(1);
        this.street = (JTextField)components.get(2);
        this.numInt = (JTextField)components.get(3);
        this.numExt = (JTextField)components.get(4);
        this.ciudad = (JTextField)components.get(5);
        this.col = (JTextField)components.get(6);
        this.estado = (JComboBox)components.get(7);
        this.codePost = (JTextField)components.get(8);
        this.pagWeb = (JTextField)components.get(9);
        this.eMail = (JTextField)components.get(10);
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(nameBussines, 25);
        ControllerValidation.limitarCaracteres(rfc, 15);
        ControllerValidation.limitarCaracteres(street, 40);
        ControllerValidation.limitarCaracteres(numInt, 6);
        ControllerValidation.soloNumeros(numInt);
        ControllerValidation.limitarCaracteres(numExt, 6);
        ControllerValidation.soloNumeros(numExt);
        ControllerValidation.limitarCaracteres(ciudad, 25);
        ControllerValidation.limitarCaracteres(col, 25);
        ControllerValidation.limitarCaracteres(codePost, 5);
        ControllerValidation.soloNumeros(codePost);
        ControllerValidation.limitarCaracteres(pagWeb, 250);
        ControllerValidation.limitarCaracteres(eMail, 45);
    }
    
    public void next(JLabel labelStatus,Thread hilo,ModelEmpresa emp){
        if(!nameBussines.getText().equals("Nombre de la empresa (*)") && !nameBussines.getText().isEmpty()){
            if(!rfc.getText().equals("R.F.C. (*)") && !rfc.getText().isEmpty()){
                emp.setNombre(nameBussines.getText());
                emp.setRFC(rfc.getText().toUpperCase().trim());
                emp.setCalle(reviewInfo(street,"Calle",true));
                emp.setCodigoPostal(Integer.parseInt(reviewInfo(codePost,"C.P.",false)));
                emp.setNumINT(Integer.parseInt(reviewInfo(numInt,"No. Int.",false)));
                emp.setNumExt(Integer.parseInt(reviewInfo(numExt,"No. Ext.",false)));
                emp.setCiudad(reviewInfo(ciudad,"Ciudad",true));
                emp.setColonia(reviewInfo(col,"Colonia",true));
                emp.setEstado((String)estado.getItemAt(estado.getSelectedIndex()));
                emp.setPagWeb(reviewInfo(pagWeb,"Página Web",true));
                if(!eMail.getText().equals("E-mail") && (!eMail.getText().contains("@") || eMail.getText().contains(" ")))
                    ControllerViewMsj.muestraMensajeGlobo("Debes ingresar un correo electronico valido", eMail);
                else{
                    emp.seteMail(reviewInfo(eMail,"E-mail",true));
                    if(ControllerConsults.addInfoBussines(emp)){
                        labelStatus.setText("Los datos se han agregado con éxito");
                        hilo.resume();
                    }else
                        labelStatus.setText("Error interno para almacenar la información");
                }
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agregua el R.F.C. de tu empresa", rfc);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega el nombre de tu empresa", nameBussines);
    }
    
    public void modifEmpresa(JLabel labelStatus,ModelEmpresa emp){
        if(!nameBussines.getText().equals("Nombre de la empresa (*)") && !nameBussines.getText().isEmpty()){
            if(!rfc.getText().equals("R.F.C. (*)") && !rfc.getText().isEmpty()){
                emp.setNombre(nameBussines.getText());
                emp.setRFC(rfc.getText().toUpperCase().trim());
                emp.setCalle(reviewInfo(street,"Calle",true));
                emp.setCodigoPostal(Integer.parseInt(reviewInfo(codePost,"C.P.",false)));
                emp.setNumINT(Integer.parseInt(reviewInfo(numInt,"No. Int.",false)));
                emp.setNumExt(Integer.parseInt(reviewInfo(numExt,"No. Ext.",false)));
                emp.setCiudad(reviewInfo(ciudad,"Ciudad",true));
                emp.setColonia(reviewInfo(col,"Colonia",true));
                emp.setEstado((String)estado.getItemAt(estado.getSelectedIndex()));
                emp.setPagWeb(reviewInfo(pagWeb,"Página Web",true));
                if(!eMail.getText().equals("E-mail") && (!eMail.getText().contains("@") || eMail.getText().contains(" ")))
                    ControllerViewMsj.muestraMensajeGlobo("Debes ingresar un correo electronico valido", eMail);
                else{
                    emp.seteMail(reviewInfo(eMail,"E-mail",true));
                    if(ControllerConsults.modifEmpresa(emp)){
                        labelStatus.setText("Los datos se han agregado con éxito");
                    }else
                        labelStatus.setText("Error interno para almacenar la información");
                }
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agregua el R.F.C. de tu empresa", rfc);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega el nombre de tu empresa", nameBussines);
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
    
    public void identificaInfo(ModelEmpresa model){
        if(!model.getNombre().equals("")){
            nameBussines.setForeground(Color.black);
            nameBussines.setText(model.getNombre());
        }if(!model.getRFC().equals("")){
            rfc.setForeground(Color.black);
            rfc.setText(model.getRFC());
        }if(!model.getEstado().equals("")){
            for (int i = 0; i < estado.getModel().getSize(); i++) {
                String est = (String)estado.getItemAt(i);
                if(est.equals(model.getEstado())){
                    estado.setSelectedIndex(i);
                    break;
                }
            }
        }if(!model.getCiudad().equals("")){
            ciudad.setForeground(Color.black);
            ciudad.setText(model.getCiudad());
        }if(!model.getColonia().equals("")){
            col.setForeground(Color.black);
            col.setText(model.getColonia());
        }if(!model.getCalle().equals("")){
            street.setForeground(Color.black);
            street.setText(model.getCalle());
        }if(model.getCodigoPostal() != 0 ){
            codePost.setForeground(Color.black);
            codePost.setText(""+model.getCodigoPostal());
        }if(model.getNumINT() != 0 ){
            numInt.setForeground(Color.black);
            numInt.setText(""+model.getNumINT());
        }if(model.getNumExt() != 0 ){
            numExt.setForeground(Color.black);
            numExt.setText(""+model.getNumExt());
        }if(!model.getPagWeb().equals("")){
            pagWeb.setForeground(Color.black);
            pagWeb.setText(model.getPagWeb());
        }if(!model.geteMail().equals("")){
            eMail.setForeground(Color.black);
            eMail.setText(model.geteMail());
        }
    }
}

