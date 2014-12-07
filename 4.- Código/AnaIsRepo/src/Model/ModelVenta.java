/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Teté
 */
public class ModelVenta {
    private int idVenta;
    private String fechaVenta;
    private String fechaEntrega;
    private int kilos;
    private double abono;
    private double resto;       
    private double precioTotal;
    private boolean entregado;
    private String descripcion;
    private int tipoVenta;
    private int idUsuario;
    private int idCliente;
    private int idProducto;
    private DefaultTableModel modeloTable;
    
    
    
    public ArrayList componentesPDF(){
        ArrayList comp = new ArrayList();
        comp.add(rotuloPDF());
        comp.add(anchoFilas());
        return comp;
    }
    
    private String[] rotuloPDF(){
        String rotulo[] = new String[5];
        rotulo[0]="Código venta";
        rotulo[1]="Tipo de venta";
        rotulo[2]="Fecha de venta";
        rotulo[3]="Precio total";
        rotulo[4]="Vendedor";
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

    public DefaultTableModel creaModelTable(){
        setModeloTable(new DefaultTableModel(){
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false,false
            };
            @Override
            public boolean isCellEditable(int row, int column){
                return canEdit [column];
            }
        });
        getModeloTable().addColumn("Código");
        getModeloTable().addColumn("Articulo");
        getModeloTable().addColumn("Descripcion");
        getModeloTable().addColumn("Tipo Venta");
        getModeloTable().addColumn("Cantidad");
        getModeloTable().addColumn("Precio");
        getModeloTable().addColumn("Importe");
        return getModeloTable();
    }
    /**
     * @return the idVenta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return the tipoVenta
     */
    public int getTipoVenta() {
        return tipoVenta;
    }

    /**
     * @param tipoVenta the tipoVenta to set
     */
    public void setTipoVenta(int tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    /**
     * @return the fechaVenta
     */
    public String getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the fechaEntrega
     */
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * @return the kilos
     */
    public int getKios() {
        return kilos;
    }

    /**
     * @param kios the kilos to set
     */
    public void setKios(int kios) {
        this.kilos = kios;
    }

    /**
     * @return the abono
     */
    public double getAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(double abono) {
        this.abono = abono;
    }

    /**
     * @return the resto
     */
    public double getResto() {
        return resto;
    }

    /**
     * @param resto the resto to set
     */
    public void setResto(double resto) {
        this.resto = resto;
    }

    /**
     * @return the precioTotal
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * @return the entregado
     */
    public boolean isEntregado() {
        return entregado;
    }

    /**
     * @param entregado the entregado to set
     */
    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

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
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
