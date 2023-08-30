/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priyectorectangulo;

/**
 *
 * @author Jairo F
 */
public class Rectangulo {
    
    private double base;
    private double altura;
    
    
    public Rectangulo(){
        this.altura=0;
        this.base=0;
    
    }
    
    
    public double getBase(){
        return this.base;
    }
    
    public double getAltura(){
        return this.altura;
    }
    
    
    public void setBase(double b){
        this.base=b;
    }
    
    public void setAltura(double a){
        this.altura=a;
    }
    
    public double calcularArea(){
    
        return this.altura*this.base;
    }
    
}
