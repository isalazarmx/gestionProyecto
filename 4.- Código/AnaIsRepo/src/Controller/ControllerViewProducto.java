/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBase.DataBaseCategoria;
import DataBase.DataBaseProducto;
import Model.ModelCategoria;
import Model.ModelProducto;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nel
 */
public class ControllerViewProducto 
{
    JTextField nombre;
    JTextArea descripcion;
    JTextField link;
    JTextField kilos;
    JTextField numpersonas;
    JTextField precioUnitario;
    

    public ControllerViewProducto(ArrayList components) { 
        this.nombre = (JTextField)components.get(0);
        this.descripcion = (JTextArea)components.get(1);
        this.link = (JTextField)components.get(2);
        this.kilos = (JTextField)components.get(3);
        this.numpersonas = (JTextField)components.get(4);
        this.precioUnitario = (JTextField)components.get(5);
    }

    
    public void validations(){            
        ControllerValidation.limitarCaracteres(nombre, 45);        
        ControllerValidation.limitarCaracteres(descripcion, 250);        
        ControllerValidation.limitarCaracteres(link, 250);        
        ControllerValidation.limitarCaracteres(kilos, 11);        
        ControllerValidation.soloNumeros(kilos);
        ControllerValidation.limitarCaracteres(numpersonas, 11);        
        ControllerValidation.soloNumeros(numpersonas);
        ControllerValidation.limitarCaracteres(precioUnitario, 8);        
        ControllerValidation.soloNumeros(precioUnitario);
        
    }    
    
    
    public void next(ModelProducto emp,String categoria){        
            if (!nombre.getText().equals("Nombre del producto(*)") && !nombre.getText().isEmpty()) {
            
            emp.setNombre(nombre.getText().toUpperCase());
            emp.setDescripcion(reviewInfo(descripcion, "Descripcion de la categoria", true));
            emp.setLinkFoto(reviewInfo(link, "Foto", true));
            emp.setKilos(Integer.parseInt(reviewInfo(kilos, "Kilos",false)));
            emp.setNumPersonas(Integer.parseInt(reviewInfo(numpersonas, "Numero de personas",false)));
            emp.setPrecioUnitario(Integer.parseInt(reviewInfo(precioUnitario, "Precio unitario",false)));
            emp.setIdCategoria(Integer.parseInt(categoria));
            
            if (!DataBaseProducto.checkExistProducto(nombre.getText().toUpperCase())) {
                if (DataBaseProducto.addInfoProducto(emp)) {

                    JOptionPane.showMessageDialog(null, "Producto " + nombre.getText() + " registrada");
                    nombre.setText("Nombre del producto(*)");
                    nombre.setForeground(new Color(180, 180, 180));
                    descripcion.setText("Descripcion del producto");
                    descripcion.setForeground(new Color(180, 180, 180));
                    
                    kilos.setText("Kilos");
                    kilos.setForeground(new Color(180, 180, 180));
                    
                    numpersonas.setText("Numero de personas");
                    numpersonas.setForeground(new Color(180, 180, 180));
                    
                    precioUnitario.setText("Precio unitario");
                    precioUnitario.setForeground(new Color(180, 180, 180));
                } else {
                    JOptionPane.showMessageDialog(null, "Error interno para almacenar la información");
                }
            } else {                
                nombre.requestFocusInWindow();
                nombre.setSelectionStart(0);                
                JOptionPane.showMessageDialog(null, "EL producto " + nombre.getText() + " ya esta registrada");
                
            }
        } else {
            ControllerViewMsj.muestraMensajeGlobo("Agregua el nombre del producto", nombre);
        }
    }
    
    public void cargaComboCategoria(JComboBox combo,String cadena,JButton bt1,JButton bt2)
    {
        if (cadena.equals("Buscar Categoria")) 
        {
            cadena="";
        }
        combo.removeAllItems();
        LinkedList lista=DataBaseCategoria.findCategoria(cadena);
        if (lista.isEmpty()) 
        {
            bt1.setEnabled(false);
            bt2.setEnabled(false);
        }else
        {
            bt1.setEnabled(true);
            bt2.setEnabled(true);
            for (int i = 0; i < lista.size(); i++) {
                ModelCategoria tmp = (ModelCategoria) lista.get(i);
                combo.addItem(tmp.getNombre());
            }
        }        
    }
    
    public void cargaTextoCategoria(JComboBox combo,JTextArea area)
    {       
        if (!(combo.getSelectedItem() == null)) 
        {
            ModelCategoria categoria = new ModelCategoria();
            DataBaseCategoria.getCategoria(categoria, combo.getSelectedItem().toString());
            area.setText("");
            area.setText("Id Cateogira: " + categoria.getIdCategoria() + "\n"
                    + "Nombre Categoria: " + categoria.getNombre() + "\n"
                    + "Descripcion Categoria: " + categoria.getDescripcion());
        }else
        {
            area.setText("");
        }
    }
    
    public void deleteCategoria(String nombre,JTextField texto)
    {
        if (DataBaseCategoria.deleteCategoria(nombre)) 
        {            
                texto.setText("Buscar Categoria");
                texto.setForeground(new Color(180, 180, 180));
                JOptionPane.showMessageDialog(null, "Categoria "+nombre+" eliminada");
        }
    }
    
    public boolean cancelaActu(JButton cancelar,JButton eliminar,JTextField nombre,JTextField desc,boolean bandera)
    {
        bandera=true;
        desc.setText("Descripcion de la categoria");
        desc.setForeground(new Color(180, 180, 180));
        nombre.setText("Nombre de la categoria(*)");
        nombre.setForeground(new Color(180, 180, 180));
        cancelar.setVisible(false);
        eliminar.setEnabled(true);
        return bandera;
    }
    
    public boolean updateCategoria(JComboBox combo,JTextField nombre,JTextField desc,JButton eliminar,JButton cancelar,boolean bandera)
    {
        
     
            bandera=false;
            ModelCategoria categoria = new ModelCategoria();
            DataBase.DataBaseCategoria.getCategoria(categoria, combo.getSelectedItem().toString());            
            nombre.setForeground(new Color(0, 0, 0));
            nombre.setText(categoria.getNombre());
            eliminar.setEnabled(false);
            cancelar.setVisible(true);
            if (!categoria.getDescripcion().equals("")) 
            {
                desc.setText(categoria.getDescripcion());
                desc.setForeground(new Color(0, 0, 00));
            }else
            {
                desc.setText("Descripcion de la categoria");
                desc.setForeground(new Color(180, 180, 180));
            }
            return bandera;
    }
    
    public boolean updateCategoria(ModelCategoria emp,String nombreCat,JButton cance,JButton eli)
    {
        boolean bandera=false;
        if (!nombre.getText().equals("Nombre de la categoria(*)") && !nombre.getText().isEmpty()) {
            emp.setNombre(nombre.getText().toUpperCase());
            emp.setDescripcion(reviewInfo(descripcion, "Descripcion de la categoria", true));
            if (!DataBase.DataBaseCategoria.checkExistCategoria(nombre.getText().toUpperCase())) {
                if (DataBase.DataBaseCategoria.modifCategoria(emp,nombreCat)) {
                    bandera=true;
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
    
    private String reviewInfo(JTextField box, String value,boolean flag)
    {
        if(flag)
        {
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
    private String reviewInfo(JTextArea box, String value,boolean flag)
    {
        if(flag)
        {
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
