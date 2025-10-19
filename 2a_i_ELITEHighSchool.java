/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elitehighschool;

/**
 *
 * @author Mukisa
 */
import java.util.Scanner;
//==============Question 2 (a)====================
public class ELITEHighSchool {
//=================For Loop===============
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter principal amount: ");
        double principal = input.nextDouble();
        
        System.out.print("Enter time in years: ");
        int time = input.nextInt();
        
        double rate = 0.05; 
        double amount = principal;
        
        // Calculate using for loop
        for (int year = 1; year <= time; year++) {
            amount = amount + (amount * rate);
        }
        
        System.out.println("Principal: " + principal);
        System.out.println("Time: " + time + " years");
        System.out.println("Rate: 5%");
        System.out.println("Final Amount: " + amount);
        
        
    }
}
