/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Teté
 */
public class ModelUsuario {
    private int idUsuario;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String username;
    private String password;
    private int tipo;
    private int idEmpresa;
    private DefaultTableModel modeloTable;

    public DefaultTableModel creaModelTable(){
        modeloTable = new DefaultTableModel();
        modeloTable.addColumn("Nombre");
        modeloTable.addColumn("Apellido Paterno");
        modeloTable.addColumn("Apellido Materno");
        modeloTable.addColumn("Username");
        modeloTable.addColumn("Contraseña");
        return modeloTable;
    }
    
    public String despAttribute(){
        return "--- Reporte de Atributos ---\n"
                + "Nombre: "+getNombre()+"\n"
                + "aPaterno: "+getaPaterno()+"\n"
                + "aMaterno: "+getaMaterno()+"\n"
                + "username:"+getUsername()+"\n"
                + "pass:"+getPassword();
    }
    
    public String addAdmin(){
        return "(1,'"
                +getNombre()+"','"
                +getaPaterno()+"','"
                +getaMaterno()+"','"
                +getUsername()+"','"
                +getPassword()+"',"
                +getTipo()+",0,"
                +getIdEmpresa()+
                ");";
    }
    
    public String addVendedor(){
        return "(nombre,aPaterno,aMaterno,username,password,tipo,eliminado,Empresa_idEmpresa) values ('"
                +getNombre()+"','"
                +getaPaterno()+"','"
                +getaMaterno()+"','"
                +getUsername()+"','"
                +getPassword()+"',"
                +getTipo()+",0,"
                +getIdEmpresa()+
                ");";
    }
    
    public String modInfo(){
        return "set nombre = '"+getNombre()+"',"+ 
               "aPaterno = '"+getaPaterno()+"',"+
               "aMaterno = '"+getaMaterno()+"',"+
               "username = '"+getUsername()+"',"+
               "password = '"+getPassword()+"'";
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
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
