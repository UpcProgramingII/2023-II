/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.Logic;

/**
 *
 * @author Jairo F
 */
public class SingletonListProduct {
    private static ListProduct model;
    
    public static ListProduct getInstance(){
        if(model==null){
            model = new ListProduct();
            return model;
        }
        else{
            return model;
        }
    }
}
