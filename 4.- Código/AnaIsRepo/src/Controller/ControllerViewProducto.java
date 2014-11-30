
package Controller;

import Model.ModelCliente;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Carolina
 */
public class ControllerViewProducto {
    JTextField ID;
    JTextField nombre;
    JTextField cantidad01;
    JTextField cantidad02;
    JComboBox tipoUnidad;
    JTextField unidadExistencia;
    JSpinner minStock;
    JSpinner maxStock;
    JTextField precioCompra01;
    JTextField precioCompra02;
    JSpinner incrementoVenta;
    JTextField precioVenta;
    JLabel imagen;
    JComboBox idCategoria;
    JTextField gananciaIndividual;
    JTextField gananciaTotal;
    JTextField inversion;
    ControllerCuentas cuentas;
    
    public ControllerViewProducto(ArrayList components){
        cuentas = new ControllerCuentas();
        this.ID = (JTextField)components.get(0);
        this.nombre = (JTextField)components.get(1);
        this.cantidad01 = (JTextField)components.get(2);
        this.cantidad02 = (JTextField)components.get(3);
        this.tipoUnidad = (JComboBox)components.get(4);
        this.unidadExistencia = (JTextField)components.get(5);
        this.minStock = (JSpinner)components.get(6);
        this.maxStock = (JSpinner)components.get(7);
        this.precioCompra01 = (JTextField)components.get(8);
        this.precioCompra02 = (JTextField)components.get(9);
        this.incrementoVenta = (JSpinner)components.get(10);
        this.precioVenta = (JTextField)components.get(11);
        this.imagen = (JLabel)components.get(12);
        this.idCategoria = (JComboBox)components.get(13);
        this.gananciaIndividual = (JTextField)components.get(14);
        this.gananciaTotal = (JTextField)components.get(15);
        this.inversion = (JTextField)components.get(16);
    }
    
    private double incremento(){
        double temp2 = (Integer)incrementoVenta.getValue();
        double temp = temp2/100;
        return temp;
    }
    
    private double buscaValor(double parteEntera,double parteDecimal){
        return parteEntera+(parteDecimal/100);
    }
    
    private double precioCompra(){
        return buscaValor(
                        Integer.parseInt(precioCompra01.getText()),
                        Integer.parseInt(precioCompra02.getText())
                        );
    }
    
    private double cantidadProductos(){
        return Integer.parseInt(unidadExistencia.getText());
    }
    
    public void despliegaCuentas(){ 
        double temp = cuentas.gananciaIndividual(precioCompra(),incremento());
        gananciaIndividual.setText(cuentas.formatoNumero(""+temp));
        gananciaTotal.setText(""+cuentas.formatoNumero(""+cuentas.gananciaTotal(temp, cantidadProductos())));
        precioVenta.setText(""+cuentas.formatoNumero(""+cuentas.precioVenta(precioCompra(),incremento())));
        inversion.setText(""+cuentas.formatoNumero(""+cuentas.cantidadInvertida(cantidadProductos(), precioCompra())));
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(ID,30);
        ControllerValidation.limitarCaracteres(nombre,45);
        ControllerValidation.limitarCaracteres(cantidad01,9);
        ControllerValidation.soloNumeros(cantidad01);
        ControllerValidation.limitarCaracteres(cantidad02,2);
        ControllerValidation.soloNumeros(cantidad02);
        ControllerValidation.limitarCaracteres(unidadExistencia,9);
        ControllerValidation.soloNumeros(unidadExistencia);
        ControllerValidation.limitarCaracteres(precioCompra01,9);
        ControllerValidation.soloNumeros(precioCompra01);
        ControllerValidation.limitarCaracteres(precioCompra02,2);
        ControllerValidation.soloNumeros(precioCompra02);
    }
    
