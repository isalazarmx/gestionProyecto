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
public class ModelEmpresa {
    private int idEmpresa;
    private String nombre;
    private String calle;
    private int numINT;
    private int numExt;
    private String ciudad;
    private String colonia;
    private String estado;
    private int codigoPostal;
    private String RFC;
    private String pagWeb;
    private String eMail;

    public String despAttribute(){
        return "--- Reporte de Atributos ---\n"
                + "Nombre: "+getNombre()+"\n"
                + "R.F.C.: "+getRFC()+"\n"
                + "Calle: "+getCalle()+"\n"
                + "No. Int:"+getNumINT()+"\n"
                + "No. Ext:"+getNumExt()+"\n"
                + "Colonia:"+getColonia()+"\n"
                + "C.P.:"+getCodigoPostal()+"\n"
                + "Página Web:"+getPagWeb()+"\n"
                + "E-mail:"+geteMail();
    }
    
    public String addInfo(){
        return "(01,'"
                +getNombre()+"','"
                +getCalle()+"',"
                +getNumINT()+","
                +getNumExt()+",'"
                +getCiudad()+"','"
                +getColonia()+"','"
                +getEstado()+"',"
                +getCodigoPostal()+",'"
                +getRFC()+"','"
                +getPagWeb()+"','"
                +geteMail()+"'"
                +",0);";
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
     * @return the numINT
     */
    public int getNumINT() {
        return numINT;
    }

    /**
     * @param numINT the numINT to set
     */
    public void setNumINT(int numINT) {
        this.numINT = numINT;
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
     * @return the pagWeb
     */
    public String getPagWeb() {
        return pagWeb;
    }

    /**
     * @param pagWeb the pagWeb to set
     */
    public void setPagWeb(String pagWeb) {
        this.pagWeb = pagWeb;
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
