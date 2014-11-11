/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.util.Calendar;

/**
 *
 * @author jesus
 */
public class ControllerDatePanel 
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
}
