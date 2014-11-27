/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelProveedor;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Carolina
 */
public class ControllerViewProveedor {
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
    
    public ControllerViewProveedor(ArrayList components){
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
    
    public void addProveedor(JTextField acID,JLabel labelStatus,ModelProveedor proveedor){
        if(validaCampos()){
            if(DataBase.DataBaseProveedor.addProveedor(proveedor)){
                labelStatus.setText("Proveedor agregado con éxito");
                limpiaCampos();
                acID.setText(DataBase.DataBaseCliente.verProximoID());
            }else
                labelStatus.setText("Error interno para almacenar la información");
        }
                            
    }

    private boolean validaCampos(){
        if(!pNombre.getText().equals("Nombre (*)") && !pNombre.getText().isEmpty()){
            if(!pApellidoPaterno.getText().equals("Apellido Paterno (*)") && !pApellidoPaterno.getText().isEmpty()){
                if(!pMarca.getText().equals("Marca (*)") && !pEmail.getText().isEmpty()){
                    if(!pMarca.getText().equals("Empresa (*)") && !pEmail.getText().isEmpty()){
                        if(!pTelCelular.getText().equals("xx-xxx-xxxxxxx (*)") && !pTelCelular.getText().isEmpty()){
                            if(!pCP.getText().equals("xxxxx (*)") && !pCP.getText().isEmpty()){
                                return true;
                            }else
                                ControllerViewMsj.muestraMensajeGlobo("Agrega un código postal", pCP);
                        }else
                            ControllerViewMsj.muestraMensajeGlobo("Agrega un teléfono móvil", pTelCelular);
                    }else
                        ControllerViewMsj.muestraMensajeGlobo("Agrega una empresa", pEmpresa);
                }else
                    ControllerViewMsj.muestraMensajeGlobo("Agrega una marca", pMarca);
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agrega un apellido paterno",pApellidoPaterno);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre para el cliente", pNombre);
        return false;
    }
    
    public boolean modificaProveedor(JLabel labelStatus,ModelProveedor proveedor){
        boolean flag = false;
        if(validaCampos()){
            if(DataBase.DataBaseProveedor.modifProveedor(proveedor)){
                ControllerViewMsj.informacion(pNombre.getText()+" modificado con éxito","Modificación de usuario");
                flag = true;
            }else
                labelStatus.setText("Error interno para almacenar la información");
        }
        return flag;
    }
    
    public ModelProveedor creaModelo(ModelProveedor model){
            model.setNombre(reviewInfo(pNombre,"Nombre (*)", true));
            model.setaPaterno(reviewInfo(pApellidoPaterno,"Apellido Paterno (*)", true));
            model.setaMaterno(reviewInfo(pApellidoMaterno,"Apellido Materno", true));
            model.setRFC(reviewInfo(pRFC,"R.F.C.", true));
            model.setEmpresa(reviewInfo(pEmpresa,"Empresa (*)",true));
            model.setTelFijo(reviewInfo(pTelefono,"xx-xxx-xxxxxxx", true));
            model.setTelCel(reviewInfo(pTelCelular,"xx-xxx-xxxxxxx (*)", true));
            model.seteMail(reviewInfo(pEmail,"cliente@anais.com (*)", true));
            model.setCalle(reviewInfo(pCalle,"Calle", true));
            model.setCiudad(reviewInfo(pCiudad,"Ciudad", true));
            model.setColonia(reviewInfo(pColonia,"Colonia", true));
            model.setMarca(reviewInfo(pMarca,"Marca (*)",true));
            model.setEstado((String)pEstados.getItemAt(pEstados.getSelectedIndex()));
            model.setCodigoPostal(Integer.parseInt(reviewInfo(pCP,"xxxxx (*)", false)));
            model.setNumExt(Integer.parseInt(reviewInfo(pNoExt,"No.Ext.", false)));
            model.setNumInt(Integer.parseInt(reviewInfo(pNoInt,"No.Int.", false)));
            return model;
    }
    
    private String reviewInfo(JTextField box, String value,boolean flag){
        if(flag){
           if(box.getText().equals(value) || box.getText().equals(""))
               return "";
           else
               return box.getText();
        }else{
           if(box.getText().equals(value) || box.getText().equals(""))
               return "0";
           else
               return box.getText();
        }
    }
    
    public void identificaInfo(ModelProveedor model){
        if(!model.getNombre().equals("")){
            pNombre.setForeground(Color.black);
            pNombre.setText(model.getNombre());
        }if(!model.getaPaterno().equals("")){
            pApellidoPaterno.setText(model.getaPaterno());
            pApellidoPaterno.setForeground(Color.black);
        }if(!model.getaMaterno().equals("")){
            pApellidoMaterno.setText(model.getaMaterno());
            pApellidoMaterno.setForeground(Color.black);
        }if(!model.getMarca().equals("")){
            pMarca.setText(model.getMarca());
            pMarca.setForeground(Color.black);
        }if(!model.getEmpresa().equals("")){
            pEmpresa.setText(model.getEmpresa());
            pEmpresa.setForeground(Color.black);
        }if(!model.getRFC().equals("")){
            pRFC.setText(model.getRFC());
            pRFC.setForeground(Color.black);
        }if(!model.getTelFijo().equals("")){
            pTelefono.setForeground(Color.black);
            pTelefono.setText(""+model.getTelFijo());
        }if(!model.getTelCel().equals("")){
            pTelCelular.setForeground(Color.black);
            pTelCelular.setText(""+model.getTelCel());
        }if(!model.geteMail().equals("")){
            pEmail.setForeground(Color.black);
            pEmail.setText(""+model.geteMail());
        }if(!model.getCalle().equals("")){
            pCalle.setForeground(Color.black);
            pCalle.setText(""+model.getCalle());
        }if(!model.getCiudad().equals("")){
            pCiudad.setForeground(Color.black);
            pCiudad.setText(""+model.getCalle());
        }if(!model.getColonia().equals("")){
            pColonia.setForeground(Color.black);
            pColonia.setText(""+model.getCalle());
        }if(!model.getEstado().equals("")){
            for (int i = 0; i < pEstados.getModel().getSize(); i++) {
                String est = (String)pEstados.getItemAt(i);
                if(est.equals(model.getEstado())){
                    pEstados.setSelectedIndex(i);
                    break;
                }
            }
        }if(model.getCodigoPostal()!=0){
            pCP.setForeground(Color.black);
            pCP.setText(""+model.getCodigoPostal());
        }if(model.getNumExt()!=0){
            pNoExt.setForeground(Color.black);
            pNoExt.setText(""+model.getNumExt());
        }if(model.getNumInt()!=0){
            pNoInt.setForeground(Color.black);
            pNoInt.setText(""+model.getNumInt());
        }
    }
    
    public void limpiaCampos(){
        limpiaJtextField(pNombre,"Nombre (*)");
        limpiaJtextField(pApellidoPaterno,"Apellido Paterno (*)");
        limpiaJtextField(pApellidoMaterno,"Apellido Materno");
        limpiaJtextField(pRFC,"R.F.C.");
        limpiaJtextField(pMarca, "Marca (*)");
        limpiaJtextField(pTelefono,"xx-xxx-xxxxxxx");
        limpiaJtextField(pEmail,"cliente@anais.com (*)");
        limpiaJtextField(pTelCelular,"xx-xxx-xxxxxxx (*)");
        limpiaJtextField(pCalle,"Calle");
        limpiaJtextField(pEmpresa, "Empresa (*)");
        limpiaJtextField(pNoExt,"No.Ext.");
        limpiaJtextField(pNoInt,"No.Int.");
        limpiaJtextField(pCP,"xxxxx (*)");
        limpiaJtextField(pColonia,"Colonia");
        limpiaJtextField(pCiudad,"Ciudad");
        pEstados.setSelectedIndex(0);
    }
    
    private void limpiaJtextField(JTextField box, String msj){
        box.setForeground(new Color(180,180,180));
        box.setText(msj);
    }
}

