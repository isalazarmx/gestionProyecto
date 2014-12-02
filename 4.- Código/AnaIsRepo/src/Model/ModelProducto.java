/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Blob;
import java.util.ArrayList;

/**
 *
 * @author Teté
 */
public class ModelProducto {
    private String idProducto;
    private String nombre;
    private double cantidad;
    private String tipoUnidad;
    private int unidadExistencia;
    private int minStock;
    private int maxStock;
    private double precioCompra;
    private double incrementoVenta;
    private double precioVenta;
    private Blob imagen;
    private String rutaImagen;
    private int tipoProducto;
    private int emprsa_idempresa;
    private int categoria_idcategoria;
    
    public ArrayList componentesPDF(){
        ArrayList comp = new ArrayList();
        comp.add(rotuloPDF());
        comp.add(anchoFilas());
        return comp;
    }
    
        private String[] rotuloPDF(){
        String rotulo[] = new String[5];
        rotulo[0]="Código producto";
        rotulo[1]="Nombre";
        rotulo[2]="Kilos";
        rotulo[3]="Precio unitario";
        rotulo[4]="Categoria";
        return rotulo;
    }
        
        private float[] anchoFilas(){
        float ancho[] = new float[5];
        ancho[0] = 1f;
        ancho[1] = 1f;
        ancho[2] = 1f;
        ancho[3] = 1f;
        ancho[4] = 1f;
        return ancho; 
    }

//    public String addInfo(){
//        return "('"
//                +getNombre()+"','"
//                +getDescripcion()+"','"                
//                +getLinkFoto()+"',"
//                +getKilos()+","
//                +getNumPersonas()+","
//                +getPrecioUnitario()+","
//                +"0,"
//                +getIdCategoria()+""
//                +",01"
//                + ");";
//    }
    
//    public String modInfo(){
//        return "set nombre = '"+getNombre()+"',"+ 
//               "descripcion = '"+getDescripcion()+"',"+
//               "linkFoto = '"+getLinkFoto()+"',"+
//               "kilos = "+getKilos()+","+
//               "numPersonas = "+getNumPersonas()+","+
//               "precioUnitario = "+getPrecioUnitario()+","+
//                "Categoria_idCategoria = "+getIdCategoria()+""
//                ;     
//    }

    /**
     * @return the idProducto
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
     * @return the precioCompra
     */
    public double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * @param precioCompra the precioCompra to set
     */
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * @return the incrementoVenta
     */
    public double getIncrementoVenta() {
        return incrementoVenta;
    }

    /**
     * @param incrementoVenta the incrementoVenta to set
     */
    public void setIncrementoVenta(double incrementoVenta) {
        this.incrementoVenta = incrementoVenta;
    }

    /**
     * @return the precioVenta
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the imagen
     */
    public Blob getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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

    /**
     * @return the emprsa_idempresa
     */
    public int getEmprsa_idempresa() {
        return emprsa_idempresa;
    }

    /**
     * @param emprsa_idempresa the emprsa_idempresa to set
     */
    public void setEmprsa_idempresa(int emprsa_idempresa) {
        this.emprsa_idempresa = emprsa_idempresa;
    }

    /**
     * @return the categoria_idcategoria
     */
    public int getCategoria_idcategoria() {
        return categoria_idcategoria;
    }

    /**
     * @param categoria_idcategoria the categoria_idcategoria to set
     */
    public void setCategoria_idcategoria(int categoria_idcategoria) {
        this.categoria_idcategoria = categoria_idcategoria;
    }
          
    
}
