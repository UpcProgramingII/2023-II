/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.logica;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Usuario;

/**
 *
 * @author Jairo F
 */
public class Login {
    
    private static Usuario usuario= new Usuario();
    private static Usuario usuarioLogeado;
    
    public static void validarLogin(String username, String password) throws Exception{
        
        
        if(username.isEmpty()){
            throw new IllegalStateException("El username no puede ser vacio");
        }
        
        if(password.isEmpty()){
            throw new IllegalStateException("El password no puede ser vacio");
        }
        
        if(!usuario.getUsername().equals(username)){
            throw new Exception("El usuario registrado no es correcto");
        }
        
        if(!usuario.getPassword().equals(password)){
            throw new Exception("El PASSWORD registrado no es correcto");
        }
        
        usuarioLogeado = usuario;
       
        
    }
    
    public static void setUsuarioLogeado(Usuario usuario){
        usuarioLogeado=usuario;
    }
    
    public static Usuario getUsuarioLogeado(){
        return usuarioLogeado;
    }
    
}
