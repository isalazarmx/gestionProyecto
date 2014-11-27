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
public class ModelProveedor {
    private int idProveedor;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String marca;
    private String empresa;
    private String RFC;
    private String telFijo;
    private String telCel;
    private String calle;
    private int numInt;
    private int numExt;
    private String colonia;
    private String ciudad;
    private String estado;
    private int codigoPostal;
    private String eMail;
    private DefaultTableModel modeloTable;

    public ArrayList componentesPDF(){
        ArrayList comp = new ArrayList();
        comp.add(rotuloPDF());
        comp.add(anchoFilas());
        return comp;
    }
    
    private String[] rotuloPDF(){
        String rotulo[] = new String[6];
        rotulo[0]="Código proveedor";
        rotulo[1]="Nombre";
        rotulo[2]="Apellido paterno";
        rotulo[3]="Apellido materno";
        rotulo[4]="Marca";
        rotulo[5]="e-Mail";
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
                false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column){
                return canEdit [column];
            }
        };
        modeloTable.addColumn("Código de proveedor");
        modeloTable.addColumn("Nombre");
        modeloTable.addColumn("Apellido Paterno");
        modeloTable.addColumn("Apellido Materno");
        modeloTable.addColumn("Marca");
        modeloTable.addColumn("e-Mail");
        return modeloTable;
    }

    public String addProveedor(){
        return "(nombre,aPaterno,aMaterno,marca,empresa,rfc,telfijo,telcel,calle,numInt,numExt,colonia,ciudad,estado,codigopostal,email,eliminado) values ('"
                +getNombre()+"','"
                +getaPaterno()+"','"
                +getaMaterno()+"','"
                +getMarca()+"','"
                +getEmpresa()+"','"
                +getRFC()+"','"
                +getTelFijo()+"','"
                +getTelCel()+"','"
                +getCalle()+"',"
                +getNumInt()+","
                +getNumExt()+",'"
                +getColonia()+"','"
                +getCiudad()+"','"
                +getEstado()+"',"+
                +getCodigoPostal()+",'"
                +geteMail()+"',0"+
                ");";
    }
    
    public String modInfo(){
        return "set nombre = '"+getNombre()+"',"+ 
               "aPaterno = '"+getaPaterno()+"',"+
               "aMaterno = '"+getaMaterno()+"',"+
               "marca = '"+getMarca()+"',"+
               "empresa = '"+getEmpresa()+"',"+
               "RFC = '"+getRFC()+"',"+
               "telfijo = '"+getTelFijo()+"',"+
               "telcel = '"+getTelCel()+"',"+
               "calle = '"+getCalle()+"',"+
               "numInt = "+getNumInt()+","+
               "numExt = "+getNumExt()+","+
               "colonia = '"+getColonia()+"',"+
               "ciudad = '"+getCiudad()+"',"+
               "estado = '"+getEstado()+"',"+
               "codigopostal = "+getCodigoPostal()+","+
               "email = '"+geteMail()+"'";
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
     * @return the aPaterno
     */
    public String getaPaterno() {
        return aPaterno;
    }

    /**
     * @param aPaterno the aPaterno to set
     */
    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    /**
     * @return the aMaterno
     */
    public String getaMaterno() {
        return aMaterno;
    }

    /**
     * @param aMaterno the aMaterno to set
     */
    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the RFC
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * @param RFC the RFC to set
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * @return the telFijo
     */
    public String getTelFijo() {
        return telFijo;
    }

    /**
     * @param telFijo the telFijo to set
     */
    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    /**
     * @return the telCel
     */
    public String getTelCel() {
        return telCel;
    }

    /**
     * @param telCel the telCel to set
     */
    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numExt
     */
    public int getNumExt() {
        return numExt;
    }

    /**
     * @param numExt the numExt to set
     */
    public void setNumExt(int numExt) {
        this.numExt = numExt;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the codigoPostal
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
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

    /**
     * @return the numInt
     */
    public int getNumInt() {
        return numInt;
    }

    /**
     * @param numInt the numInt to set
     */
    public void setNumInt(int numInt) {
        this.numInt = numInt;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
