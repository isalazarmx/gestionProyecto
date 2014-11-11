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
public class ModelInsumo_has_Producto {
    private int idProducto;
    private int idInsumo;

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the idInsumo
     */
    public int getIdInsumo() {
        return idInsumo;
    }

    /**
     * @param idInsumo the idInsumo to set
     */
    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
    
}
