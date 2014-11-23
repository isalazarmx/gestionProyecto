/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelCliente;
import Model.ModelEmpresa;
import Model.ModelUsuario;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jesus
 */
public class ControllerPaneles {
    private ModelEmpresa modelEmpresa;
    private ModelUsuario modelUsuario;
    private ModelCliente modelCliente;
    //---------------------------------------
    private JPanel panelUserData;
    private JButton botonDatosUsuario;
    private JPanel panelBotoneraPrincipal;
    private JPanel panelCentral;
    //--------------------------------------
    private JPanel panelInicio;
    private JPanel panelVendedores;
    private JPanel panelClientes;
    
    public void configPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel.setVisible(true);
    }
    
    public void addPanel(JPanel base, JPanel panel){
        base.removeAll();
        base.add(panel);
        base.updateUI();
    }

    /**
     * @return the modelEmpresa
     */
    public ModelEmpresa getModelEmpresa() {
        return modelEmpresa;
    }

    /**
     * @param modelEmpresa the modelEmpresa to set
     */
    public void setModelEmpresa(ModelEmpresa modelEmpresa) {
        this.modelEmpresa = modelEmpresa;
    }

    /**
     * @return the modelUsuario
     */
    public ModelUsuario getModelUsuario() {
        return modelUsuario;
    }

    /**
     * @param modelUsuario the modelUsuario to set
     */
    public void setModelUsuario(ModelUsuario modelUsuario) {
        this.modelUsuario = modelUsuario;
    }

    /**
     * @return the panelBotoneraPrincipal
     */
    public JPanel getPanelBotoneraPrincipal() {
        return panelBotoneraPrincipal;
    }

    /**
     * @param panelBotoneraPrincipal the panelBotoneraPrincipal to set
     */
    public void setPanelBotoneraPrincipal(JPanel panelBotoneraPrincipal) {
        this.panelBotoneraPrincipal = panelBotoneraPrincipal;
    }

    /**
     * @return the panelCentral
     */
    public JPanel getPanelCentral() {
        return panelCentral;
    }

    /**
     * @param panelCentral the panelCentral to set
     */
    public void setPanelCentral(JPanel panelCentral) {
        this.panelCentral = panelCentral;
    }

    /**
     * @return the panelUserData
     */
    public JPanel getPanelUserData() {
        return panelUserData;
    }

    /**
     * @param panelUserData the panelUserData to set
     */
    public void setPanelUserData(JPanel panelUserData) {
        this.panelUserData = panelUserData;
    }

    /**
     * @return the botonDatosUsuario
     */
    public JButton getBotonDatosUsuario() {
        return botonDatosUsuario;
    }

    /**
     * @param userData the botonDatosUsuario to set
     */
    public void setBotonDatosUsuario(JButton userData) {
        this.botonDatosUsuario = userData;
    }

    /**
     * @return the panelInicio
     */
    public JPanel getPanelInicio() {
        return panelInicio;
    }

    /**
     * @param panelInicio the panelInicio to set
     */
    public void setPanelInicio(JPanel panelInicio) {
        this.panelInicio = panelInicio;
    }

    /**
     * @return the panelVendedores
     */
    public JPanel getPanelVendedores() {
        return panelVendedores;
    }

    /**
     * @param panelVendedores the panelVendedores to set
     */
    public void setPanelVendedores(JPanel panelVendedores) {
        this.panelVendedores = panelVendedores;
    }

    /**
     * @return the panelClientes
     */
    public JPanel getPanelClientes() {
        return panelClientes;
    }

    /**
     * @param panelClientes the panelClientes to set
     */
    public void setPanelClientes(JPanel panelClientes) {
        this.panelClientes = panelClientes;
    }

    /**
     * @return the modelCliente
     */
    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    /**
     * @param modelCliente the modelCliente to set
     */
    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }
}