    public void addCliente(JTextField acID,JLabel labelStatus,ModelCliente cliente){
        if(!Nombre.getText().equals("Nombre (*)") && !Nombre.getText().isEmpty()){
            if(!acApellidoPaterno.getText().equals("Apellido Paterno (*)") && !acApellidoPaterno.getText().isEmpty()){
                if(!acEmail.getText().equals("cliente@anais.com (*)") && !acEmail.getText().isEmpty()){
                    if(!acTelCelular.getText().equals("xx-xxx-xxxxxxx (*)") && !acTelCelular.getText().isEmpty()){
                        if(!acCP.getText().equals("xxxxx (*)") && !acCP.getText().isEmpty()){
                            if(DataBase.DataBaseCliente.addCliente(cliente)){
                                   labelStatus.setText("Cliente agregado con éxito");
                                   limpiaCampos();
                                   acID.setText(DataBase.DataBaseCliente.verProximoID());
                            }else
                               labelStatus.setText("Error interno para almacenar la información");
                        }else
                            ControllerViewMsj.muestraMensajeGlobo("Agrega un código postal", acCP);
                    }else
                        ControllerViewMsj.muestraMensajeGlobo("Agrega un teléfono móvil", acTelCelular);
                }else
                    ControllerViewMsj.muestraMensajeGlobo("Agrega un email", acTelCelular);
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agrega un apellido paterno",acApellidoPaterno);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre para el cliente", Nombre);
    }
    
    public boolean modificaCliente(JLabel labelStatus,ModelCliente cliente){
        boolean flag = false;
        if(!Nombre.getText().equals("Nombre (*)") && !Nombre.getText().isEmpty()){
            if(!acApellidoPaterno.getText().equals("Apellido Paterno (*)") && !acApellidoPaterno.getText().isEmpty()){
                if(!acEmail.getText().equals("cliente@anais.com (*)") && !acEmail.getText().isEmpty()){
                    if(!acTelCelular.getText().equals("xx-xxx-xxxxxxx (*)") && !acTelCelular.getText().isEmpty()){
                        if(!acCP.getText().equals("xxxxx (*)") && !acCP.getText().isEmpty()){
                            if(DataBase.DataBaseCliente.modifUser(cliente)){
                                ControllerViewMsj.informacion(Nombre.getText()+" modificado con éxito","Modificación de usuario");
                                flag = true;
                            }else
                                labelStatus.setText("Error interno para almacenar la información");
                        }else
                            ControllerViewMsj.muestraMensajeGlobo("Agrega un código postal", acCP);
                    }else
                        ControllerViewMsj.muestraMensajeGlobo("Agrega un teléfono móvil", acTelCelular);
                }else
                    ControllerViewMsj.muestraMensajeGlobo("Agrega un email", acEmail);
            }else
                ControllerViewMsj.muestraMensajeGlobo("Agrega un apellido paterno",acApellidoPaterno);
        }else
            ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre para el cliente", Nombre);
        return flag;
    }
    
    public void identificaInfo(ModelCliente model){
        if(!model.getNombre().equals("")){
            Nombre.setForeground(Color.black);
            Nombre.setText(model.getNombre());
        }if(!model.getaPaterno().equals("")){
            acApellidoPaterno.setText(model.getaPaterno());
            acApellidoPaterno.setForeground(Color.black);
        }if(!model.getaMaterno().equals("")){
            acApellidoMaterno.setText(model.getaMaterno());
            acApellidoMaterno.setForeground(Color.black);
        }if(!model.getRFC().equals("")){
            acRFC.setText(model.getRFC());
            acRFC.setForeground(Color.black);
        }if(!model.getTelFijo().equals("")){
            acTelefono.setForeground(Color.black);
            acTelefono.setText(""+model.getTelFijo());
        }if(!model.getTelCel().equals("")){
            acTelCelular.setForeground(Color.black);
            acTelCelular.setText(""+model.getTelCel());
        }if(!model.geteMail().equals("")){
            acEmail.setForeground(Color.black);
            acEmail.setText(""+model.geteMail());
        }if(!model.getCalle().equals("")){
            acCalle.setForeground(Color.black);
            acCalle.setText(""+model.getCalle());
        }if(!model.getCiudad().equals("")){
            acCiudad.setForeground(Color.black);
            acCiudad.setText(""+model.getCalle());
        }if(!model.getColonia().equals("")){
            acColonia.setForeground(Color.black);
            acColonia.setText(""+model.getCalle());
        }if(!model.getEstado().equals("")){
            for (int i = 0; i < acEstados.getModel().getSize(); i++) {
                String est = (String)acEstados.getItemAt(i);
                if(est.equals(model.getEstado())){
                    acEstados.setSelectedIndex(i);
                    break;
                }
            }
        }if(model.getCodigoPostal()!=0){
            acCP.setForeground(Color.black);
            acCP.setText(""+model.getCodigoPostal());
        }if(model.getNumExt()!=0){
            acNoExt.setForeground(Color.black);
            acNoExt.setText(""+model.getNumExt());
        }if(model.getNumInt()!=0){
            acNoInt.setForeground(Color.black);
            acNoInt.setText(""+model.getNumInt());
        }
    }
    
    public ModelCliente creaModelo(ModelCliente model){
            model.setNombre(reviewInfo(Nombre,"Nombre (*)", true));
            model.setaPaterno(reviewInfo(acApellidoPaterno,"Apellido Paterno (*)", true));
            model.setaMaterno(reviewInfo(acApellidoMaterno,"Apellido Materno", true));
            model.setRFC(reviewInfo(acRFC,"R.F.C.", true));
            model.setTelFijo(reviewInfo(acTelefono,"xx-xxx-xxxxxxx", true));
            model.setTelCel(reviewInfo(acTelCelular,"xx-xxx-xxxxxxx (*)", true));
            model.seteMail(reviewInfo(acEmail,"cliente@anais.com (*)", true));
            model.setCalle(reviewInfo(acCalle,"Calle", true));
            model.setCiudad(reviewInfo(acCiudad,"Ciudad", true));
            model.setColonia(reviewInfo(acColonia,"Colonia", true));
            model.setEstado((String)acEstados.getItemAt(acEstados.getSelectedIndex()));
            model.setCodigoPostal(Integer.parseInt(reviewInfo(acCP,"xxxxx (*)", false)));
            model.setNumExt(Integer.parseInt(reviewInfo(acNoExt,"No.Ext.", false)));
            model.setNumInt(Integer.parseInt(reviewInfo(acNoInt,"No.Int.", false)));
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
    
    public void limpiaCampos(){
        limpiaJtextField(Nombre,"Nombre (*)");
        limpiaJtextField(acApellidoPaterno,"Apellido Paterno (*)");
        limpiaJtextField(acApellidoMaterno,"Apellido Materno");
        limpiaJtextField(acRFC,"R.F.C.");
        limpiaJtextField(acTelefono,"xx-xxx-xxxxxxx");
        limpiaJtextField(acEmail,"cliente@anais.com (*)");
        limpiaJtextField(acTelCelular,"xx-xxx-xxxxxxx (*)");
        limpiaJtextField(acCalle,"Calle");
        limpiaJtextField(acNoExt,"No.Ext.");
        limpiaJtextField(acNoInt,"No.Int.");
        limpiaJtextField(acCP,"xxxxx (*)");
        limpiaJtextField(acColonia,"Colonia");
        limpiaJtextField(acCiudad,"Ciudad");
        acEstados.setSelectedIndex(0);
    }
    
    private void limpiaJtextField(JTextField box, String msj){
        box.setForeground(new Color(180,180,180));
        box.setText(msj);
    }
}
