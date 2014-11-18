/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPaneles;
import Controller.ControllerValidation;


/**
 *
 * @author Teté
 */
public class ViewCapInfoProveedor extends javax.swing.JPanel {
    ControllerPaneles controllerPaneles;
    ControllerValidation validation;
   

    /**
     * Creates new form ViewCapInfoProveedor
     */
    public ViewCapInfoProveedor() {
        validation = new ControllerValidation();
        //this.controllerPaneles = controllerPaneles;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        panelInformacion = new javax.swing.JPanel();
        labelBuscarPor = new javax.swing.JLabel();
        nameProveedor = new javax.swing.JTextField();
        labelNombreProveedor = new javax.swing.JLabel();
        labelNota = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        marcaProv = new javax.swing.JTextField();
        empresaProv = new javax.swing.JTextField();
        labelEmpresa = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        iDProv = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        labelConfiguracion = new javax.swing.JLabel();
        labelRelacionProveedor = new javax.swing.JLabel();
        nuevoProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        labelProveedores = new javax.swing.JLabel();
        editarProveedor = new javax.swing.JButton();
        eliminarProveedor = new javax.swing.JButton();

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("E-mail:");

        setBackground(new java.awt.Color(245, 246, 247));
        setForeground(new java.awt.Color(0, 102, 51));

        panelInformacion.setBackground(new java.awt.Color(255, 255, 255));

        labelBuscarPor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBuscarPor.setForeground(new java.awt.Color(66, 139, 202));
        labelBuscarPor.setText("Buscar por:");

        nameProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameProveedor.setForeground(new java.awt.Color(180, 180, 180));
        nameProveedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nameProveedor.setText("Nombre ");
        nameProveedor.setPreferredSize(new java.awt.Dimension(170, 26));
        nameProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameProveedorActionPerformed(evt);
            }
        });
        nameProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameProveedorFocusLost(evt);
            }
        });
        nameProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameProveedorKeyPressed(evt);
            }
        });

        labelNombreProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNombreProveedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNombreProveedor.setText("Nombre:");

        labelNota.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelNota.setForeground(new java.awt.Color(66, 139, 202));
        labelNota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNota.setText("Nota: Campos para empezar la búsqueda.");

        labelMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMarca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMarca.setText("Marca :");

        marcaProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        marcaProv.setForeground(new java.awt.Color(180, 180, 180));
        marcaProv.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        marcaProv.setText("Marca ");
        marcaProv.setPreferredSize(new java.awt.Dimension(60, 26));
        marcaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaProvActionPerformed(evt);
            }
        });
        marcaProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                marcaProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                marcaProvFocusLost(evt);
            }
        });
        marcaProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                marcaProvKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaProvKeyTyped(evt);
            }
        });

        empresaProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empresaProv.setForeground(new java.awt.Color(180, 180, 180));
        empresaProv.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        empresaProv.setText("Empresa");
        empresaProv.setPreferredSize(new java.awt.Dimension(60, 26));
        empresaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresaProvActionPerformed(evt);
            }
        });
        empresaProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                empresaProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                empresaProvFocusLost(evt);
            }
        });
        empresaProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                empresaProvKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empresaProvKeyTyped(evt);
            }
        });

        labelEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEmpresa.setText("Empresa:");

        labelID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelID.setText("Código de Proveedor:");

        iDProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        iDProv.setForeground(new java.awt.Color(180, 180, 180));
        iDProv.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        iDProv.setText("ID");
        iDProv.setPreferredSize(new java.awt.Dimension(60, 26));
        iDProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iDProvActionPerformed(evt);
            }
        });
        iDProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                iDProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                iDProvFocusLost(evt);
            }
        });
        iDProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iDProvKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                iDProvKeyTyped(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(66, 139, 202));
        buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(52, 73, 94));
        buscar.setText("Buscar");
        buscar.setContentAreaFilled(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscar.setSelected(true);

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(labelBuscarPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelNota, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empresaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelID)
                            .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iDProv, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marcaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscarPor)
                    .addComponent(labelNota))
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marcaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empresaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iDProv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelConfiguracion.setBackground(new java.awt.Color(250, 250, 250));
        labelConfiguracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ajustesInfo.png"))); // NOI18N
        labelConfiguracion.setText("Configuración de información de la tienda");

        labelRelacionProveedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelRelacionProveedor.setForeground(new java.awt.Color(66, 139, 202));
        labelRelacionProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRelacionProveedor.setText("Relación de proveedores");

        nuevoProveedor.setBackground(new java.awt.Color(66, 139, 202));
        nuevoProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nuevoProveedor.setForeground(new java.awt.Color(52, 73, 94));
        nuevoProveedor.setText("Nuevo Proveedor");
        nuevoProveedor.setContentAreaFilled(false);
        nuevoProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nuevoProveedor.setSelected(true);
        nuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProveedorActionPerformed(evt);
            }
        });

        tablaProveedores.setAutoCreateRowSorter(true);
        tablaProveedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Marca", "Teléfono Fijo", "Teléfono Celular", "E-Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);

        labelProveedores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelProveedores.setForeground(new java.awt.Color(66, 139, 202));
        labelProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProveedores.setText("Proveedores");

        editarProveedor.setBackground(new java.awt.Color(66, 139, 202));
        editarProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editarProveedor.setForeground(new java.awt.Color(52, 73, 94));
        editarProveedor.setText("Editar Proveedor");
        editarProveedor.setContentAreaFilled(false);
        editarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        editarProveedor.setSelected(true);

        eliminarProveedor.setBackground(new java.awt.Color(66, 139, 202));
        eliminarProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eliminarProveedor.setForeground(new java.awt.Color(52, 73, 94));
        eliminarProveedor.setText("Eliminar Proveedor");
        eliminarProveedor.setContentAreaFilled(false);
        eliminarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminarProveedor.setSelected(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelRelacionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(editarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(labelProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConfiguracion)
                .addGap(50, 50, 50)
                .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(labelRelacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoProveedor)
                    .addComponent(editarProveedor)
                    .addComponent(eliminarProveedor))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(labelProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(532, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameProveedorFocusGained
        validation.placeHolder(true,nameProveedor,"Nombre de la empresa (*)");
    }//GEN-LAST:event_nameProveedorFocusGained

    private void nameProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameProveedorFocusLost
        validation.placeHolder(false ,nameProveedor,"Nombre de la empresa (*)");
    }//GEN-LAST:event_nameProveedorFocusLost

    private void nameProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameProveedorActionPerformed

    private void nameProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameProveedorKeyPressed
        // TODO add your handling code here:
        //        if(evt.getKeyChar()==10)
        //            next();
    }//GEN-LAST:event_nameProveedorKeyPressed

    private void marcaProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaProvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaProvFocusGained

    private void marcaProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaProvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaProvFocusLost

    private void marcaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaProvActionPerformed

    private void marcaProvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaProvKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaProvKeyPressed

    private void marcaProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaProvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaProvKeyTyped

    private void empresaProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_empresaProvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_empresaProvFocusGained

    private void empresaProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_empresaProvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_empresaProvFocusLost

    private void empresaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresaProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empresaProvActionPerformed

    private void empresaProvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empresaProvKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_empresaProvKeyPressed

    private void empresaProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empresaProvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_empresaProvKeyTyped

    private void iDProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iDProvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_iDProvFocusGained

    private void iDProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iDProvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_iDProvFocusLost

    private void iDProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iDProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iDProvActionPerformed

    private void iDProvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iDProvKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_iDProvKeyPressed

    private void iDProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iDProvKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_iDProvKeyTyped

    private void nuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton editarProveedor;
    private javax.swing.JButton eliminarProveedor;
    private javax.swing.JTextField empresaProv;
    private javax.swing.JTextField iDProv;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscarPor;
    private javax.swing.JLabel labelConfiguracion;
    private javax.swing.JLabel labelEmpresa;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNombreProveedor;
    private javax.swing.JLabel labelNota;
    private javax.swing.JLabel labelProveedores;
    private javax.swing.JLabel labelRelacionProveedor;
    private javax.swing.JTextField marcaProv;
    private javax.swing.JTextField nameProveedor;
    private javax.swing.JButton nuevoProveedor;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JTable tablaProveedores;
    // End of variables declaration//GEN-END:variables
}
