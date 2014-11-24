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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus
 */
public class ControllerViewAdministrarVendedores {
    JTextField nombre;
    JTextField username;
    JLabel labelCount;
    ControllerTables controllerTable;
    
    public ControllerViewAdministrarVendedores(ArrayList components){
        this.controllerTable = new ControllerTables();
        this.nombre = (JTextField)components.get(0);
        this.username = (JTextField)components.get(1);
        this.labelCount = (JLabel)components.get(2);
        controllerTable.setTabla((JTable)components.get(3));
        controllerTable.setModelTable((DefaultTableModel)components.get(4));
    }
    
    public void validations(){
        ControllerValidation.limitarCaracteres(nombre, 25);
        ControllerValidation.limitarCaracteres(username, 25);
        controllerTable.getTabla().setModel(controllerTable.getModelTable());
    }
    
    public void buscaUsuario(boolean flag){
        if(flag || ((!nombre.getText().equals("Nombre") && !nombre.getText().isEmpty())
            || (!username.getText().equals("Username") && !username.getText().isEmpty()))){
            limpiaBusqueda();
            String nom = reviewInfo(nombre,"Nombre",true);
            String user = reviewInfo(username,"Username",true);
            List list = DataBase.DataBaseUsuario.buscaUsuario(nom, user, flag);
            int count = list.size();
            if(!list.isEmpty()){
                for (int i = 0; i < list.size(); i++) {
                    ModelUsuario usuario = (ModelUsuario)list.get(i);
                    String[] datos = {usuario.getNombre(),usuario.getaPaterno(),usuario.getaMaterno(),usuario.getUsername(),usuario.getPassword()};
                    controllerTable.agregarDatos(datos);
                }
                if(!flag){
                    String msj;
                    if(count>1)
                        msj = count+" posibles resutaldos";
                    else
                        msj = count+" posible resutaldo";
                    if(list.size() > 1)
                        labelCount.setText("Lo sentimos, no hay coincidencias con la busqueda, pero encontramos "+msj);
                    else if ((((ModelUsuario)list.get(0)).getNombre().equals(nom) || ((ModelUsuario)list.get(0)).getUsername().equals(user)))
                        labelCount.setText("Busqueda realizada con éxito");
                    else
                        labelCount.setText("Lo sentimos, no hay coincidencias con la busqueda, pero encontramos "+msj);
                }else if(count > 1)
                    labelCount.setText("Existen "+count+" registros en el sistema");
                else
                    labelCount.setText("Existe "+count+" registro en el sistema");
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
    
    public String vendedorModificar(){
        int seleccion = controllerTable.getTabla().getSelectedRow();
        return (String)controllerTable.getModelTable().getValueAt(seleccion, 3);
    }
    
    public boolean tablaSeleccionada(){
        boolean flag = false;
        if(controllerTable.getTabla().getRowCount()>0)
            if(controllerTable.getTabla().getSelectedRow()>-1)
                flag = true;
            else
                ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, debes de seleccionar un vendedor","Mensaje para modificar vendedor");
        else
            ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, no existe ningún registro","Mensaje para modificar vendedor");
        return flag;
    }
    
    public void eliminaVendedor(){
        int eliminar = controllerTable.getTabla().getSelectedRow();
        if(eliminar != -1){
            String[] dat = new String[2];
            dat[0]="Si";
            dat[1]="No";
            if(ControllerViewMsj.pregunta("Estás seguro de quere eliminar al este vendedor?", dat, controllerTable.getTabla())==0){
                String username = vendedorModificar();
                labelCount.setText("Vendedor eliminado con éxito");
                DataBase.DataBaseUsuario.eliminarUsuario(username);
                controllerTable.getModelTable().removeRow(controllerTable.getTabla().getSelectedRow());
            }else
                labelCount.setText("Eliminación de usuario cancelada");
        }else
            ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, debes de seleccionar un vendedor","Mensaje para modificar vendedor");
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
