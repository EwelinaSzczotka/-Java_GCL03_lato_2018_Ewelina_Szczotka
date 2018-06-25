/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.ui;

import com.example.calculator.basic.*;
import com.example.calculator.logic.*;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int w;
        boolean done = false;
        
        while(!done){
        System.out.print("Wybierz figure:\n"
                + "1: kwadrat\n"
                + "2: prostokat\n"
                + "3: kolo\n"
                + "4: trojkat\n"
                + "5: wyjscie\n");
        w = scanner.nextInt();
        try{
        switch(w){
            case 1:
                ExtendedSquareCalculator calculator = new ExtendedSquareCalculator();
                System.out.println("Pole kwadratu wynosi: "+calculator.calculatePerimeter());
                calculator.calculateArea();
                break;
            case 2:
                ExtendedCalculator calculator2 = new ExtendedRectangleCalculator();
                System.out.println("Pole kwadratu wynosi: "+calculator2.calculatePerimeter());
                calculator2.calculateArea();
                break;
            case 3:
                ExtendedCalculator calculator3 = new ExtendedCircleCalculator();
                System.out.println("Pole kwadratu wynosi: "+calculator3.calculatePerimeter());
                calculator3.calculateArea();
                break;
            case 4:
                ExtendedCalculator calculator4 = new ExtendedTriangleCalculator();
                System.out.println("Pole kwadratu wynosi: "+calculator4.calculatePerimeter());
                calculator4.calculateArea();
                break;
            case 5:
                done = true;
                break;
            }
        }
        catch(Exception e){
            System.out.print("Nieprawidlowe dane.");
        }
        }
        
    }
    
}
