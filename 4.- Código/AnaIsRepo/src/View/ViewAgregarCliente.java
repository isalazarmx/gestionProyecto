/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.ControllerValidation;

/**
 *
 * @author Carolina
 */
public class ViewAgregarCliente extends javax.swing.JPanel {
    ControllerValidation validation;

    /**
     * Creates new form ViewAgregarCliente
     */
    public ViewAgregarCliente() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        acNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        acApellidoPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        acApellidoMaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        acRFC = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        acTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        acTelCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        acEmail = new javax.swing.JTextField();
        acIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        acCalle = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        acNoExt = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        acNoInt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        acColonia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        acCiudad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        acCP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Agregar Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre: ");

        acNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acNombre.setForeground(new java.awt.Color(180, 180, 180));
        acNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acNombre.setText("Nombre");
        acNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acNombreFocusLost(evt);
            }
        });
        acNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acNombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Apellido Paterno:");

        acApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acApellidoPaterno.setForeground(new java.awt.Color(180, 180, 180));
        acApellidoPaterno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acApellidoPaterno.setText("Apellido Paterno");
        acApellidoPaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acApellidoPaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acApellidoPaternoFocusLost(evt);
            }
        });
        acApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acApellidoPaternoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Apellido Materno:");

        acApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acApellidoMaterno.setForeground(new java.awt.Color(180, 180, 180));
        acApellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acApellidoMaterno.setText("Apellido Materno");
        acApellidoMaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acApellidoMaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acApellidoMaternoFocusLost(evt);
            }
        });
        acApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acApellidoMaternoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("RFC:");

        acRFC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acRFC.setForeground(new java.awt.Color(180, 180, 180));
        acRFC.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acRFC.setText("RFC");
        acRFC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acRFCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acRFCFocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Email:");

        acTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acTelefono.setForeground(new java.awt.Color(180, 180, 180));
        acTelefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acTelefono.setText("xx-xxx-xxxxxxx");
        acTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acTelefonoFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Teléfono:");

        acTelCelular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acTelCelular.setForeground(new java.awt.Color(180, 180, 180));
        acTelCelular.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acTelCelular.setText("xx-xxx-xxxxxxx");
        acTelCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acTelCelularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acTelCelularFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tel. Celular:");

        acEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acEmail.setForeground(new java.awt.Color(180, 180, 180));
        acEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acEmail.setText("cliente@reposteria.com");
        acEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acEmailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(acTelCelular)
                            .addComponent(acEmail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(acTelefono)
                            .addComponent(acNombre)
                            .addComponent(acApellidoPaterno)
                            .addComponent(acApellidoMaterno)
                            .addComponent(acRFC))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(acNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(acRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        acIdCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acIdCliente.setForeground(new java.awt.Color(180, 180, 180));
        acIdCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acIdCliente.setText("Id Cliente");
        acIdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acIdClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acIdClienteFocusLost(evt);
            }
        });
        acIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acIdClienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Id Cliente");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Calle:");

        acCalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acCalle.setForeground(new java.awt.Color(180, 180, 180));
        acCalle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acCalle.setText("Calle");
        acCalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acCalleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acCalleFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("No. Ext:");

        acNoExt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acNoExt.setForeground(new java.awt.Color(180, 180, 180));
        acNoExt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acNoExt.setText("No. Ext.");
        acNoExt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acNoExtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acNoExtFocusLost(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox1.setText("No. Int:");

        acNoInt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acNoInt.setForeground(new java.awt.Color(180, 180, 180));
        acNoInt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acNoInt.setText("No. Int");
        acNoInt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acNoIntFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acNoIntFocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Colonia:");

        acColonia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acColonia.setForeground(new java.awt.Color(180, 180, 180));
        acColonia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acColonia.setText("Colonia");
        acColonia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acColoniaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acColoniaFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Ciudad:");

        acCiudad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acCiudad.setForeground(new java.awt.Color(180, 180, 180));
        acCiudad.setText("Ciudad");
        acCiudad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acCiudadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acCiudadFocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("C.P:");

        acCP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acCP.setForeground(new java.awt.Color(180, 180, 180));
        acCP.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        acCP.setText("xxxxx");
        acCP.setToolTipText("");
        acCP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acCPFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(acCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(acCP, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(acColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(acNoExt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(acNoInt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(21, 21, 21)
                        .addComponent(acCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(acCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(acNoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(acNoInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(acColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(acCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(acCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tick-outline.png"))); // NOI18N
        jButton1.setText("Aceptar");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/times-outline.png"))); // NOI18N
        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(acIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(acIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acIdClienteActionPerformed

    private void acIdClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acIdClienteFocusGained
        validation.placeHolder(true,acIdCliente,"Id Cliente"); // TODO add your handling code here:
    }//GEN-LAST:event_acIdClienteFocusGained

    private void acNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acNombreActionPerformed

    private void acIdClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acIdClienteFocusLost
        validation.placeHolder(false,acIdCliente,"Id Cliente");// TODO add your handling code here:
    }//GEN-LAST:event_acIdClienteFocusLost

    private void acNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acNombreFocusGained
        validation.placeHolder(true,acNombre,"Nombre");        // TODO add your handling code here:
    }//GEN-LAST:event_acNombreFocusGained

    private void acNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acNombreFocusLost
        validation.placeHolder(false,acNombre,"Nombre");         // TODO add your handling code here:
    }//GEN-LAST:event_acNombreFocusLost

    private void acApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acApellidoPaternoActionPerformed

    private void acApellidoPaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acApellidoPaternoFocusGained
        validation.placeHolder(true,acApellidoPaterno,"Apellido Paterno");        // TODO add your handling code here:
    }//GEN-LAST:event_acApellidoPaternoFocusGained

    private void acApellidoPaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acApellidoPaternoFocusLost
       validation.placeHolder(false, acApellidoPaterno,"Apellido Paterno"); // TODO add your handling code here:
    }//GEN-LAST:event_acApellidoPaternoFocusLost

    private void acApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acApellidoMaternoActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_acApellidoMaternoActionPerformed

    private void acApellidoMaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acApellidoMaternoFocusGained
        validation.placeHolder(true,acApellidoMaterno,"Apellido Materno");        // TODO add your handling code here:
    }//GEN-LAST:event_acApellidoMaternoFocusGained

    private void acApellidoMaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acApellidoMaternoFocusLost
        validation.placeHolder(false,acApellidoMaterno,"Apellido Materno");        // TODO add your handling code here:
    }//GEN-LAST:event_acApellidoMaternoFocusLost

    private void acRFCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acRFCFocusGained
        validation.placeHolder(true,acRFC,"RFC");        // TODO add your handling code here:
    }//GEN-LAST:event_acRFCFocusGained

    private void acRFCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acRFCFocusLost
        validation.placeHolder(false,acRFC,"RFC");        // TODO add your handling code here:
    }//GEN-LAST:event_acRFCFocusLost

    private void acTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acTelefonoFocusGained
        validation.placeHolder(true,acTelefono,"Telefono");        // TODO add your handling code here:
    }//GEN-LAST:event_acTelefonoFocusGained

    private void acTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acTelefonoFocusLost
        validation.placeHolder(false,acTelefono,"Telefono");        // TODO add your handling code here:
    }//GEN-LAST:event_acTelefonoFocusLost

    private void acTelCelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acTelCelularFocusGained
        validation.placeHolder(true,acTelCelular,"Tel. Celular");        // TODO add your handling code here:
    }//GEN-LAST:event_acTelCelularFocusGained

    private void acTelCelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acTelCelularFocusLost
        validation.placeHolder(false,acTelCelular,"Tel. Celular");        // TODO add your handling code here:
    }//GEN-LAST:event_acTelCelularFocusLost

    private void acEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acEmailFocusGained
        validation.placeHolder(true,acEmail,"Email");        // TODO add your handling code here:
    }//GEN-LAST:event_acEmailFocusGained

    private void acEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acEmailFocusLost
        validation.placeHolder(false,acEmail,"Email");        // TODO add your handling code here:
    }//GEN-LAST:event_acEmailFocusLost

    private void acCalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acCalleFocusGained
        validation.placeHolder(true,acCalle,"Calle");        // TODO add your handling code here:
    }//GEN-LAST:event_acCalleFocusGained

    private void acCalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acCalleFocusLost
        validation.placeHolder(false,acCalle,"Calle");        // TODO add your handling code here:
    }//GEN-LAST:event_acCalleFocusLost

    private void acNoExtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acNoExtFocusGained
        validation.placeHolder(true,acNoExt,"No. Ext");        // TODO add your handling code here:
    }//GEN-LAST:event_acNoExtFocusGained

    private void acNoExtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acNoExtFocusLost
        validation.placeHolder(false,acNoExt,"No. Ext");        // TODO add your handling code here:
    }//GEN-LAST:event_acNoExtFocusLost

    private void acNoIntFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acNoIntFocusGained
        validation.placeHolder(true,acNoInt,"No. Int");       // TODO add your handling code here:
    }//GEN-LAST:event_acNoIntFocusGained

    private void acNoIntFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acNoIntFocusLost
        validation.placeHolder(false,acNoInt,"No. Int");        // TODO add your handling code here:
    }//GEN-LAST:event_acNoIntFocusLost

    private void acColoniaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acColoniaFocusGained
        validation.placeHolder(true,acColonia,"Colonia");        // TODO add your handling code here:
    }//GEN-LAST:event_acColoniaFocusGained

    private void acColoniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acColoniaFocusLost
        validation.placeHolder(false,acColonia,"Colonia");        // TODO add your handling code here:
    }//GEN-LAST:event_acColoniaFocusLost

    private void acCiudadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acCiudadFocusGained
        validation.placeHolder(true,acCiudad,"Ciudad");        // TODO add your handling code here:
    }//GEN-LAST:event_acCiudadFocusGained

    private void acCiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acCiudadFocusLost
        validation.placeHolder(false,acCiudad,"Ciudad");        // TODO add your handling code here:
    }//GEN-LAST:event_acCiudadFocusLost

    private void acCPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acCPFocusGained
        validation.placeHolder(true,acCP,"CP");        // TODO add your handling code here:
    }//GEN-LAST:event_acCPFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acApellidoMaterno;
    private javax.swing.JTextField acApellidoPaterno;
    private javax.swing.JTextField acCP;
    private javax.swing.JTextField acCalle;
    private javax.swing.JTextField acCiudad;
    private javax.swing.JTextField acColonia;
    private javax.swing.JTextField acEmail;
    private javax.swing.JTextField acIdCliente;
    private javax.swing.JTextField acNoExt;
    private javax.swing.JTextField acNoInt;
    private javax.swing.JTextField acNombre;
    private javax.swing.JTextField acRFC;
    private javax.swing.JTextField acTelCelular;
    private javax.swing.JTextField acTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
