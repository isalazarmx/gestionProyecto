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
    //-----------------------------------------------------------------------
    public void cargaComboCategoria(JComboBox combo, String cadena, JButton bt1, JButton bt2) {
        if (cadena.equals("Buscar Categoria")) {
            cadena = "";
        }
        combo.removeAllItems();
        LinkedList lista = DataBaseCategoria.findCategoria(cadena);
        if (lista.isEmpty()) {
            bt1.setEnabled(false);
            bt2.setEnabled(false);
        } else {
            bt1.setEnabled(true);
            bt2.setEnabled(true);
            for (int i = 0; i < lista.size(); i++) {
                ModelCategoria tmp = (ModelCategoria) lista.get(i);
                combo.addItem(tmp.getNombre());
            }
        }
    }

    public void cargaComboCategoria(JComboBox combo, String cadena, JButton bt1) {
        if (cadena.equals("Buscar Categoria")) {
            cadena = "";
        }
        combo.removeAllItems();
        LinkedList lista = DataBaseCategoria.findCategoria(cadena);
        if (lista.isEmpty()) {
            bt1.setEnabled(false);
        } else {
            bt1.setEnabled(true);
            for (int i = 0; i < lista.size(); i++) {
                ModelCategoria tmp = (ModelCategoria) lista.get(i);
                combo.addItem(tmp.getNombre());
            }
        }
    }

    public void deleteCategoria(String nombre, JTextField texto) {
        if (DataBaseCategoria.deleteCategoria(nombre)) {
            texto.setText("Buscar Categoria");
            texto.setForeground(new Color(180, 180, 180));
            JOptionPane.showMessageDialog(null, "Categoria " + nombre + " eliminada");
        }
    }

    public boolean cancelaActu(JButton cancelar, JButton eliminar, JTextField nombre, JTextField desc, boolean bandera) {
        bandera = true;
        desc.setText("Descripcion de la categoria");
        desc.setForeground(new Color(180, 180, 180));
        nombre.setText("Nombre de la categoria(*)");
        nombre.setForeground(new Color(180, 180, 180));
        cancelar.setVisible(false);
        eliminar.setEnabled(true);
        return bandera;
    }

    public boolean updateCategoria(JComboBox combo, JTextField nombre, JTextField desc, JButton eliminar, JButton cancelar, boolean bandera) {

        bandera = false;
        ModelCategoria categoria = new ModelCategoria();
        DataBase.DataBaseCategoria.getCategoria(categoria, combo.getSelectedItem().toString());
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setText(categoria.getNombre());
        eliminar.setEnabled(false);
        cancelar.setVisible(true);
        if (!categoria.getDescripcion().equals("")) {
            desc.setText(categoria.getDescripcion());
            desc.setForeground(new Color(0, 0, 00));
        } else {
            desc.setText("Descripcion de la categoria");
            desc.setForeground(new Color(180, 180, 180));
        }
        return bandera;
    }

    public boolean updateCategoria(ModelCategoria emp, String nombreCat, JButton cance, JButton eli) {
        boolean bandera = false;
        if (!nombre.getText().equals("Nombre de la categoria(*)") && !nombre.getText().isEmpty()) {
            emp.setNombre(nombre.getText().toUpperCase());
//            emp.setDescripcion(reviewInfo(descripcion, "Descripcion de la categoria", true));
            if (!DataBase.DataBaseCategoria.checkExistCategoria(nombre.getText().toUpperCase())) {
                if (DataBase.DataBaseCategoria.modifCategoria(emp, nombreCat)) {
                    bandera = true;
                    eli.setEnabled(true);
                    cance.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Categoria " + nombre.getText() + " actualizada ");
                    nombre.setText("Nombre de la categoria(*)");
                    nombre.setForeground(new Color(180, 180, 180));
                    descripcion.setText("Descripcion de la categoria");
                    descripcion.setForeground(new Color(180, 180, 180));
                } else {
                    JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
                }
            } else {
                nombre.requestFocusInWindow();
                nombre.setSelectionStart(0);
                JOptionPane.showMessageDialog(null, "La Categoria " + nombre.getText() + " ya esta registrada");

            }
        } else {
            ControllerViewMsj.muestraMensajeGlobo("Agregua el nombre de la categoria", nombre);
        }
        return bandera;
    }

    private String reviewInfo(JTextField box, String value, boolean flag) {
        if (flag) {
            if (box.getText().equals(value)) {
                return "";
            } else {
                return box.getText();
            }
        } else {
            if (box.getText().equals(value)) {
                return "0";
            } else {
                return box.getText();
            }
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
