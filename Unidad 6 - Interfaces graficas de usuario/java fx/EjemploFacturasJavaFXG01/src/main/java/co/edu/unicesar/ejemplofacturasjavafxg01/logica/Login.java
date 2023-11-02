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
    
    public static void validarLogin(String username, String password){
            
        if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password)){
            usuarioLogeado = usuario;
        }
        else{
            usuarioLogeado = null;
        }
        
    }
    
    public static void setUsuarioLogeado(Usuario usuario){
        usuarioLogeado=usuario;
    }
    
    public static Usuario getUsuarioLogeado(){
        return usuarioLogeado;
    }
    
}
