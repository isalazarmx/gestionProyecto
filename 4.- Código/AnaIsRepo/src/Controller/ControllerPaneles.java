/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelEmpresa;
import Model.ModelUsuario;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Jesus
 */
public class ControllerPaneles {
    private ModelEmpresa modelEmpresa;
    private ModelUsuario modelUsuario;
    private JPanel panelBotoneraPrincipal;
    private JPanel panelCentral;
    
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
}
