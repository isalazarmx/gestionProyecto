/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Validacion.java
 *
 */
public class ControllerValidation {

    /**
     * Valida la caja de texto para que solamente pueda contener caracteres
     * alfabeticos, esto lo hace por cada caracter que se teclea en la caja.
     *
     * @param COMPONENTE La caja de texto a validar.
     */
    public static void soloTexto(final JTextField COMPONENTE) {
        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                final char CARACTER = e.getKeyChar();
                if (!Character.isSpaceChar(CARACTER) && !Character.isLetter(CARACTER) && CARACTER != 'ñ') {
                    e.consume();
                    ControllerViewMsj.muestraMensajeGlobo("Solo se permiten letras en este campo.", COMPONENTE);
                }
            }
        });
    }

    /**
     * Valida la caja de texto para que solamente pueda contener caracteres
     * numéricos, esto lo hace por cada caracter que se teclea en la caja.
     *
     * @param COMPONENTE La caja de texto a validar.
     */
    public static void soloNumeros(final JTextField COMPONENTE) {
        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                final char CARACTER = e.getKeyChar();
                if (CARACTER < '0' || CARACTER > '9') {
                    e.consume();
                    ControllerViewMsj.muestraMensajeGlobo("Solo se permiten números en este campo.", COMPONENTE);
                }
            }
        });
    }

    /**
     * Valida la caja de texto para que solamente pueda contener un número
     * determinado de caracteres, esto lo hace por cada caracter que se teclea
     * en la caja.
     *
     * @param COMPONENTE La caja de texto a validar.
     * @param LIMITE Limite máximo de caracteres en la caja de texto.
     */
    public static void limitarCaracteres(final JTextField COMPONENTE, final int LIMITE) {
        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (COMPONENTE.getText().length() > LIMITE - 1) {
                    e.consume();
                    ControllerViewMsj.muestraMensajeGlobo("Tamanio máximo de caracteres alcanzado (" + LIMITE + ")", COMPONENTE);
                }
            }
        });
    }

    /**
     * Valida la caja de contrasenia para que solamente pueda contener un número
     * determinado de caracteres, esto lo hace por cada caracter que se teclea
     * en la caja.
     *
     * @param COMPONENTE La caja de texto a validar.
     * @param LIMITE Limite máximo de caracteres en la caja de texto.
     */
    public static void limitarCaracteres(final JPasswordField COMPONENTE, final int LIMITE) {
        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (String.valueOf(COMPONENTE.getPassword()).length() > LIMITE - 1) {
                    e.consume();
                    ControllerViewMsj.muestraMensajeGlobo("Tamanio máximo de caracteres alcanzado (" + LIMITE + ")", COMPONENTE);
                }
            }
        });
    }

    /**
     * Valida la caja de contrasenia para que solamente pueda contener un número
     * determinado de caracteres, esto lo hace por cada caracter que se teclea
     * en la caja.
     *
     * @param COMPONENTE La caja de texto a validar.
     * @param LIMITE Limite máximo de caracteres en la caja de texto.
     */
    public static void limitarCaracteres(final JTextArea COMPONENTE, final int LIMITE) {
        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (COMPONENTE.getText().length() > LIMITE - 1) {
                    e.consume();
                    ControllerViewMsj.muestraMensajeGlobo("Tamanio máximo de caracteres alcanzado (" + LIMITE + ")", COMPONENTE);
                }
            }
        });
    }

    /**
     * Valida el componente para que no pueda ser editado manualmente, esto lo
     * hace por cada caracter que se teclea en el componente.
     *
     * @param COMPONENTE El COMPONENTE a validar.
     */
    public static void deshabilitar(final JComponent COMPONENTE) {
        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
                ControllerViewMsj.muestraMensajeGlobo("No se permite modificar este campo.", COMPONENTE);
            }
        });
    }

    /**
     * Valida que una cadena sea una fecha correcta en base a un formato
     * definido.
     *
     * @param FECHA Cadena que se validará.
     * @param DATE_FORMAT Formato que se usará para validar la fecha.
     * @return True si la fecha es valida, de lo contrario False.
     */
    public static boolean validarFecha(final String FECHA, final String DATE_FORMAT) {
        if (FECHA == null) {
            return false;
        }
        final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat(DATE_FORMAT);
        FORMATO_FECHA.setLenient(false);
        try {
            final Date DATE = FORMATO_FECHA.parse(FECHA);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     *
     * @param cajas
     * @return
     */
    public static boolean validarCamposObligatorios(JTextField[] cajas, String[] texto) {
        boolean[] valores = new boolean[cajas.length];
        final String[] DATOS = new String[valores.length];
        if (cajas.length > 0) {
            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i].getText().equals("")) {
                    valores[i] = false;
                } else {
                    valores[i] = true;
                }
            }
            //Todos Positivos???
            boolean todosPos = true;
            String error = "Error en ";
            for (int i = 0; i < valores.length; i++) {
                if (!valores[i]) {
                    todosPos = false;

                    error = error + texto[i] + ",";
                }
            }
            if (todosPos) {
                for (int i = 0; i < valores.length; i++) {
                    DATOS[i] = cajas[i].getText();
                }
            } else {
                JOptionPane.showMessageDialog(null, error, "Campos Vacios", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Vector de Cajas vacio");
            valores = null;
        }
        boolean aprobado = true;
        for (int i = 0; i < DATOS.length; i++) {
            if (DATOS[i] == null) {
                aprobado = false;
                continue;
            }

        }
        return aprobado;
    }

    /**
     * Valida que dos contrasenias sea iguales.
     *
     * @param PASSWORD1 JPasswordField a comparar.
     * @param PASSWORD2 JPasswordField a comparar.
     * @return True si las dos contrasenias coinciden, de lo contrario False.
     */
    public static boolean validarContrasenias(final JPasswordField PASSWORD1, final JPasswordField PASSWORD2) {
        boolean status = false;
        final String PWD1 = String.valueOf(PASSWORD1.getPassword());
        final String PWD2 = String.valueOf(PASSWORD2.getPassword());
        if (PWD2.equals(PWD1)) {
            status = true;
        } else {
            ControllerViewMsj.muestraMensajeGlobo("Las contraseñas no coinciden.", PASSWORD2);
        }
        return status;
    }

    /**
     * Metodo que valida una sola caja de texto y se asegura de que tenga datos.
     *
     * @param caja La caja de texto a validar.
     * @param referencia El nombre del campo.
     * @return False si la caja esta vacia, true de lo contrario.
     */
    public static boolean camposNoNulos(JTextField caja, String referencia) {
        boolean status = false;
        if (!caja.getText().equals("")) {
            status = true;
        } else {
            JOptionPane.showMessageDialog(null, " \nNo pueden quedar campos vacíos.\nRevise los valores e intentelo de nuevo.", referencia, JOptionPane.ERROR_MESSAGE);
        }
        return status;
    }

    /**
     * Verifica que una cadena sea un valor numerico.
     *
     * @param cadena La cadena a analizar.
     * @return True si la cadena representa un valor numerico, false de lo
     * contrario.
     */
    public static boolean esNumerico(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void soloTextoYNumeros(final JTextField COMPONENTE) {

        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                final char CARACTER = e.getKeyChar();
                if (!Character.isSpaceChar(CARACTER) && !Character.isLetter(CARACTER) && CARACTER != 'ñ' && (CARACTER < '0' || CARACTER > '9')) {
                    e.consume();
                    ControllerViewMsj.muestraMensajeGlobo("Solo se permiten letras en este campo.", COMPONENTE);
                }
            }
        });
    }

    public static void soloTextoYNumeros(final JTextArea COMPONENTE) {

        COMPONENTE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                final char CARACTER = e.getKeyChar();
                if (!Character.isSpaceChar(CARACTER) && !Character.isLetter(CARACTER) && CARACTER != ',' && CARACTER != ';' && CARACTER != ':' && CARACTER != '?' && CARACTER != '¿' && CARACTER != '.' && CARACTER != 'ñ' && (CARACTER < '0' || CARACTER > '9')) {
                    e.consume();
                    ControllerViewMsj.muestraMensajeGlobo("Solo se permiten letras en este campo.", COMPONENTE);
                }
            }
        });
    }

    static void validarFecha(JTextField fecha, Object object) {
         
    }
    
    //Area de texo
    public void placeHolder(boolean flag, JTextArea boxText, String text) {
        if (flag) {
            if (boxText.getText().equals(text)) {
                boxText.setForeground(new Color(0, 0, 0));
                boxText.setText("");
            }
        } else {
            if (boxText.getText().equals("")) {
                boxText.setForeground(new Color(180, 180, 180));
                boxText.setText(text);
            }
        }
    }

    public void placeHolder(boolean flag, JTextField boxText, String text) {
        if (flag) {
            if (boxText.getText().equals(text)) {
                boxText.setForeground(new Color(0, 0, 0));
                boxText.setText("");
            }
        } else {
            if (boxText.getText().equals("")) {
                boxText.setForeground(new Color(180, 180, 180));
                boxText.setText(text);
            }
        }
    }
    
    public void placeHolderPass(boolean flag, JPasswordField boxText, String text) {
        if (flag) {
            if (crearPass(boxText).equals(text)) {
                boxText.setForeground(new Color(0, 0, 0));
                boxText.setText("");
            }
        } else {
            if (crearPass(boxText).equals("")) {
                boxText.setForeground(new Color(180, 180, 180));
                boxText.setText(text);
            }
        }
    }
    
    private String crearPass(JPasswordField pass) {
        String pas = "";
        char[] car = pass.getPassword();
        for (int i = 0; i < car.length; i++)
           pas = pas + car[i];
        return pas;
    }
}
