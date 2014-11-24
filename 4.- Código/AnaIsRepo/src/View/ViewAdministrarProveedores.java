/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPaneles;
import Controller.ControllerValidation;
import Controller.ControllerViewAdministrarClientes;
import Model.ModelCliente;
import java.util.ArrayList;

/**
 *
 * @author Carolina
 */
public class ViewAdministrarProveedores extends javax.swing.JPanel {
    ControllerViewAdministrarClientes controller;
    ControllerValidation validation;
    ControllerPaneles controllerPaneles;
    ModelCliente modelCliente;
   
public ViewAdministrarProveedores(ControllerPaneles controllerPaneles) {
        this.validation = new ControllerValidation();
        this.controllerPaneles = controllerPaneles;//asi
        controllerPaneles.setModelCliente(new ModelCliente());
        this.modelCliente = controllerPaneles.getModelCliente();
        initComponents();
        modelCliente.creaModelTable();
        validation();
        controller.buscaCliente(true);
    }

private void validation(){
        ArrayList components = new ArrayList<>();
        components.add(Nombre);
        components.add(rfc);
        components.add(labelCount);
        components.add(tableClientes);
        components.add(modelCliente.getModeloTable());
        controller = new ControllerViewAdministrarClientes(components);
        controller.validations();
    }    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rfc = new javax.swing.JTextField();
        buttonBuscaCliente = new javax.swing.JButton();
        buttonVerTodos = new javax.swing.JButton();
        panelRsultadoBusqueda = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nuevoVendedor = new javax.swing.JButton();
        eliminaVendedor = new javax.swing.JButton();
        modificaVendedor = new javax.swing.JButton();
        limipaBusqueda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        panelCantidadResultados = new javax.swing.JPanel();
        labelCount = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 246, 247));
        setPreferredSize(new java.awt.Dimension(900, 600));

        panelTitulo.setBackground(new java.awt.Color(250, 250, 250));
        panelTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 107, 161));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/proveedoresInfo.png"))); // NOI18N
        jLabel1.setText("Administración de proveedores");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panelBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nombre:");
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 26));

        Nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre.setForeground(new java.awt.Color(180, 180, 180));
        Nombre.setText("Nombre");
        Nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreFocusLost(evt);
            }
        });
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NombreKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("R.F.C.");
        jLabel5.setPreferredSize(new java.awt.Dimension(66, 26));

        rfc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rfc.setForeground(new java.awt.Color(180, 180, 180));
        rfc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        rfc.setText("R.F.C.");
        rfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rfcFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rfcFocusLost(evt);
            }
        });
        rfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfcActionPerformed(evt);
            }
        });
        rfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rfcKeyPressed(evt);
            }
        });

        buttonBuscaCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonBuscaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/findUser.png"))); // NOI18N
        buttonBuscaCliente.setText("Busca proveedor");
        buttonBuscaCliente.setContentAreaFilled(false);
        buttonBuscaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBuscaCliente.setPreferredSize(new java.awt.Dimension(119, 26));
        buttonBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscaClienteActionPerformed(evt);
            }
        });

        buttonVerTodos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonVerTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/verTodo.png"))); // NOI18N
        buttonVerTodos.setText("Ver todos");
        buttonVerTodos.setContentAreaFilled(false);
        buttonVerTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonVerTodos.setPreferredSize(new java.awt.Dimension(119, 26));
        buttonVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonVerTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelRsultadoBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panelRsultadoBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        nuevoVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/new.png"))); // NOI18N
        nuevoVendedor.setToolTipText("Nuevo cliente");
        nuevoVendedor.setContentAreaFilled(false);
        nuevoVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevoVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoVendedorActionPerformed(evt);
            }
        });

        eliminaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar.png"))); // NOI18N
        eliminaVendedor.setToolTipText("Elimina cliente");
        eliminaVendedor.setContentAreaFilled(false);
        eliminaVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaVendedorActionPerformed(evt);
            }
        });

        modificaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        modificaVendedor.setToolTipText("Mdifica cliente");
        modificaVendedor.setContentAreaFilled(false);
        modificaVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaVendedorActionPerformed(evt);
            }
        });

        limipaBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        limipaBusqueda.setToolTipText("Limpia busqueda");
        limipaBusqueda.setContentAreaFilled(false);
        limipaBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limipaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limipaBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(limipaBusqueda, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(modificaVendedor, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(eliminaVendedor, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(nuevoVendedor, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(nuevoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limipaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableClientes);

        javax.swing.GroupLayout panelRsultadoBusquedaLayout = new javax.swing.GroupLayout(panelRsultadoBusqueda);
        panelRsultadoBusqueda.setLayout(panelRsultadoBusquedaLayout);
        panelRsultadoBusquedaLayout.setHorizontalGroup(
            panelRsultadoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRsultadoBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRsultadoBusquedaLayout.setVerticalGroup(
            panelRsultadoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRsultadoBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRsultadoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelCantidadResultados.setBackground(new java.awt.Color(255, 255, 255));
        panelCantidadResultados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        labelCount.setBackground(new java.awt.Color(53, 107, 161));
        labelCount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCount.setForeground(new java.awt.Color(53, 107, 161));
        labelCount.setText("Ingresa un nombre de usuario y/o RFC para iniciar la busqueda");

        javax.swing.GroupLayout panelCantidadResultadosLayout = new javax.swing.GroupLayout(panelCantidadResultados);
        panelCantidadResultados.setLayout(panelCantidadResultadosLayout);
        panelCantidadResultadosLayout.setHorizontalGroup(
            panelCantidadResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantidadResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCount, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCantidadResultadosLayout.setVerticalGroup(
            panelCantidadResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCantidadResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCount)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRsultadoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCantidadResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCantidadResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRsultadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaVendedorActionPerformed
        // TODO add your handling code here:
        controller.eliminaCliente();
    }//GEN-LAST:event_eliminaVendedorActionPerformed

    private void nuevoVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoVendedorActionPerformed
        // TODO add your handling code here:
        controllerPaneles.addPanel(controllerPaneles.getPanelCentral(), new ViewCliente(controllerPaneles,null)); //asi
    }//GEN-LAST:event_nuevoVendedorActionPerformed

    private void NombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusGained
        // TODO add your handling code here:
        validation.placeHolder(true, Nombre,"Nombre");
    }//GEN-LAST:event_NombreFocusGained

    private void NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusLost
        // TODO add your handling code here:
        validation.placeHolder(false, Nombre,"Nombre");
    }//GEN-LAST:event_NombreFocusLost

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void rfcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rfcFocusGained
        // TODO add your handling code here:
        validation.placeHolder(true, rfc,"R.F.C.");
    }//GEN-LAST:event_rfcFocusGained

    private void rfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rfcFocusLost
        // TODO add your handling code here:
        validation.placeHolder(false, rfc,"R.F.C.");
    }//GEN-LAST:event_rfcFocusLost

    private void rfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rfcActionPerformed

    private void buttonBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscaClienteActionPerformed
        // TODO add your handling code here:
        controller.buscaCliente(false);
    }//GEN-LAST:event_buttonBuscaClienteActionPerformed

    private void buttonVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerTodosActionPerformed
        // TODO add your handling code here:
        controller.buscaCliente(true);
    }//GEN-LAST:event_buttonVerTodosActionPerformed

    private void limipaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limipaBusquedaActionPerformed
        // TODO add your handling code here:
        controller.limpiaBusqueda();
        controller.limpiaCampos();
    }//GEN-LAST:event_limipaBusquedaActionPerformed

    private void modificaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaVendedorActionPerformed
        // TODO add your handling code here:
        if(controller.tablaSeleccionada()){
            ModelCliente cliente = DataBase.DataBaseCliente.findCliente(controller.clienteModificar());
            controllerPaneles.addPanel(controllerPaneles.getPanelCentral(), new ViewCliente(controllerPaneles,cliente));
        }
    }//GEN-LAST:event_modificaVendedorActionPerformed

    private void rfcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfcKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==10)
            controller.buscaCliente(false);
    }//GEN-LAST:event_rfcKeyPressed

    private void NombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==10)
            controller.buscaCliente(false);
    }//GEN-LAST:event_NombreKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton buttonBuscaCliente;
    private javax.swing.JButton buttonVerTodos;
    private javax.swing.JButton eliminaVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCount;
    private javax.swing.JButton limipaBusqueda;
    private javax.swing.JButton modificaVendedor;
    private javax.swing.JButton nuevoVendedor;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelCantidadResultados;
    private javax.swing.JPanel panelRsultadoBusqueda;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField rfc;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
