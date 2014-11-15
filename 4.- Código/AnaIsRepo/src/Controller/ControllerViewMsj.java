package Controller;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.ModernBalloonStyle;
import net.java.balloontip.utils.FadingUtils;
import net.java.balloontip.utils.TimingUtils;
/**
 * Mensajes.java
 *
 */
public class ControllerViewMsj {

    /**
     * Mostrar mensaje de error generico o personalizado.
     *
     * @param tipo El tipo de error que se genera.
     * @param origen El nombre de la clase donde se genera el error.
     * @param linea La linea especifica donde el error se genera.
     * @param mensaje El mensaje que se mostrara en el dialogo.
     */
    public static void error(String tipo, String origen, int linea, String mensaje) {

        JOptionPane.showMessageDialog(null,
                "Tipo de error: " + tipo
                + "\nOrigen: " + origen
                + "\nLinea: " + linea
                + "\nMensaje: " + mensaje,
                "Error!", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mostrar mensaje de error causado por una excepcion.
     *
     * @param className El nombre de la clase donde se genera la excepcion.
     * @param ex La excepcion.
     * @param titulo El titulo del mensaje (default = null).
     * @param descripcionAdicional Descripcion adicional del error (default =
     * null).
     */
    public static void errorExcepcion(String className, Exception ex, String titulo, String descripcionAdicional) {
        StackTraceElement[] trace = ex.getStackTrace();
        String tipo = "desconocido";
        String mensaje = "desconocido";
        String clase = "desconocido";
        String metodo = "desconocido";
        String tituloMensaje;
        String descripcion;
        int linea = 0;
        for (StackTraceElement trace1 : trace) {
            if (trace1.getClassName() == null ? className == null : trace1.getClassName().equals(className)) {
                tipo = ex.toString().split(": ")[0];
                mensaje = ex.getLocalizedMessage();
                clase = trace1.getClassName();
                metodo = trace1.getMethodName();
                linea = trace1.getLineNumber();
                break;
            }
        }
        if (null == titulo) {
            tituloMensaje = "Error";
        } else {
            tituloMensaje = titulo;
        }
        if (descripcionAdicional == null) {
            descripcion = "N/A";
        } else {
            descripcion = descripcionAdicional;
        }
        //Logs.log.error(clase + ":" + metodo + "[" + linea + "]: " + tipo + ": <'" + mensaje + "'> Descripcion adicional: " + descripcionAdicional);

        JOptionPane.showMessageDialog(null,
                "Tipo: " + tipo
                + "\nMensaje: " + mensaje
                + "\nClase: " + clase
                + "\nMetodo: " + metodo
                + "\nLinea: " + linea
                + "\nDescripcion adicional: " + descripcion, tituloMensaje, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mostrar mensaje de inormacion.
     *
     * @param mensaje El mensaje a mostrar.
     * @param titulo El titulo del mensaje (default = "").
     */
    public static void informacion(String mensaje, String titulo) {
        if ("".equals(titulo)) {
            titulo = "Información.";
        }
//        Logs.log.info(titulo + ":" + mensaje);
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mostrar mensaje de pregunta.
     *
     * @param mensaje La pregunta a mostrar.
     * @param opciones Arreglo de opciones.
     * @return Entero que representa la pocision del arreglo de opciones que se
     * escogio.
     */
    public static int pregunta(String mensaje, String[] opciones, Object frame) {

        int respuesta = JOptionPane.showOptionDialog((Component) frame, mensaje, "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[opciones.length - 1]);
        return respuesta;
    }

    /**
     * Mostrar mensaje de aviso.
     *
     * @param comp
     * @param mensaje El mensaje a mostrar.
     * @param titulo El titulo del mensaje.
     */
    public static void aviso(Component comp, String mensaje, String titulo) {

//        Logs.log.warn(titulo + ":" + mensaje);
        JOptionPane.showMessageDialog(comp, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Mostrar mensaje plano.
     *
     * @param mensaje El mensaje a mostrar.
     * @param titulo El titulo del mensaje.
     */
    public static void plano(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Mostrar un mensaje de globo tipo notificacion en un componente
     * especifico.
     *
     * @param mensaje El mensaje a mostrar.
     * @param componente El componente donde se adjuntara el mensaje.
     */
    public static void muestraMensajeGlobo(String mensaje, JComponent componente) {
        ModernBalloonStyle style = new ModernBalloonStyle(5, 5, Color.WHITE, Color.LIGHT_GRAY, new Color(115,164,209));
        style.setBorderThickness(3);
        style.enableAntiAliasing(true);
        BalloonTip bt = new BalloonTip(componente, mensaje, style, false);
        bt.setVisible(true);
        FadingUtils.fadeInBalloon(bt, null, 300, 24);
        TimingUtils.showTimedBalloon(bt, 1500);
    }
}
