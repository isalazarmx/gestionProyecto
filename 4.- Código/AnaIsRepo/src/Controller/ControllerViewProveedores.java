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
public class ControllerViewProveedores {
    JTextField pNombre;
    JTextField pApellidoPaterno;
    JTextField pApellidoMaterno;
    JTextField pRFC;
    JTextField pMarca;
    JTextField pEmpresa;
    JTextField pTelefono;
    JTextField pTelCelular;
    JTextField pEmail;    
    JTextField pCalle;
    JTextField pCiudad;
    JTextField pColonia;
    JComboBox pEstados;
    JTextField pCP;
    JTextField pNoExt;
    JTextField pNoInt;
    
    public ControllerViewProveedores(ArrayList components){
        this.pNombre = (JTextField)components.get(0);
        this.pApellidoPaterno = (JTextField)components.get(1);
        this.pApellidoMaterno = (JTextField)components.get(2);
        this.pRFC = (JTextField)components.get(3);
        this.pMarca = (JTextField)components.get(4);
        this.pEmpresa = (JTextField)components.get(5);     
        this.pTelefono = (JTextField)components.get(6);
        this.pTelCelular = (JTextField)components.get(7);
        this.pEmail = (JTextField)components.get(8);
        this.pCalle = (JTextField)components.get(9);
        this.pCiudad = (JTextField)components.get(10);
        this.pColonia = (JTextField)components.get(11);
        this.pEstados = (JComboBox)components.get(12);
        this.pCP = (JTextField)components.get(13);
        this.pNoExt = (JTextField)components.get(14);
        this.pNoInt = (JTextField)components.get(15);
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(pNombre, 25);
        ControllerValidation.soloTexto(pNombre);
        ControllerValidation.limitarCaracteres(pApellidoPaterno, 20);
        ControllerValidation.soloTexto(pApellidoPaterno);
        ControllerValidation.limitarCaracteres(pApellidoMaterno, 20);
        ControllerValidation.soloTexto(pApellidoMaterno);
        ControllerValidation.limitarCaracteres(pMarca, 20);
        ControllerValidation.limitarCaracteres(pEmpresa, 25);
        ControllerValidation.limitarCaracteres(pRFC, 15);   
        ControllerValidation.limitarCaracteres(pTelefono, 12);
        ControllerValidation.soloNumeros(pTelefono);
        ControllerValidation.limitarCaracteres(pTelCelular, 12);
        ControllerValidation.soloNumeros(pTelCelular);       
        ControllerValidation.limitarCaracteres(pEmail,45 );
        ControllerValidation.limitarCaracteres(pCalle,45);
        ControllerValidation.limitarCaracteres(pCiudad, 20);
        ControllerValidation.limitarCaracteres(pColonia, 20);
        ControllerValidation.limitarCaracteres(pCP, 5);
        ControllerValidation.soloNumeros(pCP);
        ControllerValidation.limitarCaracteres(pNoExt,6 );
        ControllerValidation.soloNumeros(pNoExt);
        ControllerValidation.limitarCaracteres(pNoInt, 6);     
        ControllerValidation.soloNumeros(pNoInt);
        
        
        
        
        
        
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

