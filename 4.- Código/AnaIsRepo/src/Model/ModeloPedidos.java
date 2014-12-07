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
public class ModeloPedidos {
    private int idventaPedido;
    private double abono;
    private double resto;
    private boolean entregado;
    private String descripcion;
    private DefaultTableModel modeloTable;
    
    public ArrayList componentesPDF(){
        ArrayList comp = new ArrayList();
        comp.add(rotuloPDF());
        comp.add(anchoFilas());
        return comp;
    }
    
    private String[] rotuloPDF(){
        String rotulo[] = new String[6];
        rotulo[0]="Codigo Pedido";
        rotulo[1]="Total";
        rotulo[2]="Cliente";
        rotulo[3]="Vendedor";
        rotulo[4]="Fecha de venta";
        rotulo[5]="Fecha de entrega";
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
        modeloTable = new DefaultTableModel(){
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column){
                return canEdit [column];
            }
        };
        modeloTable.addColumn("Código Venta");
        modeloTable.addColumn("Código Cliente");
        modeloTable.addColumn("Fecha Pedido");
        modeloTable.addColumn("Fecha Entrega");
        modeloTable.addColumn("Lugar Entrega");
        modeloTable.addColumn("Hora Entrega");
        modeloTable.addColumn("Total");
        modeloTable.addColumn("Abono");
        modeloTable.addColumn("Resto");
        return modeloTable;
    }

    /**
     * @return the idventaPedido
     */
    public int getIdventaPedido() {
        return idventaPedido;
    }

    /**
     * @param idventaPedido the idventaPedido to set
     */
    public void setIdventaPedido(int idventaPedido) {
        this.idventaPedido = idventaPedido;
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
                +getIdventaPedido()+"','"
                +getDescripcion()+"','"                
                +getAbono()+"',"
                +getResto()+","
                +",01"
                + ");";
    }
    
    public String modInfo(){
        return "set id = '"+getIdventaPedido()+"',"+ 
               "descripcion = '"+getDescripcion()+"',"+
               "abono = '"+getAbono()+"',"+
               "resto = "+getResto()
                ;     
    }
    
    
    
}
