package com.mycompany.main.Datos;

import com.mycompany.main.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class UserDao implements IUserCrud {
    private List<User> dbUsers;

    public UserDao() {
        this.dbUsers = new ArrayList();
       
    }

    @Override
    public void insert(User user) throws IllegalStateException,IllegalArgumentException {
        
        if(user==null)
            throw new IllegalArgumentException("No se puede registrar un Usuario NULL");
        
        if(user.getName().isBlank())
            throw new IllegalArgumentException("El primer nombre del usuario no puede ser NULL");
        
        if(user.getLstName().isBlank())
            throw new IllegalArgumentException("El segundo nombre del usuario no puede ser NULL");
        
        if(user.getNameUser().isBlank())
            throw new IllegalArgumentException("El NAMEUSER no puede ser NULL");
        
        if(user.getPassword().isBlank())
            throw new IllegalArgumentException("El PASSWORD no puede ser NULL");
        
        for(User u:this.dbUsers){
            if(u.getNameUser().equals(user.getNameUser())){
                throw new IllegalStateException("El usuario "+user.getNameUser()+ " No esta disponible");
            }
        }
        
        this.dbUsers.add(user);
    }

    @Override
    public User getUser(String userName)throws IllegalArgumentException {
        User user=null;
        for(User u:this.dbUsers){
            if(u.getNameUser().equals(userName)){
                user = u;
                break;
            }
        }
        
        if(user==null)
            throw new IllegalArgumentException("El usuario " + userName + " no se encuentra registrado");

        return user;
    }

    @Override
    public List<User> getListUsers() {
        return this.dbUsers;
    }
    
    
    
}
