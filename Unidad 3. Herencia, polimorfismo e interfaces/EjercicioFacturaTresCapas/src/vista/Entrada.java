/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
public class Entrada {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static int leerInt(String label){
        
        System.out.printf("> %-20s:", label);
        return scanner.nextInt();
    }
    
    public static int leerInt(String label, char prompt){
        
        System.out.printf("%s %-20s:",prompt, label);
        return scanner.nextInt();
    }
    
    public static double leerDouble(String label){
        
        System.out.printf("> %-20s:", label);
        return scanner.nextDouble();
        
    }
    
    public static String leerString(String label){
        System.out.printf("> %-20s:", label);
        return scanner.next();
    }
    
    public static char leerChar(String label){
        System.out.printf("> %-20s:", label);
        return scanner.next().toUpperCase().charAt(0);
    }
    
    public static String leerLinea(String label){
        
        System.out.printf("> %-20s:", label);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
        
    }
    
    public static LocalDate leerFecha(String label){
        System.out.printf("> %-20s:\n", label);
        
        int anio = leerInt("Año(aaaa)",'#');
        int mes = leerInt("Mes(1-12)",'#');
        int dia = leerInt("Dia(1-31)",'#');
        
        return LocalDate.of(anio, mes, dia);
    }
    
}
