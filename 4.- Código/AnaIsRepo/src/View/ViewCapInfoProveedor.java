/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Teté
 */
public class ViewCapInfoProveedor extends javax.swing.JPanel {

    /**
     * Creates new form ViewCapInfoProveedor
     */
    public ViewCapInfoProveedor() {
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

        labelPrincProvee = new javax.swing.JLabel();
        labelCodProv = new javax.swing.JLabel();
        codProv = new javax.swing.JTextField();
        labelNomProv = new javax.swing.JLabel();
        nomProv = new javax.swing.JTextField();
        labelCiudProv = new javax.swing.JLabel();
        ciudadProv = new javax.swing.JTextField();
        labelRelProv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelCP = new javax.swing.JLabel();
        codigoPostal = new javax.swing.JTextField();
        labelTelProv = new javax.swing.JLabel();
        telProv = new javax.swing.JTextField();
        labelProvEnc = new javax.swing.JLabel();
        encontrados = new javax.swing.JTextField();
        botonBuscProv = new javax.swing.JButton();
        botonImpProv = new javax.swing.JButton();
        botonLimProv = new javax.swing.JButton();
        botonNuevProv = new javax.swing.JButton();
        botonRelProv = new javax.swing.JButton();
        botonEditarProv = new javax.swing.JButton();

        setForeground(new java.awt.Color(0, 102, 51));

        labelPrincProvee.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincProvee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrincProvee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrincProvee.setText("Buscar Proveedor");
        labelPrincProvee.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelCodProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCodProv.setText("Código de Proveedor");

        codProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codProv.setForeground(new java.awt.Color(204, 204, 255));
        codProv.setText("Cod. Prov.");
        codProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codProvActionPerformed(evt);
            }
        });
        codProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codProvFocusLost(evt);
            }
        });

        labelNomProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNomProv.setText("Nombre");

        nomProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomProv.setForeground(new java.awt.Color(204, 204, 255));
        nomProv.setText("Nombre.");
        nomProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomProvActionPerformed(evt);
            }
        });
        nomProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomProvFocusLost(evt);
            }
        });

        labelCiudProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCiudProv.setText("Cuidad");

        ciudadProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ciudadProv.setForeground(new java.awt.Color(204, 204, 255));
        ciudadProv.setText("Ciudad.");
        ciudadProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadProvActionPerformed(evt);
            }
        });
        ciudadProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ciudadProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ciudadProvFocusLost(evt);
            }
        });

        labelRelProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRelProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRelProv.setText("Relación de Proveedores");
        labelRelProv.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Marca", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        labelCP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCP.setText("Código Postal");

        codigoPostal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codigoPostal.setForeground(new java.awt.Color(204, 204, 255));
        codigoPostal.setText("Código Postal.");
        codigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoPostalActionPerformed(evt);
            }
        });
        codigoPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codigoPostalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoPostalFocusLost(evt);
            }
        });

        labelTelProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelProv.setText("Télefono");

        telProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telProv.setForeground(new java.awt.Color(204, 204, 255));
        telProv.setText("Cel/Fijo");
        telProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telProvActionPerformed(evt);
            }
        });
        telProv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telProvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telProvFocusLost(evt);
            }
        });

        labelProvEnc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelProvEnc.setText("No. de proveedores encontrados.");

        encontrados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        botonBuscProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonBuscProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/zoom.png"))); // NOI18N
        botonBuscProv.setText("Buscar");

        botonImpProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonImpProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        botonImpProv.setText("Imprimir");

        botonLimProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonLimProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trash.png"))); // NOI18N
        botonLimProv.setText("Limpiar");

        botonNuevProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonNuevProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user-add.png"))); // NOI18N
        botonNuevProv.setText("Nuevo Proveedor");

        botonRelProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/group.png"))); // NOI18N

        botonEditarProv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonEditarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        botonEditarProv.setText("Editar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrincProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodProv)
                            .addComponent(labelNomProv)
                            .addComponent(labelCiudProv)
                            .addComponent(labelCP)
                            .addComponent(labelTelProv))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codProv, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonRelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomProv, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(ciudadProv)
                            .addComponent(telProv)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonBuscProv)
                        .addGap(73, 73, 73)
                        .addComponent(botonLimProv)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(labelRelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelProvEnc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(encontrados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonEditarProv)))
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonNuevProv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonImpProv)
                                .addGap(66, 66, 66))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRelProv, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPrincProvee))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodProv)
                            .addComponent(codProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonRelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomProv)
                            .addComponent(nomProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCiudProv)
                            .addComponent(ciudadProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCP)
                            .addComponent(codigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTelProv)
                            .addComponent(telProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelProvEnc)
                            .addComponent(encontrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEditarProv))))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonImpProv)
                    .addComponent(botonNuevProv)
                    .addComponent(botonBuscProv)
                    .addComponent(botonLimProv))
                .addContainerGap(155, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void codProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codProvActionPerformed

    private void codProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codProvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_codProvFocusGained

    private void codProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codProvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codProvFocusLost

    private void nomProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomProvActionPerformed

    private void nomProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomProvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nomProvFocusGained

    private void nomProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomProvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_nomProvFocusLost

    private void ciudadProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadProvActionPerformed

    private void ciudadProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ciudadProvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadProvFocusGained

    private void ciudadProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ciudadProvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadProvFocusLost

    private void codigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoPostalActionPerformed

    private void codigoPostalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoPostalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoPostalFocusGained

    private void codigoPostalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoPostalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoPostalFocusLost

    private void telProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telProvActionPerformed

    private void telProvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telProvFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_telProvFocusGained

    private void telProvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telProvFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_telProvFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscProv;
    private javax.swing.JButton botonEditarProv;
    private javax.swing.JButton botonImpProv;
    private javax.swing.JButton botonLimProv;
    private javax.swing.JButton botonNuevProv;
    private javax.swing.JButton botonRelProv;
    private javax.swing.JTextField ciudadProv;
    private javax.swing.JTextField codProv;
    private javax.swing.JTextField codigoPostal;
    private javax.swing.JTextField encontrados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCP;
    private javax.swing.JLabel labelCiudProv;
    private javax.swing.JLabel labelCodProv;
    private javax.swing.JLabel labelNomProv;
    private javax.swing.JLabel labelPrincProvee;
    private javax.swing.JLabel labelProvEnc;
    private javax.swing.JLabel labelRelProv;
    private javax.swing.JLabel labelTelProv;
    private javax.swing.JTextField nomProv;
    private javax.swing.JTextField telProv;
    // End of variables declaration//GEN-END:variables
}
