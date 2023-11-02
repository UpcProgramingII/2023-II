package com.mycompany.main.Logic;

import com.mycompany.main.Datos.IUserCrud;
import com.mycompany.main.Datos.UserDao;
import com.mycompany.main.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class ListUser{
    
    private IUserCrud dataUser;

    public ListUser() {
        this.dataUser = new UserDao();
        User a= new User("Admin", "Root", "Jairo", "Seoanes", true);
        User b= new User("user", "user", "Jairo", "Seoanes", false);
        this.insertUser(a);
        this.insertUser(b);

    }
    
    
    
    public void insertUser(User user) throws IllegalStateException,IllegalArgumentException{
        
        this.dataUser.insert(user);
    }
    
    public User getUser(String userName) throws IllegalArgumentException{
        return this.dataUser.getUser(userName);
    }
    public List<User> getListUsers(){
        List<User>users = new ArrayList(this.dataUser.getListUsers());
        return users;
    }
}
