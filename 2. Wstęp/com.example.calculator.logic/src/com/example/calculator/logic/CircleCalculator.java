/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.logic;

import com.example.calculator.basic.*;
import java.util.Scanner;

public class CircleCalculator implements Calculator {
    
    @Override
    public double calculatePerimeter(){
        double p;
        System.out.print("Podaj promien: ");
        Scanner scanner = new Scanner(System.in);
        p = scanner.nextDouble();
        return (p*Math.PI)/2;
    }
}
