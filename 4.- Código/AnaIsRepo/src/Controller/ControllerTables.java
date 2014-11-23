/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus
 */
public class ControllerTables {
    private DefaultTableModel modelTable;
    private JTable tabla;

    public void agregarDatos(String[] datos){
        getModelTable().addRow(datos);
    }
    
    /**
     * @return the modelTable
     */
    public DefaultTableModel getModelTable() {
        return modelTable;
    }

    /**
     * @param modelTable the modelTable to set
     */
    public void setModelTable(DefaultTableModel modelTable) {
        this.modelTable = modelTable;
    }

    /**
     * @return the tabla
     */
    public JTable getTabla() {
        return tabla;
    }

    /**
     * @param tabla the tabla to set
     */
    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }
    
}
