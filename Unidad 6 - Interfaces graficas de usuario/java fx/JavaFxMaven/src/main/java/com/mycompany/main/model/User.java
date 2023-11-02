package com.mycompany.main.model;

public class User {
    private String nameUser;
    private String password;
    private String name;
    private String lstName;
    private boolean isAdmin;
    

    public User(String nameUser, String password, String name, String lstName, boolean admin) {
        this.nameUser = nameUser;
        this.password = password;
        this.name = name;
        this.lstName = lstName;
        this.isAdmin=admin;
    }

    /**
     * @return the nameUser
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * @param nameUser the nameUser to set
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lstName
     */
    public String getLstName() {
        return lstName;
    }

    /**
     * @param lstName the lstName to set
     */
    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
}
