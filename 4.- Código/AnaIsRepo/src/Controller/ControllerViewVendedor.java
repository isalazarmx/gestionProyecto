/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelEmpresa;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jesus
 */
public class ControllerViewVendedor {
    JTextField idCliente;
    JTextField fecha;
    JTextField fechaPedido;
    JTextField fechaEnt;
    JTextField lugarEnt;
    JTextField horaEnt;
    JTextField codBarras;
    JTextField descripcion;
    JTextField price;
    JTextField ;
    JTextField fecha;
    JTextField fechaPedido;
    JTextField fechaEnt;
    JTextField lugarEnt;
    JTextField horaEnt;
    JTextField codBarras;
    JTextField descripcion;
    JTextField price;
    
    public ControllerViewVendedor(ArrayList components){
        this.nameBussines = (JTextField)components.get(0);
        this.rfc = (JTextField)components.get(1);
        this.street = (JTextField)components.get(2);
        this.numInt = (JTextField)components.get(3);
        this.numExt = (JTextField)components.get(4);
        this.col = (JTextField)components.get(5);
        this.codePost = (JTextField)components.get(6);
        this.pagWeb = (JTextField)components.get(7);
        this.eMail = (JTextField)components.get(8);
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(nameBussines, 25);
        ControllerValidation.limitarCaracteres(rfc, 15);
        ControllerValidation.limitarCaracteres(street, 40);
        ControllerValidation.limitarCaracteres(numInt, 6);
        ControllerValidation.soloNumeros(numInt);
        ControllerValidation.limitarCaracteres(numExt, 6);
        ControllerValidation.soloNumeros(numExt);
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
                emp.setColonia(reviewInfo(col,"Colonia",true));
                emp.setPagWeb(reviewInfo(pagWeb,"Página Web",true));
                if(!eMail.getText().equals("E-mail") && (!eMail.getText().contains("@") || eMail.getText().contains(" "))){
                    labelStatus.setForeground(new Color(153,0,0));
                    labelStatus.setText("Revise su correo electronico");
                }else{
                    emp.seteMail(reviewInfo(eMail,"E-mail",true));
                    if(ControllerConsults.addInfoBussines(emp)){
                        labelStatus.setText("Datos de empresa agregados");
                        hilo.resume();
                    }else
                        labelStatus.setText("Error interno para almacenar la información");
                }
            }else{
                labelStatus.setForeground(new Color(153,0,0));
                labelStatus.setText("Agregue el R.F.C. de la empresa");
            }
        }else{
            labelStatus.setForeground(new Color(153,0,0));
            labelStatus.setText("Agregue el nombre de la empresa");
        }
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

