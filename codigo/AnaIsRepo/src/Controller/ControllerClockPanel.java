package Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author Jesus Salazar
 */
public class ControllerClockPanel implements Runnable {

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    JLabel S;
   
    /**
     *
     * @param S
     */
    public ControllerClockPanel(JLabel S) 
    {
        this.S = S;
    }

    /**
     *
     */
    public void calcula() {
        Calendar calendar = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendar.setTime(fechaHoraActual);
        ampm = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendar.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
            if (Integer.parseInt(hora) == 0) {
                hora = ("12");
            }
        } else {
            hora = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY) : "0" + calendar.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND) : "0" + calendar.get(Calendar.SECOND);
    }

    @Override
    public void run() {
        while(true){
            calcula();
            S.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
    }
    }



}
