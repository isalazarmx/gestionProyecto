/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPaneles;
import Controller.ControllerValidation;
import Controller.ControllerViewAdministrarVendedores;
import Controller.ControllerViewMsj;
import Model.ModelUsuario;
import java.util.ArrayList;

/**
 *
 * @author Carolina
 */
public class ViewAdministrarVendedores extends javax.swing.JPanel {
    ControllerViewAdministrarVendedores controller;
    ControllerValidation validation;
    ControllerPaneles controllerPaneles;
    ModelUsuario modelUsuario;
    
   
public ViewAdministrarVendedores(ControllerPaneles controllerPaneles) {
        this.validation = new ControllerValidation();
        this.controllerPaneles = controllerPaneles;//asi
        this.modelUsuario = controllerPaneles.getModelUsuario();
        initComponents();
        modelUsuario.creaModelTable();
        validation();
        controller.buscaUsuario(true);
    }

private void validation(){
        ArrayList components = new ArrayList<>();
        components.add(Nombre);
        components.add(username);
        components.add(labelCount);
        components.add(tableVendedores);
        components.add(modelUsuario.getModeloTable());
        controller = new ControllerViewAdministrarVendedores(components);
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
        username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelRsultadoBusqueda = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nuevoVendedor = new javax.swing.JButton();
        eliminaVendedor = new javax.swing.JButton();
        modificaVendedor = new javax.swing.JButton();
        limipaBusqueda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVendedores = new javax.swing.JTable();
        panelCantidadResultados = new javax.swing.JPanel();
        labelCount = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 246, 247));
        setPreferredSize(new java.awt.Dimension(900, 600));

        panelTitulo.setBackground(new java.awt.Color(250, 250, 250));
        panelTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 107, 161));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/vendedorInfo.png"))); // NOI18N
        jLabel1.setText("Administración de vendedores");

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
        jLabel5.setText("Username:");
        jLabel5.setPreferredSize(new java.awt.Dimension(66, 26));

        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(180, 180, 180));
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setText("Username");
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/findUser.png"))); // NOI18N
        jButton1.setText("Busca Vendedor");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(119, 26));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/verTodo.png"))); // NOI18N
        jButton2.setText("Ver todos");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(119, 26));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelRsultadoBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panelRsultadoBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        nuevoVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/newUser.png"))); // NOI18N
        nuevoVendedor.setToolTipText("Nuevo vendedor");
        nuevoVendedor.setContentAreaFilled(false);
        nuevoVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevoVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoVendedorActionPerformed(evt);
            }
        });

        eliminaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/removeUser.png"))); // NOI18N
        eliminaVendedor.setToolTipText("Elimina vendedor");
        eliminaVendedor.setContentAreaFilled(false);
        eliminaVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaVendedorActionPerformed(evt);
            }
        });

        modificaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        modificaVendedor.setToolTipText("Mdifica vendedor");
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

        tableVendedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableVendedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableVendedores);

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
        labelCount.setText("Ingresa un nombre de usuario y/o username para iniciar la busqueda");

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
        controller.eliminaVendedor();
    }//GEN-LAST:event_eliminaVendedorActionPerformed

    private void nuevoVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoVendedorActionPerformed
        // TODO add your handling code here:
        controllerPaneles.addPanel(controllerPaneles.getPanelCentral(), new ViewVendedor(controllerPaneles,null)); //asi
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

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        // TODO add your handling code here:
        validation.placeHolder(true, username,"Username");
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // TODO add your handling code here:
        validation.placeHolder(false, username,"Username");
    }//GEN-LAST:event_usernameFocusLost

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controller.buscaUsuario(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        controller.buscaUsuario(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void limipaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limipaBusquedaActionPerformed
        // TODO add your handling code here:
        controller.limpiaBusqueda();
        controller.limpiaCampos();
    }//GEN-LAST:event_limipaBusquedaActionPerformed

    private void modificaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaVendedorActionPerformed
        // TODO add your handling code here:
        if(controller.tablaSeleccionada()){
            ModelUsuario user = DataBase.DataBaseUsuario.findUser(controller.vendedorModificar());
            controllerPaneles.addPanel(controllerPaneles.getPanelCentral(), new ViewVendedor(controllerPaneles,user));
        }
    }//GEN-LAST:event_modificaVendedorActionPerformed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==10)
            controller.buscaUsuario(false);
    }//GEN-LAST:event_usernameKeyPressed

    private void NombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==10)
            controller.buscaUsuario(false);
    }//GEN-LAST:event_NombreKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton eliminaVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTable tableVendedores;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
