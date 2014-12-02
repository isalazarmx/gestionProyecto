/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelCategoria;
import Model.ModelCliente;
import Model.ModelEmpresa;
import Model.ModelInsumo_has_Producto;
import Model.ModelProducto;
import Model.ModelProveedor;
import Model.ModelUsuario;
import Model.ModelVenta;
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
    private ModelProveedor modelProveedor;
    private ModelProducto modelProducto;
    private ModelCategoria modelCategoria;
    private ModelInsumo_has_Producto modelInsumoProducto;
    private ModelVenta modelVenta;
    //---------------------------------------
    private JPanel panelUserData;
    private JButton botonDatosUsuario;
    private JPanel panelBotoneraPrincipal;
    private JPanel panelCentral;
    //--------------------------------------
    private JPanel panelInicio;
    private JPanel panelProductos;
    private JPanel panelAlmacen;
    private JPanel panelVendedores;
    private JPanel panelClientes;
    private JPanel panelProveedores;
    
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

    /**
     * @return the panelProveedores
     */
    public JPanel getPanelProveedores() {
        return panelProveedores;
    }

    /**
     * @param panelProveedores the panelProveedores to set
     */
    public void setPanelProveedores(JPanel panelProveedores) {
        this.panelProveedores = panelProveedores;
    }

    /**
     * @return the modelProveedor
     */
    public ModelProveedor getModelProveedor() {
        return modelProveedor;
    }

    /**
     * @param modelProveedor the modelProveedor to set
     */
    public void setModelProveedor(ModelProveedor modelProveedor) {
        this.modelProveedor = modelProveedor;
    }

    /**
     * @return the modelProducto
     */
    public ModelProducto getModelProducto() {
        return modelProducto;
    }

    /**
     * @param modelProducto the modelProducto to set
     */
    public void setModelProducto(ModelProducto modelProducto) {
        this.modelProducto = modelProducto;
    }

    /**
     * @return the modelCategoria
     */
    public ModelCategoria getModelCategoria() {
        return modelCategoria;
    }

    /**
     * @param modelCategoria the modelCategoria to set
     */
    public void setModelCategoria(ModelCategoria modelCategoria) {
        this.modelCategoria = modelCategoria;
    }

    /**
     * @return the modelInsumoProducto
     */
    public ModelInsumo_has_Producto getModelInsumoProducto() {
        return modelInsumoProducto;
    }

    /**
     * @param modelInsumoProducto the modelInsumoProducto to set
     */
    public void setModelInsumoProducto(ModelInsumo_has_Producto modelInsumoProducto) {
        this.modelInsumoProducto = modelInsumoProducto;
    }

    /**
     * @return the modelVenta
     */
    public ModelVenta getModelVenta() {
        return modelVenta;
    }

    /**
     * @param modelVenta the modelVenta to set
     */
    public void setModelVenta(ModelVenta modelVenta) {
        this.modelVenta = modelVenta;
    }

    /**
     * @return the panelProductos
     */
    public JPanel getPanelProductos() {
        return panelProductos;
    }

    /**
     * @param panelProductos the panelProductos to set
     */
    public void setPanelProductos(JPanel panelProductos) {
        this.panelProductos = panelProductos;
    }

    /**
     * @return the panelAlmacen
     */
    public JPanel getPanelAlmacen() {
        return panelAlmacen;
    }

    /**
     * @param panelAlmacen the panelAlmacen to set
     */
    public void setPanelAlmacen(JPanel panelAlmacen) {
        this.panelAlmacen = panelAlmacen;
    }
}
