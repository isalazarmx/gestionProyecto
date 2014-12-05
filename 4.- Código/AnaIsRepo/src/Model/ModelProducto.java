/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
    private File rutaImagen;
    private int tipoProducto;
    private int emprsa_idempresa;
    private int categoria_idcategoria;
    private DefaultTableModel modeloTable;
    
    public ArrayList componentesPDF(){
        ArrayList comp = new ArrayList();
        comp.add(rotuloPDF());
        comp.add(anchoFilas());
        return comp;
    }
    
        private String[] rotuloPDF(){
        String rotulo[] = new String[6];
        rotulo[0]="Código";
        rotulo[1]="Nombre";
        rotulo[2]="Cantidad existencía";
        rotulo[3]="Precio compra";
        rotulo[4]="Precio venta";
        rotulo[5]="Ganancía";
        return rotulo;
    }
        
        private float[] anchoFilas(){
        float ancho[] = new float[6];
        ancho[0] = 1f;
        ancho[1] = 1f;
        ancho[2] = 1f;
        ancho[3] = 1f;
        ancho[4] = 1f;
        ancho[5] = 1f;
        return ancho; 
    }

        public DefaultTableModel creaModelTable(){
        setModeloTable(new DefaultTableModel(){
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column){
                return canEdit [column];
            }
        });
        getModeloTable().addColumn("Código");
        getModeloTable().addColumn("Nombre");
        getModeloTable().addColumn("Cantidad");
        getModeloTable().addColumn("PrecioCompra");
        getModeloTable().addColumn("PrecioVenta");
        getModeloTable().addColumn("Ganancia");
        return getModeloTable();
    }

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
    public File getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(File rutaImagen) {
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

    /**
     * @return the modeloTable
     */
    public DefaultTableModel getModeloTable() {
        return modeloTable;
    }

    /**
     * @param modeloTable the modeloTable to set
     */
    public void setModeloTable(DefaultTableModel modeloTable) {
        this.modeloTable = modeloTable;
    }
          
    
}
