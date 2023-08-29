/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciohoramilitar;

/**
 *
 * @author Jairo F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int horas = 12;
        int minutos = 59;

        System.out.printf("Hora Militar [%d:%d]%n", horas, minutos);
        System.out.printf("Hora Formato AM/PM [%d:%d %s]%n", horaFormato12(horas), minutos, obtenerAmPm(horas));

    }

    public static int horaFormato12(int hora) {

        int hora_am_pm;
        String ampm;

        if (hora > 12) {
            hora_am_pm = hora - 12;
        } else {
            if (hora == 0) {
                hora_am_pm = 12;
            } else {
                hora_am_pm = hora;
            }
        }

        return hora_am_pm;
    }
    
    public static String obtenerAmPm(int hora){
        String ampm;
        if (hora >= 12){
            ampm="pm";
        }
        else{
            ampm="am";
        }
        return ampm;
    }

}
