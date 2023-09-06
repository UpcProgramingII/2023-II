/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplovector3d;

/**
 *
 * @author Jairo F
 */
public class Vector3d {
    
    private double x;
    private double y;
    private double z;
    
    public Vector3d(){
        this(0,0,0);
    
    }
    
    public Vector3d(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }
    
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public void setZ(double z){
        this.z=z;
    }
    
    public String getVector(){
    
        //StringBuilder cad = new StringBuilder();
        return "("+this.x+", "+this.y+", "+this.z+")";
        
    }
    
    public Vector3d sumaVector(double x, double y, double z){
        
        Vector3d resultado = new Vector3d();
        resultado.setX(this.x+x);
        resultado.setY(this.y + y);
        resultado.setZ(this.z+z);
        return resultado;
        
    }
    
    public Vector3d sumaVector(Vector3d v){
        return this.sumaVector(v.getX(), v.getY(), v.getZ());
    }
    
    public double moduloVector(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
    
    public Vector3d scalarMultiplication(double n){
        Vector3d resultado = new Vector3d(n*this.x, n*this.y, n*this.z);
        return resultado;
    }
    
    
}
