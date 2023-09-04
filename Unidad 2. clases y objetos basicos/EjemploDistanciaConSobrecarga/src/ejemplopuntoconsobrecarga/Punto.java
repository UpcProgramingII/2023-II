/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplopuntoconsobrecarga;

/**
 *
 * @author Jairo F
 */
public class Punto {
    
    private double x;
    private double y;
    
    public Punto(){
        
       this(0,0);
        
    }
    
    public Punto(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
    
        return this.y;
        
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
       
        this.y = y;
        
    }
    
    public double calcularDistancia(Punto p){
    
        double dx = this.x - p.getX();
        double dy = this.y - p.getY();
        
        double d = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return d;
        
    }
    
    public double calcularDistancia(double x, double y){
    
        Punto p = new Punto(x,y);
        double d = this.calcularDistancia(p);
        return d;
    
    }
    
}
