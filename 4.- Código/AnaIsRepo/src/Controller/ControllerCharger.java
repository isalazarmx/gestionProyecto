package Controller;

import Model.ModelEmpresa;
import Model.ModelUsuario;
import View.ViewAdminsitrador;
import View.ViewCaptInfoBussines;
import View.ViewCaptInfoUser;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import View.ViewLoading;
import View.ViewInitSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Salazar
 */
public class ControllerCharger extends Thread {
    private final JFrame principalFrame;
    private final JLabel labelStatus;
    private final JPanel panelBase;
    private final JPanel viewLoading;
    private final ModelEmpresa modelEmpresa;
    private final ModelUsuario modelUsuario;
    private int auxiliar;

    /**
     *
     * @param principalFrame
     * @param labelStatus
     * @param panelBase
     */
    public ControllerCharger(JFrame principalFrame, JLabel labelStatus, JPanel panelBase) {
        this.principalFrame = principalFrame;
        this.labelStatus = labelStatus;
        this.panelBase = panelBase;
        this.viewLoading = new ViewLoading();
        this.modelEmpresa = new ModelEmpresa();
        this.modelUsuario = new ModelUsuario();
    }

    @Override
    public void run() {
        setAuxiliar(-1);
        while (true) {
            setAuxiliar(getAuxiliar() + 1);
            try {
                switch (getAuxiliar()) {
                    case 0:
                        iniciaComponentes();
                        break;
                    case 1:
                        this.labelStatus.setText("Cargando módulos");
                        break;
                    case 2:
                        this.labelStatus.setText("Cargando gráficos");
                        break;
                    case 3:
                        testConexion();
                        break;
                    case 4:
                        findDatBussines();
                        break;
                    case 5:
                        findUser();
                        break;
                    case 6:
                        initLogin();
                        break;
                    case 7:
                        identificaPrivilegiosUsuario();
                        break;
                }
                Thread.sleep(1000);
                System.out.println("hilo Ejecutando");
            } catch (InterruptedException e) {
            }
        }
    }

    private void iniciaComponentes() {
        panelBase.setLayout(new GridBagLayout());
        panelBase.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelBase.setVisible(true);
        lanzarPantalla(viewLoading, "Cargando . . .",false);
    }

    private void testConexion() throws InterruptedException {
        this.labelStatus.setText("Realizando test de conexión");
        principalFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        ControllerConnDBMS conn = new ControllerConnDBMS();
        String test = conn.testConn();
        conn.closeConect();
        if (!"".equals(test)) {
            panelBase.setVisible(false);
            String aux = "";
            switch (test) {
                case "08S01":
                    aux = "La comunicación con el servidor falló";
                    break;
                case "28000":
                    aux = "Usuario y/o contraseña incorrectos";
                    break;
                default:
                    aux = "Error desconocido #" + test;
                    break;
            }
            labelStatus.setText(aux);
            Thread.sleep(4000);
            System.exit(0);
        }
    }

    private void findDatBussines() {
        lanzarPantalla(viewLoading, "Buscando datos de la empresa",false);
        principalFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if (ControllerConsults.findInfoBussines(modelEmpresa).getIdEmpresa() != 0)
            lanzarPantalla(viewLoading, "Verificando usuarios", false);
        else {
            ViewCaptInfoBussines viewCapInfoBussines = new ViewCaptInfoBussines(labelStatus,this,modelEmpresa);
            lanzarPantalla(viewCapInfoBussines, "Datos de la empresa",true);
            try {
                panelBase.setVisible(false);
                Thread.sleep(1000);
                panelBase.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerCharger.class.getName()).log(Level.SEVERE, null, ex);
            }
            findDatBussines();
        }
    }
    
    private void findUser() {
        lanzarPantalla(viewLoading, "Verificando usuario",false);
        principalFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if (ControllerConsults.findUser(modelUsuario).getTipo() != 0)
            lanzarPantalla(viewLoading, "Iniciando pantalla", false);
        else {
            JPanel viewCapInfoUser = new ViewCaptInfoUser(labelStatus,this,modelEmpresa.getIdEmpresa(),modelUsuario);
            lanzarPantalla(viewCapInfoUser, "Datos de usuario administrador",true);
            try {
                panelBase.setVisible(false);
                Thread.sleep(1000);
                panelBase.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerCharger.class.getName()).log(Level.SEVERE, null, ex);
            }
            findUser();
        }
    }

    private void initLogin(){
        JPanel viewInitSession = new ViewInitSession(labelStatus,this,modelUsuario);
        lanzarPantalla(viewInitSession, "Bienvenido",true);
        lanzarPantalla(viewLoading, "Buscando permisos de usuario",false);
    }

    private void identificaPrivilegiosUsuario(){
        if(modelUsuario.getTipo() == 3){
            principalFrame.dispose();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ViewAdminsitrador(modelEmpresa, modelUsuario).setVisible(true);
                }
            });
            System.out.println("Matar Hilo");
            this.interrupt();
            this.suspend();
            this.stop();  
        }else{
        
        }
    }
    
    private void lanzarPantalla(JPanel panel, String mensaje, boolean flag) {
        principalFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelBase.removeAll();
        panelBase.add(panel);
        panelBase.updateUI();
        labelStatus.setForeground(new Color(0, 0, 0));
        labelStatus.setText(mensaje);
        if (flag) {
            System.out.println("Hilo se detuvo");
            super.suspend();
        }
    }

    /**
     * @return the auxiliar
     */
    public int getAuxiliar() {
        return auxiliar;
    }

    /**
     * @param auxiliar the auxiliar to set
     */
    public void setAuxiliar(int auxiliar) {
        this.auxiliar = auxiliar;
    }
}
