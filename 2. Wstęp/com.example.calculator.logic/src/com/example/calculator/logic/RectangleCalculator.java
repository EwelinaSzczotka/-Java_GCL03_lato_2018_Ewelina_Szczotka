/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;
import java.util.Scanner;

public class RectangleCalculator implements Calculator {
    
    @Override
    public double calculatePerimeter(){
        double a,b;
        System.out.print("Podaj dlugosc bokow: ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        return a*b;
    }
    
}
