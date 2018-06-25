/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.logic;

import com.example.calculator.basic.*;
import java.util.Scanner;

public class ExtendedTriangleCalculator extends TriangleCalculator implements ExtendedCalculator {
    
    @Override
     public void calculateArea() throws Exception {
        System.out.println("Podaj dlugosci bokow: ");
        Scanner scanner = new Scanner(System.in);
        double a=0;
        double b=0;
        double c=0;
        
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        
        if(a<0||b<0||c<0) throw new Exception();
        
        System.out.println("Obwod wynosi: " + (a+b+c));
    }
}
