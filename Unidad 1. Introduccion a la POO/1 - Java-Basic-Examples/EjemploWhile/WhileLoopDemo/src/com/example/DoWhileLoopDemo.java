package com.example;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class DoWhileLoopDemo {

    public static void main(String[] args) {

        int num = 1;
        do {
            System.out.print(num + " ");
            num = num * 2;
        } while (num <= 200);
    }
}
