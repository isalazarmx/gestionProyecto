/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelVenta;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jesus
 */
public class ControllerViewVendedor {
    JTextField idCliente;
    JComboBox tipoVenta;
    JTextField fecha;
    JTextField fechaPedido;
    JTextField horaEnt;
    JTextField lugarEnt;
    JTextField idVentas;
    JTextField codBarras;
    JTextField descripcion;
    JTextField price;
    JTextField cantidad;
    JTextField descuento;
    JTextField importe;
    JTextField abono;
    JTextField resto;
    JTextField subtotal;
    JTextField iva;
    JTextField totalT;
    
    
    public ControllerViewVendedor(ArrayList components){
        this.idCliente = (JTextField)components.get(0);
        this.tipoVenta = (JComboBox)components.get(1);
        this.fecha = (JTextField)components.get(2);
        this.horaEnt = (JTextField)components.get(3);
        this.lugarEnt = (JTextField)components.get(4);
        this.idVentas = (JTextField)components.get(5);
        this.codBarras = (JTextField)components.get(6);
        this.descripcion = (JTextField)components.get(7);
        this.price = (JTextField)components.get(8);
        this.cantidad = (JTextField)components.get(9);
        this.descuento = (JTextField)components.get(10);
        this.importe = (JTextField)components.get(11);
        this.abono = (JTextField)components.get(12);
        this.resto= (JTextField)components.get(13);
        this.subtotal = (JTextField)components.get(14);
        this.iva = (JTextField)components.get(15);
        this.totalT = (JTextField)components.get(16);
    }
    
        public void validations(){
//        ControllerValidation.camposNoNulos(idCliente, "Campo oblagatorio");
//        ControllerValidation.soloNumeros(idCliente);
//        ControllerValidation.validarFecha(fecha, null);
//        ControllerValidation.soloNumeros(fecha);
//        ControllerValidation.validarFecha(fechaPedido, null);
//        ControllerValidation.soloNumeros(fechaPedido);
//        ControllerValidation.soloNumeros(horaEnt);
//        ControllerValidation.soloNumeros(codBarras);
//        ControllerValidation.limitarCaracteres(descripcion, 250);
//        ControllerValidation.soloNumeros(cantidad);
//        ControllerValidation.soloNumeros(descuento);
//        ControllerValidation.soloNumeros(importe);
//        ControllerValidation.soloNumeros(iva);
//        ControllerValidation.soloNumeros(abono);
    }
    
    public void next(JLabel labelStatus,Thread hilo,ModelVenta emp){
        if(idCliente.getText().equals("Cod. Cliente") && idCliente.getText().isEmpty()){
           labelStatus.setForeground(new Color(153,0,0));
            labelStatus.setText("Agregue el código del cliente");
        }else{   }
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

