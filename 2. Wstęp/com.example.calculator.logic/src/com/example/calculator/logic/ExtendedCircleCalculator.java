/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.logic;

import com.example.calculator.basic.*;
import java.util.Scanner;

public class ExtendedCircleCalculator extends CircleCalculator implements ExtendedCalculator{
    
    public void calculateArea() throws Exception {
        System.out.println("Podaj promień: ");
        Scanner scanner = new Scanner(System.in);
        double p=0;
      
        p = scanner.nextDouble();
        
        if(p<0) throw new Exception();
        System.out.println("Obwod wynosi: " + (2  * Math.PI * p));
    }
}
