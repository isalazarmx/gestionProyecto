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
public class ControllerViewClientes {
    JTextField Nombre;
    JTextField acApellidoPaterno;
    JTextField acApellidoMaterno;
    JTextField acRFC;
    JTextField acTelefono;
    JTextField acTelCelular;
    JTextField acEmail;
    
    JTextField acCalle;
    JTextField acCiudad;
    JTextField acColonia;
    JComboBox acEstados;
    JTextField acCP;
    JTextField acNoExt;
    JTextField acNoInt;
    
    public ControllerViewClientes(ArrayList components){
        this.Nombre = (JTextField)components.get(0);
        this.acApellidoPaterno = (JTextField)components.get(1);
        this.acApellidoMaterno = (JTextField)components.get(2);
        this.acRFC = (JTextField)components.get(3);
        this.acTelefono = (JTextField)components.get(4);
        this.acTelCelular = (JTextField)components.get(5);
        this.acEmail = (JTextField)components.get(6);
        this.acCalle = (JTextField)components.get(7);
        this.acCiudad = (JTextField)components.get(8);
        this.acColonia = (JTextField)components.get(9);
        this.acEstados = (JComboBox)components.get(10);
        this.acCP = (JTextField)components.get(11);
        this.acNoExt = (JTextField)components.get(12);
        this.acNoInt = (JTextField)components.get(13);
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(Nombre, 25);
        ControllerValidation.soloTexto(Nombre);
        ControllerValidation.limitarCaracteres(acApellidoPaterno, 20);
        ControllerValidation.soloTexto(acApellidoPaterno);
        ControllerValidation.limitarCaracteres(acApellidoMaterno, 20);
        ControllerValidation.soloTexto(acApellidoMaterno);
        ControllerValidation.limitarCaracteres(acRFC, 15);
        ControllerValidation.limitarCaracteres(acTelefono, 12);
        ControllerValidation.soloNumeros(acTelefono);
        ControllerValidation.limitarCaracteres(acTelCelular, 12);
        ControllerValidation.soloNumeros(acTelCelular);
        ControllerValidation.limitarCaracteres(acEmail,45 );
        ControllerValidation.limitarCaracteres(acCalle,45);
        
        ControllerValidation.limitarCaracteres(acNoExt,6 );
        ControllerValidation.soloNumeros(acNoExt);
        ControllerValidation.limitarCaracteres(acNoInt, 6);     
        ControllerValidation.soloNumeros(acNoInt);
        ControllerValidation.limitarCaracteres(acColonia, 20);
        ControllerValidation.limitarCaracteres(acCiudad, 20);
        ControllerValidation.limitarCaracteres(acCP, 5);
        ControllerValidation.soloNumeros(acCP);
        
        
        
    }
    
//    public void next(JLabel labelStatus,Thread hilo,ModelEmpresa emp){
//        if(!nameBussines.getText().equals("Nombre de la empresa (*)") && !nameBussines.getText().isEmpty()){
//            if(!rfc.getText().equals("R.F.C. (*)") && !rfc.getText().isEmpty()){
//                emp.setNombre(nameBussines.getText());
//                emp.setRFC(rfc.getText().toUpperCase().trim());
//                emp.setCalle(reviewInfo(street,"Calle",true));
//                emp.setCodigoPostal(Integer.parseInt(reviewInfo(codePost,"C.P.",false)));
//                emp.setNumINT(Integer.parseInt(reviewInfo(numInt,"No. Int.",false)));
//                emp.setNumExt(Integer.parseInt(reviewInfo(numExt,"No. Ext.",false)));
//                emp.setCiudad(reviewInfo(ciudad,"Ciudad",true));
//                emp.setColonia(reviewInfo(col,"Colonia",true));
//                emp.setEstado((String)estado.getItemAt(estado.getSelectedIndex()));
//                emp.setPagWeb(reviewInfo(pagWeb,"Página Web",true));
//                if(!eMail.getText().equals("E-mail") && (!eMail.getText().contains("@") || eMail.getText().contains(" ")))
//                    ControllerViewMsj.muestraMensajeGlobo("Debes ingresar un correo electronico valido", eMail);
//                else{
//                    emp.seteMail(reviewInfo(eMail,"E-mail",true));
//                    if(ControllerConsults.addInfoBussines(emp)){
//                        labelStatus.setText("Los datos se han agregado con éxito");
//                        hilo.resume();
//                    }else
//                        labelStatus.setText("Error interno para almacenar la información");
//                }
//            }else
//                ControllerViewMsj.muestraMensajeGlobo("Agregua el R.F.C. de tu empresa", rfc);
//        }else
//            ControllerViewMsj.muestraMensajeGlobo("Agrega el nombre de tu empresa", nameBussines);
//    }
//    
//    public void modifEmpresa(JLabel labelStatus,ModelEmpresa emp){
//        if(!nameBussines.getText().equals("Nombre de la empresa (*)") && !nameBussines.getText().isEmpty()){
//            if(!rfc.getText().equals("R.F.C. (*)") && !rfc.getText().isEmpty()){
//                emp.setNombre(nameBussines.getText());
//                emp.setRFC(rfc.getText().toUpperCase().trim());
//                emp.setCalle(reviewInfo(street,"Calle",true));
//                emp.setCodigoPostal(Integer.parseInt(reviewInfo(codePost,"C.P.",false)));
//                emp.setNumINT(Integer.parseInt(reviewInfo(numInt,"No. Int.",false)));
//                emp.setNumExt(Integer.parseInt(reviewInfo(numExt,"No. Ext.",false)));
//                emp.setCiudad(reviewInfo(ciudad,"Ciudad",true));
//                emp.setColonia(reviewInfo(col,"Colonia",true));
//                emp.setEstado((String)estado.getItemAt(estado.getSelectedIndex()));
//                emp.setPagWeb(reviewInfo(pagWeb,"Página Web",true));
//                if(!eMail.getText().equals("E-mail") && (!eMail.getText().contains("@") || eMail.getText().contains(" ")))
//                    ControllerViewMsj.muestraMensajeGlobo("Debes ingresar un correo electronico valido", eMail);
//                else{
//                    emp.seteMail(reviewInfo(eMail,"E-mail",true));
//                    if(ControllerConsults.modifEmpresa(emp)){
//                        labelStatus.setText("Los datos se han agregado con éxito");
//                    }else
//                        labelStatus.setText("Error interno para almacenar la información");
//                }
//            }else
//                ControllerViewMsj.muestraMensajeGlobo("Agregua el R.F.C. de tu empresa", rfc);
//        }else
//            ControllerViewMsj.muestraMensajeGlobo("Agrega el nombre de tu empresa", nameBussines);
//    }
//    
//    private String reviewInfo(JTextField box, String value,boolean flag){
//        if(flag){
//            if(box.getText().equals(value))
//                return "";
//            else
//                return box.getText();
//        }else{
//            if(box.getText().equals(value))
//                return "0";
//            else
//                return box.getText();
//        }   
//    }
//    
//    public void identificaInfo(ModelEmpresa model){
//        if(!model.getNombre().equals("")){
//            nameBussines.setForeground(Color.black);
//            nameBussines.setText(model.getNombre());
//        }if(!model.getRFC().equals("")){
//            rfc.setForeground(Color.black);
//            rfc.setText(model.getRFC());
//        }if(!model.getEstado().equals("")){
//            for (int i = 0; i < estado.getModel().getSize(); i++) {
//                String est = (String)estado.getItemAt(i);
//                if(est.equals(model.getEstado())){
//                    estado.setSelectedIndex(i);
//                    break;
//                }
//            }
//        }if(!model.getCiudad().equals("")){
//            ciudad.setForeground(Color.black);
//            ciudad.setText(model.getCiudad());
//        }if(!model.getColonia().equals("")){
//            col.setForeground(Color.black);
//            col.setText(model.getColonia());
//        }if(!model.getCalle().equals("")){
//            street.setForeground(Color.black);
//            street.setText(model.getCalle());
//        }if(model.getCodigoPostal() != 0 ){
//            codePost.setForeground(Color.black);
//            codePost.setText(""+model.getCodigoPostal());
//        }if(model.getNumINT() != 0 ){
//            numInt.setForeground(Color.black);
//            numInt.setText(""+model.getNumINT());
//        }if(model.getNumExt() != 0 ){
//            numExt.setForeground(Color.black);
//            numExt.setText(""+model.getNumExt());
//        }if(!model.getPagWeb().equals("")){
//            pagWeb.setForeground(Color.black);
//            pagWeb.setText(model.getPagWeb());
//        }if(!model.geteMail().equals("")){
//            eMail.setForeground(Color.black);
//            eMail.setText(model.geteMail());
//        }
//    }
}

