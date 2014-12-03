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
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;
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
public class ControllerViewProductos 
{
    JTextField nombre;
    JTextArea descripcion;
    JTextField link;
    JTextField kilos;
    JTextField numpersonas;
    JTextField precioUnitario;
    

    public ControllerViewProductos(ArrayList components) { 
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
            int idc=DataBaseProducto.idCategoria(categoria);
            emp.setNombre(nombre.getText().toUpperCase());
            emp.setDescripcion(reviewInfo(descripcion, "Descripcion del producto", true));
            emp.setLinkFoto(reviewInfo(link, "Foto", true));
            emp.setKilos(Integer.parseInt(reviewInfo(kilos, "Kilos",false)));
            emp.setNumPersonas(Integer.parseInt(reviewInfo(numpersonas, "Numero de personas",false)));
            emp.setPrecioUnitario(Integer.parseInt(reviewInfo(precioUnitario, "Precio unitario",false)));
            emp.setIdCategoria(idc);
            
            if (!DataBaseProducto.checkExistProducto(nombre.getText().toUpperCase())) {
                if (DataBaseProducto.addInfoProducto(emp)) {

                    JOptionPane.showMessageDialog(null, "Producto " + nombre.getText() + " registrada");
                    nombre.setText("Nombre del producto(*)");
                    nombre.setForeground(new Color(180, 180, 180));
                    descripcion.setText("Descripcion del producto");
                    descripcion.setForeground(new Color(180, 180, 180));
                    
                    kilos.setText("Kilos");
                    kilos.setForeground(new Color(180, 180, 180));
                    link.setText("Foto");
                    link.setForeground(new Color(180, 180, 180));
                    
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
    
    
    public void cargaComboProducto(JComboBox combo,String cadena,JButton bt1,JButton bt2)
    {
        if (cadena.equals("Nombre del producto")) 
        {
            cadena="";
        }
        combo.removeAllItems();
        LinkedList lista=DataBaseProducto.findProductos(cadena);
        if (lista.isEmpty()) 
        {
            bt1.setEnabled(false);
            bt2.setEnabled(false);
        }else
        {
            bt1.setEnabled(true);
            bt2.setEnabled(true);
            for (int i = 0; i < lista.size(); i++) {
                ModelProducto tmp = (ModelProducto) lista.get(i);
                combo.addItem(tmp.getNombre());
            }
        }        
    }
    
    public void cargaTextoProducto(JComboBox combo,JTextArea area,JLabel label)
    {       
        if (!(combo.getSelectedItem() == null)) 
        {
            ModelProducto categoria = new ModelProducto();
            DataBaseProducto.getProducto(categoria, combo.getSelectedItem().toString());
            area.setText("");
            area.setText("Id producto: " + categoria.getIdProducto() + "\n"
                    + "Nombre del Producto: " + categoria.getNombre() + "\n"
                    + "Descripcion Producto: " + categoria.getDescripcion()+ "\n"
                    + "Kilos: " + categoria.getKilos()+ "\n"
                    + "Numero de personas: " + categoria.getNumPersonas()+ "\n"
                    + "Precio Unitario: " + categoria.getPrecioUnitario()+ "\n"
                    );
                    
                if (!categoria.getLinkFoto().equals("")) {                                                
                    //ImageIcon icon = new ImageIcon("C:\\Users\\nel\\Documents\\GitHub\\gestionProyecto\\4.- Código\\AnaIsRepo\\hola.jpg");
                    System.err.println(categoria.getLinkFoto());
                    ImageIcon icon = new ImageIcon(categoria.getLinkFoto());
                    Image img = icon.getImage(); //convertimos icon en una imagen
                    Image otraimg = img.getScaledInstance(300, 230, java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dándole las dimensiones que queramos a la antigua
                    ImageIcon otroicon = new ImageIcon(otraimg);
                    label.setIcon(otroicon);

                
            }
                
        }else
        {
            area.setText("");
        }
    }
    
    public void deleteProducto(String nombre,JTextField texto)
    {
        if (DataBaseProducto.deleteProducto(nombre)) 
        {            
                texto.setText("Nombre del producto");
                texto.setForeground(new Color(180, 180, 180));
                JOptionPane.showMessageDialog(null, "Producto "+nombre+" eliminado");
        }
    }
    
    public boolean cancelaActu(JButton cancelar,JButton eliminar,JTextField nombre,JTextArea desc,JTextField link,JTextField kilos,JTextField pers,JTextField preci,boolean bandera)
    {
        bandera=true;
        desc.setText("Descripcion del producto");
        desc.setForeground(new Color(180, 180, 180));
        nombre.setText("Nombre del producto(*)");
        nombre.setForeground(new Color(180, 180, 180));
        
        link.setText("Foto");
        link.setForeground(new Color(180, 180, 180));
        
        kilos.setText("Kilos");
        kilos.setForeground(new Color(180, 180, 180));
        
        pers.setText("Numero de personas");
        pers.setForeground(new Color(180, 180, 180));
        
        
        preci.setText("Precio unitario");
        preci.setForeground(new Color(180, 180, 180));
        
        cancelar.setVisible(false);
        eliminar.setEnabled(true);
        return bandera;
    }
    
    public boolean updateProducto(JComboBox combo,JTextField nombre,JTextArea desc,JTextField foto,JTextField kilos,JTextField numper,JTextField precioun,JButton eliminar,JButton cancelar,boolean bandera)
    {
        
     
            bandera=false;
            ModelProducto categoria = new ModelProducto();
            //DataBase.DataBaseCategoria.getCategoria(categoria, combo.getSelectedItem().toString());            
            DataBaseProducto.getProducto(categoria,combo.getSelectedItem().toString());
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
                desc.setText("Descripcion del producto");
                desc.setForeground(new Color(180, 180, 180));
            }
            if (!categoria.getLinkFoto().equals("")) 
            {
                foto.setText(categoria.getLinkFoto());
                foto.setForeground(new Color(0, 0, 00));
            }else
            {
                foto.setText("Foto");
                foto.setForeground(new Color(180, 180, 180));
            }
            
                kilos.setText(categoria.getKilos()+"");
                kilos.setForeground(new Color(0, 0, 00));
            
                numper.setText(categoria.getNumPersonas()+"");
                numper.setForeground(new Color(0, 0, 00));
                
                precioun.setText(categoria.getPrecioUnitario()+"");
                precioun.setForeground(new Color(0, 0, 00));
            
            return bandera;
    }
    
    public boolean updateProducto(ModelProducto emp,String nombreProduc,JButton cance,JButton eli,String categoria)
    {
        boolean bandera=false;
        if (!nombre.getText().equals("Nombre del producto(*)") && !nombre.getText().isEmpty()) {
            
            int idc=DataBaseProducto.idCategoria(categoria);
            emp.setNombre(nombre.getText().toUpperCase());
            emp.setDescripcion(reviewInfo(descripcion, "Descripcion del producto", true));
            emp.setLinkFoto(reviewInfo(link, "Foto", true));
            emp.setKilos(Integer.parseInt(reviewInfo(kilos, "Kilos",false)));
            emp.setNumPersonas(Integer.parseInt(reviewInfo(numpersonas, "Numero de personas",false)));
            emp.setPrecioUnitario(Double.parseDouble(reviewInfo(precioUnitario, "Precio unitario",false)));
            emp.setIdCategoria(idc);
            
            System.out.println(emp.getLinkFoto());
            
            if (!DataBaseProducto.checkExistProducto(nombre.getText().toUpperCase())) {
                if (DataBaseProducto.modifProdcuto(emp,nombreProduc)) {
                    bandera=true;
                    eli.setEnabled(true);
                    cance.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Producto " + nombre.getText() + " actualizado ");
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
                JOptionPane.showMessageDialog(null, "El producto " + nombre.getText() + " ya esta registrado");
                
            }
        } else {
            ControllerViewMsj.muestraMensajeGlobo("Agregua el nombre del producto", nombre);
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
