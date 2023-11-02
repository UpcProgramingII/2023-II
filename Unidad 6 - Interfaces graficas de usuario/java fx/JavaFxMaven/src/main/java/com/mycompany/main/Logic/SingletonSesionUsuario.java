package com.mycompany.main.Logic;

import com.mycompany.main.model.User;

/**
 *
 * @author Jairo F
 */
public class SingletonSesionUsuario {
    private static User usuarioActivo;

    public static void setUsuarioActivo(User user){
        usuarioActivo = user;
    }
    
    public static User getUsuarioActivo(){
        return usuarioActivo ;
    }
    
}
