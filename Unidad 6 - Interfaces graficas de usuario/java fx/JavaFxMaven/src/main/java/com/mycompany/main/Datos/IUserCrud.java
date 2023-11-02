package com.mycompany.main.Datos;

import com.mycompany.main.model.*;
import java.util.List;

public interface IUserCrud {
    
    void insert(User user);
    User getUser(String userName);
    List<User> getListUsers();
}
