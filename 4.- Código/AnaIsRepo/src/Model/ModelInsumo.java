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
public class ModelInsumo {
    private int idInsumo;
    private String nombre;
    private int unidadExistencia;
    private String tipoUnidad;
    private int minStock;
    private int maxStock;
    private double precioUnidad;
    private int idProveedor;

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
     * @return the unidadExistencia
     */
    public int getUnidadExistencia() {
        return unidadExistencia;
    }

    /**
     * @param unidadExistencia the unidadExistencia to set
     */
    public void setUnidadExistencia(int unidadExistencia) {
        this.unidadExistencia = unidadExistencia;
    }

    /**
     * @return the tipoUnidad
     */
    public String getTipoUnidad() {
        return tipoUnidad;
    }

    /**
     * @param tipoUnidad the tipoUnidad to set
     */
    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    /**
     * @return the minStock
     */
    public int getMinStock() {
        return minStock;
    }

    /**
     * @param minStock the minStock to set
     */
    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    /**
     * @return the maxStock
     */
    public int getMaxStock() {
        return maxStock;
    }

    /**
     * @param maxStock the maxStock to set
     */
    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    /**
     * @return the precioUnidad
     */
    public double getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * @param precioUnidad the precioUnidad to set
     */
    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    /**
     * @return the idProveedor
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
}
