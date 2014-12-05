/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelCategoria;
import Model.ModelProducto;
import Model.ModelProveedor;
import Model.Proveedor_has_Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus
 */
public class ControllerViewAdministrarProducto {
    JComboBox idCategoria;
    JComboBox idProveedor;
    JButton verTodo;
    boolean tipoAlmacen;
    ControllerTables controllerTable;
    List<ModelCategoria> listCategoria;
    List<ModelProveedor> listProveedor;
    List<ModelProducto> listProductos;
    List<Proveedor_has_Producto> listRelations;
    
    public ControllerViewAdministrarProducto(ArrayList components){
        this.controllerTable = new ControllerTables();
        this.idCategoria = (JComboBox)components.get(0);
        this.idProveedor = (JComboBox)components.get(1);
        this.verTodo = (JButton)components.get(2);
        controllerTable.setTabla((JTable)components.get(3));
        controllerTable.setModelTable((DefaultTableModel)components.get(4));
        this.tipoAlmacen = (Boolean)components.get(5);
    }
    
    public void validations(){
        controllerTable.getTabla().setModel(controllerTable.getModelTable());
    }
    
    public List cargarCombo(int tipoProducto, boolean seleccion) {
        List temp = null;
        switch (tipoProducto) {
            case 0:
                int cant00 = idCategoria.getItemCount()-1;
                for (int i = cant00; i > 0; i--) {
                    idCategoria.removeItemAt(i);
                }
                listCategoria = DataBase.DataBaseCategoria.buscaCategorias(seleccion);
                for (ModelCategoria list1 : listCategoria)
                    idCategoria.addItem(list1.getNombre());
                temp = listCategoria;
                break;
            case 1:
                int cant01 = idProveedor.getItemCount()-1;
                for (int i = cant01; i > 0; i--) {
                    idProveedor.removeItemAt(i);
                }
                listProveedor = DataBase.DataBaseProveedor.buscaProveedores();
                for (ModelProveedor list1 : listProveedor)
                    idProveedor.addItem(list1.getNombre() + " " + list1.getaPaterno());
                temp = listProveedor;
                break;
            case 2:
                listRelations = DataBase.DataBaseProveedor_has_Producto.buscaRelations();
                break;
            case 3:
                listProductos = DataBase.DataBaseProducto.buscaProductos(seleccion);
                break;
        }
        return temp;
    }
    
    public void limpiaBusqueda(JButton button){
        int cantidadEliminar = controllerTable.getTabla().getRowCount();
        for (int i = cantidadEliminar-1;i>=0;i--)
            controllerTable.getModelTable().removeRow(i);
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscaImagen.png")));
    }
    
    public boolean tablaSeleccionada(){
        boolean flag = false;
        if(controllerTable.getTabla().getRowCount()>0)
            if(controllerTable.getTabla().getSelectedRow()>-1)
                flag = true;
            else
                ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, debes de seleccionar un cliente","Mensaje para modificar cliente");
        else
            ControllerViewMsj.aviso(controllerTable.getTabla(),"Lo sentimos, no existe ningún registro","Mensaje para modificar cliente");
        return flag;
    }
    
    public void buscaCategoria(){
        limpiaBusqueda(new JButton());
        int idCat = buscaIdCategoria();
        List cat = DataBase.DataBaseProducto.buscaPorCategoria(idCat, tipoAlmacen);
        for (int i = 0; i < cat.size(); i++) {
            List list = (List)cat.get(i);
            String[] datos = {""+list.get(0),""+list.get(1),""+list.get(2),""+list.get(3),""+list.get(4),""+list.get(5)};
            controllerTable.agregarDatos(datos);
        }
    }
    
    public void buscaProveedor(){
        limpiaBusqueda(new JButton());
        int id = buscaIdProveedor();
        List pro = DataBase.DataBaseProducto.buscaPorProveedor(id, tipoAlmacen);
        for (int i = 0; i < pro.size(); i++) {
            List list = (List)pro.get(i);
            String[] datos = {""+list.get(0),""+list.get(1),""+list.get(2),""+list.get(3),""+list.get(4),""+list.get(5)};
            controllerTable.agregarDatos(datos);
        }
    }
    
    public void busquedaTotal(){
        List pro = DataBase.DataBaseProducto.buscaTotal(tipoAlmacen);
        for (int i = 0; i < pro.size(); i++) {
            List list = (List)pro.get(i);
            String[] datos = {""+list.get(0),""+list.get(1),""+list.get(2),""+list.get(3),""+list.get(4),""+list.get(5)};
            controllerTable.agregarDatos(datos);
        }
    }
    
    private int buscaIdCategoria(){
        for (int i = 0; i < listCategoria.size(); i++) {
            ModelCategoria modTemp = listCategoria.get(i);
            if(modTemp.getNombre().equals((String)idCategoria.getSelectedItem()))
               return modTemp.getIdCategoria();
        }
        return 0;
    }
    
    private int buscaIdProveedor(){
        for (int i = 0; i < listProveedor.size(); i++) {
            ModelProveedor modTemp = listProveedor.get(i);
            if((modTemp.getNombre()+" "+modTemp.getaPaterno()).equals(""+idProveedor.getSelectedItem()))
               return modTemp.getIdProveedor();
        }
        return 0;
    }
    
    public void buscaImagenProducto(JPanel panelImage, JButton imagen){
        int selected = controllerTable.getTabla().getSelectedRow();
        String idProducto = (String)controllerTable.getModelTable().getValueAt(selected,0);
        for (int i = 0; i < listProductos.size(); i++) {
            ModelProducto modTemp = listProductos.get(i);
            if(modTemp.getIdProducto().equals(idProducto))
               new ControllerImagenes().cargaImagen(modTemp.getImagen(), panelImage, imagen);
        }
        panelImage.updateUI();
    }
}
