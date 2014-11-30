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
public class ViewAdministrarProductos extends javax.swing.JPanel {
    ControllerViewAdministrarClientes controller;
    ControllerValidation validation;
    ControllerPaneles controllerPaneles;
    ModelCliente modelCliente;
   
public ViewAdministrarProductos(ControllerPaneles controllerPaneles) {
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
        components.add(idProducto);
        components.add(nomProducto);
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
        idProducto = new javax.swing.JTextField();
        idProveedor = new javax.swing.JTextField();
        nomProducto = new javax.swing.JTextField();
        nomProveedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        buttonBuscaProducto = new javax.swing.JButton();
        buttonBuscaProveedor = new javax.swing.JButton();
        buttonVerTodos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/userInfo.png"))); // NOI18N
        jLabel1.setText("Administración de almacén");

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
        jLabel4.setText("ID producto:");
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 26));

        idProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idProducto.setForeground(new java.awt.Color(180, 180, 180));
        idProducto.setText("ID producto");
        idProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idProductoFocusLost(evt);
            }
        });
        idProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProductoActionPerformed(evt);
            }
        });
        idProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idProductoKeyPressed(evt);
            }
        });

        idProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idProveedor.setForeground(new java.awt.Color(180, 180, 180));
        idProveedor.setText("ID proveedor");
        idProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idProveedorFocusLost(evt);
            }
        });
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

        nomProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomProducto.setForeground(new java.awt.Color(180, 180, 180));
        nomProducto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nomProducto.setText("Nombre del producto");
        nomProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomProductoFocusLost(evt);
            }
        });
        nomProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomProductoActionPerformed(evt);
            }
        });
        nomProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomProductoKeyPressed(evt);
            }
        });

        nomProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomProveedor.setForeground(new java.awt.Color(180, 180, 180));
        nomProveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nomProveedor.setText("Nombre del proveedor");
        nomProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomProveedorFocusLost(evt);
            }
        });
        nomProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomProveedorActionPerformed(evt);
            }
        });
        nomProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomProveedorKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nombre:");
        jLabel5.setPreferredSize(new java.awt.Dimension(66, 26));

        buttonBuscaProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonBuscaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/findproducto.png"))); // NOI18N
        buttonBuscaProducto.setText("Busca producto");
        buttonBuscaProducto.setContentAreaFilled(false);
        buttonBuscaProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBuscaProducto.setPreferredSize(new java.awt.Dimension(119, 26));
        buttonBuscaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscaProductoActionPerformed(evt);
            }
        });

        buttonBuscaProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonBuscaProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/findUser.png"))); // NOI18N
        buttonBuscaProveedor.setText("Busca proveedor");
        buttonBuscaProveedor.setContentAreaFilled(false);
        buttonBuscaProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBuscaProveedor.setPreferredSize(new java.awt.Dimension(119, 26));
        buttonBuscaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscaProveedorActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ID proveedor:");
        jLabel6.setPreferredSize(new java.awt.Dimension(50, 26));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre:");
        jLabel7.setPreferredSize(new java.awt.Dimension(66, 26));

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBuscaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addComponent(idProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelCantidadResultados.setBackground(new java.awt.Color(255, 255, 255));
        panelCantidadResultados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 1, true));

        labelCount.setBackground(new java.awt.Color(53, 107, 161));
        labelCount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCount.setForeground(new java.awt.Color(53, 107, 161));
        labelCount.setText("Ingresa un ID y/o Nombre para iniciar la busqueda");

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
            .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        controllerPaneles.addPanel(controllerPaneles.getPanelCentral(), new ViewProducto(controllerPaneles,null,false)); //asi
    }//GEN-LAST:event_nuevoVendedorActionPerformed

    private void idProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idProductoFocusGained
        // TODO add your handling code here:
        validation.placeHolder(true, idProducto,"ID producto");
    }//GEN-LAST:event_idProductoFocusGained

    private void idProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idProductoFocusLost
        // TODO add your handling code here:
        validation.placeHolder(false, idProducto,"ID producto");
    }//GEN-LAST:event_idProductoFocusLost

    private void idProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProductoActionPerformed

    private void nomProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomProductoFocusGained
        // TODO add your handling code here:
        validation.placeHolder(true, nomProducto,"Nombre del producto");
    }//GEN-LAST:event_nomProductoFocusGained

    private void nomProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomProductoFocusLost
        // TODO add your handling code here:
        validation.placeHolder(false, nomProducto,"Nombre del producto");
    }//GEN-LAST:event_nomProductoFocusLost

    private void nomProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomProductoActionPerformed

    private void buttonBuscaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscaProductoActionPerformed
        // TODO add your handling code here:
        controller.buscaCliente(false);
    }//GEN-LAST:event_buttonBuscaProductoActionPerformed

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

    private void nomProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomProductoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==10)
            controller.buscaCliente(false);
    }//GEN-LAST:event_nomProductoKeyPressed

    private void idProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idProductoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()==10)
            controller.buscaCliente(false);
    }//GEN-LAST:event_idProductoKeyPressed

    private void idProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idProveedorFocusGained
        // TODO add your handling code here:
        validation.placeHolder(true, idProveedor,"ID proveedor");
    }//GEN-LAST:event_idProveedorFocusGained

    private void idProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idProveedorFocusLost
        // TODO add your handling code here:
        validation.placeHolder(false,idProveedor,"ID proveedor");
    }//GEN-LAST:event_idProveedorFocusLost

    private void idProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProveedorActionPerformed

    private void idProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProveedorKeyPressed

    private void nomProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomProveedorFocusGained
        // TODO add your handling code here:
        validation.placeHolder(true, nomProveedor,"Nombre del proveedor");
    }//GEN-LAST:event_nomProveedorFocusGained

    private void nomProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomProveedorFocusLost
        // TODO add your handling code here:
        validation.placeHolder(false, nomProveedor,"Nombre del proveedor");
    }//GEN-LAST:event_nomProveedorFocusLost

    private void nomProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomProveedorActionPerformed

    private void nomProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomProveedorKeyPressed

    private void buttonBuscaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscaProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonBuscaProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscaProducto;
    private javax.swing.JButton buttonBuscaProveedor;
    private javax.swing.JButton buttonVerTodos;
    private javax.swing.JButton eliminaVendedor;
    private javax.swing.JTextField idProducto;
    private javax.swing.JTextField idProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCount;
    private javax.swing.JButton limipaBusqueda;
    private javax.swing.JButton modificaVendedor;
    private javax.swing.JTextField nomProducto;
    private javax.swing.JTextField nomProveedor;
    private javax.swing.JButton nuevoVendedor;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelCantidadResultados;
    private javax.swing.JPanel panelRsultadoBusqueda;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
