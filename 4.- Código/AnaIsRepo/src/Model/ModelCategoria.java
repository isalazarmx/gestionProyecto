/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Teté
 */
public class ModelCategoria {
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private int tipoProducto;

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public String addInfo(){
        return "('"
                +getNombre()+"','"
                +getDescripcion()+"',"                
                +getTipoProducto()
                +",0);";
    }
    
    
    public String modInfo(){
        return "SET NOMBRE = '"+getNombre()+"',"+ 
               "DESCRIPCION = '"+getDescripcion()+"'";     
    }

    /**
     * @return the tipoProducto
     */
    public int getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    
}
