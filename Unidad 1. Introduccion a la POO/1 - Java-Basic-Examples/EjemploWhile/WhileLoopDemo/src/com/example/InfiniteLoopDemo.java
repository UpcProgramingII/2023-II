package com.example;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class InfiniteLoopDemo {
 

    public static void main(String[] args) {

        int count = 1;
        while (count <= 25) {
            System.out.println(count);
            count = count - 1;
        }

    }

}

    

