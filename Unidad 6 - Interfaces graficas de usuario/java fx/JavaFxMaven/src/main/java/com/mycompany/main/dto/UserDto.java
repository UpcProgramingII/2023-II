package com.mycompany.main.dto;

import com.mycompany.main.model.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jairo F
 */
public class UserDto {
    private SimpleStringProperty nameUser;
    private SimpleStringProperty password;
    private SimpleStringProperty name;
    private SimpleStringProperty lstName;
    private SimpleBooleanProperty isAdmin;

    public UserDto(User user) {
        this.name=new SimpleStringProperty(user.getName());
        this.lstName=new SimpleStringProperty(user.getLstName());
        this.nameUser=new SimpleStringProperty(user.getNameUser());
        this.password=new SimpleStringProperty(user.getPassword());
        this.isAdmin=new SimpleBooleanProperty(user.isIsAdmin());
    }

    /**
     * @return the nameUser
     */
    public String getNameUser() {
        return this.nameUser.getValue();
    }

    /**
     * @param nameUser the nameUser to set
     */
    public void setNameUser(String nameUser) {
        this.nameUser.set(nameUser);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password.getValue();
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password.set(password);
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name.getValue();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name.setValue(name);
    }

    /**
     * @return the lstName
     */
    public String getLstName() {
        return lstName.getValue();
    }

    /**
     * @param lstName the lstName to set
     */
    public void setLstName(String lstName) {
        this.lstName.setValue(lstName);
    }

    /**
     * @return the isAdmin
     */
    public Boolean getIsAdmin() {
        return isAdmin.getValue();
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin.setValue(isAdmin);
    }
    
    
}
