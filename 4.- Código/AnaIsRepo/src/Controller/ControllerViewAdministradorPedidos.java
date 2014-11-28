/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModeloPedidos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Teté
 */
public class ControllerViewAdministradorPedidos {
    JTextField codigoVenta;
    JTextField idCliente;
    JLabel labelCount1;
    ControllerTables controllerTable;
    
    
public ControllerViewAdministradorPedidos(ArrayList components){
this.controllerTable = new ControllerTables();
this.codigoVenta = (JTextField)components.get(0);
this.idCliente = (JTextField)components.get(1);
this.labelCount1 = (JLabel)components.get(2);
controllerTable.setTabla((JTable)components.get(3));
controllerTable.setModelTable((DefaultTableModel)components.get(4));
}

public void buscaPedido(boolean flag){
    if(flag || ((!codigoVenta.getText().equals("Cod. Venta") && !codigoVenta.getText().isEmpty())
        || (!idCliente.getText().equals("Cod. Cliente") && !idCliente.getText().isEmpty()))){
        limpiaBusqueda();
        String ven = reviewInfo(codigoVenta,"Cod. Venta",true);
        String cli = reviewInfo(idCliente,"Cod. Cliente",true);
        List list = DataBase.DataBasePedido.findPedido(ven);
        int count = list.size();
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                ModeloPedidos pedido = (ModeloPedidos)list.get(i);
                String[] datos = {""+pedido.getIdventaPedido(),pedido.getDescripcion()};
                controllerTable.agregarDatos(datos);
            }
            if(!flag){
                String msj;
                if(count>1)
                    msj = count+" posibles resutaldos";
                else
                    msj = count+" posible resutaldo";
                if(list.size() > 1)
                    labelCount1.setText("Lo sentimos, no hay coincidencias con la busqueda, pero encontramos "+msj);
//                else if ((((ModeloPedidos)list.get(0)).getIdventaPedido()));
//                    labelCount1.setText("Busqueda realizada con éxito");
//                else
//                    labelCount1.setText("Lo sentimos, no hay coincidencias con la busqueda, pero encontramos "+msj);
            }else if(count > 1)
                labelCount1.setText("Existen "+count+" registros en el sistema");
            else
                labelCount1.setText("Existe "+count+" registro en el sistema");
        }else
            labelCount1.setText("Lo sentimos, no se encontro ninguna coincidencía");
    }else{
        ControllerViewMsj.muestraMensajeGlobo("Agrega un nombre o un username para iniciar la busqueda",codigoVenta);
    }
}


    public void limpiaBusqueda(){
        int cantidadEliminar = controllerTable.getTabla().getRowCount();
        for (int i = cantidadEliminar-1;i>=0;i--)
            controllerTable.getModelTable().removeRow(i);
    }
    
    public String pedidoModificar(){
        int seleccion = controllerTable.getTabla().getSelectedRow();
        return (String)controllerTable.getModelTable().getValueAt(seleccion, 3);
    }
    
    public boolean tablaSeleccionada(){
        boolean flag = false;
        if(controllerTable.getTabla().getRowCount()>0)
            if(controllerTable.getTabla().getSelectedRow()>-1)
                flag = true;
            else
                ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, debes de seleccionar un pedido","Mensaje para modificar pedido");
        else
            ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, no existe ningún registro","Mensaje para modificar pedido");
        return flag;
    }
    
    public void eliminaPedido(){
        int eliminar = controllerTable.getTabla().getSelectedRow();
        if(eliminar != -1){
            String[] dat = new String[2];
            dat[0]="Si";
            dat[1]="No";
            if(ControllerViewMsj.pregunta("Estás seguro de quere eliminar al este pedido?", dat, controllerTable.getTabla())==0){
                String idventaPedido = pedidoModificar();
                labelCount1.setText("Pedido eliminado con éxito");
                DataBase.DataBaseUsuario.eliminarUsuario(idventaPedido);
                controllerTable.getModelTable().removeRow(controllerTable.getTabla().getSelectedRow());
            }else
                labelCount1.setText("Eliminación de pedido cancelada");
        }else
            ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, debes de seleccionar un pedido","Mensaje para modificar pedido");
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
