/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author jesus
 */
public class ControllerFechas 
{
    
private static final Calendar date = Calendar.getInstance();
private static String fecha;
private static String hora;

static 
{
    setFecha 
            (
                obtenerDia(date.get(Calendar.DAY_OF_WEEK))+", "+
                verNum(date.get(Calendar.DATE))+" de "+
                obtenerMes(date.get(Calendar.MONTH))+" de " +date.get(Calendar.YEAR)
            );
    setHora 
            (
                verNum(date.get(Calendar.HOUR_OF_DAY))+":"+
                verNum(date.get(Calendar.MINUTE))+":"+
                verNum(date.get(Calendar.SECOND))+" "+
                obtenerMeridiano(date.get(Calendar.AM_PM))
            );
}

private static String verNum(int val)
{
    String temp = Integer.toString(val);
    if(temp.length() == 1)
        temp = "0" + temp;
    return temp;
}
private static String obtenerDia(int dd)
{
    String dia="";
    switch (dd)
    {
        case 1: dia = "Domingo";break;
        case 2: dia = "Lunes";break;
        case 3: dia = "Martes";break;
        case 4: dia = "Miércoles";break;
        case 5: dia = "Jueves";break;
        case 6: dia = "Viernes";break;
        case 7: dia = "Sábado";break;
    }
    return dia;
}
private static String obtenerMes(int mm)
{
    String dia="";
    switch (mm)
    {
        case 0: dia = "Enero";break;
        case 1: dia = "Febrero";break;
        case 2: dia = "Marzo";break;
        case 3: dia = "Abril";break;
        case 4: dia = "Mayo";break;
        case 5: dia = "Junio";break;
        case 6: dia = "Julio";break;
        case 7: dia = "Agosto";break;
        case 8: dia = "Septiembre";break;
        case 9: dia = "Octubre";break;
        case 10: dia = "Noviembre";break;
        case 11: dia = "Diciembre";break;
    }
    return dia;
}
private static String obtenerMeridiano(int mm)
{
    String dia="";
    switch (mm)
    {
        case 0: dia = "A.M.";break;
        case 1: dia = "P.M.";break;
    }
    return dia;
}
    /**
     * @return the fecha
     */
    public static String getFecha() 
    {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    private static void setFecha(String afecha) 
    {
        fecha = afecha;
    }

    /**
     * @return the hora
     */
   public static String getHora()
   {
        return hora;
    }

    /**
     * @param aHora the hora to set
     */
    private static void setHora(String aHora) 
    {
        hora = aHora;
    }
    
     public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
    public static String getFechaActualBD() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(ahora);
    }

    //Metodo usado para obtener la hora actual del sistema
    //@return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"
    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

    //Sumarle dias a una fecha determinada
    //@param fch La fecha para sumarle los dias
    //@param dias Numero de dias a agregar
    //@return La fecha agregando los dias
    public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Restarle dias a una fecha determinada
    //@param fch La fecha
    //@param dias Dias a restar
    //@return La fecha restando los dias
    public static synchronized java.sql.Date restarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
