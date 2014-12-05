/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPaneles;
import Controller.ControllerValidation;
import Controller.ControllerViewAdministrarProducto;
import Model.ModelProducto;
import java.util.ArrayList;

/**
 *
 * @author Carolina
 */
public class ViewAdministrarProductos extends javax.swing.JPanel {
    ControllerViewAdministrarProducto controller;
    ControllerValidation validation;
    ControllerPaneles controllerPaneles;
    ModelProducto modelProducto;
    boolean tipoAlmacen;
   
public ViewAdministrarProductos(ControllerPaneles controllerPaneles,boolean tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
        this.validation = new ControllerValidation();
        this.controllerPaneles = controllerPaneles;//asi
        controllerPaneles.setModelProducto(new ModelProducto());
        this.modelProducto = controllerPaneles.getModelProducto();
        initComponents();
        modelProducto.creaModelTable();
        validation();
        if(tipoAlmacen){
            labelTitulo.setText("Administración de almacén");
            labelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/almacenInfo.png")));
        }else{
            labelTitulo.setText("Administración de productos");
            labelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ajustesProducto.png")));
        }
        for (int i = 0; i < 4; i++)
            controller.cargarCombo(i,tipoAlmacen);
    }

private void validation(){
        ArrayList components = new ArrayList<>();
        components.add(idCategoria);
        components.add(idProveedor);
        components.add(vertodos);
        components.add(tableProducto);
        components.add(modelProducto.getModeloTable());
        components.add(tipoAlmacen);
        controller = new ControllerViewAdministrarProducto(components);
        controller.validations();
    }    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        vertodos = new javax.swing.JButton();
        idCategoria = new javax.swing.JComboBox();
        idProveedor = new javax.swing.JComboBox();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        vertodos1 = new javax.swing.JButton();
        panelRsultadoBusqueda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProducto = new javax.swing.JTable();
        panelImagen = new javax.swing.JPanel();
        imagen = new javax.swing.JButton();
        vertodos2 = new javax.swing.JButton();
        panelCantidadResultados = new javax.swing.JPanel();
        labelCount = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 246, 247));
        setPreferredSize(new java.awt.Dimension(900, 600));

        panelTitulo.setBackground(new java.awt.Color(250, 250, 250));
        panelTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        labelTitulo.setBackground(new java.awt.Color(250, 250, 250));
        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(53, 107, 161));
        labelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/almacenInfo.png"))); // NOI18N
        labelTitulo.setText("Administración de almacén");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panelBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        vertodos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vertodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/verTodo.png"))); // NOI18N
        vertodos.setText("Ver todos");
        vertodos.setContentAreaFilled(false);
        vertodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vertodos.setPreferredSize(new java.awt.Dimension(119, 26));
        vertodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertodosActionPerformed(evt);
            }
        });

        idCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona categoría" }));
        idCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        idCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCategoriaActionPerformed(evt);
            }
        });
        idCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idCategoriaKeyPressed(evt);
            }
        });

        idProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona proveedor" }));
        idProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        idProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProveedorActionPerformed(evt);
            }
        });
        idProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idProveedorKeyPressed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Busqueda por categoria:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Busqueda por proveedor:");

        vertodos1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vertodos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/administrar.png"))); // NOI18N
        vertodos1.setText("Administrar");
        vertodos1.setContentAreaFilled(false);
        vertodos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vertodos1.setPreferredSize(new java.awt.Dimension(119, 26));
        vertodos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertodos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(245, 245, 245)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vertodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vertodos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vertodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vertodos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelRsultadoBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        panelRsultadoBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        tableProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProducto);

        panelImagen.setBackground(new java.awt.Color(255, 255, 255));
        panelImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 180, 180), 1, true));

        imagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscaImagen.png"))); // NOI18N
        imagen.setToolTipText("Cargar foto de producto");
        imagen.setContentAreaFilled(false);
        imagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imagen.setPreferredSize(new java.awt.Dimension(107, 33));
        imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        vertodos2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vertodos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/limpiar.png"))); // NOI18N
        vertodos2.setText("Limpia Busqueda");
        vertodos2.setContentAreaFilled(false);
        vertodos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vertodos2.setPreferredSize(new java.awt.Dimension(119, 26));
        vertodos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertodos2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRsultadoBusquedaLayout = new javax.swing.GroupLayout(panelRsultadoBusqueda);
        panelRsultadoBusqueda.setLayout(panelRsultadoBusquedaLayout);
        panelRsultadoBusquedaLayout.setHorizontalGroup(
            panelRsultadoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRsultadoBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRsultadoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vertodos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelRsultadoBusquedaLayout.setVerticalGroup(
            panelRsultadoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRsultadoBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRsultadoBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addGroup(panelRsultadoBusquedaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vertodos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelCantidadResultados.setBackground(new java.awt.Color(255, 255, 255));
        panelCantidadResultados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        labelCount.setBackground(new java.awt.Color(53, 107, 161));
        labelCount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCount.setForeground(new java.awt.Color(53, 107, 161));
        labelCount.setText("Selecciona una categoría o un proveedor");

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
            .addComponent(panelRsultadoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCantidadResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void vertodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertodosActionPerformed
        // TODO add your handling code here:
        controller.busquedaTotal();
    }//GEN-LAST:event_vertodosActionPerformed

    private void idCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCategoriaActionPerformed
        // TODO add your handling code here:
        controller.buscaCategoria();
    }//GEN-LAST:event_idCategoriaActionPerformed

    private void idCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idCategoriaKeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyChar()==10)
//        controller.agregaModificaProducto();
    }//GEN-LAST:event_idCategoriaKeyPressed

    private void idProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProveedorActionPerformed
        // TODO add your handling code here:
        controller.buscaProveedor();
        
    }//GEN-LAST:event_idProveedorActionPerformed

    private void idProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProveedorKeyPressed

    private void vertodos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertodos1ActionPerformed
        // TODO add your handling code here:
        controllerPaneles.addPanel(controllerPaneles.getPanelCentral(),new ViewProducto(controllerPaneles,null,tipoAlmacen)); //asi
    }//GEN-LAST:event_vertodos1ActionPerformed

    private void imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagenActionPerformed

    private void vertodos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertodos2ActionPerformed
        // TODO add your handling code here:
        controller.limpiaBusqueda(imagen);
    }//GEN-LAST:event_vertodos2ActionPerformed

    private void tableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductoMouseClicked
        // TODO add your handling code here:
        controller.buscaImagenProducto(panelImagen,imagen);
    }//GEN-LAST:event_tableProductoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox idCategoria;
    private javax.swing.JComboBox idProveedor;
    private javax.swing.JButton imagen;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCount;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelCantidadResultados;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JPanel panelRsultadoBusqueda;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tableProducto;
    private javax.swing.JButton vertodos;
    private javax.swing.JButton vertodos1;
    private javax.swing.JButton vertodos2;
    // End of variables declaration//GEN-END:variables
}
