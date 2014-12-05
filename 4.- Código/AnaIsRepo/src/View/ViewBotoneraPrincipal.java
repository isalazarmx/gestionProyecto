/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPaneles;
import Controller.ControllerViewAdministradorBotoneraPrincipal;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jesus
 */
public class ViewBotoneraPrincipal extends javax.swing.JPanel {
    ControllerPaneles controllerPaneles;
    ControllerViewAdministradorBotoneraPrincipal controller;
    JPanel panelBotoneraSubPrincipal;
    JPanel panelCentral;
    
    /**
     * Creates new form ViewBaseAdministradorBotoneraPrincipal
     * @param controllerPaneles
     * @param flag
     */
    public ViewBotoneraPrincipal(ControllerPaneles controllerPaneles,boolean flag) {
        this.controllerPaneles = controllerPaneles;
        this.panelCentral = controllerPaneles.getPanelCentral();
        initComponents();
        initController();
        initPanelesBotones();
        if(flag){
            controller.accionButton(1);
            controllerPaneles.setPanelInicio(new ViewBaseAdministrador(controllerPaneles));
            controllerPaneles.addPanel(panelCentral, controllerPaneles.getPanelInicio());
        }else
            controller.accionButton(10);    
    }
    
    private void initPanelesBotones(){
        controllerPaneles.setPanelProductos(new ViewAdministrarProductos(controllerPaneles,false));
        controllerPaneles.setPanelAlmacen(new ViewAdministrarProductos(controllerPaneles,true));
        controllerPaneles.setPanelVendedores(new ViewAdministrarVendedores(controllerPaneles));
        controllerPaneles.setPanelClientes(new ViewAdministrarClientes(controllerPaneles));
        controllerPaneles.setPanelProveedores(new ViewAdministrarProveedores(controllerPaneles));
    }
    
     private void initController(){
        ArrayList components = new ArrayList<>();
        components.add(inicio);
        components.add(productos);
        components.add(inventario);
        components.add(vendedores);
        components.add(clientes);
        components.add(proveedores);
        components.add(ventas);
        components.add(pedidos);
        components.add(reportes);
        controller = new ControllerViewAdministradorBotoneraPrincipal(components);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicio = new javax.swing.JButton();
        productos = new javax.swing.JButton();
        inventario = new javax.swing.JButton();
        clientes = new javax.swing.JButton();
        proveedores = new javax.swing.JButton();
        ventas = new javax.swing.JButton();
        pedidos = new javax.swing.JButton();
        reportes = new javax.swing.JButton();
        vendedores = new javax.swing.JButton();

        setBackground(new java.awt.Color(20, 20, 20));

        inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inicio.setForeground(new java.awt.Color(51, 51, 51));
        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/inicioDisable.png"))); // NOI18N
        inicio.setContentAreaFilled(false);
        inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inicio.setSelected(true);
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        productos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productos.setForeground(new java.awt.Color(51, 51, 51));
        productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/productoDisable.png"))); // NOI18N
        productos.setContentAreaFilled(false);
        productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        productos.setSelected(true);
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });

        inventario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inventario.setForeground(new java.awt.Color(51, 51, 51));
        inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/inventarioDisable.png"))); // NOI18N
        inventario.setContentAreaFilled(false);
        inventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inventario.setSelected(true);
        inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });

        clientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clientes.setForeground(new java.awt.Color(51, 51, 51));
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clientesDisable.png"))); // NOI18N
        clientes.setContentAreaFilled(false);
        clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clientes.setSelected(true);
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });

        proveedores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        proveedores.setForeground(new java.awt.Color(51, 51, 51));
        proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/proveedoresDisable.png"))); // NOI18N
        proveedores.setContentAreaFilled(false);
        proveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        proveedores.setSelected(true);
        proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedoresActionPerformed(evt);
            }
        });

        ventas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ventas.setForeground(new java.awt.Color(51, 51, 51));
        ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ventasDisable.png"))); // NOI18N
        ventas.setContentAreaFilled(false);
        ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ventas.setSelected(true);
        ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasActionPerformed(evt);
            }
        });

        pedidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pedidos.setForeground(new java.awt.Color(51, 51, 51));
        pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pedidosDisable.png"))); // NOI18N
        pedidos.setContentAreaFilled(false);
        pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedidos.setSelected(true);
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });

        reportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reportes.setForeground(new java.awt.Color(51, 51, 51));
        reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reportesDisable.png"))); // NOI18N
        reportes.setContentAreaFilled(false);
        reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportes.setSelected(true);
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });

        vendedores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vendedores.setForeground(new java.awt.Color(51, 51, 51));
        vendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/vendedoresDisable.png"))); // NOI18N
        vendedores.setContentAreaFilled(false);
        vendedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vendedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vendedores.setSelected(true);
        vendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clientes, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ventas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vendedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // TODO add your handling code here:
        controller.accionButton(1);
        controllerPaneles.addPanel(panelCentral,controllerPaneles.getPanelInicio());
    }//GEN-LAST:event_inicioActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
        // TODO add your handling code here:
        controller.accionButton(2);
        controllerPaneles.addPanel(panelCentral,controllerPaneles.getPanelProductos());
    }//GEN-LAST:event_productosActionPerformed

    private void inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioActionPerformed
        // TODO add your handling code here:
        controller.accionButton(3);
        controllerPaneles.addPanel(panelCentral, controllerPaneles.getPanelAlmacen());
    }//GEN-LAST:event_inventarioActionPerformed

    private void proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresActionPerformed
            // TODO add your handling code here:
        controller.accionButton(6);
        controllerPaneles.addPanel(panelCentral, controllerPaneles.getPanelProveedores());
        
    }//GEN-LAST:event_proveedoresActionPerformed

    private void ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasActionPerformed
        // TODO add your handling code here:
        controller.accionButton(7);
        controllerPaneles.addPanel(panelCentral, new ViewRealizarVentas(controllerPaneles));
    }//GEN-LAST:event_ventasActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        // TODO add your handling code here:
        controller.accionButton(9);
        controllerPaneles.addPanel(panelCentral, new ViewReportes(controllerPaneles));
    }//GEN-LAST:event_reportesActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        // TODO add your handling code here:
        controller.accionButton(5);
        controllerPaneles.addPanel(panelCentral, controllerPaneles.getPanelClientes());
    }//GEN-LAST:event_clientesActionPerformed

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        // TODO add your handling code here:
        controller.accionButton(8);
        controllerPaneles.addPanel(panelCentral,new ViewPedidos(controllerPaneles));
    }//GEN-LAST:event_pedidosActionPerformed

    private void vendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedoresActionPerformed
        // TODO add your handling code here:
        controller.accionButton(4);
        controllerPaneles.addPanel(panelCentral, controllerPaneles.getPanelVendedores());
    }//GEN-LAST:event_vendedoresActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientes;
    private javax.swing.JButton inicio;
    private javax.swing.JButton inventario;
    private javax.swing.JButton pedidos;
    private javax.swing.JButton productos;
    private javax.swing.JButton proveedores;
    private javax.swing.JButton reportes;
    private javax.swing.JButton vendedores;
    private javax.swing.JButton ventas;
    // End of variables declaration//GEN-END:variables
}
