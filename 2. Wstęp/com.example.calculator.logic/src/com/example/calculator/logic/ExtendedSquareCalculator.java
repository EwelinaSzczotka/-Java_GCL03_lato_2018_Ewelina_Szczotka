/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.logic;

import com.example.calculator.basic.*;
import java.util.Scanner;

public class ExtendedSquareCalculator extends SquareCalculator implements ExtendedCalculator{
    
    @Override
     public void calculateArea() throws Exception {
        System.out.println("Podaj dlugosc boku: ");
        Scanner scanner = new Scanner(System.in);
        double a=0;
        
        a = scanner.nextDouble();
        
        if(a<0) throw new Exception();
        System.out.println("Obwod wynosi: " + (4*a));
    }
     
}
