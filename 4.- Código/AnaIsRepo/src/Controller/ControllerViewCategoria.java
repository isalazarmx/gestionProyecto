/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBase.DataBaseCategoria;
import Model.ModelCategoria;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nel
 */
public class ControllerViewCategoria {

    JTextField nombre;
    JTextArea descripcion;
    JComboBox idCategoria;
    JTextField acID;
    JLabel labelStatus02;
    JButton elimina;
    List<ModelCategoria> listCategoria;
    private boolean modifica;

    public ControllerViewCategoria(ArrayList components) {
        this.nombre = (JTextField) components.get(0);
        this.descripcion = (JTextArea) components.get(1);
        this.idCategoria = (JComboBox) components.get(2);
        this.acID = (JTextField) components.get(3);
        this.labelStatus02 = (JLabel)components.get(4);
        this.elimina = (JButton)components.get(5);
        modifica = false;
    }

    public void validations() {
        ControllerValidation.limitarCaracteres(nombre, 45);
        ControllerValidation.limitarCaracteres(descripcion, 250);
    }

    public void addCategoria(JLabel labelStatus) {
        if(validaCategoria()){
            ModelCategoria categoria = creaModelCategoria(new ModelCategoria(), false);
            if (DataBaseCategoria.addCategoria(categoria)) {
                limpiaCampos();
                labelStatus.setText("Categoría agregada con éxito");
                cargarCombo(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
            }
        }
    }

    public void limpiaCampos() {
        nombre.setForeground(new Color(180, 180, 180));
        nombre.setText("Nombre de la categoría (*)");
        descripcion.setForeground(new Color(180, 180, 180));
        descripcion.setText("Agrega una descripción");
        labelStatus02.setText("");
        idCategoria.setSelectedIndex(0);
        elimina.setVisible(false);
        setModifica(false);
    }

    public void cargarCombo(boolean seleccion) {
        int as = idCategoria.getItemCount()-1;
        for (int i = as; i > 0; i--) {
            idCategoria.removeItemAt(i);
        }
        idCategoria.repaint();
        listCategoria = DataBase.DataBaseCategoria.buscaCategorias(seleccion);
        for (ModelCategoria list1 : listCategoria) {
            idCategoria.addItem(list1.getNombre());
        }
    }
    
    public ModelCategoria creaModelCategoria(ModelCategoria categoria, boolean tipoProducto) {
        categoria.setNombre(nombre.getText());
        categoria.setDescripcion(descripcion.getText());
        if (tipoProducto)
            categoria.setTipoProducto(2);
        else
            categoria.setTipoProducto(3);
        return categoria;
    }

    public void identificaInfo() {
        String nombreCat = (String)idCategoria.getSelectedItem();
        if (!nombreCat.equals("Nueva categoría")){
            llenaCampos(buscaCategoria(nombreCat));
            labelStatus02.setText("Modifica productos");
            elimina.setVisible(true);
            setModifica(true);
        }else
            limpiaCampos();
    }
    
    private ModelCategoria buscaCategoria(String nombre){
        ModelCategoria model = null;
        for (ModelCategoria modTemp : listCategoria) {
            if (modTemp.getNombre().equals(nombre)) {
                model = modTemp;
                break;
            }
        }
        return model;
    }
    
    private void llenaCampos(ModelCategoria modTemp){
        acID.setText(""+modTemp.getIdCategoria());
        nombre.setForeground(Color.black);
        nombre.setText(modTemp.getNombre());
        descripcion.setForeground(Color.black);
        descripcion.setText(modTemp.getDescripcion());
    }
    
    private boolean validaCategoria(){
        boolean flag = false;
        if (!nombre.getText().equals("Nombre de la categoría (*)") && !nombre.getText().isEmpty()) {
            if (!DataBaseCategoria.checkExistCategoria(nombre.getText().toUpperCase())||modifica)
                flag = true;
            else
                ControllerViewMsj.muestraMensajeGlobo("Lo sentimos, el nombre de la categoría ya existe", nombre);
        } else
            ControllerViewMsj.muestraMensajeGlobo("Agregua el nombre de la categoria", nombre);
        return flag;
    }
    
    public void modificaCategoria(JLabel labelStatus){
        if(validaCategoria()){
            ModelCategoria categoria = creaModelCategoria(new ModelCategoria(), false);
            categoria.setIdCategoria(Integer.parseInt(acID.getText()));
            if (DataBaseCategoria.modificaCategoria(categoria)) {
                limpiaCampos();
                labelStatus.setText("Categoría modificada con éxito");
                cargarCombo(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
            }
        }
    }
    
    public void eliminaCategoria(JLabel status){
        if(validaCategoria()){
            String[] dat = new String[2];
            dat[0]="Si";
            dat[1]="No";
            if(ControllerViewMsj.pregunta("Estás seguro de quere eliminar esta categoría?", dat,descripcion)==0){
                DataBase.DataBaseCategoria.modifCategoria(acID.getText());
                limpiaCampos();
                status.setText("Categoría eliminada con éxito");
                cargarCombo(true);
            }else
                labelStatus02.setText("Eliminación de usuario cancelada");
        }
    }
    
    /**
     * @return the modifica
     */
    public boolean isModifica() {
        return modifica;
    }

    /**
     * @param modifica the modifica to set
     */
    public void setModifica(boolean modifica) {
        this.modifica = modifica;
    }
}
