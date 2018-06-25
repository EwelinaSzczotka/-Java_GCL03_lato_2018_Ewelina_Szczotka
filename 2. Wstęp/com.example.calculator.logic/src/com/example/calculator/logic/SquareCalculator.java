/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;
import java.util.Scanner;

public class SquareCalculator implements Calculator {
    
    @Override
    public double calculatePerimeter(){
        double a;
        System.out.print("Podaj dlugosc boku: ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextDouble();
        return a*a;
    }
}
